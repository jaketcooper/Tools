package com.google.android.gms.internal;

@zzzb
public final class zzyh implements zzxx<zzns> {
    private final boolean zzccv;
    private final boolean zzcjy;
    private final boolean zzcjz;

    public zzyh(boolean z, boolean z2, boolean z3) {
        this.zzcjy = z;
        this.zzcjz = z2;
        this.zzccv = z3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.zzoc zza(com.google.android.gms.internal.zzxr r19, org.json.JSONObject r20) throws org.json.JSONException, java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        /*
            r18 = this;
            java.lang.String r4 = "images"
            r5 = 0
            r0 = r18
            boolean r6 = r0.zzcjy
            r0 = r18
            boolean r7 = r0.zzcjz
            r2 = r19
            r3 = r20
            java.util.List r2 = r2.zza(r3, r4, r5, r6, r7)
            java.lang.String r3 = "app_icon"
            r4 = 1
            r0 = r18
            boolean r5 = r0.zzcjy
            r0 = r19
            r1 = r20
            com.google.android.gms.internal.zzajp r6 = r0.zza(r1, r3, r4, r5)
            java.lang.String r3 = "video"
            r0 = r19
            r1 = r20
            com.google.android.gms.internal.zzajp r3 = r0.zzc((org.json.JSONObject) r1, (java.lang.String) r3)
            com.google.android.gms.internal.zzajp r12 = r19.zzh(r20)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r5 = r2.iterator()
        L_0x0039:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x004f
            java.lang.Object r2 = r5.next()
            com.google.android.gms.internal.zzajp r2 = (com.google.android.gms.internal.zzajp) r2
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.zznr r2 = (com.google.android.gms.internal.zznr) r2
            r4.add(r2)
            goto L_0x0039
        L_0x004f:
            com.google.android.gms.internal.zzama r15 = com.google.android.gms.internal.zzxr.zzb(r3)
            com.google.android.gms.internal.zzns r2 = new com.google.android.gms.internal.zzns
            java.lang.String r3 = "headline"
            r0 = r20
            java.lang.String r5 = r0.getString(r3)
            r0 = r18
            boolean r3 = r0.zzccv
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r3 = com.google.android.gms.internal.zzmq.zzbqc
            com.google.android.gms.internal.zzmo r7 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r3 = r7.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.internal.zzaez r3 = com.google.android.gms.ads.internal.zzbs.zzeg()
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x00f8
            int r7 = com.google.android.gms.C0555R.string.f83s7
            java.lang.String r3 = r3.getString(r7)
        L_0x0085:
            if (r5 == 0) goto L_0x00b1
            java.lang.String r7 = java.lang.String.valueOf(r3)
            int r7 = r7.length()
            int r7 = r7 + 3
            java.lang.String r8 = java.lang.String.valueOf(r5)
            int r8 = r8.length()
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            java.lang.StringBuilder r3 = r8.append(r3)
            java.lang.String r7 = " : "
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
        L_0x00b1:
            java.lang.String r5 = "body"
            r0 = r20
            java.lang.String r5 = r0.getString(r5)
            java.lang.Object r6 = r6.get()
            com.google.android.gms.internal.zzoy r6 = (com.google.android.gms.internal.zzoy) r6
            java.lang.String r7 = "call_to_action"
            r0 = r20
            java.lang.String r7 = r0.getString(r7)
            java.lang.String r8 = "rating"
            r10 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r0 = r20
            double r8 = r0.optDouble(r8, r10)
            java.lang.String r10 = "store"
            r0 = r20
            java.lang.String r10 = r0.optString(r10)
            java.lang.String r11 = "price"
            r0 = r20
            java.lang.String r11 = r0.optString(r11)
            java.lang.Object r12 = r12.get()
            com.google.android.gms.internal.zznp r12 = (com.google.android.gms.internal.zznp) r12
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            if (r15 == 0) goto L_0x00fd
            com.google.android.gms.internal.zzamr r14 = r15.zzrx()
        L_0x00f2:
            if (r15 == 0) goto L_0x0109
            if (r15 != 0) goto L_0x00ff
            r2 = 0
            throw r2
        L_0x00f8:
            java.lang.String r3 = "Test Ad"
            goto L_0x0085
        L_0x00fb:
            r3 = r5
            goto L_0x00b1
        L_0x00fd:
            r14 = 0
            goto L_0x00f2
        L_0x00ff:
            android.view.View r15 = (android.view.View) r15
        L_0x0101:
            r16 = 0
            r17 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17)
            return r2
        L_0x0109:
            r15 = 0
            goto L_0x0101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzyh.zza(com.google.android.gms.internal.zzxr, org.json.JSONObject):com.google.android.gms.internal.zzoc");
    }
}
