package com.example.photoshopmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    GraphicView graphicView;
    static Bitmap picture;
    static float scaleX = 1, scaleY = 1, color = 1, angle = 0, chroma = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        graphicView = new GraphicView(this);
        setContentView(graphicView);
        setTitle("미니 포토샵(메뉴)");

        registerForContextMenu(graphicView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,1,0,"확대");
        menu.add(0,2,0,"축소");
        menu.add(0,3,0,"회전");
        menu.add(0,4,0,"밝게");
        menu.add(0,5,0,"어둡게");
        menu.add(0,6,0,"그레이영상");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                scaleX += 0.2f;
                scaleY += 0.2f;
                graphicView.invalidate();
                return true;
            case 2:
                scaleX -= 0.2f;
                scaleY -= 0.2f;
                graphicView.invalidate();
                return true;
            case 3:
                angle += 20;
                graphicView.invalidate();
                return true;
            case 4:
                color += 0.2f;
                graphicView.invalidate();
                return true;
            case 5:
                color -= 0.2f;
                graphicView.invalidate();
                return true;
            case 6:
                if (chroma == 1) chroma = 0;
                else chroma = 1;
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

            picture = BitmapFactory.decodeResource(getResources(), R.drawable.image256);
            int x = (getWidth() - picture.getWidth())/2;
            int y = (getHeight() - picture.getHeight())/2;
            int cenX = getWidth()/2;
            int cenY = getHeight()/2;

            canvas.scale(scaleX,scaleY,cenX,cenY);
            canvas.rotate(angle,cenX,cenY);

            Paint paint = new Paint();
            float[] array = {color,0,0,0,0,
                            0,color,0,0,0,
                            0,0,color,0,0,
                            0,0,0,1,0};

            ColorMatrix cm = new ColorMatrix(array);
            if(chroma == 0) cm.setSaturation(chroma);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            canvas.drawBitmap(picture,x,y,paint);

            picture.recycle();
        }
    }
}