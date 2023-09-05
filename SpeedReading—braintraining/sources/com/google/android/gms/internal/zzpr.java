package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzpr extends zzee implements zzpq {
    public zzpr() {
        attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 2:
                IObjectWrapper zzjn = zzjn();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjn);
                break;
            case 3:
                String headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                break;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                break;
            case 5:
                String body = getBody();
                parcel2.writeNoException();
                parcel2.writeString(body);
                break;
            case 6:
                zzoy zzjt = zzjt();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjt);
                break;
            case 7:
                String callToAction = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(callToAction);
                break;
            case 8:
                String advertiser = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(advertiser);
                break;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzef.zzb(parcel2, extras);
                break;
            case 10:
                destroy();
                parcel2.writeNoException();
                break;
            case 11:
                zzku videoController = getVideoController();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) videoController);
                break;
            case 12:
                performClick((Bundle) zzef.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                boolean recordImpression = recordImpression((Bundle) zzef.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzef.zza(parcel2, recordImpression);
                break;
            case 14:
                reportTouchEvent((Bundle) zzef.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                break;
            case 15:
                zzou zzjs = zzjs();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjs);
                break;
            case 16:
                IObjectWrapper zzjr = zzjr();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzjr);
                break;
            case 17:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                break;
            default:
                return false;
        }
        return true;
    }
}
