package com.example.android.acecounter;

import android.app.Application;

import com.acecounter.android.acetm.AceConfiguration;
import com.acecounter.android.acetm.AceTM;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AceConfiguration aceConfiguration = new AceConfiguration.Builder(this)
                .setServiceId("100341")
                //TODO : [주의] Activity 의 WebView 에 AceCounter+ WebScript 가 적용 된 경우 정확한 수집을 위하여 ignore 항목으로 등록 해주세요.
                //.setAutoPageView(true, HybridActivity.class)
                //TODO : [선택] 디버깅 로그를 보시려면 true로 설정해주세요
                //.setDebugMode(true)
                .build();

        AceTM.configure(aceConfiguration);
    }
}
