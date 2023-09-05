package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzack;
import com.google.android.gms.internal.zzadr;
import com.google.android.gms.internal.zzads;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zztm;
import com.google.android.gms.internal.zztn;
import com.google.android.gms.internal.zzuf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzay implements Runnable {
    private /* synthetic */ zzax zzaql;

    zzay(zzax zzax) {
        this.zzaql = zzax;
    }

    public final void run() {
        Context zza = this.zzaql.zzaqk.mContext;
        Runnable runnable = this.zzaql.zzaqj;
        zzbq.zzga("Adapters must be initialized on the main thread.");
        Map<String, zztn> zzor = zzbs.zzeg().zzpj().zzor();
        if (zzor != null && !zzor.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzafj.zzc("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            zzack zznu = zzack.zznu();
            if (zznu != null) {
                Collection<zztn> values = zzor.values();
                HashMap hashMap = new HashMap();
                IObjectWrapper zzy = zzn.zzy(zza);
                for (zztn zztn : values) {
                    for (zztm next : zztn.zzcbt) {
                        String str = next.zzcbk;
                        for (String next2 : next.zzcbd) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzadr zzbp = zznu.zzbp(str2);
                        if (zzbp != null) {
                            zzuf zzoc = zzbp.zzoc();
                            if (!zzoc.isInitialized() && zzoc.zzmc()) {
                                zzoc.zza(zzy, (zzads) zzbp.zzod(), (List<String>) (List) entry.getValue());
                                String valueOf = String.valueOf(str2);
                                zzafj.zzbw(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                            }
                        }
                    } catch (Throwable th2) {
                        zzafj.zzc(new StringBuilder(String.valueOf(str2).length() + 56).append("Failed to initialize rewarded video mediation adapter \"").append(str2).append("\"").toString(), th2);
                    }
                }
            }
        }
    }
}
