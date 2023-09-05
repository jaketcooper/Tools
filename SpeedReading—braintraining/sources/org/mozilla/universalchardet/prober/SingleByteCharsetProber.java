package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.sequence.SequenceModel;

public class SingleByteCharsetProber extends CharsetProber {
    public static final int NEGATIVE_CAT = 0;
    public static final float NEGATIVE_SHORTCUT_THRESHOLD = 0.05f;
    public static final int NUMBER_OF_SEQ_CAT = 4;
    public static final int POSITIVE_CAT = 3;
    public static final float POSITIVE_SHORTCUT_THRESHOLD = 0.95f;
    public static final int SAMPLE_SIZE = 64;
    public static final int SB_ENOUGH_REL_THRESHOLD = 1024;
    public static final int SYMBOL_CAT_ORDER = 250;
    private int freqChar;
    private short lastOrder;
    private SequenceModel model;
    private CharsetProber nameProber;
    private boolean reversed;
    private int[] seqCounters;
    private CharsetProber.ProbingState state;
    private int totalChar;
    private int totalSeqs;

    public SingleByteCharsetProber(SequenceModel model2) {
        this.model = model2;
        this.reversed = false;
        this.nameProber = null;
        this.seqCounters = new int[4];
        reset();
    }

    public SingleByteCharsetProber(SequenceModel model2, boolean reversed2, CharsetProber nameProber2) {
        this.model = model2;
        this.reversed = reversed2;
        this.nameProber = nameProber2;
        this.seqCounters = new int[4];
        reset();
    }

    /* access modifiers changed from: package-private */
    public boolean keepEnglishLetters() {
        return this.model.getKeepEnglishLetter();
    }

    public String getCharSetName() {
        if (this.nameProber == null) {
            return this.model.getCharsetName();
        }
        return this.nameProber.getCharSetName();
    }

    public float getConfidence() {
        if (this.totalSeqs <= 0) {
            return 0.01f;
        }
        float r = (((float) this.freqChar) * (((((float) this.seqCounters[3]) * 1.0f) / ((float) this.totalSeqs)) / this.model.getTypicalPositiveRatio())) / ((float) this.totalChar);
        if (r >= 1.0f) {
            return 0.99f;
        }
        return r;
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    public CharsetProber.ProbingState handleData(byte[] buf, int offset, int length) {
        int maxPos = offset + length;
        for (int i = offset; i < maxPos; i++) {
            short order = this.model.getOrder(buf[i]);
            if (order < 250) {
                this.totalChar++;
            }
            if (order < 64) {
                this.freqChar++;
                if (this.lastOrder < 64) {
                    this.totalSeqs++;
                    if (!this.reversed) {
                        int[] iArr = this.seqCounters;
                        byte precedence = this.model.getPrecedence((this.lastOrder * 64) + order);
                        iArr[precedence] = iArr[precedence] + 1;
                    } else {
                        int[] iArr2 = this.seqCounters;
                        byte precedence2 = this.model.getPrecedence((order * 64) + this.lastOrder);
                        iArr2[precedence2] = iArr2[precedence2] + 1;
                    }
                }
            }
            this.lastOrder = order;
        }
        if (this.state == CharsetProber.ProbingState.DETECTING && this.totalSeqs > 1024) {
            float cf = getConfidence();
            if (cf > 0.95f) {
                this.state = CharsetProber.ProbingState.FOUND_IT;
            } else if (cf < 0.05f) {
                this.state = CharsetProber.ProbingState.NOT_ME;
            }
        }
        return this.state;
    }

    public void reset() {
        this.state = CharsetProber.ProbingState.DETECTING;
        this.lastOrder = 255;
        for (int i = 0; i < 4; i++) {
            this.seqCounters[i] = 0;
        }
        this.totalSeqs = 0;
        this.totalChar = 0;
        this.freqChar = 0;
    }

    public void setOption() {
    }
}
