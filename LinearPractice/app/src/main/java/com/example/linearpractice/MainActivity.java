package com.example.linearpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout magenta, blue, yellow, black;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        magenta = findViewById(R.id.magenta);
        blue = findViewById(R.id.blue);
        yellow = findViewById(R.id.yellow);
        black = findViewById(R.id.black);

        magenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "폭 : " + magenta.getWidth()+", 높이 : " + magenta.getHeight();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "폭 : " + blue.getWidth()+", 높이 : " + blue.getHeight();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "폭 : " + yellow.getWidth()+", 높이 : " + yellow.getHeight();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "폭 : " + black.getWidth()+", 높이 : " + black.getHeight();
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}