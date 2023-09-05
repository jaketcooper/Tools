package com.p005rd;

import android.os.Build;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.rd.Utils */
public class Utils {
    private static final AtomicInteger nextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        if (Build.VERSION.SDK_INT < 17) {
            return generateId();
        }
        return View.generateViewId();
    }

    private static int generateId() {
        int result;
        int newValue;
        do {
            result = nextGeneratedId.get();
            newValue = result + 1;
            if (newValue > 16777215) {
                newValue = 1;
            }
        } while (!nextGeneratedId.compareAndSet(result, newValue));
        return result;
    }
}
