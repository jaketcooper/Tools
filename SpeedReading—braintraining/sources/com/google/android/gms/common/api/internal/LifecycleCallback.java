package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    protected final zzci zzfrt;

    protected LifecycleCallback(zzci zzci) {
        this.zzfrt = zzci;
    }

    @Keep
    private static zzci getChimeraLifecycleFragmentImpl(zzch zzch) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    protected static zzci zzb(zzch zzch) {
        if (zzch.zzaiy()) {
            return zzdd.zza(zzch.zzajb());
        }
        if (zzch.zzaiz()) {
            return zzcj.zzo(zzch.zzaja());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static zzci zzn(Activity activity) {
        return zzb(new zzch(activity));
    }

    @MainThread
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Activity getActivity() {
        return this.zzfrt.zzajc();
    }

    @MainThread
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @MainThread
    public void onCreate(Bundle bundle) {
    }

    @MainThread
    public void onDestroy() {
    }

    @MainThread
    public void onResume() {
    }

    @MainThread
    public void onSaveInstanceState(Bundle bundle) {
    }

    @MainThread
    public void onStart() {
    }

    @MainThread
    public void onStop() {
    }
}
