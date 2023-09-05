package org.mozilla.universalchardet.prober.distributionanalysis;

public class SJISDistributionAnalysis extends JISDistributionAnalysis {
    public static final int HIGHBYTE_BEGIN_1 = 129;
    public static final int HIGHBYTE_BEGIN_2 = 224;
    public static final int HIGHBYTE_END_1 = 159;
    public static final int HIGHBYTE_END_2 = 239;
    public static final int LOWBYTE_BEGIN_1 = 64;
    public static final int LOWBYTE_BEGIN_2 = 128;

    /* access modifiers changed from: protected */
    public int getOrder(byte[] buf, int offset) {
        int order;
        int highbyte = buf[offset] & 255;
        if (highbyte >= 129 && highbyte <= 159) {
            order = (highbyte - 129) * 188;
        } else if (highbyte < 224 || highbyte > 239) {
            return -1;
        } else {
            order = ((highbyte - 224) + 31) * 188;
        }
        int lowbyte = buf[offset + 1] & 255;
        int order2 = order + (lowbyte - 64);
        if (lowbyte >= 128) {
            order2--;
        }
        return order2;
    }
}
