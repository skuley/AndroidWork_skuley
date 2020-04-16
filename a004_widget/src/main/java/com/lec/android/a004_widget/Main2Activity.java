package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button btnPlus, btnMinus, btnMul, btnDiv;
    EditText op1, op2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        tvResult = findViewById(R.id.tvResult);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op1.setBackgroundColor(Color.YELLOW);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();
                int a = Integer.parseInt(oper1);
                int b = Integer.parseInt(oper2);
                tvResult.setText((a + b) + "");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();
                int a = Integer.parseInt(oper1);
                int b = Integer.parseInt(oper2);
                tvResult.setText((a - b) + "");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();
                int a = Integer.parseInt(oper1);
                int b = Integer.parseInt(oper2);
                tvResult.setText((a * b) + "");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();
                int a = Integer.parseInt(oper1);
                int b = Integer.parseInt(oper2);
                tvResult.setText((a / b) + "");
            }
        });



    }
}
