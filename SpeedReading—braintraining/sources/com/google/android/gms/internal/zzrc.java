package com.google.android.gms.internal;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzzb
public final class zzrc implements zzk {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    /* access modifiers changed from: private */
    @Nullable
    public zzqv zzbwy;
    /* access modifiers changed from: private */
    public boolean zzbwz;

    public zzrc(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbwy != null) {
                this.zzbwy.disconnect();
                this.zzbwy = null;
                Binder.flushPendingCommands();
            }
        }
    }

    private final Future<ParcelFileDescriptor> zzb(zzqw zzqw) {
        zzrd zzrd = new zzrd(this);
        zzre zzre = new zzre(this, zzrd, zzqw);
        zzrh zzrh = new zzrh(this, zzrd);
        synchronized (this.mLock) {
            this.zzbwy = new zzqv(this.mContext, zzbs.zzet().zzqm(), zzre, zzrh);
            this.zzbwy.zzajy();
        }
        return zzrd;
    }

    /* JADX INFO: finally extract failed */
    public final zzn zza(zzp<?> zzp) throws zzaa {
        zzn zzn;
        zzqw zze = zzqw.zze(zzp);
        long intValue = (long) ((Integer) zzbs.zzep().zzd(zzmq.zzbov)).intValue();
        long elapsedRealtime = zzbs.zzei().elapsedRealtime();
        try {
            zzqy zzqy = (zzqy) new zzaap(zzb(zze).get(intValue, TimeUnit.MILLISECONDS)).zza(zzqy.CREATOR);
            if (zzqy.zzbww) {
                throw new zzaa(zzqy.zzbwx);
            }
            if (zzqy.zzbwu.length != zzqy.zzbwv.length) {
                zzn = null;
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < zzqy.zzbwu.length; i++) {
                    hashMap.put(zzqy.zzbwu[i], zzqy.zzbwv[i]);
                }
                zzn = new zzn(zzqy.statusCode, zzqy.data, hashMap, zzqy.zzz, zzqy.zzaa);
            }
            zzafj.m11v(new StringBuilder(52).append("Http assets remote cache took ").append(zzbs.zzei().elapsedRealtime() - elapsedRealtime).append("ms").toString());
            return zzn;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzafj.m11v(new StringBuilder(52).append("Http assets remote cache took ").append(zzbs.zzei().elapsedRealtime() - elapsedRealtime).append("ms").toString());
            return null;
        } catch (Throwable th) {
            zzafj.m11v(new StringBuilder(52).append("Http assets remote cache took ").append(zzbs.zzei().elapsedRealtime() - elapsedRealtime).append("ms").toString());
            throw th;
        }
    }
}
