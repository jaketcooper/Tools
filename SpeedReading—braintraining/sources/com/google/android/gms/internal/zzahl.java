package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzbs;

final class zzahl implements DialogInterface.OnClickListener {
    private /* synthetic */ zzahj zzczv;
    private /* synthetic */ String zzczw;

    zzahl(zzahj zzahj, String str) {
        this.zzczv = zzahj;
        this.zzczw = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbs.zzec();
        zzagr.zza(this.zzczv.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.zzczw), "Share via"));
    }
}
