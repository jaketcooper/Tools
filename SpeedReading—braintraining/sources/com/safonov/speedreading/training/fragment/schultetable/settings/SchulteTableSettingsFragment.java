package com.safonov.speedreading.training.fragment.schultetable.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class SchulteTableSettingsFragment extends PreferenceFragmentCompat {
    public static SchulteTableSettingsFragment newInstance() {
        return new SchulteTableSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.schulte_table_settings);
    }
}
