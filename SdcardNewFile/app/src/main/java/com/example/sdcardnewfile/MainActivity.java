package com.example.sdcardnewfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button create, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        create = findViewById(R.id.create);
        delete = findViewById(R.id.delete);

        // SD 카드의 절대 경로로
        String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File myDir = new File(sdPath + "/mydir");

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.mkdir();
                Toast.makeText(getApplicationContext(), "디렉터리 생성", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
                Toast.makeText(getApplicationContext(), "디렉터리 삭제", Toast.LENGTH_SHORT).show();
            }
        });
    }
}