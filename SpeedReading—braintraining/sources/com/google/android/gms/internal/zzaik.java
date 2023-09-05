package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;

@zzzb
public final class zzaik extends zzafh {
    private final String zzad;
    private final zzaix zzdbe;

    public zzaik(Context context, String str, String str2) {
        this(str2, zzbs.zzec().zzp(context, str));
    }

    private zzaik(String str, String str2) {
        this.zzdbe = new zzaix(str2);
        this.zzad = str;
    }

    public final void onStop() {
    }

    public final void zzdg() {
        this.zzdbe.zzch(this.zzad);
    }
}
