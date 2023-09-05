package com.google.android.gms.ads.internal.p004js;

import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzzb;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzzb
/* renamed from: com.google.android.gms.ads.internal.js.zzam */
public final class zzam implements zzal {
    private final zzak zzcaj;
    private final HashSet<AbstractMap.SimpleEntry<String, zzt<? super zzak>>> zzcak = new HashSet<>();

    public zzam(zzak zzak) {
        this.zzcaj = zzak;
    }

    public final void zza(String str, zzt<? super zzak> zzt) {
        this.zzcaj.zza(str, zzt);
        this.zzcak.add(new AbstractMap.SimpleEntry(str, zzt));
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzcaj.zza(str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzcaj.zza(str, jSONObject);
    }

    public final void zzb(String str, zzt<? super zzak> zzt) {
        this.zzcaj.zzb(str, zzt);
        this.zzcak.remove(new AbstractMap.SimpleEntry(str, zzt));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.zzcaj.zzb(str, jSONObject);
    }

    public final void zzln() {
        Iterator<AbstractMap.SimpleEntry<String, zzt<? super zzak>>> it = this.zzcak.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzt) next.getValue()).toString());
            zzafj.m11v(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzcaj.zzb((String) next.getKey(), (zzt<? super zzak>) (zzt) next.getValue());
        }
        this.zzcak.clear();
    }
}
