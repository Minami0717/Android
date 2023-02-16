package com.example.spinnerposter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    GraphicView graphicView;
    static Bitmap pic;
    static int idx = 0;
    static float scaleX = 0.4f, scaleY = 0.4f, angle = 0, slopeX = 0, slopeY = 0;
    static Integer[] aniID = {R.drawable.ani01,R.drawable.ani02,R.drawable.ani03,R.drawable.ani04,
            R.drawable.ani05,R.drawable.ani06,R.drawable.ani07,R.drawable.ani08,
            R.drawable.ani09,R.drawable.ani10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("스피너 포스터");

        LinearLayout poster = findViewById(R.id.poster);
        graphicView = new GraphicView(this);
        poster.addView(graphicView);
        registerForContextMenu(graphicView);

        String[] ani = {"귀멸의 칼날","스파이 패밀리","소드 아트 온라인","던만추",
                "문호 스트레이독스","카구야","전여친","러브라이브","오소마츠상","주문은 토끼입니까"};


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,ani);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idx = i;
                graphicView.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,1,0,"회전");
        menu.add(0,2,0,"확대");
        menu.add(0,3,0,"축소");
        menu.add(0,4,0,"기울기 증가");
        menu.add(0,5,0,"기울기 감소");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                angle += 20;
                graphicView.invalidate();
                return true;
            case 2:
                scaleX += 0.1f;
                scaleY += 0.1f;
                graphicView.invalidate();
                return true;
            case 3:
                scaleX -= 0.1f;
                scaleY -= 0.1f;
                graphicView.invalidate();
                return true;
            case 4:
                slopeX += 0.2f;
                slopeY += 0.2f;
                graphicView.invalidate();
                return true;
            case 5:
                slopeX -= 0.2f;
                slopeY -= 0.2f;
                graphicView.invalidate();
                return true;
        }
        return false;
    }

    private static class GraphicView extends View {
        public GraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            pic = BitmapFactory.decodeResource(getResources(),aniID[idx]);
            int x = (getWidth() - pic.getWidth())/2;
            int y = (getHeight() - pic.getHeight())/2;
            int cenX = getWidth()/2;
            int cenY = getHeight()/2;

            canvas.scale(scaleX,scaleY,cenX,cenY);
            canvas.rotate(angle,cenX,cenY);
            canvas.skew(slopeX,slopeY);
            canvas.drawBitmap(pic,x,y,null);

            pic.recycle();
        }
    }
}