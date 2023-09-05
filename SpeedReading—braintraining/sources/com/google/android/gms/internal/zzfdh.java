package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfdh;
import com.google.android.gms.internal.zzfdi;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class zzfdh<MessageType extends zzfdh<MessageType, BuilderType>, BuilderType extends zzfdi<MessageType, BuilderType>> implements zzffq {
    private static boolean zzpau = false;
    protected int zzpat = 0;

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfdi.zza(iterable, list);
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzhl()];
            zzfed zzbb = zzfed.zzbb(bArr);
            zza(zzbb);
            zzbb.zzcut();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length()).append("Serializing ").append(name).append(" to a ").append("byte array").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    public final zzfdp toByteString() {
        try {
            zzfdu zzkf = zzfdp.zzkf(zzhl());
            zza(zzkf.zzcts());
            return zzkf.zzctr();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ").append("ByteString").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        zzfed zzb = zzfed.zzb(outputStream, zzfed.zzks(zzhl()));
        zza(zzb);
        zzb.flush();
    }
}
