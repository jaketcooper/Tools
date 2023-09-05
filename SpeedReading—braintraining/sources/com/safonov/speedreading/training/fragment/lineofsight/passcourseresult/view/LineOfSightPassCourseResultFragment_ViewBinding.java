package com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class LineOfSightPassCourseResultFragment_ViewBinding implements Unbinder {
    private LineOfSightPassCourseResultFragment target;
    private View view2131296542;

    @UiThread
    public LineOfSightPassCourseResultFragment_ViewBinding(final LineOfSightPassCourseResultFragment target2, View source) {
        this.target = target2;
        target2.mistakesTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.mistakes_text_view, "field 'mistakesTextView'", TextView.class);
        target2.foundMistakesTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.found_mistakes_text_view, "field 'foundMistakesTextView'", TextView.class);
        target2.foundMistakesPercentTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.accuracy_text_view, "field 'foundMistakesPercentTextView'", TextView.class);
        target2.passCourseScoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.pass_course_score_text_view, "field 'passCourseScoreTextView'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.next_button, "field 'nextButton' and method 'onNextClick'");
        target2.nextButton = (Button) Utils.castView(view, R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131296542 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onNextClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        LineOfSightPassCourseResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.mistakesTextView = null;
        target2.foundMistakesTextView = null;
        target2.foundMistakesPercentTextView = null;
        target2.passCourseScoreTextView = null;
        target2.nextButton = null;
        this.view2131296542.setOnClickListener((View.OnClickListener) null);
        this.view2131296542 = null;
    }
}
