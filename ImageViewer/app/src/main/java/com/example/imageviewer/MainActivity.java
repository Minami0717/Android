package com.example.imageviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    PictureView pictureView;
    TextView textView;

    File[] image_files;
    String image_name;
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        pictureView = findViewById(R.id.pictureView);
        textView = findViewById(R.id.textView);
        // SD카드에서 Pictures 폴더를 읽어 파일 리스트를 File 배열로 생성
        // listFiles : 해당 경로에 있는 모든 파일 반환
        image_files = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
            + "/Pictures").listFiles();
        image_name = image_files[index].toString(); // 첫 번째 파일의 이름을 추출
        pictureView.imagePath = image_name; // 이미지 출력
        textView.setText(index + "/" + (image_files.length-1) + " ");
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        //display.getRealSize(size); // status bar 포함
//        display.getSize(size); //status bar 제외
//        pictureView.setY(size.y/2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if (index < 1)
                    index = image_files.length-1;

                image_name = image_files[index].toString();
                pictureView.imagePath = image_name;
                pictureView.invalidate();
                textView.setText(index + "/" + (image_files.length-1) + " ");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index > image_files.length-1)
                    index = 1;

                image_name = image_files[index].toString();
                pictureView.imagePath = image_name;
                pictureView.invalidate();
                textView.setText(index + "/" + (image_files.length-1) + " ");
            }
        });
    }
}