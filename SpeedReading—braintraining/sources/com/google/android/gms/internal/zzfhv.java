package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfhv {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static int zzphv = 11;
    private static int zzphw = 12;
    private static int zzphx = 16;
    private static int zzphy = 26;
    public static final int[] zzphz = new int[0];
    public static final long[] zzpia = new long[0];
    public static final float[] zzpib = new float[0];
    private static double[] zzpic = new double[0];
    public static final boolean[] zzpid = new boolean[0];
    public static final byte[][] zzpie = new byte[0][];
    public static final byte[] zzpif = new byte[0];

    public static final int zzb(zzfhj zzfhj, int i) throws IOException {
        int i2 = 1;
        int position = zzfhj.getPosition();
        zzfhj.zzkh(i);
        while (zzfhj.zzctt() == i) {
            zzfhj.zzkh(i);
            i2++;
        }
        zzfhj.zzam(position, i);
        return i2;
    }
}
