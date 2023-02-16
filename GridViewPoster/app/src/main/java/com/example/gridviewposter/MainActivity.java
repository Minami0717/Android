package com.example.gridviewposter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 애니 포스터");

        GridView gridView = findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);
    }

    public class GridAdapter extends BaseAdapter {
        Context context;
        public GridAdapter(Context c) {
            context = c;
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
        Integer[] posterID = {R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,R.drawable.ani01,
                R.drawable.ani01};
        String[] aniName = {"귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날",
                "귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날",
                "귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날",
                "귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날",
                "귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날",
                "귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날","귀멸의 칼날"};
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[i]);
            final int pos = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialog = View.inflate(MainActivity.this, R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView poster = dialog.findViewById(R.id.poster);
                    poster.setImageResource(posterID[pos]);
                    dlg.setTitle(aniName[pos]);
                    dlg.setIcon(R.drawable.ani01);
                    dlg.setView(dialog);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });
            return imageView;
        }
    }
}