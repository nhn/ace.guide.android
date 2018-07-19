# AceCounter+ Android SDK
AceCounter+ 분석 서비스를 사용하기 위한 Android SDK 입니다.
* [AceCounter+ 서비스 페이지 바로가기](https://new.acecounter.com/common/front) 
* [설치 가이드 바로가기](https://github.com/nhnent/ace.guide.android/wiki)

# 간편 시작하기
AceCounter+를 가장 쉽게 이용하는 방법입니다.  

 `build.gradle`에 의존성 추가하기 :  
 ```java
 dependencies {
    //..중략..
    implementation project(':AceTM')
}
 ```

AndroidManifest.xml 에 `Application class` 추가 하기 :
```java
<application android:name=".MyApplication"/>
```

Application 클래스에서 `초기화`하기 :
```java
public class MyApplication extends Application {
    @Override 
    public void onCreate() {
        AceConfiguration aceConfiguration = new AceConfiguration.Builder(this)
            .setServiceId(this, R.string.acecounter_sid)
            .setAutoPageView(true)
            .build();
        AceTM.initialize(aceConfiguration);
    }
}
```
고객 아이디 보호를 위해 **ServiceId**는 `res/string`을 사용하실 것을 권장 해드립니다.

# FAQ
* [데이터 수집이 정상적으로 이루어지는지 확인하고 싶습니다.](../../wiki/99.FAQ#q--%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%88%98%EC%A7%91%EC%9D%B4-%EC%A0%95%EC%83%81%EC%A0%81%EC%9C%BC%EB%A1%9C-%EC%9D%B4%EB%A3%A8%EC%96%B4%EC%A7%80%EB%8A%94%EC%A7%80-%ED%99%95%EC%9D%B8%ED%95%98%EA%B3%A0-%EC%8B%B6%EC%8A%B5%EB%8B%88%EB%8B%A4)
* [데이터 수집이 안되는 것 같습니다.](../../wiki/99.FAQ#q--%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%88%98%EC%A7%91%EC%9D%B4-%EC%95%88%EB%90%98%EB%8A%94-%EA%B2%83-%EA%B0%99%EC%8A%B5%EB%8B%88%EB%8B%A4)
* [Deprecate 된 AceTM.init(), AceTM.onCreate()는 계속 사용해도 될까요??](../../wiki/99.FAQ#q--deprecate-%EB%90%9C-acetminit-acetmoncreate%EB%8A%94-%EA%B3%84%EC%86%8D-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%8F%84-%EB%90%A0%EA%B9%8C%EC%9A%94)
* [배포 전 설치 유입(Install Referrer)동작을 확인하고 싶습니다.](../../wiki/99.FAQ#q--%EB%B0%B0%ED%8F%AC-%EC%A0%84-%EC%84%A4%EC%B9%98-%EC%9C%A0%EC%9E%85install-referrer%EB%8F%99%EC%9E%91%EC%9D%84-%ED%99%95%EC%9D%B8%ED%95%98%EA%B3%A0-%EC%8B%B6%EC%8A%B5%EB%8B%88%EB%8B%A4)