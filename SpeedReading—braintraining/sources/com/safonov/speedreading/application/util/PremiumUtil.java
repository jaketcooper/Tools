package com.safonov.speedreading.application.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PremiumUtil {
    private static final String PREMIUM_USER_KEY = "premium_user";
    public static final String PREMIUM_USER_SKU = "com.speedreading.alexander.speedreading.premiumsub";
    public static final String PREMIUM_USER_SKU_HALF_YEAR = "com.speedreading.alexander.speedreading.premium.subscription.halfyear";
    public static final String PREMIUM_USER_SKU_MONTH = "com.speedreading.alexander.speedreading.premium.subscription.month";
    public static final String PREMIUM_USER_SKU_UNSUB = "com.speedreading.alexander.speedreading.premium";
    public static final String PREMIUM_USER_SKU_YEAR = "com.speedreading.alexander.speedreading.premium.subscription.year";
    private boolean premiumUser = this.sharedPreferences.getBoolean(PREMIUM_USER_KEY, false);
    private SharedPreferences sharedPreferences;

    public boolean isPremiumUser() {
        return this.premiumUser;
    }

    public void setPremiumUser(boolean premiumUser2) {
        this.premiumUser = premiumUser2;
        this.sharedPreferences.edit().putBoolean(PREMIUM_USER_KEY, premiumUser2).apply();
    }

    public PremiumUtil(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
}
