package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrr;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzdow<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private ConcurrentMap<String, List<zzdox<P>>> zzlpr = new ConcurrentHashMap();
    private zzdox<P> zzlps;

    /* access modifiers changed from: protected */
    public final zzdox<P> zza(P p, zzdrr.zzb zzb) throws GeneralSecurityException {
        byte[] bArr;
        switch (zzdoq.zzlpo[zzb.zzboj().ordinal()]) {
            case 1:
            case 2:
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzb.zzboi()).array();
                break;
            case 3:
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzb.zzboi()).array();
                break;
            case 4:
                bArr = zzdop.zzlpn;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        zzdox<P> zzdox = new zzdox<>(p, bArr, zzb.zzboh(), zzb.zzboj());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzdox);
        String str = new String(zzdox.zzbli(), UTF_8);
        List list = (List) this.zzlpr.put(str, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(zzdox);
            this.zzlpr.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzdox;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzdox<P> zzdox) {
        this.zzlps = zzdox;
    }

    public final zzdox<P> zzblg() {
        return this.zzlps;
    }
}
