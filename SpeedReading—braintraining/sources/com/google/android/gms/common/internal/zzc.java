package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class zzc {
    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzga(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e("Asserts", new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length()).append("checkMainThread: current thread ").append(valueOf).append(" IS NOT the main thread ").append(valueOf2).append("!").toString());
            throw new IllegalStateException(str);
        }
    }

    public static void zzu(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }
}
