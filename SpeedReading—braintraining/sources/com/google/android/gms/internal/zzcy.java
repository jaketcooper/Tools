package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzcy extends zzbq<Integer, Object> {
    public Long zzaia;
    public Boolean zzaib;
    public Boolean zzaic;

    public zzcy() {
    }

    public zzcy(String str) {
        zzi(str);
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzaia = (Long) zzj.get(0);
            this.zzaib = (Boolean) zzj.get(1);
            this.zzaic = (Boolean) zzj.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzw() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaia);
        hashMap.put(1, this.zzaib);
        hashMap.put(2, this.zzaic);
        return hashMap;
    }
}
