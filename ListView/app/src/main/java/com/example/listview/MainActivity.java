package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

        String[] ani = {"중2병","내여귀","내청코","러브라이브","논논비요리","어과초","소아온","리제로",
                        "유루유리","뱅드림","스파이패밀리","주문토끼","4구라","케이온"};
        ArrayList<String> aniList = new ArrayList<String>();

        ListView list = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,aniList);
        //list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setAdapter(adapter);

        EditText editText = findViewById(R.id.editText);
        Button add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aniList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                aniList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), ani[i], Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}