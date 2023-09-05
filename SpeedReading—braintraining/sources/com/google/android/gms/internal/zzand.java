package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzand implements DialogInterface.OnClickListener {
    private /* synthetic */ JsPromptResult zzdkr;
    private /* synthetic */ EditText zzdks;

    zzand(JsPromptResult jsPromptResult, EditText editText) {
        this.zzdkr = jsPromptResult;
        this.zzdks = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdkr.confirm(this.zzdks.getText().toString());
    }
}
