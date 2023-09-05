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
public final class zzht extends zzd<zzhx> {
    zzht(Context context, Looper looper, zzf zzf, zzg zzg) {
        super(context, looper, 123, zzf, zzg, (String) null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        return queryLocalInterface instanceof zzhx ? (zzhx) queryLocalInterface : new zzhy(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String zzhf() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    /* access modifiers changed from: protected */
    public final String zzhg() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public final zzhx zzhh() throws DeadObjectException {
        return (zzhx) super.zzakc();
    }
}
