package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzoh implements zzt<Object> {
    final /* synthetic */ zzyg zzbtf;
    final /* synthetic */ zzog zzbtg;

    zzoh(zzog zzog, zzyg zzyg) {
        this.zzbtg = zzog;
        this.zzbtf = zzyg;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzama zzama = (zzama) this.zzbtg.zzbtd.get();
        if (zzama == null) {
            this.zzbtf.zzb("/loadHtml", this);
            return;
        }
        zzama.zzsq().zza((zzamf) new zzoi(this, map));
        String str = map.get("overlayHtml");
        String str2 = map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzama.loadData(str, "text/html", "UTF-8");
        } else {
            zzama.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
