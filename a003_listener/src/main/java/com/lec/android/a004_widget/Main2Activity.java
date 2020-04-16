package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button divide, multiply, difference, sum, equal, clear;
    EditText et;
    TextView answer;
    List<Integer> list = new ArrayList<Integer>();
    int number1, number2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num0 = findViewById(R.id.num0);        num1 = findViewById(R.id.num1);        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);        num4 = findViewById(R.id.num4);        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);        num7 = findViewById(R.id.num7);        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);

        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        difference = findViewById(R.id.difference);
        sum = findViewById(R.id.sum);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);

        et = findViewById(R.id.et);
        et.setInputType(0x00000000);

        answer = findViewById(R.id.answer);

        class Numberbtn implements View.OnClickListener{
            String n;
            public Numberbtn(String num){ this.n = num;}

            @Override
            public void onClick(View v) {
                if(et.getText().length() < 15) {
                    et.setText(et.getText().append(n));
                } else{
                    Toast.makeText(Main2Activity.this, "숫자는 15개 이하로 적어주세요", Toast.LENGTH_SHORT).show();
                    et.setText(et.getText());
                }
            }
        } // Numberbtn


        num0.setOnClickListener(new Numberbtn("0"));
        num1.setOnClickListener(new Numberbtn("1"));
        num2.setOnClickListener(new Numberbtn("2"));
        num3.setOnClickListener(new Numberbtn("3"));
        num4.setOnClickListener(new Numberbtn("4"));
        num5.setOnClickListener(new Numberbtn("5"));
        num6.setOnClickListener(new Numberbtn("6"));
        num7.setOnClickListener(new Numberbtn("7"));
        num8.setOnClickListener(new Numberbtn("8"));
        num9.setOnClickListener(new Numberbtn("9"));
        divide.setOnClickListener(new Numberbtn("÷"));

//        class Symbolbtn implements View.OnClickListener{
//            String sym;
//            public Symbolbtn(String symbol){ this.sym = symbol;}
//
//            @Override
//            public void onClick(View v) {
//                answer.setText(et.getText().append(sym));
//            }
//
//        } // Symbolbtn
//
//        divide.setOnClickListener(new Symbolbtn("÷"));
//        multiply.setOnClickListener(new Symbolbtn("×"));
//        difference.setOnClickListener(new Symbolbtn("－"));
//        sum.setOnClickListener(new Symbolbtn("+"));

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().append("÷"));
                String[] num = (et.getText().toString().split("÷"));
                for(int i = 0; i < num.length; i++){
                    result = 0;
                    result /= Integer.parseInt(num[i]);
                }
            }
        });

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText().append("＋"));
                String[] num = (et.getText().toString().split("＋"));
                for(int i = 0; i < num.length; i++){
                    result = 0;
                    result += Integer.parseInt(num[i]);
                }
            }
        });

        difference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] num = (et.getText().toString().split("-"));
                for(int i = 0; i < num.length; i++){
                    result = 0;
                    result -= Integer.parseInt(num[i]);
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] num = (et.getText().toString().split("×"));
                for(int i = 0; i < num.length; i++){
                    result = 0;
                    result *= Integer.parseInt(num[i]);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("d", String.valueOf(result));
                String result1 = String.format("%d", result);
                answer.setText(result1 + "");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
                answer.setText("");
            }
        });




    } // onCreate()

    public void operation(View v){
        String[] num;
        int result = 0;
        switch (v.getId()){
            case R.id.equal:
                answer.setText(result);
                break;

            case R.id.divide:
                num = (et.getText().toString().split("÷"));
                for(int i = 0; i < num.length; i++){
                    result = 0;
                    result /= Integer.parseInt(num[i]);
                }
                break;

            case R.id.difference:
                num = (et.getText().toString().split("-"));
                for(int i = 0; i < num.length; i++){
                    result = 0;
                    result -= Integer.parseInt(num[i]);
                }
                break;

            case R.id.sum:
                num = (et.getText().toString().split("＋"));
                for(int i = 0; i < num.length; i++){
                    result += Integer.parseInt(num[i]);
                }
                break;

            case R.id.multiply:
                num = (et.getText().toString().split("×"));
                for(int i = 0; i < num.length; i++){
                    result = 0;
                    result *= Integer.parseInt(num[i]);
                }
                break;

            case R.id.clear:
                et.setText("");
                answer.setText("");
                break;

        }
    }

}
