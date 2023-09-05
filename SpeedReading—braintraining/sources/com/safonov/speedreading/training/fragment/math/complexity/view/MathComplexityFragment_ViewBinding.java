package com.safonov.speedreading.training.fragment.math.complexity.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class MathComplexityFragment_ViewBinding implements Unbinder {
    private MathComplexityFragment target;
    private View view2131296495;
    private View view2131296496;
    private View view2131296497;
    private View view2131296498;

    @UiThread
    public MathComplexityFragment_ViewBinding(final MathComplexityFragment target2, View source) {
        this.target = target2;
        View view = Utils.findRequiredView(source, R.id.math_complexity_button_1, "field 'complexityButton1' and method 'setComplexityFirst'");
        target2.complexityButton1 = (TextView) Utils.castView(view, R.id.math_complexity_button_1, "field 'complexityButton1'", TextView.class);
        this.view2131296495 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.setComplexityFirst((TextView) Utils.castParam(p0, "doClick", 0, "setComplexityFirst", 0));
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.math_complexity_button_2, "field 'complexityButton2' and method 'setComplexitySecond'");
        target2.complexityButton2 = (TextView) Utils.castView(view2, R.id.math_complexity_button_2, "field 'complexityButton2'", TextView.class);
        this.view2131296496 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.setComplexitySecond((TextView) Utils.castParam(p0, "doClick", 0, "setComplexitySecond", 0));
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.math_complexity_button_3, "field 'complexityButton3' and method 'setComplexityThird'");
        target2.complexityButton3 = (TextView) Utils.castView(view3, R.id.math_complexity_button_3, "field 'complexityButton3'", TextView.class);
        this.view2131296497 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.setComplexityThird((TextView) Utils.castParam(p0, "doClick", 0, "setComplexityThird", 0));
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.math_complexity_button_4, "method 'setComplexityFourth'");
        this.view2131296498 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.setComplexityFourth((TextView) Utils.castParam(p0, "doClick", 0, "setComplexityFourth", 0));
            }
        });
    }

    @CallSuper
    public void unbind() {
        MathComplexityFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.complexityButton1 = null;
        target2.complexityButton2 = null;
        target2.complexityButton3 = null;
        this.view2131296495.setOnClickListener((View.OnClickListener) null);
        this.view2131296495 = null;
        this.view2131296496.setOnClickListener((View.OnClickListener) null);
        this.view2131296496 = null;
        this.view2131296497.setOnClickListener((View.OnClickListener) null);
        this.view2131296497 = null;
        this.view2131296498.setOnClickListener((View.OnClickListener) null);
        this.view2131296498 = null;
    }
}
