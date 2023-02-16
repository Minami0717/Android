package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test", "test");
        Log.e("test", "test");
        Log.i("test", "test");
        Log.v("test", "test");
        Log.w("test", "test");
    }
}