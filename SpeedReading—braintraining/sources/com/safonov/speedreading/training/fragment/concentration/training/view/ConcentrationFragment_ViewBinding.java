package com.safonov.speedreading.training.fragment.concentration.training.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class ConcentrationFragment_ViewBinding implements Unbinder {
    private ConcentrationFragment target;

    @UiThread
    public ConcentrationFragment_ViewBinding(ConcentrationFragment target2, View source) {
        this.target = target2;
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.concentration_score_text_view, "field 'scoreTextView'", TextView.class);
        target2.recordTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.concentration_record_text_view, "field 'recordTextView'", TextView.class);
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.concentration_progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.circlesContatiner = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.circles_container, "field 'circlesContatiner'", LinearLayout.class);
        target2.layout = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.concentration_statistics_layout, "field 'layout'", LinearLayout.class);
        target2.concentrationPointsTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.concentration_points_text_view, "field 'concentrationPointsTextView'", TextView.class);
    }

    @CallSuper
    public void unbind() {
        ConcentrationFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.scoreTextView = null;
        target2.recordTextView = null;
        target2.progressBar = null;
        target2.circlesContatiner = null;
        target2.layout = null;
        target2.concentrationPointsTextView = null;
    }
}
