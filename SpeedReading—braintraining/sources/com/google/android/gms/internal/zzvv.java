package com.google.android.gms.internal;

import android.content.DialogInterface;

final class zzvv implements DialogInterface.OnClickListener {
    private /* synthetic */ zzvt zzceu;

    zzvv(zzvt zzvt) {
        this.zzceu = zzvt;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzceu.zzbl("Operation denied by user.");
    }
}
