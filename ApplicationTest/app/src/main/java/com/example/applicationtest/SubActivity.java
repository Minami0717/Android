package com.example.applicationtest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String num = intent.getExtras().getString("num");
        textView.setText(num);
    }
}
