package com.example.galleryposter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 애니 포스터");

        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter galleryAdapter = new GalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);
    }

    public class GalleryAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {R.drawable.ani01,R.drawable.ani02,R.drawable.ani03,R.drawable.ani04
                ,R.drawable.ani05,R.drawable.ani06,R.drawable.ani07,R.drawable.ani08
                ,R.drawable.ani09,R.drawable.ani10};
        String[] aniName = {"귀멸의 칼날","스파이 패밀리","소드 아트 온라인","던만추",
        "문호 스트레이독스","카구야","전여친","러브라이브","오소마츠상","주문은 토끼입니까"};

        public GalleryAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[i]);

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView poster = findViewById(R.id.poster);
                    poster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    poster.setImageResource(posterID[i]);

                    Toast toast = new Toast(MainActivity.this);
                    View toastView = View.inflate(MainActivity.this,R.layout.toast,null);
                    TextView toastText = toastView.findViewById(R.id.aniName);
                    toastText.setText(aniName[i]);
                    toast.setView(toastView);
                    toast.show();

                    return false;
                }
            });

            return imageView;
        }
    }
}