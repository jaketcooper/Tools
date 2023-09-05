package com.safonov.speedreading.application.notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.p000v4.app.NotificationCompat;
import android.util.Log;
import com.speedreading.alexander.speedreading.R;
import java.util.Calendar;

public class AlarmHandleService extends Service {
    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(this, NotificationStarterService.class), 134217728);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (sharedPreferences.getBoolean(getString(R.string.notifications_settings_notify_key), getResources().getBoolean(R.bool.notifications_settings_notify_default_value))) {
            int timeInMinutes = sharedPreferences.getInt(getString(R.string.notifications_settings_notify_time_key), getResources().getInteger(R.integer.notifications_settings_notify_time_default_value));
            int hours = timeInMinutes / 60;
            int minutes = timeInMinutes - (hours * 60);
            Log.d("NOTIFICATIONS", "AlarmHandleService hours " + hours + " min " + minutes);
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, hours);
            calendar.set(12, minutes);
            Log.d("NOTIFICATIONS", "Notify Time " + calendar.getTimeInMillis() + " Current Time From Calendar " + Calendar.getInstance().getTimeInMillis());
            if (calendar.getTimeInMillis() < Calendar.getInstance().getTimeInMillis()) {
                Log.d("NOTIFICATIONS", "Next Day");
                calendar.add(5, 1);
            }
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 86400000, pendingIntent);
        } else {
            alarmManager.cancel(pendingIntent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
