package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@zzzb
public final class zzit {
    private Bundle mExtras;
    private boolean zzals;
    private long zzbcl;
    private int zzbcm;
    private List<String> zzbcn;
    private boolean zzbco;
    private int zzbcp;
    private String zzbcq;
    private zzlw zzbcr;
    private String zzbcs;
    private Bundle zzbct;
    private Bundle zzbcu;
    private List<String> zzbcv;
    private String zzbcw;
    private String zzbcx;
    private boolean zzbcy;
    private Location zzhe;

    public zzit() {
        this.zzbcl = -1;
        this.mExtras = new Bundle();
        this.zzbcm = -1;
        this.zzbcn = new ArrayList();
        this.zzbco = false;
        this.zzbcp = -1;
        this.zzals = false;
        this.zzbcq = null;
        this.zzbcr = null;
        this.zzhe = null;
        this.zzbcs = null;
        this.zzbct = new Bundle();
        this.zzbcu = new Bundle();
        this.zzbcv = new ArrayList();
        this.zzbcw = null;
        this.zzbcx = null;
        this.zzbcy = false;
    }

    public zzit(zzis zzis) {
        this.zzbcl = zzis.zzbbv;
        this.mExtras = zzis.extras;
        this.zzbcm = zzis.zzbbw;
        this.zzbcn = zzis.zzbbx;
        this.zzbco = zzis.zzbby;
        this.zzbcp = zzis.zzbbz;
        this.zzals = zzis.zzbca;
        this.zzbcq = zzis.zzbcb;
        this.zzbcr = zzis.zzbcc;
        this.zzhe = zzis.zzbcd;
        this.zzbcs = zzis.zzbce;
        this.zzbct = zzis.zzbcf;
        this.zzbcu = zzis.zzbcg;
        this.zzbcv = zzis.zzbch;
        this.zzbcw = zzis.zzbci;
        this.zzbcx = zzis.zzbcj;
    }

    public final zzit zza(@Nullable Location location) {
        this.zzhe = null;
        return this;
    }

    public final zzis zzho() {
        return new zzis(7, this.zzbcl, this.mExtras, this.zzbcm, this.zzbcn, this.zzbco, this.zzbcp, this.zzals, this.zzbcq, this.zzbcr, this.zzhe, this.zzbcs, this.zzbct, this.zzbcu, this.zzbcv, this.zzbcw, this.zzbcx, false);
    }
}
