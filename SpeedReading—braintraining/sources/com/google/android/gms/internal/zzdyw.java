package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map;

final class zzdyw<T> implements Iterator<T> {
    private Iterator<Map.Entry<T, Void>> zzmhv;

    public zzdyw(Iterator<Map.Entry<T, Void>> it) {
        this.zzmhv = it;
    }

    public final boolean hasNext() {
        return this.zzmhv.hasNext();
    }

    public final T next() {
        return this.zzmhv.next().getKey();
    }

    public final void remove() {
        this.zzmhv.remove();
    }
}
