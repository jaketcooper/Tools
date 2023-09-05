package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzf implements DynamiteModule.zzd {
    zzf() {
    }

    public final zzj zza(Context context, String str, zzi zzi) throws DynamiteModule.zzc {
        zzj zzj = new zzj();
        zzj.zzguw = zzi.zzab(context, str);
        zzj.zzgux = zzi.zzc(context, str, true);
        if (zzj.zzguw == 0 && zzj.zzgux == 0) {
            zzj.zzguy = 0;
        } else if (zzj.zzgux >= zzj.zzguw) {
            zzj.zzguy = 1;
        } else {
            zzj.zzguy = -1;
        }
        return zzj;
    }
}
