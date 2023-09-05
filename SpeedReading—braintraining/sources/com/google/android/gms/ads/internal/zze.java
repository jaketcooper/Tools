package com.google.android.gms.ads.internal;

import java.util.concurrent.Callable;

final class zze implements Callable<String> {
    private /* synthetic */ zzd zzand;

    zze(zzd zzd) {
        this.zzand = zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r0 = com.google.android.gms.ads.internal.zzbs.zzee().zzax(r3.zzand.zzamt.zzaif);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object call() throws java.lang.Exception {
        /*
            r3 = this;
            java.lang.String r1 = ""
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzboh
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.zzagw r0 = com.google.android.gms.ads.internal.zzbs.zzee()
            com.google.android.gms.ads.internal.zzd r2 = r3.zzand
            com.google.android.gms.ads.internal.zzbt r2 = r2.zzamt
            android.content.Context r2 = r2.zzaif
            android.webkit.CookieManager r0 = r0.zzax(r2)
            if (r0 == 0) goto L_0x002b
            java.lang.String r1 = "googleads.g.doubleclick.net"
            java.lang.String r0 = r0.getCookie(r1)
        L_0x002a:
            return r0
        L_0x002b:
            r0 = r1
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zze.call():java.lang.Object");
    }
}
