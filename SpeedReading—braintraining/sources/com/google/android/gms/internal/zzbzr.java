package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzr extends zzbzn<Long> {
    public zzbzr(int i, String str, Long l) {
        super(0, str, l);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final Long zza(zzbzv zzbzv) {
        try {
            return Long.valueOf(zzbzv.getLongFlagValue(getKey(), ((Long) zzip()).longValue(), getSource()));
        } catch (RemoteException e) {
            return (Long) zzip();
        }
    }
}
