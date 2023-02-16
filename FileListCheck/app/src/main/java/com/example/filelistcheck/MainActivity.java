package com.example.filelistcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 안드로이드 system 폴더 경로 : /system
                String sysDir = Environment.getRootDirectory().getAbsolutePath();

                // system 폴더의 폴더/파일 목록을 sys_files 배열에 저장장
               File[] sysFiles = new File(sysDir).listFiles();

                String fileName;
                for(File sysFile : sysFiles) {
                    if (sysFile.isDirectory())
                        fileName = "<폴더> " + sysFile.toString();
                    else
                        fileName = "<파일> " + sysFile.toString();

                    editText.setText(editText.getText() + "\n" + fileName);
                }
//                for (int i = 0; i < sysFiles.length; i++) {
//                    if (sysFiles[i].isDirectory())
//                        fileName = "<폴더> " + sysFiles[i].toString();
//                    else
//                        fileName = "<파일> " + sysFiles[i].toString();
//
//                    editText.setText(editText.getText() + "\n" + fileName);
//                }
            }
        });
    }
}