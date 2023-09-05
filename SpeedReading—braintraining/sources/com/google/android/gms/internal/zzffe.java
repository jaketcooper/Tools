package com.google.android.gms.internal;

import java.io.IOException;

public class zzffe extends IOException {
    private zzffq zzpdi = null;

    public zzffe(String str) {
        super(str);
    }

    static zzffe zzcvs() {
        return new zzffe("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzffe zzcvt() {
        return new zzffe("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzffe zzcvu() {
        return new zzffe("CodedInputStream encountered a malformed varint.");
    }

    static zzffe zzcvv() {
        return new zzffe("Protocol message contained an invalid tag (zero).");
    }

    static zzffe zzcvw() {
        return new zzffe("Protocol message end-group tag did not match expected tag.");
    }

    static zzfff zzcvx() {
        return new zzfff("Protocol message tag had invalid wire type.");
    }

    static zzffe zzcvy() {
        return new zzffe("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzffe zzcvz() {
        return new zzffe("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzffe zzcwa() {
        return new zzffe("Protocol message had invalid UTF-8.");
    }

    public final zzffe zzh(zzffq zzffq) {
        this.zzpdi = zzffq;
        return this;
    }
}
