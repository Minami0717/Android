package com.example.menubar_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴 예제");

        linearLayout = findViewById(R.id.linearLayout);
        button = findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "빨간색");
        menu.add(0, 2, 0, "초록색");
        menu.add(0, 3, 0, "파란색");
        SubMenu subMenu = menu.addSubMenu("버튼 설정");
        subMenu.add(0, 4, 0, "버튼 45도 회전");
        subMenu.add(0, 5, 0, "버튼 2배 확대");
        subMenu.add(0, 6, 0, "버튼 초기화");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                linearLayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                linearLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                linearLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button.setRotation(45);
                return true;
            case 5:
                button.setScaleX(2);
                button.setScaleY(2);
                return true;
            case 6:
                button.setRotation(0);
                button.setScaleX(1);
                button.setScaleY(1);
                return true;
        }
        return false;
    }
}