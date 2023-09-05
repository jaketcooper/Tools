package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;

final class zzffj<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzmhv;

    public zzffj(Iterator<Map.Entry<K, Object>> it) {
        this.zzmhv = it;
    }

    public final boolean hasNext() {
        return this.zzmhv.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzmhv.next();
        return next.getValue() instanceof zzffg ? new zzffi(next) : next;
    }

    public final void remove() {
        this.zzmhv.remove();
    }
}
