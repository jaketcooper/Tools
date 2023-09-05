package com.google.android.gms.internal;

final /* synthetic */ class zzdoz {
    static final /* synthetic */ int[] zzlpx = new int[zzdrc.values().length];
    static final /* synthetic */ int[] zzlpy = new int[zzdqy.values().length];
    static final /* synthetic */ int[] zzlpz = new int[zzdqo.values().length];

    static {
        try {
            zzlpz[zzdqo.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzlpz[zzdqo.COMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzlpy[zzdqy.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzlpy[zzdqy.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzlpy[zzdqy.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            zzlpx[zzdrc.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            zzlpx[zzdrc.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            zzlpx[zzdrc.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
    }
}
