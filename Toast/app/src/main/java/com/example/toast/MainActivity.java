package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Toast
    // - 화면에 잠깐 나타났다 사라지는 메시지
    // - 사용자가 인식해야 할 작은 메시지를 보여줄 때 사용
    // - 디버깅 용도

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 디스플레이 생성
                Display display = getWindowManager().getDefaultDisplay();
                //Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                Point size = new Point();
                display.getRealSize(size); // status bar 포함
                //display.getSize(size); status bar 제외

                // Math.random() : 0 ~ 1 사이의 수 랜덤 출력
                int x = (int) (Math.random() * size.x); // width
                int y = (int) (Math.random() * size.y); // height

                Toast toast = Toast.makeText(MainActivity.this, Integer.toString(y),
                        Toast.LENGTH_SHORT);

                // setGravity : 토스트 메시지 위치 설정
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }
}