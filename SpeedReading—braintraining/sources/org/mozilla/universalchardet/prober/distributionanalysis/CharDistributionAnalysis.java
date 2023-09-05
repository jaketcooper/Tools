package org.mozilla.universalchardet.prober.distributionanalysis;

public abstract class CharDistributionAnalysis {
    public static final int ENOUGH_DATA_THRESHOLD = 1024;
    public static final int MINIMUM_DATA_THRESHOLD = 4;
    public static final float SURE_NO = 0.01f;
    public static final float SURE_YES = 0.99f;
    protected int[] charToFreqOrder;
    protected boolean done;
    private int freqChars;
    private int totalChars;
    protected float typicalDistributionRatio;

    /* access modifiers changed from: protected */
    public abstract int getOrder(byte[] bArr, int i);

    public CharDistributionAnalysis() {
        reset();
    }

    public void handleData(byte[] buf, int offset, int length) {
    }

    public void handleOneChar(byte[] buf, int offset, int charLength) {
        int order = -1;
        if (charLength == 2) {
            order = getOrder(buf, offset);
        }
        if (order >= 0) {
            this.totalChars++;
            if (order < this.charToFreqOrder.length && 512 > this.charToFreqOrder[order]) {
                this.freqChars++;
            }
        }
    }

    public float getConfidence() {
        if (this.totalChars <= 0 || this.freqChars <= 4) {
            return 0.01f;
        }
        if (this.totalChars != this.freqChars) {
            float r = ((float) (this.freqChars / (this.totalChars - this.freqChars))) * this.typicalDistributionRatio;
            if (r < 0.99f) {
                return r;
            }
        }
        return 0.99f;
    }

    public void reset() {
        this.done = false;
        this.totalChars = 0;
        this.freqChars = 0;
    }

    public void setOption() {
    }

    public boolean gotEnoughData() {
        return this.totalChars > 1024;
    }
}
