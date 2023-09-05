package com.google.android.gms.internal;

import java.util.Comparator;

final class zzhb implements Comparator<zzhh> {
    zzhb(zzha zzha) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzhh zzhh = (zzhh) obj;
        zzhh zzhh2 = (zzhh) obj2;
        int i = zzhh.zzazr - zzhh2.zzazr;
        return i != 0 ? i : (int) (zzhh.value - zzhh2.value);
    }
}
