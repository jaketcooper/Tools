package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbg;

@zzzb
public final class zzaci extends zzaco {
    private final String zzcrp;
    private final int zzctd;

    public zzaci(String str, int i) {
        this.zzcrp = str;
        this.zzctd = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzaci)) {
            return false;
        }
        zzaci zzaci = (zzaci) obj;
        return zzbg.equal(this.zzcrp, zzaci.zzcrp) && zzbg.equal(Integer.valueOf(this.zzctd), Integer.valueOf(zzaci.zzctd));
    }

    public final int getAmount() {
        return this.zzctd;
    }

    public final String getType() {
        return this.zzcrp;
    }
}
