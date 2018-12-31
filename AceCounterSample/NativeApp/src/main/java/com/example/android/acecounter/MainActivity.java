package com.example.android.acecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.acecounter.android.acetm.AceTM;
import com.acecounter.android.acetm.parameter.AceProduct;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO : [선택] Application의 초기화 부분에서 자동 수집(setAutoPageView)을 사용하시지 않을 경우
        //아래의 코드를 각 Activity 마다 직접 입력해주셔야 합니다.

        //AceTM.pv(this);
        //또는 AceTM.pv(this, "MainActivity");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //TODO : [필수] 유입정보를 확인하기 위한 필수 설정입니다. 반드시 추가해주세요.
        AceTM.setNewIntent(this, intent);
    }

    /**
     * 일부 기능에 대한 예시입니다. 상세 기능은 메뉴얼을 참조 해주세요.
     * 실제 구현하실때 고객님 어플리케이션의 원하시는 위치에 코드를 삽입 해주시면 됩니다.
     */
    public void onClickSns(View view) {
        AceTM.sns(this, Integer.toString((int) (Math.random() * 100000)), "페이스북");
    }

    public void onClickTel(View view) {
        AceTM.tel(this, "010-1111-1111");
    }

    public void onClickNow(View view) {
        AceProduct product1 = new AceProduct("샤프랑 130ml", "10000", 2000, 4);
        AceTM.buyNow(this, product1);
    }

    public void onClickBuyList(View view) {
        AceProduct product4 = new AceProduct("샤프랑 130ml", "10000", 2000., 4);
        product4.addOption(new AceProduct.AceOption("20000", "하얀색", 2));
        product4.addOption(new AceProduct.AceOption("30000", "검은색", 4));
        AceTM.buyList(this, "신용카드", "P0001", 50000.0, product4);
    }

    public void onClickReview(View view) {
        AceTM.review(this, "P0001", "상품은 별로인데 배송은 빠릅니다.", 5);
    }

    public void onClickLogin(View view) {
        AceTM.login(this, "testUser", 25, AceTM.Gender.MAN);
    }
}
