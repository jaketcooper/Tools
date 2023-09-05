package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;

public abstract class CharsetProber {
    public static final int ASCII_A = 97;
    public static final int ASCII_A_CAPITAL = 65;
    public static final int ASCII_GT = 62;
    public static final int ASCII_LT = 60;
    public static final int ASCII_SP = 32;
    public static final int ASCII_Z = 122;
    public static final int ASCII_Z_CAPITAL = 90;
    public static final float SHORTCUT_THRESHOLD = 0.95f;

    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    public abstract String getCharSetName();

    public abstract float getConfidence();

    public abstract ProbingState getState();

    public abstract ProbingState handleData(byte[] bArr, int i, int i2);

    public abstract void reset();

    public abstract void setOption();

    public ByteBuffer filterWithoutEnglishLetters(byte[] buf, int offset, int length) {
        ByteBuffer out = ByteBuffer.allocate(length);
        boolean meetMSB = false;
        int prevPtr = offset;
        int curPtr = offset;
        int maxPtr = offset + length;
        while (curPtr < maxPtr) {
            byte c = buf[curPtr];
            if (!isAscii(c)) {
                meetMSB = true;
            } else if (isAsciiSymbol(c)) {
                if (!meetMSB || curPtr <= prevPtr) {
                    prevPtr = curPtr + 1;
                } else {
                    out.put(buf, prevPtr, curPtr - prevPtr);
                    out.put(HebrewProber.SPACE);
                    prevPtr = curPtr + 1;
                    meetMSB = false;
                }
            }
            curPtr++;
        }
        if (meetMSB && curPtr > prevPtr) {
            out.put(buf, prevPtr, curPtr - prevPtr);
        }
        return out;
    }

    public ByteBuffer filterWithEnglishLetters(byte[] buf, int offset, int length) {
        ByteBuffer out = ByteBuffer.allocate(length);
        boolean isInTag = false;
        int prevPtr = offset;
        int curPtr = offset;
        int maxPtr = offset + length;
        while (curPtr < maxPtr) {
            byte c = buf[curPtr];
            if (c == 62) {
                isInTag = false;
            } else if (c == 60) {
                isInTag = true;
            }
            if (isAscii(c) && isAsciiSymbol(c)) {
                if (curPtr <= prevPtr || isInTag) {
                    prevPtr = curPtr + 1;
                } else {
                    out.put(buf, prevPtr, curPtr - prevPtr);
                    out.put(HebrewProber.SPACE);
                    prevPtr = curPtr + 1;
                }
            }
            curPtr++;
        }
        if (!isInTag && curPtr > prevPtr) {
            out.put(buf, prevPtr, curPtr - prevPtr);
        }
        return out;
    }

    private boolean isAscii(byte b) {
        return (b & 128) == 0;
    }

    private boolean isAsciiSymbol(byte b) {
        int c = b & 255;
        return c < 65 || (c > 90 && c < 97) || c > 122;
    }
}
