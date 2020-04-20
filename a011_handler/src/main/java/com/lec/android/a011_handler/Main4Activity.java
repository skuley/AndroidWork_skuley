package com.lec.android.a011_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

// TODO
// value1
// 1 ~ 10 까지 1초 단위로 증가시키기
// 10초 도달하면 멈춰서 Toast 띄우기
// Message 사용

// value2
// 1 ~ 20 까지 1초 단위로 증가시키기
// 10초에 도달하면 멈춰서 Toast 띄우기
// Handler 사용
public class Main4Activity extends AppCompatActivity {

    TextView tvResult1, tvResult2, tvResult3, tvResult4, tvResult5;
    int value1, value2, value3, value4, value5;
    Handler mhandler2, mhandler3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);
        tvResult4 = findViewById(R.id.tvResult4);
        tvResult5 = findViewById(R.id.tvResult5);


        // 방법3:
        mhandler3 = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                value3++;
                tvResult3.setText("Value3 : " + value3);
                if(value3 < 5){
                    mhandler3.sendEmptyMessageDelayed(0, 100);
                } else{
                    Toast.makeText(getApplicationContext(), "Value3 종료", Toast.LENGTH_SHORT).show();
                }
            }
        };
        mhandler3.sendEmptyMessage(0);

        // 방법 #4
        // 핸들러를 사용하지 않고도 일정시간마다 (혹은 후에) 코스를 수행할수 있도록
        // CountDownTimer 클래스가 제공된다.
        // '총시간'  과 '인터벌(간격)' 을 주면 매 간격마다 onTick 메소드를 수행한다.
        new CountDownTimer(15 * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                value4++;
                tvResult4.setText("Value4 : " + value4);
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Value4 종료", Toast.LENGTH_SHORT).show();
            }
        }.start(); // 타이머 시작
        
    } // onCreate()



    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            value1++;
            tvResult1.setText("Value1 : " + value1);

            if(value1 < 10){
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };



} // Main4Activity


