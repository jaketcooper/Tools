package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@zzzb
public final class zznc {
    @Nullable
    private final zznd zzamo;
    private final Map<String, zznb> zzbqu = new HashMap();

    public zznc(@Nullable zznd zznd) {
        this.zzamo = zznd;
    }

    public final void zza(String str, zznb zznb) {
        this.zzbqu.put(str, zznb);
    }

    public final void zza(String str, String str2, long j) {
        zznd zznd = this.zzamo;
        zznb zznb = this.zzbqu.get(str2);
        String[] strArr = {str};
        if (!(zznd == null || zznb == null)) {
            zznd.zza(zznb, j, strArr);
        }
        Map<String, zznb> map = this.zzbqu;
        zznd zznd2 = this.zzamo;
        map.put(str, zznd2 == null ? null : zznd2.zzc(j));
    }

    @Nullable
    public final zznd zziy() {
        return this.zzamo;
    }
}
