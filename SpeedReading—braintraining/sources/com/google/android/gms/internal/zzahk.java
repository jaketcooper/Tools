package com.google.android.gms.internal;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.zzbs;

final class zzahk implements DialogInterface.OnClickListener {
    private /* synthetic */ int zzczs;
    private /* synthetic */ int zzczt;
    private /* synthetic */ int zzczu;
    private /* synthetic */ zzahj zzczv;

    zzahk(zzahj zzahj, int i, int i2, int i3) {
        this.zzczv = zzahj;
        this.zzczs = i;
        this.zzczt = i2;
        this.zzczu = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == this.zzczs) {
            this.zzczv.zzqg();
            return;
        }
        if (i == this.zzczt) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzboz)).booleanValue()) {
                this.zzczv.zzqh();
                return;
            }
        }
        if (i == this.zzczu) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbpa)).booleanValue()) {
                this.zzczv.zzqi();
            }
        }
    }
}
