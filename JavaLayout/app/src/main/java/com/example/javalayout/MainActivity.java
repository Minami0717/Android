package com.example.javalayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        LinearLayout layout1 = new LinearLayout(this);
        baseLayout.addView(layout1, params1);

        LinearLayout layout2 = new LinearLayout(this);
        layout2.setBackgroundColor(Color.BLUE);
        baseLayout.addView(layout2, params1);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        LinearLayout layout3 = new LinearLayout(this);
        layout3.setBackgroundColor(Color.RED);
        layout1.addView(layout3, params2);

        LinearLayout layout4 = new LinearLayout(this);
        layout4.setOrientation(LinearLayout.VERTICAL);
        layout1.addView(layout4, params2);

        LinearLayout layout5 = new LinearLayout(this);
        layout5.setBackgroundColor(Color.YELLOW);
        layout4.addView(layout5, params1);

        LinearLayout layout6 = new LinearLayout(this);
        layout6.setBackgroundColor(Color.BLACK);
        layout4.addView(layout6, params1);
    }
}