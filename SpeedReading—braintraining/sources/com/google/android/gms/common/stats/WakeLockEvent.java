package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbem;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzd();
    private final long mTimeout;
    private int zzdzm;
    private final long zzgbb;
    private int zzgbc;
    private final String zzgbd;
    private final String zzgbe;
    private final String zzgbf;
    private final int zzgbg;
    private final List<String> zzgbh;
    private final String zzgbi;
    private final long zzgbj;
    private int zzgbk;
    private final String zzgbl;
    private final float zzgbm;
    private long zzgbn;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.zzdzm = i;
        this.zzgbb = j;
        this.zzgbc = i2;
        this.zzgbd = str;
        this.zzgbe = str3;
        this.zzgbf = str5;
        this.zzgbg = i3;
        this.zzgbn = -1;
        this.zzgbh = list;
        this.zzgbi = str2;
        this.zzgbj = j2;
        this.zzgbk = i4;
        this.zzgbl = str4;
        this.zzgbm = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public final int getEventType() {
        return this.zzgbc;
    }

    public final long getTimeMillis() {
        return this.zzgbb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zzc(parcel, 1, this.zzdzm);
        zzbem.zza(parcel, 2, getTimeMillis());
        zzbem.zza(parcel, 4, this.zzgbd, false);
        zzbem.zzc(parcel, 5, this.zzgbg);
        zzbem.zzb(parcel, 6, this.zzgbh, false);
        zzbem.zza(parcel, 8, this.zzgbj);
        zzbem.zza(parcel, 10, this.zzgbe, false);
        zzbem.zzc(parcel, 11, getEventType());
        zzbem.zza(parcel, 12, this.zzgbi, false);
        zzbem.zza(parcel, 13, this.zzgbl, false);
        zzbem.zzc(parcel, 14, this.zzgbk);
        zzbem.zza(parcel, 15, this.zzgbm);
        zzbem.zza(parcel, 16, this.mTimeout);
        zzbem.zza(parcel, 17, this.zzgbf, false);
        zzbem.zzai(parcel, zze);
    }

    public final long zzals() {
        return this.zzgbn;
    }

    public final String zzalt() {
        String str = this.zzgbd;
        int i = this.zzgbg;
        String join = this.zzgbh == null ? "" : TextUtils.join(",", this.zzgbh);
        int i2 = this.zzgbk;
        String str2 = this.zzgbe == null ? "" : this.zzgbe;
        String str3 = this.zzgbl == null ? "" : this.zzgbl;
        float f = this.zzgbm;
        String str4 = this.zzgbf == null ? "" : this.zzgbf;
        return new StringBuilder(String.valueOf("\t").length() + 37 + String.valueOf(str).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(join).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str2).length() + String.valueOf("\t").length() + String.valueOf(str3).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str4).length()).append("\t").append(str).append("\t").append(i).append("\t").append(join).append("\t").append(i2).append("\t").append(str2).append("\t").append(str3).append("\t").append(f).append("\t").append(str4).toString();
    }
}
