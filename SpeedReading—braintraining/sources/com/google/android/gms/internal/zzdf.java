package com.google.android.gms.internal;

import android.os.Looper;
import android.util.DisplayMetrics;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

public final class zzdf {
    private static final char[] zzaji = "0123456789abcdef".toCharArray();

    public static long zza(double d, int i, DisplayMetrics displayMetrics) {
        return Math.round((((double) i) * d) / ((double) displayMetrics.density));
    }

    public static String zza(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzdtf.zza(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean zza(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static Long zzar() {
        return Long.valueOf(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")).getTime().getTime());
    }

    public static boolean zzas() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String zzm(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return zzbr.zza(bArr, true);
    }

    public static boolean zzn(String str) {
        return str == null || str.isEmpty();
    }
}
