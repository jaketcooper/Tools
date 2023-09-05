package com.safonov.speedreading.training.fragment.greendot.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class GreenDotSettingsFragment extends PreferenceFragmentCompat {
    public static GreenDotSettingsFragment newInstance() {
        return new GreenDotSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.green_dot_settings);
    }
}
