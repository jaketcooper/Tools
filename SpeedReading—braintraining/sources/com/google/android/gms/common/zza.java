package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zza implements ServiceConnection {
    private boolean zzfig = false;
    private final BlockingQueue<IBinder> zzfih = new LinkedBlockingQueue();

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzfih.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    public final IBinder zza(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        zzbq.zzgj("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.zzfig) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.zzfig = true;
        IBinder poll = this.zzfih.poll(10000, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public final IBinder zzafm() throws InterruptedException {
        zzbq.zzgj("BlockingServiceConnection.getService() called on main thread");
        if (this.zzfig) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.zzfig = true;
        return this.zzfih.take();
    }
}
