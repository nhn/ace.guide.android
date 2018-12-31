package com.example.android.acecounter.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.acecounter.android.acetm.AceTM;
import com.example.android.acecounter.MainActivity;
import com.example.android.acecounter.R;
import com.google.android.gms.gcm.GcmListenerService;

//TODO : Google Cloud Messaging 의 예시 입니다. 아래 코드를 참조하여 직접 구현해주세요.

/**
 * GcmListenerService는 deprecated 되었습니다.
 * <p>
 * 2019년 4월 11일 부터 gcm은 지원이 중단되오니 Firebase Cloud Messaging 으로 구현 하시기를 권장 드립니다.
 * <p>
 * 참고 : https://developers.google.com/cloud-messaging/android/android-migrate-fcm
 */

public class ExampleGcmReceiveService extends GcmListenerService {
    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        super.onMessageReceived(s, bundle);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //TODO : [필수] Push 데이터 유입을 위하여 아래의 코드를 추가해주세요.
        AceTM.initPushExtraData(intent, bundle);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        String title = bundle.getString("title");
        String message = bundle.getString("message");

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentTitle(title)
                .setContentText(message)
                .setSound(defaultSoundUri)
                .setVibrate(new long[]{500, 500})
                .setTicker("테스트 알림 창")
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
    }
}
