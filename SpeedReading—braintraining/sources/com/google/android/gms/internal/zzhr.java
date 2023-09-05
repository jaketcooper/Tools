package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import java.io.InputStream;

@zzzb
public final class zzhr extends zzbej {
    public static final Parcelable.Creator<zzhr> CREATOR = new zzhs();
    @Nullable
    private ParcelFileDescriptor zzbaf;

    public zzhr() {
        this((ParcelFileDescriptor) null);
    }

    public zzhr(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbaf = parcelFileDescriptor;
    }

    private synchronized ParcelFileDescriptor zzhe() {
        return this.zzbaf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, (Parcelable) zzhe(), i, false);
        zzbem.zzai(parcel, zze);
    }

    public final synchronized boolean zzhc() {
        return this.zzbaf != null;
    }

    @Nullable
    public final synchronized InputStream zzhd() {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = null;
        synchronized (this) {
            if (this.zzbaf != null) {
                autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbaf);
                this.zzbaf = null;
            }
        }
        return autoCloseInputStream;
    }
}
