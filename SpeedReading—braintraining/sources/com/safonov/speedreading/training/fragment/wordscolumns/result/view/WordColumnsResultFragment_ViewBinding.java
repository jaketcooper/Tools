package com.safonov.speedreading.training.fragment.wordscolumns.result.view;

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

public class WordColumnsResultFragment_ViewBinding implements Unbinder {
    private WordColumnsResultFragment target;

    @UiThread
    public WordColumnsResultFragment_ViewBinding(WordColumnsResultFragment target2, View source) {
        this.target = target2;
        target2.durationTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.duration_text_view, "field 'durationTextView'", TextView.class);
        target2.lineChart = (LineChart) Utils.findRequiredViewAsType(source, R.id.line_chart, "field 'lineChart'", LineChart.class);
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.chartLineColor = ContextCompat.getColor(context, R.color.result_chart_line_1_color);
        target2.chartItemColor = ContextCompat.getColor(context, R.color.result_chart_item_1_color);
        target2.chartItemCircleRadiusDp = res.getInteger(R.integer.result_chart_item_circle_radius_dp);
        target2.chartItemValueTextSizeDp = res.getInteger(R.integer.result_chart_item_value_text_size_dp);
        target2.chartLineWidthDp = res.getInteger(R.integer.result_chart_line_width_dp);
        target2.durationTitle = res.getString(R.string.accelerator_result_duration_title);
    }

    @CallSuper
    public void unbind() {
        WordColumnsResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.durationTextView = null;
        target2.lineChart = null;
    }
}
