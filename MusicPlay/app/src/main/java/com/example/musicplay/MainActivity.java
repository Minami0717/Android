package com.example.musicplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    SeekBar bar;
    Switch play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        player = MediaPlayer.create(this,R.raw.mybgm);
        bar = findViewById(R.id.bar);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (play.isChecked()) {
                    player.start();
                    thread_start();
                }
                else
                    player.stop();
            }
        });
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b)
                    player.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    void thread_start() {
        new Thread() {
            @Override
            public void run() {
                while (player.isPlaying()) {
                    bar.setMax(player.getDuration());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bar.setProgress(player.getCurrentPosition());
                        }
                    });
                    SystemClock.sleep(100);
                }
                bar.setProgress(0);
            }
        }.start();
    }
}