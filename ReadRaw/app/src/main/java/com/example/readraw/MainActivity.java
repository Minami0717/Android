package com.example.readraw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // getResources : 현재 패키지의 리소스를 반환
                    // openRawResource : /res/raw 리소스를 읽기 전용으로 open
                    // available : 입력 스트림에서 읽을 수 있는 바이트 수를 반환
                    // InputStream inputStream = getResources().openRawResource(R.raw.test); raw 파일
                    FileInputStream inputStream = new FileInputStream("/storage/emulated/0/test.txt");
                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    inputStream.close();
                    editText.setText(new String(txt));
                }
                catch (IOException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}