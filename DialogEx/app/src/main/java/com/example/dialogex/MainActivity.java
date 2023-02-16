package com.example.dialogex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView toast_text;
    Button button;
    EditText input_name, input_pw, name, pw;
    View dialog, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        name = findViewById(R.id.name);
        pw = findViewById(R.id.password);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialog에 내용으로 보여질 dialog.xml View 생성
                dialog = View.inflate(MainActivity.this, R.layout.dialog, null);
                // dialog 생성 및 설정
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("사용자 정보 입력");
                dig.setIcon(R.mipmap.ic_launcher);
                dig.setView(dialog);

                input_name = dialog.findViewById(R.id.input_name);
                input_pw = dialog.findViewById(R.id.input_password);
                input_name.setText(name.getText().toString());
                input_pw.setText(pw.getText().toString());

                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        name.setText(input_name.getText().toString());
                        pw.setText(input_pw.getText().toString());
                    }
                });
                dig.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = View.inflate(MainActivity.this, R.layout.toast, null);
                        toast_text = toastView.findViewById(R.id.toast_text);
                        toast.setView(toastView);

                        Display display = getWindowManager().getDefaultDisplay();
                        //Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        Point size = new Point();
                        display.getRealSize(size); // status bar 포함
                        //display.getSize(size); status bar 제외
                        int x = (int) (Math.random() * size.x); // width
                        int y = (int) (Math.random() * size.y); // height
                        toast_text.setText("너비 : " + size.x + ", 높이 : " + size.y);
                        toast.setGravity(Gravity.TOP, x, y);
                        toast.show();
                    }
                });
                dig.show();
            }
        });
    }
}