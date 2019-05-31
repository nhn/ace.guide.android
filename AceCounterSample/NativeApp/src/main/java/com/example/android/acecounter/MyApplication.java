package com.example.android.acecounter;

import android.app.Application;

import com.acecounter.android.acetm.AceConfiguration;
import com.acecounter.android.acetm.AceTM;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AceConfiguration aceConfiguration = new AceConfiguration.Builder(this)
                //TODO : [필수] 보안을 위해 Resource ID를 사용하실 것을 권장해드립니다.
                .setServiceId("100341")
                //TODO : [선택] Activity의 PageView 자동 수집을 원하실 경우 setAutoPageView 를 true 로 설정 해주세요.
                .setAutoPageView(true)
                //TODO : [선택] 디버깅 로그를 보시려면 true로 설정해주세요
                //.setDebugMode(true)
                .build();

        AceTM.configure(aceConfiguration);
    }
}
