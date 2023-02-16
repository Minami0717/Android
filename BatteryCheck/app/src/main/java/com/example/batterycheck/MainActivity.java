package com.example.batterycheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView battery;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배터리 체크");

        battery = findViewById(R.id.battery);
        text = findViewById(R.id.text);
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br,filter);
    }

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                text.setText("현재 충전량 : " + remain + " %\n");
                Toast.makeText(getApplicationContext(),"배터리 상태: "+remain+" %",
                        Toast.LENGTH_SHORT).show();

                if (remain >= 90) battery.setImageResource(R.drawable.stat_sys_battery_100);
                else if (remain >= 70) battery.setImageResource(R.drawable.stat_sys_battery_80);
                else if (remain >= 50) battery.setImageResource(R.drawable.stat_sys_battery_60);
                else if (remain >= 10) battery.setImageResource(R.drawable.stat_sys_battery_20);
                else battery.setImageResource(R.drawable.stat_sys_battery_0);

                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
                switch (plug) {
                    case 0:
                        text.append("전원 연결 : 안됨");
                        Toast.makeText(getApplicationContext(),"배터리 상태: 현재 충전중 아님",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        text.append("전원 연결 : 어댑터 연결됨");
                        Toast.makeText(getApplicationContext(),"배터리 상태: 현재 충전중",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        text.append("전원 연결 : USB 연결됨");
                        Toast.makeText(getApplicationContext(),"배터리 상태: 현재 충전중",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    };
}