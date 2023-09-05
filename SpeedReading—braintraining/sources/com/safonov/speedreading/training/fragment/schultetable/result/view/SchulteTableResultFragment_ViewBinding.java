package com.safonov.speedreading.training.fragment.schultetable.result.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.LineChart;
import com.speedreading.alexander.speedreading.R;

public class SchulteTableResultFragment_ViewBinding implements Unbinder {
    private SchulteTableResultFragment target;

    @UiThread
    public SchulteTableResultFragment_ViewBinding(SchulteTableResultFragment target2, View source) {
        this.target = target2;
        target2.timeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.schulte_table_result_time_text_view, "field 'timeTextView'", TextView.class);
        target2.bestTimeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.schulte_table_result_best_time_text_view, "field 'bestTimeTextView'", TextView.class);
        target2.newBestTimeView = (ImageView) Utils.findRequiredViewAsType(source, R.id.schulte_table_result_new_best_time_image_view, "field 'newBestTimeView'", ImageView.class);
        target2.lineChart = (LineChart) Utils.findRequiredViewAsType(source, R.id.schulte_table_result_chart_view, "field 'lineChart'", LineChart.class);
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.chartLineColor = ContextCompat.getColor(context, R.color.result_chart_line_1_color);
        target2.chartItemColor = ContextCompat.getColor(context, R.color.result_chart_item_1_color);
        target2.chartItemCircleRadiusDp = res.getInteger(R.integer.result_chart_item_circle_radius_dp);
        target2.chartItemValueTextSizeDp = res.getInteger(R.integer.result_chart_item_value_text_size_dp);
        target2.chartLineWidthDp = res.getInteger(R.integer.result_chart_line_width_dp);
        target2.timeTitle = res.getString(R.string.schulte_table_result_time);
    }

    @CallSuper
    public void unbind() {
        SchulteTableResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.timeTextView = null;
        target2.bestTimeTextView = null;
        target2.newBestTimeView = null;
        target2.lineChart = null;
    }
}
