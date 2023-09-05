package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdpq;
import com.google.android.gms.internal.zzdpu;
import com.google.android.gms.internal.zzdqg;
import com.google.android.gms.internal.zzdre;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzdpl implements zzdsm {
    private final int zzlqd;
    private final int zzlqe;
    private zzdqg zzlqf;
    private zzdpq zzlqg;
    private int zzlqh;

    zzdpl(zzdrp zzdrp) throws GeneralSecurityException {
        String zzbnt = zzdrp.zzbnt();
        if (zzbnt.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdqi zzs = zzdqi.zzs(zzdrp.zzbnu());
                this.zzlqd = zzdpm.zzlqi;
                this.zzlqf = (zzdqg) zzdpa.zzlqa.zzb(zzdrp);
                this.zzlqe = zzs.getKeySize();
            } catch (zzffe e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zzbnt.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzdps zzi = zzdps.zzi(zzdrp.zzbnu());
                this.zzlqd = zzdpm.zzlqj;
                this.zzlqg = (zzdpq) zzdpa.zzlqa.zzb(zzdrp);
                this.zzlqh = zzi.zzblq().getKeySize();
                this.zzlqe = zzi.zzblr().getKeySize() + this.zzlqh;
            } catch (zzffe e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        } else {
            String valueOf = String.valueOf(zzbnt);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    public final zzdoo zzad(byte[] bArr) throws GeneralSecurityException {
        if (this.zzlqd == zzdpm.zzlqi) {
            return (zzdoo) zzdpa.zzlqa.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey", (zzdqg) ((zzdqg.zza) zzdqg.zzbmj().zza(this.zzlqf)).zzr(zzfdp.zzay(bArr)).zzcvl());
        } else if (this.zzlqd == zzdpm.zzlqj) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzlqh);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzlqh, this.zzlqe);
            zzdpq.zza zzb = zzdpq.zzblo().zzfj(this.zzlqg.getVersion()).zzb((zzdpu) ((zzdpu.zza) zzdpu.zzblv().zza(this.zzlqg.zzblm())).zzl(zzfdp.zzay(copyOfRange)).zzcvl());
            return (zzdoo) zzdpa.zzlqa.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", (zzdpq) zzb.zzb((zzdre) ((zzdre.zza) zzdre.zzbnk().zza(this.zzlqg.zzbln())).zzx(zzfdp.zzay(copyOfRange2)).zzcvl()).zzcvl());
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }

    public final int zzbll() {
        return this.zzlqe;
    }
}
