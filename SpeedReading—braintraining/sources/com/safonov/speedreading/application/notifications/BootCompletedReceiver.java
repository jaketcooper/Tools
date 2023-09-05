package com.safonov.speedreading.application.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class BootCompletedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED") && Build.VERSION.SDK_INT < 26) {
            context.startService(new Intent(context, AlarmHandleService.class));
        }
    }
}
