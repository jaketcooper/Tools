package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Stack;

final class zzffz {
    private final Stack<zzfdp> zzpea;

    private zzffz() {
        this.zzpea = new Stack<>();
    }

    private final void zzao(zzfdp zzfdp) {
        zzfdp zzfdp2 = zzfdp;
        while (!zzfdp2.zzcto()) {
            if (zzfdp2 instanceof zzffx) {
                zzffx zzffx = (zzffx) zzfdp2;
                zzao(zzffx.zzpdw);
                zzfdp2 = zzffx.zzpdx;
            } else {
                String valueOf = String.valueOf(zzfdp2.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
            }
        }
        int zzlp = zzlp(zzfdp2.size());
        int i = zzffx.zzpdu[zzlp + 1];
        if (this.zzpea.isEmpty() || this.zzpea.peek().size() >= i) {
            this.zzpea.push(zzfdp2);
            return;
        }
        int i2 = zzffx.zzpdu[zzlp];
        zzffx pop = this.zzpea.pop();
        while (!this.zzpea.isEmpty() && this.zzpea.peek().size() < i2) {
            pop = new zzffx(this.zzpea.pop(), pop);
        }
        zzffx zzffx2 = new zzffx(pop, zzfdp2);
        while (!this.zzpea.isEmpty()) {
            if (this.zzpea.peek().size() >= zzffx.zzpdu[zzlp(zzffx2.size()) + 1]) {
                break;
            }
            zzffx2 = new zzffx(this.zzpea.pop(), zzffx2);
        }
        this.zzpea.push(zzffx2);
    }

    /* access modifiers changed from: private */
    public final zzfdp zzc(zzfdp zzfdp, zzfdp zzfdp2) {
        zzao(zzfdp);
        zzao(zzfdp2);
        zzffx pop = this.zzpea.pop();
        while (!this.zzpea.isEmpty()) {
            pop = new zzffx(this.zzpea.pop(), pop);
        }
        return pop;
    }

    private static int zzlp(int i) {
        int binarySearch = Arrays.binarySearch(zzffx.zzpdu, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }
}
