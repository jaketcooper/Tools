package com.safonov.speedreading.training.fragment.speedreading.result.view;

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

public class SpeedReadingResultFragment_ViewBinding implements Unbinder {
    private SpeedReadingResultFragment target;

    @UiThread
    public SpeedReadingResultFragment_ViewBinding(SpeedReadingResultFragment target2, View source) {
        this.target = target2;
        target2.maxSpeedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.max_speed_text_view, "field 'maxSpeedTextView'", TextView.class);
        target2.bestMaxSpeedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.best_max_speed_text_view, "field 'bestMaxSpeedTextView'", TextView.class);
        target2.averageSpeedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.average_speed_text_view, "field 'averageSpeedTextView'", TextView.class);
        target2.bestAverageSpeedTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.best_average_speed_text_view, "field 'bestAverageSpeedTextView'", TextView.class);
        target2.lineChart = (LineChart) Utils.findRequiredViewAsType(source, R.id.speed_reading_result_line_chart, "field 'lineChart'", LineChart.class);
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.maxSpeedLineColor = ContextCompat.getColor(context, R.color.result_chart_line_1_color);
        target2.maxSpeedItemColor = ContextCompat.getColor(context, R.color.result_chart_item_1_color);
        target2.averageSpeedLineColor = ContextCompat.getColor(context, R.color.result_chart_line_2_color);
        target2.averageSpeedItemColor = ContextCompat.getColor(context, R.color.result_chart_item_2_color);
        target2.chartItemCircleRadiusDp = res.getInteger(R.integer.result_chart_item_circle_radius_dp);
        target2.chartItemValueTextSizeDp = res.getInteger(R.integer.result_chart_item_value_text_size_dp);
        target2.chartLineWidthDp = res.getInteger(R.integer.result_chart_line_width_dp);
        target2.maxSpeedTitle = res.getString(R.string.speed_reading_result_max_speed);
        target2.averageSpeedTitle = res.getString(R.string.speed_reading_result_average_speed);
    }

    @CallSuper
    public void unbind() {
        SpeedReadingResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.maxSpeedTextView = null;
        target2.bestMaxSpeedTextView = null;
        target2.averageSpeedTextView = null;
        target2.bestAverageSpeedTextView = null;
        target2.lineChart = null;
    }
}
