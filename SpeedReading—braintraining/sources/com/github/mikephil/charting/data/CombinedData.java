package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {
    private BarData mBarData;
    private BubbleData mBubbleData;
    private CandleData mCandleData;
    private LineData mLineData;
    private ScatterData mScatterData;

    public void setData(LineData data) {
        this.mLineData = data;
        notifyDataChanged();
    }

    public void setData(BarData data) {
        this.mBarData = data;
        notifyDataChanged();
    }

    public void setData(ScatterData data) {
        this.mScatterData = data;
        notifyDataChanged();
    }

    public void setData(CandleData data) {
        this.mCandleData = data;
        notifyDataChanged();
    }

    public void setData(BubbleData data) {
        this.mBubbleData = data;
        notifyDataChanged();
    }

    public void calcMinMax() {
        if (this.mDataSets == null) {
            this.mDataSets = new ArrayList();
        }
        this.mDataSets.clear();
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        for (ChartData data : getAllData()) {
            data.calcMinMax();
            this.mDataSets.addAll(data.getDataSets());
            if (data.getYMax() > this.mYMax) {
                this.mYMax = data.getYMax();
            }
            if (data.getYMin() < this.mYMin) {
                this.mYMin = data.getYMin();
            }
            if (data.getXMax() > this.mXMax) {
                this.mXMax = data.getXMax();
            }
            if (data.getXMin() < this.mXMin) {
                this.mXMin = data.getXMin();
            }
            if (data.mLeftAxisMax > this.mLeftAxisMax) {
                this.mLeftAxisMax = data.mLeftAxisMax;
            }
            if (data.mLeftAxisMin < this.mLeftAxisMin) {
                this.mLeftAxisMin = data.mLeftAxisMin;
            }
            if (data.mRightAxisMax > this.mRightAxisMax) {
                this.mRightAxisMax = data.mRightAxisMax;
            }
            if (data.mRightAxisMin < this.mRightAxisMin) {
                this.mRightAxisMin = data.mRightAxisMin;
            }
        }
    }

    public BubbleData getBubbleData() {
        return this.mBubbleData;
    }

    public LineData getLineData() {
        return this.mLineData;
    }

    public BarData getBarData() {
        return this.mBarData;
    }

    public ScatterData getScatterData() {
        return this.mScatterData;
    }

    public CandleData getCandleData() {
        return this.mCandleData;
    }

    public List<BarLineScatterCandleBubbleData> getAllData() {
        List<BarLineScatterCandleBubbleData> data = new ArrayList<>();
        if (this.mLineData != null) {
            data.add(this.mLineData);
        }
        if (this.mBarData != null) {
            data.add(this.mBarData);
        }
        if (this.mScatterData != null) {
            data.add(this.mScatterData);
        }
        if (this.mCandleData != null) {
            data.add(this.mCandleData);
        }
        if (this.mBubbleData != null) {
            data.add(this.mBubbleData);
        }
        return data;
    }

    public BarLineScatterCandleBubbleData getDataByIndex(int index) {
        return getAllData().get(index);
    }

    public void notifyDataChanged() {
        if (this.mLineData != null) {
            this.mLineData.notifyDataChanged();
        }
        if (this.mBarData != null) {
            this.mBarData.notifyDataChanged();
        }
        if (this.mCandleData != null) {
            this.mCandleData.notifyDataChanged();
        }
        if (this.mScatterData != null) {
            this.mScatterData.notifyDataChanged();
        }
        if (this.mBubbleData != null) {
            this.mBubbleData.notifyDataChanged();
        }
        calcMinMax();
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.github.mikephil.charting.data.Entry getEntryForHighlight(com.github.mikephil.charting.highlight.Highlight r9) {
        /*
            r8 = this;
            r4 = 0
            java.util.List r1 = r8.getAllData()
            int r5 = r9.getDataIndex()
            int r6 = r1.size()
            if (r5 < r6) goto L_0x0011
            r3 = r4
        L_0x0010:
            return r3
        L_0x0011:
            int r5 = r9.getDataIndex()
            java.lang.Object r0 = r1.get(r5)
            com.github.mikephil.charting.data.ChartData r0 = (com.github.mikephil.charting.data.ChartData) r0
            int r5 = r9.getDataSetIndex()
            int r6 = r0.getDataSetCount()
            if (r5 < r6) goto L_0x0027
            r3 = r4
            goto L_0x0010
        L_0x0027:
            int r5 = r9.getDataSetIndex()
            com.github.mikephil.charting.interfaces.datasets.IDataSet r5 = r0.getDataSetByIndex(r5)
            float r6 = r9.getX()
            java.util.List r2 = r5.getEntriesForXValue(r6)
            java.util.Iterator r5 = r2.iterator()
        L_0x003b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x005e
            java.lang.Object r3 = r5.next()
            com.github.mikephil.charting.data.Entry r3 = (com.github.mikephil.charting.data.Entry) r3
            float r6 = r3.getY()
            float r7 = r9.getY()
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0010
            float r6 = r9.getY()
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 == 0) goto L_0x003b
            goto L_0x0010
        L_0x005e:
            r3 = r4
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.getEntryForHighlight(com.github.mikephil.charting.highlight.Highlight):com.github.mikephil.charting.data.Entry");
    }

    public int getDataIndex(ChartData data) {
        return getAllData().indexOf(data);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0009 A[LOOP:0: B:1:0x0009->B:4:0x0019, LOOP_START, PHI: r2 
      PHI: (r2v1 'success' boolean) = (r2v0 'success' boolean), (r2v3 'success' boolean) binds: [B:0:0x0000, B:4:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeDataSet(com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet<? extends com.github.mikephil.charting.data.Entry> r6) {
        /*
            r5 = this;
            java.util.List r1 = r5.getAllData()
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x0009:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x001b
            java.lang.Object r0 = r3.next()
            com.github.mikephil.charting.data.ChartData r0 = (com.github.mikephil.charting.data.ChartData) r0
            boolean r2 = r0.removeDataSet(r6)
            if (r2 == 0) goto L_0x0009
        L_0x001b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.removeDataSet(com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet):boolean");
    }

    @Deprecated
    public boolean removeDataSet(int index) {
        Log.e(Chart.LOG_TAG, "removeDataSet(int index) not supported for CombinedData");
        return false;
    }

    @Deprecated
    public boolean removeEntry(Entry e, int dataSetIndex) {
        Log.e(Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    @Deprecated
    public boolean removeEntry(float xValue, int dataSetIndex) {
        Log.e(Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData");
        return false;
    }
}
