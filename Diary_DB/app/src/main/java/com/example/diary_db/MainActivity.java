package com.example.diary_db;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText editText;
    Button button,delete;
    DBHelper dbHelper;
    SQLiteDatabase sqlDB;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일기장_DB");

        datePicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        delete = findViewById(R.id.delete);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        date = Integer.toString(year) + Integer.toString(month+1) +  Integer.toString(day);
        dbHelper = new DBHelper(this);
        select();

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                date = Integer.toString(y) + Integer.toString(m+1) +  Integer.toString(d);
                select();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getWritableDatabase();

                if (button.getText().equals("새로 저장")) {
                    sqlDB.execSQL("insert into myDiary values('"+date+"', " +
                            "'"+editText.getText().toString()+"')");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"저장 완료",Toast.LENGTH_SHORT).show();
                    button.setText("수정하기");
                }
                else if (button.getText().equals("수정하기")) {
                    sqlDB.execSQL("update myDiary set content='"+editText.getText().toString()+"'" +
                            "where diaryDate='"+date+"'");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(),"수정 완료",Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button.getText().equals("새로 저장")) {
                    Toast.makeText(getApplicationContext(),"저장된 내용이 없습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                sqlDB = dbHelper.getWritableDatabase();
                sqlDB.execSQL("delete from myDiary where diaryDate='"+date+"'");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"삭제 완료",Toast.LENGTH_SHORT).show();
                editText.setText("");
                editText.setHint("내용 없음");
                button.setText("새로 저장");
            }
        });
    }

    void select() {
        sqlDB = dbHelper.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("select * from myDiary " +
                "where diaryDate='"+date+"'",null);

        if (cursor.moveToNext()) {
            editText.setText(cursor.getString(1));
            button.setText("수정하기");
        }
        else {
            editText.setText("");
            editText.setHint("내용 없음");
            button.setText("새로 저장");
        }

        cursor.close();
        sqlDB.close();
    }

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "myDB.db",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table myDiary(diaryDate char(10) primary key, content varchar(500))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists myDiary");
            onCreate(db);
        }
    }
}