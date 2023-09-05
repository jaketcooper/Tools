package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.Nullable;

@zzzb
public final class zzala extends zzakv {
    @Nullable
    public final zzaku zza(Context context, zzali zzali, int i, boolean z, zznd zznd, zzalh zzalh) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(applicationInfo == null || applicationInfo.targetSdkVersion >= 11)) {
            return null;
        }
        return new zzakk(context, z, zzali.zzso().zztx(), zzalh, new zzalj(context, zzali.zzsb(), zzali.getRequestId(), zznd, zzali.zzry()));
    }
}
