package org.mozilla.universalchardet.prober.statemachine;

public class EUCTWSMModel extends SMModel {
    public static final int EUCTW_CLASS_FACTOR = 7;
    private static int[] euctwCharLenTable = {0, 0, 1, 2, 2, 2, 3};
    private static int[] euctwClassTable = {PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 0, 0), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 0, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 6, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 0, 0, 0, 0, 0, 0, 0), PkgInt.pack4bits(0, 3, 4, 4, 4, 4, 4, 4), PkgInt.pack4bits(5, 5, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 3, 1, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 0)};
    private static int[] euctwStateTable = {PkgInt.pack4bits(1, 1, 0, 3, 3, 3, 4, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 1, 0, 1), PkgInt.pack4bits(0, 0, 0, 1, 1, 1, 1, 1), PkgInt.pack4bits(5, 1, 1, 1, 0, 1, 0, 0), PkgInt.pack4bits(0, 1, 0, 0, 0, 0, 0, 0)};

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EUCTWSMModel() {
        /*
            r12 = this;
            r4 = 15
            r1 = 3
            r3 = 2
            r2 = 7
            org.mozilla.universalchardet.prober.statemachine.PkgInt r0 = new org.mozilla.universalchardet.prober.statemachine.PkgInt
            int[] r5 = euctwClassTable
            r0.<init>(r1, r2, r3, r4, r5)
            org.mozilla.universalchardet.prober.statemachine.PkgInt r5 = new org.mozilla.universalchardet.prober.statemachine.PkgInt
            int[] r10 = euctwStateTable
            r6 = r1
            r7 = r2
            r8 = r3
            r9 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            int[] r10 = euctwCharLenTable
            java.lang.String r11 = org.mozilla.universalchardet.Constants.CHARSET_EUC_TW
            r6 = r12
            r7 = r0
            r8 = r2
            r9 = r5
            r6.<init>(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.universalchardet.prober.statemachine.EUCTWSMModel.<init>():void");
    }
}
