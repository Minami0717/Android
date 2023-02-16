package com.example.activitypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);
        RadioButton second = findViewById(R.id.second);
        RadioButton third = findViewById(R.id.third);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                if (second.isChecked())
                    intent.setClass(getApplicationContext(), Second.class);
                else if (third.isChecked())
                    intent.setClass(getApplicationContext(), Third.class);
                else {
                    Toast.makeText(getApplicationContext(), "버튼 선택", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });
    }
}