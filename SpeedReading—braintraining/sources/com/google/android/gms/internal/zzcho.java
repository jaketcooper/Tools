package com.google.android.gms.internal;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class zzcho extends zzcgc {
    /* access modifiers changed from: private */
    public final zzchj zzitu;
    private Boolean zzjea;
    @Nullable
    private String zzjeb;

    public zzcho(zzchj zzchj) {
        this(zzchj, (String) null);
    }

    private zzcho(zzchj zzchj, @Nullable String str) {
        zzbq.checkNotNull(zzchj);
        this.zzitu = zzchj;
        this.zzjeb = null;
    }

    @BinderThread
    private final void zzb(zzcff zzcff, boolean z) {
        zzbq.checkNotNull(zzcff);
        zzf(zzcff.packageName, false);
        this.zzitu.zzawj().zzkb(zzcff.zzivh);
    }

    @BinderThread
    private final void zzf(String str, boolean z) {
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            this.zzitu.zzawn().zzays().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzjea == null) {
                    if ("com.google.android.gms".equals(this.zzjeb) || zzx.zzf(this.zzitu.getContext(), Binder.getCallingUid()) || zzp.zzcg(this.zzitu.getContext()).zzbr(Binder.getCallingUid())) {
                        z2 = true;
                    }
                    this.zzjea = Boolean.valueOf(z2);
                }
                if (this.zzjea.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zzitu.zzawn().zzays().zzj("Measurement Service called with invalid calling package. appId", zzcgj.zzjf(str));
                throw e;
            }
        }
        if (this.zzjeb == null && zzo.zzb(this.zzitu.getContext(), Binder.getCallingUid(), str)) {
            this.zzjeb = str;
        }
        if (!str.equals(this.zzjeb)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    @BinderThread
    public final List<zzckk> zza(zzcff zzcff, boolean z) {
        zzb(zzcff, false);
        try {
            List<zzckm> list = (List) this.zzitu.zzawm().zzc(new zzcie(this, zzcff)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzckm zzckm : list) {
                if (z || !zzckn.zzkd(zzckm.mName)) {
                    arrayList.add(new zzckk(zzckm));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzitu.zzawn().zzays().zze("Failed to get user attributes. appId", zzcgj.zzjf(zzcff.packageName), e);
            return null;
        }
    }

    @BinderThread
    public final List<zzcfi> zza(String str, String str2, zzcff zzcff) {
        zzb(zzcff, false);
        try {
            return (List) this.zzitu.zzawm().zzc(new zzchw(this, zzcff, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzitu.zzawn().zzays().zzj("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzckk> zza(String str, String str2, String str3, boolean z) {
        zzf(str, true);
        try {
            List<zzckm> list = (List) this.zzitu.zzawm().zzc(new zzchv(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzckm zzckm : list) {
                if (z || !zzckn.zzkd(zzckm.mName)) {
                    arrayList.add(new zzckk(zzckm));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzitu.zzawn().zzays().zze("Failed to get user attributes. appId", zzcgj.zzjf(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzckk> zza(String str, String str2, boolean z, zzcff zzcff) {
        zzb(zzcff, false);
        try {
            List<zzckm> list = (List) this.zzitu.zzawm().zzc(new zzchu(this, zzcff, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzckm zzckm : list) {
                if (z || !zzckn.zzkd(zzckm.mName)) {
                    arrayList.add(new zzckk(zzckm));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzitu.zzawn().zzays().zze("Failed to get user attributes. appId", zzcgj.zzjf(zzcff.packageName), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        this.zzitu.zzawm().zzg(new zzcig(this, str2, str3, str, j));
    }

    @BinderThread
    public final void zza(zzcff zzcff) {
        zzb(zzcff, false);
        zzcif zzcif = new zzcif(this, zzcff);
        if (this.zzitu.zzawm().zzazh()) {
            zzcif.run();
        } else {
            this.zzitu.zzawm().zzg(zzcif);
        }
    }

    @BinderThread
    public final void zza(zzcfi zzcfi, zzcff zzcff) {
        zzbq.checkNotNull(zzcfi);
        zzbq.checkNotNull(zzcfi.zzivv);
        zzb(zzcff, false);
        zzcfi zzcfi2 = new zzcfi(zzcfi);
        zzcfi2.packageName = zzcff.packageName;
        if (zzcfi.zzivv.getValue() == null) {
            this.zzitu.zzawm().zzg(new zzchq(this, zzcfi2, zzcff));
        } else {
            this.zzitu.zzawm().zzg(new zzchr(this, zzcfi2, zzcff));
        }
    }

    @BinderThread
    public final void zza(zzcfx zzcfx, zzcff zzcff) {
        zzbq.checkNotNull(zzcfx);
        zzb(zzcff, false);
        this.zzitu.zzawm().zzg(new zzchz(this, zzcfx, zzcff));
    }

    @BinderThread
    public final void zza(zzcfx zzcfx, String str, String str2) {
        zzbq.checkNotNull(zzcfx);
        zzbq.zzgi(str);
        zzf(str, true);
        this.zzitu.zzawm().zzg(new zzcia(this, zzcfx, str));
    }

    @BinderThread
    public final void zza(zzckk zzckk, zzcff zzcff) {
        zzbq.checkNotNull(zzckk);
        zzb(zzcff, false);
        if (zzckk.getValue() == null) {
            this.zzitu.zzawm().zzg(new zzcic(this, zzckk, zzcff));
        } else {
            this.zzitu.zzawm().zzg(new zzcid(this, zzckk, zzcff));
        }
    }

    @BinderThread
    public final byte[] zza(zzcfx zzcfx, String str) {
        zzbq.zzgi(str);
        zzbq.checkNotNull(zzcfx);
        zzf(str, true);
        this.zzitu.zzawn().zzayx().zzj("Log and bundle. event", this.zzitu.zzawi().zzjc(zzcfx.name));
        long nanoTime = this.zzitu.zzwh().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzitu.zzawm().zzd(new zzcib(this, zzcfx, str)).get();
            if (bArr == null) {
                this.zzitu.zzawn().zzays().zzj("Log and bundle returned null. appId", zzcgj.zzjf(str));
                bArr = new byte[0];
            }
            this.zzitu.zzawn().zzayx().zzd("Log and bundle processed. event, size, time_ms", this.zzitu.zzawi().zzjc(zzcfx.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzitu.zzwh().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zzitu.zzawn().zzays().zzd("Failed to log and bundle. appId, event, error", zzcgj.zzjf(str), this.zzitu.zzawi().zzjc(zzcfx.name), e);
            return null;
        }
    }

    @BinderThread
    public final void zzb(zzcff zzcff) {
        zzb(zzcff, false);
        this.zzitu.zzawm().zzg(new zzchp(this, zzcff));
    }

    @BinderThread
    public final void zzb(zzcfi zzcfi) {
        zzbq.checkNotNull(zzcfi);
        zzbq.checkNotNull(zzcfi.zzivv);
        zzf(zzcfi.packageName, true);
        zzcfi zzcfi2 = new zzcfi(zzcfi);
        if (zzcfi.zzivv.getValue() == null) {
            this.zzitu.zzawm().zzg(new zzchs(this, zzcfi2));
        } else {
            this.zzitu.zzawm().zzg(new zzcht(this, zzcfi2));
        }
    }

    @BinderThread
    public final String zzc(zzcff zzcff) {
        zzb(zzcff, false);
        return this.zzitu.zzjs(zzcff.packageName);
    }

    @BinderThread
    public final void zzd(zzcff zzcff) {
        zzf(zzcff.packageName, false);
        this.zzitu.zzawm().zzg(new zzchy(this, zzcff));
    }

    @BinderThread
    public final List<zzcfi> zzj(String str, String str2, String str3) {
        zzf(str, true);
        try {
            return (List) this.zzitu.zzawm().zzc(new zzchx(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzitu.zzawn().zzays().zzj("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }
}
