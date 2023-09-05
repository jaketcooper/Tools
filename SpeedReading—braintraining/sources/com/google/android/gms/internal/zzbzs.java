package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzs extends zzbzn<String> {
    public zzbzs(int i, String str, String str2) {
        super(0, str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final String zza(zzbzv zzbzv) {
        try {
            return zzbzv.getStringFlagValue(getKey(), (String) zzip(), getSource());
        } catch (RemoteException e) {
            return (String) zzip();
        }
    }
}
