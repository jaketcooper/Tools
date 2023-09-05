package com.google.android.gms.ads.internal.p004js;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.zzr;
import com.google.android.gms.internal.zzaaf;
import com.google.android.gms.internal.zzaeh;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzais;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamf;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zzanp;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzwh;
import com.google.android.gms.internal.zzzb;
import java.util.Map;
import org.json.JSONObject;

@zzzb
/* renamed from: com.google.android.gms.ads.internal.js.zzg */
public final class zzg implements zzc {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final zzama zzbwq;

    public zzg(Context context, zzaiy zzaiy, @Nullable zzcs zzcs, zzv zzv) throws zzamm {
        this.mContext = context;
        this.zzbwq = zzbs.zzed().zza(context, zzanp.zztw(), "", false, false, zzcs, zzaiy, (zznd) null, (zzbl) null, zzv, zzib.zzhi());
        zzama zzama = this.zzbwq;
        if (zzama == null) {
            throw null;
        }
        ((View) zzama).setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzjk.zzhx();
        if (zzais.zzqt()) {
            runnable.run();
        } else {
            zzagr.zzczc.post(runnable);
        }
    }

    public final void destroy() {
        this.zzbwq.destroy();
    }

    public final void zza(zzd zzd) {
        this.zzbwq.zzsq().zza((zzamf) new zzm(this, zzd));
    }

    public final void zza(zzin zzin, zzn zzn, zzb zzb, zzq zzq, boolean z, zzx zzx, zzw zzw, zzwh zzwh) {
        this.zzbwq.zzsq().zza(zzin, zzn, zzb, zzq, false, (zzx) null, new zzw(this.mContext, (zzaeh) null, (zzaaf) null), (zzwh) null, (zzaeh) null);
    }

    public final void zza(String str, zzt<? super zzak> zzt) {
        this.zzbwq.zzsq().zza(str, (zzt<? super zzama>) new zzn(this, zzt));
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzbwq.zza(str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzbwq.zza(str, jSONObject);
    }

    public final void zzb(String str, zzt<? super zzak> zzt) {
        this.zzbwq.zzsq().zza(str, (zzr<zzt<? super zzama>>) new zzh(zzt));
    }

    public final void zzb(String str, JSONObject jSONObject) {
        runOnUiThread(new zzi(this, str, jSONObject));
    }

    public final void zzba(String str) {
        runOnUiThread(new zzj(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzbb(String str) {
        runOnUiThread(new zzl(this, str));
    }

    public final void zzbc(String str) {
        runOnUiThread(new zzk(this, str));
    }

    public final zzal zzlh() {
        return new zzam(this);
    }
}
