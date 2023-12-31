package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider chart) {
        super(chart);
    }

    public Highlight getHighlight(float x, float y) {
        BarData barData = ((BarDataProvider) this.mChart).getBarData();
        MPPointD pos = getValsForTouch(y, x);
        Highlight high = getHighlightForX((float) pos.f74y, y, x);
        if (high == null) {
            return null;
        }
        IBarDataSet set = (IBarDataSet) barData.getDataSetByIndex(high.getDataSetIndex());
        if (set.isStacked()) {
            return getStackedHighlight(high, set, (float) pos.f74y, (float) pos.f73x);
        }
        MPPointD.recycleInstance(pos);
        return high;
    }

    /* access modifiers changed from: protected */
    public List<Highlight> buildHighlights(IDataSet set, int dataSetIndex, float xVal, DataSet.Rounding rounding) {
        Entry closest;
        ArrayList<Highlight> highlights = new ArrayList<>();
        List<Entry> entries = set.getEntriesForXValue(xVal);
        if (entries.size() == 0 && (closest = set.getEntryForXValue(xVal, Float.NaN, rounding)) != null) {
            entries = set.getEntriesForXValue(closest.getX());
        }
        if (entries.size() != 0) {
            for (Entry e : entries) {
                MPPointD pixels = ((BarDataProvider) this.mChart).getTransformer(set.getAxisDependency()).getPixelForValues(e.getY(), e.getX());
                highlights.add(new Highlight(e.getX(), e.getY(), (float) pixels.f73x, (float) pixels.f74y, dataSetIndex, set.getAxisDependency()));
            }
        }
        return highlights;
    }

    /* access modifiers changed from: protected */
    public float getDistance(float x1, float y1, float x2, float y2) {
        return Math.abs(y1 - y2);
    }
}
