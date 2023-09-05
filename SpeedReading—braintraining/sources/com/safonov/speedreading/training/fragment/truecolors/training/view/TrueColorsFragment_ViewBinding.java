package com.safonov.speedreading.training.fragment.truecolors.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class TrueColorsFragment_ViewBinding implements Unbinder {
    private TrueColorsFragment target;
    private View view2131296814;
    private View view2131296815;
    private View view2131296816;
    private View view2131296817;

    @UiThread
    public TrueColorsFragment_ViewBinding(final TrueColorsFragment target2, View source) {
        this.target = target2;
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.true_colors_score_text_view, "field 'scoreTextView'", TextView.class);
        target2.recordTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.true_colors_record_text_view, "field 'recordTextView'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.true_colors_progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.answerImageView = (ImageView) Utils.findRequiredViewAsType(source, R.id.iv_answer, "field 'answerImageView'", ImageView.class);
        target2.timerBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.true_colors_timer_bar, "field 'timerBar'", ProgressBar.class);
        target2.questionTV = (TextView) Utils.findRequiredViewAsType(source, R.id.true_colors_question_tv, "field 'questionTV'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.true_colors_answer_tv_1, "method 'onNumberButtonClick'");
        this.view2131296814 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((TextView) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.true_colors_answer_tv_2, "method 'onNumberButtonClick'");
        this.view2131296815 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((TextView) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.true_colors_answer_tv_3, "method 'onNumberButtonClick'");
        this.view2131296816 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((TextView) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.true_colors_answer_tv_4, "method 'onNumberButtonClick'");
        this.view2131296817 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNumberButtonClick((TextView) Utils.castParam(p0, "doClick", 0, "onNumberButtonClick", 0));
            }
        });
        target2.answerButtons = Utils.listOf((TextView) Utils.findRequiredViewAsType(source, R.id.true_colors_answer_tv_1, "field 'answerButtons'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.true_colors_answer_tv_2, "field 'answerButtons'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.true_colors_answer_tv_3, "field 'answerButtons'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.true_colors_answer_tv_4, "field 'answerButtons'", TextView.class));
    }

    @CallSuper
    public void unbind() {
        TrueColorsFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.scoreTextView = null;
        target2.recordTextView = null;
        target2.progressBar = null;
        target2.answerImageView = null;
        target2.timerBar = null;
        target2.questionTV = null;
        target2.answerButtons = null;
        this.view2131296814.setOnClickListener((View.OnClickListener) null);
        this.view2131296814 = null;
        this.view2131296815.setOnClickListener((View.OnClickListener) null);
        this.view2131296815 = null;
        this.view2131296816.setOnClickListener((View.OnClickListener) null);
        this.view2131296816 = null;
        this.view2131296817.setOnClickListener((View.OnClickListener) null);
        this.view2131296817 = null;
    }
}
