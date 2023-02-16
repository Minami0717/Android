package com.example.applicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button call;
    Button[] buttons = new Button[12];
    int[] buttonId = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
            R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.asterisk, R.id.button0, R.id.hash};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittext);
        call = (Button) findViewById(R.id.call);

        for (int i = 0; i < buttons.length; i++) {
            int index = i;
            buttons[i] = findViewById(buttonId[i]);
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText.setText(editText.getText().toString() + buttons[index].getText());
                }
            });
        }

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("num", editText.getText().toString());
                startActivity(intent);
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//              if (editText.getText().length()==2 && keyEvent.)
//                  editText.setText(editText.getText().toString() + "-");
                return false;
            }
        });
    }
}