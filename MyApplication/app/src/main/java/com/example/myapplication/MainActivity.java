package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // activity_main.xml의 버튼에 접근하기 위해 버튼에 대한 멤버 변수 생성
    Button naver_button, emergency_button, gallery_button, close_button;

    // 인텐트 멤버 변수 생성
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById : activity_main.xml 파일에서 만든 버튼 객체에 접근
        naver_button = (Button) findViewById(R.id.naver_button);
        emergency_button = (Button) findViewById(R.id.emergency_button);
        gallery_button = (Button) findViewById(R.id.gallery_button);
        close_button = (Button) findViewById(R.id.close_button);

        // 버튼 색상 변경
        naver_button.setBackgroundColor(Color.GRAY);
        emergency_button.setBackgroundColor(Color.GREEN);
        gallery_button.setBackgroundColor(Color.RED);
        close_button.setBackgroundColor(Color.YELLOW);

        // 버튼을 클릭했을 때 동작하는 클래스 정의
        naver_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 버튼을 클릭했을 때 동작
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                startActivity(intent);
            }
        });

        emergency_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/119"));
                startActivity(intent);
            }
        });

        gallery_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(intent);
            }
        });

        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 애플리케이션 종료
            }
        });
    }
}