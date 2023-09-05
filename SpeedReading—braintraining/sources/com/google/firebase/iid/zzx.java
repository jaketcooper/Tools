package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzx extends Handler {
    private /* synthetic */ zzw zznvl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzx(zzw zzw, Looper looper) {
        super(looper);
        this.zznvl = zzw;
    }

    public final void handleMessage(Message message) {
        this.zznvl.zzc(message);
    }
}
