package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> mValues = null;
    protected float mXMax = -3.4028235E38f;
    protected float mXMin = Float.MAX_VALUE;
    protected float mYMax = -3.4028235E38f;
    protected float mYMin = Float.MAX_VALUE;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public abstract DataSet<T> copy();

    public DataSet(List<T> values, String label) {
        super(label);
        this.mValues = values;
        if (this.mValues == null) {
            this.mValues = new ArrayList();
        }
        calcMinMax();
    }

    public void calcMinMax() {
        if (this.mValues != null && !this.mValues.isEmpty()) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            this.mXMax = -3.4028235E38f;
            this.mXMin = Float.MAX_VALUE;
            for (T e : this.mValues) {
                calcMinMax(e);
            }
        }
    }

    public void calcMinMaxY(float fromX, float toX) {
        if (this.mValues != null && !this.mValues.isEmpty()) {
            this.mYMax = -3.4028235E38f;
            this.mYMin = Float.MAX_VALUE;
            int indexFrom = getEntryIndex(fromX, Float.NaN, Rounding.DOWN);
            int indexTo = getEntryIndex(toX, Float.NaN, Rounding.UP);
            for (int i = indexFrom; i <= indexTo; i++) {
                calcMinMaxY((Entry) this.mValues.get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(T e) {
        if (e != null) {
            calcMinMaxX(e);
            calcMinMaxY(e);
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMaxX(T e) {
        if (e.getX() < this.mXMin) {
            this.mXMin = e.getX();
        }
        if (e.getX() > this.mXMax) {
            this.mXMax = e.getX();
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMaxY(T e) {
        if (e.getY() < this.mYMin) {
            this.mYMin = e.getY();
        }
        if (e.getY() > this.mYMax) {
            this.mYMax = e.getY();
        }
    }

    public int getEntryCount() {
        return this.mValues.size();
    }

    public List<T> getValues() {
        return this.mValues;
    }

    public void setValues(List<T> values) {
        this.mValues = values;
        notifyDataSetChanged();
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(toSimpleString());
        for (int i = 0; i < this.mValues.size(); i++) {
            buffer.append(((Entry) this.mValues.get(i)).toString() + " ");
        }
        return buffer.toString();
    }

    public String toSimpleString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("DataSet, label: " + (getLabel() == null ? "" : getLabel()) + ", entries: " + this.mValues.size() + "\n");
        return buffer.toString();
    }

    public float getYMin() {
        return this.mYMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getXMax() {
        return this.mXMax;
    }

    public void addEntryOrdered(T e) {
        if (e != null) {
            if (this.mValues == null) {
                this.mValues = new ArrayList();
            }
            calcMinMax(e);
            if (this.mValues.size() <= 0 || ((Entry) this.mValues.get(this.mValues.size() - 1)).getX() <= e.getX()) {
                this.mValues.add(e);
                return;
            }
            this.mValues.add(getEntryIndex(e.getX(), e.getY(), Rounding.UP), e);
        }
    }

    public void clear() {
        this.mValues.clear();
        notifyDataSetChanged();
    }

    public boolean addEntry(T e) {
        if (e == null) {
            return false;
        }
        List<T> values = getValues();
        if (values == null) {
            values = new ArrayList<>();
        }
        calcMinMax(e);
        return values.add(e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        r0 = r2.mValues.remove(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeEntry(T r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
        L_0x0003:
            return r0
        L_0x0004:
            java.util.List<T> r1 = r2.mValues
            if (r1 == 0) goto L_0x0003
            java.util.List<T> r1 = r2.mValues
            boolean r0 = r1.remove(r3)
            if (r0 == 0) goto L_0x0003
            r2.calcMinMax()
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.DataSet.removeEntry(com.github.mikephil.charting.data.Entry):boolean");
    }

    public int getEntryIndex(Entry e) {
        return this.mValues.indexOf(e);
    }

    public T getEntryForXValue(float xValue, float closestToY, Rounding rounding) {
        int index = getEntryIndex(xValue, closestToY, rounding);
        if (index > -1) {
            return (Entry) this.mValues.get(index);
        }
        return null;
    }

    public T getEntryForXValue(float xValue, float closestToY) {
        return getEntryForXValue(xValue, closestToY, Rounding.CLOSEST);
    }

    public T getEntryForIndex(int index) {
        return (Entry) this.mValues.get(index);
    }

    public int getEntryIndex(float xValue, float closestToY, Rounding rounding) {
        if (this.mValues == null || this.mValues.isEmpty()) {
            return -1;
        }
        int low = 0;
        int high = this.mValues.size() - 1;
        int closest = high;
        while (low < high) {
            int m = (low + high) / 2;
            float d1 = ((Entry) this.mValues.get(m)).getX() - xValue;
            float ad1 = Math.abs(d1);
            float ad2 = Math.abs(((Entry) this.mValues.get(m + 1)).getX() - xValue);
            if (ad2 < ad1) {
                low = m + 1;
            } else if (ad1 < ad2) {
                high = m;
            } else if (((double) d1) >= Utils.DOUBLE_EPSILON) {
                high = m;
            } else if (((double) d1) < Utils.DOUBLE_EPSILON) {
                low = m + 1;
            }
            closest = high;
        }
        if (closest == -1) {
            return closest;
        }
        float closestXValue = ((Entry) this.mValues.get(closest)).getX();
        if (rounding == Rounding.UP) {
            if (closestXValue < xValue && closest < this.mValues.size() - 1) {
                closest++;
            }
        } else if (rounding == Rounding.DOWN && closestXValue > xValue && closest > 0) {
            closest--;
        }
        if (Float.isNaN(closestToY)) {
            return closest;
        }
        while (closest > 0 && ((Entry) this.mValues.get(closest - 1)).getX() == closestXValue) {
            closest--;
        }
        float closestYValue = ((Entry) this.mValues.get(closest)).getY();
        int closestYIndex = closest;
        while (true) {
            closest++;
            if (closest < this.mValues.size()) {
                Entry value = (Entry) this.mValues.get(closest);
                if (value.getX() != closestXValue) {
                    break;
                } else if (Math.abs(value.getY() - closestToY) < Math.abs(closestYValue - closestToY)) {
                    closestYValue = closestToY;
                    closestYIndex = closest;
                }
            } else {
                break;
            }
        }
        return closestYIndex;
    }

    public List<T> getEntriesForXValue(float xValue) {
        List<T> entries = new ArrayList<>();
        int low = 0;
        int high = this.mValues.size() - 1;
        while (true) {
            if (low > high) {
                break;
            }
            int m = (high + low) / 2;
            T entry = (Entry) this.mValues.get(m);
            if (xValue == entry.getX()) {
                while (m > 0 && ((Entry) this.mValues.get(m - 1)).getX() == xValue) {
                    m--;
                }
                int high2 = this.mValues.size();
                while (m < high2) {
                    T entry2 = (Entry) this.mValues.get(m);
                    if (entry2.getX() != xValue) {
                        break;
                    }
                    entries.add(entry2);
                    m++;
                }
            } else if (xValue > entry.getX()) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return entries;
    }
}
