package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzkb extends IInterface {
    void destroy() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzku getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzacv zzacv) throws RemoteException;

    void zza(zziw zziw) throws RemoteException;

    void zza(zzjn zzjn) throws RemoteException;

    void zza(zzjq zzjq) throws RemoteException;

    void zza(zzkg zzkg) throws RemoteException;

    void zza(zzkm zzkm) throws RemoteException;

    void zza(zzla zzla) throws RemoteException;

    void zza(zzma zzma) throws RemoteException;

    void zza(zznj zznj) throws RemoteException;

    void zza(zzwq zzwq) throws RemoteException;

    void zza(zzww zzww, String str) throws RemoteException;

    boolean zzb(zzis zzis) throws RemoteException;

    IObjectWrapper zzbl() throws RemoteException;

    zziw zzbm() throws RemoteException;

    void zzbo() throws RemoteException;

    zzkg zzbx() throws RemoteException;

    zzjq zzby() throws RemoteException;

    String zzcj() throws RemoteException;
}
