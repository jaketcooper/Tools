package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaeu;
import com.google.android.gms.internal.zzafj;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamf;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoz;
import com.google.android.gms.internal.zztt;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzur;
import com.google.android.gms.internal.zzzb;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzaq {
    static zzt<zzama> zza(@Nullable zzuo zzuo, @Nullable zzur zzur, zzab zzab) {
        return new zzav(zzuo, zzab, zzur);
    }

    private static String zza(@Nullable Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            zzafj.zzco("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        String valueOf2 = String.valueOf(encodeToString);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static String zza(@Nullable zzoy zzoy) {
        if (zzoy == null) {
            zzafj.zzco("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri uri = zzoy.getUri();
            if (uri != null) {
                return uri.toString();
            }
        } catch (RemoteException e) {
            zzafj.zzco("Unable to get image uri. Trying data uri next");
        }
        return zzb(zzoy);
    }

    /* access modifiers changed from: private */
    public static JSONObject zza(@Nullable Bundle bundle, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (bundle.containsKey(next)) {
                if ("image".equals(jSONObject2.getString(next))) {
                    Object obj = bundle.get(next);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(next, zza((Bitmap) obj));
                    } else {
                        zzafj.zzco("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(next) instanceof Bitmap) {
                    zzafj.zzco("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(next, String.valueOf(bundle.get(next)));
                }
            }
        }
        return jSONObject;
    }

    public static boolean zza(zzama zzama, zztt zztt, CountDownLatch countDownLatch) {
        boolean z;
        if (zzama == null) {
            try {
                throw null;
            } catch (RemoteException e) {
                zzafj.zzc("Unable to invoke load assets", e);
                z = false;
            } catch (RuntimeException e2) {
                countDownLatch.countDown();
                throw e2;
            }
        } else {
            View view = (View) zzama;
            if (view == null) {
                zzafj.zzco("AdWebView is null");
                z = false;
            } else {
                view.setVisibility(4);
                List<String> list = zztt.zzcdd.zzcbq;
                if (list == null || list.isEmpty()) {
                    zzafj.zzco("No template ids present in mediation response");
                    z = false;
                } else {
                    zzama.zzsq().zza("/nativeExpressAssetsLoaded", (zzt<? super zzama>) new zzat(countDownLatch));
                    zzama.zzsq().zza("/nativeExpressAssetsLoadingFailed", (zzt<? super zzama>) new zzau(countDownLatch));
                    zzuo zzly = zztt.zzcde.zzly();
                    zzur zzlz = zztt.zzcde.zzlz();
                    if (list.contains("2") && zzly != null) {
                        zzama.zzsq().zza((zzamf) new zzar(new zzns(zzly.getHeadline(), zzly.getImages(), zzly.getBody(), zzly.zzjm(), zzly.getCallToAction(), zzly.getStarRating(), zzly.getStore(), zzly.getPrice(), (zznp) null, zzly.getExtras(), (zzku) null, zzly.zzmf() != null ? (View) zzn.zzx(zzly.zzmf()) : null, zzly.zzjr(), (String) null), zztt.zzcdd.zzcbp, zzama));
                    } else if (!list.contains("1") || zzlz == null) {
                        zzafj.zzco("No matching template id and mapper");
                        z = false;
                    } else {
                        zzama.zzsq().zza((zzamf) new zzas(new zznu(zzlz.getHeadline(), zzlz.getImages(), zzlz.getBody(), zzlz.zzjt(), zzlz.getCallToAction(), zzlz.getAdvertiser(), (zznp) null, zzlz.getExtras(), (zzku) null, zzlz.zzmf() != null ? (View) zzn.zzx(zzlz.zzmf()) : null, zzlz.zzjr(), (String) null), zztt.zzcdd.zzcbp, zzama));
                    }
                    String str = zztt.zzcdd.zzcbn;
                    String str2 = zztt.zzcdd.zzcbo;
                    if (str2 != null) {
                        zzama.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
                    } else {
                        zzama.loadData(str, "text/html", "UTF-8");
                    }
                    z = true;
                }
            }
            if (!z) {
                countDownLatch.countDown();
            }
            return z;
        }
    }

    private static String zzb(zzoy zzoy) {
        try {
            IObjectWrapper zzjl = zzoy.zzjl();
            if (zzjl == null) {
                zzafj.zzco("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) zzn.zzx(zzjl);
            if (drawable instanceof BitmapDrawable) {
                return zza(((BitmapDrawable) drawable).getBitmap());
            }
            zzafj.zzco("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            zzafj.zzco("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    /* access modifiers changed from: private */
    public static void zzc(zzama zzama) {
        View.OnClickListener onClickListener = zzama.getOnClickListener();
        if (onClickListener == null) {
            return;
        }
        if (zzama == null) {
            throw null;
        }
        onClickListener.onClick((View) zzama);
    }

    /* access modifiers changed from: private */
    @Nullable
    public static zzoy zzd(Object obj) {
        if (obj instanceof IBinder) {
            return zzoz.zzk((IBinder) obj);
        }
        return null;
    }

    @Nullable
    public static View zze(@Nullable zzaeu zzaeu) {
        if (zzaeu == null) {
            zzafj.m12e("AdState is null");
            return null;
        } else if (!zzf(zzaeu) || zzaeu.zzchj == null) {
            try {
                IObjectWrapper view = zzaeu.zzcde != null ? zzaeu.zzcde.getView() : null;
                if (view != null) {
                    return (View) zzn.zzx(view);
                }
                zzafj.zzco("View in mediation adapter is null.");
                return null;
            } catch (RemoteException e) {
                zzafj.zzc("Could not get View from mediation adapter.", e);
                return null;
            }
        } else {
            zzama zzama = zzaeu.zzchj;
            if (zzama != null) {
                return (View) zzama;
            }
            throw null;
        }
    }

    public static boolean zzf(@Nullable zzaeu zzaeu) {
        return (zzaeu == null || !zzaeu.zzcng || zzaeu.zzcdd == null || zzaeu.zzcdd.zzcbn == null) ? false : true;
    }
}
