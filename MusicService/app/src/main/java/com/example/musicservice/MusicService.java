package com.example.musicservice;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MusicService extends Service {
    MediaPlayer player;
    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";
    ArrayList<String> mp3List;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mp3List = new ArrayList<String>();

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName,extName;
        for (File file : listFiles) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if (extName.equalsIgnoreCase("mp3"))
                mp3List.add(fileName);
        }

        Log.i("서비스 테스트","onCreate()");
        Toast.makeText(getApplicationContext(),"onCreate()",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("서비스 테스트","onStartCommand()");
        Toast.makeText(getApplicationContext(),"onStartCommand()",Toast.LENGTH_SHORT).show();

        final int[] i = {0};
        try {
            player = new MediaPlayer();
            player.setDataSource(mp3Path + mp3List.get(i[0]));
            i[0]++;
            player.prepare();
            player.start();
            player.setLooping(true);

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    try {
                        player.setDataSource(mp3Path + mp3List.get(i[0]));
                        i[0]++;
                        player.prepare();
                        player.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("서비스 테스트","onDestroy()");
        Toast.makeText(getApplicationContext(),"onDestroy()",Toast.LENGTH_SHORT).show();
        player.stop();
        super.onDestroy();
    }
}
