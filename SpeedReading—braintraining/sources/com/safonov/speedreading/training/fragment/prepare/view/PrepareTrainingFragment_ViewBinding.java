package com.safonov.speedreading.training.fragment.prepare.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class PrepareTrainingFragment_ViewBinding implements Unbinder {
    private PrepareTrainingFragment target;

    @UiThread
    public PrepareTrainingFragment_ViewBinding(PrepareTrainingFragment target2, View source) {
        this.target = target2;
        target2.circularProgressBar = (CircularProgressBar) Utils.findRequiredViewAsType(source, R.id.prepare_circular_progress_bar, "field 'circularProgressBar'", CircularProgressBar.class);
    }

    @CallSuper
    public void unbind() {
        PrepareTrainingFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.circularProgressBar = null;
    }
}
