package com.safonov.speedreading.training.fragment.schultetable.training.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.widget.GridLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class SchulteTableFragment_ViewBinding implements Unbinder {
    private SchulteTableFragment target;

    @UiThread
    public SchulteTableFragment_ViewBinding(SchulteTableFragment target2, View source) {
        this.target = target2;
        target2.statisticsPanel = Utils.findRequiredView(source, R.id.schulte_statistics_panel, "field 'statisticsPanel'");
        target2.timeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.schulte_time_text_view, "field 'timeTextView'", TextView.class);
        target2.bestTimeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.schulte_best_time_text_view, "field 'bestTimeTextView'", TextView.class);
        target2.nextItemTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.schulte_next_item_text_view, "field 'nextItemTextView'", TextView.class);
        target2.gridLayout = (GridLayout) Utils.findRequiredViewAsType(source, R.id.schulte_grid_layout, "field 'gridLayout'", GridLayout.class);
        Context context = source.getContext();
        Resources res = context.getResources();
        target2.backgroundWhiteColor = ContextCompat.getColor(context, R.color.background_white);
        target2.tableEdgeColor = ContextCompat.getColor(context, R.color.schulte_edge_color);
        target2.textColorWhite = ContextCompat.getColor(context, 17170443);
        target2.textColorBlack = ContextCompat.getColor(context, 17170435);
        target2.greenColor = ContextCompat.getColor(context, R.color.accept_green);
        target2.redColor = ContextCompat.getColor(context, R.color.reject_red);
        target2.itemMargin = res.getDimensionPixelSize(R.dimen.schulte_table_item_margin);
    }

    @CallSuper
    public void unbind() {
        SchulteTableFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.statisticsPanel = null;
        target2.timeTextView = null;
        target2.bestTimeTextView = null;
        target2.nextItemTextView = null;
        target2.gridLayout = null;
    }
}
