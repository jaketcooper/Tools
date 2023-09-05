package com.safonov.speedreading.main.fragment.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.p003v7.preference.DialogPreference;
import android.util.AttributeSet;
import android.util.Log;

public class TimePreference extends DialogPreference {
    private static final int DEFAULT_VALUE = 1170;
    private static final int MINUTES_PER_HOUR = 60;
    private int timeInMinutes;

    public TimePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("TimePreference", "TimePreference");
    }

    private String timeToString() {
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(getHours()), Integer.valueOf(getMinutes())});
    }

    public void updateSummary() {
        setSummary((CharSequence) timeToString());
        Log.d("TimePreference", "updateSummary");
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray a, int index) {
        Log.d("TimePreference", "onGetDefaultValue");
        return Integer.valueOf(a.getInteger(index, DEFAULT_VALUE));
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(boolean restoreValue, Object defaultValue) {
        if (restoreValue) {
            Log.d("TimePreference", "restoreValue");
            this.timeInMinutes = getPersistedInt(DEFAULT_VALUE);
        } else {
            this.timeInMinutes = ((Integer) defaultValue).intValue();
            Log.d("TimePreference", "Not restoreValue");
            persistInt(this.timeInMinutes);
        }
        updateSummary();
    }

    public int getMinutes() {
        return this.timeInMinutes - ((this.timeInMinutes / 60) * 60);
    }

    public int getHours() {
        return this.timeInMinutes / 60;
    }

    public int convertToSaveFormat(int hours, int minutes) {
        return (hours * 60) + minutes;
    }

    public void persist(int convertedValue) {
        this.timeInMinutes = convertedValue;
        persistInt(convertedValue);
    }
}
