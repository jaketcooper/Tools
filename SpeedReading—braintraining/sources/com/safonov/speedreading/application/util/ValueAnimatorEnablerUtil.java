package com.safonov.speedreading.application.util;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.Method;

public class ValueAnimatorEnablerUtil {
    public static void init(Context context) {
        if (Build.VERSION.SDK_INT >= 17 && Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 0.0f) != 1.0f) {
            Class<ValueAnimator> cls = ValueAnimator.class;
            try {
                Method targetMethod = cls.getDeclaredMethod("setDurationScale", new Class[]{Float.TYPE});
                targetMethod.setAccessible(true);
                targetMethod.invoke((Object) null, new Object[]{Float.valueOf(1.0f)});
            } catch (Exception e) {
                Log.d("ValueAnimatorUtil", "setDurationScale failed: " + e.getMessage());
            }
        }
    }
}
