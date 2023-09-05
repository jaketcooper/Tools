package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

public final class zzahw {
    public final int count;
    public final String name;
    private double zzdak;
    private double zzdal;
    public final double zzdam;

    public zzahw(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzdal = d;
        this.zzdak = d2;
        this.zzdam = d3;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzahw)) {
            return false;
        }
        zzahw zzahw = (zzahw) obj;
        return zzbg.equal(this.name, zzahw.name) && this.zzdak == zzahw.zzdak && this.zzdal == zzahw.zzdal && this.count == zzahw.count && Double.compare(this.zzdam, zzahw.zzdam) == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, Double.valueOf(this.zzdak), Double.valueOf(this.zzdal), Double.valueOf(this.zzdam), Integer.valueOf(this.count)});
    }

    public final String toString() {
        return zzbg.zzw(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzdal)).zzg("maxBound", Double.valueOf(this.zzdak)).zzg("percent", Double.valueOf(this.zzdam)).zzg("count", Integer.valueOf(this.count)).toString();
    }
}
