package com.example.buttonmenubar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = findViewById(R.id.button2);
        registerForContextMenu(button2);
        linearLayout = findViewById(R.id.linearLayout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v == button1) {
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if (v == button2) {
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                linearLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.green:
                linearLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.blue:
                linearLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.rotate:
                button2.setRotation(45);
                return true;
            case R.id.twice:
                button2.setScaleX(2);
                button2.setScaleY(2);
                return true;
        }
        return false;
    }
}