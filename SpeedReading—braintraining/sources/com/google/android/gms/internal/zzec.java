package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzec implements Callable {
    private String TAG = getClass().getSimpleName();
    private String className;
    protected final zzda zzagk;
    protected final zzaw zzajo;
    private String zzajv;
    protected Method zzajx;
    private int zzakb;
    private int zzakc;

    public zzec(zzda zzda, String str, String str2, zzaw zzaw, int i, int i2) {
        this.zzagk = zzda;
        this.className = str;
        this.zzajv = str2;
        this.zzajo = zzaw;
        this.zzakb = i;
        this.zzakc = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzat() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzav */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            this.zzajx = this.zzagk.zza(this.className, this.zzajv);
            if (this.zzajx != null) {
                zzat();
                zzcm zzaj = this.zzagk.zzaj();
                if (!(zzaj == null || this.zzakb == Integer.MIN_VALUE)) {
                    zzaj.zza(this.zzakc, this.zzakb, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
        return null;
    }
}
