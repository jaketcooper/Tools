package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfem;
import com.google.android.gms.internal.zzfen;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class zzfem<MessageType extends zzfem<MessageType, BuilderType>, BuilderType extends zzfen<MessageType, BuilderType>> extends zzfdh<MessageType, BuilderType> {
    protected zzfgq zzpcg = zzfgq.zzcwv();
    protected int zzpch = -1;

    protected static <T extends zzfem<T, ?>> T zza(T t, zzfdp zzfdp) throws zzffe {
        boolean z = true;
        T zza = zza(t, zzfdp, zzfei.zzcva());
        if (zza != null) {
            if (!(zza.zza(zzfeu.zzpcq, (Object) Boolean.TRUE, (Object) null) != null)) {
                throw new zzfgp(zza).zzcwu().zzh(zza);
            }
        }
        if (zza != null) {
            if (zza.zza(zzfeu.zzpcq, (Object) Boolean.TRUE, (Object) null) == null) {
                z = false;
            }
            if (!z) {
                throw new zzfgp(zza).zzcwu().zzh(zza);
            }
        }
        return zza;
    }

    private static <T extends zzfem<T, ?>> T zza(T t, zzfdp zzfdp, zzfei zzfei) throws zzffe {
        T zza;
        try {
            zzfdy zzctm = zzfdp.zzctm();
            zza = zza(t, zzctm, zzfei);
            zzctm.zzkg(0);
            return zza;
        } catch (zzffe e) {
            throw e.zzh(zza);
        } catch (zzffe e2) {
            throw e2;
        }
    }

    static <T extends zzfem<T, ?>> T zza(T t, zzfdy zzfdy, zzfei zzfei) throws zzffe {
        T t2 = (zzfem) t.zza(zzfeu.zzpcu, (Object) null, (Object) null);
        try {
            t2.zza(zzfeu.zzpcs, (Object) zzfdy, (Object) zzfei);
            t2.zza(zzfeu.zzpct, (Object) null, (Object) null);
            t2.zzpcg.zzbin();
            return t2;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof zzffe) {
                throw ((zzffe) e.getCause());
            }
            throw e;
        }
    }

    protected static <T extends zzfem<T, ?>> T zza(T t, byte[] bArr) throws zzffe {
        T zza = zza(t, bArr, zzfei.zzcva());
        if (zza != null) {
            if (!(zza.zza(zzfeu.zzpcq, (Object) Boolean.TRUE, (Object) null) != null)) {
                throw new zzfgp(zza).zzcwu().zzh(zza);
            }
        }
        return zza;
    }

    private static <T extends zzfem<T, ?>> T zza(T t, byte[] bArr, zzfei zzfei) throws zzffe {
        T zza;
        try {
            zzfdy zzba = zzfdy.zzba(bArr);
            zza = zza(t, zzba, zzfei);
            zzba.zzkg(0);
            return zza;
        } catch (zzffe e) {
            throw e.zzh(zza);
        } catch (zzffe e2) {
            throw e2;
        }
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static zzffc zzcvf() {
        return zzfey.zzcvr();
    }

    protected static <E> zzffd<E> zzcvg() {
        return zzffw.zzcwg();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzfem) zza(zzfeu.zzpcw, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        try {
            zzfep zzfep = zzfep.zzpcl;
            zzfem zzfem = (zzfem) obj;
            zza(zzfeu.zzpcr, (Object) zzfep, (Object) zzfem);
            this.zzpcg = zzfep.zza(this.zzpcg, zzfem.zzpcg);
            return true;
        } catch (zzfeq e) {
            return false;
        }
    }

    public int hashCode() {
        if (this.zzpat != 0) {
            return this.zzpat;
        }
        zzfes zzfes = new zzfes();
        zza(zzfeu.zzpcr, (Object) zzfes, (Object) this);
        this.zzpcg = zzfes.zza(this.zzpcg, this.zzpcg);
        this.zzpat = zzfes.zzpco;
        return this.zzpat;
    }

    public final boolean isInitialized() {
        return zza(zzfeu.zzpcq, (Object) Boolean.TRUE, (Object) null) != null;
    }

    public String toString() {
        return zzfft.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* access modifiers changed from: protected */
    public final boolean zza(int i, zzfdy zzfdy) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        if (this.zzpcg == zzfgq.zzcwv()) {
            this.zzpcg = zzfgq.zzcww();
        }
        return this.zzpcg.zzb(i, zzfdy);
    }

    public final zzffu<MessageType> zzcve() {
        return (zzffu) zza(zzfeu.zzpcx, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzffr zzcvh() {
        zzfen zzfen = (zzfen) zza(zzfeu.zzpcv, (Object) null, (Object) null);
        zzfen.zza(this);
        return zzfen;
    }

    public final /* synthetic */ zzffq zzcvi() {
        return (zzfem) zza(zzfeu.zzpcw, (Object) null, (Object) null);
    }
}
