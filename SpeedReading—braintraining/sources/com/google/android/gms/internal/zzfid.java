package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfid extends zzfhm<zzfid> {
    public String mimeType = null;
    public Integer zzpig = null;
    public byte[] zzpji = null;

    public zzfid() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zzap */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzfid zza(com.google.android.gms.internal.zzfhj r7) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r7.zzctt()
            switch(r0) {
                case 0: goto L_0x000d;
                case 8: goto L_0x000e;
                case 18: goto L_0x0043;
                case 26: goto L_0x004a;
                default: goto L_0x0007;
            }
        L_0x0007:
            boolean r0 = super.zza(r7, r0)
            if (r0 != 0) goto L_0x0000
        L_0x000d:
            return r6
        L_0x000e:
            int r1 = r7.getPosition()
            int r2 = r7.zzctw()     // Catch:{ IllegalArgumentException -> 0x0034 }
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x003c;
                default: goto L_0x0019;
            }     // Catch:{ IllegalArgumentException -> 0x0034 }
        L_0x0019:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0034 }
            r4 = 36
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0034 }
            r5.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x0034 }
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0034 }
            java.lang.String r4 = " is not a valid enum Type"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ IllegalArgumentException -> 0x0034 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalArgumentException -> 0x0034 }
            r3.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0034 }
            throw r3     // Catch:{ IllegalArgumentException -> 0x0034 }
        L_0x0034:
            r2 = move-exception
            r7.zzlw(r1)
            r6.zza(r7, r0)
            goto L_0x0000
        L_0x003c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalArgumentException -> 0x0034 }
            r6.zzpig = r2     // Catch:{ IllegalArgumentException -> 0x0034 }
            goto L_0x0000
        L_0x0043:
            java.lang.String r0 = r7.readString()
            r6.mimeType = r0
            goto L_0x0000
        L_0x004a:
            byte[] r0 = r7.readBytes()
            r6.zzpji = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfid.zza(com.google.android.gms.internal.zzfhj):com.google.android.gms.internal.zzfid");
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.zzpig != null) {
            zzfhk.zzaa(1, this.zzpig.intValue());
        }
        if (this.mimeType != null) {
            zzfhk.zzn(2, this.mimeType);
        }
        if (this.zzpji != null) {
            zzfhk.zzc(3, this.zzpji);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzpig != null) {
            zzo += zzfhk.zzad(1, this.zzpig.intValue());
        }
        if (this.mimeType != null) {
            zzo += zzfhk.zzo(2, this.mimeType);
        }
        return this.zzpji != null ? zzo + zzfhk.zzd(3, this.zzpji) : zzo;
    }
}
