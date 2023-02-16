package com.example.drawtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        // 클래스가 생성되거나 갱신(invalidate)되면 호출되는 메소드
        // - 일반적으로 화면에 그려질 내용
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(70);

            canvas.drawLine(50,50,700,50,paint);

            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50,200,700,200,paint);

            canvas.drawOval(100,300,700,500,paint);

            canvas.drawArc(100,400,400,700,40,
                    100,true,paint);

            paint.setColor(Color.BLUE);
            canvas.drawRect(100,800,400,1100,paint);

            paint.setColor(Color.argb(128,255,0,0));
            canvas.drawRect(200,900,500,1200,paint);
        }
    }
}