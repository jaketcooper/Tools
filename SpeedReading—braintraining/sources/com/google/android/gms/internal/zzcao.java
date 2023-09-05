package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzcao extends zzbej {
    public static final Parcelable.Creator<zzcao> CREATOR = new zzcap();
    private int versionCode;
    private zzaw zzhzg = null;
    private byte[] zzhzh;

    zzcao(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzhzh = bArr;
        zzamy();
    }

    private final void zzamy() {
        if (this.zzhzg == null && this.zzhzh != null) {
            return;
        }
        if (this.zzhzg != null && this.zzhzh == null) {
            return;
        }
        if (this.zzhzg != null && this.zzhzh != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.zzhzg == null && this.zzhzh == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.versionCode);
        zzbem.zza(parcel, 2, this.zzhzh != null ? this.zzhzh : zzfhs.zzc(this.zzhzg), false);
        zzbem.zzai(parcel, zze);
    }

    public final zzaw zzaug() {
        if (!(this.zzhzg != null)) {
            try {
                this.zzhzg = (zzaw) zzfhs.zza(new zzaw(), this.zzhzh);
                this.zzhzh = null;
            } catch (zzfhr e) {
                throw new IllegalStateException(e);
            }
        }
        zzamy();
        return this.zzhzg;
    }
}
