package com.example.votegridview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Result extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");
        int max = 0;

        TextView[] tv = new TextView[9];
        RatingBar[] rb = new RatingBar[9];

        Integer[] tId = {R.id.pic1,R.id.pic2,R.id.pic3,R.id.pic4,R.id.pic5,R.id.pic6,R.id.pic7,
                R.id.pic8,R.id.pic9};
        Integer[] rId = {R.id.bar1,R.id.bar2,R.id.bar3,R.id.bar4,R.id.bar5,R.id.bar6,R.id.bar7,
                R.id.bar8,R.id.bar9};
        Integer fileId[] = {R.drawable.khj,R.drawable.kjc,R.drawable.kjw,R.drawable.prl,
                R.drawable.oji,R.drawable.kjs,R.drawable.lws,R.drawable.kmh,R.drawable.ljh};

        for (int i = 0; i < tv.length; i++) {
            tv[i] = findViewById(tId[i]);
            rb[i] = findViewById(rId[i]);
            tv[i].setText(imageName[i]);
            rb[i].setRating(voteResult[i]);
        }
        for (int i = 1; i < voteResult.length; i++) {
            if (voteResult[max] < voteResult[i])
                max = i;
        }
        TextView textView = findViewById(R.id.maxName);
        textView.setText(imageName[max]);
        ImageView imageView = findViewById(R.id.maxPic);
        imageView.setImageResource(fileId[max]);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
