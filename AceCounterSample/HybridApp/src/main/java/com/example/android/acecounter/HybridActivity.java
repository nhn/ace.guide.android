package com.example.android.acecounter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.acecounter.android.acetm.AceTM;
import com.acecounter.android.acetm.webview.AceWebViewInterface;

public class HybridActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybrid);

        //TODO : 앱 내부에 html이 적재되는 경우 Cookie 허용이 필요합니다.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            CookieManager.setAcceptFileSchemeCookies(true);
        }

        //TODO : [주의] WebView 에 Acecounter+ WebScript 가 적용 된 경우 정확한 수집을 위하여 별도로 PageView를 수집하지 말아주세요.
        //TODO : [주의] WebApp 으로 사용되는 Activity 는 별도로 AceTM.pv를 삽입할 필요가 없습니다.
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new AceWebViewInterface(this), AceWebViewInterface.INTERFACE_NAME);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                AceTM.onPageFinished(view); //TODO : [필수] super 전에 호출해주세요.
                super.onPageFinished(view, url);
            }
        });

        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //TODO : [필수] 유입정보를 확인하기 위한 필수 설정입니다. 반드시 추가해주세요.
        AceTM.setNewIntent(this, intent);
    }
}
