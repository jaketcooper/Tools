package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

final class zzahq implements Runnable {
    final /* synthetic */ Context val$context;
    private /* synthetic */ String zzdab;
    private /* synthetic */ boolean zzdac;
    private /* synthetic */ boolean zzdad;

    zzahq(zzahp zzahp, Context context, String str, boolean z, boolean z2) {
        this.val$context = context;
        this.zzdab = str;
        this.zzdac = z;
        this.zzdad = z2;
    }

    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.val$context);
        builder.setMessage(this.zzdab);
        if (this.zzdac) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.zzdad) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new zzahr(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
