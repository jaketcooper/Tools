package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdss;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public class zzdsr<T_WRAPPER extends zzdss<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzdsr.class.getName());
    private static final List<Provider> zzlvt;
    public static final zzdsr<zzdst, Cipher> zzlvu = new zzdsr<>(new zzdst());
    public static final zzdsr<zzdsx, Mac> zzlvv = new zzdsr<>(new zzdsx());
    private static zzdsr<zzdsz, Signature> zzlvw = new zzdsr<>(new zzdsz());
    private static zzdsr<zzdsy, MessageDigest> zzlvx = new zzdsr<>(new zzdsy());
    public static final zzdsr<zzdsu, KeyAgreement> zzlvy = new zzdsr<>(new zzdsu());
    public static final zzdsr<zzdsw, KeyPairGenerator> zzlvz = new zzdsr<>(new zzdsw());
    private static zzdsr<zzdsv, KeyFactory> zzlwa = new zzdsr<>(new zzdsv());
    private T_WRAPPER zzlwb;
    private List<Provider> zzlwc = zzlvt;
    private boolean zzlwd = true;

    static {
        if (zzdte.zzaiz()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzlvt = arrayList;
        } else {
            zzlvt = new ArrayList();
        }
    }

    private zzdsr(T_WRAPPER t_wrapper) {
        this.zzlwb = t_wrapper;
    }

    private final boolean zza(String str, Provider provider) {
        try {
            this.zzlwb.zzb(str, provider);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final T_ENGINE zzod(String str) throws GeneralSecurityException {
        for (Provider next : this.zzlwc) {
            if (zza(str, next)) {
                return this.zzlwb.zzb(str, next);
            }
        }
        if (this.zzlwd) {
            return this.zzlwb.zzb(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }
}
