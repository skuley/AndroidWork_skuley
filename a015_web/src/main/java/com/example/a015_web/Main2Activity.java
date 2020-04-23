package com.example.a015_web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

// #1 WebView 사용하여 웹 페이지 보여주기
// #2 묵시적 Intent 사용하여 웹 브라우져 띄우기
public class Main2Activity extends AppCompatActivity {
    WebView wv;
    EditText etUrl;
    Button btnWebView, btnBrowser;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etUrl = findViewById(R.id.etUrl);
        wv = findViewById(R.id.wv);
        btnWebView = findViewById(R.id.btnWebView);
        btnBrowser = findViewById(R.id.btnBrowser);

        // WebView를 사용 할때 세팅할것
        wv.getSettings().setJavaScriptEnabled(true); // JavaScript 사용여부 : 디폴트 false;

        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = etUrl.getText().toString().trim();
                wv.loadUrl(url); // 읽어올 웹페이지 url 로 읽어오기
                wv.setWebChromeClient(new WebChromeClient()); // 안하면 (javascript에 있는 팝업창같은게 있는데) alert() 같은 알림창 안뜸.
                wv.setWebViewClient(new WebViewClient()); // 안하면 웹페이지 (html) 내부에서 다른 페이지로 이동 불가
            }
        });


    } // onCreate()

    // 키보드 눌렀을때 동작하는 이벤트
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()){
            wv.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
} // Main2Activity
