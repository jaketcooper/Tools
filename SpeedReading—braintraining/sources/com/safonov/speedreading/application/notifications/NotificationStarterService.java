package com.safonov.speedreading.application.notifications;

import android.content.Context;
import android.content.Intent;
import android.support.p000v4.content.WakefulBroadcastReceiver;

public class NotificationStarterService extends WakefulBroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        MotivatorNotification.notify(context);
    }
}
