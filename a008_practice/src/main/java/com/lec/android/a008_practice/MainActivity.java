package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    EditText etName, etAge;
    RadioGroup rgSex;
    RecyclerView rv;

    DogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                // insert 버튼을 눌렀을 경우, 데이터를 adapter에 담기

            }
        });


    } // onCreate()

    protected void insertData(View v){
        adapter.addProfile(new DogProfile(getprofile));
    }

} // MainActivity
