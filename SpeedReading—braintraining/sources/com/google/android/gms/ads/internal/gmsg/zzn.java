package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzafj;
import java.util.Map;

final class zzn implements zzt<Object> {
    zzn() {
    }

    public final void zza(Object obj, Map<String, String> map) {
        String valueOf = String.valueOf(map.get("string"));
        zzafj.zzcn(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}
