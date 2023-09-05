package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfie extends zzfhm<zzfie> {
    private static volatile zzfie[] zzpjj;
    public String url = null;
    public Integer zzjhl = null;
    public zzfhz zzpjk = null;
    private zzfib zzpjl = null;
    private Integer zzpjm = null;
    private int[] zzpjn = zzfhv.zzphz;
    private String zzpjo = null;
    public Integer zzpjp = null;
    public String[] zzpjq = zzfhv.EMPTY_STRING_ARRAY;

    public zzfie() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zzaq */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzfie zza(com.google.android.gms.internal.zzfhj r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
        L_0x0001:
            int r0 = r8.zzctt()
            switch(r0) {
                case 0: goto L_0x000e;
                case 8: goto L_0x000f;
                case 18: goto L_0x001a;
                case 26: goto L_0x0021;
                case 34: goto L_0x0032;
                case 40: goto L_0x0043;
                case 48: goto L_0x004e;
                case 50: goto L_0x0081;
                case 58: goto L_0x00c3;
                case 64: goto L_0x00cb;
                case 74: goto L_0x0102;
                default: goto L_0x0008;
            }
        L_0x0008:
            boolean r0 = super.zza(r8, r0)
            if (r0 != 0) goto L_0x0001
        L_0x000e:
            return r7
        L_0x000f:
            int r0 = r8.zzctw()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.zzjhl = r0
            goto L_0x0001
        L_0x001a:
            java.lang.String r0 = r8.readString()
            r7.url = r0
            goto L_0x0001
        L_0x0021:
            com.google.android.gms.internal.zzfhz r0 = r7.zzpjk
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.internal.zzfhz r0 = new com.google.android.gms.internal.zzfhz
            r0.<init>()
            r7.zzpjk = r0
        L_0x002c:
            com.google.android.gms.internal.zzfhz r0 = r7.zzpjk
            r8.zza(r0)
            goto L_0x0001
        L_0x0032:
            com.google.android.gms.internal.zzfib r0 = r7.zzpjl
            if (r0 != 0) goto L_0x003d
            com.google.android.gms.internal.zzfib r0 = new com.google.android.gms.internal.zzfib
            r0.<init>()
            r7.zzpjl = r0
        L_0x003d:
            com.google.android.gms.internal.zzfib r0 = r7.zzpjl
            r8.zza(r0)
            goto L_0x0001
        L_0x0043:
            int r0 = r8.zzctw()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.zzpjm = r0
            goto L_0x0001
        L_0x004e:
            r0 = 48
            int r2 = com.google.android.gms.internal.zzfhv.zzb(r8, r0)
            int[] r0 = r7.zzpjn
            if (r0 != 0) goto L_0x0074
            r0 = r1
        L_0x0059:
            int r2 = r2 + r0
            int[] r2 = new int[r2]
            if (r0 == 0) goto L_0x0063
            int[] r3 = r7.zzpjn
            java.lang.System.arraycopy(r3, r1, r2, r1, r0)
        L_0x0063:
            int r3 = r2.length
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x0078
            int r3 = r8.zzctw()
            r2[r0] = r3
            r8.zzctt()
            int r0 = r0 + 1
            goto L_0x0063
        L_0x0074:
            int[] r0 = r7.zzpjn
            int r0 = r0.length
            goto L_0x0059
        L_0x0078:
            int r3 = r8.zzctw()
            r2[r0] = r3
            r7.zzpjn = r2
            goto L_0x0001
        L_0x0081:
            int r0 = r8.zzcui()
            int r3 = r8.zzkj(r0)
            int r2 = r8.getPosition()
            r0 = r1
        L_0x008e:
            int r4 = r8.zzcuk()
            if (r4 <= 0) goto L_0x009a
            r8.zzctw()
            int r0 = r0 + 1
            goto L_0x008e
        L_0x009a:
            r8.zzlw(r2)
            int[] r2 = r7.zzpjn
            if (r2 != 0) goto L_0x00b8
            r2 = r1
        L_0x00a2:
            int r0 = r0 + r2
            int[] r0 = new int[r0]
            if (r2 == 0) goto L_0x00ac
            int[] r4 = r7.zzpjn
            java.lang.System.arraycopy(r4, r1, r0, r1, r2)
        L_0x00ac:
            int r4 = r0.length
            if (r2 >= r4) goto L_0x00bc
            int r4 = r8.zzctw()
            r0[r2] = r4
            int r2 = r2 + 1
            goto L_0x00ac
        L_0x00b8:
            int[] r2 = r7.zzpjn
            int r2 = r2.length
            goto L_0x00a2
        L_0x00bc:
            r7.zzpjn = r0
            r8.zzkk(r3)
            goto L_0x0001
        L_0x00c3:
            java.lang.String r0 = r8.readString()
            r7.zzpjo = r0
            goto L_0x0001
        L_0x00cb:
            int r2 = r8.getPosition()
            int r3 = r8.zzctw()     // Catch:{ IllegalArgumentException -> 0x00f1 }
            switch(r3) {
                case 0: goto L_0x00fa;
                case 1: goto L_0x00fa;
                case 2: goto L_0x00fa;
                case 3: goto L_0x00fa;
                default: goto L_0x00d6;
            }     // Catch:{ IllegalArgumentException -> 0x00f1 }
        L_0x00d6:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x00f1 }
            r5 = 46
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x00f1 }
            r6.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x00f1 }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ IllegalArgumentException -> 0x00f1 }
            java.lang.String r5 = " is not a valid enum AdResourceType"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IllegalArgumentException -> 0x00f1 }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x00f1 }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x00f1 }
            throw r4     // Catch:{ IllegalArgumentException -> 0x00f1 }
        L_0x00f1:
            r3 = move-exception
            r8.zzlw(r2)
            r7.zza(r8, r0)
            goto L_0x0001
        L_0x00fa:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x00f1 }
            r7.zzpjp = r3     // Catch:{ IllegalArgumentException -> 0x00f1 }
            goto L_0x0001
        L_0x0102:
            r0 = 74
            int r2 = com.google.android.gms.internal.zzfhv.zzb(r8, r0)
            java.lang.String[] r0 = r7.zzpjq
            if (r0 != 0) goto L_0x0128
            r0 = r1
        L_0x010d:
            int r2 = r2 + r0
            java.lang.String[] r2 = new java.lang.String[r2]
            if (r0 == 0) goto L_0x0117
            java.lang.String[] r3 = r7.zzpjq
            java.lang.System.arraycopy(r3, r1, r2, r1, r0)
        L_0x0117:
            int r3 = r2.length
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x012c
            java.lang.String r3 = r8.readString()
            r2[r0] = r3
            r8.zzctt()
            int r0 = r0 + 1
            goto L_0x0117
        L_0x0128:
            java.lang.String[] r0 = r7.zzpjq
            int r0 = r0.length
            goto L_0x010d
        L_0x012c:
            java.lang.String r3 = r8.readString()
            r2[r0] = r3
            r7.zzpjq = r2
            goto L_0x0001
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfie.zza(com.google.android.gms.internal.zzfhj):com.google.android.gms.internal.zzfie");
    }

    public static zzfie[] zzcxo() {
        if (zzpjj == null) {
            synchronized (zzfhq.zzphu) {
                if (zzpjj == null) {
                    zzpjj = new zzfie[0];
                }
            }
        }
        return zzpjj;
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        zzfhk.zzaa(1, this.zzjhl.intValue());
        if (this.url != null) {
            zzfhk.zzn(2, this.url);
        }
        if (this.zzpjk != null) {
            zzfhk.zza(3, (zzfhs) this.zzpjk);
        }
        if (this.zzpjl != null) {
            zzfhk.zza(4, (zzfhs) this.zzpjl);
        }
        if (this.zzpjm != null) {
            zzfhk.zzaa(5, this.zzpjm.intValue());
        }
        if (this.zzpjn != null && this.zzpjn.length > 0) {
            for (int zzaa : this.zzpjn) {
                zzfhk.zzaa(6, zzaa);
            }
        }
        if (this.zzpjo != null) {
            zzfhk.zzn(7, this.zzpjo);
        }
        if (this.zzpjp != null) {
            zzfhk.zzaa(8, this.zzpjp.intValue());
        }
        if (this.zzpjq != null && this.zzpjq.length > 0) {
            for (String str : this.zzpjq) {
                if (str != null) {
                    zzfhk.zzn(9, str);
                }
            }
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo() + zzfhk.zzad(1, this.zzjhl.intValue());
        if (this.url != null) {
            zzo += zzfhk.zzo(2, this.url);
        }
        if (this.zzpjk != null) {
            zzo += zzfhk.zzb(3, (zzfhs) this.zzpjk);
        }
        if (this.zzpjl != null) {
            zzo += zzfhk.zzb(4, (zzfhs) this.zzpjl);
        }
        if (this.zzpjm != null) {
            zzo += zzfhk.zzad(5, this.zzpjm.intValue());
        }
        if (this.zzpjn != null && this.zzpjn.length > 0) {
            int i = 0;
            for (int zzky : this.zzpjn) {
                i += zzfhk.zzky(zzky);
            }
            zzo = zzo + i + (this.zzpjn.length * 1);
        }
        if (this.zzpjo != null) {
            zzo += zzfhk.zzo(7, this.zzpjo);
        }
        if (this.zzpjp != null) {
            zzo += zzfhk.zzad(8, this.zzpjp.intValue());
        }
        if (this.zzpjq == null || this.zzpjq.length <= 0) {
            return zzo;
        }
        int i2 = 0;
        int i3 = 0;
        for (String str : this.zzpjq) {
            if (str != null) {
                i3++;
                i2 += zzfhk.zzte(str);
            }
        }
        return zzo + i2 + (i3 * 1);
    }
}
