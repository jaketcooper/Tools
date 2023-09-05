package com.google.android.gms.internal;

import com.github.mikephil.charting.utils.Utils;

public enum zzfhe {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(Utils.DOUBLE_EPSILON)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzfdp.zzpaz),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzphd;

    private zzfhe(Object obj) {
        this.zzphd = obj;
    }
}
