package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzus extends zzee implements zzur {
    public zzus() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 3:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 4:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                return true;
            case 5:
                zzoy zzjt = zzjt();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjt);
                return true;
            case 6:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                return true;
            case 7:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                return true;
            case 8:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 9:
                zzh(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                zzi(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                boolean overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzef.zza(parcel2, overrideImpressionRecording);
                return true;
            case 12:
                boolean overrideClickHandling = getOverrideClickHandling();
                parcel2.writeNoException();
                zzef.zza(parcel2, overrideClickHandling);
                return true;
            case 13:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzef.zzb(parcel2, extras);
                return true;
            case 14:
                zzj(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper zzme = zzme();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzme);
                return true;
            case 16:
                zzku videoController = getVideoController();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) videoController);
                return true;
            case 19:
                zzou zzjs = zzjs();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjs);
                return true;
            case 20:
                IObjectWrapper zzmf = zzmf();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzmf);
                return true;
            case 21:
                IObjectWrapper zzjr = zzjr();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjr);
                return true;
            default:
                return false;
        }
    }
}
