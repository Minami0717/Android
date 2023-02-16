package com.example.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml에서 생성한 TabHost
        tabHost = getTabHost();

        // 탭스펙(탭을 구성하는 요소) 생성
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("image0").setIndicator("이미지1");
        tabSpec1.setContent(R.id.image0);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("image1").setIndicator("이미지2");
        tabSpec2.setContent(R.id.image1);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("image2").setIndicator("이미지3");
        tabSpec3.setContent(R.id.image2);
        tabHost.addTab(tabSpec3);

        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("image3").setIndicator("이미지4");
        tabSpec4.setContent(R.id.image3);
        tabHost.addTab(tabSpec4);

        tabHost.setCurrentTab(0);
    }
}