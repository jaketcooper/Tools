package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzzb;

@zzzb
public final class zzi {
    public final int index;
    public final ViewGroup parent;
    public final Context zzaif;
    public final ViewGroup.LayoutParams zzchd;

    public zzi(zzama zzama) throws zzg {
        this.zzchd = zzama.getLayoutParams();
        ViewParent parent2 = zzama.getParent();
        this.zzaif = zzama.zzsl();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        this.parent = (ViewGroup) parent2;
        ViewGroup viewGroup = this.parent;
        if (zzama == null) {
            throw null;
        }
        this.index = viewGroup.indexOfChild((View) zzama);
        ViewGroup viewGroup2 = this.parent;
        if (zzama == null) {
            throw null;
        }
        viewGroup2.removeView((View) zzama);
        zzama.zzac(true);
    }
}
