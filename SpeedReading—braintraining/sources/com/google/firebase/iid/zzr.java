package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.iid.zzi;

final class zzr {
    private static String zznvf = zzi.class.getName();
    final Messenger zzidb;
    final MessengerCompat zznvg;

    zzr(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.zzidb = new Messenger(iBinder);
            this.zznvg = null;
        } else if (zznvf.equals(interfaceDescriptor)) {
            this.zznvg = new MessengerCompat(iBinder);
            this.zzidb = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }
}
