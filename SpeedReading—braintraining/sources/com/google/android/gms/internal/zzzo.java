package com.google.android.gms.internal;

@zzzb
final class zzzo extends Exception {
    private final int mErrorCode;

    public zzzo(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }
}
