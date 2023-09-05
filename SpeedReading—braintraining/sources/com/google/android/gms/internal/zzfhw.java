package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfhw extends zzfhm<zzfhw> {
    public String url = null;
    public Integer zzpig = null;
    private Integer zzpih = null;
    public String zzpii = null;
    private String zzpij = null;
    public zzfhx zzpik = null;
    public zzfie[] zzpil = zzfie.zzcxo();
    public String zzpim = null;
    public zzfid zzpin = null;
    private Boolean zzpio = null;
    private String[] zzpip = zzfhv.EMPTY_STRING_ARRAY;
    private String zzpiq = null;
    private Boolean zzpir = null;
    private Boolean zzpis = null;
    private byte[] zzpit = null;
    public zzfif zzpiu = null;

    public zzfhw() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zzao */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzfhw zza(com.google.android.gms.internal.zzfhj r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
        L_0x0001:
            int r0 = r8.zzctt()
            switch(r0) {
                case 0: goto L_0x000e;
                case 10: goto L_0x000f;
                case 18: goto L_0x0016;
                case 26: goto L_0x001d;
                case 34: goto L_0x0024;
                case 40: goto L_0x0063;
                case 50: goto L_0x006e;
                case 58: goto L_0x00a2;
                case 64: goto L_0x00aa;
                case 72: goto L_0x00b6;
                case 80: goto L_0x00c2;
                case 88: goto L_0x00f9;
                case 98: goto L_0x0130;
                case 106: goto L_0x0142;
                case 114: goto L_0x014a;
                case 122: goto L_0x015c;
                case 138: goto L_0x0164;
                default: goto L_0x0008;
            }
        L_0x0008:
            boolean r0 = super.zza(r8, r0)
            if (r0 != 0) goto L_0x0001
        L_0x000e:
            return r7
        L_0x000f:
            java.lang.String r0 = r8.readString()
            r7.url = r0
            goto L_0x0001
        L_0x0016:
            java.lang.String r0 = r8.readString()
            r7.zzpii = r0
            goto L_0x0001
        L_0x001d:
            java.lang.String r0 = r8.readString()
            r7.zzpij = r0
            goto L_0x0001
        L_0x0024:
            r0 = 34
            int r2 = com.google.android.gms.internal.zzfhv.zzb(r8, r0)
            com.google.android.gms.internal.zzfie[] r0 = r7.zzpil
            if (r0 != 0) goto L_0x0050
            r0 = r1
        L_0x002f:
            int r2 = r2 + r0
            com.google.android.gms.internal.zzfie[] r2 = new com.google.android.gms.internal.zzfie[r2]
            if (r0 == 0) goto L_0x0039
            com.google.android.gms.internal.zzfie[] r3 = r7.zzpil
            java.lang.System.arraycopy(r3, r1, r2, r1, r0)
        L_0x0039:
            int r3 = r2.length
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x0054
            com.google.android.gms.internal.zzfie r3 = new com.google.android.gms.internal.zzfie
            r3.<init>()
            r2[r0] = r3
            r3 = r2[r0]
            r8.zza(r3)
            r8.zzctt()
            int r0 = r0 + 1
            goto L_0x0039
        L_0x0050:
            com.google.android.gms.internal.zzfie[] r0 = r7.zzpil
            int r0 = r0.length
            goto L_0x002f
        L_0x0054:
            com.google.android.gms.internal.zzfie r3 = new com.google.android.gms.internal.zzfie
            r3.<init>()
            r2[r0] = r3
            r0 = r2[r0]
            r8.zza(r0)
            r7.zzpil = r2
            goto L_0x0001
        L_0x0063:
            boolean r0 = r8.zzctz()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.zzpio = r0
            goto L_0x0001
        L_0x006e:
            r0 = 50
            int r2 = com.google.android.gms.internal.zzfhv.zzb(r8, r0)
            java.lang.String[] r0 = r7.zzpip
            if (r0 != 0) goto L_0x0094
            r0 = r1
        L_0x0079:
            int r2 = r2 + r0
            java.lang.String[] r2 = new java.lang.String[r2]
            if (r0 == 0) goto L_0x0083
            java.lang.String[] r3 = r7.zzpip
            java.lang.System.arraycopy(r3, r1, r2, r1, r0)
        L_0x0083:
            int r3 = r2.length
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x0098
            java.lang.String r3 = r8.readString()
            r2[r0] = r3
            r8.zzctt()
            int r0 = r0 + 1
            goto L_0x0083
        L_0x0094:
            java.lang.String[] r0 = r7.zzpip
            int r0 = r0.length
            goto L_0x0079
        L_0x0098:
            java.lang.String r3 = r8.readString()
            r2[r0] = r3
            r7.zzpip = r2
            goto L_0x0001
        L_0x00a2:
            java.lang.String r0 = r8.readString()
            r7.zzpiq = r0
            goto L_0x0001
        L_0x00aa:
            boolean r0 = r8.zzctz()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.zzpir = r0
            goto L_0x0001
        L_0x00b6:
            boolean r0 = r8.zzctz()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.zzpis = r0
            goto L_0x0001
        L_0x00c2:
            int r2 = r8.getPosition()
            int r3 = r8.zzctw()     // Catch:{ IllegalArgumentException -> 0x00e8 }
            switch(r3) {
                case 0: goto L_0x00f1;
                case 1: goto L_0x00f1;
                case 2: goto L_0x00f1;
                case 3: goto L_0x00f1;
                case 4: goto L_0x00f1;
                case 5: goto L_0x00f1;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00f1;
                case 8: goto L_0x00f1;
                case 9: goto L_0x00f1;
                default: goto L_0x00cd;
            }     // Catch:{ IllegalArgumentException -> 0x00e8 }
        L_0x00cd:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x00e8 }
            r5 = 42
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x00e8 }
            r6.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x00e8 }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ IllegalArgumentException -> 0x00e8 }
            java.lang.String r5 = " is not a valid enum ReportType"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IllegalArgumentException -> 0x00e8 }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x00e8 }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x00e8 }
            throw r4     // Catch:{ IllegalArgumentException -> 0x00e8 }
        L_0x00e8:
            r3 = move-exception
            r8.zzlw(r2)
            r7.zza(r8, r0)
            goto L_0x0001
        L_0x00f1:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x00e8 }
            r7.zzpig = r3     // Catch:{ IllegalArgumentException -> 0x00e8 }
            goto L_0x0001
        L_0x00f9:
            int r2 = r8.getPosition()
            int r3 = r8.zzctw()     // Catch:{ IllegalArgumentException -> 0x011f }
            switch(r3) {
                case 0: goto L_0x0128;
                case 1: goto L_0x0128;
                case 2: goto L_0x0128;
                case 3: goto L_0x0128;
                case 4: goto L_0x0128;
                default: goto L_0x0104;
            }     // Catch:{ IllegalArgumentException -> 0x011f }
        L_0x0104:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x011f }
            r5 = 39
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x011f }
            r6.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x011f }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ IllegalArgumentException -> 0x011f }
            java.lang.String r5 = " is not a valid enum Verdict"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IllegalArgumentException -> 0x011f }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x011f }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x011f }
            throw r4     // Catch:{ IllegalArgumentException -> 0x011f }
        L_0x011f:
            r3 = move-exception
            r8.zzlw(r2)
            r7.zza(r8, r0)
            goto L_0x0001
        L_0x0128:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x011f }
            r7.zzpih = r3     // Catch:{ IllegalArgumentException -> 0x011f }
            goto L_0x0001
        L_0x0130:
            com.google.android.gms.internal.zzfhx r0 = r7.zzpik
            if (r0 != 0) goto L_0x013b
            com.google.android.gms.internal.zzfhx r0 = new com.google.android.gms.internal.zzfhx
            r0.<init>()
            r7.zzpik = r0
        L_0x013b:
            com.google.android.gms.internal.zzfhx r0 = r7.zzpik
            r8.zza(r0)
            goto L_0x0001
        L_0x0142:
            java.lang.String r0 = r8.readString()
            r7.zzpim = r0
            goto L_0x0001
        L_0x014a:
            com.google.android.gms.internal.zzfid r0 = r7.zzpin
            if (r0 != 0) goto L_0x0155
            com.google.android.gms.internal.zzfid r0 = new com.google.android.gms.internal.zzfid
            r0.<init>()
            r7.zzpin = r0
        L_0x0155:
            com.google.android.gms.internal.zzfid r0 = r7.zzpin
            r8.zza(r0)
            goto L_0x0001
        L_0x015c:
            byte[] r0 = r8.readBytes()
            r7.zzpit = r0
            goto L_0x0001
        L_0x0164:
            com.google.android.gms.internal.zzfif r0 = r7.zzpiu
            if (r0 != 0) goto L_0x016f
            com.google.android.gms.internal.zzfif r0 = new com.google.android.gms.internal.zzfif
            r0.<init>()
            r7.zzpiu = r0
        L_0x016f:
            com.google.android.gms.internal.zzfif r0 = r7.zzpiu
            r8.zza(r0)
            goto L_0x0001
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfhw.zza(com.google.android.gms.internal.zzfhj):com.google.android.gms.internal.zzfhw");
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.url != null) {
            zzfhk.zzn(1, this.url);
        }
        if (this.zzpii != null) {
            zzfhk.zzn(2, this.zzpii);
        }
        if (this.zzpij != null) {
            zzfhk.zzn(3, this.zzpij);
        }
        if (this.zzpil != null && this.zzpil.length > 0) {
            for (zzfie zzfie : this.zzpil) {
                if (zzfie != null) {
                    zzfhk.zza(4, (zzfhs) zzfie);
                }
            }
        }
        if (this.zzpio != null) {
            zzfhk.zzl(5, this.zzpio.booleanValue());
        }
        if (this.zzpip != null && this.zzpip.length > 0) {
            for (String str : this.zzpip) {
                if (str != null) {
                    zzfhk.zzn(6, str);
                }
            }
        }
        if (this.zzpiq != null) {
            zzfhk.zzn(7, this.zzpiq);
        }
        if (this.zzpir != null) {
            zzfhk.zzl(8, this.zzpir.booleanValue());
        }
        if (this.zzpis != null) {
            zzfhk.zzl(9, this.zzpis.booleanValue());
        }
        if (this.zzpig != null) {
            zzfhk.zzaa(10, this.zzpig.intValue());
        }
        if (this.zzpih != null) {
            zzfhk.zzaa(11, this.zzpih.intValue());
        }
        if (this.zzpik != null) {
            zzfhk.zza(12, (zzfhs) this.zzpik);
        }
        if (this.zzpim != null) {
            zzfhk.zzn(13, this.zzpim);
        }
        if (this.zzpin != null) {
            zzfhk.zza(14, (zzfhs) this.zzpin);
        }
        if (this.zzpit != null) {
            zzfhk.zzc(15, this.zzpit);
        }
        if (this.zzpiu != null) {
            zzfhk.zza(17, (zzfhs) this.zzpiu);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.url != null) {
            zzo += zzfhk.zzo(1, this.url);
        }
        if (this.zzpii != null) {
            zzo += zzfhk.zzo(2, this.zzpii);
        }
        if (this.zzpij != null) {
            zzo += zzfhk.zzo(3, this.zzpij);
        }
        if (this.zzpil != null && this.zzpil.length > 0) {
            int i = zzo;
            for (zzfie zzfie : this.zzpil) {
                if (zzfie != null) {
                    i += zzfhk.zzb(4, (zzfhs) zzfie);
                }
            }
            zzo = i;
        }
        if (this.zzpio != null) {
            this.zzpio.booleanValue();
            zzo += zzfhk.zzkx(5) + 1;
        }
        if (this.zzpip != null && this.zzpip.length > 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str : this.zzpip) {
                if (str != null) {
                    i3++;
                    i2 += zzfhk.zzte(str);
                }
            }
            zzo = zzo + i2 + (i3 * 1);
        }
        if (this.zzpiq != null) {
            zzo += zzfhk.zzo(7, this.zzpiq);
        }
        if (this.zzpir != null) {
            this.zzpir.booleanValue();
            zzo += zzfhk.zzkx(8) + 1;
        }
        if (this.zzpis != null) {
            this.zzpis.booleanValue();
            zzo += zzfhk.zzkx(9) + 1;
        }
        if (this.zzpig != null) {
            zzo += zzfhk.zzad(10, this.zzpig.intValue());
        }
        if (this.zzpih != null) {
            zzo += zzfhk.zzad(11, this.zzpih.intValue());
        }
        if (this.zzpik != null) {
            zzo += zzfhk.zzb(12, (zzfhs) this.zzpik);
        }
        if (this.zzpim != null) {
            zzo += zzfhk.zzo(13, this.zzpim);
        }
        if (this.zzpin != null) {
            zzo += zzfhk.zzb(14, (zzfhs) this.zzpin);
        }
        if (this.zzpit != null) {
            zzo += zzfhk.zzd(15, this.zzpit);
        }
        return this.zzpiu != null ? zzo + zzfhk.zzb(17, (zzfhs) this.zzpiu) : zzo;
    }
}
