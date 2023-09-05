package com.google.android.gms.internal;

import java.util.Comparator;

public final class zzhk implements Comparator<zzgy> {
    public zzhk(zzhj zzhj) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgy zzgy = (zzgy) obj;
        zzgy zzgy2 = (zzgy) obj2;
        if (zzgy.zzgw() < zzgy2.zzgw()) {
            return -1;
        }
        if (zzgy.zzgw() > zzgy2.zzgw()) {
            return 1;
        }
        if (zzgy.zzgv() < zzgy2.zzgv()) {
            return -1;
        }
        if (zzgy.zzgv() > zzgy2.zzgv()) {
            return 1;
        }
        float zzgy3 = (zzgy.zzgy() - zzgy.zzgw()) * (zzgy.zzgx() - zzgy.zzgv());
        float zzgy4 = (zzgy2.zzgy() - zzgy2.zzgw()) * (zzgy2.zzgx() - zzgy2.zzgv());
        if (zzgy3 <= zzgy4) {
            return zzgy3 < zzgy4 ? 1 : 0;
        }
        return -1;
    }
}
