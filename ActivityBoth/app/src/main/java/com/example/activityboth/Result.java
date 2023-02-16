package com.example.activityboth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

public class Result extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("Second");

        Intent intent = getIntent();
        float n1 = intent.getFloatExtra("n1",0);
        float n2 = intent.getFloatExtra("n2",0);
        float result = 0;

        if (intent.getStringExtra("mark").equals("plus"))
            result = n1 + n2;
        else if (intent.getStringExtra("mark").equals("minus"))
            result = n1 - n2;
        else if (intent.getStringExtra("mark").equals("multi"))
            result = n1 * n2;
        else if (intent.getStringExtra("mark").equals("division"))
            result = n1 / n2;

        Button back = findViewById(R.id.back);
        float finalResult = result;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(getApplicationContext(),MainActivity.class);
                sendIntent.putExtra("result", finalResult);
                setResult(RESULT_OK,sendIntent);
                finish();
            }
        });
    }
}
