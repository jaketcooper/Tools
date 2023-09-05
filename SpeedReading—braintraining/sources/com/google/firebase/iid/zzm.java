package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.stats.zza;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class zzm implements ServiceConnection {
    int state;
    final Messenger zznuy;
    zzr zznuz;
    final Queue<zzt<?>> zznva;
    final SparseArray<zzt<?>> zznvb;
    final /* synthetic */ zzk zznvc;

    private zzm(zzk zzk) {
        this.zznvc = zzk;
        this.state = 0;
        this.zznuy = new Messenger(new Handler(Looper.getMainLooper(), new zzn(this)));
        this.zznva = new LinkedList();
        this.zznvb = new SparseArray<>();
    }

    private final void zza(zzu zzu) {
        for (zzt zzb : this.zznva) {
            zzb.zzb(zzu);
        }
        this.zznva.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zznvb.size()) {
                this.zznvb.valueAt(i2).zzb(zzu);
                i = i2 + 1;
            } else {
                this.zznvb.clear();
                return;
            }
        }
    }

    private final void zzchi() {
        this.zznvc.zznuv.execute(new zzp(this));
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zzm(0, "Null service connection");
        } else {
            try {
                this.zznuz = new zzr(iBinder);
                this.state = 2;
                zzchi();
            } catch (RemoteException e) {
                zzm(0, e.getMessage());
            }
        }
        return;
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zzm(2, "Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzb(zzt zzt) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            switch (this.state) {
                case 0:
                    this.zznva.add(zzt);
                    if (this.state == 0) {
                        z = true;
                    }
                    zzbq.checkState(z);
                    if (Log.isLoggable("MessengerIpcClient", 2)) {
                        Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                    }
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (zza.zzalr().zza(this.zznvc.zzaif, intent, this, 1)) {
                        this.zznvc.zznuv.schedule(new zzo(this), 30, TimeUnit.SECONDS);
                        break;
                    } else {
                        zzm(0, "Unable to bind to service");
                        break;
                    }
                case 1:
                    this.zznva.add(zzt);
                    break;
                case 2:
                    this.zznva.add(zzt);
                    zzchi();
                    break;
                case 3:
                case 4:
                    z2 = false;
                    break;
                default:
                    throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzchj() {
        if (this.state == 2 && this.zznva.isEmpty() && this.zznvb.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            zza.zzalr();
            this.zznvc.zzaif.unbindService(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzchk() {
        if (this.state == 1) {
            zzm(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzd(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", new StringBuilder(41).append("Received response to request: ").append(i).toString());
        }
        synchronized (this) {
            zzt zzt = this.zznvb.get(i);
            if (zzt == null) {
                Log.w("MessengerIpcClient", new StringBuilder(50).append("Received response for unknown request: ").append(i).toString());
            } else {
                this.zznvb.remove(i);
                zzchj();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzt.zzb(new zzu(4, "Not supported by GmsCore"));
                } else {
                    zzt.zzad(data);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzhu(int i) {
        zzt zzt = this.zznvb.get(i);
        if (zzt != null) {
            Log.w("MessengerIpcClient", new StringBuilder(31).append("Timing out request: ").append(i).toString());
            this.zznvb.remove(i);
            zzt.zzb(new zzu(3, "Timed out waiting for response"));
            zzchj();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzm(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        switch (this.state) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.state = 4;
                zza.zzalr();
                this.zznvc.zzaif.unbindService(this);
                zza(new zzu(i, str));
                break;
            case 3:
                this.state = 4;
                break;
            case 4:
                break;
            default:
                throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
        }
    }
}
