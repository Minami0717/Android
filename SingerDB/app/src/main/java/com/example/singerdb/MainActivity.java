package com.example.singerdb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    EditText name,age,idx;
    TextView idxResult,nameResult,ageResult;
    Button init,insert,select,update,delete;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가수 관리 DB");

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        idx = findViewById(R.id.idx);
        idxResult = findViewById(R.id.idxResult);
        nameResult = findViewById(R.id.nameResult);
        ageResult = findViewById(R.id.ageResult);
        init = findViewById(R.id.init);
        insert = findViewById(R.id.insert);
        select = findViewById(R.id.select);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        dbHelper = new DBHelper(this);

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getWritableDatabase();
                dbHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
                select.callOnClick();
                Toast.makeText(getApplicationContext(),"초기화 완료",Toast.LENGTH_SHORT).show();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getWritableDatabase();
                sqlDB.execSQL("insert into singer(name,age) values('"+name.getText().toString()+"'," +
                        ""+age.getText().toString()+")");
                sqlDB.close();
                select.callOnClick();
                Toast.makeText(getApplicationContext(),"입력됨",Toast.LENGTH_SHORT).show();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("select * from singer",null);

                String index = "번호\r\n--------\r\n";
                String names = "이름\r\n--------\r\n";
                String ages = "나이\r\n--------\r\n";

                while (cursor.moveToNext()) {
                    index += cursor.getInt(0) + "\r\n";
                    names += cursor.getString(1) + "\r\n";
                    ages += cursor.getInt(2) + "\r\n";
                }

                idxResult.setText(index);
                nameResult.setText(names);
                ageResult.setText(ages);

                cursor.close();
                sqlDB.close();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getWritableDatabase();
                sqlDB.execSQL("update singer set name='"+name.getText().toString()+"', " +
                        "age="+age.getText().toString()+" where idx="+idx.getText().toString()+"");
                sqlDB.close();
                select.callOnClick();
                Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getWritableDatabase();
                sqlDB.execSQL("delete from singer where idx="+idx.getText().toString()+"");
                sqlDB.close();
                select.callOnClick();
                Toast.makeText(getApplicationContext(),"삭제됨",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "singer.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table singer(idx integer primary key autoincrement, name char(20)," +
                    "age integer)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists singer");
            onCreate(db);
        }
    }
}