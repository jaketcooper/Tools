package com.google.android.gms.internal;

import android.webkit.ValueCallback;

final class zzgw implements ValueCallback<String> {
    private /* synthetic */ zzgv zzaza;

    zzgw(zzgv zzgv) {
        this.zzaza = zzgv;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.zzaza.zzayv.zza(this.zzaza.zzayx, this.zzaza.zzayy, (String) obj, this.zzaza.zzayz);
    }
}
