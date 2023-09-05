package com.google.android.gms.internal;

final class zzfgw extends IllegalArgumentException {
    zzfgw(int i, int i2) {
        super(new StringBuilder(54).append("Unpaired surrogate at index ").append(i).append(" of ").append(i2).toString());
    }
}
