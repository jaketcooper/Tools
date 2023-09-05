package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public class zzoe implements zzoa {
    private final Context mContext;
    private final Object mLock = new Object();
    @Nullable
    private final zzaiy zzaov;
    @Nullable
    private zzaek zzapk;
    @Nullable
    private final zzyg zzaqq;
    @Nullable
    private String zzaqr;
    private final zzob zzbsv;
    @Nullable
    private final JSONObject zzbsy;
    @Nullable
    private final zzoc zzbsz;
    private final zzcs zzbta;
    boolean zzbtb;
    private WeakReference<View> zzbtc = null;

    public zzoe(Context context, zzob zzob, @Nullable zzyg zzyg, zzcs zzcs, @Nullable JSONObject jSONObject, @Nullable zzoc zzoc, @Nullable zzaiy zzaiy, @Nullable String str) {
        this.mContext = context;
        this.zzbsv = zzob;
        this.zzaqq = zzyg;
        this.zzbta = zzcs;
        this.zzbsy = jSONObject;
        this.zzbsz = zzoc;
        this.zzaov = zzaiy;
        this.zzaqr = str;
    }

    private final JSONObject zza(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject2;
        }
        int[] zzh = zzh(view);
        for (Map.Entry next : map.entrySet()) {
            View view2 = (View) ((WeakReference) next.getValue()).get();
            if (view2 != null) {
                int[] zzh2 = zzh(view2);
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", zzt(view2.getMeasuredWidth()));
                    jSONObject4.put("height", zzt(view2.getMeasuredHeight()));
                    jSONObject4.put("x", zzt(zzh2[0] - zzh[0]));
                    jSONObject4.put("y", zzt(zzh2[1] - zzh[1]));
                    jSONObject4.put("relative_to", "ad_view");
                    jSONObject3.put("frame", jSONObject4);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        jSONObject = zzb(rect);
                    } else {
                        jSONObject = new JSONObject();
                        jSONObject.put("width", 0);
                        jSONObject.put("height", 0);
                        jSONObject.put("x", zzt(zzh2[0] - zzh[0]));
                        jSONObject.put("y", zzt(zzh2[1] - zzh[1]));
                        jSONObject.put("relative_to", "ad_view");
                    }
                    jSONObject3.put("visible_bounds", jSONObject);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject3.put("text_color", textView.getCurrentTextColor());
                        jSONObject3.put("font_size", (double) textView.getTextSize());
                        jSONObject3.put("text", textView.getText());
                    }
                    jSONObject2.put((String) next.getKey(), jSONObject3);
                } catch (JSONException e) {
                    zzafj.zzco("Unable to get asset views information");
                }
            }
        }
        return jSONObject2;
    }

    private final void zza(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6) {
        boolean z = true;
        zzbq.zzga("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzbsy);
            if (jSONObject2 != null) {
                jSONObject7.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject7.put("ad_view_signal", jSONObject);
            }
            if (jSONObject5 != null) {
                jSONObject7.put("click_signal", jSONObject5);
            }
            if (jSONObject3 != null) {
                jSONObject7.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject7.put("lock_screen_signal", jSONObject4);
            }
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzbsz.zzjo());
            zzbs.zzee();
            jSONObject8.put("is_privileged_process", zzagw.zzqd());
            jSONObject8.put("has_custom_click_handler", this.zzbsv.zzr(this.zzbsz.getCustomTemplateId()) != null);
            if (this.zzbsv.zzr(this.zzbsz.getCustomTemplateId()) == null) {
                z = false;
            }
            jSONObject7.put("has_custom_click_handler", z);
            try {
                JSONObject optJSONObject = this.zzbsy.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject8.put("click_signals", this.zzbta.zzad().zza(this.mContext, optJSONObject.optString("click_string"), view));
            } catch (Exception e) {
                zzafj.zzb("Exception obtaining click signals", e);
            }
            jSONObject7.put("click", jSONObject8);
            if (jSONObject6 != null) {
                jSONObject7.put("provided_signals", jSONObject6);
            }
            jSONObject7.put("ads_id", this.zzaqr);
            zzaje.zza(this.zzaqq.zzj(jSONObject7), "NativeAdEngineImpl.performClick");
        } catch (JSONException e2) {
            zzafj.zzb("Unable to create click JSON.", e2);
        }
    }

    private final boolean zza(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        zzbq.zzga("recordImpression must be called on the main UI thread.");
        if (this.zzbtb) {
            return true;
        }
        this.zzbtb = true;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzbsy);
            jSONObject6.put("ads_id", this.zzaqr);
            if (jSONObject2 != null) {
                jSONObject6.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject6.put("ad_view_signal", jSONObject);
            }
            if (jSONObject3 != null) {
                jSONObject6.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject6.put("lock_screen_signal", jSONObject4);
            }
            if (jSONObject5 != null) {
                jSONObject6.put("provided_signals", jSONObject5);
            }
            zzaje.zza(this.zzaqq.zzk(jSONObject6), "NativeAdEngineImpl.recordImpression");
            this.zzbsv.zza((zzoa) this);
            this.zzbsv.zzbw();
            return true;
        } catch (JSONException e) {
            zzafj.zzb("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final boolean zzaq(String str) {
        JSONObject optJSONObject = this.zzbsy == null ? null : this.zzbsy.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null) {
            return false;
        }
        return optJSONObject.optBoolean(str, false);
    }

    private final JSONObject zzb(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzt(rect.right - rect.left));
        jSONObject.put("height", zzt(rect.bottom - rect.top));
        jSONObject.put("x", zzt(rect.left));
        jSONObject.put("y", zzt(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int[] zzh(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    private final JSONObject zzi(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view != null) {
            try {
                int[] zzh = zzh(view);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("width", zzt(view.getMeasuredWidth()));
                jSONObject3.put("height", zzt(view.getMeasuredHeight()));
                jSONObject3.put("x", zzt(zzh[0]));
                jSONObject3.put("y", zzt(zzh[1]));
                jSONObject3.put("relative_to", "window");
                jSONObject2.put("frame", jSONObject3);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    jSONObject = zzb(rect);
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("width", 0);
                    jSONObject.put("height", 0);
                    jSONObject.put("x", zzt(zzh[0]));
                    jSONObject.put("y", zzt(zzh[1]));
                    jSONObject.put("relative_to", "window");
                }
                jSONObject2.put("visible_bounds", jSONObject);
            } catch (Exception e) {
                zzafj.zzco("Unable to get native ad view bounding box");
            }
        }
        return jSONObject2;
    }

    private static JSONObject zzj(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                zzbs.zzec();
                jSONObject.put("contained_in_scroll_view", zzagr.zzr(view) != -1);
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }

    private final JSONObject zzk(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                zzbs.zzec();
                jSONObject.put("can_show_on_lock_screen", zzagr.zzq(view));
                zzbs.zzec();
                jSONObject.put("is_keyguard_locked", zzagr.zzas(this.mContext));
            } catch (JSONException e) {
                zzafj.zzco("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    private final int zzt(int i) {
        zzjk.zzhx();
        return zzais.zzd(this.mContext, i);
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void performClick(Bundle bundle) {
        if (bundle == null) {
            zzafj.zzbw("Click data is null. No click is reported.");
        } else if (!zzaq("click_reporting")) {
            zzafj.m12e("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            zza((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle.getBundle("click_signal").getString("asset_id"), (JSONObject) null, zzbs.zzec().zza(bundle, (JSONObject) null));
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        if (!zzaq("impression_reporting")) {
            zzafj.m12e("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, zzbs.zzec().zza(bundle, (JSONObject) null));
    }

    public final void reportTouchEvent(Bundle bundle) {
        if (bundle == null) {
            zzafj.zzbw("Touch event data is null. No touch event is reported.");
        } else if (!zzaq("touch_reporting")) {
            zzafj.m12e("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzbta.zzad().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    @Nullable
    public View zza(View.OnClickListener onClickListener, boolean z) {
        zznp zzjp = this.zzbsz.zzjp();
        if (zzjp == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!z) {
            switch (zzjp.zzjj()) {
                case 0:
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case 2:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
        }
        zznq zznq = new zznq(this.mContext, zzjp, layoutParams);
        zznq.setOnClickListener(onClickListener);
        zznq.setContentDescription((CharSequence) zzbs.zzep().zzd(zzmq.zzbnb));
        return zznq;
    }

    public final void zza(View view, zzny zzny) {
        if (!zzb(view, zzny)) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            ((FrameLayout) view).removeAllViews();
            if (this.zzbsz instanceof zzod) {
                zzod zzod = (zzod) this.zzbsz;
                if (zzod.getImages() != null && zzod.getImages().size() > 0) {
                    Object obj = zzod.getImages().get(0);
                    zzoy zzk = obj instanceof IBinder ? zzoz.zzk((IBinder) obj) : null;
                    if (zzk != null) {
                        try {
                            IObjectWrapper zzjl = zzk.zzjl();
                            if (zzjl != null) {
                                ImageView imageView = new ImageView(this.mContext);
                                imageView.setImageDrawable((Drawable) zzn.zzx(zzjl));
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                ((FrameLayout) view).addView(imageView, layoutParams);
                            }
                        } catch (RemoteException e) {
                            zzafj.zzco("Could not get drawable from image");
                        }
                    }
                }
            }
        }
    }

    public final void zza(View view, String str, @Nullable Bundle bundle, Map<String, WeakReference<View>> map, View view2) {
        JSONObject jSONObject;
        JSONObject zza = zza(map, view2);
        JSONObject zzi = zzi(view2);
        JSONObject zzj = zzj(view2);
        JSONObject zzk = zzk(view2);
        try {
            JSONObject zza2 = zzbs.zzec().zza(bundle, (JSONObject) null);
            jSONObject = new JSONObject();
            try {
                jSONObject.put("click_point", zza2);
                jSONObject.put("asset_id", str);
            } catch (Exception e) {
                e = e;
                zzafj.zzb("Error occurred while grabbing click signals.", e);
                zza(view, zzi, zza, zzj, zzk, str, jSONObject, (JSONObject) null);
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
            zzafj.zzb("Error occurred while grabbing click signals.", e);
            zza(view, zzi, zza, zzj, zzk, str, jSONObject, (JSONObject) null);
        }
        zza(view, zzi, zza, zzj, zzk, str, jSONObject, (JSONObject) null);
    }

    public void zza(View view, Map<String, WeakReference<View>> map) {
        zza(zzi(view), zza(map, view), zzj(view), zzk(view), (JSONObject) null);
    }

    public void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        zzbq.zzga("performClick must be called on the main UI thread.");
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    zza(view, (String) next.getKey(), bundle, map, view2);
                    return;
                }
            }
        }
        if ("2".equals(this.zzbsz.zzjo())) {
            zza(view, "2099", bundle, map, view2);
        } else if ("1".equals(this.zzbsz.zzjo())) {
            zza(view, "1099", bundle, map, view2);
        }
    }

    public void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbmz)).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
            if (map2 != null) {
                for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                    View view3 = (View) ((WeakReference) value2.getValue()).get();
                    if (view3 != null) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                }
            }
        }
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbmy)).booleanValue()) {
            view.setOnTouchListener((View.OnTouchListener) null);
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            if (map != null) {
                for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                    View view2 = (View) ((WeakReference) value.getValue()).get();
                    if (view2 != null) {
                        view2.setOnTouchListener((View.OnTouchListener) null);
                        view2.setClickable(false);
                        view2.setOnClickListener((View.OnClickListener) null);
                    }
                }
            }
        }
    }

    public final boolean zzb(View view, zzny zzny) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View zzjq = this.zzbsz.zzjq();
        if (zzjq == null) {
            return false;
        }
        ViewParent parent = zzjq.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(zzjq);
        }
        ((FrameLayout) view).removeAllViews();
        ((FrameLayout) view).addView(zzjq, layoutParams);
        this.zzbsv.zza(zzny);
        return true;
    }

    public final void zzc(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            if (!this.zzbtb) {
                if (view.isShown()) {
                    if (view.getGlobalVisibleRect(new Rect(), (Point) null)) {
                        zza(view, map);
                    }
                }
            }
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        this.zzbta.zza(motionEvent);
    }

    public final void zzg(View view) {
        this.zzbtc = new WeakReference<>(view);
    }

    public final void zzg(Map<String, WeakReference<View>> map) {
        if (this.zzbsz.zzjq() == null) {
            return;
        }
        if ("2".equals(this.zzbsz.zzjo())) {
            zzbs.zzeg().zzb(this.mContext, this.zzbsv.getAdUnitId(), this.zzbsz.zzjo(), map.containsKey(NativeAppInstallAd.ASSET_MEDIA_VIDEO));
        } else if ("1".equals(this.zzbsz.zzjo())) {
            zzbs.zzeg().zzb(this.mContext, this.zzbsv.getAdUnitId(), this.zzbsz.zzjo(), map.containsKey(NativeContentAd.ASSET_MEDIA_VIDEO));
        }
    }

    public boolean zzjw() {
        zznp zzjp = this.zzbsz.zzjp();
        return zzjp != null && zzjp.zzjk();
    }

    public boolean zzjx() {
        return this.zzbsy != null && this.zzbsy.optBoolean("allow_pub_owned_ad_view", false);
    }

    public zzama zzka() throws zzamm {
        if (this.zzbsy == null || this.zzbsy.optJSONObject("overlay") == null) {
            return null;
        }
        zzamk zzed = zzbs.zzed();
        Context context = this.mContext;
        zziw zzg = zziw.zzg(this.mContext);
        zzama zza = zzed.zza(context, zzanp.zzc(zzg), zzg.zzbda, false, false, this.zzbta, this.zzaov, (zznd) null, (zzbl) null, (zzv) null, zzib.zzhi());
        if (zza == null) {
            return zza;
        }
        if (zza == null) {
            throw null;
        }
        ((View) zza).setVisibility(8);
        new zzog(zza).zza(this.zzaqq);
        return zza;
    }

    public void zzkb() {
        this.zzaqq.zzlm();
    }

    public void zzkc() {
        this.zzbsv.zzcp();
    }

    public final View zzkd() {
        if (this.zzbtc != null) {
            return (View) this.zzbtc.get();
        }
        return null;
    }

    @Nullable
    public final zzaek zzke() {
        if (!zzbs.zzfa().zzt(this.mContext)) {
            return null;
        }
        if (this.zzapk == null) {
            this.zzapk = new zzaek(this.mContext, this.zzbsv.getAdUnitId());
        }
        return this.zzapk;
    }
}
