package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzd implements DynamiteModule.zzd {
    zzd() {
    }

    public final zzj zza(Context context, String str, zzi zzi) throws DynamiteModule.zzc {
        zzj zzj = new zzj();
        zzj.zzguw = zzi.zzab(context, str);
        zzj.zzgux = zzi.zzc(context, str, true);
        if (zzj.zzguw == 0 && zzj.zzgux == 0) {
            zzj.zzguy = 0;
        } else if (zzj.zzguw >= zzj.zzgux) {
            zzj.zzguy = -1;
        } else {
            zzj.zzguy = 1;
        }
        return zzj;
    }
}
