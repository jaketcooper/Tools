package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.zzo;

public abstract class zzp<T> {
    private final String zzgud;
    private T zzgue;

    protected zzp(String str) {
        this.zzgud = str;
    }

    /* access modifiers changed from: protected */
    public final T zzdb(Context context) throws zzq {
        if (this.zzgue == null) {
            zzbq.checkNotNull(context);
            Context remoteContext = zzo.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zzq("Could not get remote context.");
            }
            try {
                this.zzgue = zze((IBinder) remoteContext.getClassLoader().loadClass(this.zzgud).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zzq("Could not load creator class.", e);
            } catch (InstantiationException e2) {
                throw new zzq("Could not instantiate creator.", e2);
            } catch (IllegalAccessException e3) {
                throw new zzq("Could not access creator.", e3);
            }
        }
        return this.zzgue;
    }

    /* access modifiers changed from: protected */
    public abstract T zze(IBinder iBinder);
}
