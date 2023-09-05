package com.safonov.speedreading.training.fragment.rememberwords.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class RememberWordsFragment_ViewBinding implements Unbinder {
    private RememberWordsFragment target;

    @UiThread
    public RememberWordsFragment_ViewBinding(RememberWordsFragment target2, View source) {
        this.target = target2;
        target2.score = (TextView) Utils.findRequiredViewAsType(source, R.id.focus_attention_score, "field 'score'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.focus_attention_progress, "field 'progressBar'", ProgressBar.class);
        target2.statisticsLayout = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.focus_attention_statistics, "field 'statisticsLayout'", LinearLayout.class);
        target2.wordsLayout = (TableLayout) Utils.findRequiredViewAsType(source, R.id.words_layout, "field 'wordsLayout'", TableLayout.class);
        target2.tableLayout = (TableLayout) Utils.findRequiredViewAsType(source, R.id.tableLayout, "field 'tableLayout'", TableLayout.class);
        target2.answerLayout = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.answer_layout, "field 'answerLayout'", LinearLayout.class);
        target2.answersContainer = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.answerLineContainer, "field 'answersContainer'", LinearLayout.class);
        target2.scrollView = (HorizontalScrollView) Utils.findRequiredViewAsType(source, R.id.horizontalScrollView, "field 'scrollView'", HorizontalScrollView.class);
        target2.recordTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.focus_attention_record, "field 'recordTextView'", TextView.class);
        target2.pointsTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.points_text_view, "field 'pointsTextView'", TextView.class);
    }

    @CallSuper
    public void unbind() {
        RememberWordsFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.score = null;
        target2.progressBar = null;
        target2.statisticsLayout = null;
        target2.wordsLayout = null;
        target2.tableLayout = null;
        target2.answerLayout = null;
        target2.answersContainer = null;
        target2.scrollView = null;
        target2.recordTextView = null;
        target2.pointsTextView = null;
    }
}
