package com.example.a016_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements SensorEventListener {

    private TextView tv;
    private SensorManager sm;

    // TYPE_ORIENTATION <-- 현재 deprecated 된 센서
    Sensor accelerometer;
    Sensor magnetometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.textView1);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // 옛날 방식
        // Sensor s = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    } // onCreate()

    // 화면 동작하기 직전에 센서 자원 획득.
    @Override
    protected void onResume() {
        super.onResume();
        // 센서 값이 변경되었을때 마다 콜백 받기 위한 리스너 등록 SensorEventListener 객체
        sm.registerListener((SensorEventListener) this,
                accelerometer, // 콜백 원하는 센서
                2000  // 센서 지연시간, 2ms
        );
        sm.registerListener((SensorEventListener) this,
                magnetometer,
                2000);
    }

    // ★ 화면 빠져나가기 전에 센서 자원 반납!! ★
    @Override
    protected void onPause() {
        super.onPause();
        // 센서에 등록된 리스너 해제
        sm.unregisterListener(this); // 반납할 센서
    }

    float[] mGravity;
    float[] mGeomagnetic;

    // SensorEventListener 객체의 메소드들
    // 센서값이변경될때마다 호출되는 콜백
    @Override
    public void onSensorChanged(SensorEvent event) {
        tv.setText("OnSensorChanged");
        Log.d("myapp", "onSensorChanged");
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            mGravity = event.values; // 센서값들은 float[] 로 넘어옴.

        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            mGeomagnetic = event.values;

        if (mGravity != null && mGeomagnetic != null) {
            float[] R = new float[9];
            float[] I = new float[9];

            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);

            if(success){
                float[] orientation = new float[3];
                SensorManager.getOrientation(R, orientation);

                float azimuth = orientation[0];  // z축 회전방향  (-3 ~ 3)
                float pitch = orientation[1]; // x 축 회전방향   (1.5 ~ -1.5)
                float roll = orientation[2]; // y 축 회전방향    (1.5 ~ -1.5)

                String str = String.format("\n%10s:%10s:%10s\n%10.2f:%10.2f:%10.2f\n",
                        "방위각", "피치", "롤",
                        azimuth, pitch, roll);
                tv.setText(str);
                Log.d("myapp", str);
            }

        }

    }

    // 센서의 정확도가 변경되었을때 호출되는 콜백
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
} // Main2Activity
