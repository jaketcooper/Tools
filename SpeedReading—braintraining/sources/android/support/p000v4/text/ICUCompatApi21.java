package android.support.p000v4.text;

import android.support.annotation.RequiresApi;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

@RequiresApi(21)
/* renamed from: android.support.v4.text.ICUCompatApi21 */
class ICUCompatApi21 {
    private static final String TAG = "ICUCompatApi21";
    private static Method sAddLikelySubtagsMethod;

    ICUCompatApi21() {
    }

    static {
        try {
            sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        try {
            return ((Locale) sAddLikelySubtagsMethod.invoke((Object) null, new Object[]{locale})).getScript();
        } catch (InvocationTargetException e) {
            Log.w(TAG, e);
        } catch (IllegalAccessException e2) {
            Log.w(TAG, e2);
        }
        return locale.getScript();
    }
}
