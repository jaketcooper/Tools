package org.mozilla.universalchardet.prober.statemachine;

public class PkgInt {
    public static final int BIT_SHIFT_16BITS = 4;
    public static final int BIT_SHIFT_4BITS = 2;
    public static final int BIT_SHIFT_8BITS = 3;
    public static final int INDEX_SHIFT_16BITS = 1;
    public static final int INDEX_SHIFT_4BITS = 3;
    public static final int INDEX_SHIFT_8BITS = 2;
    public static final int SHIFT_MASK_16BITS = 1;
    public static final int SHIFT_MASK_4BITS = 7;
    public static final int SHIFT_MASK_8BITS = 3;
    public static final int UNIT_MASK_16BITS = 65535;
    public static final int UNIT_MASK_4BITS = 15;
    public static final int UNIT_MASK_8BITS = 255;
    private int bitShift;
    private int[] data;
    private int indexShift;
    private int shiftMask;
    private int unitMask;

    public PkgInt(int indexShift2, int shiftMask2, int bitShift2, int unitMask2, int[] data2) {
        this.indexShift = indexShift2;
        this.shiftMask = shiftMask2;
        this.bitShift = bitShift2;
        this.unitMask = unitMask2;
        this.data = data2;
    }

    public static int pack16bits(int a, int b) {
        return (b << 16) | a;
    }

    public static int pack8bits(int a, int b, int c, int d) {
        return pack16bits((b << 8) | a, (d << 8) | c);
    }

    public static int pack4bits(int a, int b, int c, int d, int e, int f, int g, int h) {
        return pack8bits((b << 4) | a, (d << 4) | c, (f << 4) | e, (h << 4) | g);
    }

    public int unpack(int i) {
        return (this.data[i >> this.indexShift] >> ((this.shiftMask & i) << this.bitShift)) & this.unitMask;
    }
}
