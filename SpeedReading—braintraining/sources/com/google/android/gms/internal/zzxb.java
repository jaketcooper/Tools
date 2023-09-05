package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;

@zzzb
public abstract class zzxb extends zzafh {
    protected final Context mContext;
    protected final Object mLock = new Object();
    protected final zzxg zzchu;
    protected final zzaev zzchv;
    protected zzaad zzchw;
    protected final Object zzchy = new Object();

    protected zzxb(Context context, zzaev zzaev, zzxg zzxg) {
        super(true);
        this.mContext = context;
        this.zzchv = zzaev;
        this.zzchw = zzaev.zzcwe;
        this.zzchu = zzxg;
    }

    public void onStop() {
    }

    /* access modifiers changed from: protected */
    public abstract void zzd(long j) throws zzxe;

    public final void zzdg() {
        synchronized (this.mLock) {
            zzafj.zzbw("AdRendererBackgroundTask started.");
            int i = this.zzchv.errorCode;
            try {
                zzd(SystemClock.elapsedRealtime());
            } catch (zzxe e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzafj.zzcn(e.getMessage());
                } else {
                    zzafj.zzco(e.getMessage());
                }
                if (this.zzchw == null) {
                    this.zzchw = new zzaad(errorCode);
                } else {
                    this.zzchw = new zzaad(errorCode, this.zzchw.zzccb);
                }
                zzagr.zzczc.post(new zzxc(this));
                i = errorCode;
            }
            zzagr.zzczc.post(new zzxd(this, zzy(i)));
        }
    }

    /* access modifiers changed from: protected */
    public abstract zzaeu zzy(int i);
}
