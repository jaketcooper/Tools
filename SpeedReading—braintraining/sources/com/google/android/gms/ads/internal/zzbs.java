package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.p004js.zzb;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzabw;
import com.google.android.gms.internal.zzael;
import com.google.android.gms.internal.zzaez;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzagw;
import com.google.android.gms.internal.zzahb;
import com.google.android.gms.internal.zzahc;
import com.google.android.gms.internal.zzahd;
import com.google.android.gms.internal.zzahe;
import com.google.android.gms.internal.zzahf;
import com.google.android.gms.internal.zzahg;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzahp;
import com.google.android.gms.internal.zzaii;
import com.google.android.gms.internal.zzaij;
import com.google.android.gms.internal.zzajz;
import com.google.android.gms.internal.zzakg;
import com.google.android.gms.internal.zzals;
import com.google.android.gms.internal.zzamk;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzhm;
import com.google.android.gms.internal.zzia;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzmv;
import com.google.android.gms.internal.zzsl;
import com.google.android.gms.internal.zzsv;
import com.google.android.gms.internal.zztv;
import com.google.android.gms.internal.zzxf;
import com.google.android.gms.internal.zzzb;
import com.google.android.gms.internal.zzzc;

@zzzb
public final class zzbs {
    private static final Object sLock = new Object();
    private static zzbs zzarr;
    private final zza zzars = new zza();
    private final zzzc zzart = new zzzc();
    private final zzl zzaru = new zzl();
    private final zzxf zzarv = new zzxf();
    private final zzagr zzarw = new zzagr();
    private final zzamk zzarx = new zzamk();
    private final zzagw zzary;
    private final zzgp zzarz;
    private final zzaez zzasa;
    private final zzhl zzasb;
    private final zzhm zzasc;
    private final zzd zzasd;
    private final zzac zzase;
    private final zzmv zzasf;
    private final zzahp zzasg;
    private final zzabw zzash;
    private final zzmm zzasi;
    private final zzmn zzasj;
    private final zzmo zzask;
    private final zzajz zzasl;
    private final zzsl zzasm;
    private final zzsv zzasn;
    private final zzaii zzaso;
    private final zzr zzasp;
    private final zzs zzasq;
    private final zztv zzasr;
    private final zzaij zzass;
    private final zzaz zzast;
    private final zzia zzasu;
    private final zzael zzasv;
    private final zzals zzasw;
    private final zzakg zzasx;
    private final zzb zzasy;
    private final zzahh zzasz;

    static {
        zzbs zzbs = new zzbs();
        synchronized (sLock) {
            zzarr = zzbs;
        }
    }

    protected zzbs() {
        int i = Build.VERSION.SDK_INT;
        this.zzary = i >= 21 ? new zzahg() : i >= 19 ? new zzahf() : i >= 18 ? new zzahd() : i >= 17 ? new zzahc() : i >= 16 ? new zzahe() : new zzahb();
        this.zzarz = new zzgp();
        this.zzasa = new zzaez(this.zzarw);
        this.zzasb = new zzhl();
        this.zzasc = new zzhm();
        this.zzasd = zzh.zzalv();
        this.zzase = new zzac();
        this.zzasf = new zzmv();
        this.zzasg = new zzahp();
        this.zzash = new zzabw();
        this.zzasy = new zzb();
        this.zzasi = new zzmm();
        this.zzasj = new zzmn();
        this.zzask = new zzmo();
        this.zzasl = new zzajz();
        this.zzasm = new zzsl();
        this.zzasn = new zzsv();
        this.zzaso = new zzaii();
        this.zzasp = new zzr();
        this.zzasq = new zzs();
        this.zzasr = new zztv();
        this.zzass = new zzaij();
        this.zzast = new zzaz();
        this.zzasu = new zzia();
        this.zzasv = new zzael();
        this.zzasw = new zzals();
        this.zzasx = new zzakg();
        this.zzasz = new zzahh();
    }

    private static zzbs zzdx() {
        zzbs zzbs;
        synchronized (sLock) {
            zzbs = zzarr;
        }
        return zzbs;
    }

    public static zzzc zzdy() {
        return zzdx().zzart;
    }

    public static zza zzdz() {
        return zzdx().zzars;
    }

    public static zzl zzea() {
        return zzdx().zzaru;
    }

    public static zzxf zzeb() {
        return zzdx().zzarv;
    }

    public static zzagr zzec() {
        return zzdx().zzarw;
    }

    public static zzamk zzed() {
        return zzdx().zzarx;
    }

    public static zzagw zzee() {
        return zzdx().zzary;
    }

    public static zzgp zzef() {
        return zzdx().zzarz;
    }

    public static zzaez zzeg() {
        return zzdx().zzasa;
    }

    public static zzhm zzeh() {
        return zzdx().zzasc;
    }

    public static zzd zzei() {
        return zzdx().zzasd;
    }

    public static zzac zzej() {
        return zzdx().zzase;
    }

    public static zzmv zzek() {
        return zzdx().zzasf;
    }

    public static zzahp zzel() {
        return zzdx().zzasg;
    }

    public static zzabw zzem() {
        return zzdx().zzash;
    }

    public static zzmn zzen() {
        return zzdx().zzasj;
    }

    public static zzmm zzeo() {
        return zzdx().zzasi;
    }

    public static zzmo zzep() {
        return zzdx().zzask;
    }

    public static zzajz zzeq() {
        return zzdx().zzasl;
    }

    public static zzsl zzer() {
        return zzdx().zzasm;
    }

    public static zzsv zzes() {
        return zzdx().zzasn;
    }

    public static zzaii zzet() {
        return zzdx().zzaso;
    }

    public static zzr zzeu() {
        return zzdx().zzasp;
    }

    public static zzs zzev() {
        return zzdx().zzasq;
    }

    public static zztv zzew() {
        return zzdx().zzasr;
    }

    public static zzaij zzex() {
        return zzdx().zzass;
    }

    public static zzals zzey() {
        return zzdx().zzasw;
    }

    public static zzakg zzez() {
        return zzdx().zzasx;
    }

    public static zzael zzfa() {
        return zzdx().zzasv;
    }

    public static zzb zzfb() {
        return zzdx().zzasy;
    }

    public static zzahh zzfc() {
        return zzdx().zzasz;
    }
}
