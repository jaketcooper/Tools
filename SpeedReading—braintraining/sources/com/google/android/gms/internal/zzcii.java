package com.google.android.gms.internal;

abstract class zzcii extends zzcih {
    private boolean zzdqd;

    zzcii(zzchj zzchj) {
        super(zzchj);
        this.zzitu.zzb(this);
    }

    public final void initialize() {
        if (this.zzdqd) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzaxo()) {
            this.zzitu.zzazz();
            this.zzdqd = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isInitialized() {
        return this.zzdqd;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzaxo();

    /* access modifiers changed from: protected */
    public void zzayn() {
    }

    public final void zzazl() {
        if (this.zzdqd) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzayn();
        this.zzitu.zzazz();
        this.zzdqd = true;
    }

    /* access modifiers changed from: protected */
    public final void zzwu() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
