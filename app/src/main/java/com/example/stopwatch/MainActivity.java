package com.example.stopwatch;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.stopwatch.R;

public class MainActivity extends AppCompatActivity {

    // 위젯 전역변수
    TextView tv_text;
    Button btn_start, btn_finish;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 과 연결
        tv_text = findViewById(R.id.tv_text);
        chronometer = findViewById(R.id.chronometer);
        btn_start = findViewById(R.id.btn_start);
        btn_finish = findViewById(R.id.btn_finish);

        // start 버튼 클릭 이벤트
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                tv_text.setTextColor(Color.BLUE);
                tv_text.setText("시간 측정중...");
            }
        });

        // finish 버튼 클릭 이벤트
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                tv_text.setTextColor(Color.RED);
                tv_text.setText("FINISH !!!");
            }
        });

    }
}