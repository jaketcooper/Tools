package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzamp implements zzt<zzama> {
    private /* synthetic */ zzamo zzdkc;

    zzamp(zzamo zzamo) {
        this.zzdkc = zzamo;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzdkc.mLock) {
                        if (this.zzdkc.zzdju != parseInt) {
                            int unused = this.zzdkc.zzdju = parseInt;
                            this.zzdkc.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzafj.zzc("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
