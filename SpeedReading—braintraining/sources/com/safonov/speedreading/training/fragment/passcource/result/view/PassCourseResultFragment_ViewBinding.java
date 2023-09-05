package com.safonov.speedreading.training.fragment.passcource.result.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class PassCourseResultFragment_ViewBinding implements Unbinder {
    private PassCourseResultFragment target;

    @UiThread
    public PassCourseResultFragment_ViewBinding(PassCourseResultFragment target2, View source) {
        this.target = target2;
        target2.layout = (LinearLayout) Utils.findRequiredViewAsType(source, R.id.pass_course_result_result_layout, "field 'layout'", LinearLayout.class);
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.chartLine1Color = ContextCompat.getColor(context, R.color.result_chart_line_1_color);
        target2.chartItem1Color = ContextCompat.getColor(context, R.color.result_chart_item_1_color);
        target2.chartLine2Color = ContextCompat.getColor(context, R.color.result_chart_line_2_color);
        target2.chartItem2Color = ContextCompat.getColor(context, R.color.result_chart_item_2_color);
        target2.chartItemCircleRadiusDp = res.getInteger(R.integer.result_chart_item_circle_radius_dp);
        target2.chartItemValueTextSizeDp = res.getInteger(R.integer.result_chart_item_value_text_size_dp);
        target2.chartLineWidthDp = res.getInteger(R.integer.result_chart_line_width_dp);
    }

    @CallSuper
    public void unbind() {
        PassCourseResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.layout = null;
    }
}
