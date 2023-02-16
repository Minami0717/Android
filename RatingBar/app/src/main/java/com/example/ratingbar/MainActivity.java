package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBar bar1,bar2,bar3;
        Button plus,minus;

        bar1 = findViewById(R.id.bar1);
        bar2 = findViewById(R.id.bar2);
        bar3 = findViewById(R.id.bar3);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar1.setRating(bar1.getRating()+bar1.getStepSize());
                bar2.setRating(bar2.getRating()+bar2.getStepSize());
                bar3.setRating(bar3.getRating()+bar3.getStepSize());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar1.setRating(bar1.getRating()-bar1.getStepSize());
                bar2.setRating(bar2.getRating()-bar2.getStepSize());
                bar3.setRating(bar3.getRating()-bar3.getStepSize());
            }
        });
    }
}