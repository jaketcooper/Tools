package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzq extends zzbzn<Integer> {
    public zzbzq(int i, String str, Integer num) {
        super(0, str, num);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final Integer zza(zzbzv zzbzv) {
        try {
            return Integer.valueOf(zzbzv.getIntFlagValue(getKey(), ((Integer) zzip()).intValue(), getSource()));
        } catch (RemoteException e) {
            return (Integer) zzip();
        }
    }
}
