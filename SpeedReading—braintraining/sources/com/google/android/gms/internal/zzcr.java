package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzcr extends zzcq {
    private zzcr(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzcr zza(String str, Context context, boolean z) {
        zza(context, z);
        return new zzcr(context, str, z);
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zza(zzda zzda, zzaw zzaw, zzat zzat) {
        if (zzda.zzae() == null || !this.zzahk) {
            return super.zza(zzda, zzaw, zzat);
        }
        int zzaa = zzda.zzaa();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzda, zzaw, zzat));
        arrayList.add(new zzdn(zzda, "nq+dK1ZBazPeiOwzPjxFVi/DAdimINGjjC3dmnjHFWeFHhcvKyvaGTwBjbCXbYjP", "sZx5dM9LN5T6tOU5PFWOx9ynOF1nN101RoY1lhhzYQc=", zzaw, zzaa, 24));
        return arrayList;
    }
}
