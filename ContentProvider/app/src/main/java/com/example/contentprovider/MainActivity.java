package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.READ_CALL_LOG},MODE_PRIVATE);

        button = findViewById(R.id.button);
        text = findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText(getCallHistory());
            }
        });
    }

    public String getCallHistory() {
        String[] callSet = new String[] {CallLog.Calls.DATE, CallLog.Calls.TYPE,
                CallLog.Calls.NUMBER, CallLog.Calls.DURATION};
        Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI,callSet,
                null,null,null);
        if (c == null)
            return "통화기록 없음";

        StringBuffer callBuff = new StringBuffer();
        callBuff.append("\n날짜 / 구분 / 전화번호 / 통화시간\n\n");
        c.moveToFirst();
        do {
            long callDate = c.getLong(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date_str = dateFormat.format(new Date(callDate));
            callBuff.append(date_str + " / ");
            if (c.getInt(1) == CallLog.Calls.INCOMING_TYPE)
                callBuff.append("착신 / ");
            else
                callBuff.append("발신 / ");
            callBuff.append(c.getString(2) + " / ");
            callBuff.append(c.getString(3) + "초\n");
        } while (c.moveToNext());

        c.close();
        return callBuff.toString();
    }
}