package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfdh;
import com.google.android.gms.internal.zzfdi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzfdi<MessageType extends zzfdh<MessageType, BuilderType>, BuilderType extends zzfdi<MessageType, BuilderType>> implements zzffr {
    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfez.checkNotNull(iterable);
        if (iterable instanceof zzffl) {
            List<?> zzcwc = ((zzffl) iterable).zzcwc();
            zzffl zzffl = (zzffl) list;
            int size = list.size();
            for (Object next : zzcwc) {
                if (next == null) {
                    String sb = new StringBuilder(37).append("Element at index ").append(zzffl.size() - size).append(" is null.").toString();
                    for (int size2 = zzffl.size() - 1; size2 >= size; size2--) {
                        zzffl.remove(size2);
                    }
                    throw new NullPointerException(sb);
                } else if (!(next instanceof zzfdp)) {
                    zzffl.add((String) next);
                }
            }
        } else if (iterable instanceof zzffv) {
            list.addAll((Collection) iterable);
        } else {
            zzb(iterable, list);
        }
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size = list.size();
        for (T next : iterable) {
            if (next == null) {
                String sb = new StringBuilder(37).append("Element at index ").append(list.size() - size).append(" is null.").toString();
                for (int size2 = list.size() - 1; size2 >= size; size2--) {
                    list.remove(size2);
                }
                throw new NullPointerException(sb);
            }
            list.add(next);
        }
    }

    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zza */
    public abstract BuilderType zzb(zzfdy zzfdy, zzfei zzfei) throws IOException;

    public final /* synthetic */ zzffr zzc(zzffq zzffq) {
        if (zzcvi().getClass().isInstance(zzffq)) {
            return zza((zzfdh) zzffq);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzcth */
    public abstract BuilderType clone();
}
