package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzdg extends zzbq<Integer, Long> {
    public Long zzajj;
    public Long zzfx;
    public Long zzfy;

    public zzdg() {
    }

    public zzdg(String str) {
        zzi(str);
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzajj = (Long) zzj.get(0);
            this.zzfx = (Long) zzj.get(1);
            this.zzfy = (Long) zzj.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzw() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzajj);
        hashMap.put(1, this.zzfx);
        hashMap.put(2, this.zzfy);
        return hashMap;
    }
}
