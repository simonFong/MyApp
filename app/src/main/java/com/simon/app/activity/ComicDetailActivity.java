package com.simon.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.simon.app.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ComicDetailActivity extends AppCompatActivity {

    @InjectView(R.id.webview)
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWebview.loadUrl(url);

    }
}
