package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzae;
import com.google.android.gms.ads.internal.p004js.zzab;
import org.json.JSONException;
import org.json.JSONObject;

final class zzti implements zzae {
    private /* synthetic */ zztf zzcay;
    private final zzab zzcaz;
    private final zzajy zzcba;

    public zzti(zztf zztf, zzab zzab, zzajy zzajy) {
        this.zzcay = zztf;
        this.zzcaz = zzab;
        this.zzcba = zzajy;
    }

    public final void zzat(String str) {
        if (str == null) {
            try {
                this.zzcba.setException(new zzst());
            } catch (IllegalStateException e) {
                this.zzcaz.release();
                return;
            } catch (Throwable th) {
                this.zzcaz.release();
                throw th;
            }
        } else {
            this.zzcba.setException(new zzst(str));
        }
        this.zzcaz.release();
    }

    public final void zze(JSONObject jSONObject) {
        try {
            this.zzcba.set(this.zzcay.zzcas.zzf(jSONObject));
        } catch (IllegalStateException e) {
        } catch (JSONException e2) {
            this.zzcba.set(e2);
        } finally {
            this.zzcaz.release();
        }
    }
}
