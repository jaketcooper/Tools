package com.google.android.gms.internal;

import com.google.android.gms.internal.zzid;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zzib {
    private final zzig zzban;
    private final zzil zzbao;
    private final boolean zzbap;

    private zzib() {
        this.zzbap = false;
        this.zzban = new zzig();
        this.zzbao = new zzil();
        zzhj();
    }

    public zzib(zzig zzig, boolean z) {
        this.zzban = zzig;
        this.zzbap = z;
        this.zzbao = new zzil();
        zzhj();
    }

    public static zzib zzhi() {
        return new zzib();
    }

    private final synchronized void zzhj() {
        this.zzbao.zzbbp = new zzij();
        this.zzbao.zzbbo = new zzik();
    }

    private static int[] zzhk() {
        int i = 0;
        List<String> zzir = zzmq.zzir();
        ArrayList arrayList = new ArrayList();
        for (String split : zzir) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Integer.valueOf(valueOf));
                } catch (NumberFormatException e) {
                    zzafj.m11v("Experiment ID is not a number");
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            iArr[i2] = ((Integer) obj).intValue();
            i2++;
        }
        return iArr;
    }

    public final synchronized void zza(zzic zzic) {
        if (this.zzbap) {
            zzic.zza(this.zzbao);
        }
    }

    public final synchronized void zza(zzid.zza.zzb zzb) {
        if (this.zzbap) {
            this.zzban.zzd(zzfhs.zzc(this.zzbao)).zzq(zzb.zzhn()).zzb(zzhk()).zzbf();
            String valueOf = String.valueOf(Integer.toString(zzb.zzhn(), 10));
            zzafj.m11v(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
        }
    }
}
