package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.stats.zza;
import java.util.HashSet;
import java.util.Set;

final class zzaj implements ServiceConnection {
    private ComponentName mComponentName;
    private int mState = 2;
    private IBinder zzfwv;
    private final Set<ServiceConnection> zzfyg = new HashSet();
    private boolean zzfyh;
    private final zzah zzfyi;
    private /* synthetic */ zzai zzfyj;

    public zzaj(zzai zzai, zzah zzah) {
        this.zzfyj = zzai;
        this.zzfyi = zzah;
    }

    public final IBinder getBinder() {
        return this.zzfwv;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zzfyh;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzfyj.zzfyc) {
            this.zzfyj.mHandler.removeMessages(1, this.zzfyi);
            this.zzfwv = iBinder;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceConnected : this.zzfyg) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zzfyj.zzfyc) {
            this.zzfyj.mHandler.removeMessages(1, this.zzfyi);
            this.zzfwv = null;
            this.mComponentName = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzfyg) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.mState = 2;
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        zza unused = this.zzfyj.zzfyd;
        Context unused2 = this.zzfyj.mApplicationContext;
        this.zzfyi.zzala();
        this.zzfyg.add(serviceConnection);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zzfyg.contains(serviceConnection);
    }

    public final boolean zzalb() {
        return this.zzfyg.isEmpty();
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        zza unused = this.zzfyj.zzfyd;
        Context unused2 = this.zzfyj.mApplicationContext;
        this.zzfyg.remove(serviceConnection);
    }

    public final void zzge(String str) {
        this.mState = 3;
        this.zzfyh = this.zzfyj.zzfyd.zza(this.zzfyj.mApplicationContext, str, this.zzfyi.zzala(), this, this.zzfyi.zzakz());
        if (this.zzfyh) {
            this.zzfyj.mHandler.sendMessageDelayed(this.zzfyj.mHandler.obtainMessage(1, this.zzfyi), this.zzfyj.zzfyf);
            return;
        }
        this.mState = 2;
        try {
            zza unused = this.zzfyj.zzfyd;
            this.zzfyj.mApplicationContext.unbindService(this);
        } catch (IllegalArgumentException e) {
        }
    }

    public final void zzgf(String str) {
        this.zzfyj.mHandler.removeMessages(1, this.zzfyi);
        zza unused = this.zzfyj.zzfyd;
        this.zzfyj.mApplicationContext.unbindService(this);
        this.zzfyh = false;
        this.mState = 2;
    }
}
