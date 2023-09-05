package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.zzbs;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzzb
public final class zzms {
    private Context mContext = null;
    private String zzaus = null;
    private boolean zzbqe;
    private String zzbqf;
    private Map<String, String> zzbqg;

    public zzms(Context context, String str) {
        this.mContext = context;
        this.zzaus = str;
        this.zzbqe = ((Boolean) zzbs.zzep().zzd(zzmq.zzbhx)).booleanValue();
        this.zzbqf = (String) zzbs.zzep().zzd(zzmq.zzbhy);
        this.zzbqg = new LinkedHashMap();
        this.zzbqg.put("s", "gmob_sdk");
        this.zzbqg.put("v", "3");
        this.zzbqg.put("os", Build.VERSION.RELEASE);
        this.zzbqg.put("sdk", Build.VERSION.SDK);
        Map<String, String> map = this.zzbqg;
        zzbs.zzec();
        map.put("device", zzagr.zzpw());
        this.zzbqg.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.zzbqg;
        zzbs.zzec();
        map2.put("is_lite_sdk", zzagr.zzat(context) ? "1" : "0");
        Future<zzabu> zzp = zzbs.zzem().zzp(this.mContext);
        try {
            zzp.get();
            this.zzbqg.put("network_coarse", Integer.toString(zzp.get().zzcsg));
            this.zzbqg.put("network_fine", Integer.toString(zzp.get().zzcsh));
        } catch (Exception e) {
            zzbs.zzeg().zza((Throwable) e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    public final String zzfo() {
        return this.zzaus;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzis() {
        return this.zzbqe;
    }

    /* access modifiers changed from: package-private */
    public final String zzit() {
        return this.zzbqf;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zziu() {
        return this.zzbqg;
    }
}
