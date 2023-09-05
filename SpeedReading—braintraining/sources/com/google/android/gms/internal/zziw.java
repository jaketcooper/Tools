package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzb;

@zzzb
public class zziw extends zzbej {
    public static final Parcelable.Creator<zziw> CREATOR = new zzix();
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final String zzbda;
    public final boolean zzbdb;
    public final zziw[] zzbdc;
    public final boolean zzbdd;
    public final boolean zzbde;
    public boolean zzbdf;

    public zziw() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zziw[]) null, false, false, false);
    }

    public zziw(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zziw(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r1 = 1
            r2 = 0
            r12.<init>()
            r6 = r14[r2]
            r12.zzbdb = r2
            boolean r0 = r6.isFluid()
            r12.zzbde = r0
            boolean r0 = r12.zzbde
            if (r0 == 0) goto L_0x00bc
            com.google.android.gms.ads.AdSize r0 = com.google.android.gms.ads.AdSize.BANNER
            int r0 = r0.getWidth()
            r12.width = r0
            com.google.android.gms.ads.AdSize r0 = com.google.android.gms.ads.AdSize.BANNER
            int r0 = r0.getHeight()
            r12.height = r0
        L_0x0023:
            int r0 = r12.width
            r3 = -1
            if (r0 != r3) goto L_0x00ca
            r0 = r1
        L_0x0029:
            int r3 = r12.height
            r4 = -2
            if (r3 != r4) goto L_0x00cd
            r3 = r1
        L_0x002f:
            android.content.res.Resources r4 = r13.getResources()
            android.util.DisplayMetrics r7 = r4.getDisplayMetrics()
            if (r0 == 0) goto L_0x00d5
            com.google.android.gms.internal.zzjk.zzhx()
            boolean r4 = com.google.android.gms.internal.zzais.zzbf(r13)
            if (r4 == 0) goto L_0x00d0
            com.google.android.gms.internal.zzjk.zzhx()
            boolean r4 = com.google.android.gms.internal.zzais.zzbg(r13)
            if (r4 == 0) goto L_0x00d0
            int r4 = r7.widthPixels
            com.google.android.gms.internal.zzjk.zzhx()
            int r5 = com.google.android.gms.internal.zzais.zzbh(r13)
            int r4 = r4 - r5
            r12.widthPixels = r4
        L_0x0057:
            int r4 = r12.widthPixels
            float r4 = (float) r4
            float r5 = r7.density
            float r4 = r4 / r5
            double r8 = (double) r4
            int r4 = (int) r8
            int r5 = (int) r8
            double r10 = (double) r5
            double r8 = r8 - r10
            r10 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x006d
            int r4 = r4 + 1
        L_0x006d:
            r5 = r4
        L_0x006e:
            if (r3 == 0) goto L_0x00e4
            int r4 = zzd(r7)
        L_0x0074:
            com.google.android.gms.internal.zzjk.zzhx()
            int r7 = com.google.android.gms.internal.zzais.zza((android.util.DisplayMetrics) r7, (int) r4)
            r12.heightPixels = r7
            if (r0 != 0) goto L_0x0081
            if (r3 == 0) goto L_0x00e7
        L_0x0081:
            r0 = 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.StringBuilder r0 = r3.append(r5)
            java.lang.String r3 = "x"
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r3 = "_as"
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            r12.zzbda = r0
        L_0x00a2:
            int r0 = r14.length
            if (r0 <= r1) goto L_0x00f7
            int r0 = r14.length
            com.google.android.gms.internal.zziw[] r0 = new com.google.android.gms.internal.zziw[r0]
            r12.zzbdc = r0
            r0 = r2
        L_0x00ab:
            int r1 = r14.length
            if (r0 >= r1) goto L_0x00fa
            com.google.android.gms.internal.zziw[] r1 = r12.zzbdc
            com.google.android.gms.internal.zziw r3 = new com.google.android.gms.internal.zziw
            r4 = r14[r0]
            r3.<init>((android.content.Context) r13, (com.google.android.gms.ads.AdSize) r4)
            r1[r0] = r3
            int r0 = r0 + 1
            goto L_0x00ab
        L_0x00bc:
            int r0 = r6.getWidth()
            r12.width = r0
            int r0 = r6.getHeight()
            r12.height = r0
            goto L_0x0023
        L_0x00ca:
            r0 = r2
            goto L_0x0029
        L_0x00cd:
            r3 = r2
            goto L_0x002f
        L_0x00d0:
            int r4 = r7.widthPixels
            r12.widthPixels = r4
            goto L_0x0057
        L_0x00d5:
            int r4 = r12.width
            com.google.android.gms.internal.zzjk.zzhx()
            int r5 = r12.width
            int r5 = com.google.android.gms.internal.zzais.zza((android.util.DisplayMetrics) r7, (int) r5)
            r12.widthPixels = r5
            r5 = r4
            goto L_0x006e
        L_0x00e4:
            int r4 = r12.height
            goto L_0x0074
        L_0x00e7:
            boolean r0 = r12.zzbde
            if (r0 == 0) goto L_0x00f0
            java.lang.String r0 = "320x50_mb"
            r12.zzbda = r0
            goto L_0x00a2
        L_0x00f0:
            java.lang.String r0 = r6.toString()
            r12.zzbda = r0
            goto L_0x00a2
        L_0x00f7:
            r0 = 0
            r12.zzbdc = r0
        L_0x00fa:
            r12.zzbdd = r2
            r12.zzbdf = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zziw.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    public zziw(zziw zziw, zziw[] zziwArr) {
        this(zziw.zzbda, zziw.height, zziw.heightPixels, zziw.zzbdb, zziw.width, zziw.widthPixels, zziwArr, zziw.zzbdd, zziw.zzbde, zziw.zzbdf);
    }

    zziw(String str, int i, int i2, boolean z, int i3, int i4, zziw[] zziwArr, boolean z2, boolean z3, boolean z4) {
        this.zzbda = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzbdb = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzbdc = zziwArr;
        this.zzbdd = z2;
        this.zzbde = z3;
        this.zzbdf = z4;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zziw zzg(Context context) {
        return new zziw("320x50_mb", 0, 0, false, 0, 0, (zziw[]) null, true, false, false);
    }

    public static zziw zzhp() {
        return new zziw("reward_mb", 0, 0, true, 0, 0, (zziw[]) null, false, false, false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, this.zzbda, false);
        zzbem.zzc(parcel, 3, this.height);
        zzbem.zzc(parcel, 4, this.heightPixels);
        zzbem.zza(parcel, 5, this.zzbdb);
        zzbem.zzc(parcel, 6, this.width);
        zzbem.zzc(parcel, 7, this.widthPixels);
        zzbem.zza(parcel, 8, (T[]) this.zzbdc, i, false);
        zzbem.zza(parcel, 9, this.zzbdd);
        zzbem.zza(parcel, 10, this.zzbde);
        zzbem.zza(parcel, 11, this.zzbdf);
        zzbem.zzai(parcel, zze);
    }

    public final AdSize zzhq() {
        return zzb.zza(this.width, this.height, this.zzbda);
    }
}
