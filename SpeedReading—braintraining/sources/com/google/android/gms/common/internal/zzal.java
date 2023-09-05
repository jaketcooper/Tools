package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzal {
    private static int zzfym = 15;
    private static final String zzfyn = null;
    private final String zzfyo;
    private final String zzfyp;

    public zzal(String str) {
        this(str, (String) null);
    }

    public zzal(String str, String str2) {
        zzbq.checkNotNull(str, "log tag cannot be null");
        zzbq.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zzfyo = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzfyp = null;
        } else {
            this.zzfyp = str2;
        }
    }

    private final boolean zzci(int i) {
        return Log.isLoggable(this.zzfyo, i);
    }

    private final String zzgh(String str) {
        return this.zzfyp == null ? str : this.zzfyp.concat(str);
    }

    private final String zzh(String str, Object... objArr) {
        String format = String.format(str, objArr);
        return this.zzfyp == null ? format : this.zzfyp.concat(format);
    }

    public final void zzb(String str, String str2, Throwable th) {
        if (zzci(4)) {
            Log.i(str, zzgh(str2), th);
        }
    }

    public final void zzb(String str, String str2, Object... objArr) {
        if (zzci(3)) {
            Log.d(str, zzh(str2, objArr));
        }
    }

    public final void zzc(String str, String str2, Throwable th) {
        if (zzci(5)) {
            Log.w(str, zzgh(str2), th);
        }
    }

    public final void zzc(String str, String str2, Object... objArr) {
        if (zzci(5)) {
            Log.w(this.zzfyo, zzh(str2, objArr));
        }
    }

    public final void zzd(String str, String str2, Throwable th) {
        if (zzci(6)) {
            Log.e(str, zzgh(str2), th);
        }
    }

    public final void zzd(String str, String str2, Object... objArr) {
        if (zzci(6)) {
            Log.e(str, zzh(str2, objArr));
        }
    }

    public final void zzu(String str, String str2) {
        if (zzci(3)) {
            Log.d(str, zzgh(str2));
        }
    }

    public final void zzv(String str, String str2) {
        if (zzci(5)) {
            Log.w(str, zzgh(str2));
        }
    }

    public final void zzw(String str, String str2) {
        if (zzci(6)) {
            Log.e(str, zzgh(str2));
        }
    }
}
