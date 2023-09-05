package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public final class zzk extends zzax {
    private zzd zzfws;
    private final int zzfwt;

    public zzk(@NonNull zzd zzd, int i) {
        this.zzfws = zzd;
        this.zzfwt = i;
    }

    @BinderThread
    public final void zza(int i, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @BinderThread
    public final void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        zzbq.checkNotNull(this.zzfws, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zzfws.zza(i, iBinder, bundle, this.zzfwt);
        this.zzfws = null;
    }
}
