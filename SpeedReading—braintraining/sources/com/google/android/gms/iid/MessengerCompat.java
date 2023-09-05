package com.google.android.gms.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class MessengerCompat implements ReflectedParcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzk();
    private Messenger zzidb;
    private zzi zzidc;

    public MessengerCompat(IBinder iBinder) {
        zzi zzj;
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzidb = new Messenger(iBinder);
            return;
        }
        if (iBinder == null) {
            zzj = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzj = queryLocalInterface instanceof zzi ? (zzi) queryLocalInterface : new zzj(iBinder);
        }
        this.zzidc = zzj;
    }

    private final IBinder getBinder() {
        return this.zzidb != null ? this.zzidb.getBinder() : this.zzidc.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) throws RemoteException {
        if (this.zzidb != null) {
            this.zzidb.send(message);
        } else {
            this.zzidc.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzidb != null) {
            parcel.writeStrongBinder(this.zzidb.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzidc.asBinder());
        }
    }
}
