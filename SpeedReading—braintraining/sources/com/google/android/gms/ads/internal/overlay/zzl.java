package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zzl {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzchp == 4 && adOverlayInfoParcel.zzchi == null) {
            if (adOverlayInfoParcel.zzchh != null) {
                adOverlayInfoParcel.zzchh.onAdClicked();
            }
            zzbs.zzdz();
            zza.zza(context, adOverlayInfoParcel.zzchg, adOverlayInfoParcel.zzcho);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzatd.zzdcb);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!zzq.zzamc()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzbs.zzec();
        zzagr.zza(context, intent);
    }
}
