package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzpv extends zzee implements zzpu {
    public zzpv() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzpu zzn(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return queryLocalInterface instanceof zzpu ? (zzpu) queryLocalInterface : new zzpw(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                String zzao = zzao(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzao);
                return true;
            case 2:
                zzoy zzap = zzap(parcel.readString());
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzap);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzku videoController = getVideoController();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) videoController);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper zzju = zzju();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzju);
                return true;
            case 10:
                boolean zzf = zzf(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzef.zza(parcel2, zzf);
                return true;
            case 11:
                IObjectWrapper zzjn = zzjn();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjn);
                return true;
            default:
                return false;
        }
    }
}
