package com.google.android.gms.internal;

public final class zzav {
    public static int zzd(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 1000:
                return i;
            default:
                throw new IllegalArgumentException(new StringBuilder(43).append(i).append(" is not a valid enum EnumBoolean").toString());
        }
    }
}
