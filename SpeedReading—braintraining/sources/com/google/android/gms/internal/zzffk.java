package com.google.android.gms.internal;

public class zzffk {
    private static final zzfei zzpax = zzfei.zzcva();
    private zzfdp zzpdk;
    private volatile zzffq zzpdl;
    private volatile zzfdp zzpdm;

    private zzfdp toByteString() {
        if (this.zzpdm != null) {
            return this.zzpdm;
        }
        synchronized (this) {
            if (this.zzpdm != null) {
                zzfdp zzfdp = this.zzpdm;
                return zzfdp;
            }
            if (this.zzpdl == null) {
                this.zzpdm = zzfdp.zzpaz;
            } else {
                this.zzpdm = this.zzpdl.toByteString();
            }
            zzfdp zzfdp2 = this.zzpdm;
            return zzfdp2;
        }
    }

    private zzffq zzi(zzffq zzffq) {
        if (this.zzpdl == null) {
            synchronized (this) {
                if (this.zzpdl == null) {
                    try {
                        this.zzpdl = zzffq;
                        this.zzpdm = zzfdp.zzpaz;
                    } catch (zzffe e) {
                        this.zzpdl = zzffq;
                        this.zzpdm = zzfdp.zzpaz;
                    }
                }
            }
        }
        return this.zzpdl;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzffk)) {
            return false;
        }
        zzffk zzffk = (zzffk) obj;
        zzffq zzffq = this.zzpdl;
        zzffq zzffq2 = zzffk.zzpdl;
        return (zzffq == null && zzffq2 == null) ? toByteString().equals(zzffk.toByteString()) : (zzffq == null || zzffq2 == null) ? zzffq != null ? zzffq.equals(zzffk.zzi(zzffq.zzcvi())) : zzi(zzffq2.zzcvi()).equals(zzffq2) : zzffq.equals(zzffq2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zzhl() {
        if (this.zzpdm != null) {
            return this.zzpdm.size();
        }
        if (this.zzpdl != null) {
            return this.zzpdl.zzhl();
        }
        return 0;
    }

    public final zzffq zzj(zzffq zzffq) {
        zzffq zzffq2 = this.zzpdl;
        this.zzpdk = null;
        this.zzpdm = null;
        this.zzpdl = zzffq;
        return zzffq2;
    }
}
