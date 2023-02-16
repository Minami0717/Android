package com.example.voteresultauto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result extends Activity {
    int[] result = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");

        Button start = findViewById(R.id.start);
        Button stop = findViewById(R.id.stop);
        ViewFlipper viewFlipper = findViewById(R.id.viewFlipper);

        ImageView[] images = new ImageView[9];
        Integer viewId[] = {R.id.image1,R.id.image2,R.id.image3,R.id.image4,R.id.image5,R.id.image6,
                R.id.image7, R.id.image8,R.id.image9};
        Integer fileId[] = {R.drawable.khj,R.drawable.kjc,R.drawable.kjw,R.drawable.prl,R.drawable.oji,
                R.drawable.kjs,R.drawable.lws,R.drawable.kmh,R.drawable.ljh};

        // 1,2,3,4,5,6,7,8,9
        // 8,0,0,0,0,0,0,0,0
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (voteResult[i] < voteResult[j])
                    result[i]++;
                else
                    result[j]++;
            }
        }

        for (int i = 0; i < images.length; i++)
            images[i] = findViewById(viewId[i]);

        for (int i = 0; i < images.length; i++)
            images[result[i]].setImageResource(fileId[i]);

        viewFlipper.setFlipInterval(1000);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.startFlipping();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();
            }
        });
    }
}
