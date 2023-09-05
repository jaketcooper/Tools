package com.google.android.gms.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class zzdn extends zzec {
    public zzdn(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        super(zzda, str, str2, zzaw, i, 24);
    }

    private final void zzaw() {
        AdvertisingIdClient zzaq = this.zzagk.zzaq();
        if (zzaq != null) {
            try {
                AdvertisingIdClient.Info info = zzaq.getInfo();
                String zzm = zzdf.zzm(info.getId());
                if (zzm != null) {
                    synchronized (this.zzajo) {
                        this.zzajo.zzew = zzm;
                        this.zzajo.zzey = Boolean.valueOf(info.isLimitAdTrackingEnabled());
                        this.zzajo.zzex = 5;
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    public final /* synthetic */ Object call() throws Exception {
        return call();
    }

    /* access modifiers changed from: protected */
    public final void zzat() throws IllegalAccessException, InvocationTargetException {
        if (this.zzagk.zzai()) {
            zzaw();
            return;
        }
        synchronized (this.zzajo) {
            this.zzajo.zzew = (String) this.zzajx.invoke((Object) null, new Object[]{this.zzagk.getApplicationContext()});
        }
    }

    public final Void zzav() throws Exception {
        if (this.zzagk.isInitialized()) {
            return super.call();
        }
        if (this.zzagk.zzai()) {
            zzaw();
        }
        return null;
    }
}
