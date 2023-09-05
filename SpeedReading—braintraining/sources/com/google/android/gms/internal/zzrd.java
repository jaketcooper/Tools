package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;

final class zzrd extends zzajy<ParcelFileDescriptor> {
    private /* synthetic */ zzrc zzbxa;

    zzrd(zzrc zzrc) {
        this.zzbxa = zzrc;
    }

    public final boolean cancel(boolean z) {
        this.zzbxa.disconnect();
        return super.cancel(z);
    }
}
