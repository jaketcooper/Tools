package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzbs;

@TargetApi(21)
public final class zzahg extends zzahf {
    public final CookieManager zzax(Context context) {
        if (zzqd()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzafj.zzb("Failed to obtain CookieManager.", th);
            zzbs.zzeg().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final zzamb zzb(zzama zzama, boolean z) {
        return new zzani(zzama, z);
    }

    public final int zzqe() {
        return 16974374;
    }
}
