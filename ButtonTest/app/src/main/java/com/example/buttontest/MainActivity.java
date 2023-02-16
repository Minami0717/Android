package com.example.buttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    CheckBox enabled, clickable, rotation;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enabled = (CheckBox) findViewById(R.id.enabled);
        clickable = (CheckBox) findViewById(R.id.clickable);
        rotation = (CheckBox) findViewById(R.id.rotation);
        button = (Button) findViewById(R.id.button);

        enabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    button.setEnabled(true);
                }
                else {
                    button.setEnabled(false);
                }
            }
        });

        clickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    button.setClickable(true);
                }
                else {
                    button.setClickable(false);
                }
            }
        });

        rotation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    button.setRotation(45);
                }
                else {
                    button.setRotation(0);
                }
            }
        });
    }
}