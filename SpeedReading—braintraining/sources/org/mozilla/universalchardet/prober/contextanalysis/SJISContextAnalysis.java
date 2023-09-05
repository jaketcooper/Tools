package org.mozilla.universalchardet.prober.contextanalysis;

import org.mozilla.universalchardet.prober.contextanalysis.JapaneseContextAnalysis;

public class SJISContextAnalysis extends JapaneseContextAnalysis {
    public static final int HIGHBYTE_BEGIN_1 = 129;
    public static final int HIGHBYTE_BEGIN_2 = 224;
    public static final int HIGHBYTE_END_1 = 159;
    public static final int HIGHBYTE_END_2 = 239;
    public static final int HIRAGANA_HIGHBYTE = 130;
    public static final int HIRAGANA_LOWBYTE_BEGIN = 159;
    public static final int HIRAGANA_LOWBYTE_END = 241;

    /* access modifiers changed from: protected */
    public void getOrder(JapaneseContextAnalysis.Order order, byte[] buf, int offset) {
        int lowbyte;
        order.order = -1;
        order.charLength = 1;
        int highbyte = buf[offset] & 255;
        if ((highbyte >= 129 && highbyte <= 159) || (highbyte >= 224 && highbyte <= 239)) {
            order.charLength = 2;
        }
        if (highbyte == 130 && (lowbyte = buf[offset + 1] & 255) >= 159 && lowbyte <= 241) {
            order.order = lowbyte - 159;
        }
    }

    /* access modifiers changed from: protected */
    public int getOrder(byte[] buf, int offset) {
        int lowbyte;
        if ((buf[offset] & 255) != 130 || (lowbyte = buf[offset + 1] & 255) < 159 || lowbyte > 241) {
            return -1;
        }
        return lowbyte - 159;
    }
}
