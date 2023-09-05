package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfem;
import com.google.android.gms.internal.zzfen;
import java.io.IOException;

public class zzfen<MessageType extends zzfem<MessageType, BuilderType>, BuilderType extends zzfen<MessageType, BuilderType>> extends zzfdi<MessageType, BuilderType> {
    private final MessageType zzpci;
    protected MessageType zzpcj;
    private boolean zzpck = false;

    protected zzfen(MessageType messagetype) {
        this.zzpci = messagetype;
        this.zzpcj = (zzfem) messagetype.zza(zzfeu.zzpcu, (Object) null, (Object) null);
    }

    private static void zza(MessageType messagetype, MessageType messagetype2) {
        zzfet zzfet = zzfet.zzpcp;
        messagetype.zza(zzfeu.zzpcr, (Object) zzfet, (Object) messagetype2);
        messagetype.zzpcg = zzfet.zza(messagetype.zzpcg, messagetype2.zzpcg);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final BuilderType zzb(zzfdy zzfdy, zzfei zzfei) throws IOException {
        zzcvj();
        try {
            this.zzpcj.zza(zzfeu.zzpcs, (Object) zzfdy, (Object) zzfei);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        MessageType messagetype;
        zzfen zzfen = (zzfen) ((zzfem) this.zzpci).zza(zzfeu.zzpcv, (Object) null, (Object) null);
        if (this.zzpck) {
            messagetype = this.zzpcj;
        } else {
            MessageType messagetype2 = this.zzpcj;
            messagetype2.zza(zzfeu.zzpct, (Object) null, (Object) null);
            messagetype2.zzpcg.zzbin();
            this.zzpck = true;
            messagetype = this.zzpcj;
        }
        zzfen.zza((zzfem) messagetype);
        return zzfen;
    }

    public final boolean isInitialized() {
        return this.zzpcj.zza(zzfeu.zzpcq, (Object) false, (Object) null) != null;
    }

    public final /* synthetic */ zzfdi zza(zzfdy zzfdy, zzfei zzfei) throws IOException {
        return (zzfen) zzb(zzfdy, zzfei);
    }

    public final BuilderType zza(MessageType messagetype) {
        zzcvj();
        zza(this.zzpcj, messagetype);
        return this;
    }

    public final /* synthetic */ zzfdi zzcth() {
        return (zzfen) clone();
    }

    public final /* synthetic */ zzffq zzcvi() {
        return this.zzpci;
    }

    /* access modifiers changed from: protected */
    public final void zzcvj() {
        if (this.zzpck) {
            MessageType messagetype = (zzfem) this.zzpcj.zza(zzfeu.zzpcu, (Object) null, (Object) null);
            zza(messagetype, this.zzpcj);
            this.zzpcj = messagetype;
            this.zzpck = false;
        }
    }

    public final MessageType zzcvk() {
        if (this.zzpck) {
            return this.zzpcj;
        }
        MessageType messagetype = this.zzpcj;
        messagetype.zza(zzfeu.zzpct, (Object) null, (Object) null);
        messagetype.zzpcg.zzbin();
        this.zzpck = true;
        return this.zzpcj;
    }

    public final MessageType zzcvl() {
        MessageType messagetype;
        boolean z = true;
        if (this.zzpck) {
            messagetype = this.zzpcj;
        } else {
            MessageType messagetype2 = this.zzpcj;
            messagetype2.zza(zzfeu.zzpct, (Object) null, (Object) null);
            messagetype2.zzpcg.zzbin();
            this.zzpck = true;
            messagetype = this.zzpcj;
        }
        MessageType messagetype3 = (zzfem) messagetype;
        if (messagetype3.zza(zzfeu.zzpcq, (Object) Boolean.TRUE, (Object) null) == null) {
            z = false;
        }
        if (z) {
            return messagetype3;
        }
        throw new zzfgp(messagetype3);
    }

    public final /* synthetic */ zzffq zzcvm() {
        if (this.zzpck) {
            return this.zzpcj;
        }
        MessageType messagetype = this.zzpcj;
        messagetype.zza(zzfeu.zzpct, (Object) null, (Object) null);
        messagetype.zzpcg.zzbin();
        this.zzpck = true;
        return this.zzpcj;
    }

    public final /* synthetic */ zzffq zzcvn() {
        MessageType messagetype;
        boolean z = true;
        if (this.zzpck) {
            messagetype = this.zzpcj;
        } else {
            MessageType messagetype2 = this.zzpcj;
            messagetype2.zza(zzfeu.zzpct, (Object) null, (Object) null);
            messagetype2.zzpcg.zzbin();
            this.zzpck = true;
            messagetype = this.zzpcj;
        }
        zzfem zzfem = (zzfem) messagetype;
        if (zzfem.zza(zzfeu.zzpcq, (Object) Boolean.TRUE, (Object) null) == null) {
            z = false;
        }
        if (z) {
            return zzfem;
        }
        throw new zzfgp(zzfem);
    }
}
