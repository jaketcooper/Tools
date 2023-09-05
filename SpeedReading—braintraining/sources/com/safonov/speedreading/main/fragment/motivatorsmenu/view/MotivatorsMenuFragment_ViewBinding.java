package com.safonov.speedreading.main.fragment.motivatorsmenu.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class MotivatorsMenuFragment_ViewBinding implements Unbinder {
    private MotivatorsMenuFragment target;
    private View view2131296374;
    private View view2131296523;
    private View view2131296524;
    private View view2131296606;
    private View view2131296633;

    @UiThread
    public MotivatorsMenuFragment_ViewBinding(final MotivatorsMenuFragment target2, View source) {
        this.target = target2;
        View view = Utils.findRequiredView(source, R.id.motivators_speed_reading_book_view, "field 'speedReadingBookView' and method 'onSpeedReadingBookClick'");
        target2.speedReadingBookView = (ConstraintLayout) Utils.castView(view, R.id.motivators_speed_reading_book_view, "field 'speedReadingBookView'", ConstraintLayout.class);
        this.view2131296523 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onSpeedReadingBookClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.description_view, "method 'onDescriptionClick'");
        this.view2131296374 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onDescriptionClick();
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.recommendation_view, "method 'onRecommendationsClick'");
        this.view2131296606 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onRecommendationsClick();
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.rules_of_success_view, "method 'onRulesOfSuccessClick'");
        this.view2131296633 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onRulesOfSuccessClick();
            }
        });
        View view5 = Utils.findRequiredView(source, R.id.motivators_view, "method 'onMotivatorsClick'");
        this.view2131296524 = view5;
        view5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onMotivatorsClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        MotivatorsMenuFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.speedReadingBookView = null;
        this.view2131296523.setOnClickListener((View.OnClickListener) null);
        this.view2131296523 = null;
        this.view2131296374.setOnClickListener((View.OnClickListener) null);
        this.view2131296374 = null;
        this.view2131296606.setOnClickListener((View.OnClickListener) null);
        this.view2131296606 = null;
        this.view2131296633.setOnClickListener((View.OnClickListener) null);
        this.view2131296633 = null;
        this.view2131296524.setOnClickListener((View.OnClickListener) null);
        this.view2131296524 = null;
    }
}
