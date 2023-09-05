package com.google.android.gms.internal;

public enum zzdrn implements zzffa {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    private static final zzffb<zzdrn> zzbbb = null;
    private final int value;

    static {
        zzbbb = new zzdro();
    }

    private zzdrn(int i) {
        this.value = i;
    }

    public static zzdrn zzft(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_STATUS;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            case 3:
                return DESTROYED;
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
