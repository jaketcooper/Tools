package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

@zzzb
public abstract class zzzt implements zzahi<Void>, zzzr {
    private final Object mLock = new Object();
    private final zzaka<zzzz> zzclh;
    private final zzzr zzcli;

    public zzzt(zzaka<zzzz> zzaka, zzzr zzzr) {
        this.zzclh = zzaka;
        this.zzcli = zzzr;
    }

    public final void cancel() {
        zzne();
    }

    public final void zza(zzaad zzaad) {
        synchronized (this.mLock) {
            this.zzcli.zza(zzaad);
            zzne();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzaah zzaah, zzzz zzzz) {
        try {
            zzaah.zza(zzzz, (zzaak) new zzaac(this));
            return true;
        } catch (Throwable th) {
            zzafj.zzc("Could not fetch ad response from ad request service due to an Exception.", th);
            zzbs.zzeg().zza(th, "AdRequestClientTask.getAdResponseFromService");
            this.zzcli.zza(new zzaad(0));
            return false;
        }
    }

    public final /* synthetic */ Object zzmx() {
        zzaah zznf = zznf();
        if (zznf == null) {
            this.zzcli.zza(new zzaad(0));
            zzne();
        } else {
            this.zzclh.zza(new zzzu(this, zznf), new zzzv(this));
        }
        return null;
    }

    public abstract void zzne();

    public abstract zzaah zznf();
}
