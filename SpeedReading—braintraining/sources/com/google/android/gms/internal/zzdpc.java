package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrk;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzdpc implements zzdos<zzdoo> {
    private static final Logger logger = Logger.getLogger(zzdpc.class.getName());

    static {
        try {
            zzdpa.zzlqa.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", new zzdpd());
            zzdpp.zzblj();
        } catch (GeneralSecurityException e) {
            Logger logger2 = logger;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(e);
            logger2.logp(level, "com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager", "<clinit>", new StringBuilder(String.valueOf(valueOf).length() + 30).append("cannot register key managers: ").append(valueOf).toString());
        }
    }

    zzdpc() {
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzdoo zza(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            zzdpq zzh = zzdpq.zzh(zzfdp);
            if (!(zzh instanceof zzdpq)) {
                throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
            }
            zzdpq zzdpq = zzh;
            zzdte.zzt(zzdpq.getVersion(), 0);
            return new zzdsq((zzdtb) zzdpa.zzlqa.zzb("type.googleapis.com/google.crypto.tink.AesCtrKey", zzdpq.zzblm()), (zzdou) zzdpa.zzlqa.zzb("type.googleapis.com/google.crypto.tink.HmacKey", zzdpq.zzbln()), zzdpq.zzbln().zzbnj().zzbnq());
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* synthetic */ Object zza(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdpq)) {
            throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
        }
        zzdpq zzdpq = (zzdpq) zzffq;
        zzdte.zzt(zzdpq.getVersion(), 0);
        return new zzdsq((zzdtb) zzdpa.zzlqa.zzb("type.googleapis.com/google.crypto.tink.AesCtrKey", zzdpq.zzblm()), (zzdou) zzdpa.zzlqa.zzb("type.googleapis.com/google.crypto.tink.HmacKey", zzdpq.zzbln()), zzdpq.zzbln().zzbnj().zzbnq());
    }

    public final zzffq zzb(zzfdp zzfdp) throws GeneralSecurityException {
        try {
            return zzb((zzffq) zzdps.zzi(zzfdp));
        } catch (zzffe e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    public final zzffq zzb(zzffq zzffq) throws GeneralSecurityException {
        if (!(zzffq instanceof zzdps)) {
            throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
        }
        zzdps zzdps = (zzdps) zzffq;
        return zzdpq.zzblo().zzb((zzdpu) zzdpa.zzlqa.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", (zzffq) zzdps.zzblq())).zzb((zzdre) zzdpa.zzlqa.zza("type.googleapis.com/google.crypto.tink.HmacKey", (zzffq) zzdps.zzblr())).zzfj(0).zzcvl();
    }

    public final zzdrk zzc(zzfdp zzfdp) throws GeneralSecurityException {
        return (zzdrk) zzdrk.zzbnw().zzob("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").zzaa(((zzdpq) zzb(zzfdp)).toByteString()).zzb(zzdrk.zzb.SYMMETRIC).zzcvl();
    }
}
