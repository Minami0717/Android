package com.example.gridlayoutcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button add, sub, mul, div;
    TextView textView;
    String n1, n2;
    Double result;

    Button[] number_buttons = new Button[10];
    Integer[] number_button_ids = { R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        textView = (TextView) findViewById(R.id.textView);

        for (int i = 0; i < number_buttons.length; i++) {
            number_buttons[i] = (Button) findViewById(number_button_ids[i]);
        }

        for (int i = 0; i < number_buttons.length; i++) {
            int index = i;
            number_buttons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (editText1.isFocused())
                        editText1.setText(editText1.getText().toString()+number_buttons[index].getText());
                    else if (editText2.isFocused())
                        editText2.setText(editText2.getText().toString()+number_buttons[index].getText());
                    else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    n1 = editText1.getText().toString();
                    n2 = editText2.getText().toString();
                    result = Double.parseDouble(n1) + Double.parseDouble(n2);
                    textView.setText("계산결과 : " + result);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    n1 = editText1.getText().toString();
                    n2 = editText2.getText().toString();
                    result = Double.parseDouble(n1) - Double.parseDouble(n2);
                    textView.setText("계산결과 : " + result);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    n1 = editText1.getText().toString();
                    n2 = editText2.getText().toString();
                    result = Double.parseDouble(n1) * Double.parseDouble(n2);
                    textView.setText("계산결과 : " + result);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    n1 = editText1.getText().toString();
                    n2 = editText2.getText().toString();
                    result = Double.parseDouble(n1) / Double.parseDouble(n2);
                    textView.setText("계산결과 : " + result);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}