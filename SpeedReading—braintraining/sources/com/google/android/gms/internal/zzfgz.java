package com.google.android.gms.internal;

public enum zzfgz {
    DOUBLE(zzfhe.DOUBLE, 1),
    FLOAT(zzfhe.FLOAT, 5),
    INT64(zzfhe.LONG, 0),
    UINT64(zzfhe.LONG, 0),
    INT32(zzfhe.INT, 0),
    FIXED64(zzfhe.LONG, 1),
    FIXED32(zzfhe.INT, 5),
    BOOL(zzfhe.BOOLEAN, 0),
    STRING(zzfhe.STRING, 2),
    GROUP(zzfhe.MESSAGE, 3),
    MESSAGE(zzfhe.MESSAGE, 2),
    BYTES(zzfhe.BYTE_STRING, 2),
    UINT32(zzfhe.INT, 0),
    ENUM(zzfhe.ENUM, 0),
    SFIXED32(zzfhe.INT, 5),
    SFIXED64(zzfhe.LONG, 1),
    SINT32(zzfhe.INT, 0),
    SINT64(zzfhe.LONG, 0);
    
    private final zzfhe zzpgr;
    private final int zzpgs;

    private zzfgz(zzfhe zzfhe, int i) {
        this.zzpgr = zzfhe;
        this.zzpgs = i;
    }

    public final zzfhe zzcxd() {
        return this.zzpgr;
    }

    public final int zzcxe() {
        return this.zzpgs;
    }
}
