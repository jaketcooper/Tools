package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzea {
    private static String TAG = zzea.class.getSimpleName();
    private final String className;
    private final zzda zzagk;
    private final String zzajv;
    private final int zzajw = 2;
    private volatile Method zzajx = null;
    private final Class<?>[] zzajy;
    private CountDownLatch zzajz = new CountDownLatch(1);

    public zzea(zzda zzda, String str, String str2, Class<?>... clsArr) {
        this.zzagk = zzda;
        this.className = str;
        this.zzajv = str2;
        this.zzajy = clsArr;
        this.zzagk.zzae().submit(new zzeb(this));
    }

    /* access modifiers changed from: private */
    public final void zzax() {
        try {
            Class loadClass = this.zzagk.zzaf().loadClass(zzc(this.zzagk.zzah(), this.className));
            if (loadClass != null) {
                this.zzajx = loadClass.getMethod(zzc(this.zzagk.zzah(), this.zzajv), this.zzajy);
                if (this.zzajx == null) {
                    this.zzajz.countDown();
                } else {
                    this.zzajz.countDown();
                }
            }
        } catch (zzcv e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.zzajz.countDown();
        }
    }

    private final String zzc(byte[] bArr, String str) throws zzcv, UnsupportedEncodingException {
        return new String(this.zzagk.zzag().zzb(bArr, str), "UTF-8");
    }

    public final Method zzay() {
        if (this.zzajx != null) {
            return this.zzajx;
        }
        try {
            if (this.zzajz.await(2, TimeUnit.SECONDS)) {
                return this.zzajx;
            }
            return null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
