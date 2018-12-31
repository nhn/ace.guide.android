package com.example.android.acecounter.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.acecounter.android.acetm.AceTM;
import com.example.android.acecounter.HybridActivity;
import com.example.android.acecounter.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

//TODO : Google Firebase cloud messaging 의 예시 입니다. 아래 코드를 참조하여 직접 구현해주세요.
public class ExampleFcmReceiveService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Intent intent = new Intent(this, HybridActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //TODO : [필수] Push 데이터 유입을 위하여 아래의 코드를 추가해주세요.
        AceTM.initPushExtraData(intent, remoteMessage.getData());

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder;

        if (notificationManager != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                //TODO : [선택] Android Oreo 버전 부터는  NotificationChannel 을 구현 해주셔야 합니다.
                NotificationChannel channel = new NotificationChannel("FCM001", "FCM Test channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
                notificationBuilder = new NotificationCompat.Builder(this, channel.getId());
            } else {
                notificationBuilder = new NotificationCompat.Builder(this);
            }

            notificationBuilder
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("FCM Title")
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setDefaults(NotificationCompat.DEFAULT_VIBRATE);

            notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
        }
    }
}
