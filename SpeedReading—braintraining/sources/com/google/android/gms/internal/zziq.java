package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzp;
import com.google.android.gms.dynamic.zzq;

@zzzb
public final class zziq extends zzp<zzjz> {
    public zziq() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzjw zza(Context context, String str, zzuc zzuc) {
        try {
            IBinder zza = ((zzjz) zzdb(context)).zza(zzn.zzy(context), str, zzuc, 11717000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof zzjw ? (zzjw) queryLocalInterface : new zzjy(zza);
        } catch (RemoteException e) {
            zzaiw.zzc("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (zzq e2) {
            zzaiw.zzc("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return queryLocalInterface instanceof zzjz ? (zzjz) queryLocalInterface : new zzka(iBinder);
    }
}
