package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class zzhc {
    private ByteArrayOutputStream zzazn = new ByteArrayOutputStream(4096);
    private Base64OutputStream zzazo = new Base64OutputStream(this.zzazn, 10);

    public final String toString() {
        String str;
        try {
            this.zzazo.close();
        } catch (IOException e) {
            zzafj.zzb("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzazn.close();
            str = this.zzazn.toString();
        } catch (IOException e2) {
            zzafj.zzb("HashManager: Unable to convert to Base64.", e2);
            str = "";
        } finally {
            this.zzazn = null;
            this.zzazo = null;
        }
        return str;
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzazo.write(bArr);
    }
}
