package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText editText;
    Button button;
    String file_name, path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        setTitle("간단 일기장");
        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myDiary";
        file_name = Integer.toString(year) + "_" + Integer.toString(month+1) + "_" + Integer.toString(day)
                + ".txt";
        readDiary(file_name);

        // DatePicker 초기화
        // 날짜가 변경되었을 때 동작
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                file_name = Integer.toString(y) + "_" + Integer.toString(m+1) + "_" + Integer.toString(d)
                        + ".txt";
                readDiary(file_name);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(),"내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                File file = new File(path);
                if (!file.exists())
                    file.mkdir();
                file = new File(path + "/" + file_name);

                try {
                    FileOutputStream outFs = new FileOutputStream(file);
                    String str = editText.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), file_name+"이 저장됨", Toast.LENGTH_SHORT).show();
                    button.setText("수정하기");
                }
                catch (IOException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = new FileInputStream(path + "/" + fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            button.setText("수정하기");
            editText.setText(diaryStr);
        }
        catch (IOException e) {
            editText.setText("");
            editText.setHint("일기 없음");
            button.setText("새로 저장");
        }
    }
}