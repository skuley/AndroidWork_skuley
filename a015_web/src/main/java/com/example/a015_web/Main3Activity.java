package com.example.a015_web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Main3Activity extends AppCompatActivity {

     Handler handler = new Handler();

    Button btnXML, btnJSON, btnParse;
    TextView tvResult;

    String urlXml = "http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울";
    String urlJson = "   http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnXML = findViewById(R.id.btnXML);
        btnJSON = findViewById(R.id.btnJSON);
        btnParse = findViewById(R.id.btnParse);

        tvResult = findViewById(R.id.tvResult);

        btnXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       readFromUrl(urlXml);
                   }
               }).start();
                }
        });

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            readFromUrl(urlJson);
                        }
                    }).start();
            }
        });

        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String text = tvResult.getText().toString();
                        parseXML(text);
                        try {
                            parseJSON(text);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });


    } // onCreate()

    public void readFromUrl(String urlAddress){
        final StringBuffer sb = new StringBuffer();

        URL url = null;
        HttpURLConnection conn = null;
        InputStream in = null;
        InputStreamReader reader = null;
        BufferedReader br = null;

        final char[] buf = new char[512];

        try {
            url = new URL(urlAddress);
            conn = (HttpURLConnection) url.openConnection();

            if (conn != null) {
                conn.setConnectTimeout(2000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                conn.setUseCaches(false);

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) { // 200 HTTP_OK
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = null;
                    while (true) {
                        line = br.readLine();
                        if (line == null) break;
                        sb.append(line + "\n");
                    } // while
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if (br != null) br.close();
                if (conn != null) conn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                tvResult.setText("응답결과 : " + sb.toString());
            }
        });

    }


    public void parseXML(String xmlText) {

        // TODO
        // XML 파싱을 시작하지
        DocumentBuilderFactory dbF;
        DocumentBuilder dB;

        try {
            dbF = DocumentBuilderFactory.newInstance();
            dB = dbF.newDocumentBuilder();

            InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));
            Document dom = dB.parse(in);
            Element docElement = dom.getDocumentElement();
            docElement.normalize();

            NodeList nList = docElement.getElementsByTagName("row");
            System.out.println("<row> 개수 : " + nList.getLength());

            for(int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                // element node 인 경우만 파싱 진행
                if(node.getNodeType() != Node.ELEMENT_NODE) continue;

                Element rowElement = (Element)node;

                String statnNm = rowElement.getElementsByTagName("statnNm").item(0).getChildNodes().item(0).getNodeValue().trim();
                String subwayId = rowElement.getElementsByTagName("subwayId").item(0).getChildNodes().item(0).getNodeValue().trim();
                String subwayNm = rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0).getNodeValue().trim();

                System.out.printf("%d: %s역 %s %s\n", i + 1, statnNm, subwayId, subwayNm);

            } // for



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    } // end parseXML()

    public void parseJSON(String jsonText) throws JSONException {

        // TODO
        JSONObject jObj = new JSONObject(jsonText);
        JSONArray row = jObj.getJSONArray("stationList");

        for(int i = 0; i < row.length(); i++) {
            JSONObject jObj2 = row.getJSONObject(i);

            String statnNm = jObj2.getString("statnNm");
            String subwayId = jObj2.getString("subwayId");
            String subwayNm = jObj2.getString("subwayNm");

            handler.post(new Runnable() {
                @Override
                public void run() {
                    tvResult.setText();
                }
            });

            System.out.printf("%d: %s역 %s %s\n", i + 1, statnNm, subwayId, subwayNm);
        }

    } // parseJSON


} // Main3Activity
