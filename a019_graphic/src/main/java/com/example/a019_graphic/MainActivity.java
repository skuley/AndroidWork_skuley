package com.example.a019_graphic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // 사용자가 작성한 View로 액티비티 레이아웃 세팅
        MyView v = new MyView(MainActivity.this);
        //setContentView(new MyView(MainActivity.this));
        setContentView(v);

    }
}

class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    // 화면이 업데이트 될때, '그려주기'
    // Canvas 객체 : 글미을 그릴 대상 객체[
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint(); // 화면에 그러줄 도구 세팅
        paint.setColor(Color.RED); // 색상 지정

        setBackgroundColor(Color.GREEN); // 배경색 지정

        // TODO
        // 사각형의 좌상, 우하 좌표
        canvas.drawRect(100, 100, 200, 200, paint);

        // 원의 중심 x, y, 반지름
        canvas.drawCircle(300, 300, 80, paint);

        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10f); // 선의 굵기
        canvas.drawLine(400, 100, 800, 150, paint);

        // Path 자취(?) 만들기
        Path path = new Path(); // android.graphic.Path
        path.moveTo(20, 100); // 자취 이동 (시작점)
        path.lineTo(100, 100); // 직선 line 2
        path.cubicTo(150, 40, 200, 300, 300, 200); // 베지어 곡선

        paint.setColor(Color.CYAN);
        canvas.drawPath(path, paint);
    }
}
