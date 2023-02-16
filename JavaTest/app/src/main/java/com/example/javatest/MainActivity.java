package com.example.javatest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LinearLayout 객체 생성
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        EditText editText = new EditText(this);
        editText.setHint("입력");
        baseLayout.addView(editText);

        Button button = new Button(this);
        button.setText("버튼입니다");
        button.setBackgroundColor(Color.GREEN);
        baseLayout.addView(button);

        TextView textView = new TextView(this);
        textView.setTextColor(Color.MAGENTA);
        textView.setTextSize(50);
        baseLayout.addView(textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });
    }
}