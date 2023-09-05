package com.google.android.gms.internal;

import java.util.concurrent.ExecutionException;

public final class zzdj extends zzec {
    private static final Object zzajl = new Object();
    private static volatile zzbs zzajm = null;
    private zzat zzajn = null;

    public zzdj(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2, zzat zzat) {
        super(zzda, str, str2, zzaw, i, 27);
        this.zzajn = zzat;
    }

    private final String zzau() {
        try {
            if (this.zzagk.zzan() != null) {
                this.zzagk.zzan().get();
            }
            zzaw zzam = this.zzagk.zzam();
            if (!(zzam == null || zzam.zzcq == null)) {
                return zzam.zzcq;
            }
        } catch (InterruptedException | ExecutionException e) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzat() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r10 = this;
            r4 = 2
            r1 = 1
            r2 = 0
            com.google.android.gms.internal.zzbs r0 = zzajm
            if (r0 == 0) goto L_0x0029
            com.google.android.gms.internal.zzbs r0 = zzajm
            java.lang.String r0 = r0.zzcq
            boolean r0 = com.google.android.gms.internal.zzdf.zzn(r0)
            if (r0 != 0) goto L_0x0029
            com.google.android.gms.internal.zzbs r0 = zzajm
            java.lang.String r0 = r0.zzcq
            java.lang.String r3 = "E"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0029
            com.google.android.gms.internal.zzbs r0 = zzajm
            java.lang.String r0 = r0.zzcq
            java.lang.String r3 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00ad
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 == 0) goto L_0x0078
            java.lang.Object r5 = zzajl
            monitor-enter(r5)
            com.google.android.gms.internal.zzat r0 = r10.zzajn     // Catch:{ all -> 0x0105 }
            r0 = 0
            boolean r0 = com.google.android.gms.internal.zzdf.zzn(r0)     // Catch:{ all -> 0x0105 }
            if (r0 != 0) goto L_0x00b0
            r0 = 4
            r3 = r0
        L_0x003a:
            java.lang.reflect.Method r6 = r10.zzajx     // Catch:{ all -> 0x0105 }
            r7 = 0
            r0 = 2
            java.lang.Object[] r8 = new java.lang.Object[r0]     // Catch:{ all -> 0x0105 }
            r0 = 0
            com.google.android.gms.internal.zzda r9 = r10.zzagk     // Catch:{ all -> 0x0105 }
            android.content.Context r9 = r9.getContext()     // Catch:{ all -> 0x0105 }
            r8[r0] = r9     // Catch:{ all -> 0x0105 }
            r9 = 1
            if (r3 != r4) goto L_0x00f9
            r0 = r1
        L_0x004d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0105 }
            r8[r9] = r0     // Catch:{ all -> 0x0105 }
            java.lang.Object r0 = r6.invoke(r7, r8)     // Catch:{ all -> 0x0105 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.zzbs r1 = new com.google.android.gms.internal.zzbs     // Catch:{ all -> 0x0105 }
            r1.<init>(r0)     // Catch:{ all -> 0x0105 }
            zzajm = r1     // Catch:{ all -> 0x0105 }
            java.lang.String r0 = r1.zzcq     // Catch:{ all -> 0x0105 }
            boolean r0 = com.google.android.gms.internal.zzdf.zzn(r0)     // Catch:{ all -> 0x0105 }
            if (r0 != 0) goto L_0x0074
            com.google.android.gms.internal.zzbs r0 = zzajm     // Catch:{ all -> 0x0105 }
            java.lang.String r0 = r0.zzcq     // Catch:{ all -> 0x0105 }
            java.lang.String r1 = "E"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0105 }
            if (r0 == 0) goto L_0x0077
        L_0x0074:
            switch(r3) {
                case 3: goto L_0x0108;
                case 4: goto L_0x00fc;
                default: goto L_0x0077;
            }     // Catch:{ all -> 0x0105 }
        L_0x0077:
            monitor-exit(r5)     // Catch:{ all -> 0x0105 }
        L_0x0078:
            com.google.android.gms.internal.zzaw r1 = r10.zzajo
            monitor-enter(r1)
            com.google.android.gms.internal.zzbs r0 = zzajm     // Catch:{ all -> 0x0118 }
            if (r0 == 0) goto L_0x00ab
            com.google.android.gms.internal.zzaw r0 = r10.zzajo     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzbs r2 = zzajm     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.zzcq     // Catch:{ all -> 0x0118 }
            r0.zzcq = r2     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzaw r0 = r10.zzajo     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzbs r2 = zzajm     // Catch:{ all -> 0x0118 }
            long r2 = r2.zzyo     // Catch:{ all -> 0x0118 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0118 }
            r0.zzdu = r2     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzaw r0 = r10.zzajo     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzbs r2 = zzajm     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.zzcs     // Catch:{ all -> 0x0118 }
            r0.zzcs = r2     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzaw r0 = r10.zzajo     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzbs r2 = zzajm     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.zzct     // Catch:{ all -> 0x0118 }
            r0.zzct = r2     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzaw r0 = r10.zzajo     // Catch:{ all -> 0x0118 }
            com.google.android.gms.internal.zzbs r2 = zzajm     // Catch:{ all -> 0x0118 }
            java.lang.String r2 = r2.zzcu     // Catch:{ all -> 0x0118 }
            r0.zzcu = r2     // Catch:{ all -> 0x0118 }
        L_0x00ab:
            monitor-exit(r1)     // Catch:{ all -> 0x0118 }
            return
        L_0x00ad:
            r0 = r2
            goto L_0x002a
        L_0x00b0:
            com.google.android.gms.internal.zzat r0 = r10.zzajn     // Catch:{ all -> 0x0105 }
            r0 = 0
            com.google.android.gms.internal.zzdf.zzn(r0)     // Catch:{ all -> 0x0105 }
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0105 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0105 }
            if (r0 == 0) goto L_0x00f6
            com.google.android.gms.internal.zzda r0 = r10.zzagk     // Catch:{ all -> 0x0105 }
            boolean r0 = r0.zzak()     // Catch:{ all -> 0x0105 }
            if (r0 == 0) goto L_0x00f4
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbmf     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0105 }
            java.lang.Object r0 = r3.zzd(r0)     // Catch:{ all -> 0x0105 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0105 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0105 }
            if (r0 == 0) goto L_0x00f4
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbmg     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0105 }
            java.lang.Object r0 = r3.zzd(r0)     // Catch:{ all -> 0x0105 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0105 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0105 }
            if (r0 == 0) goto L_0x00f4
            r0 = r1
        L_0x00ee:
            if (r0 == 0) goto L_0x00f6
            r0 = 3
            r3 = r0
            goto L_0x003a
        L_0x00f4:
            r0 = r2
            goto L_0x00ee
        L_0x00f6:
            r3 = r4
            goto L_0x003a
        L_0x00f9:
            r0 = r2
            goto L_0x004d
        L_0x00fc:
            com.google.android.gms.internal.zzbs r0 = zzajm     // Catch:{ all -> 0x0105 }
            r1 = 0
            java.lang.String r1 = r1.zzcq     // Catch:{ all -> 0x0105 }
            r0.zzcq = r1     // Catch:{ all -> 0x0105 }
            goto L_0x0077
        L_0x0105:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0105 }
            throw r0
        L_0x0108:
            java.lang.String r0 = r10.zzau()     // Catch:{ all -> 0x0105 }
            boolean r1 = com.google.android.gms.internal.zzdf.zzn(r0)     // Catch:{ all -> 0x0105 }
            if (r1 != 0) goto L_0x0077
            com.google.android.gms.internal.zzbs r1 = zzajm     // Catch:{ all -> 0x0105 }
            r1.zzcq = r0     // Catch:{ all -> 0x0105 }
            goto L_0x0077
        L_0x0118:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0118 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdj.zzat():void");
    }
}
