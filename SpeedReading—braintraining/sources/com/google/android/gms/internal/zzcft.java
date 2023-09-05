package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

final class zzcft {
    final String mAppId;
    final String mName;
    final long zziwz;
    final long zzixa;
    final long zzixb;
    final long zzixc;
    final Long zzixd;
    final Long zzixe;
    final Boolean zzixf;

    zzcft(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        zzbq.zzgi(str);
        zzbq.zzgi(str2);
        zzbq.checkArgument(j >= 0);
        zzbq.checkArgument(j2 >= 0);
        zzbq.checkArgument(j4 >= 0);
        this.mAppId = str;
        this.mName = str2;
        this.zziwz = j;
        this.zzixa = j2;
        this.zzixb = j3;
        this.zzixc = j4;
        this.zzixd = l;
        this.zzixe = l2;
        this.zzixf = bool;
    }

    /* access modifiers changed from: package-private */
    public final zzcft zza(Long l, Long l2, Boolean bool) {
        return new zzcft(this.mAppId, this.mName, this.zziwz, this.zzixa, this.zzixb, this.zzixc, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    /* access modifiers changed from: package-private */
    public final zzcft zzayl() {
        return new zzcft(this.mAppId, this.mName, this.zziwz + 1, this.zzixa + 1, this.zzixb, this.zzixc, this.zzixd, this.zzixe, this.zzixf);
    }

    /* access modifiers changed from: package-private */
    public final zzcft zzba(long j) {
        return new zzcft(this.mAppId, this.mName, this.zziwz, this.zzixa, j, this.zzixc, this.zzixd, this.zzixe, this.zzixf);
    }

    /* access modifiers changed from: package-private */
    public final zzcft zzbb(long j) {
        return new zzcft(this.mAppId, this.mName, this.zziwz, this.zzixa, this.zzixb, j, this.zzixd, this.zzixe, this.zzixf);
    }
}
