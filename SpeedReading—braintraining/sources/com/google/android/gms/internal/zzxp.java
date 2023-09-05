package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzyg;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@zzzb
public abstract class zzxp<T extends zzyg> implements zzyg<T> {
    private final HashMap<String, List<zzt<? super T>>> zzcio = new HashMap<>();

    public void zza(String str, zzt<? super T> zzt) {
        List list = this.zzcio.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.zzcio.put(str, list);
        }
        list.add(zzt);
    }

    public void zzb(String str, zzt<? super T> zzt) {
        List list = this.zzcio.get(str);
        if (list != null) {
            list.remove(zzt);
        }
    }
}
