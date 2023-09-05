package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.zzaec;
import com.google.android.gms.internal.zzaed;
import com.google.android.gms.internal.zzaei;
import com.google.android.gms.internal.zzakv;
import com.google.android.gms.internal.zzala;
import com.google.android.gms.internal.zzaln;
import com.google.android.gms.internal.zzaly;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zzv {
    public final zzaly zzanq;
    public final zzakv zzanr;
    public final zzaei zzans;
    public final zzig zzant;

    private zzv(zzaly zzaly, zzakv zzakv, zzaei zzaei, zzig zzig) {
        this.zzanq = zzaly;
        this.zzanr = zzakv;
        this.zzans = zzaei;
        this.zzant = zzig;
    }

    public static zzv zzd(Context context) {
        return new zzv(new zzaln(), new zzala(), new zzaec(new zzaed()), new zzig(context));
    }
}
