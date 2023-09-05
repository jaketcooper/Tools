package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

@zzzb
public final class zzaiy extends zzbej {
    public static final Parcelable.Creator<zzaiy> CREATOR = new zzaiz();
    public String zzcp;
    public int zzdbz;
    public int zzdca;
    public boolean zzdcb;
    public boolean zzdcc;

    public zzaiy(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzaiy(int i, int i2, boolean z, boolean z2) {
        this(11717000, i2, true, false, z2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzaiy(int r7, int r8, boolean r9, boolean r10, boolean r11) {
        /*
            r6 = this;
            java.lang.String r1 = "afma-sdk-a-v"
            if (r9 == 0) goto L_0x0047
            java.lang.String r0 = "0"
        L_0x0006:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 24
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r2 = "."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = "."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r11
            r0.<init>((java.lang.String) r1, (int) r2, (int) r3, (boolean) r4, (boolean) r5)
            return
        L_0x0047:
            java.lang.String r0 = "1"
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaiy.<init>(int, int, boolean, boolean, boolean):void");
    }

    zzaiy(String str, int i, int i2, boolean z, boolean z2) {
        this.zzcp = str;
        this.zzdbz = i;
        this.zzdca = i2;
        this.zzdcb = z;
        this.zzdcc = z2;
    }

    public static zzaiy zzqv() {
        return new zzaiy(11717208, 11717208, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzcp, false);
        zzbem.zzc(parcel, 3, this.zzdbz);
        zzbem.zzc(parcel, 4, this.zzdca);
        zzbem.zza(parcel, 5, this.zzdcb);
        zzbem.zza(parcel, 6, this.zzdcc);
        zzbem.zzai(parcel, zze);
    }
}
