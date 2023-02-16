package com.example.photoshop;

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
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton zoomIn, zoomOut, rotate, bright, dark, blur, embo;
    GraphicView graphicView;
    static float scaleX = 1, scaleY = 1, color = 1, angle = 0, chroma = 1;
    static boolean isBlur = false, isEmbo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        zoomIn = findViewById(R.id.zoomIn);
        zoomOut = findViewById(R.id.zoomout);
        rotate = findViewById(R.id.rotate);
        bright = findViewById(R.id.bright);
        dark = findViewById(R.id.dark);
        blur = findViewById(R.id.blur);
        embo = findViewById(R.id.embo);

        LinearLayout picture = findViewById(R.id.picture);
        graphicView = new GraphicView(this);
        picture.addView(graphicView);

        clickIcons();
    }

    private void clickIcons() {
        zoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX += 0.2f;
                scaleY += 0.2f;
                graphicView.invalidate();
            }
        });
        zoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX -= 0.2f;
                scaleY -= 0.2f;
                graphicView.invalidate();
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle += 20;
                graphicView.invalidate();
            }
        });
        bright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chroma += 0.5f;
                graphicView.invalidate();
            }
        });
        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chroma -= 0.5f;
                graphicView.invalidate();
            }
        });
        blur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isBlur) isBlur = true;
                else isBlur = false;
                graphicView.invalidate();
            }
        });
        embo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmbo) isEmbo = true;
                else isEmbo = false;
                graphicView.invalidate();
            }
        });
    }

    private static class GraphicView extends View {
        public GraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.image256);
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
            cm.setSaturation(chroma);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            BlurMaskFilter bMask;
            EmbossMaskFilter eMask;
            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
            eMask = new EmbossMaskFilter(new float[] {3,3,3}, 0.5f, 5, 10);

            if (isBlur) paint.setMaskFilter(bMask);
            if (isEmbo) paint.setMaskFilter(eMask);

            canvas.drawBitmap(picture,x,y,paint);
            picture.recycle();
        }
    }
}