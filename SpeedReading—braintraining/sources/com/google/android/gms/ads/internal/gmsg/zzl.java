package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import java.util.Map;

final class zzl implements zzt<zzama> {
    zzl() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        zzd zzsm = zzama.zzsm();
        if (zzsm != null) {
            zzsm.close();
            return;
        }
        zzd zzsn = zzama.zzsn();
        if (zzsn != null) {
            zzsn.close();
        } else {
            zzafj.zzco("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
