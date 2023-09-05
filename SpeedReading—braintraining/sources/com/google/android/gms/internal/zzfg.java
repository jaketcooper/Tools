package com.google.android.gms.internal;

import android.view.View;

public final class zzfg implements zzgm {
    private zzoa zzavu;

    public zzfg(zzoa zzoa) {
        this.zzavu = zzoa;
    }

    public final View zzfz() {
        if (this.zzavu != null) {
            return this.zzavu.zzkd();
        }
        return null;
    }

    public final boolean zzga() {
        return this.zzavu == null;
    }

    public final zzgm zzgb() {
        return this;
    }
}
