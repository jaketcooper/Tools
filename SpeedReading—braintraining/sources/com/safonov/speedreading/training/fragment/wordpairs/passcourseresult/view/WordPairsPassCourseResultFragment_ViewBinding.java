package com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.view;

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

public class WordPairsPassCourseResultFragment_ViewBinding implements Unbinder {
    private WordPairsPassCourseResultFragment target;
    private View view2131296542;

    @UiThread
    public WordPairsPassCourseResultFragment_ViewBinding(final WordPairsPassCourseResultFragment target2, View source) {
        this.target = target2;
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.score_text_view, "field 'scoreTextView'", TextView.class);
        target2.bestScoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.best_score_text_view, "field 'bestScoreTextView'", TextView.class);
        target2.newBestScoreView = (ImageView) Utils.findRequiredViewAsType(source, R.id.new_best_score_image_view, "field 'newBestScoreView'", ImageView.class);
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
        WordPairsPassCourseResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.scoreTextView = null;
        target2.bestScoreTextView = null;
        target2.newBestScoreView = null;
        target2.passCourseScoreTextView = null;
        target2.nextButton = null;
        this.view2131296542.setOnClickListener((View.OnClickListener) null);
        this.view2131296542 = null;
    }
}
