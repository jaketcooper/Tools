package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SMModel;
import org.mozilla.universalchardet.prober.statemachine.UTF8SMModel;

public class UTF8Prober extends CharsetProber {
    public static final float ONE_CHAR_PROB = 0.5f;
    private static final SMModel smModel = new UTF8SMModel();
    private CodingStateMachine codingSM = new CodingStateMachine(smModel);
    private int numOfMBChar = 0;
    private CharsetProber.ProbingState state;

    public UTF8Prober() {
        reset();
    }

    public String getCharSetName() {
        return Constants.CHARSET_UTF_8;
    }

    public CharsetProber.ProbingState handleData(byte[] buf, int offset, int length) {
        int maxPos = offset + length;
        int i = offset;
        while (true) {
            if (i >= maxPos) {
                break;
            }
            int codingState = this.codingSM.nextState(buf[i]);
            if (codingState == 1) {
                this.state = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (codingState == 2) {
                this.state = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (codingState == 0 && this.codingSM.getCurrentCharLen() >= 2) {
                    this.numOfMBChar++;
                }
                i++;
            }
        }
        if (this.state == CharsetProber.ProbingState.DETECTING && getConfidence() > 0.95f) {
            this.state = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.state;
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    public void reset() {
        this.codingSM.reset();
        this.numOfMBChar = 0;
        this.state = CharsetProber.ProbingState.DETECTING;
    }

    public float getConfidence() {
        float unlike = 0.99f;
        if (this.numOfMBChar >= 6) {
            return 0.99f;
        }
        for (int i = 0; i < this.numOfMBChar; i++) {
            unlike *= 0.5f;
        }
        return 1.0f - unlike;
    }

    public void setOption() {
    }
}
