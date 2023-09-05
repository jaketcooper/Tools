package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzchl implements Callable<String> {
    private /* synthetic */ String zziju;
    private /* synthetic */ zzchj zzjdw;

    zzchl(zzchj zzchj, String str) {
        this.zzjdw = zzchj;
        this.zziju = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzcfe zziw = this.zzjdw.zzawh().zziw(this.zziju);
        if (zziw != null) {
            return zziw.getAppInstanceId();
        }
        this.zzjdw.zzawn().zzayu().log("App info was null when attempting to get app instance id");
        return null;
    }
}
