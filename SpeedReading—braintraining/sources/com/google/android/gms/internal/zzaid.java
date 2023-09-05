package com.google.android.gms.internal;

import java.util.Map;

final class zzaid extends zzaq {
    private /* synthetic */ byte[] zzdav;
    private /* synthetic */ Map zzdaw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaid(zzahy zzahy, int i, String str, zzv zzv, zzu zzu, byte[] bArr, Map map) {
        super(i, str, zzv, zzu);
        this.zzdav = bArr;
        this.zzdaw = map;
    }

    public final Map<String, String> getHeaders() throws zza {
        return this.zzdaw == null ? super.getHeaders() : this.zzdaw;
    }

    public final byte[] zzg() throws zza {
        return this.zzdav == null ? super.zzg() : this.zzdav;
    }
}
