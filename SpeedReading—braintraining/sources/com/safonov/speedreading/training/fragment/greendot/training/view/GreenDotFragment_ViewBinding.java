package com.safonov.speedreading.training.fragment.greendot.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class GreenDotFragment_ViewBinding implements Unbinder {
    private GreenDotFragment target;

    @UiThread
    public GreenDotFragment_ViewBinding(GreenDotFragment target2, View source) {
        this.target = target2;
        target2.greenDotTextView = (GreenDotTextView) Utils.findRequiredViewAsType(source, R.id.green_dot_text_view, "field 'greenDotTextView'", GreenDotTextView.class);
        target2.greenDotText = source.getContext().getResources().getString(R.string.green_dot_text);
    }

    @CallSuper
    public void unbind() {
        GreenDotFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.greenDotTextView = null;
    }
}
