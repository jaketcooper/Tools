package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.support.p000v4.util.ArrayMap;
import android.support.p000v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.api.internal.zzl;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzeuo;
import com.google.android.gms.internal.zzeup;
import com.google.android.gms.internal.zzeuq;
import com.google.android.gms.internal.zzeur;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    /* access modifiers changed from: private */
    public static final Object sLock = new Object();
    static final Map<String, FirebaseApp> zzicu = new ArrayMap();
    private static final List<String> zzlwp = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> zzlwq = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzlwr = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> zzlws = Arrays.asList(new String[0]);
    private static final Set<String> zzlwt = Collections.emptySet();
    private final Context mApplicationContext;
    private final String mName;
    private final FirebaseOptions zzlwu;
    private final AtomicBoolean zzlwv = new AtomicBoolean(false);
    private final AtomicBoolean zzlww = new AtomicBoolean();
    private final List<zzb> zzlwx = new CopyOnWriteArrayList();
    private final List<zza> zzlwy = new CopyOnWriteArrayList();
    private final List<Object> zzlwz = new CopyOnWriteArrayList();
    private zzeuq zzlxa;
    private zzc zzlxb;

    public interface zza {
        void zzbe(boolean z);
    }

    public interface zzb {
        void zzb(@NonNull zzeur zzeur);
    }

    public interface zzc {
    }

    @TargetApi(24)
    static class zzd extends BroadcastReceiver {
        private static AtomicReference<zzd> zzlxc = new AtomicReference<>();
        private final Context mApplicationContext;

        private zzd(Context context) {
            this.mApplicationContext = context;
        }

        /* access modifiers changed from: private */
        public static void zzeo(Context context) {
            if (zzlxc.get() == null) {
                zzd zzd = new zzd(context);
                if (zzlxc.compareAndSet((Object) null, zzd)) {
                    context.registerReceiver(zzd, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.sLock) {
                for (FirebaseApp zza : FirebaseApp.zzicu.values()) {
                    zza.zzbpb();
                }
            }
            this.mApplicationContext.unregisterReceiver(this);
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.mApplicationContext = (Context) zzbq.checkNotNull(context);
        this.mName = zzbq.zzgi(str);
        this.zzlwu = (FirebaseOptions) zzbq.checkNotNull(firebaseOptions);
        this.zzlxb = new zzeuo();
    }

    public static List<FirebaseApp> getApps(Context context) {
        ArrayList arrayList;
        zzeup.zzew(context);
        synchronized (sLock) {
            arrayList = new ArrayList(zzicu.values());
            zzeup.zzcht();
            Set<String> zzchu = zzeup.zzchu();
            zzchu.removeAll(zzicu.keySet());
            for (String next : zzchu) {
                zzeup.zzrb(next);
                arrayList.add(initializeApp(context, (FirebaseOptions) null, next));
            }
        }
        return arrayList;
    }

    @Nullable
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (sLock) {
            firebaseApp = zzicu.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                String zzamd = zzs.zzamd();
                throw new IllegalStateException(new StringBuilder(String.valueOf(zzamd).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(zzamd).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String concat;
        synchronized (sLock) {
            firebaseApp = zzicu.get(str.trim());
            if (firebaseApp == null) {
                List<String> zzbpa = zzbpa();
                if (zzbpa.isEmpty()) {
                    concat = "";
                } else {
                    String valueOf = String.valueOf(TextUtils.join(", ", zzbpa));
                    concat = valueOf.length() != 0 ? "Available app names: ".concat(valueOf) : new String("Available app names: ");
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, concat}));
            }
        }
        return firebaseApp;
    }

    @Nullable
    public static FirebaseApp initializeApp(Context context) {
        FirebaseApp initializeApp;
        synchronized (sLock) {
            if (zzicu.containsKey(DEFAULT_APP_NAME)) {
                initializeApp = getInstance();
            } else {
                FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
                initializeApp = fromResource == null ? null : initializeApp(context, fromResource);
            }
        }
        return initializeApp;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        zzeup.zzew(context);
        if (context.getApplicationContext() instanceof Application) {
            zzk.zza((Application) context.getApplicationContext());
            zzk.zzagq().zza((zzl) new zza());
        }
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (sLock) {
            zzbq.zza(!zzicu.containsKey(trim), (Object) new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
            zzbq.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, trim, firebaseOptions);
            zzicu.put(trim, firebaseApp);
        }
        zzeup.zzf(firebaseApp);
        firebaseApp.zza(FirebaseApp.class, firebaseApp, zzlwp);
        if (firebaseApp.zzboy()) {
            firebaseApp.zza(FirebaseApp.class, firebaseApp, zzlwq);
            firebaseApp.zza(Context.class, firebaseApp.getApplicationContext(), zzlwr);
        }
        return firebaseApp;
    }

    private final <T> void zza(Class<T> cls, T t, Iterable<String> iterable) {
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.mApplicationContext);
        if (isDeviceProtectedStorage) {
            zzd.zzeo(this.mApplicationContext);
        }
        for (String next : iterable) {
            if (isDeviceProtectedStorage) {
                try {
                    if (!zzlws.contains(next)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (zzlwt.contains(next)) {
                        throw new IllegalStateException(String.valueOf(next).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(next).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(next).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (InvocationTargetException e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (IllegalAccessException e4) {
                    String valueOf = String.valueOf(next);
                    Log.wtf("FirebaseApp", valueOf.length() != 0 ? "Failed to initialize ".concat(valueOf) : new String("Failed to initialize "), e4);
                }
            }
            Method method = Class.forName(next).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke((Object) null, new Object[]{t});
            }
        }
    }

    public static void zzbe(boolean z) {
        synchronized (sLock) {
            ArrayList arrayList = new ArrayList(zzicu.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.zzlwv.get()) {
                    firebaseApp.zzca(z);
                }
            }
        }
    }

    private final void zzbox() {
        zzbq.zza(!this.zzlww.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> zzbpa() {
        ArraySet arraySet = new ArraySet();
        synchronized (sLock) {
            for (FirebaseApp name : zzicu.values()) {
                arraySet.add(name.getName());
            }
            if (zzeup.zzcht() != null) {
                arraySet.addAll(zzeup.zzchu());
            }
        }
        ArrayList arrayList = new ArrayList(arraySet);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void zzbpb() {
        zza(FirebaseApp.class, this, zzlwp);
        if (zzboy()) {
            zza(FirebaseApp.class, this, zzlwq);
            zza(Context.class, this.mApplicationContext, zzlwr);
        }
    }

    private final void zzca(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (zza zzbe : this.zzlwy) {
            zzbe.zzbe(z);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.mName.equals(((FirebaseApp) obj).getName());
    }

    @NonNull
    public Context getApplicationContext() {
        zzbox();
        return this.mApplicationContext;
    }

    @NonNull
    public String getName() {
        zzbox();
        return this.mName;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zzbox();
        return this.zzlwu;
    }

    public final Task<GetTokenResult> getToken(boolean z) {
        zzbox();
        return this.zzlxa == null ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.zzlxa.zzcb(z);
    }

    @Nullable
    public final String getUid() throws FirebaseApiNotAvailableException {
        zzbox();
        if (this.zzlxa != null) {
            return this.zzlxa.getUid();
        }
        throw new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.");
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public void setAutomaticResourceManagementEnabled(boolean z) {
        zzbox();
        if (this.zzlwv.compareAndSet(!z, z)) {
            boolean zzagr = zzk.zzagq().zzagr();
            if (z && zzagr) {
                zzca(true);
            } else if (!z && zzagr) {
                zzca(false);
            }
        }
    }

    public String toString() {
        return zzbg.zzw(this).zzg("name", this.mName).zzg("options", this.zzlwu).toString();
    }

    public final void zza(@NonNull zzeuq zzeuq) {
        this.zzlxa = (zzeuq) zzbq.checkNotNull(zzeuq);
    }

    @UiThread
    public final void zza(@NonNull zzeur zzeur) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (zzb zzb2 : this.zzlwx) {
            zzb2.zzb(zzeur);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    public final void zza(zza zza2) {
        zzbox();
        if (this.zzlwv.get() && zzk.zzagq().zzagr()) {
            zza2.zzbe(true);
        }
        this.zzlwy.add(zza2);
    }

    public final void zza(@NonNull zzb zzb2) {
        zzbox();
        zzbq.checkNotNull(zzb2);
        this.zzlwx.add(zzb2);
        this.zzlwx.size();
    }

    public final boolean zzboy() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public final String zzboz() {
        String zzl = com.google.android.gms.common.util.zzb.zzl(getName().getBytes());
        String zzl2 = com.google.android.gms.common.util.zzb.zzl(getOptions().getApplicationId().getBytes());
        return new StringBuilder(String.valueOf(zzl).length() + 1 + String.valueOf(zzl2).length()).append(zzl).append("+").append(zzl2).toString();
    }
}
