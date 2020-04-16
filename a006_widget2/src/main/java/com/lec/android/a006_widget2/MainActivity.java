package com.lec.android.a006_widget2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1, pb2, pb3;
    TextView tvTitle;

    int value = 0; // 막대 progressBar 현재 진행값
    int add = 10; // 증가량

    int value2 = 0;
    int add2 = 1;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb1);
        pb2 = findViewById(R.id.pb2);
        pb3 = findViewById(R.id.pb3);

        ToggleButton btn1 = findViewById(R.id.toggleButton);
        Button btn2 = findViewById(R.id.button1);

        // 토글버튼 상태 변화시 호출되는 콜백
        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pb1.setVisibility(View.INVISIBLE);
                } else{
                    pb1.setVisibility(View.VISIBLE);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = value + add;
                if(value > 100 || value < 0) {
                    value = -add;
                }
                pb2.setProgress(value); // 프로그레스바의 진행값 설정
            }
        });

        // 앱 시작시 Thread를 사용하여 progressbar 증가 시키기
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                    value2 = value2 + add2;

                    if(value2 > 100 || value2 < 0){
                        add2 = -add2;
                    }

                    // 별도의 작업 Thread 에서
                    // 메인 UI 접근하려면 Handler 사용
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb3.setProgress(value2);
                        }
                    });

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    } // onCreate
}
