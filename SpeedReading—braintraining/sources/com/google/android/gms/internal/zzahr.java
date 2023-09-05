package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzbs;

final class zzahr implements DialogInterface.OnClickListener {
    private /* synthetic */ zzahq zzdae;

    zzahr(zzahq zzahq) {
        this.zzdae = zzahq;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbs.zzec();
        zzagr.zza(this.zzdae.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
