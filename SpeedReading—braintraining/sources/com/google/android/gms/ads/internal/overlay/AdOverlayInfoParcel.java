package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.zzao;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzbej;
import com.google.android.gms.internal.zzbem;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class AdOverlayInfoParcel extends zzbej implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzm();
    public final int orientation;
    public final String url;
    public final zzaiy zzatd;
    public final zzc zzchg;
    public final zzin zzchh;
    public final zzn zzchi;
    public final zzama zzchj;
    public final zzb zzchk;
    public final String zzchl;
    public final boolean zzchm;
    public final String zzchn;
    public final zzq zzcho;
    public final int zzchp;
    public final String zzchq;
    public final zzao zzchr;

    AdOverlayInfoParcel(zzc zzc, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzaiy zzaiy, String str4, zzao zzao) {
        this.zzchg = zzc;
        this.zzchh = (zzin) zzn.zzx(IObjectWrapper.zza.zzap(iBinder));
        this.zzchi = (zzn) zzn.zzx(IObjectWrapper.zza.zzap(iBinder2));
        this.zzchj = (zzama) zzn.zzx(IObjectWrapper.zza.zzap(iBinder3));
        this.zzchk = (zzb) zzn.zzx(IObjectWrapper.zza.zzap(iBinder4));
        this.zzchl = str;
        this.zzchm = z;
        this.zzchn = str2;
        this.zzcho = (zzq) zzn.zzx(IObjectWrapper.zza.zzap(iBinder5));
        this.orientation = i;
        this.zzchp = i2;
        this.url = str3;
        this.zzatd = zzaiy;
        this.zzchq = str4;
        this.zzchr = zzao;
    }

    public AdOverlayInfoParcel(zzc zzc, zzin zzin, zzn zzn, zzq zzq, zzaiy zzaiy) {
        this.zzchg = zzc;
        this.zzchh = zzin;
        this.zzchi = zzn;
        this.zzchj = null;
        this.zzchk = null;
        this.zzchl = null;
        this.zzchm = false;
        this.zzchn = null;
        this.zzcho = zzq;
        this.orientation = -1;
        this.zzchp = 4;
        this.url = null;
        this.zzatd = zzaiy;
        this.zzchq = null;
        this.zzchr = null;
    }

    public AdOverlayInfoParcel(zzin zzin, zzn zzn, zzb zzb, zzq zzq, zzama zzama, boolean z, int i, String str, zzaiy zzaiy) {
        this.zzchg = null;
        this.zzchh = zzin;
        this.zzchi = zzn;
        this.zzchj = zzama;
        this.zzchk = zzb;
        this.zzchl = null;
        this.zzchm = z;
        this.zzchn = null;
        this.zzcho = zzq;
        this.orientation = i;
        this.zzchp = 3;
        this.url = str;
        this.zzatd = zzaiy;
        this.zzchq = null;
        this.zzchr = null;
    }

    public AdOverlayInfoParcel(zzin zzin, zzn zzn, zzb zzb, zzq zzq, zzama zzama, boolean z, int i, String str, String str2, zzaiy zzaiy) {
        this.zzchg = null;
        this.zzchh = zzin;
        this.zzchi = zzn;
        this.zzchj = zzama;
        this.zzchk = zzb;
        this.zzchl = str2;
        this.zzchm = z;
        this.zzchn = str;
        this.zzcho = zzq;
        this.orientation = i;
        this.zzchp = 3;
        this.url = null;
        this.zzatd = zzaiy;
        this.zzchq = null;
        this.zzchr = null;
    }

    public AdOverlayInfoParcel(zzin zzin, zzn zzn, zzq zzq, zzama zzama, int i, zzaiy zzaiy, String str, zzao zzao) {
        this.zzchg = null;
        this.zzchh = zzin;
        this.zzchi = zzn;
        this.zzchj = zzama;
        this.zzchk = null;
        this.zzchl = null;
        this.zzchm = false;
        this.zzchn = null;
        this.zzcho = zzq;
        this.orientation = i;
        this.zzchp = 1;
        this.url = null;
        this.zzatd = zzaiy;
        this.zzchq = str;
        this.zzchr = zzao;
    }

    public AdOverlayInfoParcel(zzin zzin, zzn zzn, zzq zzq, zzama zzama, boolean z, int i, zzaiy zzaiy) {
        this.zzchg = null;
        this.zzchh = zzin;
        this.zzchi = zzn;
        this.zzchj = zzama;
        this.zzchk = null;
        this.zzchl = null;
        this.zzchm = z;
        this.zzchn = null;
        this.zzcho = zzq;
        this.orientation = i;
        this.zzchp = 2;
        this.url = null;
        this.zzatd = zzaiy;
        this.zzchq = null;
        this.zzchr = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, (Parcelable) this.zzchg, i, false);
        zzbem.zza(parcel, 3, zzn.zzy(this.zzchh).asBinder(), false);
        zzbem.zza(parcel, 4, zzn.zzy(this.zzchi).asBinder(), false);
        zzbem.zza(parcel, 5, zzn.zzy(this.zzchj).asBinder(), false);
        zzbem.zza(parcel, 6, zzn.zzy(this.zzchk).asBinder(), false);
        zzbem.zza(parcel, 7, this.zzchl, false);
        zzbem.zza(parcel, 8, this.zzchm);
        zzbem.zza(parcel, 9, this.zzchn, false);
        zzbem.zza(parcel, 10, zzn.zzy(this.zzcho).asBinder(), false);
        zzbem.zzc(parcel, 11, this.orientation);
        zzbem.zzc(parcel, 12, this.zzchp);
        zzbem.zza(parcel, 13, this.url, false);
        zzbem.zza(parcel, 14, (Parcelable) this.zzatd, i, false);
        zzbem.zza(parcel, 16, this.zzchq, false);
        zzbem.zza(parcel, 17, (Parcelable) this.zzchr, i, false);
        zzbem.zzai(parcel, zze);
    }
}
