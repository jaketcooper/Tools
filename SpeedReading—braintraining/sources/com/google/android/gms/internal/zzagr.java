package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzn;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzb
public final class zzagr {
    public static final Handler zzczc = new zzafk(Looper.getMainLooper());
    private static AtomicReference<List<String>> zzczd = new AtomicReference<>((Object) null);
    private static AtomicReference<List<String>> zzcze = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    /* access modifiers changed from: private */
    public String zzcxh;
    /* access modifiers changed from: private */
    public boolean zzczf = true;
    private boolean zzczg = false;
    private Pattern zzczh;
    private Pattern zzczi;

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            zzczc.post(runnable);
        }
    }

    public static Bundle zza(zzgt zzgt) {
        String str;
        String zzoy;
        String zzoz;
        if (zzgt == null) {
            return null;
        }
        if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbig)).booleanValue()) {
            if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbii)).booleanValue()) {
                return null;
            }
        }
        if (zzbs.zzeg().zzos() && zzbs.zzeg().zzot()) {
            return null;
        }
        if (zzgt.zzgu()) {
            zzgt.wakeup();
        }
        zzgn zzgs = zzgt.zzgs();
        if (zzgs != null) {
            String zzgh = zzgs.zzgh();
            String zzgi = zzgs.zzgi();
            String zzgj = zzgs.zzgj();
            if (zzgh != null) {
                zzbs.zzeg().zzbz(zzgh);
            }
            if (zzgj != null) {
                zzbs.zzeg().zzca(zzgj);
                zzoy = zzgh;
                str = zzgi;
                zzoz = zzgj;
            } else {
                zzoy = zzgh;
                str = zzgi;
                zzoz = zzgj;
            }
        } else {
            str = null;
            zzoy = zzbs.zzeg().zzoy();
            zzoz = zzbs.zzeg().zzoz();
        }
        Bundle bundle = new Bundle(1);
        if (zzoz != null) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbii)).booleanValue() && !zzbs.zzeg().zzot()) {
                bundle.putString("v_fp_vertical", zzoz);
            }
        }
        if (zzoy != null) {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbig)).booleanValue() && !zzbs.zzeg().zzos()) {
                bundle.putString("fingerprint", zzoy);
                if (!zzoy.equals(str)) {
                    bundle.putString("v_fp", str);
                }
            }
        }
        if (!bundle.isEmpty()) {
            return bundle;
        }
        return null;
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String zza(Context context, View view, zziw zziw) {
        if (!((Boolean) zzbs.zzep().zzd(zzmq.zzbiy)).booleanValue()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", zziw.width);
            jSONObject2.put("height", zziw.height);
            jSONObject.put("size", jSONObject2);
            jSONObject.put("activity", zzal(context));
            if (!zziw.zzbdb) {
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null) {
                        int i = -1;
                        if (parent instanceof ViewGroup) {
                            i = ((ViewGroup) parent).indexOfChild(view);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("type", parent.getClass().getName());
                        jSONObject3.put("index_of_child", i);
                        jSONArray.put(jSONObject3);
                    }
                    view = (parent == null || !(parent instanceof View)) ? null : (View) parent;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("parents", jSONArray);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zzafj.zzc("Fail to get view hierarchy json", e);
            return null;
        }
    }

    public static String zza(Context context, zzcs zzcs, String str, View view) {
        if (zzcs == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzcs.zzc(parse)) {
                parse = zzcs.zza(parse, context, view);
            }
            return parse.toString();
        } catch (Exception e) {
            return str;
        }
    }

    public static String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private final JSONArray zza(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object zza : collection) {
            zza(jSONArray, (Object) zza);
        }
        return jSONArray;
    }

    public static void zza(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void zza(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
        }
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    @TargetApi(18)
    public static void zza(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbow)).booleanValue()) {
                zzb(context, intent);
            }
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            zzafj.zzbw(new StringBuilder(String.valueOf(uri2).length() + 26).append("Opening ").append(uri2).append(" in a new browser.").toString());
        } catch (ActivityNotFoundException e) {
            zzafj.zzb("No browser is found.", e);
        }
    }

    public static void zza(Context context, String str, List<String> list) {
        for (String zzaik : list) {
            new zzaik(context, str, zzaik).zzmx();
        }
    }

    private final void zza(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzp((Map<String, ?>) (Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object zza : (Object[]) obj) {
                zza(jSONArray2, zza);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private final void zza(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzp((Map<String, ?>) (Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection<?>) (Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza((Collection<?>) Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    @TargetApi(24)
    public static boolean zza(Activity activity, Configuration configuration) {
        zzjk.zzhx();
        int zzc = zzais.zzc(activity, configuration.screenHeightDp);
        int zzc2 = zzais.zzc(activity, configuration.screenWidthDp);
        DisplayMetrics zza = zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int intValue = ((Integer) zzbs.zzep().zzd(zzmq.zzbpg)).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
        return zzb(i, dimensionPixelSize + zzc, intValue) && zzb(i2, zzc2, intValue);
    }

    public static boolean zza(ClassLoader classLoader, Class<?> cls, String str) {
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean zzag(Context context) {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            zzafj.zzco("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            zzafj.zzco(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            zzafj.zzco(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            zzafj.zzco(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            zzafj.zzco(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            zzafj.zzco(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            zzafj.zzco(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        zzafj.zzco(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", new Object[]{"smallestScreenSize"}));
        return false;
    }

    protected static String zzai(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable th) {
            return zzpu();
        }
    }

    public static AlertDialog.Builder zzaj(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzmc zzak(Context context) {
        return new zzmc(context);
    }

    private static String zzal(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (!(runningTasks == null || runningTasks.isEmpty() || (runningTaskInfo = runningTasks.get(0)) == null || runningTaskInfo.topActivity == null)) {
                return runningTaskInfo.topActivity.getClassName();
            }
            return null;
        } catch (Exception e) {
        }
    }

    public static boolean zzam(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    if (next.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (powerManager == null ? false : powerManager.isScreenOn()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static Bitmap zzan(Context context) {
        Bitmap bitmap;
        if (!(context instanceof Activity)) {
            return null;
        }
        try {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbml)).booleanValue()) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    bitmap = zzp(window.getDecorView().getRootView());
                }
                bitmap = null;
            } else {
                bitmap = zzo(((Activity) context).getWindow().getDecorView());
            }
        } catch (RuntimeException e) {
            zzafj.zzb("Fail to capture screen shot", e);
        }
        return bitmap;
    }

    public static AudioManager zzao(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public static float zzap(Context context) {
        AudioManager zzao = zzao(context);
        if (zzao == null) {
            return 0.0f;
        }
        int streamMaxVolume = zzao.getStreamMaxVolume(3);
        int streamVolume = zzao.getStreamVolume(3);
        if (streamMaxVolume != 0) {
            return ((float) streamVolume) / ((float) streamMaxVolume);
        }
        return 0.0f;
    }

    public static int zzaq(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    @Nullable
    private static KeyguardManager zzar(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r1 = zzar(r2);
     */
    @android.annotation.TargetApi(16)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzas(android.content.Context r2) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0009
            boolean r1 = com.google.android.gms.common.util.zzq.zzalx()
            if (r1 != 0) goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            android.app.KeyguardManager r1 = zzar(r2)
            if (r1 == 0) goto L_0x0009
            boolean r1 = r1.isKeyguardLocked()
            if (r1 == 0) goto L_0x0009
            r0 = 1
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzagr.zzas(android.content.Context):boolean");
    }

    public static boolean zzat(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            zzafj.zzb("Error loading class.", th);
            zzbs.zzeg().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static int zzau(Context context) {
        return DynamiteModule.zzac(context, ModuleDescriptor.MODULE_ID);
    }

    public static int zzav(Context context) {
        return DynamiteModule.zzab(context, ModuleDescriptor.MODULE_ID);
    }

    public static Uri zzb(String str, String str2, String str3) throws UnsupportedOperationException {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(str.substring(0, indexOf + 1) + str2 + "=" + str3 + "&" + str.substring(indexOf + 1)) : Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    public static void zzb(Activity activity, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            window.getDecorView().getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
        }
    }

    @TargetApi(18)
    public static void zzb(Context context, Intent intent) {
        if (intent != null && zzq.zzalz()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", (IBinder) null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void zzb(zzis zzis, boolean z) {
        Bundle bundle;
        Bundle bundle2 = zzis.zzbcf != null ? zzis.zzbcf : new Bundle();
        if (bundle2.getBundle(AdMobAdapter.class.getName()) != null) {
            bundle = bundle2.getBundle(AdMobAdapter.class.getName());
        } else {
            Bundle bundle3 = new Bundle();
            bundle2.putBundle(AdMobAdapter.class.getName(), bundle3);
            bundle = bundle3;
        }
        bundle.putBoolean("render_test_label", true);
    }

    public static void zzb(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzagl.zza(runnable);
        }
    }

    private static boolean zzb(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    private final JSONObject zzc(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static String zzcc(String str) {
        return Uri.parse(str).buildUpon().query((String) null).build().toString();
    }

    public static int zzcd(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            String valueOf = String.valueOf(e);
            zzafj.zzco(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Could not parse value:").append(valueOf).toString());
            return 0;
        }
    }

    public static boolean zzce(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static boolean zzd(Context context, String str, String str2) {
        return zzbgc.zzcy(context).checkPermission(str2, str) == 0;
    }

    public static float zzdh() {
        return zzbs.zzfc().zzdh();
    }

    public static boolean zzdi() {
        return zzbs.zzfc().zzdi();
    }

    public static void zze(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        zza(context, str, (List<String>) arrayList);
    }

    public static Map<String, String> zzf(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : zzbs.zzee().zzg(uri)) {
            hashMap.put(next, uri.getQueryParameter(next));
        }
        return hashMap;
    }

    public static void zzf(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e) {
            zzafj.zzb("Error writing to file in internal storage.", e);
        }
    }

    public static int[] zzf(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return zzpx();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static Bitmap zzm(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap zzn(View view) {
        if (view == null) {
            return null;
        }
        Bitmap zzp = zzp(view);
        return zzp == null ? zzo(view) : zzp;
    }

    private static Bitmap zzo(@NonNull View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                zzafj.zzco("Width or height of view is zero");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(0, 0, width, height);
            view.draw(canvas);
            return createBitmap;
        } catch (RuntimeException e) {
            zzafj.zzb("Fail to capture the webview", e);
            return null;
        }
    }

    private static Bitmap zzp(@NonNull View view) {
        RuntimeException e;
        Bitmap bitmap;
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            bitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            try {
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
            } catch (RuntimeException e2) {
                e = e2;
                zzafj.zzb("Fail to capture the web view", e);
                return bitmap;
            }
        } catch (RuntimeException e3) {
            RuntimeException runtimeException = e3;
            bitmap = null;
            e = runtimeException;
            zzafj.zzb("Fail to capture the web view", e);
            return bitmap;
        }
        return bitmap;
    }

    public static boolean zzp(zzis zzis) {
        Bundle bundle = zzis.zzbcf != null ? zzis.zzbcf : new Bundle();
        return (bundle.getBundle(AdMobAdapter.class.getName()) != null ? bundle.getBundle(AdMobAdapter.class.getName()) : new Bundle()).getBoolean("render_test_label", false);
    }

    private static String zzpu() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            stringBuffer.append(" ").append(Build.VERSION.RELEASE);
        }
        stringBuffer.append("; ").append(Locale.getDefault());
        if (Build.DEVICE != null) {
            stringBuffer.append("; ").append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                stringBuffer.append(" Build/").append(Build.DISPLAY);
            }
        }
        stringBuffer.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return stringBuffer.toString();
    }

    public static String zzpv() {
        return UUID.randomUUID().toString();
    }

    public static String zzpw() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
    }

    private static int[] zzpx() {
        return new int[]{0, 0};
    }

    public static Bundle zzpy() {
        Bundle bundle = new Bundle();
        try {
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbhf)).booleanValue()) {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                bundle.putParcelable("debug_memory_info", memoryInfo);
            }
            if (((Boolean) zzbs.zzep().zzd(zzmq.zzbhg)).booleanValue()) {
                Runtime runtime = Runtime.getRuntime();
                bundle.putLong("runtime_free_memory", runtime.freeMemory());
                bundle.putLong("runtime_max_memory", runtime.maxMemory());
                bundle.putLong("runtime_total_memory", runtime.totalMemory());
            }
            bundle.putInt("web_view_count", zzbs.zzeg().zzpp());
        } catch (Exception e) {
            zzafj.zzc("Unable to gather memory stats", e);
        }
        return bundle;
    }

    public static String zzq(Context context, String str) {
        try {
            return new String(zzn.zza(context.openFileInput(str), true), "UTF-8");
        } catch (IOException e) {
            zzafj.zzbw("Error reading from internal storage.");
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzq(android.view.View r4) {
        /*
            r2 = 0
            r1 = 0
            android.view.View r0 = r4.getRootView()
            if (r0 == 0) goto L_0x0016
            android.content.Context r0 = r0.getContext()
            boolean r3 = r0 instanceof android.app.Activity
            if (r3 == 0) goto L_0x0016
            android.app.Activity r0 = (android.app.Activity) r0
        L_0x0012:
            if (r0 != 0) goto L_0x0018
            r0 = r1
        L_0x0015:
            return r0
        L_0x0016:
            r0 = r2
            goto L_0x0012
        L_0x0018:
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto L_0x002a
            r0 = r2
        L_0x001f:
            if (r0 == 0) goto L_0x002f
            int r0 = r0.flags
            r2 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r2
            if (r0 == 0) goto L_0x002f
            r0 = 1
            goto L_0x0015
        L_0x002a:
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            goto L_0x001f
        L_0x002f:
            r0 = r1
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzagr.zzq(android.view.View):boolean");
    }

    public static int zzr(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public final JSONObject zza(Bundle bundle, JSONObject jSONObject) {
        try {
            return zzc(bundle);
        } catch (JSONException e) {
            zzafj.zzb("Error converting Bundle to JSON", e);
            return null;
        }
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        if (z) {
            zzbs.zzec();
            bundle.putString("device", zzpw());
            bundle.putString("eids", TextUtils.join(",", zzmq.zziq()));
        }
        zzjk.zzhx();
        zzais.zza(context, str, str2, bundle, z, new zzagu(this, context, str));
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", zzp(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final void zza(Context context, List<String> list) {
        if (!(context instanceof Activity) || TextUtils.isEmpty(zzfll.zzfh((Activity) context))) {
            return;
        }
        if (list == null) {
            zzafj.m11v("Cannot ping urls: empty list.");
        } else if (!zznn.zzi(context)) {
            zzafj.m11v("Cannot ping url because custom tabs is not supported");
        } else {
            zznn zznn = new zznn();
            zznn.zza((zzno) new zzags(this, list, zznn, context));
            zznn.zzd((Activity) context);
        }
    }

    public final boolean zza(View view, Context context) {
        PowerManager powerManager = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            powerManager = (PowerManager) applicationContext.getSystemService("power");
        }
        return zza(view, powerManager, zzar(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(android.view.View r5, android.os.PowerManager r6, android.app.KeyguardManager r7) {
        /*
            r4 = this;
            r2 = 1
            r1 = 0
            com.google.android.gms.internal.zzagr r0 = com.google.android.gms.ads.internal.zzbs.zzec()
            boolean r0 = r0.zzczf
            if (r0 != 0) goto L_0x0027
            if (r7 != 0) goto L_0x006a
            r0 = r1
        L_0x000d:
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbla
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x006f
            boolean r0 = zzq(r5)
            if (r0 == 0) goto L_0x006f
        L_0x0027:
            r0 = r2
        L_0x0028:
            int r3 = r5.getVisibility()
            if (r3 != 0) goto L_0x0073
            boolean r3 = r5.isShown()
            if (r3 == 0) goto L_0x0073
            if (r6 == 0) goto L_0x003c
            boolean r3 = r6.isScreenOn()
            if (r3 == 0) goto L_0x0071
        L_0x003c:
            r3 = r2
        L_0x003d:
            if (r3 == 0) goto L_0x0073
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.internal.zzmg<java.lang.Boolean> r0 = com.google.android.gms.internal.zzmq.zzbky
            com.google.android.gms.internal.zzmo r3 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r0 = r3.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0069
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r5.getLocalVisibleRect(r0)
            if (r0 != 0) goto L_0x0069
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            boolean r0 = r5.getGlobalVisibleRect(r0)
            if (r0 == 0) goto L_0x0073
        L_0x0069:
            return r2
        L_0x006a:
            boolean r0 = r7.inKeyguardRestrictedInputMode()
            goto L_0x000d
        L_0x006f:
            r0 = r1
            goto L_0x0028
        L_0x0071:
            r3 = r1
            goto L_0x003d
        L_0x0073:
            r2 = r1
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzagr.zza(android.view.View, android.os.PowerManager, android.app.KeyguardManager):boolean");
    }

    public final boolean zzah(Context context) {
        if (this.zzczg) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzagv(this, (zzags) null), intentFilter);
        this.zzczg = true;
        return true;
    }

    public final void zzb(Context context, String str, String str2, Bundle bundle, boolean z) {
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbld)).booleanValue()) {
            zza(context, str, str2, bundle, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (((java.lang.String) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbje)).equals(r3.zzczh.pattern()) == false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzcf(java.lang.String r4) {
        /*
            r3 = this;
            r1 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0009
            r0 = r1
        L_0x0008:
            return r0
        L_0x0009:
            monitor-enter(r3)     // Catch:{ PatternSyntaxException -> 0x0047 }
            java.util.regex.Pattern r0 = r3.zzczh     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.internal.zzmg<java.lang.String> r0 = com.google.android.gms.internal.zzmq.zzbje     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0044 }
            java.util.regex.Pattern r2 = r3.zzczh     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = r2.pattern()     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0038
        L_0x0026:
            com.google.android.gms.internal.zzmg<java.lang.String> r0 = com.google.android.gms.internal.zzmq.zzbje     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0044 }
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x0044 }
            r3.zzczh = r0     // Catch:{ all -> 0x0044 }
        L_0x0038:
            java.util.regex.Pattern r0 = r3.zzczh     // Catch:{ all -> 0x0044 }
            java.util.regex.Matcher r0 = r0.matcher(r4)     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.matches()     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0008
        L_0x0044:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0044 }
            throw r0     // Catch:{ PatternSyntaxException -> 0x0047 }
        L_0x0047:
            r0 = move-exception
            r0 = r1
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzagr.zzcf(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (((java.lang.String) com.google.android.gms.ads.internal.zzbs.zzep().zzd(com.google.android.gms.internal.zzmq.zzbjf)).equals(r3.zzczi.pattern()) == false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzcg(java.lang.String r4) {
        /*
            r3 = this;
            r1 = 0
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0009
            r0 = r1
        L_0x0008:
            return r0
        L_0x0009:
            monitor-enter(r3)     // Catch:{ PatternSyntaxException -> 0x0047 }
            java.util.regex.Pattern r0 = r3.zzczi     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.internal.zzmg<java.lang.String> r0 = com.google.android.gms.internal.zzmq.zzbjf     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0044 }
            java.util.regex.Pattern r2 = r3.zzczi     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = r2.pattern()     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0038
        L_0x0026:
            com.google.android.gms.internal.zzmg<java.lang.String> r0 = com.google.android.gms.internal.zzmq.zzbjf     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzmo r2 = com.google.android.gms.ads.internal.zzbs.zzep()     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r2.zzd(r0)     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0044 }
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ all -> 0x0044 }
            r3.zzczi = r0     // Catch:{ all -> 0x0044 }
        L_0x0038:
            java.util.regex.Pattern r0 = r3.zzczi     // Catch:{ all -> 0x0044 }
            java.util.regex.Matcher r0 = r0.matcher(r4)     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.matches()     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0008
        L_0x0044:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0044 }
            throw r0     // Catch:{ PatternSyntaxException -> 0x0047 }
        L_0x0047:
            r0 = move-exception
            r0 = r1
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzagr.zzcg(java.lang.String):boolean");
    }

    public final int[] zzg(Activity activity) {
        int[] zzf = zzf(activity);
        zzjk.zzhx();
        zzjk.zzhx();
        return new int[]{zzais.zzd(activity, zzf[0]), zzais.zzd(activity, zzf[1])};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r1 = r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] zzh(android.app.Activity r7) {
        /*
            r6 = this;
            r5 = 2
            r4 = 1
            r3 = 0
            android.view.Window r0 = r7.getWindow()
            if (r0 == 0) goto L_0x0039
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r0.findViewById(r1)
            if (r1 == 0) goto L_0x0039
            int[] r0 = new int[r5]
            int r2 = r1.getTop()
            r0[r3] = r2
            int r1 = r1.getBottom()
            r0[r4] = r1
        L_0x0020:
            int[] r1 = new int[r5]
            com.google.android.gms.internal.zzjk.zzhx()
            r2 = r0[r3]
            int r2 = com.google.android.gms.internal.zzais.zzd(r7, r2)
            r1[r3] = r2
            com.google.android.gms.internal.zzjk.zzhx()
            r0 = r0[r4]
            int r0 = com.google.android.gms.internal.zzais.zzd(r7, r0)
            r1[r4] = r0
            return r1
        L_0x0039:
            int[] r0 = zzpx()
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzagr.zzh(android.app.Activity):int[]");
    }

    public final String zzp(Context context, String str) {
        String str2;
        synchronized (this.mLock) {
            if (this.zzcxh != null) {
                str2 = this.zzcxh;
            } else if (str == null) {
                str2 = zzpu();
            } else {
                try {
                    this.zzcxh = zzbs.zzee().getDefaultUserAgent(context);
                } catch (Exception e) {
                }
                if (TextUtils.isEmpty(this.zzcxh)) {
                    zzjk.zzhx();
                    if (!zzais.zzqt()) {
                        this.zzcxh = null;
                        zzczc.post(new zzagt(this, context));
                        while (this.zzcxh == null) {
                            try {
                                this.mLock.wait();
                            } catch (InterruptedException e2) {
                                this.zzcxh = zzpu();
                                String valueOf = String.valueOf(this.zzcxh);
                                zzafj.zzco(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                            }
                        }
                    } else {
                        this.zzcxh = zzai(context);
                    }
                }
                String valueOf2 = String.valueOf(this.zzcxh);
                this.zzcxh = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length()).append(valueOf2).append(" (Mobile; ").append(str).toString();
                try {
                    if (zzbgc.zzcy(context).zzamj()) {
                        this.zzcxh = String.valueOf(this.zzcxh).concat(";aia");
                    }
                } catch (Exception e3) {
                    zzbs.zzeg().zza((Throwable) e3, "AdUtil.getUserAgent");
                }
                this.zzcxh = String.valueOf(this.zzcxh).concat(")");
                str2 = this.zzcxh;
            }
        }
        return str2;
    }

    public final JSONObject zzp(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : map.keySet()) {
                zza(jSONObject, next, (Object) map.get(next));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            String valueOf = String.valueOf(e.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }
}
