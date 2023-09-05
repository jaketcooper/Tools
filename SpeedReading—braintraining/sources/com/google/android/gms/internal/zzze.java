package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzid;
import org.json.JSONObject;

@zzzb
public final class zzze extends zzafh implements zzzr {
    private final Context mContext;
    private zztn zzccq;
    private zzzz zzcdj;
    private zzaad zzchw;
    /* access modifiers changed from: private */
    public Runnable zzchx;
    /* access modifiers changed from: private */
    public final Object zzchy = new Object();
    private final zzzd zzckx;
    /* access modifiers changed from: private */
    public final zzaaa zzcky;
    private final zzib zzckz;
    private final zzig zzcla;
    zzahi zzclb;

    public zzze(Context context, zzaaa zzaaa, zzzd zzzd, zzig zzig) {
        this.zzckx = zzzd;
        this.mContext = context;
        this.zzcky = zzaaa;
        this.zzcla = zzig;
        this.zzckz = new zzib(this.zzcla, ((Boolean) zzbs.zzep().zzd(zzmq.zzbpk)).booleanValue());
        this.zzckz.zza((zzic) new zzzf(this));
        zzim zzim = new zzim();
        zzim.zzbbq = Integer.valueOf(this.zzcky.zzatd.zzdbz);
        zzim.zzbbr = Integer.valueOf(this.zzcky.zzatd.zzdca);
        zzim.zzbbs = Integer.valueOf(this.zzcky.zzatd.zzdcb ? 0 : 2);
        this.zzckz.zza((zzic) new zzzg(zzim));
        if (this.zzcky.zzclp != null) {
            this.zzckz.zza((zzic) new zzzh(this));
        }
        zziw zziw = this.zzcky.zzath;
        if (zziw.zzbdb && "interstitial_mb".equals(zziw.zzbda)) {
            this.zzckz.zza(zzzi.zzcle);
        } else if (zziw.zzbdb && "reward_mb".equals(zziw.zzbda)) {
            this.zzckz.zza(zzzj.zzcle);
        } else if (zziw.zzbdd || zziw.zzbdb) {
            this.zzckz.zza(zzzl.zzcle);
        } else {
            this.zzckz.zza(zzzk.zzcle);
        }
        this.zzckz.zza(zzid.zza.zzb.AD_REQUEST);
    }

    private final zziw zza(zzzz zzzz) throws zzzo {
        boolean z = true;
        if (this.zzcdj == null || this.zzcdj.zzatx == null || this.zzcdj.zzatx.size() <= 1) {
            z = false;
        }
        if (z && this.zzccq != null && !this.zzccq.zzccl) {
            return null;
        }
        if (this.zzchw.zzbde) {
            for (zziw zziw : zzzz.zzath.zzbdc) {
                if (zziw.zzbde) {
                    return new zziw(zziw, zzzz.zzath.zzbdc);
                }
            }
        }
        if (this.zzchw.zzcnj == null) {
            throw new zzzo("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzchw.zzcnj.split("x");
        if (split.length != 2) {
            String valueOf = String.valueOf(this.zzchw.zzcnj);
            throw new zzzo(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (zziw zziw2 : zzzz.zzath.zzbdc) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = zziw2.width == -1 ? (int) (((float) zziw2.widthPixels) / f) : zziw2.width;
                int i2 = zziw2.height == -2 ? (int) (((float) zziw2.heightPixels) / f) : zziw2.height;
                if (parseInt == i && parseInt2 == i2 && !zziw2.zzbde) {
                    return new zziw(zziw2, zzzz.zzath.zzbdc);
                }
            }
            String valueOf2 = String.valueOf(this.zzchw.zzcnj);
            throw new zzzo(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
        } catch (NumberFormatException e) {
            String valueOf3 = String.valueOf(this.zzchw.zzcnj);
            throw new zzzo(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(int i, String str) {
        if (i == 3 || i == -1) {
            zzafj.zzcn(str);
        } else {
            zzafj.zzco(str);
        }
        if (this.zzchw == null) {
            this.zzchw = new zzaad(i);
        } else {
            this.zzchw = new zzaad(i, this.zzchw.zzccb);
        }
        this.zzckx.zza(new zzaev(this.zzcdj != null ? this.zzcdj : new zzzz(this.zzcky, -1, (String) null, (String) null, (String) null), this.zzchw, this.zzccq, (zziw) null, i, -1, this.zzchw.zzcnk, (JSONObject) null, this.zzckz, (Boolean) null));
    }

    public final void onStop() {
        synchronized (this.zzchy) {
            if (this.zzclb != null) {
                this.zzclb.cancel();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzahi zza(zzaiy zzaiy, zzaka<zzzz> zzaka) {
        Context context = this.mContext;
        if (new zzzq(context).zza(zzaiy)) {
            zzafj.zzbw("Fetching ad response from local ad request service.");
            zzzw zzzw = new zzzw(context, zzaka, this);
            zzzw.zzmx();
            return zzzw;
        }
        zzafj.zzbw("Fetching ad response from remote ad request service.");
        zzjk.zzhx();
        if (zzais.zzbd(context)) {
            return new zzzx(context, zzaiy, zzaka, this);
        }
        zzafj.zzco("Failed to connect to remote ad request service.");
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(@android.support.annotation.NonNull com.google.android.gms.internal.zzaad r14) {
        /*
            r13 = this;
            r5 = -2
            r10 = -3
            r9 = 1
            r1 = 0
            r8 = 0
            java.lang.String r0 = "Received ad response."
            com.google.android.gms.internal.zzafj.zzbw(r0)
            r13.zzchw = r14
            com.google.android.gms.common.util.zzd r0 = com.google.android.gms.ads.internal.zzbs.zzei()
            long r6 = r0.elapsedRealtime()
            java.lang.Object r2 = r13.zzchy
            monitor-enter(r2)
            r0 = 0
            r13.zzclb = r0     // Catch:{ all -> 0x00b6 }
            monitor-exit(r2)     // Catch:{ all -> 0x00b6 }
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()
            android.content.Context r2 = r13.mContext
            com.google.android.gms.internal.zzaad r3 = r13.zzchw
            boolean r3 = r3.zzcmk
            r0.zzg(r2, r3)
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbkg
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.internal.zzaad r0 = r13.zzchw
            boolean r0 = r0.zzcmw
            if (r0 == 0) goto L_0x00b9
            com.google.android.gms.ads.internal.zzbs.zzeg()
            android.content.Context r0 = r13.mContext
            com.google.android.gms.internal.zzzz r2 = r13.zzcdj
            java.lang.String r2 = r2.zzatb
            java.lang.String r3 = "admob"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r8)
            java.util.Set r3 = java.util.Collections.emptySet()
            java.lang.String r4 = "never_pool_slots"
            java.util.Set r3 = r0.getStringSet(r4, r3)
            boolean r4 = r3.contains(r2)
            if (r4 != 0) goto L_0x0073
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>(r3)
            r4.add(r2)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r2 = "never_pool_slots"
            r0.putStringSet(r2, r4)
            r0.apply()
        L_0x0073:
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            int r0 = r0.errorCode     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == r5) goto L_0x00ed
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            int r0 = r0.errorCode     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == r10) goto L_0x00ed
            com.google.android.gms.internal.zzzo r0 = new com.google.android.gms.internal.zzzo     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzaad r1 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            int r1 = r1.errorCode     // Catch:{ zzzo -> 0x00a2 }
            r2 = 66
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ zzzo -> 0x00a2 }
            r3.<init>(r2)     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r2 = "There was a problem getting an ad response. ErrorCode: "
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ zzzo -> 0x00a2 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r1 = r1.toString()     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzaad r2 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            int r2 = r2.errorCode     // Catch:{ zzzo -> 0x00a2 }
            r0.<init>(r1, r2)     // Catch:{ zzzo -> 0x00a2 }
            throw r0     // Catch:{ zzzo -> 0x00a2 }
        L_0x00a2:
            r0 = move-exception
            int r1 = r0.getErrorCode()
            java.lang.String r0 = r0.getMessage()
            r13.zzc(r1, r0)
            android.os.Handler r0 = com.google.android.gms.internal.zzagr.zzczc
            java.lang.Runnable r1 = r13.zzchx
            r0.removeCallbacks(r1)
        L_0x00b5:
            return
        L_0x00b6:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00b6 }
            throw r0
        L_0x00b9:
            com.google.android.gms.ads.internal.zzbs.zzeg()
            android.content.Context r0 = r13.mContext
            com.google.android.gms.internal.zzzz r2 = r13.zzcdj
            java.lang.String r2 = r2.zzatb
            java.lang.String r3 = "admob"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r8)
            java.util.Set r3 = java.util.Collections.emptySet()
            java.lang.String r4 = "never_pool_slots"
            java.util.Set r3 = r0.getStringSet(r4, r3)
            boolean r4 = r3.contains(r2)
            if (r4 == 0) goto L_0x0073
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>(r3)
            r4.remove(r2)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r2 = "never_pool_slots"
            r0.putStringSet(r2, r4)
            r0.apply()
            goto L_0x0073
        L_0x00ed:
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            int r0 = r0.errorCode     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == r10) goto L_0x0165
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r0 = r0.body     // Catch:{ zzzo -> 0x00a2 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == 0) goto L_0x0106
            com.google.android.gms.internal.zzzo r0 = new com.google.android.gms.internal.zzzo     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r1 = "No fill from ad server."
            r2 = 3
            r0.<init>(r1, r2)     // Catch:{ zzzo -> 0x00a2 }
            throw r0     // Catch:{ zzzo -> 0x00a2 }
        L_0x0106:
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ zzzo -> 0x00a2 }
            android.content.Context r2 = r13.mContext     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzaad r3 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            boolean r3 = r3.zzclw     // Catch:{ zzzo -> 0x00a2 }
            r0.zzf(r2, r3)     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            boolean r0 = r0.zzcng     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == 0) goto L_0x0216
            com.google.android.gms.internal.zztn r0 = new com.google.android.gms.internal.zztn     // Catch:{ JSONException -> 0x01ef }
            com.google.android.gms.internal.zzaad r2 = r13.zzchw     // Catch:{ JSONException -> 0x01ef }
            java.lang.String r2 = r2.body     // Catch:{ JSONException -> 0x01ef }
            r0.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x01ef }
            r13.zzccq = r0     // Catch:{ JSONException -> 0x01ef }
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ JSONException -> 0x01ef }
            com.google.android.gms.internal.zztn r2 = r13.zzccq     // Catch:{ JSONException -> 0x01ef }
            boolean r2 = r2.zzcbz     // Catch:{ JSONException -> 0x01ef }
            r0.zzz(r2)     // Catch:{ JSONException -> 0x01ef }
        L_0x012f:
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r0 = r0.zzcml     // Catch:{ zzzo -> 0x00a2 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzzo -> 0x00a2 }
            if (r0 != 0) goto L_0x0165
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzboh     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ zzzo -> 0x00a2 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ zzzo -> 0x00a2 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzzo -> 0x00a2 }
            boolean r0 = r0.booleanValue()     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == 0) goto L_0x0165
            java.lang.String r0 = "Received cookie from server. Setting webview cookie in CookieManager."
            com.google.android.gms.internal.zzafj.zzbw(r0)     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzagw r0 = com.google.android.gms.ads.internal.zzbs.zzee()     // Catch:{ zzzo -> 0x00a2 }
            android.content.Context r2 = r13.mContext     // Catch:{ zzzo -> 0x00a2 }
            android.webkit.CookieManager r0 = r0.zzax(r2)     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == 0) goto L_0x0165
            java.lang.String r2 = "googleads.g.doubleclick.net"
            com.google.android.gms.internal.zzaad r3 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r3 = r3.zzcml     // Catch:{ zzzo -> 0x00a2 }
            r0.setCookie(r2, r3)     // Catch:{ zzzo -> 0x00a2 }
        L_0x0165:
            com.google.android.gms.internal.zzzz r0 = r13.zzcdj     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zziw r0 = r0.zzath     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zziw[] r0 = r0.zzbdc     // Catch:{ zzzo -> 0x00a2 }
            if (r0 == 0) goto L_0x022e
            com.google.android.gms.internal.zzzz r0 = r13.zzcdj     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zziw r4 = r13.zza((com.google.android.gms.internal.zzzz) r0)     // Catch:{ zzzo -> 0x00a2 }
        L_0x0173:
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()
            com.google.android.gms.internal.zzaad r2 = r13.zzchw
            boolean r2 = r2.zzcnq
            r0.zzx(r2)
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()
            com.google.android.gms.internal.zzaad r2 = r13.zzchw
            boolean r2 = r2.zzcod
            r0.zzy(r2)
            com.google.android.gms.internal.zzaad r0 = r13.zzchw
            java.lang.String r0 = r0.zzcno
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0229
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0223 }
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ Exception -> 0x0223 }
            java.lang.String r0 = r0.zzcno     // Catch:{ Exception -> 0x0223 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x0223 }
        L_0x019c:
            com.google.android.gms.internal.zzaad r0 = r13.zzchw
            int r0 = r0.zzcof
            r2 = 2
            if (r0 != r2) goto L_0x01b1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
            com.google.android.gms.ads.internal.zzbs.zzec()
            com.google.android.gms.internal.zzzz r0 = r13.zzcdj
            com.google.android.gms.internal.zzis r0 = r0.zzclo
            com.google.android.gms.internal.zzagr.zzb((com.google.android.gms.internal.zzis) r0, (boolean) r9)
        L_0x01b1:
            com.google.android.gms.internal.zzaad r0 = r13.zzchw
            int r0 = r0.zzcof
            if (r0 != r9) goto L_0x01bb
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r8)
        L_0x01bb:
            com.google.android.gms.internal.zzaad r0 = r13.zzchw
            int r0 = r0.zzcof
            if (r0 != 0) goto L_0x022c
            com.google.android.gms.ads.internal.zzbs.zzec()
            com.google.android.gms.internal.zzzz r0 = r13.zzcdj
            com.google.android.gms.internal.zzis r0 = r0.zzclo
            boolean r0 = com.google.android.gms.internal.zzagr.zzp((com.google.android.gms.internal.zzis) r0)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r0)
        L_0x01d0:
            com.google.android.gms.internal.zzaev r0 = new com.google.android.gms.internal.zzaev
            com.google.android.gms.internal.zzzz r1 = r13.zzcdj
            com.google.android.gms.internal.zzaad r2 = r13.zzchw
            com.google.android.gms.internal.zztn r3 = r13.zzccq
            com.google.android.gms.internal.zzaad r8 = r13.zzchw
            long r8 = r8.zzcnk
            com.google.android.gms.internal.zzib r11 = r13.zzckz
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12)
            com.google.android.gms.internal.zzzd r1 = r13.zzckx
            r1.zza(r0)
            android.os.Handler r0 = com.google.android.gms.internal.zzagr.zzczc
            java.lang.Runnable r1 = r13.zzchx
            r0.removeCallbacks(r1)
            goto L_0x00b5
        L_0x01ef:
            r0 = move-exception
            java.lang.String r1 = "Could not parse mediation config."
            com.google.android.gms.internal.zzafj.zzb(r1, r0)     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzzo r1 = new com.google.android.gms.internal.zzzo     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r2 = "Could not parse mediation config: "
            com.google.android.gms.internal.zzaad r0 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r0 = r0.body     // Catch:{ zzzo -> 0x00a2 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ zzzo -> 0x00a2 }
            int r3 = r0.length()     // Catch:{ zzzo -> 0x00a2 }
            if (r3 == 0) goto L_0x0210
            java.lang.String r0 = r2.concat(r0)     // Catch:{ zzzo -> 0x00a2 }
        L_0x020b:
            r2 = 0
            r1.<init>(r0, r2)     // Catch:{ zzzo -> 0x00a2 }
            throw r1     // Catch:{ zzzo -> 0x00a2 }
        L_0x0210:
            java.lang.String r0 = new java.lang.String     // Catch:{ zzzo -> 0x00a2 }
            r0.<init>(r2)     // Catch:{ zzzo -> 0x00a2 }
            goto L_0x020b
        L_0x0216:
            com.google.android.gms.internal.zzaez r0 = com.google.android.gms.ads.internal.zzbs.zzeg()     // Catch:{ zzzo -> 0x00a2 }
            com.google.android.gms.internal.zzaad r2 = r13.zzchw     // Catch:{ zzzo -> 0x00a2 }
            boolean r2 = r2.zzcbz     // Catch:{ zzzo -> 0x00a2 }
            r0.zzz(r2)     // Catch:{ zzzo -> 0x00a2 }
            goto L_0x012f
        L_0x0223:
            r0 = move-exception
            java.lang.String r2 = "Error parsing the JSON for Active View."
            com.google.android.gms.internal.zzafj.zzb(r2, r0)
        L_0x0229:
            r10 = r1
            goto L_0x019c
        L_0x022c:
            r12 = r1
            goto L_0x01d0
        L_0x022e:
            r4 = r1
            goto L_0x0173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzze.zza(com.google.android.gms.internal.zzaad):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzil zzil) {
        zzil.zzbbo.zzbbl = this.zzcky.zzclp.packageName;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzil zzil) {
        zzil.zzbbn = this.zzcky.zzcmb;
    }

    public final void zzdg() {
        String string;
        zzafj.zzbw("AdLoaderBackgroundTask started.");
        this.zzchx = new zzzm(this);
        zzagr.zzczc.postDelayed(this.zzchx, ((Long) zzbs.zzep().zzd(zzmq.zzbls)).longValue());
        long elapsedRealtime = zzbs.zzei().elapsedRealtime();
        if (!((Boolean) zzbs.zzep().zzd(zzmq.zzblq)).booleanValue() || this.zzcky.zzclo.extras == null || (string = this.zzcky.zzclo.extras.getString("_ad")) == null) {
            zzake zzake = new zzake();
            zzagl.zza(new zzzn(this, zzake));
            String zzx = zzbs.zzfa().zzx(this.mContext);
            String zzy = zzbs.zzfa().zzy(this.mContext);
            String zzz = zzbs.zzfa().zzz(this.mContext);
            zzbs.zzfa().zzg(this.mContext, zzz);
            this.zzcdj = new zzzz(this.zzcky, elapsedRealtime, zzx, zzy, zzz);
            zzake.zzj(this.zzcdj);
            return;
        }
        this.zzcdj = new zzzz(this.zzcky, elapsedRealtime, (String) null, (String) null, (String) null);
        zza(zzabm.zza(this.mContext, this.zzcdj, string));
    }
}
