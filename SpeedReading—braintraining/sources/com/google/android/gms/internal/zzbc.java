package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbc extends zzfhm<zzbc> {
    public byte[] zzge = null;
    public byte[][] zzgj = zzfhv.zzpie;
    private Integer zzgk;
    public Integer zzgl;

    public zzbc() {
        this.zzpaw = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zzd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzbc zza(com.google.android.gms.internal.zzfhj r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
        L_0x0001:
            int r0 = r8.zzctt()
            switch(r0) {
                case 0: goto L_0x000e;
                case 10: goto L_0x000f;
                case 18: goto L_0x0042;
                case 24: goto L_0x0049;
                case 32: goto L_0x007e;
                default: goto L_0x0008;
            }
        L_0x0008:
            boolean r0 = super.zza(r8, r0)
            if (r0 != 0) goto L_0x0001
        L_0x000e:
            return r7
        L_0x000f:
            r0 = 10
            int r2 = com.google.android.gms.internal.zzfhv.zzb(r8, r0)
            byte[][] r0 = r7.zzgj
            if (r0 != 0) goto L_0x0035
            r0 = r1
        L_0x001a:
            int r2 = r2 + r0
            byte[][] r2 = new byte[r2][]
            if (r0 == 0) goto L_0x0024
            byte[][] r3 = r7.zzgj
            java.lang.System.arraycopy(r3, r1, r2, r1, r0)
        L_0x0024:
            int r3 = r2.length
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x0039
            byte[] r3 = r8.readBytes()
            r2[r0] = r3
            r8.zzctt()
            int r0 = r0 + 1
            goto L_0x0024
        L_0x0035:
            byte[][] r0 = r7.zzgj
            int r0 = r0.length
            goto L_0x001a
        L_0x0039:
            byte[] r3 = r8.readBytes()
            r2[r0] = r3
            r7.zzgj = r2
            goto L_0x0001
        L_0x0042:
            byte[] r0 = r8.readBytes()
            r7.zzge = r0
            goto L_0x0001
        L_0x0049:
            int r2 = r8.getPosition()
            int r3 = r8.zzcui()     // Catch:{ IllegalArgumentException -> 0x006f }
            switch(r3) {
                case 0: goto L_0x0077;
                case 1: goto L_0x0077;
                default: goto L_0x0054;
            }     // Catch:{ IllegalArgumentException -> 0x006f }
        L_0x0054:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x006f }
            r5 = 41
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x006f }
            r6.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x006f }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ IllegalArgumentException -> 0x006f }
            java.lang.String r5 = " is not a valid enum ProtoName"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IllegalArgumentException -> 0x006f }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x006f }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x006f }
            throw r4     // Catch:{ IllegalArgumentException -> 0x006f }
        L_0x006f:
            r3 = move-exception
            r8.zzlw(r2)
            r7.zza(r8, r0)
            goto L_0x0001
        L_0x0077:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x006f }
            r7.zzgk = r3     // Catch:{ IllegalArgumentException -> 0x006f }
            goto L_0x0001
        L_0x007e:
            int r2 = r8.getPosition()
            int r3 = r8.zzcui()     // Catch:{ IllegalArgumentException -> 0x00a4 }
            switch(r3) {
                case 0: goto L_0x00ad;
                case 1: goto L_0x00ad;
                case 2: goto L_0x00ad;
                default: goto L_0x0089;
            }     // Catch:{ IllegalArgumentException -> 0x00a4 }
        L_0x0089:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x00a4 }
            r5 = 48
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x00a4 }
            r6.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x00a4 }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ IllegalArgumentException -> 0x00a4 }
            java.lang.String r5 = " is not a valid enum EncryptionMethod"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IllegalArgumentException -> 0x00a4 }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x00a4 }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x00a4 }
            throw r4     // Catch:{ IllegalArgumentException -> 0x00a4 }
        L_0x00a4:
            r3 = move-exception
            r8.zzlw(r2)
            r7.zza(r8, r0)
            goto L_0x0001
        L_0x00ad:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x00a4 }
            r7.zzgl = r3     // Catch:{ IllegalArgumentException -> 0x00a4 }
            goto L_0x0001
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbc.zza(com.google.android.gms.internal.zzfhj):com.google.android.gms.internal.zzbc");
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.zzgj != null && this.zzgj.length > 0) {
            for (byte[] bArr : this.zzgj) {
                if (bArr != null) {
                    zzfhk.zzc(1, bArr);
                }
            }
        }
        if (this.zzge != null) {
            zzfhk.zzc(2, this.zzge);
        }
        if (this.zzgk != null) {
            zzfhk.zzaa(3, this.zzgk.intValue());
        }
        if (this.zzgl != null) {
            zzfhk.zzaa(4, this.zzgl.intValue());
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int i;
        int zzo = super.zzo();
        if (this.zzgj == null || this.zzgj.length <= 0) {
            i = zzo;
        } else {
            int i2 = 0;
            int i3 = 0;
            for (byte[] bArr : this.zzgj) {
                if (bArr != null) {
                    i3++;
                    i2 += zzfhk.zzbf(bArr);
                }
            }
            i = zzo + i2 + (i3 * 1);
        }
        if (this.zzge != null) {
            i += zzfhk.zzd(2, this.zzge);
        }
        if (this.zzgk != null) {
            i += zzfhk.zzad(3, this.zzgk.intValue());
        }
        return this.zzgl != null ? i + zzfhk.zzad(4, this.zzgl.intValue()) : i;
    }
}
