package com.safonov.speedreading.application.notifications;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.p000v4.app.NotificationCompat;
import com.safonov.speedreading.main.activity.view.MenuActivity;
import com.speedreading.alexander.speedreading.R;
import java.util.Random;

public class MotivatorNotification {
    private static final String NOTIFICATION_TAG = "motivatorNotification";

    public static void notify(Context context) {
        Resources res = context.getResources();
        String title = res.getString(R.string.app_name);
        String[] motivators = res.getStringArray(R.array.motivators);
        String text = motivators[new Random().nextInt(motivators.length)];
        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText(text);
        notify(context, new NotificationCompat.Builder(context).setDefaults(-1).setSmallIcon(R.drawable.notification_icon).setContentTitle(title).setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, MenuActivity.class).putExtra("menuFragment", "favoritesMenuItem"), 134217728)).setStyle(bigText).setWhen(0).setPriority(1).setContentText(text).setAutoCancel(true).build());
    }

    @TargetApi(5)
    private static void notify(Context context, Notification notification) {
        ((NotificationManager) context.getSystemService("notification")).notify(NOTIFICATION_TAG.hashCode(), notification);
    }

    @TargetApi(5)
    public static void cancel(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(NOTIFICATION_TAG.hashCode());
    }
}
