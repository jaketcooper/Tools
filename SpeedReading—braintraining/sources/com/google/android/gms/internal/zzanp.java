package com.google.android.gms.internal;

@zzzb
public final class zzanp {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    private zzanp(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public static zzanp zzc(zziw zziw) {
        return zziw.zzbdb ? new zzanp(3, 0, 0) : zziw.zzbde ? new zzanp(2, 0, 0) : zziw.zzbdd ? zztw() : zzi(zziw.widthPixels, zziw.heightPixels);
    }

    public static zzanp zzi(int i, int i2) {
        return new zzanp(1, i, i2);
    }

    public static zzanp zztw() {
        return new zzanp(0, 0, 0);
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zztx() {
        return this.type == 3;
    }

    public final boolean zzty() {
        return this.type == 0;
    }
}
