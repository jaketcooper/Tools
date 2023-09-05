package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zze;
import java.util.HashMap;
import java.util.Map;

@zzzb
public final class zzamr extends zzkv {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private boolean zzbfk = true;
    private boolean zzbfl;
    private boolean zzbfm;
    /* access modifiers changed from: private */
    public zzkx zzcdw;
    /* access modifiers changed from: private */
    public final zzali zzdew;
    private final boolean zzdkd;
    private final boolean zzdke;
    private final float zzdkf;
    private int zzdkg;
    /* access modifiers changed from: private */
    public boolean zzdkh;
    private boolean zzdki = true;
    private float zzdkj;
    private float zzdkk;

    public zzamr(zzali zzali, float f, boolean z, boolean z2) {
        this.zzdew = zzali;
        this.zzdkf = f;
        this.zzdkd = z;
        this.zzdke = z2;
    }

    private final void zzc(String str, @Nullable Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbs.zzec();
        zzagr.runOnUiThread(new zzams(this, hashMap));
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzdkk;
        }
        return f;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzdkg;
        }
        return i;
    }

    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                if (this.zzbfm && this.zzdke) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdkd && this.zzbfl;
        }
        return z;
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdki;
        }
        return z;
    }

    public final void mute(boolean z) {
        zzc(z ? "mute" : "unmute", (Map<String, String>) null);
    }

    public final void pause() {
        zzc("pause", (Map<String, String>) null);
    }

    public final void play() {
        zzc("play", (Map<String, String>) null);
    }

    public final void zza(float f, int i, boolean z, float f2) {
        boolean z2;
        int i2;
        synchronized (this.lock) {
            this.zzdkj = f;
            z2 = this.zzdki;
            this.zzdki = z;
            i2 = this.zzdkg;
            this.zzdkg = i;
            this.zzdkk = f2;
        }
        zzbs.zzec();
        zzagr.runOnUiThread(new zzamt(this, i2, i, z2, z));
    }

    public final void zza(zzkx zzkx) {
        synchronized (this.lock) {
            this.zzcdw = zzkx;
        }
    }

    public final void zzb(zzma zzma) {
        synchronized (this.lock) {
            this.zzbfk = zzma.zzbfk;
            this.zzbfl = zzma.zzbfl;
            this.zzbfm = zzma.zzbfm;
        }
        zzc("initialState", zze.zza("muteStart", zzma.zzbfk ? "1" : "0", "customControlsRequested", zzma.zzbfl ? "1" : "0", "clickToExpandRequested", zzma.zzbfm ? "1" : "0"));
    }

    public final float zzib() {
        return this.zzdkf;
    }

    public final float zzic() {
        float f;
        synchronized (this.lock) {
            f = this.zzdkj;
        }
        return f;
    }

    public final zzkx zzid() throws RemoteException {
        zzkx zzkx;
        synchronized (this.lock) {
            zzkx = this.zzcdw;
        }
        return zzkx;
    }
}
