package com.google.android.gms.internal;

import android.support.p000v4.util.SimpleArrayMap;
import android.view.View;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzyj implements zzxx<zznw> {
    private final boolean zzcjy;

    public zzyj(boolean z) {
        this.zzcjy = z;
    }

    private static <K, V> SimpleArrayMap<K, V> zza(SimpleArrayMap<K, Future<V>> simpleArrayMap) throws InterruptedException, ExecutionException {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= simpleArrayMap.size()) {
                return simpleArrayMap2;
            }
            simpleArrayMap2.put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2).get());
            i = i2 + 1;
        }
    }

    public final /* synthetic */ zzoc zza(zzxr zzxr, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        View view;
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        zzajp<zznp> zzh = zzxr.zzh(jSONObject);
        zzajp<zzama> zzc = zzxr.zzc(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                simpleArrayMap2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if ("image".equals(string)) {
                simpleArrayMap.put(jSONObject2.getString("name"), zzxr.zza(jSONObject2, "image_value", this.zzcjy));
            } else {
                String valueOf = String.valueOf(string);
                zzafj.zzco(valueOf.length() != 0 ? "Unknown custom asset type: ".concat(valueOf) : new String("Unknown custom asset type: "));
            }
        }
        zzama zzb = zzxr.zzb(zzc);
        String string2 = jSONObject.getString("custom_template_id");
        SimpleArrayMap zza = zza(simpleArrayMap);
        zznp zznp = (zznp) zzh.get();
        zzamr zzrx = zzb != null ? zzb.zzrx() : null;
        if (zzb == null) {
            view = null;
        } else if (zzb == null) {
            throw null;
        } else {
            view = (View) zzb;
        }
        return new zznw(string2, zza, simpleArrayMap2, zznp, zzrx, view);
    }
}
