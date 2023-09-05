package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzmq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzbq extends AsyncTask<Void, Void, String> {
    private /* synthetic */ zzbm zzarm;

    private zzbq(zzbm zzbm) {
        this.zzarm = zzbm;
    }

    /* synthetic */ zzbq(zzbm zzbm, zzbn zzbn) {
        this(zzbm);
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        try {
            zzcs unused = this.zzarm.zzark = (zzcs) this.zzarm.zzarh.get(((Long) zzbs.zzep().zzd(zzmq.zzbnz)).longValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            zzafj.zzc("Failed to load ad data", e);
        } catch (TimeoutException e2) {
            zzafj.zzco("Timed out waiting for ad data");
        }
        return this.zzarm.zzds();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.zzarm.zzarj != null && str != null) {
            this.zzarm.zzarj.loadUrl(str);
        }
    }
}
