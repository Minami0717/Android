package com.example.bitmapimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicView(this));
    }

    private static class GraphicView extends View {
        public GraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
            canvas.scale(0.5f,0.5f);
            int x = ((getWidth()*2) - picture.getWidth()) / 2;
            int y = ((getHeight()*2) - picture.getHeight()) / 2;
            int cenX = getWidth();
            int cenY = getHeight();
            //canvas.rotate(45, cenX, cenY);
            //canvas.translate(100,300);
            //canvas.skew(0.3f,0.3f);

            Paint paint = new Paint();
            float[] array = {3,0,0,0,0,
                             0,3,0,0,0,
                             0,0,3,0,0,
                             0,0,0,1,0};
            ColorMatrix cm = new ColorMatrix(array);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            //paint.setColor(Color.GRAY);
            BlurMaskFilter mask1;
            EmbossMaskFilter mask2;

            mask1 = new BlurMaskFilter(300, BlurMaskFilter.Blur.SOLID);
            mask2 = new EmbossMaskFilter(new float[] {3,3,10}, 1, 1, 10);
            //paint.setMaskFilter(mask2);
            //canvas.drawCircle(cenX,cenY,500,paint);
            canvas.drawBitmap(picture, x, y,paint);
            //picture.recycle();
        }
    }
}