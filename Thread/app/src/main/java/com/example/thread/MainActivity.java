package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar bar1 = findViewById(R.id.bar1);
        SeekBar bar2 = findViewById(R.id.bar2);
        Button start = findViewById(R.id.start);
        Button reset = findViewById(R.id.reset);
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);

        final Thread[] thread = new Thread[2];
        final boolean[] state = new boolean[2];


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state[0] = true;
                state[1] = true;

                thread[0] = new Thread() {
                    @Override
                    public void run() {
                        for (int i = bar1.getProgress(); i < 100; i = i + 2) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    bar1.setProgress(bar1.getProgress() + 2);
                                    t1.setText("1번 진행률 : " + bar1.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);

                            if (!state[0]) {
                                bar1.setProgress(0);
                                bar2.setProgress(0);
                                break;
                            }
                        }
                    }
                };
                thread[0].start();

                thread[1] = new Thread() {
                    @Override
                    public void run() {
                        for (int i=bar2.getProgress(); i<100; i++) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    bar2.setProgress(bar2.getProgress()+1);
                                    t2.setText("2번 진행률 : " + bar2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);

                            if (!state[1]) {
                                bar1.setProgress(0);
                                bar2.setProgress(0);
                                break;
                            }
                        }
                    }
                };
                thread[1].start();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state[0] = false;
                state[1] = false;

                t1.setText("1번 진행률 : 0%");
                t2.setText("2번 진행률 : 0%");
            }
        });
    }
}