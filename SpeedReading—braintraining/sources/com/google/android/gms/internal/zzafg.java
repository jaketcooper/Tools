package com.google.android.gms.internal;

import android.content.Context;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.math.BigInteger;
import java.util.Locale;

@zzzb
public final class zzafg {
    private static final Object sLock = new Object();
    private static String zzcyh;

    public static String zzc(Context context, String str, String str2) {
        String str3;
        synchronized (sLock) {
            if (zzcyh == null && !TextUtils.isEmpty(str)) {
                try {
                    ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
                    Class<?> cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
                    BigInteger bigInteger = new BigInteger(new byte[1]);
                    String[] split = str.split(",");
                    BigInteger bigInteger2 = bigInteger;
                    for (int i = 0; i < split.length; i++) {
                        zzbs.zzec();
                        if (zzagr.zza(classLoader, cls, split[i])) {
                            bigInteger2 = bigInteger2.setBit(i);
                        }
                    }
                    zzcyh = String.format(Locale.US, "%X", new Object[]{bigInteger2});
                } catch (Throwable th) {
                    zzcyh = NotificationCompat.CATEGORY_ERROR;
                }
            }
            str3 = zzcyh;
        }
        return str3;
    }

    public static String zzpr() {
        String str;
        synchronized (sLock) {
            str = zzcyh;
        }
        return str;
    }
}
