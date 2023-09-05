package com.google.android.gms.internal;

public abstract class zzjx extends zzee implements zzjw {
    public zzjx() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v12, types: [com.google.android.gms.internal.zzkm] */
    /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.internal.zzjq] */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* JADX WARNING: type inference failed for: r0v31 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            boolean r2 = r4.zza(r5, r6, r7, r8)
            if (r2 == 0) goto L_0x000a
            r0 = r1
        L_0x0009:
            return r0
        L_0x000a:
            switch(r5) {
                case 1: goto L_0x000f;
                case 2: goto L_0x001b;
                case 3: goto L_0x003b;
                case 4: goto L_0x004a;
                case 5: goto L_0x0059;
                case 6: goto L_0x0074;
                case 7: goto L_0x0083;
                case 8: goto L_0x00a3;
                case 9: goto L_0x00bb;
                default: goto L_0x000d;
            }
        L_0x000d:
            r0 = 0
            goto L_0x0009
        L_0x000f:
            com.google.android.gms.internal.zzjt r0 = r4.zzdc()
            r7.writeNoException()
            com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, (android.os.IInterface) r0)
        L_0x0019:
            r0 = r1
            goto L_0x0009
        L_0x001b:
            android.os.IBinder r2 = r6.readStrongBinder()
            if (r2 != 0) goto L_0x0028
        L_0x0021:
            r4.zzb((com.google.android.gms.internal.zzjq) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0028:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.zzjq
            if (r3 == 0) goto L_0x0035
            com.google.android.gms.internal.zzjq r0 = (com.google.android.gms.internal.zzjq) r0
            goto L_0x0021
        L_0x0035:
            com.google.android.gms.internal.zzjs r0 = new com.google.android.gms.internal.zzjs
            r0.<init>(r2)
            goto L_0x0021
        L_0x003b:
            android.os.IBinder r0 = r6.readStrongBinder()
            com.google.android.gms.internal.zzpy r0 = com.google.android.gms.internal.zzpz.zzo(r0)
            r4.zza((com.google.android.gms.internal.zzpy) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x004a:
            android.os.IBinder r0 = r6.readStrongBinder()
            com.google.android.gms.internal.zzqb r0 = com.google.android.gms.internal.zzqc.zzp(r0)
            r4.zza((com.google.android.gms.internal.zzqb) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0059:
            java.lang.String r0 = r6.readString()
            android.os.IBinder r2 = r6.readStrongBinder()
            com.google.android.gms.internal.zzqh r2 = com.google.android.gms.internal.zzqi.zzr(r2)
            android.os.IBinder r3 = r6.readStrongBinder()
            com.google.android.gms.internal.zzqe r3 = com.google.android.gms.internal.zzqf.zzq(r3)
            r4.zza(r0, r2, r3)
            r7.writeNoException()
            goto L_0x0019
        L_0x0074:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzom> r0 = com.google.android.gms.internal.zzom.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r6, r0)
            com.google.android.gms.internal.zzom r0 = (com.google.android.gms.internal.zzom) r0
            r4.zza((com.google.android.gms.internal.zzom) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0083:
            android.os.IBinder r2 = r6.readStrongBinder()
            if (r2 != 0) goto L_0x0090
        L_0x0089:
            r4.zzb((com.google.android.gms.internal.zzkm) r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x0090:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.android.gms.internal.zzkm
            if (r3 == 0) goto L_0x009d
            com.google.android.gms.internal.zzkm r0 = (com.google.android.gms.internal.zzkm) r0
            goto L_0x0089
        L_0x009d:
            com.google.android.gms.internal.zzko r0 = new com.google.android.gms.internal.zzko
            r0.<init>(r2)
            goto L_0x0089
        L_0x00a3:
            android.os.IBinder r0 = r6.readStrongBinder()
            com.google.android.gms.internal.zzqk r2 = com.google.android.gms.internal.zzql.zzs(r0)
            android.os.Parcelable$Creator<com.google.android.gms.internal.zziw> r0 = com.google.android.gms.internal.zziw.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r6, r0)
            com.google.android.gms.internal.zziw r0 = (com.google.android.gms.internal.zziw) r0
            r4.zza(r2, r0)
            r7.writeNoException()
            goto L_0x0019
        L_0x00bb:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.PublisherAdViewOptions> r0 = com.google.android.gms.ads.formats.PublisherAdViewOptions.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r6, r0)
            com.google.android.gms.ads.formats.PublisherAdViewOptions r0 = (com.google.android.gms.ads.formats.PublisherAdViewOptions) r0
            r4.zza((com.google.android.gms.ads.formats.PublisherAdViewOptions) r0)
            r7.writeNoException()
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjx.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
