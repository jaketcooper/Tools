package com.google.android.gms.internal;

import java.util.List;

public final class zzfgp extends RuntimeException {
    private final List<String> zzpey = null;

    public zzfgp(zzffq zzffq) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzffe zzcwu() {
        return new zzffe(getMessage());
    }
}
