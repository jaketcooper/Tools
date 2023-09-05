package com.safonov.speedreading.training;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.annotation.XmlRes;

public enum TrainingType2 {
    ;
    
    @LayoutRes
    private final int descriptionView;
    private final boolean isRes;
    private final boolean isSettingsSupported;
    @XmlRes
    private final int settingsView;
    @StringRes
    private final int title;

    public int getTitle() {
        return this.title;
    }

    public int getDescriptionView() {
        return this.descriptionView;
    }

    public boolean isRes() {
        return this.isRes;
    }

    public boolean isSettingsSupported() {
        return this.isSettingsSupported;
    }

    public int getSettingsView() {
        return this.settingsView;
    }

    private TrainingType2(int title2, int descriptionView2, boolean isRes2, boolean isSettingsSupported2, int settingsView2) {
        this.title = title2;
        this.descriptionView = descriptionView2;
        this.isRes = isRes2;
        this.isSettingsSupported = isSettingsSupported2;
        this.settingsView = settingsView2;
    }
}
