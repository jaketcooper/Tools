package com.p005rd.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* renamed from: com.rd.utils.DensityUtils */
public class DensityUtils {
    public static int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(1, (float) dp, Resources.getSystem().getDisplayMetrics());
    }

    public static int pxToDp(float px) {
        return (int) TypedValue.applyDimension(0, px, Resources.getSystem().getDisplayMetrics());
    }
}
