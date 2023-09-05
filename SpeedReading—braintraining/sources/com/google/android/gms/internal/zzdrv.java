package com.google.android.gms.internal;

public enum zzdrv implements zzffa {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    private static final zzffb<zzdrv> zzbbb = null;
    private final int value;

    static {
        zzbbb = new zzdrw();
    }

    private zzdrv(int i) {
        this.value = i;
    }

    public static zzdrv zzfy(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PREFIX;
            case 1:
                return TINK;
            case 2:
                return LEGACY;
            case 3:
                return RAW;
            case 4:
                return CRUNCHY;
            default:
                return null;
        }
    }

    public final int zzhn() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
