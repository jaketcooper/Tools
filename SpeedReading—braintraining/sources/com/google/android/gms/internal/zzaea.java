package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;

final class zzaea implements Runnable {
    private /* synthetic */ zzady zzcut;
    private /* synthetic */ zzajp zzcuu;

    zzaea(zzady zzady, zzajp zzajp) {
        this.zzcut = zzady;
        this.zzcuu = zzajp;
    }

    public final void run() {
        Throwable th;
        try {
            this.zzcut.zzo((Map) this.zzcuu.get());
            if (this.zzcut.zzcuo) {
                synchronized (this.zzcut.mLock) {
                    this.zzcut.zzcul.zzpig = 9;
                }
            }
            this.zzcut.send();
            return;
        } catch (InterruptedException e) {
            th = e;
        } catch (ExecutionException e2) {
            th = e2;
        } catch (JSONException e3) {
            th = e3;
        }
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbog)).booleanValue()) {
            zzafj.zza("Failed to get SafeBrowsing metadata", th);
        }
    }
}
