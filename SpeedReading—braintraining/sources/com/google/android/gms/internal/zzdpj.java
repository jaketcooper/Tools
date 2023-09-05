package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzdpj {
    private static final Logger logger = Logger.getLogger(zzdpj.class.getName());

    static {
        try {
            zzdpb.zzblj();
            zzdpp.zzblj();
        } catch (GeneralSecurityException e) {
            Logger logger2 = logger;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(e);
            logger2.logp(level, "com.google.crypto.tink.hybrid.HybridEncryptFactory", "<clinit>", new StringBuilder(String.valueOf(valueOf).length() + 30).append("cannot register key managers: ").append(valueOf).toString());
        }
    }

    public static zzdor zza(zzdot zzdot) throws GeneralSecurityException {
        return new zzdpk(zzdpa.zzlqa.zza(zzdot, (zzdos) null));
    }
}
