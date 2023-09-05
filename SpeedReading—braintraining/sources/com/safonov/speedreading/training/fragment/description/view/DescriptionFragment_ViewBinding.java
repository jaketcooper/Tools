package com.safonov.speedreading.training.fragment.description.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class DescriptionFragment_ViewBinding implements Unbinder {
    private DescriptionFragment target;
    private View view2131296373;

    @UiThread
    public DescriptionFragment_ViewBinding(final DescriptionFragment target2, View source) {
        this.target = target2;
        target2.contentHolderScrollView = (ScrollView) Utils.findRequiredViewAsType(source, R.id.description_content_holder_scroll_view, "field 'contentHolderScrollView'", ScrollView.class);
        View view = Utils.findRequiredView(source, R.id.description_start_training_button, "method 'onStartTrainingClick'");
        this.view2131296373 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartTrainingClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        DescriptionFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.contentHolderScrollView = null;
        this.view2131296373.setOnClickListener((View.OnClickListener) null);
        this.view2131296373 = null;
    }
}
