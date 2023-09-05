package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzabg {
    public final boolean zzcph;
    public final zzabs zzcpi = null;
    public final zzhw zzcpj;
    public final zzaep zzcpk;
    public final zzmf zzcpl;
    public final zzacb zzcpm;
    public final zztj zzcpn;
    private zzacc zzcpo;
    public final zzacd zzcpp;
    public final zzwp zzcpq;
    public final zzaet zzcpr;
    public final zzabl zzcps;

    private zzabg(zzabs zzabs, zzhw zzhw, zzaep zzaep, zzmf zzmf, zzacb zzacb, zztj zztj, zzacc zzacc, zzacd zzacd, zzwp zzwp, zzaet zzaet, boolean z, zzabl zzabl) {
        this.zzcpj = zzhw;
        this.zzcpk = zzaep;
        this.zzcpl = zzmf;
        this.zzcpm = zzacb;
        this.zzcpn = zztj;
        this.zzcpo = zzacc;
        this.zzcpp = zzacd;
        this.zzcpq = zzwp;
        this.zzcpr = zzaet;
        this.zzcph = true;
        this.zzcps = zzabl;
    }

    public static zzabg zzl(Context context) {
        zzbs.zzfb().initialize(context);
        zzach zzach = new zzach(context);
        return new zzabg((zzabs) null, new zzhz(), new zzaeq(), new zzme(), new zzabz(context, zzach.zznl()), new zztk(), new zzacf(), new zzacg(), new zzwo(), new zzaer(), true, zzach);
    }
}
