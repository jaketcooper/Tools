package com.safonov.speedreading.training.fragment.flashword.settings;

import android.os.Bundle;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class FlashWordsSettingsFragment extends PreferenceFragmentCompat {
    public static FlashWordsSettingsFragment newInstance() {
        return new FlashWordsSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.flash_words_settings);
    }
}
