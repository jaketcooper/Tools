package org.mozilla.universalchardet.prober.distributionanalysis;

public class EUCJPDistributionAnalysis extends JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN = 161;
    public static final int HIGHBYTE_END = 254;
    public static final int LOWBYTE_BEGIN = 161;
    public static final int LOWBYTE_END = 254;

    /* access modifiers changed from: protected */
    public int getOrder(byte[] buf, int offset) {
        int highbyte = buf[offset] & 255;
        if (highbyte < 161) {
            return -1;
        }
        return (((highbyte - 161) * 94) + (buf[offset + 1] & 255)) - 161;
    }
}
