package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfhr extends IOException {
    public zzfhr(String str) {
        super(str);
    }

    static zzfhr zzcxi() {
        return new zzfhr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfhr zzcxj() {
        return new zzfhr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfhr zzcxk() {
        return new zzfhr("CodedInputStream encountered a malformed varint.");
    }

    static zzfhr zzcxl() {
        return new zzfhr("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
