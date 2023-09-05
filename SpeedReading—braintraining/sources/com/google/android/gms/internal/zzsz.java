package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzsz {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zzsy<JSONObject> zzcam = new zztb();
    private static zzsw<InputStream> zzcan = zzta.zzcao;

    static final /* synthetic */ InputStream zzg(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
