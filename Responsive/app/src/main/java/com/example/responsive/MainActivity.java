package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.layout);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);

        Log.i("size", String.valueOf(size.x));
        Log.i("size", String.valueOf(size.y));

        button.setWidth((int)(size.x * 0.3));
        button.setHeight((int)(size.y * 0.1));
        textView.setTextSize((int)(size.x * 0.03));

        Log.i("size", String.valueOf(button.getWidth()));
        Log.i("size", String.valueOf(button.getHeight()));
    }
}