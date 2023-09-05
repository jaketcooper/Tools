package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.p000v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzom;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqb;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzuc;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zzaj extends zzjx {
    private final Context mContext;
    private final zzv zzamw;
    private final zzuc zzanb;
    private zzjq zzaoj;
    private zziw zzaon;
    private PublisherAdViewOptions zzaoo;
    private zzom zzaor;
    private zzkm zzaot;
    private final String zzaou;
    private final zzaiy zzaov;
    private zzpy zzapa;
    private zzqb zzapb;
    private SimpleArrayMap<String, zzqe> zzapc = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzqh> zzapd = new SimpleArrayMap<>();
    private zzqk zzape;

    public zzaj(Context context, String str, zzuc zzuc, zzaiy zzaiy, zzv zzv) {
        this.mContext = context;
        this.zzaou = str;
        this.zzanb = zzuc;
        this.zzaov = zzaiy;
        this.zzamw = zzv;
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzaoo = publisherAdViewOptions;
    }

    public final void zza(zzom zzom) {
        this.zzaor = zzom;
    }

    public final void zza(zzpy zzpy) {
        this.zzapa = zzpy;
    }

    public final void zza(zzqb zzqb) {
        this.zzapb = zzqb;
    }

    public final void zza(zzqk zzqk, zziw zziw) {
        this.zzape = zzqk;
        this.zzaon = zziw;
    }

    public final void zza(String str, zzqh zzqh, zzqe zzqe) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzapd.put(str, zzqh);
        this.zzapc.put(str, zzqe);
    }

    public final void zzb(zzjq zzjq) {
        this.zzaoj = zzjq;
    }

    public final void zzb(zzkm zzkm) {
        this.zzaot = zzkm;
    }

    public final zzjt zzdc() {
        return new zzag(this.mContext, this.zzaou, this.zzanb, this.zzaov, this.zzaoj, this.zzapa, this.zzapb, this.zzapd, this.zzapc, this.zzaor, this.zzaot, this.zzamw, this.zzape, this.zzaon, this.zzaoo);
    }
}
