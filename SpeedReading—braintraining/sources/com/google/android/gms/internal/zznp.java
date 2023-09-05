package com.google.android.gms.internal;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zznp extends zzov {
    private static final int zzbrh = Color.rgb(12, 174, 206);
    private static final int zzbri;
    private static int zzbrj;
    private static int zzbrk = zzbrh;
    private final int mTextColor;
    private final String zzbrl;
    private final List<zznr> zzbrm = new ArrayList();
    private final List<zzoy> zzbrn = new ArrayList();
    private final int zzbro;
    private final int zzbrp;
    private final int zzbrq;
    private final int zzbrr;
    private final boolean zzbrs;

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzbri = rgb;
        zzbrj = rgb;
    }

    public zznp(String str, List<zznr> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzbrl = str;
        if (list != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    break;
                }
                zznr zznr = list.get(i4);
                this.zzbrm.add(zznr);
                this.zzbrn.add(zznr);
                i3 = i4 + 1;
            }
        }
        this.zzbro = num != null ? num.intValue() : zzbrj;
        this.mTextColor = num2 != null ? num2.intValue() : zzbrk;
        this.zzbrp = num3 != null ? num3.intValue() : 12;
        this.zzbrq = i;
        this.zzbrr = i2;
        this.zzbrs = z;
    }

    public final int getBackgroundColor() {
        return this.zzbro;
    }

    public final String getText() {
        return this.zzbrl;
    }

    public final int getTextColor() {
        return this.mTextColor;
    }

    public final int getTextSize() {
        return this.zzbrp;
    }

    public final List<zzoy> zzjg() {
        return this.zzbrn;
    }

    public final List<zznr> zzjh() {
        return this.zzbrm;
    }

    public final int zzji() {
        return this.zzbrq;
    }

    public final int zzjj() {
        return this.zzbrr;
    }

    public final boolean zzjk() {
        return this.zzbrs;
    }
}
