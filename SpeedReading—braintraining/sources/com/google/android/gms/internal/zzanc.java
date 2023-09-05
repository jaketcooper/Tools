package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzanc implements DialogInterface.OnClickListener {
    private /* synthetic */ JsPromptResult zzdkr;

    zzanc(JsPromptResult jsPromptResult) {
        this.zzdkr = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdkr.cancel();
    }
}
