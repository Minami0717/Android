package com.example.baemin;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class Address extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}
