package com.google.android.gms.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzfgj extends AbstractSet<Map.Entry<K, V>> {
    private /* synthetic */ zzfgc zzper;

    private zzfgj(zzfgc zzfgc) {
        this.zzper = zzfgc;
    }

    /* synthetic */ zzfgj(zzfgc zzfgc, zzfgd zzfgd) {
        this(zzfgc);
    }

    public final /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzper.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.zzper.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzper.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzfgi(this.zzper, (zzfgd) null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzper.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.zzper.size();
    }
}
