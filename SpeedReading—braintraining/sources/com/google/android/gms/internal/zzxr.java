package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzba;
import com.google.android.gms.ads.internal.zzbs;
import com.safonov.speedreading.training.fragment.concentration.training.model.MovementView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzxr implements Callable<zzaeu> {
    private static long zzciq = 10;
    private final Context mContext;
    private int mErrorCode;
    private final Object mLock = new Object();
    private final zznd zzamo;
    private final zzyg zzaqq;
    private final zzcs zzbta;
    private final zzaev zzchv;
    private final zzahy zzcir;
    /* access modifiers changed from: private */
    public final zzba zzcis;
    private boolean zzcit;
    private List<String> zzciu;
    private JSONObject zzciv;
    private String zzciw;

    public zzxr(Context context, zzba zzba, zzahy zzahy, zzcs zzcs, zzaev zzaev, zznd zznd) {
        this.mContext = context;
        this.zzcis = zzba;
        this.zzcir = zzahy;
        this.zzchv = zzaev;
        this.zzbta = zzcs;
        this.zzamo = zznd;
        this.zzaqq = zzba.zzdk();
        this.zzcit = false;
        this.mErrorCode = -2;
        this.zzciu = null;
        this.zzciw = null;
    }

    private final zzaeu zza(zzoc zzoc) {
        int i;
        synchronized (this.mLock) {
            i = this.mErrorCode;
            if (zzoc == null && this.mErrorCode == -2) {
                i = 0;
            }
        }
        return new zzaeu(this.zzchv.zzcpe.zzclo, (zzama) null, this.zzchv.zzcwe.zzcbv, i, this.zzchv.zzcwe.zzcbw, this.zzciu, this.zzchv.zzcwe.orientation, this.zzchv.zzcwe.zzccb, this.zzchv.zzcpe.zzclr, false, (zztm) null, (zzuf) null, (String) null, (zztn) null, (zztp) null, 0, this.zzchv.zzath, this.zzchv.zzcwe.zzcnf, this.zzchv.zzcvw, this.zzchv.zzcvx, this.zzchv.zzcwe.zzcnl, this.zzciv, i != -2 ? null : zzoc, (zzadw) null, (List<String>) null, (List<String>) null, this.zzchv.zzcwe.zzcny, this.zzchv.zzcwe.zzcnz, (String) null, this.zzchv.zzcwe.zzcby, this.zzciw, this.zzchv.zzcwc, this.zzchv.zzcwe.zzapy, this.zzchv.zzcwd);
    }

    private final zzajp<zznr> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? zzajg.zzi(new zznr((Drawable) null, Uri.parse(string), optDouble)) : this.zzcir.zza(string, new zzxv(this, z, optDouble, optBoolean, string));
        }
        zzd(0, z);
        return zzajg.zzi(null);
    }

    static zzama zzb(zzajp<zzama> zzajp) {
        try {
            return (zzama) zzajp.get((long) ((Integer) zzbs.zzep().zzd(zzmq.zzbna)).intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            zzafj.zzc("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            zzafj.zzc("Exception occurred while waiting for video to load", e2);
        }
        return null;
    }

    private static Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(zzpu zzpu, String str) {
        try {
            zzqe zzr = this.zzcis.zzr(zzpu.getCustomTemplateId());
            if (zzr != null) {
                zzr.zzb(zzpu, str);
            }
        } catch (RemoteException e) {
            zzafj.zzc(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private static String[] zzd(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private static <V> zzajp<List<V>> zzk(List<zzajp<V>> list) {
        zzajy zzajy = new zzajy();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzajp<V> zza : list) {
            zza.zza(new zzxw(atomicInteger, size, zzajy, list), zzagl.zzcyx);
        }
        return zzajy;
    }

    /* access modifiers changed from: private */
    public static <V> List<V> zzl(List<zzajp<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (zzajp<V> zzajp : list) {
            Object obj = zzajp.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065 A[Catch:{ InterruptedException | CancellationException -> 0x0126, ExecutionException -> 0x0139, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012b  */
    /* renamed from: zzna */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.zzaeu call() {
        /*
            r13 = this;
            r11 = 0
            r12 = 0
            com.google.android.gms.ads.internal.zzba r2 = r13.zzcis     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r10 = r2.getUuid()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            boolean r2 = r13.zznb()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 != 0) goto L_0x0081
            com.google.android.gms.internal.zzajy r2 = new com.google.android.gms.internal.zzajy     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzxq r2 = new com.google.android.gms.internal.zzxq     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzaev r3 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzaad r3 = r3.zzcwe     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r3 = r3.body     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>(r3)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzyg r3 = r13.zzaqq     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzajp r2 = r3.zzi(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            long r4 = zzciq     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.Object r2 = r2.get(r4, r3)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r3 = "success"
            r4 = 0
            boolean r3 = r2.optBoolean(r3, r4)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r3 == 0) goto L_0x0081
            java.lang.String r3 = "json"
            org.json.JSONObject r2 = r2.getJSONObject(r3)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r3 = "ads"
            org.json.JSONArray r2 = r2.optJSONArray(r3)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r3 = 0
            org.json.JSONObject r7 = r2.getJSONObject(r3)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
        L_0x004d:
            boolean r2 = r13.zznb()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 != 0) goto L_0x0055
            if (r7 != 0) goto L_0x0083
        L_0x0055:
            r3 = r11
        L_0x0056:
            boolean r2 = r13.zznb()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 != 0) goto L_0x0060
            if (r3 == 0) goto L_0x0060
            if (r7 != 0) goto L_0x013b
        L_0x0060:
            r3 = r11
        L_0x0061:
            boolean r2 = r3 instanceof com.google.android.gms.internal.zznw     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 == 0) goto L_0x007c
            r0 = r3
            com.google.android.gms.internal.zznw r0 = (com.google.android.gms.internal.zznw) r0     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2 = r0
            com.google.android.gms.internal.zzxq r4 = new com.google.android.gms.internal.zzxq     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r4.<init>()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzxt r5 = new com.google.android.gms.internal.zzxt     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r5.<init>(r13, r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r4.zzcip = r5     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzyg r2 = r13.zzaqq     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r4 = "/nativeAdCustomClick"
            r2.zza((java.lang.String) r4, r5)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
        L_0x007c:
            com.google.android.gms.internal.zzaeu r2 = r13.zza((com.google.android.gms.internal.zzoc) r3)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
        L_0x0080:
            return r2
        L_0x0081:
            r7 = r11
            goto L_0x004d
        L_0x0083:
            java.lang.String r2 = "template_id"
            java.lang.String r5 = r7.getString(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzaev r2 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzzz r2 = r2.zzcpe     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzom r2 = r2.zzatt     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 == 0) goto L_0x00be
            com.google.android.gms.internal.zzaev r2 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzzz r2 = r2.zzcpe     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzom r2 = r2.zzatt     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            boolean r2 = r2.zzbtj     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r4 = r2
        L_0x009a:
            com.google.android.gms.internal.zzaev r2 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzzz r2 = r2.zzcpe     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzom r2 = r2.zzatt     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 == 0) goto L_0x00c0
            com.google.android.gms.internal.zzaev r2 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzzz r2 = r2.zzcpe     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzom r2 = r2.zzatt     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            boolean r2 = r2.zzbtl     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r3 = r2
        L_0x00ab:
            java.lang.String r2 = "2"
            boolean r2 = r2.equals(r5)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 == 0) goto L_0x00c2
            com.google.android.gms.internal.zzyh r2 = new com.google.android.gms.internal.zzyh     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzaev r5 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            boolean r5 = r5.zzcwd     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>(r4, r3, r5)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r3 = r2
            goto L_0x0056
        L_0x00be:
            r4 = r12
            goto L_0x009a
        L_0x00c0:
            r3 = r12
            goto L_0x00ab
        L_0x00c2:
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r5)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 == 0) goto L_0x00d5
            com.google.android.gms.internal.zzyi r2 = new com.google.android.gms.internal.zzyi     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzaev r5 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            boolean r5 = r5.zzcwd     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>(r4, r3, r5)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r3 = r2
            goto L_0x0056
        L_0x00d5:
            java.lang.String r2 = "3"
            boolean r2 = r2.equals(r5)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 == 0) goto L_0x0134
            java.lang.String r2 = "custom_template_id"
            java.lang.String r2 = r7.getString(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzajy r3 = new com.google.android.gms.internal.zzajy     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r3.<init>()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            android.os.Handler r5 = com.google.android.gms.internal.zzagr.zzczc     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzxs r6 = new com.google.android.gms.internal.zzxs     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r6.<init>(r13, r3, r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r5.post(r6)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            long r8 = zzciq     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.Object r2 = r3.get(r8, r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 == 0) goto L_0x0104
            com.google.android.gms.internal.zzyj r2 = new com.google.android.gms.internal.zzyj     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>(r4)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r3 = r2
            goto L_0x0056
        L_0x0104:
            java.lang.String r3 = "No handler for custom template: "
            java.lang.String r2 = "custom_template_id"
            java.lang.String r2 = r7.getString(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            int r4 = r2.length()     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r4 == 0) goto L_0x0120
            java.lang.String r2 = r3.concat(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
        L_0x011a:
            com.google.android.gms.internal.zzafj.m12e(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
        L_0x011d:
            r3 = r11
            goto L_0x0056
        L_0x0120:
            java.lang.String r2 = new java.lang.String     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>(r3)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            goto L_0x011a
        L_0x0126:
            r2 = move-exception
        L_0x0127:
            boolean r2 = r13.zzcit
            if (r2 != 0) goto L_0x012e
            r13.zzz(r12)
        L_0x012e:
            com.google.android.gms.internal.zzaeu r2 = r13.zza((com.google.android.gms.internal.zzoc) r11)
            goto L_0x0080
        L_0x0134:
            r2 = 0
            r13.zzz(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            goto L_0x011d
        L_0x0139:
            r2 = move-exception
            goto L_0x0127
        L_0x013b:
            java.lang.String r2 = "tracking_urls_and_actions"
            org.json.JSONObject r4 = r7.getJSONObject(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r2 = "impression_tracking_urls"
            java.lang.String[] r2 = zzd((org.json.JSONObject) r4, (java.lang.String) r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            if (r2 != 0) goto L_0x0179
            r2 = r11
        L_0x014a:
            r13.zzciu = r2     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r2 = "active_view"
            org.json.JSONObject r2 = r4.optJSONObject(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r13.zzciv = r2     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            java.lang.String r2 = "debug_signals"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r13.zzciw = r2     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzoc r8 = r3.zza(r13, r7)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzoe r2 = new com.google.android.gms.internal.zzoe     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            android.content.Context r3 = r13.mContext     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.ads.internal.zzba r4 = r13.zzcis     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzyg r5 = r13.zzaqq     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzcs r6 = r13.zzbta     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzaev r9 = r13.zzchv     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzzz r9 = r9.zzcpe     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            com.google.android.gms.internal.zzaiy r9 = r9.zzatd     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r8.zzb(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            r3 = r8
            goto L_0x0061
        L_0x0179:
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ CancellationException -> 0x0126, ExecutionException -> 0x0139, InterruptedException -> 0x0193, JSONException -> 0x017e, TimeoutException -> 0x0185, Exception -> 0x018c }
            goto L_0x014a
        L_0x017e:
            r2 = move-exception
            java.lang.String r3 = "Malformed native JSON response."
            com.google.android.gms.internal.zzafj.zzc(r3, r2)
            goto L_0x0127
        L_0x0185:
            r2 = move-exception
            java.lang.String r3 = "Timeout when loading native ad."
            com.google.android.gms.internal.zzafj.zzc(r3, r2)
            goto L_0x0127
        L_0x018c:
            r2 = move-exception
            java.lang.String r3 = "Error occured while doing native ads initialization."
            com.google.android.gms.internal.zzafj.zzc(r3, r2)
            goto L_0x0127
        L_0x0193:
            r2 = move-exception
            goto L_0x0127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzxr.call():com.google.android.gms.internal.zzaeu");
    }

    private final boolean zznb() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcit;
        }
        return z;
    }

    private final void zzz(int i) {
        synchronized (this.mLock) {
            this.zzcit = true;
            this.mErrorCode = i;
        }
    }

    public final zzajp<zznr> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public final List<zzajp<zznr>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            zzd(0, false);
            return arrayList;
        }
        int length = z3 ? optJSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, false, z2));
        }
        return arrayList;
    }

    public final Future<zznr> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public final zzajp<zzama> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzajg.zzi(null);
        }
        if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            zzafj.zzco("Required field 'vast_xml' is missing");
            return zzajg.zzi(null);
        }
        zzxy zzxy = new zzxy(this.mContext, this.zzbta, this.zzchv, this.zzamo, this.zzcis);
        zzajy zzajy = new zzajy();
        zzbs.zzec();
        zzagr.runOnUiThread(new zzxz(zzxy, optJSONObject, zzajy));
        return zzajy;
    }

    public final void zzd(int i, boolean z) {
        if (z) {
            zzz(i);
        }
    }

    public final zzajp<zznp> zzh(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzajg.zzi(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", MovementView.CIRCLES_RUN_TIME);
        int i = (this.zzchv.zzcpe.zzatt == null || this.zzchv.zzcpe.zzatt.versionCode < 2) ? 1 : this.zzchv.zzcpe.zzatt.zzbtm;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        return zzajg.zza(zzk(arrayList), new zzxu(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i, optBoolean), (Executor) zzagl.zzcyx);
    }
}
