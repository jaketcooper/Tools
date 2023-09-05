package com.safonov.speedreading.training.fragment.help.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ScrollView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class HelpFragment_ViewBinding implements Unbinder {
    private HelpFragment target;

    @UiThread
    public HelpFragment_ViewBinding(HelpFragment target2, View source) {
        this.target = target2;
        target2.contentHolderScrollView = (ScrollView) Utils.findRequiredViewAsType(source, R.id.help_content_holder_scroll_view, "field 'contentHolderScrollView'", ScrollView.class);
    }

    @CallSuper
    public void unbind() {
        HelpFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.contentHolderScrollView = null;
    }
}
