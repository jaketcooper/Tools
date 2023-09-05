package com.safonov.speedreading.training.fragment.speedreading.training.view;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class SpeedReadingFragment_ViewBinding implements Unbinder {
    private SpeedReadingFragment target;
    private View view2131296683;
    private View view2131296684;
    private View view2131296685;
    private View view2131296686;
    private View view2131296687;
    private View view2131296688;

    @UiThread
    public SpeedReadingFragment_ViewBinding(final SpeedReadingFragment target2, View source) {
        this.target = target2;
        target2.statisticsView = Utils.findRequiredView(source, R.id.speed_reading_statistics_layout, "field 'statisticsView'");
        target2.speedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_speed_text_view, "field 'speedTextView'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.speed_reading_progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.wordsView = Utils.findRequiredView(source, R.id.speed_reading_words_view, "field 'wordsView'");
        target2.answerGridLayout = (GridLayout) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_grid_layout, "field 'answerGridLayout'", GridLayout.class);
        target2.answerSpeedTitleTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_speed_title_text_view, "field 'answerSpeedTitleTextView'", TextView.class);
        target2.answerSpeedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_speed_text_view, "field 'answerSpeedTextView'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.speed_reading_answer_button_1, "method 'onAnswerButtonClick'");
        this.view2131296683 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAnswerButtonClick(p0);
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.speed_reading_answer_button_2, "method 'onAnswerButtonClick'");
        this.view2131296684 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAnswerButtonClick(p0);
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.speed_reading_answer_button_3, "method 'onAnswerButtonClick'");
        this.view2131296685 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAnswerButtonClick(p0);
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.speed_reading_answer_button_4, "method 'onAnswerButtonClick'");
        this.view2131296686 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAnswerButtonClick(p0);
            }
        });
        View view5 = Utils.findRequiredView(source, R.id.speed_reading_answer_button_5, "method 'onAnswerButtonClick'");
        this.view2131296687 = view5;
        view5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAnswerButtonClick(p0);
            }
        });
        View view6 = Utils.findRequiredView(source, R.id.speed_reading_answer_button_6, "method 'onAnswerButtonClick'");
        this.view2131296688 = view6;
        view6.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAnswerButtonClick(p0);
            }
        });
        target2.wordsTextViewList = Utils.listOf((TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_1, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_2, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_3, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_4, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_5, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_6, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_7, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_8, "field 'wordsTextViewList'", TextView.class), (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_word_view_9, "field 'wordsTextViewList'", TextView.class));
        target2.answerButtons = Utils.listOf((Button) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_button_1, "field 'answerButtons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_button_2, "field 'answerButtons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_button_3, "field 'answerButtons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_button_4, "field 'answerButtons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_button_5, "field 'answerButtons'", Button.class), (Button) Utils.findRequiredViewAsType(source, R.id.speed_reading_answer_button_6, "field 'answerButtons'", Button.class));
        Context context = source.getContext();
        target2.textColorBlack = ContextCompat.getColor(context, 17170435);
        target2.greenColor = ContextCompat.getColor(context, R.color.accept_green);
        target2.redColor = ContextCompat.getColor(context, R.color.reject_red);
    }

    @CallSuper
    public void unbind() {
        SpeedReadingFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.statisticsView = null;
        target2.speedTextView = null;
        target2.progressBar = null;
        target2.wordsView = null;
        target2.answerGridLayout = null;
        target2.answerSpeedTitleTextView = null;
        target2.answerSpeedTextView = null;
        target2.wordsTextViewList = null;
        target2.answerButtons = null;
        this.view2131296683.setOnClickListener((View.OnClickListener) null);
        this.view2131296683 = null;
        this.view2131296684.setOnClickListener((View.OnClickListener) null);
        this.view2131296684 = null;
        this.view2131296685.setOnClickListener((View.OnClickListener) null);
        this.view2131296685 = null;
        this.view2131296686.setOnClickListener((View.OnClickListener) null);
        this.view2131296686 = null;
        this.view2131296687.setOnClickListener((View.OnClickListener) null);
        this.view2131296687 = null;
        this.view2131296688.setOnClickListener((View.OnClickListener) null);
        this.view2131296688 = null;
    }
}
