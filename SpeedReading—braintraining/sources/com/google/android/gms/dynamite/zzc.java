package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzc implements DynamiteModule.zzd {
    zzc() {
    }

    public final zzj zza(Context context, String str, zzi zzi) throws DynamiteModule.zzc {
        zzj zzj = new zzj();
        zzj.zzguw = zzi.zzab(context, str);
        if (zzj.zzguw != 0) {
            zzj.zzguy = -1;
        } else {
            zzj.zzgux = zzi.zzc(context, str, true);
            if (zzj.zzgux != 0) {
                zzj.zzguy = 1;
            }
        }
        return zzj;
    }
}
