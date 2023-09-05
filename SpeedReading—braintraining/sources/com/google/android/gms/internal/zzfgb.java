package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;

final class zzfgb extends InputStream {
    private int mark;
    private zzfga zzped;
    private zzfdv zzpee;
    private int zzpef;
    private int zzpeg;
    private int zzpeh;
    private /* synthetic */ zzffx zzpei;

    public zzfgb(zzffx zzffx) {
        this.zzpei = zzffx;
        initialize();
    }

    private final void initialize() {
        this.zzped = new zzfga(this.zzpei);
        this.zzpee = (zzfdv) this.zzped.next();
        this.zzpef = this.zzpee.size();
        this.zzpeg = 0;
        this.zzpeh = 0;
    }

    private final void zzcwj() {
        if (this.zzpee != null && this.zzpeg == this.zzpef) {
            this.zzpeh += this.zzpef;
            this.zzpeg = 0;
            if (this.zzped.hasNext()) {
                this.zzpee = (zzfdv) this.zzped.next();
                this.zzpef = this.zzpee.size();
                return;
            }
            this.zzpee = null;
            this.zzpef = 0;
        }
    }

    private final int zzj(byte[] bArr, int i, int i2) {
        int i3 = i2;
        int i4 = i;
        while (true) {
            if (i3 <= 0) {
                break;
            }
            zzcwj();
            if (this.zzpee != null) {
                int min = Math.min(this.zzpef - this.zzpeg, i3);
                if (bArr != null) {
                    this.zzpee.zza(bArr, this.zzpeg, i4, min);
                    i4 += min;
                }
                this.zzpeg += min;
                i3 -= min;
            } else if (i3 == i2) {
                return -1;
            }
        }
        return i2 - i3;
    }

    public final int available() throws IOException {
        return this.zzpei.size() - (this.zzpeh + this.zzpeg);
    }

    public final void mark(int i) {
        this.mark = this.zzpeh + this.zzpeg;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() throws IOException {
        zzcwj();
        if (this.zzpee == null) {
            return -1;
        }
        zzfdv zzfdv = this.zzpee;
        int i = this.zzpeg;
        this.zzpeg = i + 1;
        return zzfdv.zzke(i) & 255;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
            return zzj(bArr, i, i2);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public final synchronized void reset() {
        initialize();
        zzj((byte[]) null, 0, this.mark);
    }

    public final long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return (long) zzj((byte[]) null, 0, (int) j);
    }
}
