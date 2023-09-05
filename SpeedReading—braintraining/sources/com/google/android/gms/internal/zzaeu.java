package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzzb
public final class zzaeu {
    public final int errorCode;
    public final int orientation;
    public final boolean zzapy;
    public final List<String> zzcbv;
    public final List<String> zzcbw;
    @Nullable
    public final List<String> zzcby;
    public final long zzccb;
    @Nullable
    public final zztm zzcdd;
    @Nullable
    public final zzuf zzcde;
    @Nullable
    public final String zzcdf;
    @Nullable
    public final zztp zzcdg;
    @Nullable
    public final zzama zzchj;
    public final zzis zzclo;
    public final String zzclr;
    private long zzcnf;
    public final boolean zzcng;
    private long zzcnh;
    public final List<String> zzcni;
    public final String zzcnl;
    @Nullable
    public final zzadw zzcnv;
    @Nullable
    public final List<String> zzcnx;
    public final boolean zzcny;
    private zzaaf zzcnz;
    public final String zzcoc;
    public final JSONObject zzcvq;
    public boolean zzcvr;
    public final zztn zzcvs;
    @Nullable
    public final String zzcvt;
    public final zziw zzcvu;
    @Nullable
    public final List<String> zzcvv;
    public final long zzcvw;
    public final long zzcvx;
    @Nullable
    public final zzoc zzcvy;
    public boolean zzcvz;
    public boolean zzcwa;
    public boolean zzcwb;
    public final zzib zzcwc;
    public final boolean zzcwd;

    public zzaeu(zzaev zzaev, @Nullable zzama zzama, @Nullable zztm zztm, @Nullable zzuf zzuf, @Nullable String str, @Nullable zztp zztp, @Nullable zzoc zzoc, @Nullable String str2) {
        this(zzaev.zzcpe.zzclo, (zzama) null, zzaev.zzcwe.zzcbv, zzaev.errorCode, zzaev.zzcwe.zzcbw, zzaev.zzcwe.zzcni, zzaev.zzcwe.orientation, zzaev.zzcwe.zzccb, zzaev.zzcpe.zzclr, zzaev.zzcwe.zzcng, (zztm) null, (zzuf) null, (String) null, zzaev.zzcvs, (zztp) null, zzaev.zzcwe.zzcnh, zzaev.zzath, zzaev.zzcwe.zzcnf, zzaev.zzcvw, zzaev.zzcvx, zzaev.zzcwe.zzcnl, zzaev.zzcvq, (zzoc) null, zzaev.zzcwe.zzcnv, zzaev.zzcwe.zzcnw, zzaev.zzcwe.zzcnw, zzaev.zzcwe.zzcny, zzaev.zzcwe.zzcnz, (String) null, zzaev.zzcwe.zzcby, zzaev.zzcwe.zzcoc, zzaev.zzcwc, zzaev.zzcwe.zzapy, zzaev.zzcwd);
    }

    public zzaeu(zzis zzis, @Nullable zzama zzama, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable zztm zztm, @Nullable zzuf zzuf, @Nullable String str2, zztn zztn, @Nullable zztp zztp, long j2, zziw zziw, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable zzoc zzoc, zzadw zzadw, List<String> list4, List<String> list5, boolean z2, zzaaf zzaaf, @Nullable String str4, List<String> list6, String str5, zzib zzib, boolean z3, boolean z4) {
        this.zzcvz = false;
        this.zzcwa = false;
        this.zzcwb = false;
        this.zzclo = zzis;
        this.zzchj = zzama;
        this.zzcbv = zzp(list);
        this.errorCode = i;
        this.zzcbw = zzp(list2);
        this.zzcni = zzp(list3);
        this.orientation = i2;
        this.zzccb = j;
        this.zzclr = str;
        this.zzcng = z;
        this.zzcdd = zztm;
        this.zzcde = zzuf;
        this.zzcdf = str2;
        this.zzcvs = zztn;
        this.zzcdg = zztp;
        this.zzcnh = j2;
        this.zzcvu = zziw;
        this.zzcnf = j3;
        this.zzcvw = j4;
        this.zzcvx = j5;
        this.zzcnl = str3;
        this.zzcvq = jSONObject;
        this.zzcvy = zzoc;
        this.zzcnv = zzadw;
        this.zzcvv = zzp(list4);
        this.zzcnx = zzp(list5);
        this.zzcny = z2;
        this.zzcnz = zzaaf;
        this.zzcvt = str4;
        this.zzcby = zzp(list6);
        this.zzcoc = str5;
        this.zzcwc = zzib;
        this.zzapy = z3;
        this.zzcwd = z4;
    }

    @Nullable
    private static <T> List<T> zzp(@Nullable List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public final boolean zzfr() {
        if (this.zzchj == null || this.zzchj.zzsq() == null) {
            return false;
        }
        return this.zzchj.zzsq().zzfr();
    }
}
