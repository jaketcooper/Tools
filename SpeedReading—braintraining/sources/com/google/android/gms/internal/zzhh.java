package com.google.android.gms.internal;

import android.support.annotation.Nullable;

public final class zzhh {
    final long value;
    final String zzazq;
    final int zzazr;

    zzhh(long j, String str, int i) {
        this.value = j;
        this.zzazq = str;
        this.zzazr = i;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof zzhh)) {
            return false;
        }
        return ((zzhh) obj).value == this.value && ((zzhh) obj).zzazr == this.zzazr;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
