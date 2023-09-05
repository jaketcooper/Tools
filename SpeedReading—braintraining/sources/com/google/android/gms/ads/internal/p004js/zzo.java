package com.google.android.gms.ads.internal.p004js;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagr;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzzb;

@zzzb
/* renamed from: com.google.android.gms.ads.internal.js.zzo */
public final class zzo {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Object mLock;
    /* access modifiers changed from: private */
    public final zzaiy zzaov;
    /* access modifiers changed from: private */
    public final String zzbzj;
    /* access modifiers changed from: private */
    public zzaht<zzc> zzbzk;
    private zzaht<zzc> zzbzl;
    /* access modifiers changed from: private */
    @Nullable
    public zzaf zzbzm;
    /* access modifiers changed from: private */
    public int zzbzn;

    public zzo(Context context, zzaiy zzaiy, String str) {
        this.mLock = new Object();
        this.zzbzn = 1;
        this.zzbzj = str;
        this.mContext = context.getApplicationContext();
        this.zzaov = zzaiy;
        this.zzbzk = new zzaa();
        this.zzbzl = new zzaa();
    }

    public zzo(Context context, zzaiy zzaiy, String str, zzaht<zzc> zzaht, zzaht<zzc> zzaht2) {
        this(context, zzaiy, str);
        this.zzbzk = zzaht;
        this.zzbzl = zzaht2;
    }

    /* access modifiers changed from: protected */
    public final zzaf zza(@Nullable zzcs zzcs) {
        zzaf zzaf = new zzaf(this.zzbzl);
        zzbs.zzec();
        zzagr.runOnUiThread(new zzp(this, zzcs, zzaf));
        zzaf.zza(new zzx(this, zzaf), new zzy(this, zzaf));
        return zzaf;
    }

    public final zzab zzb(@Nullable zzcs zzcs) {
        zzab zzab;
        synchronized (this.mLock) {
            if (this.zzbzm == null || this.zzbzm.getStatus() == -1) {
                this.zzbzn = 2;
                this.zzbzm = zza((zzcs) null);
                zzab = this.zzbzm.zzlj();
            } else if (this.zzbzn == 0) {
                zzab = this.zzbzm.zzlj();
            } else if (this.zzbzn == 1) {
                this.zzbzn = 2;
                zza((zzcs) null);
                zzab = this.zzbzm.zzlj();
            } else {
                zzab = this.zzbzn == 2 ? this.zzbzm.zzlj() : this.zzbzm.zzlj();
            }
        }
        return zzab;
    }
}
