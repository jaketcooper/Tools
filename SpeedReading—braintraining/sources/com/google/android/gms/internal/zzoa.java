package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

public interface zzoa {
    Context getContext();

    void performClick(Bundle bundle);

    boolean recordImpression(Bundle bundle);

    void reportTouchEvent(Bundle bundle);

    View zza(View.OnClickListener onClickListener, boolean z);

    void zza(View view, zzny zzny);

    void zza(View view, String str, Bundle bundle, Map<String, WeakReference<View>> map, View view2);

    void zza(View view, Map<String, WeakReference<View>> map);

    void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2);

    void zzb(View view, Map<String, WeakReference<View>> map);

    void zzc(View view, Map<String, WeakReference<View>> map);

    void zzd(MotionEvent motionEvent);

    void zzg(View view);

    boolean zzjw();

    boolean zzjx();

    void zzkb();

    void zzkc();

    View zzkd();
}
