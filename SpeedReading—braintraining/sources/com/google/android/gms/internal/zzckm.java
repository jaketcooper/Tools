package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

final class zzckm {
    final String mAppId;
    final String mName;
    final String mOrigin;
    final Object mValue;
    final long zzjhb;

    zzckm(String str, String str2, String str3, long j, Object obj) {
        zzbq.zzgi(str);
        zzbq.zzgi(str3);
        zzbq.checkNotNull(obj);
        this.mAppId = str;
        this.mOrigin = str2;
        this.mName = str3;
        this.zzjhb = j;
        this.mValue = obj;
    }
}
