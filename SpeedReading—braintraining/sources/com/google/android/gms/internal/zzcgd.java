package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public final class zzcgd extends zzed implements zzcgb {
    zzcgd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<zzckk> zza(zzcff zzcff, boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcff);
        zzef.zza(zzaz, z);
        Parcel zza = zza(7, zzaz);
        ArrayList<zzckk> createTypedArrayList = zza.createTypedArrayList(zzckk.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzcfi> zza(String str, String str2, zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzef.zza(zzaz, (Parcelable) zzcff);
        Parcel zza = zza(16, zzaz);
        ArrayList<zzcfi> createTypedArrayList = zza.createTypedArrayList(zzcfi.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzckk> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzaz.writeString(str3);
        zzef.zza(zzaz, z);
        Parcel zza = zza(15, zzaz);
        ArrayList<zzckk> createTypedArrayList = zza.createTypedArrayList(zzckk.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzckk> zza(String str, String str2, boolean z, zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzef.zza(zzaz, z);
        zzef.zza(zzaz, (Parcelable) zzcff);
        Parcel zza = zza(14, zzaz);
        ArrayList<zzckk> createTypedArrayList = zza.createTypedArrayList(zzckk.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeLong(j);
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzaz.writeString(str3);
        zzb(10, zzaz);
    }

    public final void zza(zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcff);
        zzb(4, zzaz);
    }

    public final void zza(zzcfi zzcfi, zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcfi);
        zzef.zza(zzaz, (Parcelable) zzcff);
        zzb(12, zzaz);
    }

    public final void zza(zzcfx zzcfx, zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcfx);
        zzef.zza(zzaz, (Parcelable) zzcff);
        zzb(1, zzaz);
    }

    public final void zza(zzcfx zzcfx, String str, String str2) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcfx);
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzb(5, zzaz);
    }

    public final void zza(zzckk zzckk, zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzckk);
        zzef.zza(zzaz, (Parcelable) zzcff);
        zzb(2, zzaz);
    }

    public final byte[] zza(zzcfx zzcfx, String str) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcfx);
        zzaz.writeString(str);
        Parcel zza = zza(9, zzaz);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    public final void zzb(zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcff);
        zzb(6, zzaz);
    }

    public final void zzb(zzcfi zzcfi) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcfi);
        zzb(13, zzaz);
    }

    public final String zzc(zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcff);
        Parcel zza = zza(11, zzaz);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zzd(zzcff zzcff) throws RemoteException {
        Parcel zzaz = zzaz();
        zzef.zza(zzaz, (Parcelable) zzcff);
        zzb(18, zzaz);
    }

    public final List<zzcfi> zzj(String str, String str2, String str3) throws RemoteException {
        Parcel zzaz = zzaz();
        zzaz.writeString(str);
        zzaz.writeString(str2);
        zzaz.writeString(str3);
        Parcel zza = zza(17, zzaz);
        ArrayList<zzcfi> createTypedArrayList = zza.createTypedArrayList(zzcfi.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }
}
