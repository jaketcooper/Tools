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
public final class zzzy extends zzd<zzaah> {
    private int zzclm;

    public zzzy(Context context, Looper looper, zzf zzf, zzg zzg, int i) {
        super(context, looper, 8, zzf, zzg, (String) null);
        this.zzclm = i;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        return queryLocalInterface instanceof zzaah ? (zzaah) queryLocalInterface : new zzaaj(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String zzhf() {
        return "com.google.android.gms.ads.service.START";
    }

    /* access modifiers changed from: protected */
    public final String zzhg() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public final zzaah zzng() throws DeadObjectException {
        return (zzaah) super.zzakc();
    }
}
