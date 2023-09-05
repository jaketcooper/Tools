package com.safonov.speedreading.training.fragment.cuptimer.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class CupTimerSettingsFragment extends PreferenceFragmentCompat {
    public static CupTimerSettingsFragment newInstance() {
        return new CupTimerSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.cup_timer_settings);
    }
}
