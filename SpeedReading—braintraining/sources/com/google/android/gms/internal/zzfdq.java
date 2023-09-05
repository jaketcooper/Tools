package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzfdq implements Iterator {
    private final int limit = this.zzpbb.size();
    private int position = 0;
    private /* synthetic */ zzfdp zzpbb;

    zzfdq(zzfdp zzfdp) {
        this.zzpbb = zzfdp;
    }

    private final byte nextByte() {
        try {
            zzfdp zzfdp = this.zzpbb;
            int i = this.position;
            this.position = i + 1;
            return zzfdp.zzke(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
