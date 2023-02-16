package com.example.radiodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    RadioButton dog, cat, rabbit, horse;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        rabbit = findViewById(R.id.rabbit);
        horse = findViewById(R.id.horse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setView(dialogView);
                dialog.setNegativeButton("닫기", null);

                ImageView imageView = dialogView.findViewById(R.id.dialogImage);

                if (dog.isChecked()) {
                    dialog.setTitle(dog.getText());
                    imageView.setImageResource(R.drawable.puppy);
                }
                else if (cat.isChecked()) {
                    dialog.setTitle(cat.getText());
                    imageView.setImageResource(R.drawable.lion);
                }
                else if (rabbit.isChecked()) {
                    dialog.setTitle(rabbit.getText());
                    imageView.setImageResource(R.drawable.tiger);
                }
                else if (horse.isChecked()) {
                    dialog.setTitle(horse.getText());
                    imageView.setImageResource(R.drawable.bear);
                }
                else {
                    Toast.makeText(MainActivity.this, "동물 선택", Toast.LENGTH_SHORT).show();
                    return;
                }

                dialog.show();
            }
        });
    }
}