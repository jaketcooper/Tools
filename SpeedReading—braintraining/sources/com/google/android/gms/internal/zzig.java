package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@zzzb
public final class zzig {
    zzeu zzbbd;
    boolean zzbbe;

    public zzig() {
    }

    public zzig(Context context) {
        zzmq.initialize(context);
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbpk)).booleanValue()) {
            try {
                this.zzbbd = zzev.zzb(DynamiteModule.zza(context, DynamiteModule.zzgum, ModuleDescriptor.MODULE_ID).zzgx("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
                zzn.zzy(context);
                this.zzbbd.zza(zzn.zzy(context), "GMA_SDK");
                this.zzbbe = true;
            } catch (RemoteException | DynamiteModule.zzc | NullPointerException e) {
                zzafj.m11v("Cannot dynamite load clearcut");
            }
        }
    }

    public zzig(Context context, String str, String str2) {
        zzmq.initialize(context);
        try {
            this.zzbbd = zzev.zzb(DynamiteModule.zza(context, DynamiteModule.zzgum, ModuleDescriptor.MODULE_ID).zzgx("com.google.android.gms.ads.clearcut.DynamiteClearcutLogger"));
            zzn.zzy(context);
            this.zzbbd.zza(zzn.zzy(context), str, (String) null);
            this.zzbbe = true;
        } catch (RemoteException | DynamiteModule.zzc | NullPointerException e) {
            zzafj.m11v("Cannot dynamite load clearcut");
        }
    }

    public final zzii zzd(byte[] bArr) {
        return new zzii(this, bArr);
    }
}
