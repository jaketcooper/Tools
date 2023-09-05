package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzbzp extends zzbzn<Boolean> {
    public zzbzp(int i, String str, Boolean bool) {
        super(0, str, bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Boolean zza(zzbzv zzbzv) {
        try {
            return Boolean.valueOf(zzbzv.getBooleanFlagValue(getKey(), ((Boolean) zzip()).booleanValue(), getSource()));
        } catch (RemoteException e) {
            return (Boolean) zzip();
        }
    }
}
