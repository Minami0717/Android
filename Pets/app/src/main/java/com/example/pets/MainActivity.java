package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch switch1;
    TextView textView;
    RadioGroup radioGroup;
    RadioButton bear, lion, tiger;
    ImageView imageView;
    Button exit, restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진");

        switch1 = (Switch) findViewById(R.id.switch1);
        textView = (TextView) findViewById(R.id.textView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        bear = (RadioButton) findViewById(R.id.bear);
        lion = (RadioButton) findViewById(R.id.lion);
        tiger = (RadioButton) findViewById(R.id.tiger);
        imageView = (ImageView) findViewById(R.id.imageView);
        exit = (Button) findViewById(R.id.exit);
        restart = (Button) findViewById(R.id.restart);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    textView.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    exit.setVisibility(View.VISIBLE);
                    restart.setVisibility(View.VISIBLE);
                    radioGroup.clearCheck();
                    imageView.setImageResource(0);
                }
                else {
                    textView.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    exit.setVisibility(View.INVISIBLE);
                    restart.setVisibility(View.INVISIBLE);
                }
            }
        });

        bear.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imageView.setImageResource(R.drawable.bear);
                }
            }
        });

        lion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imageView.setImageResource(R.drawable.lion);
                }
            }
        });

        tiger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imageView.setImageResource(R.drawable.tiger);
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finishAndRemoveTask();
                System.exit(0);
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch1.setChecked(false);
            }
        });
    }
}