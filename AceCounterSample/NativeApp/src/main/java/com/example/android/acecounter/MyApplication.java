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
                .setServiceId(this, R.string.acecouneter_sid)
                //TODO : [선택] Activity의 PageView 자동 수집을 원하실 경우 setAutoPageView 를 true 로 설정 해주세요.
                .setAutoPageView(true)
                //TODO : [선택] 디버깅 로그를 보시려면 true로 설정해주세요
                //.setDebugMode(true)
                .build();

        AceTM.initialize(aceConfiguration);

        /**
         * [AutoPageView 사용 가이드]
         *
         * @name setAutoPageView
         * @param boolean autoPv 활성화 여부
         * @param Class<?>... ignoreActivity PageView 전송을 제외할 Activity 목록
         *
         * ignoreActivity 에는 PageView 를 수집할 필요가 없는 Activity 를 넣어주시면 됩니다.
         * 예) IntroActivity, SplashActivity, WebActivity
         */

        /**
         * [Proguard, Dexguard 사용자]
         *
         * 난독화 툴을 사용할 경우 Activity 이름이 변경되여 올바른 결과를 수집할 수 없습니다.
         * 이 경우에는 2가지 방법 있습니다.
         *
         * 1. Keenames 룰에 'Activity'를 포함한 이름을 keep 하도록 설정
         *   -keepnames **Activity;
         *
         * 2. PageView 직접 수집
         *   - setAutoPageView = false 설정
         *   - 수집이 필요한 모든 Activity 의 onCreate 영역에 AceTM.pv(this, "Activity Name"); 삽입
         */
    }
}
