package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzzb
public final class zzgo {
    private final Object mLock = new Object();
    private int zzaxx;
    private List<zzgn> zzaxy = new LinkedList();

    public final boolean zza(zzgn zzgn) {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzaxy.contains(zzgn);
        }
        return z;
    }

    public final boolean zzb(zzgn zzgn) {
        synchronized (this.mLock) {
            Iterator<zzgn> it = this.zzaxy.iterator();
            while (it.hasNext()) {
                zzgn next = it.next();
                if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbig)).booleanValue() || zzbs.zzeg().zzos()) {
                    if (((Boolean) zzbs.zzep().zzd(zzmq.zzbii)).booleanValue() && !zzbs.zzeg().zzot() && zzgn != next && next.zzgj().equals(zzgn.zzgj())) {
                        it.remove();
                        return true;
                    }
                } else if (zzgn != next && next.zzgh().equals(zzgn.zzgh())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzgn zzgn) {
        synchronized (this.mLock) {
            if (this.zzaxy.size() >= 10) {
                zzafj.zzbw(new StringBuilder(41).append("Queue is full, current size = ").append(this.zzaxy.size()).toString());
                this.zzaxy.remove(0);
            }
            int i = this.zzaxx;
            this.zzaxx = i + 1;
            zzgn.zzo(i);
            this.zzaxy.add(zzgn);
        }
    }

    @Nullable
    public final zzgn zzgp() {
        int i;
        zzgn zzgn;
        int i2;
        zzgn zzgn2 = null;
        int i3 = 0;
        synchronized (this.mLock) {
            if (this.zzaxy.size() == 0) {
                zzafj.zzbw("Queue empty");
                return null;
            } else if (this.zzaxy.size() >= 2) {
                int i4 = Integer.MIN_VALUE;
                int i5 = 0;
                for (zzgn next : this.zzaxy) {
                    int score = next.getScore();
                    if (score > i4) {
                        i2 = score;
                        zzgn = next;
                        i = i5;
                    } else {
                        i = i3;
                        zzgn = zzgn2;
                        i2 = i4;
                    }
                    i5++;
                    i4 = i2;
                    zzgn2 = zzgn;
                    i3 = i;
                }
                this.zzaxy.remove(i3);
                return zzgn2;
            } else {
                zzgn zzgn3 = this.zzaxy.get(0);
                zzgn3.zzgk();
                return zzgn3;
            }
        }
    }
}
