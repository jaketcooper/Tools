package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzae;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.p004js.zzab;
import com.google.android.gms.ads.internal.p004js.zzak;
import com.google.android.gms.ads.internal.p004js.zzo;
import com.google.android.gms.ads.internal.zzbs;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import org.json.JSONObject;

@zzzb
public final class zztf<I, O> implements zzsu<I, O> {
    private final zzo zzcar;
    /* access modifiers changed from: private */
    public final zzsw<O> zzcas;
    private final zzsx<I> zzcat;
    private final String zzcau;

    zztf(zzo zzo, String str, zzsx<I> zzsx, zzsw<O> zzsw) {
        this.zzcar = zzo;
        this.zzcau = str;
        this.zzcat = zzsx;
        this.zzcas = zzsw;
    }

    /* access modifiers changed from: private */
    public final void zza(zzab zzab, zzak zzak, I i, zzajy<O> zzajy) {
        try {
            zzbs.zzec();
            String zzpv = zzagr.zzpv();
            zzd.zzbvq.zza(zzpv, (zzae) new zzti(this, zzab, zzajy));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IdentityRealmObject.FIELD_ID, zzpv);
            jSONObject.put("args", this.zzcat.zzh(i));
            zzak.zzb(this.zzcau, jSONObject);
        } catch (Exception e) {
            zzajy.setException(e);
            zzafj.zzb("Unable to invokeJavaScript", e);
            zzab.release();
        } catch (Throwable th) {
            zzab.release();
            throw th;
        }
    }

    public final zzajp<O> zzc(I i) throws Exception {
        return zzg(i);
    }

    public final zzajp<O> zzg(I i) {
        zzajy zzajy = new zzajy();
        zzab zzb = this.zzcar.zzb((zzcs) null);
        zzb.zza(new zztg(this, zzb, i, zzajy), new zzth(this, zzajy, zzb));
        return zzajy;
    }
}
