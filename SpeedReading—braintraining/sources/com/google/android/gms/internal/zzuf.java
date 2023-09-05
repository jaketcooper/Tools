package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzuf extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzku getVideoController() throws RemoteException;

    IObjectWrapper getView() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzads zzads, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzads zzads, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, zzui zzui) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzis zzis, String str, String str2, zzui zzui, zzom zzom, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, zzui zzui) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zziw zziw, zzis zzis, String str, String str2, zzui zzui) throws RemoteException;

    void zza(zzis zzis, String str, String str2) throws RemoteException;

    void zzc(zzis zzis, String str) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzuo zzly() throws RemoteException;

    zzur zzlz() throws RemoteException;

    Bundle zzma() throws RemoteException;

    Bundle zzmb() throws RemoteException;

    boolean zzmc() throws RemoteException;

    zzpu zzmd() throws RemoteException;
}
