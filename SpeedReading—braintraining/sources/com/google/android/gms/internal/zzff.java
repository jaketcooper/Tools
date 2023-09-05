package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

final class zzff extends ContentObserver {
    private /* synthetic */ zzfc zzavs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzff(zzfc zzfc, Handler handler) {
        super(handler);
        this.zzavs = zzfc;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        this.zzavs.zzft();
    }
}
