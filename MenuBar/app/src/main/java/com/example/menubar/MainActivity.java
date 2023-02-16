package com.example.menubar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴 예제");

        linearLayout = findViewById(R.id.linearLayout);
        button = findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Inflater : xml 파일을 java 코드에서 접근해서 사용
        MenuInflater menuInflater = getMenuInflater(); // 메뉴 Inflater 생성
        menuInflater.inflate(R.menu.menu1, menu); // 메뉴 xml 파일 연결

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                linearLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.itemGreen:
                linearLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.itemBlue:
                linearLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.subButton1:
                button.setRotation(45);
                return true;
            case R.id.subButton2:
                button.setScaleX(2);
                button.setScaleY(2);
                return true;
            case R.id.subButton3:
                button.setRotation(0);
                button.setScaleX(1);
                button.setScaleY(1);
                return true;
        }
        return false;
    }
}