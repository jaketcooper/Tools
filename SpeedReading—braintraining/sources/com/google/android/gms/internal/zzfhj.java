package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfhj {
    private final byte[] buffer;
    private int zzpbf;
    private int zzpbg = 64;
    private int zzpbh = 67108864;
    private int zzpbl;
    private int zzpbn;
    private int zzpbo = Integer.MAX_VALUE;
    private int zzpbq;
    private int zzphj;
    private int zzphk;

    private zzfhj(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzphj = i;
        this.zzpbq = i + i2;
        this.zzphk = i;
    }

    public static zzfhj zzbd(byte[] bArr) {
        return zzn(bArr, 0, bArr.length);
    }

    private final void zzcuq() {
        this.zzpbq += this.zzpbl;
        int i = this.zzpbq;
        if (i > this.zzpbo) {
            this.zzpbl = i - this.zzpbo;
            this.zzpbq -= this.zzpbl;
            return;
        }
        this.zzpbl = 0;
    }

    private final byte zzcur() throws IOException {
        if (this.zzphk == this.zzpbq) {
            throw zzfhr.zzcxi();
        }
        byte[] bArr = this.buffer;
        int i = this.zzphk;
        this.zzphk = i + 1;
        return bArr[i];
    }

    private final void zzkl(int i) throws IOException {
        if (i < 0) {
            throw zzfhr.zzcxj();
        } else if (this.zzphk + i > this.zzpbo) {
            zzkl(this.zzpbo - this.zzphk);
            throw zzfhr.zzcxi();
        } else if (i <= this.zzpbq - this.zzphk) {
            this.zzphk += i;
        } else {
            throw zzfhr.zzcxi();
        }
    }

    public static zzfhj zzn(byte[] bArr, int i, int i2) {
        return new zzfhj(bArr, 0, i2);
    }

    public final int getPosition() {
        return this.zzphk - this.zzphj;
    }

    public final byte[] readBytes() throws IOException {
        int zzcui = zzcui();
        if (zzcui < 0) {
            throw zzfhr.zzcxj();
        } else if (zzcui == 0) {
            return zzfhv.zzpif;
        } else {
            if (zzcui > this.zzpbq - this.zzphk) {
                throw zzfhr.zzcxi();
            }
            byte[] bArr = new byte[zzcui];
            System.arraycopy(this.buffer, this.zzphk, bArr, 0, zzcui);
            this.zzphk = zzcui + this.zzphk;
            return bArr;
        }
    }

    public final String readString() throws IOException {
        int zzcui = zzcui();
        if (zzcui < 0) {
            throw zzfhr.zzcxj();
        } else if (zzcui > this.zzpbq - this.zzphk) {
            throw zzfhr.zzcxi();
        } else {
            String str = new String(this.buffer, this.zzphk, zzcui, zzfhq.UTF_8);
            this.zzphk = zzcui + this.zzphk;
            return str;
        }
    }

    public final void zza(zzfhs zzfhs) throws IOException {
        int zzcui = zzcui();
        if (this.zzpbf >= this.zzpbg) {
            throw zzfhr.zzcxl();
        }
        int zzkj = zzkj(zzcui);
        this.zzpbf++;
        zzfhs.zza(this);
        zzkg(0);
        this.zzpbf--;
        zzkk(zzkj);
    }

    public final void zza(zzfhs zzfhs, int i) throws IOException {
        if (this.zzpbf >= this.zzpbg) {
            throw zzfhr.zzcxl();
        }
        this.zzpbf++;
        zzfhs.zza(this);
        zzkg((i << 3) | 4);
        this.zzpbf--;
    }

    public final byte[] zzal(int i, int i2) {
        if (i2 == 0) {
            return zzfhv.zzpif;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzphj + i, bArr, 0, i2);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void zzam(int i, int i2) {
        if (i > this.zzphk - this.zzphj) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.zzphk - this.zzphj).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        } else {
            this.zzphk = this.zzphj + i;
            this.zzpbn = i2;
        }
    }

    public final int zzctt() throws IOException {
        if (this.zzphk == this.zzpbq) {
            this.zzpbn = 0;
            return 0;
        }
        this.zzpbn = zzcui();
        if (this.zzpbn != 0) {
            return this.zzpbn;
        }
        throw new zzfhr("Protocol message contained an invalid tag (zero).");
    }

    public final long zzctv() throws IOException {
        return zzcun();
    }

    public final int zzctw() throws IOException {
        return zzcui();
    }

    public final boolean zzctz() throws IOException {
        return zzcui() != 0;
    }

    public final long zzcuh() throws IOException {
        long zzcun = zzcun();
        return (-(zzcun & 1)) ^ (zzcun >>> 1);
    }

    public final int zzcui() throws IOException {
        byte zzcur = zzcur();
        if (zzcur >= 0) {
            return zzcur;
        }
        byte b = zzcur & Byte.MAX_VALUE;
        byte zzcur2 = zzcur();
        if (zzcur2 >= 0) {
            return b | (zzcur2 << 7);
        }
        byte b2 = b | ((zzcur2 & Byte.MAX_VALUE) << 7);
        byte zzcur3 = zzcur();
        if (zzcur3 >= 0) {
            return b2 | (zzcur3 << 14);
        }
        byte b3 = b2 | ((zzcur3 & Byte.MAX_VALUE) << 14);
        byte zzcur4 = zzcur();
        if (zzcur4 >= 0) {
            return b3 | (zzcur4 << 21);
        }
        byte b4 = b3 | ((zzcur4 & Byte.MAX_VALUE) << 21);
        byte zzcur5 = zzcur();
        byte b5 = b4 | (zzcur5 << 28);
        if (zzcur5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (zzcur() >= 0) {
                return b5;
            }
        }
        throw zzfhr.zzcxk();
    }

    public final int zzcuk() {
        if (this.zzpbo == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzpbo - this.zzphk;
    }

    public final long zzcun() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcur = zzcur();
            j |= ((long) (zzcur & Byte.MAX_VALUE)) << i;
            if ((zzcur & 128) == 0) {
                return j;
            }
        }
        throw zzfhr.zzcxk();
    }

    public final int zzcuo() throws IOException {
        return (zzcur() & 255) | ((zzcur() & 255) << 8) | ((zzcur() & 255) << 16) | ((zzcur() & 255) << 24);
    }

    public final long zzcup() throws IOException {
        byte zzcur = zzcur();
        byte zzcur2 = zzcur();
        return ((((long) zzcur2) & 255) << 8) | (((long) zzcur) & 255) | ((((long) zzcur()) & 255) << 16) | ((((long) zzcur()) & 255) << 24) | ((((long) zzcur()) & 255) << 32) | ((((long) zzcur()) & 255) << 40) | ((((long) zzcur()) & 255) << 48) | ((((long) zzcur()) & 255) << 56);
    }

    public final void zzkg(int i) throws zzfhr {
        if (this.zzpbn != i) {
            throw new zzfhr("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzkh(int i) throws IOException {
        int zzctt;
        switch (i & 7) {
            case 0:
                zzcui();
                return true;
            case 1:
                zzcup();
                return true;
            case 2:
                zzkl(zzcui());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzcuo();
                return true;
            default:
                throw new zzfhr("Protocol message tag had invalid wire type.");
        }
        do {
            zzctt = zzctt();
            if (zzctt == 0 || !zzkh(zzctt)) {
                zzkg(((i >>> 3) << 3) | 4);
                return true;
            }
            zzctt = zzctt();
            zzkg(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzkh(zzctt));
        zzkg(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzkj(int i) throws zzfhr {
        if (i < 0) {
            throw zzfhr.zzcxj();
        }
        int i2 = this.zzphk + i;
        int i3 = this.zzpbo;
        if (i2 > i3) {
            throw zzfhr.zzcxi();
        }
        this.zzpbo = i2;
        zzcuq();
        return i3;
    }

    public final void zzkk(int i) {
        this.zzpbo = i;
        zzcuq();
    }

    public final void zzlw(int i) {
        zzam(i, this.zzpbn);
    }
}
