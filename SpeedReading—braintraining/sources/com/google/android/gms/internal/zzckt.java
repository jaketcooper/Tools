package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckt extends zzfhm<zzckt> {
    public Integer zzjid = null;
    public String zzjie = null;
    public Boolean zzjif = null;
    public String[] zzjig = zzfhv.EMPTY_STRING_ARRAY;

    public zzckt() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zzi */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzckt zza(com.google.android.gms.internal.zzfhj r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
        L_0x0001:
            int r0 = r8.zzctt()
            switch(r0) {
                case 0: goto L_0x000e;
                case 8: goto L_0x000f;
                case 18: goto L_0x0044;
                case 24: goto L_0x004b;
                case 34: goto L_0x0056;
                default: goto L_0x0008;
            }
        L_0x0008:
            boolean r0 = super.zza(r8, r0)
            if (r0 != 0) goto L_0x0001
        L_0x000e:
            return r7
        L_0x000f:
            int r2 = r8.getPosition()
            int r3 = r8.zzcui()     // Catch:{ IllegalArgumentException -> 0x0035 }
            switch(r3) {
                case 0: goto L_0x003d;
                case 1: goto L_0x003d;
                case 2: goto L_0x003d;
                case 3: goto L_0x003d;
                case 4: goto L_0x003d;
                case 5: goto L_0x003d;
                case 6: goto L_0x003d;
                default: goto L_0x001a;
            }     // Catch:{ IllegalArgumentException -> 0x0035 }
        L_0x001a:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0035 }
            r5 = 41
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0035 }
            r6.<init>(r5)     // Catch:{ IllegalArgumentException -> 0x0035 }
            java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ IllegalArgumentException -> 0x0035 }
            java.lang.String r5 = " is not a valid enum MatchType"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ IllegalArgumentException -> 0x0035 }
            java.lang.String r3 = r3.toString()     // Catch:{ IllegalArgumentException -> 0x0035 }
            r4.<init>(r3)     // Catch:{ IllegalArgumentException -> 0x0035 }
            throw r4     // Catch:{ IllegalArgumentException -> 0x0035 }
        L_0x0035:
            r3 = move-exception
            r8.zzlw(r2)
            r7.zza(r8, r0)
            goto L_0x0001
        L_0x003d:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0035 }
            r7.zzjid = r3     // Catch:{ IllegalArgumentException -> 0x0035 }
            goto L_0x0001
        L_0x0044:
            java.lang.String r0 = r8.readString()
            r7.zzjie = r0
            goto L_0x0001
        L_0x004b:
            boolean r0 = r8.zzctz()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.zzjif = r0
            goto L_0x0001
        L_0x0056:
            r0 = 34
            int r2 = com.google.android.gms.internal.zzfhv.zzb(r8, r0)
            java.lang.String[] r0 = r7.zzjig
            if (r0 != 0) goto L_0x007c
            r0 = r1
        L_0x0061:
            int r2 = r2 + r0
            java.lang.String[] r2 = new java.lang.String[r2]
            if (r0 == 0) goto L_0x006b
            java.lang.String[] r3 = r7.zzjig
            java.lang.System.arraycopy(r3, r1, r2, r1, r0)
        L_0x006b:
            int r3 = r2.length
            int r3 = r3 + -1
            if (r0 >= r3) goto L_0x0080
            java.lang.String r3 = r8.readString()
            r2[r0] = r3
            r8.zzctt()
            int r0 = r0 + 1
            goto L_0x006b
        L_0x007c:
            java.lang.String[] r0 = r7.zzjig
            int r0 = r0.length
            goto L_0x0061
        L_0x0080:
            java.lang.String r3 = r8.readString()
            r2[r0] = r3
            r7.zzjig = r2
            goto L_0x0001
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckt.zza(com.google.android.gms.internal.zzfhj):com.google.android.gms.internal.zzckt");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckt)) {
            return false;
        }
        zzckt zzckt = (zzckt) obj;
        if (this.zzjid == null) {
            if (zzckt.zzjid != null) {
                return false;
            }
        } else if (!this.zzjid.equals(zzckt.zzjid)) {
            return false;
        }
        if (this.zzjie == null) {
            if (zzckt.zzjie != null) {
                return false;
            }
        } else if (!this.zzjie.equals(zzckt.zzjie)) {
            return false;
        }
        if (this.zzjif == null) {
            if (zzckt.zzjif != null) {
                return false;
            }
        } else if (!this.zzjif.equals(zzckt.zzjif)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjig, (Object[]) zzckt.zzjig)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckt.zzphm == null || zzckt.zzphm.isEmpty() : this.zzphm.equals(zzckt.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzjif == null ? 0 : this.zzjif.hashCode()) + (((this.zzjie == null ? 0 : this.zzjie.hashCode()) + (((this.zzjid == null ? 0 : this.zzjid.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + zzfhq.hashCode((Object[]) this.zzjig)) * 31;
        if (this.zzphm != null && !this.zzphm.isEmpty()) {
            i = this.zzphm.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.zzjid != null) {
            zzfhk.zzaa(1, this.zzjid.intValue());
        }
        if (this.zzjie != null) {
            zzfhk.zzn(2, this.zzjie);
        }
        if (this.zzjif != null) {
            zzfhk.zzl(3, this.zzjif.booleanValue());
        }
        if (this.zzjig != null && this.zzjig.length > 0) {
            for (String str : this.zzjig) {
                if (str != null) {
                    zzfhk.zzn(4, str);
                }
            }
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjid != null) {
            zzo += zzfhk.zzad(1, this.zzjid.intValue());
        }
        if (this.zzjie != null) {
            zzo += zzfhk.zzo(2, this.zzjie);
        }
        if (this.zzjif != null) {
            this.zzjif.booleanValue();
            zzo += zzfhk.zzkx(3) + 1;
        }
        if (this.zzjig == null || this.zzjig.length <= 0) {
            return zzo;
        }
        int i = 0;
        int i2 = 0;
        for (String str : this.zzjig) {
            if (str != null) {
                i2++;
                i += zzfhk.zzte(str);
            }
        }
        return zzo + i + (i2 * 1);
    }
}
