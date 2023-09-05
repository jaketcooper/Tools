package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zzahu {
    private final String[] zzdaf;
    private final double[] zzdag;
    private final double[] zzdah;
    private final int[] zzdai;
    private int zzdaj;

    private zzahu(zzahx zzahx) {
        int size = zzahx.zzdao.size();
        this.zzdaf = (String[]) zzahx.zzdan.toArray(new String[size]);
        this.zzdag = zzq(zzahx.zzdao);
        this.zzdah = zzq(zzahx.zzdap);
        this.zzdai = new int[size];
        this.zzdaj = 0;
    }

    private static double[] zzq(List<Double> list) {
        double[] dArr = new double[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return dArr;
            }
            dArr[i2] = list.get(i2).doubleValue();
            i = i2 + 1;
        }
    }

    public final List<zzahw> getBuckets() {
        ArrayList arrayList = new ArrayList(this.zzdaf.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzdaf.length) {
                return arrayList;
            }
            arrayList.add(new zzahw(this.zzdaf[i2], this.zzdah[i2], this.zzdag[i2], ((double) this.zzdai[i2]) / ((double) this.zzdaj), this.zzdai[i2]));
            i = i2 + 1;
        }
    }

    public final void zza(double d) {
        this.zzdaj++;
        int i = 0;
        while (i < this.zzdah.length) {
            if (this.zzdah[i] <= d && d < this.zzdag[i]) {
                int[] iArr = this.zzdai;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzdah[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
