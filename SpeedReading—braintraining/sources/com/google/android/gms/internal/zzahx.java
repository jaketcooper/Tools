package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzahx {
    /* access modifiers changed from: private */
    public final List<String> zzdan = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdao = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzdap = new ArrayList();

    public final zzahx zza(String str, double d, double d2) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.zzdan.size()) {
                break;
            }
            double doubleValue = this.zzdap.get(i).doubleValue();
            double doubleValue2 = this.zzdao.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i2 = i + 1;
        }
        this.zzdan.add(i, str);
        this.zzdap.add(i, Double.valueOf(d));
        this.zzdao.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzahu zzql() {
        return new zzahu(this);
    }
}
