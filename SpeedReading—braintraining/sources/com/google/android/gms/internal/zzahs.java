package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import java.io.File;
import java.util.regex.Pattern;

@zzzb
public final class zzahs extends zzad {
    private final Context mContext;

    private zzahs(Context context, zzam zzam) {
        super(zzam);
        this.mContext = context;
    }

    public static zzs zzaz(Context context) {
        zzs zzs = new zzs(new zzag(new File(context.getCacheDir(), "admob_volley")), new zzahs(context, new zzan()));
        zzs.start();
        return zzs;
    }

    public final zzn zza(zzp<?> zzp) throws zzaa {
        if (zzp.zzh() && zzp.getMethod() == 0) {
            if (Pattern.matches((String) zzbs.zzep().zzd(zzmq.zzbou), zzp.getUrl())) {
                zzjk.zzhx();
                if (zzais.zzbd(this.mContext)) {
                    zzn zza = new zzrc(this.mContext).zza(zzp);
                    if (zza != null) {
                        String valueOf = String.valueOf(zzp.getUrl());
                        zzafj.m11v(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zza;
                    }
                    String valueOf2 = String.valueOf(zzp.getUrl());
                    zzafj.m11v(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zza(zzp);
    }
}
