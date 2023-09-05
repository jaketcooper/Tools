package com.safonov.speedreading.main;

import android.support.annotation.Nullable;

public enum MenuFragmentType {
    MAIN_MENU((String) null),
    PROFILE((String) null),
    SETTINGS(PROFILE),
    LIBRARY((String) null),
    FILE_EXPLORER(LIBRARY),
    BOOK_DETAIL(LIBRARY),
    TRAINING_MENU((String) null),
    ACCELERATOR_MENU(TRAINING_MENU),
    MOTIVATORS_MENU((String) null),
    DESCRIPTION(MOTIVATORS_MENU),
    RULES_OF_SUCCESS(MOTIVATORS_MENU),
    MOTIVATORS(MOTIVATORS_MENU),
    RECOMMENDATION(MOTIVATORS_MENU);
    
    @Nullable
    private final MenuFragmentType parent;

    private MenuFragmentType(@Nullable MenuFragmentType parent2) {
        this.parent = parent2;
    }

    @Nullable
    public MenuFragmentType getParent() {
        return this.parent;
    }
}
