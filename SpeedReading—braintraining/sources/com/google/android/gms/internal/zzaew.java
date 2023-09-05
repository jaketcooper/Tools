package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzzb
public final class zzaew {
    private final Object mLock;
    private final zzaez zzasa;
    private boolean zzcqq;
    private final LinkedList<zzaex> zzcwf;
    private final String zzcwg;
    private final String zzcwh;
    private long zzcwi;
    private long zzcwj;
    private long zzcwk;
    private long zzcwl;
    private long zzcwm;
    private long zzcwn;

    private zzaew(zzaez zzaez, String str, String str2) {
        this.mLock = new Object();
        this.zzcwi = -1;
        this.zzcwj = -1;
        this.zzcqq = false;
        this.zzcwk = -1;
        this.zzcwl = 0;
        this.zzcwm = -1;
        this.zzcwn = -1;
        this.zzasa = zzaez;
        this.zzcwg = str;
        this.zzcwh = str2;
        this.zzcwf = new LinkedList<>();
    }

    public zzaew(String str, String str2) {
        this(zzbs.zzeg(), str, str2);
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzcwg);
            bundle.putString("slotid", this.zzcwh);
            bundle.putBoolean("ismediation", this.zzcqq);
            bundle.putLong("treq", this.zzcwm);
            bundle.putLong("tresponse", this.zzcwn);
            bundle.putLong("timp", this.zzcwj);
            bundle.putLong("tload", this.zzcwk);
            bundle.putLong("pcc", this.zzcwl);
            bundle.putLong("tfetch", this.zzcwi);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzcwf.iterator();
            while (it.hasNext()) {
                arrayList.add(((zzaex) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final void zzg(long j) {
        synchronized (this.mLock) {
            this.zzcwn = j;
            if (this.zzcwn != -1) {
                this.zzasa.zza(this);
            }
        }
    }

    public final void zzh(long j) {
        synchronized (this.mLock) {
            if (this.zzcwn != -1) {
                this.zzcwi = j;
                this.zzasa.zza(this);
            }
        }
    }

    public final void zzo(zzis zzis) {
        synchronized (this.mLock) {
            this.zzcwm = SystemClock.elapsedRealtime();
            this.zzasa.zzov().zzb(zzis, this.zzcwm);
        }
    }

    public final void zzoi() {
        synchronized (this.mLock) {
            if (this.zzcwn != -1 && this.zzcwj == -1) {
                this.zzcwj = SystemClock.elapsedRealtime();
                this.zzasa.zza(this);
            }
            this.zzasa.zzov().zzoi();
        }
    }

    public final void zzoj() {
        synchronized (this.mLock) {
            if (this.zzcwn != -1) {
                zzaex zzaex = new zzaex();
                zzaex.zzon();
                this.zzcwf.add(zzaex);
                this.zzcwl++;
                this.zzasa.zzov().zzoj();
                this.zzasa.zza(this);
            }
        }
    }

    public final void zzok() {
        synchronized (this.mLock) {
            if (this.zzcwn != -1 && !this.zzcwf.isEmpty()) {
                zzaex last = this.zzcwf.getLast();
                if (last.zzol() == -1) {
                    last.zzom();
                    this.zzasa.zza(this);
                }
            }
        }
    }

    public final void zzv(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcwn != -1) {
                this.zzcwk = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzcwj = this.zzcwk;
                    this.zzasa.zza(this);
                }
            }
        }
    }

    public final void zzw(boolean z) {
        synchronized (this.mLock) {
            if (this.zzcwn != -1) {
                this.zzcqq = z;
                this.zzasa.zza(this);
            }
        }
    }
}
