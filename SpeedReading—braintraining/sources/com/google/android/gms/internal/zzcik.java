package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcik extends zzcii {
    protected zzciy zzjem;
    private AppMeasurement.EventInterceptor zzjen;
    private final Set<AppMeasurement.OnEventListener> zzjeo = new CopyOnWriteArraySet();
    private boolean zzjep;
    private final AtomicReference<String> zzjeq = new AtomicReference<>();

    protected zzcik(zzchj zzchj) {
        super(zzchj);
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzwh().currentTimeMillis();
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgi(conditionalUserProperty.mName);
        zzbq.zzgi(conditionalUserProperty.mOrigin);
        zzbq.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzawj().zzjy(str) != 0) {
            zzawn().zzays().zzj("Invalid conditional user property name", zzawi().zzje(str));
        } else if (zzawj().zzl(str, obj) != 0) {
            zzawn().zzays().zze("Invalid conditional user property value", zzawi().zzje(str), obj);
        } else {
            Object zzm = zzawj().zzm(str, obj);
            if (zzm == null) {
                zzawn().zzays().zze("Unable to normalize conditional user property value", zzawi().zzje(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzm;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                long j2 = conditionalUserProperty.mTimeToLive;
                if (j2 > 15552000000L || j2 < 1) {
                    zzawn().zzays().zze("Invalid conditional user property time to live", zzawi().zzje(str), Long.valueOf(j2));
                } else {
                    zzawm().zzg(new zzcim(this, conditionalUserProperty));
                }
            } else {
                zzawn().zzays().zze("Invalid conditional user property timeout", zzawi().zzje(str), Long.valueOf(j));
            }
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                if (obj instanceof Bundle) {
                    bundle2.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= parcelableArr.length) {
                            break;
                        }
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i = i2 + 1;
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= arrayList.size()) {
                            break;
                        }
                        Object obj2 = arrayList.get(i4);
                        if (obj2 instanceof Bundle) {
                            arrayList.set(i4, new Bundle((Bundle) obj2));
                        }
                        i3 = i4 + 1;
                    }
                }
            }
        }
        zzawm().zzg(new zzcis(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzawm().zzg(new zzcit(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzwh().currentTimeMillis(), bundle, true, z2, z3, (String) null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, String str2, Object obj, long j) {
        zzbq.zzgi(str);
        zzbq.zzgi(str2);
        zzut();
        zzwu();
        if (!this.zzitu.isEnabled()) {
            zzawn().zzayx().log("User property not set since app measurement is disabled");
        } else if (this.zzitu.zzazk()) {
            zzawn().zzayx().zze("Setting user property (FE)", zzawi().zzjc(str2), obj);
            zzawe().zzb(new zzckk(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzwh().currentTimeMillis();
        zzbq.zzgi(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzawm().zzg(new zzcin(this, conditionalUserProperty));
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzawm().zzazh()) {
            zzawn().zzays().log("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzawm();
        if (zzche.zzas()) {
            zzawn().zzays().log("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzitu.zzawm().zzg(new zzcip(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzawn().zzayu().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<zzckk> list = (List) atomicReference.get();
        if (list == null) {
            zzawn().zzayu().log("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzckk zzckk : list) {
            arrayMap.put(zzckk.name, zzckk.getValue());
        }
        return arrayMap;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzut();
        zzwu();
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgi(conditionalUserProperty.mName);
        zzbq.zzgi(conditionalUserProperty.mOrigin);
        zzbq.checkNotNull(conditionalUserProperty.mValue);
        if (!this.zzitu.isEnabled()) {
            zzawn().zzayx().log("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        zzckk zzckk = new zzckk(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzcfx zza = zzawj().zza(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
            zzawe().zzf(new zzcfi(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzckk, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzawj().zza(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zzawj().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i;
        zzbq.zzgi(str);
        zzbq.zzgi(str2);
        zzbq.checkNotNull(bundle);
        zzut();
        zzwu();
        if (!this.zzitu.isEnabled()) {
            zzawn().zzayx().log("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.zzjep) {
            this.zzjep = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{getContext()});
                } catch (Exception e) {
                    zzawn().zzayu().zzj("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException e2) {
                zzawn().zzayw().log("Tag Manager is not found and thus will not be used");
            }
        }
        boolean equals = "am".equals(str);
        boolean zzkd = zzckn.zzkd(str2);
        if (z && this.zzjen != null && !zzkd && !equals) {
            zzawn().zzayx().zze("Passing event to registered event handler (FE)", zzawi().zzjc(str2), zzawi().zzx(bundle));
            this.zzjen.interceptEvent(str, str2, bundle, j);
        } else if (this.zzitu.zzazk()) {
            int zzjw = zzawj().zzjw(str2);
            if (zzjw != 0) {
                zzawj();
                this.zzitu.zzawj().zza(str3, zzjw, "_ev", zzckn.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            List singletonList = Collections.singletonList("_o");
            Bundle zza = zzawj().zza(str2, bundle, (List<String>) singletonList, z3, true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza);
            long nextLong = zzawj().zzbao().nextLong();
            int i2 = 0;
            String[] strArr = (String[]) zza.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length = strArr.length;
            int i3 = 0;
            while (i3 < length) {
                String str4 = strArr[i3];
                Object obj = zza.get(str4);
                zzawj();
                Bundle[] zzae = zzckn.zzae(obj);
                if (zzae != null) {
                    zza.putInt(str4, zzae.length);
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= zzae.length) {
                            break;
                        }
                        Bundle zza2 = zzawj().zza("_ep", zzae[i5], (List<String>) singletonList, z3, false);
                        zza2.putString("_en", str2);
                        zza2.putLong("_eid", nextLong);
                        zza2.putString("_gn", str4);
                        zza2.putInt("_ll", zzae.length);
                        zza2.putInt("_i", i5);
                        arrayList.add(zza2);
                        i4 = i5 + 1;
                    }
                    i = zzae.length + i2;
                } else {
                    i = i2;
                }
                i3++;
                i2 = i;
            }
            if (i2 != 0) {
                zza.putLong("_eid", nextLong);
                zza.putInt("_epc", i2);
            }
            zzcjc zzbad = zzawf().zzbad();
            if (zzbad != null && !zza.containsKey("_sc")) {
                zzbad.zzjfq = true;
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                Bundle bundle2 = (Bundle) arrayList.get(i7);
                String str5 = i7 != 0 ? "_ep" : str2;
                bundle2.putString("_o", str);
                if (!bundle2.containsKey("_sc")) {
                    zzciz.zza((AppMeasurement.zzb) zzbad, bundle2);
                }
                Bundle zzy = z2 ? zzawj().zzy(bundle2) : bundle2;
                zzawn().zzayx().zze("Logging event (FE)", zzawi().zzjc(str2), zzawi().zzx(zzy));
                zzawe().zzc(new zzcfx(str5, new zzcfu(zzy), str, j), str3);
                if (!equals) {
                    for (AppMeasurement.OnEventListener onEvent : this.zzjeo) {
                        onEvent.onEvent(str, str2, new Bundle(zzy), j);
                    }
                }
                i6 = i7 + 1;
            }
            if (zzawf().zzbad() != null && AppMeasurement.Event.APP_EXCEPTION.equals(str2)) {
                zzawl().zzbr(true);
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzbo(boolean z) {
        zzut();
        zzwu();
        zzawn().zzayx().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzawo().setMeasurementEnabled(z);
        zzawe().zzbaf();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzut();
        zzwu();
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgi(conditionalUserProperty.mName);
        if (!this.zzitu.isEnabled()) {
            zzawn().zzayx().log("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        zzckk zzckk = new zzckk(conditionalUserProperty.mName, 0, (Object) null, (String) null);
        try {
            zzawe().zzf(new zzcfi(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzckk, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, (zzcfx) null, conditionalUserProperty.mTriggerTimeout, (zzcfx) null, conditionalUserProperty.mTimeToLive, zzawj().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    private final List<AppMeasurement.ConditionalUserProperty> zzk(String str, String str2, String str3) {
        if (zzawm().zzazh()) {
            zzawn().zzays().log("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzawm();
        if (zzche.zzas()) {
            zzawn().zzays().log("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzitu.zzawm().zzg(new zzcio(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzawn().zzayu().zze("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzcfi> list = (List) atomicReference.get();
        if (list == null) {
            zzawn().zzayu().zzj("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzcfi zzcfi : list) {
            AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = zzcfi.zzivw;
            conditionalUserProperty.mName = zzcfi.zzivv.name;
            conditionalUserProperty.mValue = zzcfi.zzivv.getValue();
            conditionalUserProperty.mActive = zzcfi.zzivx;
            conditionalUserProperty.mTriggerEventName = zzcfi.zzivy;
            if (zzcfi.zzivz != null) {
                conditionalUserProperty.mTimedOutEventName = zzcfi.zzivz.name;
                if (zzcfi.zzivz.zzixi != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzcfi.zzivz.zzixi.zzaym();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzcfi.zziwa;
            if (zzcfi.zziwb != null) {
                conditionalUserProperty.mTriggeredEventName = zzcfi.zziwb.name;
                if (zzcfi.zziwb.zzixi != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzcfi.zziwb.zzixi.zzaym();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzcfi.zzivv.zzjgx;
            conditionalUserProperty.mTimeToLive = zzcfi.zziwc;
            if (zzcfi.zziwd != null) {
                conditionalUserProperty.mExpiredEventName = zzcfi.zziwd.name;
                if (zzcfi.zziwd.zzixi != null) {
                    conditionalUserProperty.mExpiredEventParams = zzcfi.zziwd.zzixi.zzaym();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        zzbq.zzgi(str);
        zzavx();
        zza(str, str2, str3, bundle);
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzazc = zzawo().zzazc();
            return zzazc != null ? Tasks.forResult(zzazc) : Tasks.call(zzawm().zzazi(), new zzciv(this));
        } catch (Exception e) {
            zzawn().zzayu().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return zzk((String) null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        zzbq.zzgi(str);
        zzavx();
        return zzk(str, str2, str3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        zzbq.zzgi(str);
        zzavx();
        return zzb(str, str2, str3, z);
    }

    public final void registerOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzwu();
        zzbq.checkNotNull(onEventListener);
        if (!this.zzjeo.add(onEventListener)) {
            zzawn().zzayu().log("OnEventListener already registered");
        }
    }

    public final void resetAnalyticsData() {
        zzawm().zzg(new zzcix(this));
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbq.checkNotNull(conditionalUserProperty);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzawn().zzayu().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbq.checkNotNull(conditionalUserProperty);
        zzbq.zzgi(conditionalUserProperty.mAppId);
        zzavx();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    @WorkerThread
    public final void setEventInterceptor(AppMeasurement.EventInterceptor eventInterceptor) {
        zzut();
        zzwu();
        if (!(eventInterceptor == null || eventInterceptor == this.zzjen)) {
            zzbq.zza(this.zzjen == null, (Object) "EventInterceptor already set.");
        }
        this.zzjen = eventInterceptor;
    }

    public final void setMeasurementEnabled(boolean z) {
        zzwu();
        zzawm().zzg(new zzcil(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzawm().zzg(new zzciq(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzawm().zzg(new zzcir(this, j));
    }

    public final void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzwu();
        zzbq.checkNotNull(onEventListener);
        if (!this.zzjeo.remove(onEventListener)) {
            zzawn().zzayu().log("OnEventListener had not been registered");
        }
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, j, bundle, false, true, true, (String) null);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, true, this.zzjen == null || zzckn.zzkd(str2), true, (String) null);
    }

    public final /* bridge */ /* synthetic */ void zzavx() {
        super.zzavx();
    }

    public final /* bridge */ /* synthetic */ void zzavy() {
        super.zzavy();
    }

    public final /* bridge */ /* synthetic */ zzcfa zzavz() {
        return super.zzavz();
    }

    public final /* bridge */ /* synthetic */ zzcfh zzawa() {
        return super.zzawa();
    }

    public final /* bridge */ /* synthetic */ zzcik zzawb() {
        return super.zzawb();
    }

    public final /* bridge */ /* synthetic */ zzcge zzawc() {
        return super.zzawc();
    }

    public final /* bridge */ /* synthetic */ zzcfr zzawd() {
        return super.zzawd();
    }

    public final /* bridge */ /* synthetic */ zzcjd zzawe() {
        return super.zzawe();
    }

    public final /* bridge */ /* synthetic */ zzciz zzawf() {
        return super.zzawf();
    }

    public final /* bridge */ /* synthetic */ zzcgf zzawg() {
        return super.zzawg();
    }

    public final /* bridge */ /* synthetic */ zzcfl zzawh() {
        return super.zzawh();
    }

    public final /* bridge */ /* synthetic */ zzcgh zzawi() {
        return super.zzawi();
    }

    public final /* bridge */ /* synthetic */ zzckn zzawj() {
        return super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzchd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzche zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzcgj zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzcfk zzawp() {
        return super.zzawp();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return false;
    }

    @Nullable
    public final String zzazc() {
        return this.zzjeq.get();
    }

    public final void zzb(String str, String str2, Object obj) {
        int i = 0;
        zzbq.zzgi(str);
        long currentTimeMillis = zzwh().currentTimeMillis();
        int zzjy = zzawj().zzjy(str2);
        if (zzjy != 0) {
            zzawj();
            String zza = zzckn.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzitu.zzawj().zza(zzjy, "_ev", zza, i);
        } else if (obj != null) {
            int zzl = zzawj().zzl(str2, obj);
            if (zzl != 0) {
                zzawj();
                String zza2 = zzckn.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzitu.zzawj().zza(zzl, "_ev", zza2, i);
                return;
            }
            Object zzm = zzawj().zzm(str2, obj);
            if (zzm != null) {
                zza(str, str2, currentTimeMillis, zzm);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final String zzbc(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzawm().zzg(new zzciw(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzawn().zzayu().log("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final List<zzckk> zzbp(boolean z) {
        zzwu();
        zzawn().zzayx().log("Fetching user attributes (FE)");
        if (zzawm().zzazh()) {
            zzawn().zzays().log("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzawm();
        if (zzche.zzas()) {
            zzawn().zzays().log("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzitu.zzawm().zzg(new zzciu(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzawn().zzayu().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<zzckk> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzawn().zzayu().log("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, this.zzjen == null || zzckn.zzkd(str2), false, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzjk(@Nullable String str) {
        this.zzjeq.set(str);
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
