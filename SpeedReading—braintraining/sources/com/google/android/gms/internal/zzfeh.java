package com.google.android.gms.internal;

final class zzfeh {
    private static Class<?> zzpbw = zzcux();

    private static Class<?> zzcux() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzfei zzcuy() {
        if (zzpbw != null) {
            try {
                return zztf("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzfei.zzpbz;
    }

    private static final zzfei zztf(String str) throws Exception {
        return (zzfei) zzpbw.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
