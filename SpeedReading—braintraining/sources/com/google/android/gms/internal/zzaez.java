package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzaez implements zzagk, zzgs {
    private Context mContext;
    private final Object mLock = new Object();
    private zzfb zzamv;
    private zzaiy zzaov;
    private boolean zzaqh = false;
    private zzgo zzayk = null;
    private boolean zzcqv = true;
    private boolean zzcqw = true;
    private boolean zzcqx = true;
    private boolean zzcre = false;
    private final zzafd zzcww = new zzafd(zzjk.zzhz());
    private BigInteger zzcwx = BigInteger.ONE;
    private final HashSet<zzaew> zzcwy = new HashSet<>();
    private final HashMap<String, zzaff> zzcwz = new HashMap<>();
    private boolean zzcxa = false;
    private int zzcxb = 0;
    private zzmt zzcxc = null;
    private zzgt zzcxd = null;
    private String zzcxe;
    private String zzcxf;
    private Boolean zzcxg = null;
    private String zzcxh;
    private boolean zzcxi = false;
    private boolean zzcxj = false;
    private String zzcxk = "";
    private long zzcxl = 0;
    private long zzcxm = 0;
    private long zzcxn = 0;
    private int zzcxo = -1;
    private JSONObject zzcxp = new JSONObject();
    private int zzcxq = 0;
    private final AtomicInteger zzcxr = new AtomicInteger(0);
    private final zzafb zzcxs = new zzafb();

    public zzaez(zzagr zzagr) {
    }

    private final Future zzad(int i) {
        Future zzb;
        synchronized (this.mLock) {
            this.zzcxo = i;
            zzb = zzafl.zzb(this.mContext, i);
        }
        return zzb;
    }

    private final Future zzi(long j) {
        Future zza;
        synchronized (this.mLock) {
            this.zzcxm = j;
            zza = zzafl.zza(this.mContext, j);
        }
        return zza;
    }

    public final Resources getResources() {
        if (this.zzaov.zzdcb) {
            return this.mContext.getResources();
        }
        try {
            DynamiteModule zza = DynamiteModule.zza(this.mContext, DynamiteModule.zzgum, ModuleDescriptor.MODULE_ID);
            if (zza != null) {
                return zza.zzapq().getResources();
            }
            return null;
        } catch (DynamiteModule.zzc e) {
            zzafj.zzc("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final Bundle zza(Context context, zzafe zzafe, String str) {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzcww.zzl(context, str));
            Bundle bundle2 = new Bundle();
            for (String next : this.zzcwz.keySet()) {
                bundle2.putBundle(next, this.zzcwz.get(next).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator<zzaew> it = this.zzcwy.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzafe.zza(this.zzcwy);
            this.zzcwy.clear();
        }
        return bundle;
    }

    public final void zza(zzaew zzaew) {
        synchronized (this.mLock) {
            this.zzcwy.add(zzaew);
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.mLock) {
            this.zzcxg = bool;
        }
    }

    public final void zza(String str, zzaff zzaff) {
        synchronized (this.mLock) {
            this.zzcwz.put(str, zzaff);
        }
    }

    public final void zza(Throwable th, String str) {
        zzyu.zzc(this.mContext, this.zzaov).zza(th, str);
    }

    public final Future zzac(int i) {
        Future zza;
        synchronized (this.mLock) {
            this.zzcxq = i;
            zza = zzafl.zza(this.mContext, i);
        }
        return zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzgt zzad(android.content.Context r6) {
        /*
            r5 = this;
            r1 = 0
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbia
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0015
            r0 = r1
        L_0x0014:
            return r0
        L_0x0015:
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbii
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x003b
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbig
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x003b
            r0 = r1
            goto L_0x0014
        L_0x003b:
            boolean r0 = r5.zzos()
            if (r0 == 0) goto L_0x0049
            boolean r0 = r5.zzot()
            if (r0 == 0) goto L_0x0049
            r0 = r1
            goto L_0x0014
        L_0x0049:
            java.lang.Object r2 = r5.mLock
            monitor-enter(r2)
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0080 }
            if (r0 == 0) goto L_0x0054
            if (r6 != 0) goto L_0x0057
        L_0x0054:
            monitor-exit(r2)     // Catch:{ all -> 0x0080 }
            r0 = r1
            goto L_0x0014
        L_0x0057:
            com.google.android.gms.internal.zzgo r0 = r5.zzayk     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x0062
            com.google.android.gms.internal.zzgo r0 = new com.google.android.gms.internal.zzgo     // Catch:{ all -> 0x0080 }
            r0.<init>()     // Catch:{ all -> 0x0080 }
            r5.zzayk = r0     // Catch:{ all -> 0x0080 }
        L_0x0062:
            com.google.android.gms.internal.zzgt r0 = r5.zzcxd     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x0077
            com.google.android.gms.internal.zzgt r0 = new com.google.android.gms.internal.zzgt     // Catch:{ all -> 0x0080 }
            com.google.android.gms.internal.zzgo r1 = r5.zzayk     // Catch:{ all -> 0x0080 }
            android.content.Context r3 = r5.mContext     // Catch:{ all -> 0x0080 }
            com.google.android.gms.internal.zzaiy r4 = r5.zzaov     // Catch:{ all -> 0x0080 }
            com.google.android.gms.internal.zzyz r3 = com.google.android.gms.internal.zzyu.zzc(r3, r4)     // Catch:{ all -> 0x0080 }
            r0.<init>(r1, r3)     // Catch:{ all -> 0x0080 }
            r5.zzcxd = r0     // Catch:{ all -> 0x0080 }
        L_0x0077:
            com.google.android.gms.internal.zzgt r0 = r5.zzcxd     // Catch:{ all -> 0x0080 }
            r0.zzgq()     // Catch:{ all -> 0x0080 }
            com.google.android.gms.internal.zzgt r0 = r5.zzcxd     // Catch:{ all -> 0x0080 }
            monitor-exit(r2)     // Catch:{ all -> 0x0080 }
            goto L_0x0014
        L_0x0080:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0080 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaez.zzad(android.content.Context):com.google.android.gms.internal.zzgt");
    }

    public final Future zzb(Context context, String str, String str2, boolean z) {
        Future zzo;
        int i = 0;
        synchronized (this.mLock) {
            JSONArray optJSONArray = this.zzcxp.optJSONArray(str);
            JSONArray jSONArray = optJSONArray == null ? new JSONArray() : optJSONArray;
            int length = jSONArray.length();
            while (true) {
                if (i >= jSONArray.length()) {
                    i = length;
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject == null || !str2.equals(optJSONObject.optString("template_id"))) {
                    i++;
                } else if (z && optJSONObject.optBoolean("uses_media_view", false) == z) {
                    zzo = null;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzbs.zzei().currentTimeMillis());
                jSONArray.put(i, jSONObject);
                this.zzcxp.put(str, jSONArray);
            } catch (JSONException e) {
                zzafj.zzc("Could not update native advanced settings", e);
            }
            zzo = zzafl.zzo(this.mContext, this.zzcxp.toString());
        }
        return zzo;
    }

    public final void zzb(Bundle bundle) {
        synchronized (this.mLock) {
            this.zzcqv = bundle.getBoolean("use_https", this.zzcqv);
            this.zzcxb = bundle.getInt("webview_cache_version", this.zzcxb);
            if (bundle.containsKey("content_url_opted_out")) {
                zzx(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.zzcxe = bundle.getString("content_url_hashes");
            }
            this.zzcre = bundle.getBoolean("auto_collect_location", this.zzcre);
            if (bundle.containsKey("content_vertical_opted_out")) {
                zzy(bundle.getBoolean("content_vertical_opted_out"));
            }
            if (bundle.containsKey("content_vertical_hashes")) {
                this.zzcxf = bundle.getString("content_vertical_hashes");
            }
            if (bundle.containsKey("native_advanced_settings")) {
                try {
                    this.zzcxp = new JSONObject(bundle.getString("native_advanced_settings"));
                } catch (JSONException e) {
                    zzafj.zzc("Could not convert native advanced settings to json object", e);
                }
            }
            if (bundle.containsKey("version_code")) {
                this.zzcxq = bundle.getInt("version_code");
            }
            this.zzcxk = bundle.containsKey("app_settings_json") ? bundle.getString("app_settings_json") : this.zzcxk;
            this.zzcxl = bundle.getLong("app_settings_last_update_ms", this.zzcxl);
            this.zzcxm = bundle.getLong("app_last_background_time_ms", this.zzcxm);
            this.zzcxo = bundle.getInt("request_in_session_count", this.zzcxo);
            this.zzcxn = bundle.getLong("first_ad_req_time_ms", this.zzcxn);
        }
    }

    public final void zzb(HashSet<zzaew> hashSet) {
        synchronized (this.mLock) {
            this.zzcwy.addAll(hashSet);
        }
    }

    public final Future zzbz(String str) {
        Future future;
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzcxe)) {
                    this.zzcxe = str;
                    future = zzafl.zzm(this.mContext, str);
                }
            }
            future = null;
        }
        return future;
    }

    public final Future zzca(String str) {
        Future future;
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzcxf)) {
                    this.zzcxf = str;
                    future = zzafl.zzn(this.mContext, str);
                }
            }
            future = null;
        }
        return future;
    }

    @TargetApi(23)
    public final void zzd(Context context, zzaiy zzaiy) {
        synchronized (this.mLock) {
            if (!this.zzaqh) {
                this.mContext = context.getApplicationContext();
                this.zzaov = zzaiy;
                zzbs.zzef().zza(this);
                zzafl.zza(context, (zzagk) this);
                zzafl.zzb(context, (zzagk) this);
                zzafl.zzh(context, (zzagk) this);
                zzafl.zzf(context, (zzagk) this);
                zzafl.zzc(context, this);
                zzafl.zzd(context, this);
                zzafl.zze(context, this);
                zzafl.zzg(context, this);
                zzafl.zzi(context, (zzagk) this);
                zzafl.zzj(context, this);
                zzafl.zzk(context, this);
                zzyu.zzc(this.mContext, this.zzaov);
                this.zzcxh = zzbs.zzec().zzp(context, zzaiy.zzcp);
                if (Build.VERSION.SDK_INT >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.zzcxj = true;
                }
                this.zzamv = new zzfb(context.getApplicationContext(), this.zzaov);
                zzms zzms = new zzms(this.mContext, this.zzaov.zzcp);
                try {
                    zzbs.zzek();
                    this.zzcxc = zzmv.zza(zzms);
                } catch (IllegalArgumentException e) {
                    zzafj.zzc("Cannot initialize CSI reporter.", e);
                }
                this.zzaqh = true;
            }
        }
    }

    public final Future zzf(Context context, boolean z) {
        Future future;
        synchronized (this.mLock) {
            if (z != this.zzcqv) {
                this.zzcqv = z;
                future = zzafl.zzf(context, z);
            } else {
                future = null;
            }
        }
        return future;
    }

    public final Future zzg(Context context, boolean z) {
        Future future;
        synchronized (this.mLock) {
            if (z != this.zzcre) {
                this.zzcre = z;
                future = zzafl.zzi(context, z);
            } else {
                future = null;
            }
        }
        return future;
    }

    public final void zzg(boolean z) {
        long currentTimeMillis = zzbs.zzei().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzcxm > ((Long) zzbs.zzep().zzd(zzmq.zzbjs)).longValue()) {
                this.zzcww.zzcxo = -1;
                return;
            }
            this.zzcww.zzcxo = this.zzcxo;
            return;
        }
        zzi(currentTimeMillis);
        zzad(this.zzcww.zzcxo);
    }

    /* access modifiers changed from: package-private */
    public final Future zzj(long j) {
        Future zzb;
        synchronized (this.mLock) {
            this.zzcxn = j;
            zzb = zzafl.zzb(this.mContext, j);
        }
        return zzb;
    }

    public final zzajp zzk(Context context, String str) {
        zzajp zzi;
        this.zzcxl = zzbs.zzei().currentTimeMillis();
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzcxk)) {
                    this.zzcxk = str;
                    zzi = zzafl.zza(context, str, this.zzcxl);
                }
            }
            zzi = zzajg.zzi(null);
        }
        return zzi;
    }

    public final boolean zzos() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcqw;
        }
        return z;
    }

    public final boolean zzot() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcqx;
        }
        return z;
    }

    public final String zzou() {
        String bigInteger;
        synchronized (this.mLock) {
            bigInteger = this.zzcwx.toString();
            this.zzcwx = this.zzcwx.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public final zzafd zzov() {
        zzafd zzafd;
        synchronized (this.mLock) {
            zzafd = this.zzcww;
        }
        return zzafd;
    }

    public final zzmt zzow() {
        zzmt zzmt;
        synchronized (this.mLock) {
            zzmt = this.zzcxc;
        }
        return zzmt;
    }

    public final boolean zzox() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcqv || this.zzcxj;
        }
        return z;
    }

    public final String zzoy() {
        String str;
        synchronized (this.mLock) {
            str = this.zzcxe;
        }
        return str;
    }

    public final String zzoz() {
        String str;
        synchronized (this.mLock) {
            str = this.zzcxf;
        }
        return str;
    }

    public final Boolean zzpa() {
        Boolean bool;
        synchronized (this.mLock) {
            bool = this.zzcxg;
        }
        return bool;
    }

    public final boolean zzpb() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcre;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final long zzpc() {
        long j;
        synchronized (this.mLock) {
            j = this.zzcxm;
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public final long zzpd() {
        long j;
        synchronized (this.mLock) {
            j = this.zzcxn;
        }
        return j;
    }

    public final int zzpe() {
        int i;
        synchronized (this.mLock) {
            i = this.zzcxq;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final int zzpf() {
        int i;
        synchronized (this.mLock) {
            i = this.zzcxo;
        }
        return i;
    }

    public final boolean zzpg() {
        return this.zzcxs.zzpg();
    }

    public final boolean zzph() {
        return this.zzcxs.zzph();
    }

    public final void zzpi() {
        this.zzcxs.zzpi();
    }

    public final zzaey zzpj() {
        zzaey zzaey;
        synchronized (this.mLock) {
            zzaey = new zzaey(this.zzcxk, this.zzcxl);
        }
        return zzaey;
    }

    public final JSONObject zzpk() {
        JSONObject jSONObject;
        synchronized (this.mLock) {
            jSONObject = this.zzcxp;
        }
        return jSONObject;
    }

    public final Future zzpl() {
        Future zzaf;
        synchronized (this.mLock) {
            zzaf = zzafl.zzaf(this.mContext);
        }
        return zzaf;
    }

    public final zzfb zzpm() {
        return this.zzamv;
    }

    public final void zzpn() {
        this.zzcxr.incrementAndGet();
    }

    public final void zzpo() {
        this.zzcxr.decrementAndGet();
    }

    public final int zzpp() {
        return this.zzcxr.get();
    }

    public final void zzx(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcqw != z) {
                zzafl.zzh(this.mContext, z);
            }
            this.zzcqw = z;
            zzgt zzad = zzad(this.mContext);
            if (zzad != null && !zzad.isAlive()) {
                zzafj.zzcn("start fetching content...");
                zzad.zzgq();
            }
        }
    }

    public final void zzy(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcqx != z) {
                zzafl.zzh(this.mContext, z);
            }
            zzafl.zzh(this.mContext, z);
            this.zzcqx = z;
            zzgt zzad = zzad(this.mContext);
            if (zzad != null && !zzad.isAlive()) {
                zzafj.zzcn("start fetching content...");
                zzad.zzgq();
            }
        }
    }

    public final void zzz(boolean z) {
        this.zzcxs.zzz(z);
    }
}
