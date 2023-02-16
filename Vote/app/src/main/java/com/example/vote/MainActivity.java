package com.example.vote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("선수 선호도 투표");

        int voteCount[] = new int[9];
        for (int i = 0; i < voteCount.length; i++)
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.khj,R.id.kjc,R.id.kjw,R.id.prl,R.id.oji,R.id.kjs,R.id.lws,
                R.id.kmh,R.id.ljh};
        String imageName[] = {"김현준","김지찬","구자욱","피렐라","오재일","김재성","이원석","강민호","이재현"};

        for (int i = 0; i < imageId.length; i++) {
            int index = i;
            image[i] = findViewById(imageId[i]);
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imageName[index] + ": 총 " +
                            voteCount[index] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Result.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName",imageName);
                startActivity(intent);
            }
        });
    }
}