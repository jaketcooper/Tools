package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

@SuppressLint({"NewApi"})
public final class zzj extends zzl {
    private Fragment zzguc;

    private zzj(Fragment fragment) {
        this.zzguc = fragment;
    }

    public static zzj zza(Fragment fragment) {
        if (fragment != null) {
            return new zzj(fragment);
        }
        return null;
    }

    public final Bundle getArguments() {
        return this.zzguc.getArguments();
    }

    public final int getId() {
        return this.zzguc.getId();
    }

    public final boolean getRetainInstance() {
        return this.zzguc.getRetainInstance();
    }

    public final String getTag() {
        return this.zzguc.getTag();
    }

    public final int getTargetRequestCode() {
        return this.zzguc.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.zzguc.getUserVisibleHint();
    }

    public final IObjectWrapper getView() {
        return zzn.zzy(this.zzguc.getView());
    }

    public final boolean isAdded() {
        return this.zzguc.isAdded();
    }

    public final boolean isDetached() {
        return this.zzguc.isDetached();
    }

    public final boolean isHidden() {
        return this.zzguc.isHidden();
    }

    public final boolean isInLayout() {
        return this.zzguc.isInLayout();
    }

    public final boolean isRemoving() {
        return this.zzguc.isRemoving();
    }

    public final boolean isResumed() {
        return this.zzguc.isResumed();
    }

    public final boolean isVisible() {
        return this.zzguc.isVisible();
    }

    public final void setHasOptionsMenu(boolean z) {
        this.zzguc.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.zzguc.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.zzguc.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.zzguc.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.zzguc.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.zzguc.startActivityForResult(intent, i);
    }

    public final IObjectWrapper zzapm() {
        return zzn.zzy(this.zzguc.getActivity());
    }

    public final zzk zzapn() {
        return zza(this.zzguc.getParentFragment());
    }

    public final IObjectWrapper zzapo() {
        return zzn.zzy(this.zzguc.getResources());
    }

    public final zzk zzapp() {
        return zza(this.zzguc.getTargetFragment());
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzguc.registerForContextMenu((View) zzn.zzx(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzguc.unregisterForContextMenu((View) zzn.zzx(iObjectWrapper));
    }
}
