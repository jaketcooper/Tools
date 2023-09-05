package com.google.android.gms.internal;

import java.util.HashMap;

public final class zzbs extends zzbq<Integer, Object> {
    public String zzcq;
    public String zzcs;
    public String zzct;
    public String zzcu;
    public long zzyo;

    public zzbs() {
        this.zzcq = "E";
        this.zzyo = -1;
        this.zzcs = "E";
        this.zzct = "E";
        this.zzcu = "E";
    }

    public zzbs(String str) {
        this();
        zzi(str);
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        HashMap zzj = zzj(str);
        if (zzj != null) {
            this.zzcq = zzj.get(0) == null ? "E" : (String) zzj.get(0);
            this.zzyo = zzj.get(1) == null ? -1 : ((Long) zzj.get(1)).longValue();
            this.zzcs = zzj.get(2) == null ? "E" : (String) zzj.get(2);
            this.zzct = zzj.get(3) == null ? "E" : (String) zzj.get(3);
            this.zzcu = zzj.get(4) == null ? "E" : (String) zzj.get(4);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzw() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzcq);
        hashMap.put(4, this.zzcu);
        hashMap.put(3, this.zzct);
        hashMap.put(2, this.zzcs);
        hashMap.put(1, Long.valueOf(this.zzyo));
        return hashMap;
    }
}
