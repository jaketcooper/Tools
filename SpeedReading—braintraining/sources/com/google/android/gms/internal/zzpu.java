package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzpu extends IInterface {
    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzku getVideoController() throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    String zzao(String str) throws RemoteException;

    zzoy zzap(String str) throws RemoteException;

    boolean zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzjn() throws RemoteException;

    IObjectWrapper zzju() throws RemoteException;
}
