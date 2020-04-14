package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvResult;
    EditText et;


    // onCreate()
    // 액티비티 (화면 객체)가 생성될때 호출되는 메소드
    // 액티비티 초기화 하는 코드 작성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 파일에 있는 btn들을 가지고 온다
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        tvResult = findViewById(R.id.tvResult);
        et = findViewById(R.id.et);
        final LinearLayout header = findViewById(R.id.header);


        // 방법 2 : 익명 클래스(anonymous class) 사용
        btn2.setOnClickListener(new View.OnClickListener() {
            // 클릭 되었을때 호출되는 메소드 (콜백 메소드 callback method)
            @Override
            public void onClick(View v) {
                Log.d("myapp", "버튼2가 클릭되었습니다.");
                tvResult.setText("버튼2가 클릭됨");
                tvResult.setBackgroundColor(Color.YELLOW);
            }
        });

        // 다양한 이벤트, 다양한 리스터 등록 가능
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            // 롱 클릭 발생시 수행하는 콜백 메소드(callback method)
            @Override
            public boolean onLongClick(View v) {
                Log.d("myapp", "버튼2가 Long클릭 되었습니다.");
                tvResult.setText("버튼2가 Long클릭되었습니다");
                tvResult.setBackgroundColor(Color.CYAN);
                return false; // false 리턴하면 이벤트가 click까지 간다.
                // return true; true 리턴하면 이벤트가 Long click 으로 소멸(consume) 된다
            }
        });

        // 방법3 : Lambda - expression 사용하기
        // Android Studio 의 세팅 필요! (AndroidStudio Java8 ppt 참조)
        btn3.setOnClickListener((v) -> {
            Log.d("myapp", "버튼3가 클릭 되었다");
            tvResult.setText("버튼3 클릭됨");
            header.setBackgroundColor(Color.rgb(164, 198, 57));
        });

        // 방법 4 : implement 한 클래스 사용
        // TODO
        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        Button btnE = findViewById(R.id.btnE);
        Button btnF = findViewById(R.id.btnF);

        class MyListener implements View.OnClickListener{

            String name;

            public MyListener(String name) {this.name = name;}

            @Override
            public void onClick(View v) {
                String tag = (String)v.getTag();
                String text = (String)((Button)v).getText(); // CharSequence 객체 리턴
                String msg = String.format("%s 버튼 %s 이 클릭[%s]", name, text, tag);
                Log.d("myapp", msg);
                tvResult.setText(msg);
                et.setText(et.getText().append(name));
            }
        }

        btnA.setOnClickListener(new MyListener("안녕1"));
        btnB.setOnClickListener(new MyListener("안녕2"));
        btnC.setOnClickListener(new MyListener("안녕3"));
        btnD.setOnClickListener(new MyListener("안녕4"));
        btnE.setOnClickListener(new MyListener("안녕5"));
        btnF.setOnClickListener(new MyListener("안녕6"));

        // 방법 5 : 액티비티가 implement
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        // 연습
        // + , - 버튼 누르면 tvResult의 글씨가 커지고/작아지게 만들기
        // getTextsize() : float 값 리턴

        Button btnInc = findViewById(R.id.btnInc);
        Button btnDec = findViewById(R.id.btnDec);
        btnInc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                float  size = tvResult.getTextSize();
                tvResult.setTextSize(0, size + 5);
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               float size = tvResult.getTextSize();
               tvResult.setTextSize(0, size - 5);
            }
        });

    } // onCreate()

    // 방법1 : 레이아웃 xml의 onXXX 속성으로 지정
    public void changeText(View v){
        // Log.d(tag, message)
        // Log 창의 Debug 메세지로 출력
        Log.d("myapp", "버튼1이 클릭되었습니다");
        tvResult.setText("버튼1 이 클릭 되었습니다");

        // verbose : 모든 메세지 다 보기
    }

    // 방법5 : 액티비티가 implement 한 것을 사용
    @Override
    public void onClick(View v) {
        Log.d("myapp", "Clear 버튼이 클릭되었습니다");
        tvResult.setText("Clear버튼이 클릭 되었습니다.");
        et.setText(""); // 이 동작이 지우는 역할
    }
} // MainActivity
