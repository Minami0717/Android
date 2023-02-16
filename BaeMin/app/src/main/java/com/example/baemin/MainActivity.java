package com.example.baemin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    LinearLayout address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = findViewById(R.id.address);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),Address.class);
                startActivity(intent);
            }
        });
//        baemin1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    baemin1.setScaleX(0.95f);
//                    baemin1.setScaleY(0.95f);
//                }
//                else if(motionEvent.getAction() == MotionEvent.ACTION_UP ||
//                        motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    baemin1.setScaleX(1);
//                    baemin1.setScaleY(1);
//                }
//                return false;
//            }
//        });
//        baedal.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    baedal.setScaleX(0.95f);
//                    baedal.setScaleY(0.95f);
//                }
//                else if(motionEvent.getAction() == MotionEvent.ACTION_UP ||
//                        motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    baedal.setScaleX(1);
//                    baedal.setScaleY(1);
//                }
//                return false;
//            }
//        });
//        pojang.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    pojang.setScaleX(0.95f);
//                    pojang.setScaleY(0.95f);
//                }
//                else if(motionEvent.getAction() == MotionEvent.ACTION_UP ||
//                        motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    pojang.setScaleX(1);
//                    pojang.setScaleY(1);
//                }
//                return false;
//            }
//        });
//        live.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    live.setScaleX(0.95f);
//                    live.setScaleY(0.95f);
//                }
//                else if(motionEvent.getAction() == MotionEvent.ACTION_UP ||
//                        motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    live.setScaleX(1);
//                    live.setScaleY(1);
//                }
//                return false;
//            }
//        });
//        present.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    present.setScaleX(0.95f);
//                    present.setScaleY(0.95f);
//                }
//                else if(motionEvent.getAction() == MotionEvent.ACTION_UP ||
//                        motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    present.setScaleX(1);
//                    present.setScaleY(1);
//                }
//                return false;
//            }
//        });
//        jeonguk.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
//                    jeonguk.setScaleX(0.95f);
//                    jeonguk.setScaleY(0.95f);
//                }
//                else if(motionEvent.getAction() == MotionEvent.ACTION_UP ||
//                        motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    jeonguk.setScaleX(1);
//                    jeonguk.setScaleY(1);
//                }
//                return false;
//            }
//        });
    }
}