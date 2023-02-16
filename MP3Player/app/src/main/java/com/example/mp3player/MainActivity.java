package com.example.mp3player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String selectedMp3;
    MediaPlayer player;
    TextView time;
    SeekBar bar;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MP3 플레이어");
        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        ListView mp3 = findViewById(R.id.mp3);
        Button play = findViewById(R.id.play);
        Button pause = findViewById(R.id.pause);
        Button stop = findViewById(R.id.stop);
        TextView text = findViewById(R.id.text);
        bar = findViewById(R.id.bar);
        time = findViewById(R.id.time);
        simpleDateFormat = new SimpleDateFormat("mm:ss");

        String mp3Path = Environment.getExternalStorageDirectory().getPath()+"/";
        ArrayList<String> mp3List = new ArrayList<String>();

        File[] fileList = new File(mp3Path).listFiles();
        String fileName,extName;
        for (File file : fileList) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length()-3);
            if (extName.equalsIgnoreCase("mp3"))
                mp3List.add(fileName);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice,mp3List);
        mp3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mp3.setAdapter(adapter);
        mp3.setItemChecked(0,true);

        mp3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMp3 = mp3List.get(i);
            }
        });
        selectedMp3 = mp3List.get(0);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    player = new MediaPlayer();
                    player.setDataSource(mp3Path+selectedMp3);
                    player.prepare();
                    player.start();
                    play.setClickable(false);
                    pause.setClickable(true);
                    stop.setClickable(true);
                    text.setText("실행중인 음악 : "+selectedMp3);

                    handler.sendEmptyMessage(0);
//                    new Thread() {
//                        SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
//                        @Override
//                        public void run() {
//                            if (player == null) return;
//                            bar.setMax(player.getDuration());
//                            while (player.isPlaying()) {
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        bar.setProgress(player.getCurrentPosition());
//                                        time.setText("진행 시간 : "+timeFormat.format(
//                                                player.getCurrentPosition()));
//                                    }
//                                });
//                                SystemClock.sleep(200);
//                            }
//                        }
//                    }.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pause.getText().equals("일시정지")) {
                    player.pause();
                    pause.setText("이어듣기");
                }
                else {
                    player.start();
                    pause.setText("일시정지");

//                    new Thread() {
//                        SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
//                        @Override
//                        public void run() {
//                            if (player == null) return;
//                            while (player.isPlaying()) {
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        bar.setProgress(player.getCurrentPosition());
//                                        time.setText("진행 시간 : "+timeFormat.format(
//                                                player.getCurrentPosition()));
//                                    }
//                                });
//                                SystemClock.sleep(200);
//                            }
//                        }
//                    }.start();
                }
            }
        });
        pause.setClickable(false);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();
                player.reset();
                play.setClickable(true);
                pause.setClickable(false);
                stop.setClickable(false);
                text.setText("실행중인 음악 : ");
                pause.setText("일시정지");
                bar.setProgress(0);
                time.setText("진행시간 : ");
            }
        });
        stop.setClickable(false);
    }

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (player == null)
                return;

            bar.setMax(player.getDuration());

            if (player.isPlaying()) {
                bar.setProgress(player.getCurrentPosition());
                time.setText("진행 시간 : "+simpleDateFormat.format(
                        player.getCurrentPosition()));
            }
            handler.sendEmptyMessageDelayed(0,200);
        }
    };
}