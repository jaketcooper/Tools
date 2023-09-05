package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzur;
import java.util.Map;

final class zzav implements zzt<zzama> {
    private /* synthetic */ zzuo zzaqd;
    private /* synthetic */ zzab zzaqe;
    private /* synthetic */ zzur zzaqf;

    zzav(zzuo zzuo, zzab zzab, zzur zzur) {
        this.zzaqd = zzuo;
        this.zzaqe = zzab;
        this.zzaqf = zzur;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzama zzama = (zzama) obj;
        if (zzama == null) {
            throw null;
        }
        View view = (View) zzama;
        if (view != null) {
            try {
                if (this.zzaqd != null) {
                    if (!this.zzaqd.getOverrideClickHandling()) {
                        this.zzaqd.zzh(zzn.zzy(view));
                        this.zzaqe.zzany.onAdClicked();
                        return;
                    }
                    zzaq.zzc(zzama);
                } else if (this.zzaqf == null) {
                } else {
                    if (!this.zzaqf.getOverrideClickHandling()) {
                        this.zzaqf.zzh(zzn.zzy(view));
                        this.zzaqe.zzany.onAdClicked();
                        return;
                    }
                    zzaq.zzc(zzama);
                }
            } catch (RemoteException e) {
                zzafj.zzc("Unable to call handleClick on mapper", e);
            }
        }
    }
}
