package com.example.imageviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.io.Console;

public class PictureView extends View {
    // PictureView에 보여줄 이미지 파일의 경로 및 파일 이름을 저장
    String imagePath = null;

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 이미지 파일의 경로 및 파일 이름이 저장된 경우
        if (imagePath != null) {

            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.scale(2,2);
            int w = ((getWidth()/2)-bitmap.getWidth())/2;
            int h = ((getHeight()/2)-bitmap.getHeight())/2;
            canvas.drawBitmap(bitmap, w, h, null);
            bitmap.recycle();
        }
    }
}
