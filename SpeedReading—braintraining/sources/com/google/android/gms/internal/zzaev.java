package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONObject;

@zzzb
public final class zzaev {
    public final int errorCode;
    @Nullable
    public final zziw zzath;
    public final zzzz zzcpe;
    @Nullable
    public final JSONObject zzcvq;
    public final zztn zzcvs;
    public final long zzcvw;
    public final long zzcvx;
    public final zzib zzcwc;
    public final boolean zzcwd;
    public final zzaad zzcwe;

    public zzaev(zzzz zzzz, zzaad zzaad, zztn zztn, zziw zziw, int i, long j, long j2, JSONObject jSONObject, zzib zzib, @Nullable Boolean bool) {
        this.zzcpe = zzzz;
        this.zzcwe = zzaad;
        this.zzcvs = zztn;
        this.zzath = zziw;
        this.errorCode = i;
        this.zzcvw = j;
        this.zzcvx = j2;
        this.zzcvq = jSONObject;
        this.zzcwc = zzib;
        if (bool != null) {
            this.zzcwd = bool.booleanValue();
            return;
        }
        zzbs.zzec();
        if (zzagr.zzp(zzzz.zzclo)) {
            this.zzcwd = true;
        } else {
            this.zzcwd = false;
        }
    }

    public zzaev(zzzz zzzz, zzaad zzaad, zztn zztn, zziw zziw, int i, long j, long j2, JSONObject jSONObject, zzig zzig) {
        this.zzcpe = zzzz;
        this.zzcwe = zzaad;
        this.zzcvs = null;
        this.zzath = null;
        this.errorCode = i;
        this.zzcvw = j;
        this.zzcvx = j2;
        this.zzcvq = null;
        this.zzcwc = new zzib(zzig, ((Boolean) zzbs.zzep().zzd(zzmq.zzbpk)).booleanValue());
        this.zzcwd = false;
    }
}
