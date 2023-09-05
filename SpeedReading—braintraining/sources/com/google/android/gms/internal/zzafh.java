package com.google.android.gms.internal;

@zzzb
public abstract class zzafh implements zzahi<zzajp> {
    /* access modifiers changed from: private */
    public volatile Thread zzcyi;
    private boolean zzcyj = false;
    private final Runnable zzv = new zzafi(this);

    public zzafh() {
    }

    public zzafh(boolean z) {
    }

    public final void cancel() {
        onStop();
        if (this.zzcyi != null) {
            this.zzcyi.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzdg();

    public final /* synthetic */ Object zzmx() {
        return this.zzcyj ? zzagl.zza(1, this.zzv) : zzagl.zza(this.zzv);
    }

    public final zzajp zzps() {
        return this.zzcyj ? zzagl.zza(1, this.zzv) : zzagl.zza(this.zzv);
    }
}
