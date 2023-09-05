package com.google.android.gms.internal;

public enum zzdqo implements zzffa {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    UNRECOGNIZED(-1);
    
    private static final zzffb<zzdqo> zzbbb = null;
    private final int value;

    static {
        zzbbb = new zzdqp();
    }

    private zzdqo(int i) {
        this.value = i;
    }

    public static zzdqo zzfo(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return UNCOMPRESSED;
            case 2:
                return COMPRESSED;
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
