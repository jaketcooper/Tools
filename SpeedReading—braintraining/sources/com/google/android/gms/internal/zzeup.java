package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzeup {
    private static final AtomicReference<zzeup> zzlxc = new AtomicReference<>();

    private zzeup(Context context) {
    }

    @Nullable
    public static zzeup zzcht() {
        return zzlxc.get();
    }

    public static Set<String> zzchu() {
        return Collections.emptySet();
    }

    public static zzeup zzew(Context context) {
        zzlxc.compareAndSet((Object) null, new zzeup(context));
        return zzlxc.get();
    }

    public static void zzf(@NonNull FirebaseApp firebaseApp) {
    }

    public static FirebaseOptions zzrb(@NonNull String str) {
        return null;
    }
}
