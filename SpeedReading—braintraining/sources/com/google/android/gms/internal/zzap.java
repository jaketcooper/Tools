package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzap extends ByteArrayOutputStream {
    private final zzae zzbn;

    public zzap(zzae zzae, int i) {
        this.zzbn = zzae;
        this.buf = this.zzbn.zzb(Math.max(i, 256));
    }

    private final void zzc(int i) {
        if (this.count + i > this.buf.length) {
            byte[] zzb = this.zzbn.zzb((this.count + i) << 1);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.zzbn.zza(this.buf);
            this.buf = zzb;
        }
    }

    public final void close() throws IOException {
        this.zzbn.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzbn.zza(this.buf);
    }

    public final synchronized void write(int i) {
        zzc(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzc(i2);
        super.write(bArr, i, i2);
    }
}
