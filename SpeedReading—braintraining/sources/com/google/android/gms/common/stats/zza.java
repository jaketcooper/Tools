package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.zzc;
import java.util.Collections;
import java.util.List;

public final class zza {
    private static final Object zzfxy = new Object();
    private static volatile zza zzgan;
    private static boolean zzgao = false;
    private final List<String> zzgap = Collections.EMPTY_LIST;
    private final List<String> zzgaq = Collections.EMPTY_LIST;
    private final List<String> zzgar = Collections.EMPTY_LIST;
    private final List<String> zzgas = Collections.EMPTY_LIST;

    private zza() {
    }

    public static zza zzalr() {
        if (zzgan == null) {
            synchronized (zzfxy) {
                if (zzgan == null) {
                    zzgan = new zza();
                }
            }
        }
        return zzgan;
    }

    public final boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : zzc.zzz(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }
}
