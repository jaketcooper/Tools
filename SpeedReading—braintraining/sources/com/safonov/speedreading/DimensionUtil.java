package com.safonov.speedreading;

import android.content.Context;

public class DimensionUtil {
    public static int dpToPx(Context context, int dp) {
        return (int) ((((float) dp) * (context.getResources().getDisplayMetrics().xdpi / 160.0f)) + 0.5f);
    }

    public static int pxToDp(Context context, int px) {
        return (int) ((((float) px) / (context.getResources().getDisplayMetrics().xdpi / 160.0f)) + 0.5f);
    }
}
