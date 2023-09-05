package com.safonov.speedreading.training.fragment.schultetable.passcourseresult.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class SchulteTablePassCourseResultFragment_ViewBinding implements Unbinder {
    private SchulteTablePassCourseResultFragment target;
    private View view2131296542;

    @UiThread
    public SchulteTablePassCourseResultFragment_ViewBinding(final SchulteTablePassCourseResultFragment target2, View source) {
        this.target = target2;
        target2.timeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.time_text_view, "field 'timeTextView'", TextView.class);
        target2.bestTimeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.best_time_text_view, "field 'bestTimeTextView'", TextView.class);
        target2.newBestTimeView = (ImageView) Utils.findRequiredViewAsType(source, R.id.new_best_time_image_view, "field 'newBestTimeView'", ImageView.class);
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
        SchulteTablePassCourseResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.timeTextView = null;
        target2.bestTimeTextView = null;
        target2.newBestTimeView = null;
        target2.passCourseScoreTextView = null;
        target2.nextButton = null;
        this.view2131296542.setOnClickListener((View.OnClickListener) null);
        this.view2131296542 = null;
    }
}
