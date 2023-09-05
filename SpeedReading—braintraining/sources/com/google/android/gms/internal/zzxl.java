package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@zzzb
public final class zzxl extends zzxb {
    private final zznd zzamo;
    private zzuc zzanb;
    /* access modifiers changed from: private */
    public final zzama zzbwq;
    private zztn zzccq;
    private zztl zzcih;
    protected zztt zzcii;
    /* access modifiers changed from: private */
    public boolean zzcij;

    zzxl(Context context, zzaev zzaev, zzuc zzuc, zzxg zzxg, zznd zznd, zzama zzama) {
        super(context, zzaev, zzxg);
        this.zzanb = zzuc;
        this.zzccq = zzaev.zzcvs;
        this.zzamo = zznd;
        this.zzbwq = zzama;
    }

    private static String zzj(List<zztt> list) {
        int i;
        if (list == null) {
            return "".toString();
        }
        String str = "";
        for (zztt next : list) {
            if (!(next == null || next.zzcdd == null || TextUtils.isEmpty(next.zzcdd.zzcbe))) {
                String valueOf = String.valueOf(str);
                String str2 = next.zzcdd.zzcbe;
                switch (next.zzcdc) {
                    case -1:
                        i = 4;
                        break;
                    case 0:
                        i = 0;
                        break;
                    case 1:
                        i = 1;
                        break;
                    case 3:
                        i = 2;
                        break;
                    case 4:
                        i = 3;
                        break;
                    case 5:
                        i = 5;
                        break;
                    default:
                        i = 6;
                        break;
                }
                String sb = new StringBuilder(String.valueOf(str2).length() + 33).append(str2).append(".").append(i).append(".").append(next.zzcdi).toString();
                str = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(sb).length()).append(valueOf).append(sb).append("_").toString();
            }
        }
        return str.substring(0, Math.max(0, str.length() - 1));
    }

    public final void onStop() {
        synchronized (this.zzchy) {
            super.onStop();
            if (this.zzcih != null) {
                this.zzcih.cancel();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd(long j) throws zzxe {
        zztl zztz;
        Bundle bundle;
        synchronized (this.zzchy) {
            if (this.zzccq.zzcce != -1) {
                zztz = new zztw(this.mContext, this.zzchv.zzcpe, this.zzanb, this.zzccq, this.zzchw.zzbdd, this.zzchw.zzbdf, this.zzchw.zzcoa, j, ((Long) zzbs.zzep().zzd(zzmq.zzblt)).longValue(), 2, this.zzchv.zzcwd);
            } else {
                zztz = new zztz(this.mContext, this.zzchv.zzcpe, this.zzanb, this.zzccq, this.zzchw.zzbdd, this.zzchw.zzbdf, this.zzchw.zzcoa, j, ((Long) zzbs.zzep().zzd(zzmq.zzblt)).longValue(), this.zzamo, this.zzchv.zzcwd);
            }
            this.zzcih = zztz;
        }
        ArrayList arrayList = new ArrayList(this.zzccq.zzcbt);
        boolean z = false;
        Bundle bundle2 = this.zzchv.zzcpe.zzclo.zzbcf;
        if (!(bundle2 == null || (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) == null)) {
            z = bundle.getBoolean("_skipMediation");
        }
        if (z) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zztm) listIterator.next()).zzcbd.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                    listIterator.remove();
                }
            }
        }
        this.zzcii = this.zzcih.zzg(arrayList);
        switch (this.zzcii.zzcdc) {
            case 0:
                if (this.zzcii.zzcdd != null && this.zzcii.zzcdd.zzcbn != null) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    zzagr.zzczc.post(new zzxm(this, countDownLatch));
                    try {
                        countDownLatch.await(10, TimeUnit.SECONDS);
                        synchronized (this.zzchy) {
                            if (!this.zzcij) {
                                throw new zzxe("View could not be prepared", 0);
                            } else if (this.zzbwq.isDestroyed()) {
                                throw new zzxe("Assets not loaded, web view is destroyed", 0);
                            }
                        }
                        return;
                    } catch (InterruptedException e) {
                        String valueOf = String.valueOf(e);
                        throw new zzxe(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
                    }
                } else {
                    return;
                }
            case 1:
                throw new zzxe("No fill from any mediation ad networks.", 3);
            default:
                throw new zzxe(new StringBuilder(40).append("Unexpected mediation result: ").append(this.zzcii.zzcdc).toString(), 0);
        }
    }

    /* access modifiers changed from: protected */
    public final zzaeu zzy(int i) {
        zzzz zzzz = this.zzchv.zzcpe;
        return new zzaeu(zzzz.zzclo, this.zzbwq, this.zzchw.zzcbv, i, this.zzchw.zzcbw, this.zzchw.zzcni, this.zzchw.orientation, this.zzchw.zzccb, zzzz.zzclr, this.zzchw.zzcng, this.zzcii != null ? this.zzcii.zzcdd : null, this.zzcii != null ? this.zzcii.zzcde : null, this.zzcii != null ? this.zzcii.zzcdf : AdMobAdapter.class.getName(), this.zzccq, this.zzcii != null ? this.zzcii.zzcdg : null, this.zzchw.zzcnh, this.zzchv.zzath, this.zzchw.zzcnf, this.zzchv.zzcvw, this.zzchw.zzcnk, this.zzchw.zzcnl, this.zzchv.zzcvq, (zzoc) null, this.zzchw.zzcnv, this.zzchw.zzcnw, this.zzchw.zzcnx, this.zzccq != null ? this.zzccq.zzccg : false, this.zzchw.zzcnz, this.zzcih != null ? zzj(this.zzcih.zzlo()) : null, this.zzchw.zzcby, this.zzchw.zzcoc, this.zzchv.zzcwc, this.zzchw.zzapy, this.zzchv.zzcwd);
    }
}
