package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;

public final class zzr extends zzl {
    private Fragment zzguf;

    private zzr(Fragment fragment) {
        this.zzguf = fragment;
    }

    public static zzr zza(Fragment fragment) {
        if (fragment != null) {
            return new zzr(fragment);
        }
        return null;
    }

    public final Bundle getArguments() {
        return this.zzguf.getArguments();
    }

    public final int getId() {
        return this.zzguf.getId();
    }

    public final boolean getRetainInstance() {
        return this.zzguf.getRetainInstance();
    }

    public final String getTag() {
        return this.zzguf.getTag();
    }

    public final int getTargetRequestCode() {
        return this.zzguf.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.zzguf.getUserVisibleHint();
    }

    public final IObjectWrapper getView() {
        return zzn.zzy(this.zzguf.getView());
    }

    public final boolean isAdded() {
        return this.zzguf.isAdded();
    }

    public final boolean isDetached() {
        return this.zzguf.isDetached();
    }

    public final boolean isHidden() {
        return this.zzguf.isHidden();
    }

    public final boolean isInLayout() {
        return this.zzguf.isInLayout();
    }

    public final boolean isRemoving() {
        return this.zzguf.isRemoving();
    }

    public final boolean isResumed() {
        return this.zzguf.isResumed();
    }

    public final boolean isVisible() {
        return this.zzguf.isVisible();
    }

    public final void setHasOptionsMenu(boolean z) {
        this.zzguf.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.zzguf.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.zzguf.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.zzguf.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.zzguf.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.zzguf.startActivityForResult(intent, i);
    }

    public final IObjectWrapper zzapm() {
        return zzn.zzy(this.zzguf.getActivity());
    }

    public final zzk zzapn() {
        return zza(this.zzguf.getParentFragment());
    }

    public final IObjectWrapper zzapo() {
        return zzn.zzy(this.zzguf.getResources());
    }

    public final zzk zzapp() {
        return zza(this.zzguf.getTargetFragment());
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzguf.registerForContextMenu((View) zzn.zzx(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzguf.unregisterForContextMenu((View) zzn.zzx(iObjectWrapper));
    }
}
