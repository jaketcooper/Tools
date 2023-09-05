package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzzb
public abstract class zzgz {
    @Nullable
    private static MessageDigest zzazi = null;
    protected Object mLock = new Object();

    /* access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zzha() {
        MessageDigest messageDigest;
        synchronized (this.mLock) {
            if (zzazi != null) {
                messageDigest = zzazi;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        zzazi = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = zzazi;
            }
        }
        return messageDigest;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] zzx(String str);
}
