package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzbs;

final class zzwa implements DialogInterface.OnClickListener {
    private /* synthetic */ String zzcfm;
    private /* synthetic */ String zzcfn;
    private /* synthetic */ zzvz zzcfo;

    zzwa(zzvz zzvz, String str, String str2) {
        this.zzcfo = zzvz;
        this.zzcfm = str;
        this.zzcfn = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzcfo.mContext.getSystemService("download");
        try {
            String str = this.zzcfm;
            String str2 = this.zzcfn;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzbs.zzee().zza(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException e) {
            this.zzcfo.zzbl("Could not store picture.");
        }
    }
}
