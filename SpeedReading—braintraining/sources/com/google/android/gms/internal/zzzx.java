package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

@zzzb
public final class zzzx extends zzzt implements zzf, zzg {
    private Context mContext;
    private final Object mLock = new Object();
    private zzaiy zzaov;
    private zzaka<zzzz> zzclh;
    private final zzzr zzcli;
    private zzzy zzcll;

    public zzzx(Context context, zzaiy zzaiy, zzaka<zzzz> zzaka, zzzr zzzr) {
        super(zzaka, zzzr);
        this.mContext = context;
        this.zzaov = zzaiy;
        this.zzclh = zzaka;
        this.zzcli = zzzr;
        this.zzcll = new zzzy(context, ((Boolean) zzbs.zzep().zzd(zzmq.zzbhr)).booleanValue() ? zzbs.zzet().zzqm() : context.getMainLooper(), this, this, this.zzaov.zzdca);
        this.zzcll.zzajy();
    }

    public final void onConnected(Bundle bundle) {
        zzmx();
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzafj.zzbw("Cannot connect to remote service, fallback to local instance.");
        new zzzw(this.mContext, this.zzclh, this.zzcli).zzmx();
        Bundle bundle = new Bundle();
        bundle.putString("action", "gms_connection_failed_fallback_to_local");
        zzbs.zzec().zzb(this.mContext, this.zzaov.zzcp, "gmob-apps", bundle, true);
    }

    public final void onConnectionSuspended(int i) {
        zzafj.zzbw("Disconnected from remote ad request service.");
    }

    public final void zzne() {
        synchronized (this.mLock) {
            if (this.zzcll.isConnected() || this.zzcll.isConnecting()) {
                this.zzcll.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public final zzaah zznf() {
        zzaah zzaah;
        synchronized (this.mLock) {
            try {
                zzaah = this.zzcll.zzng();
            } catch (DeadObjectException | IllegalStateException e) {
                zzaah = null;
            }
        }
        return zzaah;
    }
}
