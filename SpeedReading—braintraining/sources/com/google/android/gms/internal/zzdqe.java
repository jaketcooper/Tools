package com.google.android.gms.internal;

import java.io.IOException;

public final class zzdqe extends zzfem<zzdqe, zza> implements zzffs {
    private static volatile zzffu<zzdqe> zzbas;
    /* access modifiers changed from: private */
    public static final zzdqe zzlrc;
    private int zzlqx;

    public static final class zza extends zzfen<zzdqe, zza> implements zzffs {
        private zza() {
            super(zzdqe.zzlrc);
        }

        /* synthetic */ zza(zzdqf zzdqf) {
            this();
        }
    }

    static {
        zzdqe zzdqe = new zzdqe();
        zzlrc = zzdqe;
        zzdqe.zza(zzfeu.zzpct, (Object) null, (Object) null);
        zzdqe.zzpcg.zzbin();
    }

    private zzdqe() {
    }

    public static zzdqe zzbmh() {
        return zzlrc;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: CFG modification limit reached, blocks count: 159 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(int r6, java.lang.Object r7, java.lang.Object r8) {
        /*
            r5 = this;
            r0 = 0
            r2 = 0
            r1 = 1
            int[] r3 = com.google.android.gms.internal.zzdqf.zzbaq
            int r4 = r6 + -1
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0018;
                case 3: goto L_0x001b;
                case 4: goto L_0x001d;
                case 5: goto L_0x0023;
                case 6: goto L_0x003f;
                case 7: goto L_0x0085;
                case 8: goto L_0x0088;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r0.<init>()
            throw r0
        L_0x0012:
            com.google.android.gms.internal.zzdqe r5 = new com.google.android.gms.internal.zzdqe
            r5.<init>()
        L_0x0017:
            return r5
        L_0x0018:
            com.google.android.gms.internal.zzdqe r5 = zzlrc
            goto L_0x0017
        L_0x001b:
            r5 = r0
            goto L_0x0017
        L_0x001d:
            com.google.android.gms.internal.zzdqe$zza r5 = new com.google.android.gms.internal.zzdqe$zza
            r5.<init>(r0)
            goto L_0x0017
        L_0x0023:
            com.google.android.gms.internal.zzfev r7 = (com.google.android.gms.internal.zzfev) r7
            com.google.android.gms.internal.zzdqe r8 = (com.google.android.gms.internal.zzdqe) r8
            int r0 = r5.zzlqx
            if (r0 == 0) goto L_0x003b
            r0 = r1
        L_0x002c:
            int r3 = r5.zzlqx
            int r4 = r8.zzlqx
            if (r4 == 0) goto L_0x003d
        L_0x0032:
            int r2 = r8.zzlqx
            int r0 = r7.zza((boolean) r0, (int) r3, (boolean) r1, (int) r2)
            r5.zzlqx = r0
            goto L_0x0017
        L_0x003b:
            r0 = r2
            goto L_0x002c
        L_0x003d:
            r1 = r2
            goto L_0x0032
        L_0x003f:
            com.google.android.gms.internal.zzfdy r7 = (com.google.android.gms.internal.zzfdy) r7
            com.google.android.gms.internal.zzfei r8 = (com.google.android.gms.internal.zzfei) r8
            if (r8 != 0) goto L_0x004c
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x004b:
            r2 = r1
        L_0x004c:
            if (r2 != 0) goto L_0x0085
            int r0 = r7.zzctt()     // Catch:{ zzffe -> 0x0064, IOException -> 0x0071 }
            switch(r0) {
                case 0: goto L_0x004b;
                case 8: goto L_0x005d;
                default: goto L_0x0055;
            }     // Catch:{ zzffe -> 0x0064, IOException -> 0x0071 }
        L_0x0055:
            boolean r0 = r5.zza((int) r0, (com.google.android.gms.internal.zzfdy) r7)     // Catch:{ zzffe -> 0x0064, IOException -> 0x0071 }
            if (r0 != 0) goto L_0x004c
            r2 = r1
            goto L_0x004c
        L_0x005d:
            int r0 = r7.zzcuc()     // Catch:{ zzffe -> 0x0064, IOException -> 0x0071 }
            r5.zzlqx = r0     // Catch:{ zzffe -> 0x0064, IOException -> 0x0071 }
            goto L_0x004c
        L_0x0064:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.zzffe r0 = r0.zzh(r5)     // Catch:{ all -> 0x006f }
            r1.<init>(r0)     // Catch:{ all -> 0x006f }
            throw r1     // Catch:{ all -> 0x006f }
        L_0x006f:
            r0 = move-exception
            throw r0
        L_0x0071:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.zzffe r2 = new com.google.android.gms.internal.zzffe     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x006f }
            r2.<init>(r0)     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.zzffe r0 = r2.zzh(r5)     // Catch:{ all -> 0x006f }
            r1.<init>(r0)     // Catch:{ all -> 0x006f }
            throw r1     // Catch:{ all -> 0x006f }
        L_0x0085:
            com.google.android.gms.internal.zzdqe r5 = zzlrc
            goto L_0x0017
        L_0x0088:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqe> r0 = zzbas
            if (r0 != 0) goto L_0x009d
            java.lang.Class<com.google.android.gms.internal.zzdqe> r1 = com.google.android.gms.internal.zzdqe.class
            monitor-enter(r1)
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqe> r0 = zzbas     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.internal.zzfeo r0 = new com.google.android.gms.internal.zzfeo     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.zzdqe r2 = zzlrc     // Catch:{ all -> 0x00a1 }
            r0.<init>(r2)     // Catch:{ all -> 0x00a1 }
            zzbas = r0     // Catch:{ all -> 0x00a1 }
        L_0x009c:
            monitor-exit(r1)     // Catch:{ all -> 0x00a1 }
        L_0x009d:
            com.google.android.gms.internal.zzffu<com.google.android.gms.internal.zzdqe> r5 = zzbas
            goto L_0x0017
        L_0x00a1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a1 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdqe.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final void zza(zzfed zzfed) throws IOException {
        if (this.zzlqx != 0) {
            zzfed.zzab(1, this.zzlqx);
        }
        this.zzpcg.zza(zzfed);
    }

    public final int zzbma() {
        return this.zzlqx;
    }

    public final int zzhl() {
        int i = this.zzpch;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.zzlqx != 0) {
            i2 = zzfed.zzae(1, this.zzlqx) + 0;
        }
        int zzhl = i2 + this.zzpcg.zzhl();
        this.zzpch = zzhl;
        return zzhl;
    }
}
