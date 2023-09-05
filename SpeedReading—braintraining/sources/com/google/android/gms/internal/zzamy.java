package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzamy implements DialogInterface.OnCancelListener {
    private /* synthetic */ JsResult zzdkq;

    zzamy(JsResult jsResult) {
        this.zzdkq = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzdkq.cancel();
    }
}
