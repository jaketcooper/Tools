package com.safonov.speedreading.training.fragment.cuptimer.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class CupTimerFragment_ViewBinding implements Unbinder {
    private CupTimerFragment target;

    @UiThread
    public CupTimerFragment_ViewBinding(CupTimerFragment target2, View source) {
        this.target = target2;
        target2.timerBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.cup_timer_progress_bar, "field 'timerBar'", ProgressBar.class);
        target2.previewTitle = (TextView) Utils.findRequiredViewAsType(source, R.id.preview_title, "field 'previewTitle'", TextView.class);
        target2.imageView = (ImageView) Utils.findRequiredViewAsType(source, R.id.iv_faces, "field 'imageView'", ImageView.class);
    }

    @CallSuper
    public void unbind() {
        CupTimerFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.timerBar = null;
        target2.previewTitle = null;
        target2.imageView = null;
    }
}
