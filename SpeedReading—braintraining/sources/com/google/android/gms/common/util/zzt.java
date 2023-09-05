package com.google.android.gms.common.util;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzbq;
import java.util.Set;

public final class zzt {
    public static String[] zza(Scope[] scopeArr) {
        zzbq.checkNotNull(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].zzagk();
        }
        return strArr;
    }

    public static String[] zzc(Set<Scope> set) {
        zzbq.checkNotNull(set, "scopes can't be null.");
        return zza((Scope[]) set.toArray(new Scope[set.size()]));
    }
}
