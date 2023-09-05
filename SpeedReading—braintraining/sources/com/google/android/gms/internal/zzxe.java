package com.google.android.gms.internal;

public final class zzxe extends Exception {
    private final int mErrorCode;

    public zzxe(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }
}
