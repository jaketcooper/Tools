package com.safonov.speedreading.main.fragment.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.preference.PreferenceDialogFragmentCompat;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

public class TimePreferenceFragmentDialogCompat extends PreferenceDialogFragmentCompat {
    private TimePicker timePicker = null;

    public static TimePreferenceFragmentDialogCompat newInstance(String key) {
        TimePreferenceFragmentDialogCompat fragment = new TimePreferenceFragmentDialogCompat();
        Bundle args = new Bundle(1);
        args.putString("key", key);
        fragment.setArguments(args);
        return fragment;
    }

    /* access modifiers changed from: protected */
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setTitle((CharSequence) null);
    }

    /* access modifiers changed from: protected */
    public View onCreateDialogView(Context context) {
        this.timePicker = new TimePicker(context);
        return this.timePicker;
    }

    /* access modifiers changed from: protected */
    public void onBindDialogView(View v) {
        super.onBindDialogView(v);
        this.timePicker.setIs24HourView(true);
        TimePreference pref = (TimePreference) getPreference();
        initTimePicker(pref.getHours(), pref.getMinutes());
    }

    private void initTimePicker(int hours, int minutes) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.timePicker.setHour(hours);
            this.timePicker.setMinute(minutes);
            return;
        }
        this.timePicker.setCurrentHour(Integer.valueOf(hours));
        this.timePicker.setCurrentMinute(Integer.valueOf(minutes));
    }

    public void onDialogClosed(boolean positiveResult) {
        int hours;
        int minutes;
        if (positiveResult) {
            TimePreference pref = (TimePreference) getPreference();
            if (Build.VERSION.SDK_INT >= 23) {
                hours = this.timePicker.getHour();
                minutes = this.timePicker.getMinute();
            } else {
                hours = this.timePicker.getCurrentHour().intValue();
                minutes = this.timePicker.getCurrentMinute().intValue();
            }
            Log.d("TimePreference", "onDialogClosed");
            int convertedValue = pref.convertToSaveFormat(hours, minutes);
            if (pref.callChangeListener(Integer.valueOf(convertedValue))) {
                pref.persist(convertedValue);
                pref.updateSummary();
            }
        }
    }
}
