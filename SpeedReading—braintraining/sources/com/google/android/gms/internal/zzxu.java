package com.google.android.gms.internal;

import java.util.List;

final class zzxu implements zzajc<List<zznr>, zznp> {
    private /* synthetic */ String zzcjb;
    private /* synthetic */ Integer zzcjc;
    private /* synthetic */ Integer zzcjd;
    private /* synthetic */ int zzcje;
    private /* synthetic */ int zzcjf;
    private /* synthetic */ int zzcjg;
    private /* synthetic */ int zzcjh;
    private /* synthetic */ boolean zzcji;

    zzxu(zzxr zzxr, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.zzcjb = str;
        this.zzcjc = num;
        this.zzcjd = num2;
        this.zzcje = i;
        this.zzcjf = i2;
        this.zzcjg = i3;
        this.zzcjh = i4;
        this.zzcji = z;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Integer num = null;
        List list = (List) obj;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String str = this.zzcjb;
        Integer num2 = this.zzcjc;
        Integer num3 = this.zzcjd;
        if (this.zzcje > 0) {
            num = Integer.valueOf(this.zzcje);
        }
        return new zznp(str, list, num2, num3, num, this.zzcjf + this.zzcjg, this.zzcjh, this.zzcji);
    }
}
