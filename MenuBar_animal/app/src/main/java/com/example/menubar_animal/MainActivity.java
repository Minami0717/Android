package com.example.menubar_animal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("동물");

        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.image);
    }

    // 앱이 실행되면 메뉴 xml의 내용을 자동으로 읽어옴
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
            case R.id.turn:
                imageView.setRotation(Float.parseFloat(editText.getText().toString()));
                return true;
            case R.id.dog:
                imageView.setImageResource(R.drawable.dog);
                return true;
            case R.id.cat:
                imageView.setImageResource(R.drawable.cat);
                return true;
            case R.id.rabbit:
                imageView.setImageResource(R.drawable.wdog);
                return true;
        }
        return false;
    }
}