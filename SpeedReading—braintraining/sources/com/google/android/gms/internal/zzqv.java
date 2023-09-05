package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

@zzzb
public final class zzqv extends zzd<zzra> {
    zzqv(Context context, Looper looper, zzf zzf, zzg zzg) {
        super(context, looper, 166, zzf, zzg, (String) null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        return queryLocalInterface instanceof zzra ? (zzra) queryLocalInterface : new zzrb(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String zzhf() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    /* access modifiers changed from: protected */
    public final String zzhg() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    public final zzra zzkn() throws DeadObjectException {
        return (zzra) super.zzakc();
    }
}
