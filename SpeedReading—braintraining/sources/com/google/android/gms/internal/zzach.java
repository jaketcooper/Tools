package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONObject;

@zzzb
public final class zzach implements zzabl {
    private zzsu<JSONObject, JSONObject> zzcsx;
    private zzsu<JSONObject, JSONObject> zzctc;

    public zzach(Context context) {
        this.zzctc = zzbs.zzes().zzb(context, zzaiy.zzqv()).zza("google.afma.request.getAdDictionary", zzsz.zzcam, zzsz.zzcam);
        this.zzcsx = zzbs.zzes().zzb(context, zzaiy.zzqv()).zza("google.afma.sdkConstants.getSdkConstants", zzsz.zzcam, zzsz.zzcam);
    }

    public final zzsu<JSONObject, JSONObject> zznk() {
        return this.zzctc;
    }

    public final zzsu<JSONObject, JSONObject> zznl() {
        return this.zzcsx;
    }
}
