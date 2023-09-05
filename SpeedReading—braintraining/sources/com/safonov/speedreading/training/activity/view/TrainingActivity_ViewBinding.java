package com.safonov.speedreading.training.activity.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class TrainingActivity_ViewBinding implements Unbinder {
    private TrainingActivity target;

    @UiThread
    public TrainingActivity_ViewBinding(TrainingActivity target2) {
        this(target2, target2.getWindow().getDecorView());
    }

    @UiThread
    public TrainingActivity_ViewBinding(TrainingActivity target2, View source) {
        this.target = target2;
        target2.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    @CallSuper
    public void unbind() {
        TrainingActivity target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.toolbar = null;
    }
}
