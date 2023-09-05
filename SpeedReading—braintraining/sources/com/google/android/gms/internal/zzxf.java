package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzba;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;

@zzzb
public final class zzxf {
    public static zzahi zza(Context context, zza zza, zzaev zzaev, zzcs zzcs, @Nullable zzama zzama, zzuc zzuc, zzxg zzxg, zznd zznd) {
        zzahi zzxi;
        zzaad zzaad = zzaev.zzcwe;
        if (zzaad.zzcng) {
            zzxi = new zzxl(context, zzaev, zzuc, zzxg, zznd, zzama);
        } else if (zzaad.zzbdd || (zza instanceof zzba)) {
            zzxi = (!zzaad.zzbdd || !(zza instanceof zzba)) ? new zzxi(zzaev, zzxg) : new zzxn(context, (zzba) zza, zzaev, zzcs, zzxg, zznd);
        } else {
            zzxi = (!((Boolean) zzbs.zzep().zzd(zzmq.zzbit)).booleanValue() || !zzq.zzama() || zzq.zzamc() || zzama == null || !zzama.zzso().zztx()) ? new zzxh(context, zzaev, zzama, zzxg) : new zzxk(context, zzaev, zzama, zzxg);
        }
        String valueOf = String.valueOf(zzxi.getClass().getName());
        zzafj.zzbw(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzxi.zzmx();
        return zzxi;
    }
}
