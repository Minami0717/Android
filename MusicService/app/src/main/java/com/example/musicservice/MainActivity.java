package com.example.musicservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("서비스 테스트");
        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        intent = new Intent(this,MusicService.class);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
                Toast.makeText(getApplicationContext(),"startService()",Toast.LENGTH_SHORT).show();
                Log.i("서비스 테스트","startService()");
                finish();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
                Toast.makeText(getApplicationContext(),"stopService()",Toast.LENGTH_SHORT).show();
                Log.i("서비스 테스트","stopService()");
            }
        });
    }
}