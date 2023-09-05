package com.safonov.speedreading.training.fragment.aceeleratorcourse.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class AcceleratorCourseResultFragment_ViewBinding implements Unbinder {
    private AcceleratorCourseResultFragment target;

    @UiThread
    public AcceleratorCourseResultFragment_ViewBinding(AcceleratorCourseResultFragment target2, View source) {
        this.target = target2;
        target2.durationTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.duration_text_view, "field 'durationTextView'", TextView.class);
    }

    @CallSuper
    public void unbind() {
        AcceleratorCourseResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.durationTextView = null;
    }
}
