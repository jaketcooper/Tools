package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;

public final class zzcal extends zzd<zzcaq> {
    public zzcal(Context context, Looper looper, zzf zzf, zzg zzg) {
        super(context, looper, 116, zzf, zzg, (String) null);
    }

    public final zzcaq zzauf() throws DeadObjectException {
        return (zzcaq) super.zzakc();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        return queryLocalInterface instanceof zzcaq ? (zzcaq) queryLocalInterface : new zzcar(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String zzhf() {
        return "com.google.android.gms.gass.START";
    }

    /* access modifiers changed from: protected */
    public final String zzhg() {
        return "com.google.android.gms.gass.internal.IGassService";
    }
}
