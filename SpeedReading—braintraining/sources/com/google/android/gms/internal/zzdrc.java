package com.google.android.gms.internal;

public enum zzdrc implements zzffa {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA224(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    private static final zzffb<zzdrc> zzbbb = null;
    private final int value;

    static {
        zzbbb = new zzdrd();
    }

    private zzdrc(int i) {
        this.value = i;
    }

    public static zzdrc zzfq(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
                return SHA224;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
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
