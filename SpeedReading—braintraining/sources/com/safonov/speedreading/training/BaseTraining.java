package com.safonov.speedreading.training;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

public abstract class BaseTraining {
    @LayoutRes
    public final int descriptionView;
    @Nullable
    @LayoutRes
    public final int settingsView;
    @StringRes
    public final int title;

    public BaseTraining(int title2, int descriptionView2, int settingsView2) {
        this.title = title2;
        this.descriptionView = descriptionView2;
        this.settingsView = settingsView2;
    }

    public int getTitle() {
        return this.title;
    }

    public int getDescriptionView() {
        return this.descriptionView;
    }

    @Nullable
    public int getSettingsView() {
        return this.settingsView;
    }
}
