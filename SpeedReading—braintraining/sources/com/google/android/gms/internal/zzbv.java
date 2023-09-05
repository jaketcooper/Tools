package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class zzbv implements Runnable {
    private zzbv() {
    }

    public final void run() {
        try {
            MessageDigest unused = zzbt.zzyq = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        } finally {
            zzbt.zzyt.countDown();
        }
    }
}
