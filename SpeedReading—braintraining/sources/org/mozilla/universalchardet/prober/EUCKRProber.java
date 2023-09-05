package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.distributionanalysis.EUCKRDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.EUCKRSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class EUCKRProber extends CharsetProber {
    private static final SMModel smModel = new EUCKRSMModel();
    private CodingStateMachine codingSM = new CodingStateMachine(smModel);
    private EUCKRDistributionAnalysis distributionAnalyzer = new EUCKRDistributionAnalysis();
    private byte[] lastChar = new byte[2];
    private CharsetProber.ProbingState state;

    public EUCKRProber() {
        reset();
    }

    public String getCharSetName() {
        return Constants.CHARSET_EUC_KR;
    }

    public float getConfidence() {
        return this.distributionAnalyzer.getConfidence();
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
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
                if (codingState == 0) {
                    int charLen = this.codingSM.getCurrentCharLen();
                    if (i == offset) {
                        this.lastChar[1] = buf[offset];
                        this.distributionAnalyzer.handleOneChar(this.lastChar, 0, charLen);
                    } else {
                        this.distributionAnalyzer.handleOneChar(buf, i - 1, charLen);
                    }
                }
                i++;
            }
        }
        this.lastChar[0] = buf[maxPos - 1];
        if (this.state == CharsetProber.ProbingState.DETECTING && this.distributionAnalyzer.gotEnoughData() && getConfidence() > 0.95f) {
            this.state = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.state;
    }

    public void reset() {
        this.codingSM.reset();
        this.state = CharsetProber.ProbingState.DETECTING;
        this.distributionAnalyzer.reset();
        Arrays.fill(this.lastChar, (byte) 0);
    }

    public void setOption() {
    }
}
