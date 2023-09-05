package com.safonov.speedreading.training.fragment.concentration.complexity.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class ConcentrationComplexityFragment_ViewBinding implements Unbinder {
    private ConcentrationComplexityFragment target;
    private View view2131296345;
    private View view2131296346;

    @UiThread
    public ConcentrationComplexityFragment_ViewBinding(final ConcentrationComplexityFragment target2, View source) {
        this.target = target2;
        View view = Utils.findRequiredView(source, R.id.concentration_complexity_button_1, "method 'setComplexityFirst'");
        this.view2131296345 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.setComplexityFirst((TextView) Utils.castParam(p0, "doClick", 0, "setComplexityFirst", 0));
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.concentration_complexity_button_2, "method 'setComplexitySecond'");
        this.view2131296346 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.setComplexitySecond((TextView) Utils.castParam(p0, "doClick", 0, "setComplexitySecond", 0));
            }
        });
    }

    @CallSuper
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view2131296345.setOnClickListener((View.OnClickListener) null);
        this.view2131296345 = null;
        this.view2131296346.setOnClickListener((View.OnClickListener) null);
        this.view2131296346 = null;
    }
}
