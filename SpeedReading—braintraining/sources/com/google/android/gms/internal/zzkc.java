package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzkc extends zzee implements zzkb {
    public zzkc() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzkb zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzkb ? (zzkb) queryLocalInterface : new zzkd(iBinder);
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v22, types: [com.google.android.gms.internal.zzkm] */
    /* JADX WARNING: type inference failed for: r0v27, types: [com.google.android.gms.internal.zzjn] */
    /* JADX WARNING: type inference failed for: r0v43, types: [com.google.android.gms.internal.zzkg] */
    /* JADX WARNING: type inference failed for: r0v48, types: [com.google.android.gms.internal.zzjq] */
    /* JADX WARNING: type inference failed for: r0v56 */
    /* JADX WARNING: type inference failed for: r0v57 */
    /* JADX WARNING: type inference failed for: r0v58 */
    /* JADX WARNING: type inference failed for: r0v59 */
    /* JADX WARNING: type inference failed for: r0v60 */
    /* JADX WARNING: type inference failed for: r0v61 */
    /* JADX WARNING: type inference failed for: r0v62 */
    /* JADX WARNING: type inference failed for: r0v63 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
        /*
            r4 = this;
            r1 = 1
            r0 = 0
            boolean r2 = r4.zza(r5, r6, r7, r8)
            if (r2 == 0) goto L_0x000a
            r0 = r1
        L_0x0009:
            return r0
        L_0x000a:
            switch(r5) {
                case 1: goto L_0x000f;
                case 2: goto L_0x001b;
                case 3: goto L_0x0022;
                case 4: goto L_0x002d;
                case 5: goto L_0x0040;
                case 6: goto L_0x0047;
                case 7: goto L_0x004e;
                case 8: goto L_0x006e;
                case 9: goto L_0x008e;
                case 10: goto L_0x0095;
                case 11: goto L_0x009d;
                case 12: goto L_0x00a5;
                case 13: goto L_0x00b1;
                case 14: goto L_0x00c1;
                case 15: goto L_0x00d1;
                case 16: goto L_0x000d;
                case 17: goto L_0x000d;
                case 18: goto L_0x00e5;
                case 19: goto L_0x00f1;
                case 20: goto L_0x0101;
                case 21: goto L_0x0122;
                case 22: goto L_0x0143;
                case 23: goto L_0x014f;
                case 24: goto L_0x015b;
                case 25: goto L_0x016b;
                case 26: goto L_0x0177;
                case 27: goto L_0x000d;
                case 28: goto L_0x000d;
                case 29: goto L_0x0183;
                case 30: goto L_0x0193;
                case 31: goto L_0x01a3;
                case 32: goto L_0x01af;
                case 33: goto L_0x01bb;
                case 34: goto L_0x01c7;
                case 35: goto L_0x01d3;
                default: goto L_0x000d;
            }
        L_0x000d:
            r0 = 0
            goto L_0x0009
        L_0x000f:
            com.google.android.gms.dynamic.IObjectWrapper r0 = r4.zzbl()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (android.os.IInterface) r0)
        L_0x0019:
            r0 = r1
            goto L_0x0009
        L_0x001b:
            r4.destroy()
            r7.writeNoException()
            goto L_0x0019
        L_0x0022:
            boolean r0 = r4.isReady()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (boolean) r0)
            goto L_0x0019
        L_0x002d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzis> r0 = com.google.android.gms.internal.zzis.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r6, r0)
            com.google.android.gms.internal.zzis r0 = (com.google.android.gms.internal.zzis) r0
            boolean r0 = r4.zzb(r0)
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (boolean) r0)
            goto L_0x0019
        L_0x0040:
            r4.pause()
            r7.writeNoException()
            goto L_0x0019
        L_0x0047:
            r4.resume()
            r7.writeNoException()
            goto L_0x0019
        L_0x004e:
            android.os.IBinder r2 = r6.readStrongBinder()
            if (r2 != 0) goto L_0x005b
        L_0x0054:
            r4.zza((com.google.android.gms.internal.zzjq) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x005b:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.zzjq
            if (r3 == 0) goto L_0x0068
            com.google.android.gms.internal.zzjq r0 = (com.google.android.gms.internal.zzjq) r0
            goto L_0x0054
        L_0x0068:
            com.google.android.gms.internal.zzjs r0 = new com.google.android.gms.internal.zzjs
            r0.<init>(r2)
            goto L_0x0054
        L_0x006e:
            android.os.IBinder r2 = r6.readStrongBinder()
            if (r2 != 0) goto L_0x007b
        L_0x0074:
            r4.zza((com.google.android.gms.internal.zzkg) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x007b:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.zzkg
            if (r3 == 0) goto L_0x0088
            com.google.android.gms.internal.zzkg r0 = (com.google.android.gms.internal.zzkg) r0
            goto L_0x0074
        L_0x0088:
            com.google.android.gms.internal.zzki r0 = new com.google.android.gms.internal.zzki
            r0.<init>(r2)
            goto L_0x0074
        L_0x008e:
            r4.showInterstitial()
            r7.writeNoException()
            goto L_0x0019
        L_0x0095:
            r4.stopLoading()
            r7.writeNoException()
            goto L_0x0019
        L_0x009d:
            r4.zzbo()
            r7.writeNoException()
            goto L_0x0019
        L_0x00a5:
            com.google.android.gms.internal.zziw r0 = r4.zzbm()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zzb(r7, r0)
            goto L_0x0019
        L_0x00b1:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zziw> r0 = com.google.android.gms.internal.zziw.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r6, r0)
            com.google.android.gms.internal.zziw r0 = (com.google.android.gms.internal.zziw) r0
            r4.zza((com.google.android.gms.internal.zziw) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x00c1:
            android.os.IBinder r0 = r6.readStrongBinder()
            com.google.android.gms.internal.zzwq r0 = com.google.android.gms.internal.zzwr.zzv(r0)
            r4.zza((com.google.android.gms.internal.zzwq) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x00d1:
            android.os.IBinder r0 = r6.readStrongBinder()
            com.google.android.gms.internal.zzww r0 = com.google.android.gms.internal.zzwx.zzx(r0)
            java.lang.String r2 = r6.readString()
            r4.zza(r0, r2)
            r7.writeNoException()
            goto L_0x0019
        L_0x00e5:
            java.lang.String r0 = r4.getMediationAdapterClassName()
            r7.writeNoException()
            r7.writeString(r0)
            goto L_0x0019
        L_0x00f1:
            android.os.IBinder r0 = r6.readStrongBinder()
            com.google.android.gms.internal.zznj r0 = com.google.android.gms.internal.zznk.zzi(r0)
            r4.zza((com.google.android.gms.internal.zznj) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0101:
            android.os.IBinder r2 = r6.readStrongBinder()
            if (r2 != 0) goto L_0x010f
        L_0x0107:
            r4.zza((com.google.android.gms.internal.zzjn) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x010f:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.zzjn
            if (r3 == 0) goto L_0x011c
            com.google.android.gms.internal.zzjn r0 = (com.google.android.gms.internal.zzjn) r0
            goto L_0x0107
        L_0x011c:
            com.google.android.gms.internal.zzjp r0 = new com.google.android.gms.internal.zzjp
            r0.<init>(r2)
            goto L_0x0107
        L_0x0122:
            android.os.IBinder r2 = r6.readStrongBinder()
            if (r2 != 0) goto L_0x0130
        L_0x0128:
            r4.zza((com.google.android.gms.internal.zzkm) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0130:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.zzkm
            if (r3 == 0) goto L_0x013d
            com.google.android.gms.internal.zzkm r0 = (com.google.android.gms.internal.zzkm) r0
            goto L_0x0128
        L_0x013d:
            com.google.android.gms.internal.zzko r0 = new com.google.android.gms.internal.zzko
            r0.<init>(r2)
            goto L_0x0128
        L_0x0143:
            boolean r0 = com.google.android.gms.internal.zzef.zza(r6)
            r4.setManualImpressionsEnabled(r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x014f:
            boolean r0 = r4.isLoading()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (boolean) r0)
            goto L_0x0019
        L_0x015b:
            android.os.IBinder r0 = r6.readStrongBinder()
            com.google.android.gms.internal.zzacv r0 = com.google.android.gms.internal.zzacw.zzz(r0)
            r4.zza((com.google.android.gms.internal.zzacv) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x016b:
            java.lang.String r0 = r6.readString()
            r4.setUserId(r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0177:
            com.google.android.gms.internal.zzku r0 = r4.getVideoController()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (android.os.IInterface) r0)
            goto L_0x0019
        L_0x0183:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzma> r0 = com.google.android.gms.internal.zzma.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r6, r0)
            com.google.android.gms.internal.zzma r0 = (com.google.android.gms.internal.zzma) r0
            r4.zza((com.google.android.gms.internal.zzma) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0193:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzla> r0 = com.google.android.gms.internal.zzla.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r6, r0)
            com.google.android.gms.internal.zzla r0 = (com.google.android.gms.internal.zzla) r0
            r4.zza((com.google.android.gms.internal.zzla) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x01a3:
            java.lang.String r0 = r4.getAdUnitId()
            r7.writeNoException()
            r7.writeString(r0)
            goto L_0x0019
        L_0x01af:
            com.google.android.gms.internal.zzkg r0 = r4.zzbx()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (android.os.IInterface) r0)
            goto L_0x0019
        L_0x01bb:
            com.google.android.gms.internal.zzjq r0 = r4.zzby()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (android.os.IInterface) r0)
            goto L_0x0019
        L_0x01c7:
            boolean r0 = com.google.android.gms.internal.zzef.zza(r6)
            r4.setImmersiveMode(r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x01d3:
            java.lang.String r0 = r4.zzcj()
            r7.writeNoException()
            r7.writeString(r0)
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzkc.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
