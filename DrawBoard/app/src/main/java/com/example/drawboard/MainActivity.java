package com.example.drawboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static int line = 1, circle = 2, rect = 3;
    static int shape = line, color = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicView(this));
        setTitle("간단 그림판");
    }


    private static class GraphicView extends View {
        MyShape current_shape = null;
        static List<MyShape> myShapes = new ArrayList<MyShape>();

        public GraphicView(Context context) {
            super(context);
        }

        private static class MyShape {
            int shapeType;
            int startX, startY, stopX, stopY, color;

            public MyShape(int shape) {
                this.shapeType = shape;
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    current_shape = new MyShape(shape);
                    current_shape.color = color;
                    current_shape.startX = (int) event.getX();
                    current_shape.startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    current_shape.stopX = (int) event.getX();
                    current_shape.stopY = (int) event.getY();
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    current_shape.stopX = (int) event.getX();
                    current_shape.stopY = (int) event.getY();
                    myShapes.add(current_shape);
                    current_shape = null;
                    this.invalidate();
                    break;
                default:
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);

            for (MyShape current_shape : myShapes) {
                paint.setColor(current_shape.color);
                drawShape(current_shape,canvas,paint);
            }
        }
        private void drawShape(MyShape current_shape, Canvas canvas, Paint paint) {
            switch (current_shape.shapeType) {
                case line:
                    canvas.drawLine(current_shape.startX,current_shape.startY,current_shape.stopX,
                            current_shape.stopY,paint);
                    break;
                case circle:
                    int radius = (int) Math.sqrt(Math.pow(current_shape.stopX-current_shape.startX,2)
                    + Math.pow(current_shape.stopY-current_shape.startY,2));
                    canvas.drawCircle(current_shape.startX,current_shape.startY,radius,paint);
                    break;
                case rect:
                    canvas.drawRect(current_shape.startX,current_shape.startY,current_shape.stopX,
                            current_shape.stopY,paint);
                    break;
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"선 그리기");
        menu.add(0,2,0,"원 그리기");
        menu.add(0,3,0,"사각형 그리기");
        SubMenu subMenu = menu.addSubMenu("색상변경 >>");
        subMenu.add(0,4,0,"빨강");
        subMenu.add(0,5,0,"초록");
        subMenu.add(0,6,0,"파랑");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                shape = line;
                return true;
            case 2:
                shape = circle;
                return true;
            case 3:
                shape = rect;
                return true;
            case 4:
                color = Color.RED;
                return true;
            case 5:
                color = Color.GREEN;
                return true;
            case 6:
                color = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}