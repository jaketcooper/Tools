package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzzb;
import java.util.Map;

@zzzb
public final class zzz implements zzt<Object> {
    private final Context zzaif;

    public zzz(Context context) {
        this.zzaif = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzbs.zzfa().zzr(this.zzaif)) {
            zzbs.zzfa().zza(this.zzaif, map.get("eventName"), map.get("eventId"));
        }
    }
}
