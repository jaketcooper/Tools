package com.safonov.speedreading.training.fragment.math.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class MathFragment_ViewBinding implements Unbinder {
    private MathFragment target;
    private View view2131296504;
    private View view2131296505;
    private View view2131296506;
    private View view2131296507;

    @UiThread
    public MathFragment_ViewBinding(final MathFragment target2, View source) {
        this.target = target2;
        target2.expressionTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.mathematics_expression_text_view, "field 'expressionTextView'", TextView.class);
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.mathematics_score_text_view, "field 'scoreTextView'", TextView.class);
        target2.recordTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.mathematics_record_text_view, "field 'recordTextView'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.mathematics_progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.timerBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.mathematics_timer_bar, "field 'timerBar'", ProgressBar.class);
        target2.mathPointsTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.math_points_text_view, "field 'mathPointsTextView'", TextView.class);
        target2.correctAnswerTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.math_correct_answer_text_view, "field 'correctAnswerTextView'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.mathematics_button_1, "method 'onNumberButtonClick'");
        this.view2131296504 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.mathematics_button_2, "method 'onNumberButtonClick'");
        this.view2131296505 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.mathematics_button_3, "method 'onNumberButtonClick'");
        this.view2131296506 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.mathematics_button_4, "method 'onNumberButtonClick'");
        this.view2131296507 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((Button) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        target2.buttons = Utils.listOf((Button) Utils.findRequiredViewAsType(source, R.id.mathematics_button_1, "field 'buttons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.mathematics_button_2, "field 'buttons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.mathematics_button_3, "field 'buttons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.mathematics_button_4, "field 'buttons'", Button.class));
    }

    @CallSuper
    public void unbind() {
        MathFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.expressionTextView = null;
        target2.scoreTextView = null;
        target2.recordTextView = null;
        target2.progressBar = null;
        target2.timerBar = null;
        target2.mathPointsTextView = null;
        target2.correctAnswerTextView = null;
        target2.buttons = null;
        this.view2131296504.setOnClickListener((View.OnClickListener) null);
        this.view2131296504 = null;
        this.view2131296505.setOnClickListener((View.OnClickListener) null);
        this.view2131296505 = null;
        this.view2131296506.setOnClickListener((View.OnClickListener) null);
        this.view2131296506 = null;
        this.view2131296507.setOnClickListener((View.OnClickListener) null);
        this.view2131296507 = null;
    }
}
