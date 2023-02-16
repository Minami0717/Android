package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    String string;
    Button button1, button2;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 생성한 위젯들을 변수에 대입
        editText = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        imageView = (ImageView) findViewById(R.id.imageView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 에디트텍스트에 입력된 값을 string에 저장
                string = editText.getText().toString();
                // 토스트 메시지 출력
                Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(string));
                startActivity(intent);
            }
        });

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.dog);
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.cat);
            }
        });
    }
}