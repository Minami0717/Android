package com.example.dialoglist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button button;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        layout = findViewById(R.id.linear);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] array = new String[] {"빨간색","초록색","파란색"};
                boolean[] checked = new boolean[] {false, false, false};

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("색상 변경");
                // setItems 기본 setSingleChoiceItems 라디오버튼
                dialog.setMultiChoiceItems(array, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (array[i].equals("빨간색")) {
                            layout.setBackgroundColor(Color.RED);
                        }
                        else if (array[i].equals("초록색")) {
                            layout.setBackgroundColor(Color.GREEN);
                        }
                        else if (array[i].equals("파란색")) {
                            layout.setBackgroundColor(Color.BLUE);
                        }
                    }
                });
                dialog.setNegativeButton("취소", null);
                dialog.show();
            }
        });
    }
}