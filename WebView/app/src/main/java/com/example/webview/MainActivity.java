package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button1, button2;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        webView = findViewById(R.id.webView);

        // CustomWebViewClient를 WebView에 대입
        webView.setWebViewClient(new CustomWebViewClient());

        // WebSettings 클래스를 이용해서 줌 버튼 컨트롤이 화면에 출력
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("www.op.gg/summoners/kr/"+editText.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goBack();
            }
        });
    }

    // WebViewClient 상속해서 CustomWebViewClient 클래스 정의
    class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView wv, String url) {
            return super.shouldOverrideUrlLoading(wv, url);
        }
    }
}