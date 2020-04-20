package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    EditText etName, etAge;
    RadioGroup rgSex;
    RecyclerView rv;
    RadioButton rbMale, rbFemale;

    DogAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(layoutManager);
        adapter = new DogAdapter();
        rv.setAdapter(adapter);

        btnInsert = findViewById(R.id.btnInsert);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        rgSex = findViewById(R.id.rgSex);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
                // insert 버튼을 눌렀을 경우, 데이터를 adapter에 담기
                insertData(v);
            }
        });


    } // onCreate()

    protected void insertData(View v){
        int id = rgSex.getCheckedRadioButtonId();
        RadioButton rb = findViewById(id);
        adapter.addProfile(0, new DogProfile(etName.getText().toString(), etAge.getText().toString(), rb.getText().toString()));
        adapter.notifyDataSetChanged();
    }

} // MainActivity
