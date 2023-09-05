package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.util.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzdd extends Fragment implements zzci {
    private static WeakHashMap<FragmentActivity, WeakReference<zzdd>> zzfru = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public int zzbzn = 0;
    private Map<String, LifecycleCallback> zzfrv = new ArrayMap();
    /* access modifiers changed from: private */
    public Bundle zzfrw;

    public static zzdd zza(FragmentActivity fragmentActivity) {
        zzdd zzdd;
        WeakReference weakReference = zzfru.get(fragmentActivity);
        if (weakReference == null || (zzdd = (zzdd) weakReference.get()) == null) {
            try {
                zzdd = (zzdd) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (zzdd == null || zzdd.isRemoving()) {
                    zzdd = new zzdd();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzdd, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                zzfru.put(fragmentActivity, new WeakReference(zzdd));
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return zzdd;
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzfrv.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback onActivityResult : this.zzfrv.values()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzbzn = 1;
        this.zzfrw = bundle;
        for (Map.Entry next : this.zzfrv.entrySet()) {
            ((LifecycleCallback) next.getValue()).onCreate(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzbzn = 5;
        for (LifecycleCallback onDestroy : this.zzfrv.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzbzn = 3;
        for (LifecycleCallback onResume : this.zzfrv.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.zzfrv.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzbzn = 2;
        for (LifecycleCallback onStart : this.zzfrv.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzbzn = 4;
        for (LifecycleCallback onStop : this.zzfrv.values()) {
            onStop.onStop();
        }
    }

    public final <T extends LifecycleCallback> T zza(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.zzfrv.get(str));
    }

    public final void zza(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.zzfrv.containsKey(str)) {
            this.zzfrv.put(str, lifecycleCallback);
            if (this.zzbzn > 0) {
                new Handler(Looper.getMainLooper()).post(new zzde(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
    }

    public final /* synthetic */ Activity zzajc() {
        return getActivity();
    }
}
