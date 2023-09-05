package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckr extends zzfhm<zzckr> {
    public Integer zzjhv = null;
    public Boolean zzjhw = null;
    public String zzjhx = null;
    public String zzjhy = null;
    public String zzjhz = null;

    public zzckr() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: zzh */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzckr zza(com.google.android.gms.internal.zzfhj r7) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r7.zzctt()
            switch(r0) {
                case 0: goto L_0x000d;
                case 8: goto L_0x000e;
                case 16: goto L_0x0043;
                case 26: goto L_0x004e;
                case 34: goto L_0x0055;
                case 42: goto L_0x005c;
                default: goto L_0x0007;
            }
        L_0x0007:
            boolean r0 = super.zza(r7, r0)
            if (r0 != 0) goto L_0x0000
        L_0x000d:
            return r6
        L_0x000e:
            int r1 = r7.getPosition()
            int r2 = r7.zzcui()     // Catch:{ IllegalArgumentException -> 0x0034 }
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x003c;
                case 2: goto L_0x003c;
                case 3: goto L_0x003c;
                case 4: goto L_0x003c;
                default: goto L_0x0019;
            }     // Catch:{ IllegalArgumentException -> 0x0034 }
        L_0x0019:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0034 }
            r4 = 46
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IllegalArgumentException -> 0x0034 }
            r5.<init>(r4)     // Catch:{ IllegalArgumentException -> 0x0034 }
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch:{ IllegalArgumentException -> 0x0034 }
            java.lang.String r4 = " is not a valid enum ComparisonType"
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
            r6.zzjhv = r2     // Catch:{ IllegalArgumentException -> 0x0034 }
            goto L_0x0000
        L_0x0043:
            boolean r0 = r7.zzctz()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzjhw = r0
            goto L_0x0000
        L_0x004e:
            java.lang.String r0 = r7.readString()
            r6.zzjhx = r0
            goto L_0x0000
        L_0x0055:
            java.lang.String r0 = r7.readString()
            r6.zzjhy = r0
            goto L_0x0000
        L_0x005c:
            java.lang.String r0 = r7.readString()
            r6.zzjhz = r0
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckr.zza(com.google.android.gms.internal.zzfhj):com.google.android.gms.internal.zzckr");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzckr)) {
            return false;
        }
        zzckr zzckr = (zzckr) obj;
        if (this.zzjhv == null) {
            if (zzckr.zzjhv != null) {
                return false;
            }
        } else if (!this.zzjhv.equals(zzckr.zzjhv)) {
            return false;
        }
        if (this.zzjhw == null) {
            if (zzckr.zzjhw != null) {
                return false;
            }
        } else if (!this.zzjhw.equals(zzckr.zzjhw)) {
            return false;
        }
        if (this.zzjhx == null) {
            if (zzckr.zzjhx != null) {
                return false;
            }
        } else if (!this.zzjhx.equals(zzckr.zzjhx)) {
            return false;
        }
        if (this.zzjhy == null) {
            if (zzckr.zzjhy != null) {
                return false;
            }
        } else if (!this.zzjhy.equals(zzckr.zzjhy)) {
            return false;
        }
        if (this.zzjhz == null) {
            if (zzckr.zzjhz != null) {
                return false;
            }
        } else if (!this.zzjhz.equals(zzckr.zzjhz)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzckr.zzphm == null || zzckr.zzphm.isEmpty() : this.zzphm.equals(zzckr.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzjhz == null ? 0 : this.zzjhz.hashCode()) + (((this.zzjhy == null ? 0 : this.zzjhy.hashCode()) + (((this.zzjhx == null ? 0 : this.zzjhx.hashCode()) + (((this.zzjhw == null ? 0 : this.zzjhw.hashCode()) + (((this.zzjhv == null ? 0 : this.zzjhv.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzphm != null && !this.zzphm.isEmpty()) {
            i = this.zzphm.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.zzjhv != null) {
            zzfhk.zzaa(1, this.zzjhv.intValue());
        }
        if (this.zzjhw != null) {
            zzfhk.zzl(2, this.zzjhw.booleanValue());
        }
        if (this.zzjhx != null) {
            zzfhk.zzn(3, this.zzjhx);
        }
        if (this.zzjhy != null) {
            zzfhk.zzn(4, this.zzjhy);
        }
        if (this.zzjhz != null) {
            zzfhk.zzn(5, this.zzjhz);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjhv != null) {
            zzo += zzfhk.zzad(1, this.zzjhv.intValue());
        }
        if (this.zzjhw != null) {
            this.zzjhw.booleanValue();
            zzo += zzfhk.zzkx(2) + 1;
        }
        if (this.zzjhx != null) {
            zzo += zzfhk.zzo(3, this.zzjhx);
        }
        if (this.zzjhy != null) {
            zzo += zzfhk.zzo(4, this.zzjhy);
        }
        return this.zzjhz != null ? zzo + zzfhk.zzo(5, this.zzjhz) : zzo;
    }
}
