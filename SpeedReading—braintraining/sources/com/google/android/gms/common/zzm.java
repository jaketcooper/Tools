package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzau;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;

public final class zzm extends zzbej {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
    private final String zzfiw;
    private final zzg zzfix;
    private final boolean zzfiy;

    zzm(String str, IBinder iBinder, boolean z) {
        this.zzfiw = str;
        this.zzfix = zzaj(iBinder);
        this.zzfiy = z;
    }

    zzm(String str, zzg zzg, boolean z) {
        this.zzfiw = str;
        this.zzfix = zzg;
        this.zzfiy = z;
    }

    private static zzg zzaj(IBinder iBinder) {
        zzh zzh;
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzafp = zzau.zzal(iBinder).zzafp();
            byte[] bArr = zzafp == null ? null : (byte[]) zzn.zzx(zzafp);
            if (bArr != null) {
                zzh = new zzh(bArr);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                zzh = null;
            }
            return zzh;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder asBinder;
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 1, this.zzfiw, false);
        if (this.zzfix == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = this.zzfix.asBinder();
        }
        zzbem.zza(parcel, 2, asBinder, false);
        zzbem.zza(parcel, 3, this.zzfiy);
        zzbem.zzai(parcel, zze);
    }
}
