package org.mozilla.universalchardet.prober.statemachine;

public class GB18030SMModel extends SMModel {
    public static final int GB18030_CLASS_FACTOR = 7;
    private static int[] gb18030CharLenTable = {0, 1, 1, 1, 1, 1, 2};
    private static int[] gb18030ClassTable = {PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 0, 0), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 0, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(3, 3, 3, 3, 3, 3, 3, 3), PkgInt.pack4bits(3, 3, 1, 1, 1, 1, 1, 1), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 2, 2, 4), PkgInt.pack4bits(5, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 6), PkgInt.pack4bits(6, 6, 6, 6, 6, 6, 6, 0)};
    private static int[] gb18030StateTable = {PkgInt.pack4bits(1, 0, 0, 0, 0, 0, 3, 1), PkgInt.pack4bits(1, 1, 1, 1, 1, 1, 2, 2), PkgInt.pack4bits(2, 2, 2, 2, 2, 1, 1, 0), PkgInt.pack4bits(4, 1, 0, 0, 1, 1, 1, 1), PkgInt.pack4bits(1, 1, 5, 1, 1, 1, 2, 1), PkgInt.pack4bits(1, 1, 0, 0, 0, 0, 0, 0)};

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GB18030SMModel() {
        /*
            r12 = this;
            r4 = 15
            r1 = 3
            r3 = 2
            r2 = 7
            org.mozilla.universalchardet.prober.statemachine.PkgInt r0 = new org.mozilla.universalchardet.prober.statemachine.PkgInt
            int[] r5 = gb18030ClassTable
            r0.<init>(r1, r2, r3, r4, r5)
            org.mozilla.universalchardet.prober.statemachine.PkgInt r5 = new org.mozilla.universalchardet.prober.statemachine.PkgInt
            int[] r10 = gb18030StateTable
            r6 = r1
            r7 = r2
            r8 = r3
            r9 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            int[] r10 = gb18030CharLenTable
            java.lang.String r11 = org.mozilla.universalchardet.Constants.CHARSET_GB18030
            r6 = r12
            r7 = r0
            r8 = r2
            r9 = r5
            r6.<init>(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.universalchardet.prober.statemachine.GB18030SMModel.<init>():void");
    }
}
