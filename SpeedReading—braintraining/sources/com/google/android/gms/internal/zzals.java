package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzzb
public final class zzals implements Iterable<zzalq> {
    private final List<zzalq> zzdhm = new LinkedList();

    public static boolean zzb(zzali zzali) {
        zzalq zzc = zzc(zzali);
        if (zzc == null) {
            return false;
        }
        zzc.zzdhj.abort();
        return true;
    }

    static zzalq zzc(zzali zzali) {
        Iterator<zzalq> it = zzbs.zzey().iterator();
        while (it.hasNext()) {
            zzalq next = it.next();
            if (next.zzdew == zzali) {
                return next;
            }
        }
        return null;
    }

    public final Iterator<zzalq> iterator() {
        return this.zzdhm.iterator();
    }

    public final void zza(zzalq zzalq) {
        this.zzdhm.add(zzalq);
    }

    public final void zzb(zzalq zzalq) {
        this.zzdhm.remove(zzalq);
    }

    public final int zzsi() {
        return this.zzdhm.size();
    }
}
