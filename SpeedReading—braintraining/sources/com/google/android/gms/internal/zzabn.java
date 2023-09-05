package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.gmsg.zzt;

@zzzb
public final class zzabn {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    /* access modifiers changed from: private */
    public String zzcqb;
    /* access modifiers changed from: private */
    public String zzcqc;
    /* access modifiers changed from: private */
    public zzajy<zzabt> zzcqd = new zzajy<>();
    private zzt<Object> zzcqe = new zzabo(this);
    private zzt<Object> zzcqf = new zzabp(this);
    private zzt<Object> zzcqg = new zzabq(this);

    public zzabn(Context context, String str, String str2) {
        this.mContext = context;
        this.zzcqc = str2;
        this.zzcqb = str;
    }
}
