package com.google.android.gms.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzdti extends WeakReference<Throwable> {
    private final int zzlwn;

    public zzdti(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, (ReferenceQueue) null);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzlwn = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzdti zzdti = (zzdti) obj;
        return this.zzlwn == zzdti.zzlwn && get() == zzdti.get();
    }

    public final int hashCode() {
        return this.zzlwn;
    }
}
