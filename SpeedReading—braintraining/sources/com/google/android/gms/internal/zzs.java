package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzs {
    private final AtomicInteger zzaw;
    private final Map<String, Queue<zzp<?>>> zzax;
    private final Set<zzp<?>> zzay;
    private final PriorityBlockingQueue<zzp<?>> zzaz;
    private final PriorityBlockingQueue<zzp<?>> zzba;
    private final zzl[] zzbb;
    private zzd zzbc;
    private final List<Object> zzbd;
    private final zzb zzi;
    private final zzw zzj;
    private final zzk zzx;

    public zzs(zzb zzb, zzk zzk) {
        this(zzb, zzk, 4);
    }

    private zzs(zzb zzb, zzk zzk, int i) {
        this(zzb, zzk, 4, new zzh(new Handler(Looper.getMainLooper())));
    }

    private zzs(zzb zzb, zzk zzk, int i, zzw zzw) {
        this.zzaw = new AtomicInteger();
        this.zzax = new HashMap();
        this.zzay = new HashSet();
        this.zzaz = new PriorityBlockingQueue<>();
        this.zzba = new PriorityBlockingQueue<>();
        this.zzbd = new ArrayList();
        this.zzi = zzb;
        this.zzx = zzk;
        this.zzbb = new zzl[4];
        this.zzj = zzw;
    }

    public final void start() {
        if (this.zzbc != null) {
            this.zzbc.quit();
        }
        for (zzl zzl : this.zzbb) {
            if (zzl != null) {
                zzl.quit();
            }
        }
        this.zzbc = new zzd(this.zzaz, this.zzba, this.zzi, this.zzj);
        this.zzbc.start();
        for (int i = 0; i < this.zzbb.length; i++) {
            zzl zzl2 = new zzl(this.zzba, this.zzx, this.zzi, this.zzj);
            this.zzbb[i] = zzl2;
            zzl2.start();
        }
    }

    public final <T> zzp<T> zzc(zzp<T> zzp) {
        zzp.zza(this);
        synchronized (this.zzay) {
            this.zzay.add(zzp);
        }
        zzp.zza(this.zzaw.incrementAndGet());
        zzp.zzb("add-to-queue");
        if (!zzp.zzh()) {
            this.zzba.add(zzp);
        } else {
            synchronized (this.zzax) {
                String zzd = zzp.zzd();
                if (this.zzax.containsKey(zzd)) {
                    Queue queue = this.zzax.get(zzd);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(zzp);
                    this.zzax.put(zzd, queue);
                    if (zzab.DEBUG) {
                        zzab.zza("Request for cacheKey=%s is in flight, putting on hold.", zzd);
                    }
                } else {
                    this.zzax.put(zzd, (Object) null);
                    this.zzaz.add(zzp);
                }
            }
        }
        return zzp;
    }

    /* access modifiers changed from: package-private */
    public final <T> void zzd(zzp<T> zzp) {
        synchronized (this.zzay) {
            this.zzay.remove(zzp);
        }
        synchronized (this.zzbd) {
            Iterator<Object> it = this.zzbd.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (zzp.zzh()) {
            synchronized (this.zzax) {
                String zzd = zzp.zzd();
                Queue remove = this.zzax.remove(zzd);
                if (remove != null) {
                    if (zzab.DEBUG) {
                        zzab.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zzd);
                    }
                    this.zzaz.addAll(remove);
                }
            }
        }
    }
}
