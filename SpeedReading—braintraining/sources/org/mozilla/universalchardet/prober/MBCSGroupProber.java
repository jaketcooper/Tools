package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;

public class MBCSGroupProber extends CharsetProber {
    private int activeNum;
    private int bestGuess;
    private boolean[] isActive = new boolean[7];
    private CharsetProber[] probers = new CharsetProber[7];
    private CharsetProber.ProbingState state;

    public MBCSGroupProber() {
        this.probers[0] = new UTF8Prober();
        this.probers[1] = new SJISProber();
        this.probers[2] = new EUCJPProber();
        this.probers[3] = new GB18030Prober();
        this.probers[4] = new EUCKRProber();
        this.probers[5] = new Big5Prober();
        this.probers[6] = new EUCTWProber();
        reset();
    }

    public String getCharSetName() {
        if (this.bestGuess == -1) {
            getConfidence();
            if (this.bestGuess == -1) {
                this.bestGuess = 0;
            }
        }
        return this.probers[this.bestGuess].getCharSetName();
    }

    public float getConfidence() {
        float bestConf = 0.0f;
        if (this.state == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (this.state == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        for (int i = 0; i < this.probers.length; i++) {
            if (this.isActive[i]) {
                float cf = this.probers[i].getConfidence();
                if (bestConf < cf) {
                    bestConf = cf;
                    this.bestGuess = i;
                }
            }
        }
        return bestConf;
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    public CharsetProber.ProbingState handleData(byte[] buf, int offset, int length) {
        int highpos;
        boolean keepNext = true;
        byte[] highbyteBuf = new byte[length];
        int maxPos = offset + length;
        int i = offset;
        int highpos2 = 0;
        while (i < maxPos) {
            if ((buf[i] & 128) != 0) {
                highpos = highpos2 + 1;
                highbyteBuf[highpos2] = buf[i];
                keepNext = true;
            } else if (keepNext) {
                highpos = highpos2 + 1;
                highbyteBuf[highpos2] = buf[i];
                keepNext = false;
            } else {
                highpos = highpos2;
            }
            i++;
            highpos2 = highpos;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.probers.length) {
                break;
            }
            if (this.isActive[i2]) {
                CharsetProber.ProbingState st = this.probers[i2].handleData(highbyteBuf, 0, highpos2);
                if (st == CharsetProber.ProbingState.FOUND_IT) {
                    this.bestGuess = i2;
                    this.state = CharsetProber.ProbingState.FOUND_IT;
                    break;
                } else if (st == CharsetProber.ProbingState.NOT_ME) {
                    this.isActive[i2] = false;
                    this.activeNum--;
                    if (this.activeNum <= 0) {
                        this.state = CharsetProber.ProbingState.NOT_ME;
                        break;
                    }
                } else {
                    continue;
                }
            }
            i2++;
        }
        return this.state;
    }

    public void reset() {
        this.activeNum = 0;
        for (int i = 0; i < this.probers.length; i++) {
            this.probers[i].reset();
            this.isActive[i] = true;
            this.activeNum++;
        }
        this.bestGuess = -1;
        this.state = CharsetProber.ProbingState.DETECTING;
    }

    public void setOption() {
    }
}
