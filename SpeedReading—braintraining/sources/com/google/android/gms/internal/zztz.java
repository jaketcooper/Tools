package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zztz implements zztl {
    private final Context mContext;
    private final Object mLock = new Object();
    private final long mStartTime;
    private final zznd zzamo;
    private final zzuc zzanb;
    private final boolean zzauu;
    private final zztn zzccq;
    private final boolean zzccu;
    private final boolean zzccv;
    private final zzzz zzcdj;
    private final long zzcdk;
    private boolean zzcdm = false;
    private final String zzcdo;
    private List<zztt> zzcdp = new ArrayList();
    private zztq zzcdt;

    public zztz(Context context, zzzz zzzz, zzuc zzuc, zztn zztn, boolean z, boolean z2, String str, long j, long j2, zznd zznd, boolean z3) {
        this.mContext = context;
        this.zzcdj = zzzz;
        this.zzanb = zzuc;
        this.zzccq = zztn;
        this.zzauu = z;
        this.zzccu = z2;
        this.zzcdo = str;
        this.mStartTime = j;
        this.zzcdk = j2;
        this.zzamo = zznd;
        this.zzccv = z3;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzcdm = true;
            if (this.zzcdt != null) {
                this.zzcdt.cancel();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ed, code lost:
        r2 = r24.zzcdt.zza(r24.mStartTime, r24.zzcdk);
        r24.zzcdp.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0106, code lost:
        if (r2.zzcdc != 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0108, code lost:
        com.google.android.gms.internal.zzafj.zzbw("Adapter succeeded.");
        r24.zzamo.zzf("mediation_network_succeed", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x011a, code lost:
        if (r18.isEmpty() != false) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011c, code lost:
        r24.zzamo.zzf("mediation_networks_fail", android.text.TextUtils.join(",", r18));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012d, code lost:
        r24.zzamo.zza(r22, "mls");
        r24.zzamo.zza(r19, "ttm");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0154, code lost:
        r18.add(r4);
        r24.zzamo.zza(r22, "mlf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x016c, code lost:
        if (r2.zzcde == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x016e, code lost:
        com.google.android.gms.internal.zzagr.zzczc.post(new com.google.android.gms.internal.zzua(r24, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zztt zzg(java.util.List<com.google.android.gms.internal.zztm> r25) {
        /*
            r24 = this;
            java.lang.String r2 = "Starting mediation."
            com.google.android.gms.internal.zzafj.zzbw(r2)
            java.util.ArrayList r18 = new java.util.ArrayList
            r18.<init>()
            r0 = r24
            com.google.android.gms.internal.zznd r2 = r0.zzamo
            com.google.android.gms.internal.zznb r19 = r2.zziz()
            r0 = r24
            com.google.android.gms.internal.zzzz r2 = r0.zzcdj
            com.google.android.gms.internal.zziw r2 = r2.zzath
            r3 = 2
            int[] r3 = new int[r3]
            com.google.android.gms.internal.zziw[] r4 = r2.zzbdc
            if (r4 == 0) goto L_0x019b
            com.google.android.gms.ads.internal.zzbs.zzew()
            r0 = r24
            java.lang.String r4 = r0.zzcdo
            boolean r4 = com.google.android.gms.internal.zztv.zza((java.lang.String) r4, (int[]) r3)
            if (r4 == 0) goto L_0x019b
            r4 = 0
            r4 = r3[r4]
            r5 = 1
            r5 = r3[r5]
            com.google.android.gms.internal.zziw[] r6 = r2.zzbdc
            int r7 = r6.length
            r3 = 0
        L_0x0036:
            if (r3 >= r7) goto L_0x019b
            r9 = r6[r3]
            int r8 = r9.width
            if (r4 != r8) goto L_0x0096
            int r8 = r9.height
            if (r5 != r8) goto L_0x0096
        L_0x0042:
            java.util.Iterator r20 = r25.iterator()
        L_0x0046:
            boolean r2 = r20.hasNext()
            if (r2 == 0) goto L_0x017c
            java.lang.Object r7 = r20.next()
            com.google.android.gms.internal.zztm r7 = (com.google.android.gms.internal.zztm) r7
            java.lang.String r3 = "Trying mediation network: "
            java.lang.String r2 = r7.zzcbc
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x0099
            java.lang.String r2 = r3.concat(r2)
        L_0x0064:
            com.google.android.gms.internal.zzafj.zzcn(r2)
            java.util.List<java.lang.String> r2 = r7.zzcbd
            java.util.Iterator r21 = r2.iterator()
        L_0x006d:
            boolean r2 = r21.hasNext()
            if (r2 == 0) goto L_0x0046
            java.lang.Object r4 = r21.next()
            java.lang.String r4 = (java.lang.String) r4
            r0 = r24
            com.google.android.gms.internal.zznd r2 = r0.zzamo
            com.google.android.gms.internal.zznb r22 = r2.zziz()
            r0 = r24
            java.lang.Object r0 = r0.mLock
            r23 = r0
            monitor-enter(r23)
            r0 = r24
            boolean r2 = r0.zzcdm     // Catch:{ all -> 0x0151 }
            if (r2 == 0) goto L_0x009f
            com.google.android.gms.internal.zztt r2 = new com.google.android.gms.internal.zztt     // Catch:{ all -> 0x0151 }
            r3 = -1
            r2.<init>(r3)     // Catch:{ all -> 0x0151 }
            monitor-exit(r23)     // Catch:{ all -> 0x0151 }
        L_0x0095:
            return r2
        L_0x0096:
            int r3 = r3 + 1
            goto L_0x0036
        L_0x0099:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            goto L_0x0064
        L_0x009f:
            com.google.android.gms.internal.zztq r2 = new com.google.android.gms.internal.zztq     // Catch:{ all -> 0x0151 }
            r0 = r24
            android.content.Context r3 = r0.mContext     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zzuc r5 = r0.zzanb     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zztn r6 = r0.zzccq     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zzzz r8 = r0.zzcdj     // Catch:{ all -> 0x0151 }
            com.google.android.gms.internal.zzis r8 = r8.zzclo     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zzzz r10 = r0.zzcdj     // Catch:{ all -> 0x0151 }
            com.google.android.gms.internal.zzaiy r10 = r10.zzatd     // Catch:{ all -> 0x0151 }
            r0 = r24
            boolean r11 = r0.zzauu     // Catch:{ all -> 0x0151 }
            r0 = r24
            boolean r12 = r0.zzccu     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zzzz r13 = r0.zzcdj     // Catch:{ all -> 0x0151 }
            com.google.android.gms.internal.zzom r13 = r13.zzatt     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zzzz r14 = r0.zzcdj     // Catch:{ all -> 0x0151 }
            java.util.List<java.lang.String> r14 = r14.zzaub     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zzzz r15 = r0.zzcdj     // Catch:{ all -> 0x0151 }
            java.util.List<java.lang.String> r15 = r15.zzcmd     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zzzz r0 = r0.zzcdj     // Catch:{ all -> 0x0151 }
            r16 = r0
            r0 = r16
            java.util.List<java.lang.String> r0 = r0.zzcmy     // Catch:{ all -> 0x0151 }
            r16 = r0
            r0 = r24
            boolean r0 = r0.zzccv     // Catch:{ all -> 0x0151 }
            r17 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0151 }
            r0 = r24
            r0.zzcdt = r2     // Catch:{ all -> 0x0151 }
            monitor-exit(r23)     // Catch:{ all -> 0x0151 }
            r0 = r24
            com.google.android.gms.internal.zztq r2 = r0.zzcdt
            r0 = r24
            long r10 = r0.mStartTime
            r0 = r24
            long r12 = r0.zzcdk
            com.google.android.gms.internal.zztt r2 = r2.zza((long) r10, (long) r12)
            r0 = r24
            java.util.List<com.google.android.gms.internal.zztt> r3 = r0.zzcdp
            r3.add(r2)
            int r3 = r2.zzcdc
            if (r3 != 0) goto L_0x0154
            java.lang.String r3 = "Adapter succeeded."
            com.google.android.gms.internal.zzafj.zzbw(r3)
            r0 = r24
            com.google.android.gms.internal.zznd r3 = r0.zzamo
            java.lang.String r5 = "mediation_network_succeed"
            r3.zzf(r5, r4)
            boolean r3 = r18.isEmpty()
            if (r3 != 0) goto L_0x012d
            r0 = r24
            com.google.android.gms.internal.zznd r3 = r0.zzamo
            java.lang.String r4 = "mediation_networks_fail"
            java.lang.String r5 = ","
            r0 = r18
            java.lang.String r5 = android.text.TextUtils.join(r5, r0)
            r3.zzf(r4, r5)
        L_0x012d:
            r0 = r24
            com.google.android.gms.internal.zznd r3 = r0.zzamo
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mls"
            r4[r5] = r6
            r0 = r22
            r3.zza(r0, r4)
            r0 = r24
            com.google.android.gms.internal.zznd r3 = r0.zzamo
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "ttm"
            r4[r5] = r6
            r0 = r19
            r3.zza(r0, r4)
            goto L_0x0095
        L_0x0151:
            r2 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x0151 }
            throw r2
        L_0x0154:
            r0 = r18
            r0.add(r4)
            r0 = r24
            com.google.android.gms.internal.zznd r3 = r0.zzamo
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mlf"
            r4[r5] = r6
            r0 = r22
            r3.zza(r0, r4)
            com.google.android.gms.internal.zzuf r3 = r2.zzcde
            if (r3 == 0) goto L_0x006d
            android.os.Handler r3 = com.google.android.gms.internal.zzagr.zzczc
            com.google.android.gms.internal.zzua r4 = new com.google.android.gms.internal.zzua
            r0 = r24
            r4.<init>(r0, r2)
            r3.post(r4)
            goto L_0x006d
        L_0x017c:
            boolean r2 = r18.isEmpty()
            if (r2 != 0) goto L_0x0193
            r0 = r24
            com.google.android.gms.internal.zznd r2 = r0.zzamo
            java.lang.String r3 = "mediation_networks_fail"
            java.lang.String r4 = ","
            r0 = r18
            java.lang.String r4 = android.text.TextUtils.join(r4, r0)
            r2.zzf(r3, r4)
        L_0x0193:
            com.google.android.gms.internal.zztt r2 = new com.google.android.gms.internal.zztt
            r3 = 1
            r2.<init>(r3)
            goto L_0x0095
        L_0x019b:
            r9 = r2
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztz.zzg(java.util.List):com.google.android.gms.internal.zztt");
    }

    public final List<zztt> zzlo() {
        return this.zzcdp;
    }
}
