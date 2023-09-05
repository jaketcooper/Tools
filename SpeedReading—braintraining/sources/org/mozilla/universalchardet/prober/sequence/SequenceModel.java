package org.mozilla.universalchardet.prober.sequence;

public abstract class SequenceModel {
    protected short[] charToOrderMap;
    protected String charsetName;
    protected boolean keepEnglishLetter;
    protected byte[] precedenceMatrix;
    protected float typicalPositiveRatio;

    public SequenceModel(short[] charToOrderMap2, byte[] precedenceMatrix2, float typicalPositiveRatio2, boolean keepEnglishLetter2, String charsetName2) {
        this.charToOrderMap = charToOrderMap2;
        this.precedenceMatrix = precedenceMatrix2;
        this.typicalPositiveRatio = typicalPositiveRatio2;
        this.keepEnglishLetter = keepEnglishLetter2;
        this.charsetName = charsetName2;
    }

    public short getOrder(byte b) {
        return this.charToOrderMap[b & 255];
    }

    public byte getPrecedence(int pos) {
        return this.precedenceMatrix[pos];
    }

    public float getTypicalPositiveRatio() {
        return this.typicalPositiveRatio;
    }

    public boolean getKeepEnglishLetter() {
        return this.keepEnglishLetter;
    }

    public String getCharsetName() {
        return this.charsetName;
    }
}
