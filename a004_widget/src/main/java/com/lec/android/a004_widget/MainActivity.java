package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPassword, etEmail, etNumber;
    TextView tvName, tvPassword, tvEmail, tvNumber, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etNumber = findViewById(R.id.etNumber);

        tvName = findViewById(R.id.tvName);
        tvPassword = findViewById(R.id.tvPassword);
        tvEmail = findViewById(R.id.tvEmail);
        tvNumber = findViewById(R.id.tvNumber);

        tvResult = findViewById(R.id.tvResult);

        // editText 기능
        // 포커스 변화
        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            // hasFocus : true <-- 포커스 받은 경우 / false <-- 포커스 잃은 경우
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    ((EditText)v).setBackgroundColor(Color.YELLOW);
                } else {
                    // 투명색
                    ((EditText)v).setBackgroundColor(Color.parseColor("#00000000"));
                }

            }
        });

        // 자판 키보드 눌릴때 (자판 키보드만 반응하고 폰에서는 안먹힘)
        etPassword.setOnKeyListener(new View.OnKeyListener() {
            // keyCode : 눌린 키의 크드값
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                tvResult.setText(((EditText)v).getText().toString());
                return false;
            }
        });

        // 값의 변화 (입력 완료)
        etEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                tvResult.setText("입력완료: " + actionId );
                return false;
            }
        });




    } // onCreate()
}
