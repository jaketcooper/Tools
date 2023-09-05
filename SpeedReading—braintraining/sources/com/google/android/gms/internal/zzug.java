package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzug extends zzee implements zzuf {
    public zzug() {
        attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzui zzuk;
        zzui zzuk2;
        zzui zzuk3;
        zzui zzui = null;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                IObjectWrapper zzap = IObjectWrapper.zza.zzap(parcel.readStrongBinder());
                zziw zziw = (zziw) zzef.zza(parcel, zziw.CREATOR);
                zzis zzis = (zzis) zzef.zza(parcel, zzis.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzuk3 = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzuk3 = queryLocalInterface instanceof zzui ? (zzui) queryLocalInterface : new zzuk(readStrongBinder);
                }
                zza(zzap, zziw, zzis, readString, zzuk3);
                parcel2.writeNoException();
                break;
            case 2:
                IObjectWrapper view = getView();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) view);
                break;
            case 3:
                IObjectWrapper zzap2 = IObjectWrapper.zza.zzap(parcel.readStrongBinder());
                zzis zzis2 = (zzis) zzef.zza(parcel, zzis.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzui = queryLocalInterface2 instanceof zzui ? (zzui) queryLocalInterface2 : new zzuk(readStrongBinder2);
                }
                zza(zzap2, zzis2, readString2, zzui);
                parcel2.writeNoException();
                break;
            case 4:
                showInterstitial();
                parcel2.writeNoException();
                break;
            case 5:
                destroy();
                parcel2.writeNoException();
                break;
            case 6:
                IObjectWrapper zzap3 = IObjectWrapper.zza.zzap(parcel.readStrongBinder());
                zziw zziw2 = (zziw) zzef.zza(parcel, zziw.CREATOR);
                zzis zzis3 = (zzis) zzef.zza(parcel, zzis.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzui = queryLocalInterface3 instanceof zzui ? (zzui) queryLocalInterface3 : new zzuk(readStrongBinder3);
                }
                zza(zzap3, zziw2, zzis3, readString3, readString4, zzui);
                parcel2.writeNoException();
                break;
            case 7:
                IObjectWrapper zzap4 = IObjectWrapper.zza.zzap(parcel.readStrongBinder());
                zzis zzis4 = (zzis) zzef.zza(parcel, zzis.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    zzuk2 = null;
                } else {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzuk2 = queryLocalInterface4 instanceof zzui ? (zzui) queryLocalInterface4 : new zzuk(readStrongBinder4);
                }
                zza(zzap4, zzis4, readString5, readString6, zzuk2);
                parcel2.writeNoException();
                break;
            case 8:
                pause();
                parcel2.writeNoException();
                break;
            case 9:
                resume();
                parcel2.writeNoException();
                break;
            case 10:
                zza(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), (zzis) zzef.zza(parcel, zzis.CREATOR), parcel.readString(), zzadt.zzaa(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                zzc((zzis) zzef.zza(parcel, zzis.CREATOR), parcel.readString());
                parcel2.writeNoException();
                break;
            case 12:
                showVideo();
                parcel2.writeNoException();
                break;
            case 13:
                boolean isInitialized = isInitialized();
                parcel2.writeNoException();
                zzef.zza(parcel2, isInitialized);
                break;
            case 14:
                IObjectWrapper zzap5 = IObjectWrapper.zza.zzap(parcel.readStrongBinder());
                zzis zzis5 = (zzis) zzef.zza(parcel, zzis.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 == null) {
                    zzuk = null;
                } else {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzuk = queryLocalInterface5 instanceof zzui ? (zzui) queryLocalInterface5 : new zzuk(readStrongBinder5);
                }
                zza(zzap5, zzis5, readString7, readString8, zzuk, (zzom) zzef.zza(parcel, zzom.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 15:
                zzuo zzly = zzly();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzly);
                break;
            case 16:
                zzur zzlz = zzlz();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzlz);
                break;
            case 17:
                Bundle zzma = zzma();
                parcel2.writeNoException();
                zzef.zzb(parcel2, zzma);
                break;
            case 18:
                Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                parcel2.writeNoException();
                zzef.zzb(parcel2, interstitialAdapterInfo);
                break;
            case 19:
                Bundle zzmb = zzmb();
                parcel2.writeNoException();
                zzef.zzb(parcel2, zzmb);
                break;
            case 20:
                zza((zzis) zzef.zza(parcel, zzis.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 21:
                zzg(IObjectWrapper.zza.zzap(parcel.readStrongBinder()));
                parcel2.writeNoException();
                break;
            case 22:
                boolean zzmc = zzmc();
                parcel2.writeNoException();
                zzef.zza(parcel2, zzmc);
                break;
            case 23:
                zza(IObjectWrapper.zza.zzap(parcel.readStrongBinder()), zzadt.zzaa(parcel.readStrongBinder()), (List<String>) parcel.createStringArrayList());
                parcel2.writeNoException();
                break;
            case 24:
                zzpu zzmd = zzmd();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) zzmd);
                break;
            case 25:
                setImmersiveMode(zzef.zza(parcel));
                parcel2.writeNoException();
                break;
            case 26:
                zzku videoController = getVideoController();
                parcel2.writeNoException();
                zzef.zza(parcel2, (IInterface) videoController);
                break;
            default:
                return false;
        }
        return true;
    }
}
