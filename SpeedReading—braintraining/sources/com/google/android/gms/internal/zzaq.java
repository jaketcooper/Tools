package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzaq extends zzp<String> {
    private final zzv<String> zzcd;

    public zzaq(int i, String str, zzv<String> zzv, zzu zzu) {
        super(i, str, zzu);
        this.zzcd = zzv;
    }

    /* access modifiers changed from: protected */
    public final zzt<String> zza(zzn zzn) {
        String str;
        try {
            str = new String(zzn.data, zzal.zza(zzn.zzy));
        } catch (UnsupportedEncodingException e) {
            str = new String(zzn.data);
        }
        return zzt.zza(str, zzal.zzb(zzn));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        String str = (String) obj;
        if (this.zzcd != null) {
            this.zzcd.zzb(str);
        }
    }
}
