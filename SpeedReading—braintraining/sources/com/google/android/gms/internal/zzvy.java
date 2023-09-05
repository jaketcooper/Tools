package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;

@zzzb
public final class zzvy {
    private final zzama zzbwq;
    private final boolean zzcfk;
    private final String zzcfl;

    public zzvy(zzama zzama, Map<String, String> map) {
        this.zzbwq = zzama;
        this.zzcfl = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzcfk = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzcfk = true;
        }
    }

    public final void execute() {
        if (this.zzbwq == null) {
            zzafj.zzco("AdWebView is null");
        } else {
            this.zzbwq.setRequestedOrientation("portrait".equalsIgnoreCase(this.zzcfl) ? zzbs.zzee().zzqa() : "landscape".equalsIgnoreCase(this.zzcfl) ? zzbs.zzee().zzpz() : this.zzcfk ? -1 : zzbs.zzee().zzqb());
        }
    }
}
