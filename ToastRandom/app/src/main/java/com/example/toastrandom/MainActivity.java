package com.example.toastrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    View toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Display display = getWindowManager().getDefaultDisplay();
                //Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                Point size = new Point();
                display.getRealSize(size); // status bar 포함
                //display.getSize(size); status bar 제외

                // Math.random() : 0 ~ 1 사이의 수 랜덤 출력
                int x = (int) (Math.random() * size.x); // width
                int y = (int) (Math.random() * size.y); // height

                Toast toast = new Toast(MainActivity.this);
                toastView = View.inflate(MainActivity.this, R.layout.toast, null);
                toast.setView(toastView);

                // setGravity : 토스트 메시지 위치 설정
                toast.setGravity(Gravity.TOP | Gravity.LEFT, x, y);
                toast.show();
            }
        });
    }
}