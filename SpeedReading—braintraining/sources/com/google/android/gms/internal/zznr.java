package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzb
public final class zznr extends zzoz {
    private final Uri mUri;
    private final Drawable zzbrv;
    private final double zzbrw;

    public zznr(Drawable drawable, Uri uri, double d) {
        this.zzbrv = drawable;
        this.mUri = uri;
        this.zzbrw = d;
    }

    public final double getScale() {
        return this.zzbrw;
    }

    public final Uri getUri() throws RemoteException {
        return this.mUri;
    }

    public final IObjectWrapper zzjl() throws RemoteException {
        return zzn.zzy(this.zzbrv);
    }
}
