package com.safonov.speedreading.training.fragment.wordpairs.result.view;

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

public class WordPairsResultFragment_ViewBinding implements Unbinder {
    private WordPairsResultFragment target;

    @UiThread
    public WordPairsResultFragment_ViewBinding(WordPairsResultFragment target2, View source) {
        this.target = target2;
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.score_text_view, "field 'scoreTextView'", TextView.class);
        target2.bestScoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.best_score_text_view, "field 'bestScoreTextView'", TextView.class);
        target2.newBestScoreView = (ImageView) Utils.findRequiredViewAsType(source, R.id.new_best_score_image_view, "field 'newBestScoreView'", ImageView.class);
        target2.lineChart = (LineChart) Utils.findRequiredViewAsType(source, R.id.line_chart_view, "field 'lineChart'", LineChart.class);
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.chartLineColor = ContextCompat.getColor(context, R.color.result_chart_line_1_color);
        target2.chartItemColor = ContextCompat.getColor(context, R.color.result_chart_item_1_color);
        target2.chartItemCircleRadiusDp = res.getInteger(R.integer.result_chart_item_circle_radius_dp);
        target2.chartItemValueTextSizeDp = res.getInteger(R.integer.result_chart_item_value_text_size_dp);
        target2.chartLineWidthDp = res.getInteger(R.integer.result_chart_line_width_dp);
        target2.scoreTitle = res.getString(R.string.word_pairs_result_score);
    }

    @CallSuper
    public void unbind() {
        WordPairsResultFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.scoreTextView = null;
        target2.bestScoreTextView = null;
        target2.newBestScoreView = null;
        target2.lineChart = null;
    }
}
