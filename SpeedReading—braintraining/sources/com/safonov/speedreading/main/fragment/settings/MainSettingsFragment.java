package com.safonov.speedreading.main.fragment.settings;

import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p003v7.preference.Preference;
import android.support.p003v7.preference.PreferenceFragmentCompat;
import com.speedreading.alexander.speedreading.R;

public class MainSettingsFragment extends PreferenceFragmentCompat {
    public static MainSettingsFragment newInstance() {
        return new MainSettingsFragment();
    }

    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.main_settings);
    }

    public void onDisplayPreferenceDialog(Preference preference) {
        DialogFragment dialogFragment = null;
        if (preference instanceof TimePreference) {
            dialogFragment = TimePreferenceFragmentDialogCompat.newInstance(preference.getKey());
        }
        if (dialogFragment != null) {
            dialogFragment.setTargetFragment(this, 0);
            dialogFragment.show(getFragmentManager(), "android.support.v7.preference.PreferenceFragment.DIALOG");
            return;
        }
        super.onDisplayPreferenceDialog(preference);
    }
}
