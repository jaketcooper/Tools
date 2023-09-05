package com.google.android.gms.internal;

final /* synthetic */ class zzdsj {
    static final /* synthetic */ int[] zzluy = new int[zzdsl.values().length];
    static final /* synthetic */ int[] zzluz = new int[zzdsk.values().length];

    static {
        try {
            zzluz[zzdsk.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzluz[zzdsk.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzluz[zzdsk.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzluy[zzdsl.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzluy[zzdsl.COMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
