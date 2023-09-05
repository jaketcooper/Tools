package com.google.android.gms.internal;

public abstract class zzaai extends zzee implements zzaah {
    public zzaai() {
        attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v5, types: [com.google.android.gms.internal.zzaan] */
    /* JADX WARNING: type inference failed for: r1v10, types: [com.google.android.gms.internal.zzaak] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
        /*
            r5 = this;
            r1 = 0
            r2 = 1
            boolean r0 = r5.zza(r6, r7, r8, r9)
            if (r0 == 0) goto L_0x000a
            r0 = r2
        L_0x0009:
            return r0
        L_0x000a:
            switch(r6) {
                case 1: goto L_0x000f;
                case 2: goto L_0x0023;
                case 3: goto L_0x000d;
                case 4: goto L_0x004b;
                default: goto L_0x000d;
            }
        L_0x000d:
            r0 = 0
            goto L_0x0009
        L_0x000f:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzzz> r0 = com.google.android.gms.internal.zzzz.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, r0)
            com.google.android.gms.internal.zzzz r0 = (com.google.android.gms.internal.zzzz) r0
            com.google.android.gms.internal.zzaad r0 = r5.zzb(r0)
            r8.writeNoException()
            com.google.android.gms.internal.zzef.zzb(r8, r0)
        L_0x0021:
            r0 = r2
            goto L_0x0009
        L_0x0023:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzzz> r0 = com.google.android.gms.internal.zzzz.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, r0)
            com.google.android.gms.internal.zzzz r0 = (com.google.android.gms.internal.zzzz) r0
            android.os.IBinder r3 = r7.readStrongBinder()
            if (r3 != 0) goto L_0x0038
        L_0x0031:
            r5.zza((com.google.android.gms.internal.zzzz) r0, (com.google.android.gms.internal.zzaak) r1)
            r8.writeNoException()
            goto L_0x0021
        L_0x0038:
            java.lang.String r1 = "com.google.android.gms.ads.internal.request.IAdResponseListener"
            android.os.IInterface r1 = r3.queryLocalInterface(r1)
            boolean r4 = r1 instanceof com.google.android.gms.internal.zzaak
            if (r4 == 0) goto L_0x0045
            com.google.android.gms.internal.zzaak r1 = (com.google.android.gms.internal.zzaak) r1
            goto L_0x0031
        L_0x0045:
            com.google.android.gms.internal.zzaam r1 = new com.google.android.gms.internal.zzaam
            r1.<init>(r3)
            goto L_0x0031
        L_0x004b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzaas> r0 = com.google.android.gms.internal.zzaas.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.zzef.zza((android.os.Parcel) r7, r0)
            com.google.android.gms.internal.zzaas r0 = (com.google.android.gms.internal.zzaas) r0
            android.os.IBinder r3 = r7.readStrongBinder()
            if (r3 != 0) goto L_0x0060
        L_0x0059:
            r5.zza((com.google.android.gms.internal.zzaas) r0, (com.google.android.gms.internal.zzaan) r1)
            r8.writeNoException()
            goto L_0x0021
        L_0x0060:
            java.lang.String r1 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            android.os.IInterface r1 = r3.queryLocalInterface(r1)
            boolean r4 = r1 instanceof com.google.android.gms.internal.zzaan
            if (r4 == 0) goto L_0x006d
            com.google.android.gms.internal.zzaan r1 = (com.google.android.gms.internal.zzaan) r1
            goto L_0x0059
        L_0x006d:
            com.google.android.gms.internal.zzaao r1 = new com.google.android.gms.internal.zzaao
            r1.<init>(r3)
            goto L_0x0059
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaai.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
