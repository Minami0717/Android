package com.example.activityboth;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText n1 = findViewById(R.id.n1);
        EditText n2 = findViewById(R.id.n2);
        RadioButton plus = findViewById(R.id.plus);
        RadioButton minus = findViewById(R.id.minus);
        RadioButton multi = findViewById(R.id.multi);
        RadioButton division = findViewById(R.id.division);
        Button calc = findViewById(R.id.calc);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mark = "";
                if (plus.isChecked())
                    mark = "plus";
                else if (minus.isChecked())
                    mark = "minus";
                else if (multi.isChecked())
                    mark = "multi";
                else if (division.isChecked())
                    mark = "division";

                Intent intent = new Intent(getApplicationContext(),Result.class);
                intent.putExtra("n1",Float.parseFloat(n1.getText().toString()));
                intent.putExtra("n2",Float.parseFloat(n2.getText().toString()));
                intent.putExtra("mark", mark);
                launcher.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    float value = result.getData().getFloatExtra("result",0);
                    Toast.makeText(getApplicationContext(), "결과 : " + value,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            float result = data.getFloatExtra("result", 0);
//            Toast.makeText(getApplicationContext(), "결과 :" + result, Toast.LENGTH_SHORT).show();
//        }
//    }
}