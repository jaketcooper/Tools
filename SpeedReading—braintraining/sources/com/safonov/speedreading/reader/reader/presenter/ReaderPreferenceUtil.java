package com.safonov.speedreading.reader.reader.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.speedreading.alexander.speedreading.R;

public class ReaderPreferenceUtil {
    private Context context;
    private SharedPreferences sharedPreferences;

    public ReaderPreferenceUtil(Context context2) {
        this.context = context2;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
    }

    public void setSpeed(int speed) {
        this.sharedPreferences.edit().putInt(this.context.getString(R.string.reader_settings_speed_key), speed).apply();
    }

    public int getSpeed() {
        return this.sharedPreferences.getInt(this.context.getString(R.string.reader_settings_speed_key), this.context.getResources().getInteger(R.integer.reader_settings_speed_default_value));
    }

    public void setShouldShowGuideDialog(boolean shouldShow) {
        this.sharedPreferences.edit().putBoolean(this.context.getString(R.string.reader_settings_show_guide_key), shouldShow).apply();
    }

    public boolean shouldShowGuideDialog() {
        return this.sharedPreferences.getBoolean(this.context.getString(R.string.reader_settings_show_guide_key), this.context.getResources().getBoolean(R.bool.reader_settings_show_guide_default_value));
    }

    public void setPencilSelectedLineCount(int selectedLineCount) {
        this.sharedPreferences.edit().putInt(this.context.getString(R.string.reader_pencil_frame_selected_line_count_key), selectedLineCount).apply();
    }

    public int getPencilSelectedLineCount() {
        return this.sharedPreferences.getInt(this.context.getString(R.string.reader_pencil_frame_selected_line_count_key), this.context.getResources().getInteger(R.integer.reader_pencil_frame_selected_line_count_default_value));
    }
}
