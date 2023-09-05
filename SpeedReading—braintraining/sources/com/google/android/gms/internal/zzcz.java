package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzcz extends zzbq<Integer, Long> {
    public Long zzaid;
    public Long zzaie;

    public zzcz() {
    }

    public zzcz(String str) {
        zzi(str);
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzaid = (Long) zzj.get(0);
            this.zzaie = (Long) zzj.get(1);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzw() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaid);
        hashMap.put(1, this.zzaie);
        return hashMap;
    }
}
