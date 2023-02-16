package com.example.file_processing_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button write, read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        write = findViewById(R.id.write);
        read = findViewById(R.id.read);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // /data/data/패키지명/files 폴더에 저장
                try {
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "테스트";
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(MainActivity.this, "file.txt가 생성됨", Toast.LENGTH_SHORT).show();
                }
                catch (IOException error) {
                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    inFs.close();
                    String str = new String(txt);
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                }
                catch (IOException error) {
                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}