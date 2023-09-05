package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;

public final class zzfi implements zzgm {
    private final WeakReference<View> zzavw;
    private final WeakReference<zzaeu> zzavx;

    public zzfi(View view, zzaeu zzaeu) {
        this.zzavw = new WeakReference<>(view);
        this.zzavx = new WeakReference<>(zzaeu);
    }

    public final View zzfz() {
        return (View) this.zzavw.get();
    }

    public final boolean zzga() {
        return this.zzavw.get() == null || this.zzavx.get() == null;
    }

    public final zzgm zzgb() {
        return new zzfh((View) this.zzavw.get(), (zzaeu) this.zzavx.get());
    }
}
