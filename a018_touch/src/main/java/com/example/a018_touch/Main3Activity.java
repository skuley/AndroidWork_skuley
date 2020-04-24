package com.example.a018_touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView tvResult;

    // 3개까지 의 멀티터치를 다루기 위한 배열
    int id[] = new int[3];
    int x[] = new int[3];
    int y[] = new int[3];

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvResult = findViewById(R.id.tvResult);



    } // onCreate()


    // Activity 에서 발생한 터치 이벤트 처리
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        // 현재 터치 발생한 포인트 개수를 얻어온다.
        int pointCount = event.getPointerCount(); // 현재 손가락이 몇개 터치 되었느냐
        if(pointCount > 3) pointCount = 3; // 4개 이상의 손가락이 감지되어도 3개까지만 처리하겠다.

        // TODO 이게 뭐지?
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN: // 한개의 포인트에 대한 DOWN 이 발생했을때
                // TODO
                break;

            case MotionEvent.ACTION_POINTER_DOWN: // 두개 이상의 포인트에 대한 DOWN이 발생했을때
                // TODO
                break;

            case MotionEvent.ACTION_MOVE:
                // TODO
                break;

            case MotionEvent.ACTION_UP:
                // TODO
                break;

        }



        return super.onTouchEvent(event);
    }
} // Main3Activity
