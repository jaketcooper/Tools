package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

public final class zzo extends zze {
    private /* synthetic */ zzd zzfwq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzo(zzd zzd, @Nullable int i, Bundle bundle) {
        super(zzd, i, (Bundle) null);
        this.zzfwq = zzd;
    }

    /* access modifiers changed from: protected */
    public final boolean zzakg() {
        this.zzfwq.zzfwc.zzf(ConnectionResult.zzfii);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void zzj(ConnectionResult connectionResult) {
        this.zzfwq.zzfwc.zzf(connectionResult);
        this.zzfwq.onConnectionFailed(connectionResult);
    }
}
