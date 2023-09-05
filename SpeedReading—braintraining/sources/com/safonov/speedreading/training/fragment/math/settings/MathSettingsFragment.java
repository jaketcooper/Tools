package com.safonov.speedreading.training.fragment.math.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class MathSettingsFragment extends PreferenceFragmentCompat {
    public static MathSettingsFragment newInstance() {
        return new MathSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.math_settings);
    }
}
