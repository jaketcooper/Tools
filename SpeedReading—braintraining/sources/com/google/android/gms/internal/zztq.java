package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zztq implements zztu {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final zzuc zzanb;
    private final zzom zzaor;
    private final List<String> zzaos;
    private final zzaiy zzaov;
    private zzis zzara;
    private final zziw zzarg;
    private final boolean zzauu;
    /* access modifiers changed from: private */
    public final String zzcco;
    private final long zzccp;
    private final zztn zzccq;
    private final zztm zzccr;
    private final List<String> zzccs;
    private final List<String> zzcct;
    private final boolean zzccu;
    private final boolean zzccv;
    /* access modifiers changed from: private */
    public zzuf zzccw;
    /* access modifiers changed from: private */
    public int zzccx = -2;
    private zzul zzccy;

    public zztq(Context context, String str, zzuc zzuc, zztn zztn, zztm zztm, zzis zzis, zziw zziw, zzaiy zzaiy, boolean z, boolean z2, zzom zzom, List<String> list, List<String> list2, List<String> list3, boolean z3) {
        this.mContext = context;
        this.zzanb = zzuc;
        this.zzccr = zztm;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzcco = zzlr();
        } else {
            this.zzcco = str;
        }
        this.zzccq = zztn;
        this.zzccp = zztn.zzcbu != -1 ? zztn.zzcbu : 10000;
        this.zzara = zzis;
        this.zzarg = zziw;
        this.zzaov = zzaiy;
        this.zzauu = z;
        this.zzccu = z2;
        this.zzaor = zzom;
        this.zzaos = list;
        this.zzccs = list2;
        this.zzcct = list3;
        this.zzccv = z3;
    }

    private static zzuf zza(MediationAdapter mediationAdapter) {
        return new zzuw(mediationAdapter);
    }

    /* access modifiers changed from: private */
    public final void zza(zztp zztp) {
        String zzbd = zzbd(this.zzccr.zzcbk);
        try {
            if (this.zzaov.zzdca < 4100000) {
                if (this.zzarg.zzbdb) {
                    this.zzccw.zza(zzn.zzy(this.mContext), this.zzara, zzbd, zztp);
                } else {
                    this.zzccw.zza(zzn.zzy(this.mContext), this.zzarg, this.zzara, zzbd, (zzui) zztp);
                }
            } else if (this.zzauu || this.zzccr.zzlq()) {
                ArrayList arrayList = new ArrayList(this.zzaos);
                if (this.zzccs != null) {
                    for (String next : this.zzccs) {
                        String str = ":false";
                        if (this.zzcct != null && this.zzcct.contains(next)) {
                            str = ":true";
                        }
                        arrayList.add(new StringBuilder(String.valueOf(next).length() + 7 + String.valueOf(str).length()).append("custom:").append(next).append(str).toString());
                    }
                }
                this.zzccw.zza(zzn.zzy(this.mContext), this.zzara, zzbd, this.zzccr.zzcbb, zztp, this.zzaor, arrayList);
            } else if (this.zzarg.zzbdb) {
                this.zzccw.zza(zzn.zzy(this.mContext), this.zzara, zzbd, this.zzccr.zzcbb, (zzui) zztp);
            } else if (!this.zzccu) {
                this.zzccw.zza(zzn.zzy(this.mContext), this.zzarg, this.zzara, zzbd, this.zzccr.zzcbb, zztp);
            } else if (this.zzccr.zzcbn != null) {
                this.zzccw.zza(zzn.zzy(this.mContext), this.zzara, zzbd, this.zzccr.zzcbb, zztp, new zzom(zzbe(this.zzccr.zzcbr)), this.zzccr.zzcbq);
            } else {
                this.zzccw.zza(zzn.zzy(this.mContext), this.zzarg, this.zzara, zzbd, this.zzccr.zzcbb, zztp);
            }
        } catch (RemoteException e) {
            zzafj.zzc("Could not request ad from mediation adapter.", e);
            zzv(5);
        }
    }

    private final String zzbd(String str) {
        if (str == null || !zzlu() || zzw(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException e) {
            zzafj.zzco("Could not remove field. Returning the original value");
            return str;
        }
    }

    private static NativeAdOptions zzbe(String str) {
        int i = 0;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            String optString = jSONObject.optString("native_image_orientation", "any");
            if ("landscape".equals(optString)) {
                i = 2;
            } else if ("portrait".equals(optString)) {
                i = 1;
            } else if (!"any".equals(optString)) {
                i = -1;
            }
            builder.setImageOrientation(i);
        } catch (JSONException e) {
            zzafj.zzc("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private final String zzlr() {
        try {
            return (TextUtils.isEmpty(this.zzccr.zzcbf) || !this.zzanb.zzbg(this.zzccr.zzcbf)) ? "com.google.ads.mediation.customevent.CustomEventAdapter" : "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        } catch (RemoteException e) {
            zzafj.zzco("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private final zzul zzls() {
        if (this.zzccx != 0 || !zzlu()) {
            return null;
        }
        try {
            if (!(!zzw(4) || this.zzccy == null || this.zzccy.zzlw() == 0)) {
                return this.zzccy;
            }
        } catch (RemoteException e) {
            zzafj.zzco("Could not get cpm value from MediationResponseMetadata");
        }
        return new zzts(zzlv());
    }

    /* access modifiers changed from: private */
    public final zzuf zzlt() {
        String valueOf = String.valueOf(this.zzcco);
        zzafj.zzcn(valueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(valueOf) : new String("Instantiating mediation adapter: "));
        if (!this.zzauu && !this.zzccr.zzlq()) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzblo)).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzcco)) {
                return zza((MediationAdapter) new AdMobAdapter());
            }
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzblp)).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.zzcco)) {
                return zza((MediationAdapter) new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.zzcco)) {
                return new zzuw(new zzvq());
            }
        }
        try {
            return this.zzanb.zzbf(this.zzcco);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String valueOf2 = String.valueOf(this.zzcco);
            zzafj.zza(valueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(valueOf2) : new String("Could not instantiate mediation adapter: "), remoteException);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzlu() {
        return this.zzccq.zzcce != -1;
    }

    private final int zzlv() {
        if (this.zzccr.zzcbk == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzccr.zzcbk);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzcco)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = zzw(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            zzafj.zzco("Could not convert to json. Returning 0");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzw(int i) {
        try {
            Bundle zzmb = this.zzauu ? this.zzccw.zzmb() : this.zzarg.zzbdb ? this.zzccw.getInterstitialAdapterInfo() : this.zzccw.zzma();
            return zzmb != null && (zzmb.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            zzafj.zzco("Could not get adapter info. Returning false");
            return false;
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            try {
                if (this.zzccw != null) {
                    this.zzccw.destroy();
                }
            } catch (RemoteException e) {
                zzafj.zzc("Could not destroy mediation adapter.", e);
            }
            this.zzccx = -1;
            this.mLock.notify();
        }
    }

    public final zztt zza(long j, long j2) {
        zztt zztt;
        synchronized (this.mLock) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zztp zztp = new zztp();
            zzagr.zzczc.post(new zztr(this, zztp));
            long j3 = this.zzccp;
            while (this.zzccx == -2) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j4 = j3 - (elapsedRealtime2 - elapsedRealtime);
                long j5 = j2 - (elapsedRealtime2 - j);
                if (j4 <= 0 || j5 <= 0) {
                    zzafj.zzcn("Timed out waiting for adapter.");
                    this.zzccx = 3;
                } else {
                    try {
                        this.mLock.wait(Math.min(j4, j5));
                    } catch (InterruptedException e) {
                        this.zzccx = 5;
                    }
                }
            }
            zztt = new zztt(this.zzccr, this.zzccw, this.zzcco, zztp, this.zzccx, zzls(), zzbs.zzei().elapsedRealtime() - elapsedRealtime);
        }
        return zztt;
    }

    public final void zza(int i, zzul zzul) {
        synchronized (this.mLock) {
            this.zzccx = 0;
            this.zzccy = zzul;
            this.mLock.notify();
        }
    }

    public final void zzv(int i) {
        synchronized (this.mLock) {
            this.zzccx = i;
            this.mLock.notify();
        }
    }
}
