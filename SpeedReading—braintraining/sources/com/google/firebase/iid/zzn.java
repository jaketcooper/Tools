package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

final /* synthetic */ class zzn implements Handler.Callback {
    private final zzm zznvd;

    zzn(zzm zzm) {
        this.zznvd = zzm;
    }

    public final boolean handleMessage(Message message) {
        return this.zznvd.zzd(message);
    }
}
