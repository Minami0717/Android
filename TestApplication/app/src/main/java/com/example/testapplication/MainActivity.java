package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    RadioButton date, time;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chronometer = findViewById(R.id.chronometer);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        textView = findViewById(R.id.textView);

        date.setVisibility(View.GONE);
        time.setVisibility(View.GONE);
        datePicker.setVisibility(View.GONE);
        timePicker.setVisibility(View.GONE);

        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime()); // 타이머 초기화
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                date.setVisibility(View.VISIBLE);
                time.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
            }
        });

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                textView.setText(
                        Integer.toString(datePicker.getYear()) + "년 " +
                        Integer.toString(datePicker.getMonth() + 1) + "월 " +
                        Integer.toString(datePicker.getDayOfMonth()) + "일 " +
                        Integer.toString(timePicker.getHour()) + "시 " +
                        Integer.toString(timePicker.getMinute()) + "분 ");
                date.setVisibility(View.GONE);
                time.setVisibility(View.GONE);
                datePicker.setVisibility(View.GONE);
                timePicker.setVisibility(View.GONE);

                return false;
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.GONE);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.GONE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });
    }
}