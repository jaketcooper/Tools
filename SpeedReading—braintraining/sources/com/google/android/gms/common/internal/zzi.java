package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class zzi<TListener> {
    private TListener zzfsa;
    private /* synthetic */ zzd zzfwq;
    private boolean zzfwr = false;

    public zzi(zzd zzd, TListener tlistener) {
        this.zzfwq = zzd;
        this.zzfsa = tlistener;
    }

    public final void removeListener() {
        synchronized (this) {
            this.zzfsa = null;
        }
    }

    public final void unregister() {
        removeListener();
        synchronized (this.zzfwq.zzfwe) {
            this.zzfwq.zzfwe.remove(this);
        }
    }

    public final void zzakh() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.zzfsa;
            if (this.zzfwr) {
                String valueOf = String.valueOf(this);
                Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
            }
        }
        if (tlistener != null) {
            try {
                zzv(tlistener);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.zzfwr = true;
        }
        unregister();
    }

    /* access modifiers changed from: protected */
    public abstract void zzv(TListener tlistener);
}
