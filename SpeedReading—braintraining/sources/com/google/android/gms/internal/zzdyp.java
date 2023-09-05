package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

final class zzdyp implements Iterator<Map.Entry<K, V>> {
    private int zzmhn = this.zzmho;
    private /* synthetic */ int zzmho;
    private /* synthetic */ boolean zzmhp;
    private /* synthetic */ zzdyo zzmhq;

    zzdyp(zzdyo zzdyo, int i, boolean z) {
        this.zzmhq = zzdyo;
        this.zzmho = i;
        this.zzmhp = z;
    }

    public final boolean hasNext() {
        return this.zzmhp ? this.zzmhn >= 0 : this.zzmhn < this.zzmhq.zzmhk.length;
    }

    public final /* synthetic */ Object next() {
        Object obj = this.zzmhq.zzmhk[this.zzmhn];
        Object obj2 = this.zzmhq.zzmhl[this.zzmhn];
        this.zzmhn = this.zzmhp ? this.zzmhn - 1 : this.zzmhn + 1;
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
    }
}
