package com.safonov.speedreading.training.fragment.lineofsight.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class LineOfSightSettingsFragment extends PreferenceFragmentCompat {
    public static LineOfSightSettingsFragment newInstance() {
        return new LineOfSightSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.line_of_sight_settings);
    }
}
