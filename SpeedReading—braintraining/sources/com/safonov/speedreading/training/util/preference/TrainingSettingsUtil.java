package com.safonov.speedreading.training.util.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.speedreading.alexander.speedreading.R;

public class TrainingSettingsUtil {
    private Context context;
    private SharedPreferences sharedPreferences;

    public TrainingSettingsUtil(Context context2) {
        this.context = context2;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
    }

    public int getSchulteTableRowCount() {
        return Integer.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.schulte_table_settings_row_count_preference_key), this.context.getResources().getString(R.string.schulte_table_settings_row_count_preference_default_value))).intValue();
    }

    public int getSchulteTableColumnCount() {
        return Integer.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.schulte_table_settings_column_count_preference_key), this.context.getResources().getString(R.string.schulte_table_settings_column_count_preference_default_value))).intValue();
    }

    public boolean isSchulteTableFullscreen() {
        return this.sharedPreferences.getBoolean(this.context.getResources().getString(R.string.schulte_table_settings_fullscreen_preference_key), this.context.getResources().getBoolean(R.bool.schulte_table_settings_fullscreen_preference_default_value));
    }

    public int getLineOfSightRowCount() {
        return Integer.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.line_of_sight_settings_row_count_preference_key), this.context.getResources().getString(R.string.line_of_sight_settings_row_count_preference_default_value))).intValue();
    }

    public int getLineOfSightFieldType() {
        return Integer.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.line_of_sight_settings_field_type_preference_key), this.context.getResources().getString(R.string.line_of_sight_settings_field_type_preference_default_value))).intValue();
    }

    public long getGreenDotDuration() {
        return Long.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.green_dot_settings_duration_key), this.context.getResources().getString(R.string.green_dot_settings_duration_default_value))).longValue();
    }

    public long getWordsColumnsDuration() {
        return Long.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.accelerator_settings_duration_key), this.context.getResources().getString(R.string.accelerator_settings_duration_default_value))).longValue();
    }

    public int getWordsColumnsColumnCount() {
        return Integer.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.accelerator_settings_column_count_key), this.context.getResources().getString(R.string.accelerator_settings_column_count_default_value))).intValue();
    }

    public long getFlashWordsDuration() {
        return Long.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.flash_words_settings_duration_key), this.context.getResources().getString(R.string.flash_words_settings_duration_default_value))).longValue();
    }

    public long getMathDuration() {
        return Long.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.math_settings_duration_key), this.context.getResources().getString(R.string.math_settings_duration_default_value))).longValue();
    }

    public long getCupTimerDuration() {
        return Long.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.cup_timer_settings_duration_key), this.context.getResources().getString(R.string.cup_timer_settings_duration_default_value))).longValue();
    }

    public int getCupTimerType() {
        return Integer.valueOf(this.sharedPreferences.getString(this.context.getResources().getString(R.string.cup_timer_settings_type_key), this.context.getResources().getString(R.string.cup_timer_settings_type_default_value))).intValue();
    }

    public int getFlashWordsBoardType() {
        return 1;
    }
}
