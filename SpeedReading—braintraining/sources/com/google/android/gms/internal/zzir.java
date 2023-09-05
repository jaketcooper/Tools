package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;
import com.google.android.gms.dynamic.zzq;

@zzzb
public final class zzir extends zzp<zzke> {
    public zzir() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzkb zza(Context context, zziw zziw, String str, zzuc zzuc, int i) {
        try {
            IBinder zza = ((zzke) zzdb(context)).zza(zzn.zzy(context), zziw, str, zzuc, 11717000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return queryLocalInterface instanceof zzkb ? (zzkb) queryLocalInterface : new zzkd(zza);
        } catch (RemoteException | zzq e) {
            zzaiw.zza("Could not create remote AdManager.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzke ? (zzke) queryLocalInterface : new zzkf(iBinder);
    }
}
