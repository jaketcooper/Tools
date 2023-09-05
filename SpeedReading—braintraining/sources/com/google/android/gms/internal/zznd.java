package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzzb
public final class zznd {
    private final Object mLock = new Object();
    private boolean zzbqe;
    private final List<zznb> zzbqv = new LinkedList();
    private final Map<String, String> zzbqw = new LinkedHashMap();
    private String zzbqx;
    @Nullable
    private zznd zzbqy;

    public zznd(boolean z, String str, String str2) {
        this.zzbqe = z;
        this.zzbqw.put("action", str);
        this.zzbqw.put("ad_format", str2);
    }

    public final boolean zza(zznb zznb, long j, String... strArr) {
        synchronized (this.mLock) {
            for (String zznb2 : strArr) {
                this.zzbqv.add(new zznb(j, zznb2, zznb));
            }
        }
        return true;
    }

    public final boolean zza(@Nullable zznb zznb, String... strArr) {
        if (!this.zzbqe || zznb == null) {
            return false;
        }
        return zza(zznb, zzbs.zzei().elapsedRealtime(), strArr);
    }

    public final void zzan(String str) {
        if (this.zzbqe) {
            synchronized (this.mLock) {
                this.zzbqx = str;
            }
        }
    }

    @Nullable
    public final zznb zzc(long j) {
        if (!this.zzbqe) {
            return null;
        }
        return new zznb(j, (String) null, (zznb) null);
    }

    public final void zzc(@Nullable zznd zznd) {
        synchronized (this.mLock) {
            this.zzbqy = zznd;
        }
    }

    public final void zzf(String str, String str2) {
        zzmt zzow;
        if (this.zzbqe && !TextUtils.isEmpty(str2) && (zzow = zzbs.zzeg().zzow()) != null) {
            synchronized (this.mLock) {
                zzmx zzal = zzow.zzal(str);
                Map<String, String> map = this.zzbqw;
                map.put(str, zzal.zze(map.get(str), str2));
            }
        }
    }

    public final zznb zziz() {
        return zzc(zzbs.zzei().elapsedRealtime());
    }

    public final String zzja() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.mLock) {
            for (zznb next : this.zzbqv) {
                long time = next.getTime();
                String zziw = next.zziw();
                zznb zzix = next.zzix();
                if (zzix != null && time > 0) {
                    sb2.append(zziw).append('.').append(time - zzix.getTime()).append(',');
                }
            }
            this.zzbqv.clear();
            if (!TextUtils.isEmpty(this.zzbqx)) {
                sb2.append(this.zzbqx);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzjb() {
        Map<String, String> zza;
        synchronized (this.mLock) {
            zzmt zzow = zzbs.zzeg().zzow();
            zza = (zzow == null || this.zzbqy == null) ? this.zzbqw : zzow.zza(this.zzbqw, this.zzbqy.zzjb());
        }
        return zza;
    }

    public final zznb zzjc() {
        synchronized (this.mLock) {
        }
        return null;
    }
}
