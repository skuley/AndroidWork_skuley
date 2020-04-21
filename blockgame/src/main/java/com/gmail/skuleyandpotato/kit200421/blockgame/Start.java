package com.gmail.skuleyandpotato.kit200421.blockgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Start extends AppCompatActivity implements View.OnClickListener {

    TextView tvTime; // 시간표시
    TextView tvPoint; // 점수표시

    int time = 30; // 시간값
    int point = 0; // 점수값

    // 블럭이미지 래소스 배열
    int[] img = {R.drawable.block_red, R.drawable.block_green, R.drawable.block_blue};

    // 떨어지는 블럭의 ImageView 배열 객체
    ImageView[] iv = new ImageView[8]; // iv[0] --> null

    private Vibrator vibrator; // 진동
    private SoundPool soundPool; // 음향

    private int soundID_OK; // 음향 id : 블럭 맞추었을때
    private int soundID_Error; // 음향 id : 블럭 못 맞추었을때

    private MediaPlayer mp; // 배경 음악

    // 다이얼로그 ID
    final int DIALOG_TIMEOVER = 1;

    Handler handler = new Handler(); // 시간,

    // 게임진행 쓰레드
    class GameThread extends Thread{
        @Override
        public void run() {
            // 시간은 1초마다 돌아가고 있다
            // Handler 사용하여 화면 UI 엡데이트
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // TODO
                }
            }, 1000); // 1초후에 시간표시

        } // run()

    } // GameThread


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 상태바 (status bar) 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.start);

        // 레이아웃 객체(뷰) 초기화
        tvTime = findViewById(R.id.tvTime);
        tvPoint = findViewById(R.id.tvPoint);

        ImageView ivRed = findViewById(R.id.ivRed);
        ImageView ivGreen = findViewById(R.id.ivGreen);
        ImageView ivBluee = findViewById(R.id.ivBlue);

        iv[0] = findViewById(R.id.ivBlock1);
        iv[1] = findViewById(R.id.ivBlock2);
        iv[2] = findViewById(R.id.ivBlock3);
        iv[3] = findViewById(R.id.ivBlock4);
        iv[4] = findViewById(R.id.ivBlock5);
        iv[5] = findViewById(R.id.ivBlock6);
        iv[6] = findViewById(R.id.ivBlock7);
        iv[7] = findViewById(R.id.ivBlock8);

        // 최초에 게임이 실행되면 8개의 블럭이 랜덤으로 나온다
        for(int i = 0; i < iv.length; i++){
            // 빨강 파랑 초록 중에서 나와야한다  // 0, 1, 2 <-- Red
            int num = new Random().nextInt(3); // 0, 1, 2 중에 랜던 정수
            iv[i].setImageResource(img[num]);
            iv[i].setTag(num + ""); // // 태그를 버튼의 색상 판단하기 위한 값으로 허용

        }

        // 점수 초기화
         point = 0;

        tvPoint.setText("점수 : " + point);

        // r, g, b 버튼의 이벤트 리스너 등록
        ivRed.setOnClickListener(this);
        ivGreen.setOnClickListener(this);
        ivBluee.setOnClickListener(this);

        // 시간표시, 게임진행 쓰레드 시작하기
        // TODO

    } // onCreate()

    @Override
    public void onClick(View v) {
        // TODO
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 자원획득
        // Vibrator 객체 얻어오기
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        // SoundPool 객체
        soundPool = new SoundPool.Builder().setMaxStreams(5).build();
        soundID_OK = soundPool.load(Start.this, R.raw.gun3, 1);
        soundID_Error = soundPool.load(Start.this, R.raw.error, 1);

        // MediaPool
        mp = MediaPlayer.create(getApplicationContext(), R.raw.bgm);
        mp.setLooping(false); // 반복은 안하겠따
        mp.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        // 자원해제
        if(mp != null){
            mp.stop();
            mp.release();
        }
    }
} // Start{}
