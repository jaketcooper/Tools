package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffq;

public abstract class zzfdk<MessageType extends zzffq> implements zzffu<MessageType> {
    private static final zzfei zzpax = zzfei.zzcva();

    public final /* synthetic */ Object zzc(zzfdy zzfdy, zzfei zzfei) throws zzffe {
        zzffq zzffq = (zzffq) zze(zzfdy, zzfei);
        if (zzffq == null || zzffq.isInitialized()) {
            return zzffq;
        }
        throw (zzffq instanceof zzfdh ? new zzfgp((zzfdh) zzffq) : zzffq instanceof zzfdj ? new zzfgp((zzfdj) zzffq) : new zzfgp(zzffq)).zzcwu().zzh(zzffq);
    }
}
