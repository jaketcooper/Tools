package org.mozilla.universalchardet.prober.statemachine;

public class CodingStateMachine {
    protected int currentBytePos;
    protected int currentCharLen;
    protected int currentState = 0;
    protected SMModel model;

    public CodingStateMachine(SMModel model2) {
        this.model = model2;
    }

    public int nextState(byte c) {
        int byteCls = this.model.getClass(c);
        if (this.currentState == 0) {
            this.currentBytePos = 0;
            this.currentCharLen = this.model.getCharLen(byteCls);
        }
        this.currentState = this.model.getNextState(byteCls, this.currentState);
        this.currentBytePos++;
        return this.currentState;
    }

    public int getCurrentCharLen() {
        return this.currentCharLen;
    }

    public void reset() {
        this.currentState = 0;
    }

    public String getCodingStateMachine() {
        return this.model.getName();
    }
}
