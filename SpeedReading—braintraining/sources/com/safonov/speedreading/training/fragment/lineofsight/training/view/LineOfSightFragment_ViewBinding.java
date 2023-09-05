package com.safonov.speedreading.training.fragment.lineofsight.training.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class LineOfSightFragment_ViewBinding implements Unbinder {
    private LineOfSightFragment target;
    private View view2131296477;

    @UiThread
    public LineOfSightFragment_ViewBinding(final LineOfSightFragment target2, View source) {
        this.target = target2;
        target2.progressBar = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.line_of_sight_progress_bar, "field 'progressBar'", ProgressBar.class);
        target2.gridLayout = (GridLayout) Utils.findRequiredViewAsType(source, R.id.line_of_sight_grid_layout, "field 'gridLayout'", GridLayout.class);
        View view = Utils.findRequiredView(source, R.id.line_of_sight_check_button, "field 'checkButton' and method 'onCheckButtonClick'");
        target2.checkButton = (Button) Utils.castView(view, R.id.line_of_sight_check_button, "field 'checkButton'", Button.class);
        this.view2131296477 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onCheckButtonClick();
            }
        });
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.backgroundWhiteColor = ContextCompat.getColor(context, R.color.background_white);
        target2.textColorBlack = ContextCompat.getColor(context, 17170435);
        target2.greenColor = ContextCompat.getColor(context, R.color.accept_green);
        target2.white = ContextCompat.getColor(context, R.color.white);
        target2.boardItemHeight = res.getDimensionPixelSize(R.dimen.line_of_sight_board_item_height);
        target2.boardWidth = res.getDimensionPixelSize(R.dimen.line_of_sight_board_width);
    }

    @CallSuper
    public void unbind() {
        LineOfSightFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.progressBar = null;
        target2.gridLayout = null;
        target2.checkButton = null;
        this.view2131296477.setOnClickListener((View.OnClickListener) null);
        this.view2131296477 = null;
    }
}
