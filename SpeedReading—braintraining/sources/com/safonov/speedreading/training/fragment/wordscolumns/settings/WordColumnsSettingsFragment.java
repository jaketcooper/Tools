package com.safonov.speedreading.training.fragment.wordscolumns.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class WordColumnsSettingsFragment extends PreferenceFragmentCompat {
    public static WordColumnsSettingsFragment newInstance() {
        return new WordColumnsSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.word_columns_settings);
    }
}
