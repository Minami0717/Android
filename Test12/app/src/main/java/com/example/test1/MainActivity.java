package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button plus, minus, multi, div, rest;
    TextView textView;
    String number1, number2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기(수정)");

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multi = (Button) findViewById(R.id.multi);
        div = (Button) findViewById(R.id.div);
        rest = (Button) findViewById(R.id.rest);
        textView = (TextView) findViewById(R.id.result);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus.setBackgroundColor(Color.RED);
                minus.setBackgroundColor(Color.LTGRAY);
                multi.setBackgroundColor(Color.LTGRAY);
                div.setBackgroundColor(Color.LTGRAY);
                rest.setBackgroundColor(Color.LTGRAY);
                number1 = num1.getText().toString();
                number2 = num2.getText().toString();
                try {
                    result = Double.parseDouble(number1) + Double.parseDouble(number2);
                    textView.setText("계산 결과 : " + result);
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus.setBackgroundColor(Color.LTGRAY);
                minus.setBackgroundColor(Color.RED);
                multi.setBackgroundColor(Color.LTGRAY);
                div.setBackgroundColor(Color.LTGRAY);
                rest.setBackgroundColor(Color.LTGRAY);
                number1 = num1.getText().toString();
                number2 = num2.getText().toString();
                try {
                    result = Double.parseDouble(number1) - Double.parseDouble(number2);
                    textView.setText("계산 결과 : " + result);
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus.setBackgroundColor(Color.LTGRAY);
                minus.setBackgroundColor(Color.LTGRAY);
                multi.setBackgroundColor(Color.RED);
                div.setBackgroundColor(Color.LTGRAY);
                rest.setBackgroundColor(Color.LTGRAY);
                number1 = num1.getText().toString();
                number2 = num2.getText().toString();
                try {
                    result = Double.parseDouble(number1) * Double.parseDouble(number2);
                    textView.setText("계산 결과 : " + result);
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus.setBackgroundColor(Color.LTGRAY);
                minus.setBackgroundColor(Color.LTGRAY);
                multi.setBackgroundColor(Color.LTGRAY);
                div.setBackgroundColor(Color.RED);
                rest.setBackgroundColor(Color.LTGRAY);
                number1 = num1.getText().toString();
                number2 = num2.getText().toString();
                if (number2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    result = Double.parseDouble(number1) / Double.parseDouble(number2);
                    textView.setText("계산 결과 : " + result);
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus.setBackgroundColor(Color.LTGRAY);
                minus.setBackgroundColor(Color.LTGRAY);
                multi.setBackgroundColor(Color.LTGRAY);
                div.setBackgroundColor(Color.LTGRAY);
                rest.setBackgroundColor(Color.RED);
                number1 = num1.getText().toString();
                number2 = num2.getText().toString();
                if (number2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    result = Double.parseDouble(number1) % Double.parseDouble(number2);
                    textView.setText("계산 결과 : " + result);
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}