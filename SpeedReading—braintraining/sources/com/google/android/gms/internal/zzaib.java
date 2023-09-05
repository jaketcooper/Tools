package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;

final class zzaib implements zzajc<zzn, T> {
    private /* synthetic */ zzaie zzdat;

    zzaib(zzahy zzahy, zzaie zzaie) {
        this.zzdat = zzaie;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return this.zzdat.zze(new ByteArrayInputStream(((zzn) obj).data));
    }
}
