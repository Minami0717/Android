package com.example.relativelayoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button, button1, button2, button3, button4, button5, button6;

    long animationDuration = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f);
                animator.setDuration(animationDuration);
                animator.start();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ObjectAnimator.ofFloat(button1, "translationX",
                        0f, 900f);
                animator.setDuration(animationDuration);
                animator.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ObjectAnimator.ofFloat(button, View.ALPHA,
                        1.0f, 0f);
                animator.setDuration(animationDuration);
                animator.start();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ObjectAnimator.ofFloat(button3, "translationY",
                        0f, -2000f);
                animator.setDuration(animationDuration);
                animator.start();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ObjectAnimator.ofFloat(button4, "translationY",
                        0f, 2000f);
                animator.setDuration(animationDuration);
                animator.start();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ObjectAnimator.ofFloat(button, View.ALPHA,
                        0f, 1.0f);
                animator.setDuration(animationDuration);
                animator.start();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValueAnimator animator = ObjectAnimator.ofFloat(button6, "translationX",
                        0f, -900f);
                animator.setDuration(animationDuration);
                animator.start();
            }
        });
    }
}