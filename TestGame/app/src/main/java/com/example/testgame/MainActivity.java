package com.example.testgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    EditText editText;
    Button button;
    Integer strike = 0, ball = 0, n2, n3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);


        Random random = new Random();

        int n1 = random.nextInt(9)+1;
        while (true) {
            n2 = random.nextInt(9)+1;
            n3 = random.nextInt(9)+1;
            if (n1 != n2 && n1 != n3 && n2 != n3)
                break;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                int i1 = Integer.parseInt(input.substring(0,1));
                int i2 = Integer.parseInt(input.substring(1,2));
                int i3 = Integer.parseInt(input.substring(2,3));

                strike = 0;
                ball = 0;
                if (n1==i1)
                    strike++;
                if (n2==i2)
                    strike++;
                if (n3==i3)
                    strike++;
                if (i1==n2 || i1==n3)
                    ball++;
                if (i2==n1 || i2==n3)
                    ball++;
                if (i3==n2 || i3==n1)
                    ball++;

                if (strike == 3) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setTextSize(30);
                    layout.addView(textView);
                    textView.setText("삼진");
                }
                else {
                    String result = "strike : " + strike + " ball : " + ball;
                    TextView textView = new TextView(getApplicationContext());
                    textView.setTextSize(30);
                    layout.addView(textView);
                    textView.setText(input + "  " + result);
                }
            }
        });
    }
}