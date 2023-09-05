package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

public final class zzdyu<K, V> implements Iterator<Map.Entry<K, V>> {
    private final Stack<zzdzd<K, V>> zzmhs = new Stack<>();
    private final boolean zzmht;

    zzdyu(zzdyz<K, V> zzdyz, K k, Comparator<K> comparator, boolean z) {
        this.zzmht = z;
        zzdyz<K, V> zzdyz2 = zzdyz;
        while (!zzdyz2.isEmpty()) {
            int compare = k != null ? z ? comparator.compare(k, zzdyz2.getKey()) : comparator.compare(zzdyz2.getKey(), k) : 1;
            if (compare < 0) {
                if (!z) {
                    zzdyz2 = zzdyz2.zzbrs();
                }
            } else if (compare == 0) {
                this.zzmhs.push((zzdzd) zzdyz2);
                return;
            } else {
                this.zzmhs.push((zzdzd) zzdyz2);
                if (z) {
                    zzdyz2 = zzdyz2.zzbrs();
                }
            }
            zzdyz2 = zzdyz2.zzbrr();
        }
    }

    /* access modifiers changed from: private */
    public final Map.Entry<K, V> next() {
        try {
            zzdzd pop = this.zzmhs.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.zzmht) {
                for (zzdyz zzbrr = pop.zzbrr(); !zzbrr.isEmpty(); zzbrr = zzbrr.zzbrs()) {
                    this.zzmhs.push((zzdzd) zzbrr);
                }
            } else {
                for (zzdyz zzbrs = pop.zzbrs(); !zzbrs.isEmpty(); zzbrs = zzbrs.zzbrr()) {
                    this.zzmhs.push((zzdzd) zzbrs);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    public final boolean hasNext() {
        return this.zzmhs.size() > 0;
    }

    public final void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
