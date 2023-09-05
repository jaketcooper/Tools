package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

public class HebrewProber extends CharsetProber {
    public static final int FINAL_KAF = 234;
    public static final int FINAL_MEM = 237;
    public static final int FINAL_NUN = 239;
    public static final int FINAL_PE = 243;
    public static final int FINAL_TSADI = 245;
    public static final int MIN_FINAL_CHAR_DISTANCE = 5;
    public static final float MIN_MODEL_DISTANCE = 0.01f;
    public static final int NORMAL_KAF = 235;
    public static final int NORMAL_MEM = 238;
    public static final int NORMAL_NUN = 240;
    public static final int NORMAL_PE = 244;
    public static final int NORMAL_TSADI = 246;
    public static final byte SPACE = 32;
    private byte beforePrev;
    private int finalCharLogicalScore;
    private int finalCharVisualScore;
    private CharsetProber logicalProber = null;
    private byte prev;
    private CharsetProber visualProber = null;

    public HebrewProber() {
        reset();
    }

    public void setModalProbers(CharsetProber logicalProber2, CharsetProber visualProber2) {
        this.logicalProber = logicalProber2;
        this.visualProber = visualProber2;
    }

    public String getCharSetName() {
        int finalsub = this.finalCharLogicalScore - this.finalCharVisualScore;
        if (finalsub >= 5) {
            return Constants.CHARSET_WINDOWS_1255;
        }
        if (finalsub <= -5) {
            return Constants.CHARSET_ISO_8859_8;
        }
        float modelsub = this.logicalProber.getConfidence() - this.visualProber.getConfidence();
        if (modelsub > 0.01f) {
            return Constants.CHARSET_WINDOWS_1255;
        }
        if (modelsub < -0.01f) {
            return Constants.CHARSET_ISO_8859_8;
        }
        if (finalsub < 0) {
            return Constants.CHARSET_ISO_8859_8;
        }
        return Constants.CHARSET_WINDOWS_1255;
    }

    public float getConfidence() {
        return 0.0f;
    }

    public CharsetProber.ProbingState getState() {
        if (this.logicalProber.getState() == CharsetProber.ProbingState.NOT_ME && this.visualProber.getState() == CharsetProber.ProbingState.NOT_ME) {
            return CharsetProber.ProbingState.NOT_ME;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    public CharsetProber.ProbingState handleData(byte[] buf, int offset, int length) {
        if (getState() == CharsetProber.ProbingState.NOT_ME) {
            return CharsetProber.ProbingState.NOT_ME;
        }
        int maxPos = offset + length;
        for (int i = offset; i < maxPos; i++) {
            byte c = buf[i];
            if (c == 32) {
                if (this.beforePrev != 32) {
                    if (isFinal(this.prev)) {
                        this.finalCharLogicalScore++;
                    } else if (isNonFinal(this.prev)) {
                        this.finalCharVisualScore++;
                    }
                }
            } else if (this.beforePrev == 32 && isFinal(this.prev) && c != 32) {
                this.finalCharVisualScore++;
            }
            this.beforePrev = this.prev;
            this.prev = c;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    public void reset() {
        this.finalCharLogicalScore = 0;
        this.finalCharVisualScore = 0;
        this.prev = SPACE;
        this.beforePrev = SPACE;
    }

    public void setOption() {
    }

    protected static boolean isFinal(byte b) {
        int c = b & 255;
        return c == 234 || c == 237 || c == 239 || c == 243 || c == 245;
    }

    protected static boolean isNonFinal(byte b) {
        int c = b & 255;
        return c == 235 || c == 238 || c == 240 || c == 244;
    }
}
