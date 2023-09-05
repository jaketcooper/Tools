package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzzb
public final class zzuv implements MediationAdRequest {
    private final int zzbcm;
    private final boolean zzbcy;
    private final int zzcdx;
    private final Date zzha;
    private final Set<String> zzhc;
    private final boolean zzhd;
    private final Location zzhe;

    public zzuv(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2) {
        this.zzha = date;
        this.zzbcm = i;
        this.zzhc = set;
        this.zzhe = location;
        this.zzhd = z;
        this.zzcdx = i2;
        this.zzbcy = z2;
    }

    public final Date getBirthday() {
        return this.zzha;
    }

    public final int getGender() {
        return this.zzbcm;
    }

    public final Set<String> getKeywords() {
        return this.zzhc;
    }

    public final Location getLocation() {
        return this.zzhe;
    }

    public final boolean isDesignedForFamilies() {
        return this.zzbcy;
    }

    public final boolean isTesting() {
        return this.zzhd;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzcdx;
    }
}
