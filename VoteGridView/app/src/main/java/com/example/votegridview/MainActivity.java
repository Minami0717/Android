package com.example.votegridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int voteCount[] = new int[9];
    String imageName[] = {"김현준","김지찬","구자욱","피렐라","오재일","김재성","이원석","강민호","이재현"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 투표");

        for (int j = 0; j < voteCount.length; j++)
            voteCount[j] = 0;

        GridView gridView = findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);

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

    public class GridAdapter extends BaseAdapter {
        Context context;
        Integer[] pic = {R.drawable.khj,R.drawable.kjc,R.drawable.kjw,R.drawable.prl,R.drawable.oji,
                R.drawable.kjs,R.drawable.lws,R.drawable.kmh,R.drawable.ljh};

        public GridAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return pic.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(320,600));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(pic[i]);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[i]++;
                    Toast.makeText(getApplicationContext(),imageName[i] + ": 총 " +
                            voteCount[i] + " 표", Toast.LENGTH_SHORT).show();
                }
            });
            return imageView;
        }
    }
}