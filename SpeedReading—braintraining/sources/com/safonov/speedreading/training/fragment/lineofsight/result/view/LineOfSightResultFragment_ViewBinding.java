package com.safonov.speedreading.training.fragment.lineofsight.result.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.LineChart;
import com.speedreading.alexander.speedreading.R;

public class LineOfSightResultFragment_ViewBinding implements Unbinder {
    private LineOfSightResultFragment target;

    @UiThread
    public LineOfSightResultFragment_ViewBinding(LineOfSightResultFragment target2, View source) {
        this.target = target2;
        target2.mistakesTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.mistakes_text_view, "field 'mistakesTextView'", TextView.class);
        target2.foundMistakesTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.found_mistakes_text_view, "field 'foundMistakesTextView'", TextView.class);
        target2.foundMistakesPercentTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.accuracy_text_view, "field 'foundMistakesPercentTextView'", TextView.class);
        target2.lineChart = (LineChart) Utils.findRequiredViewAsType(source, R.id.line_chart, "field 'lineChart'", LineChart.class);
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.chartLineColor = ContextCompat.getColor(context, R.color.result_chart_line_1_color);
        target2.chartItemColor = ContextCompat.getColor(context, R.color.result_chart_item_1_color);
        target2.chartItemCircleRadiusDp = res.getInteger(R.integer.result_chart_item_circle_radius_dp);
        target2.chartItemValueTextSizeDp = res.getInteger(R.integer.result_chart_item_value_text_size_dp);
        target2.chartLineWidthDp = res.getInteger(R.integer.result_chart_line_width_dp);
        target2.foundMistakesPercentTitle = res.getString(R.string.line_of_sight_result_found_mistakes_accuracy);
    }

    @CallSuper
    public void unbind() {
        LineOfSightResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.mistakesTextView = null;
        target2.foundMistakesTextView = null;
        target2.foundMistakesPercentTextView = null;
        target2.lineChart = null;
    }
}
