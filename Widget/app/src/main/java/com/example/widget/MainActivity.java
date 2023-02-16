package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"test_apple", "test_banana", "test_pineapple", "mango", "coconut", "watermelon"};

        autoCompleteTextView = findViewById(R.id.auto);
        multiAutoCompleteTextView = findViewById(R.id.multi);

        // ArrayAdapter : 뷰와 데이터(배열)를 연결
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items);
        autoCompleteTextView.setAdapter(adapter); // ArrayAdapter 적용

        // CommaTokenizer : 쉼표로 구분
        MultiAutoCompleteTextView.CommaTokenizer commaTokenizer = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoCompleteTextView.setTokenizer(commaTokenizer);
        multiAutoCompleteTextView.setAdapter(adapter);
    }
}