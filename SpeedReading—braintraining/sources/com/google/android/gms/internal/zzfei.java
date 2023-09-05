package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfei {
    private static volatile boolean zzpbx = false;
    private static final Class<?> zzpby = zzcuz();
    static final zzfei zzpbz = new zzfei(true);
    private final Map<Object, Object> zzpca;

    zzfei() {
        this.zzpca = new HashMap();
    }

    private zzfei(boolean z) {
        this.zzpca = Collections.emptyMap();
    }

    private static Class<?> zzcuz() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzfei zzcva() {
        return zzfeh.zzcuy();
    }
}
