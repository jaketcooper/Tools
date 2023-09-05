package com.safonov.speedreading.reader.reader.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class ReaderSettingsFragment extends PreferenceFragmentCompat {
    public static ReaderSettingsFragment newInstance() {
        return new ReaderSettingsFragment();
    }

    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.reader_settings);
    }
}
