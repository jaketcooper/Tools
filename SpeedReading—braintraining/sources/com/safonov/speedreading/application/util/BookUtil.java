package com.safonov.speedreading.application.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BookUtil {
    private static final String BOOK_KEY = "speed_reading_book";
    public static final String BOOK_SKU = "com.speedreading.alexander.speedreading.book";
    private boolean bookPurchased = this.sharedPreferences.getBoolean(BOOK_KEY, false);
    private SharedPreferences sharedPreferences;

    public boolean isBookPurchased() {
        return this.bookPurchased;
    }

    public void setBookPurchased(boolean bookPurchased2) {
        this.bookPurchased = bookPurchased2;
        this.sharedPreferences.edit().putBoolean(BOOK_KEY, bookPurchased2).apply();
    }

    public BookUtil(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
}
