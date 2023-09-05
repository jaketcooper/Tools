package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzfhp implements Cloneable {
    private Object value;
    private zzfhn<?, ?> zzphs;
    private List<zzfhu> zzpht = new ArrayList();

    zzfhp() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzo()];
        zza(zzfhk.zzbe(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcxh */
    public zzfhp clone() {
        int i = 0;
        zzfhp zzfhp = new zzfhp();
        try {
            zzfhp.zzphs = this.zzphs;
            if (this.zzpht == null) {
                zzfhp.zzpht = null;
            } else {
                zzfhp.zzpht.addAll(this.zzpht);
            }
            if (this.value != null) {
                if (this.value instanceof zzfhs) {
                    zzfhp.value = (zzfhs) ((zzfhs) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzfhp.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzfhp.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzfhp.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzfhp.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzfhp.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzfhp.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzfhp.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzfhs[]) {
                    zzfhs[] zzfhsArr = (zzfhs[]) this.value;
                    zzfhs[] zzfhsArr2 = new zzfhs[zzfhsArr.length];
                    zzfhp.value = zzfhsArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzfhsArr.length) {
                            break;
                        }
                        zzfhsArr2[i3] = (zzfhs) zzfhsArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzfhp;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfhp)) {
            return false;
        }
        zzfhp zzfhp = (zzfhp) obj;
        if (this.value == null || zzfhp.value == null) {
            if (this.zzpht != null && zzfhp.zzpht != null) {
                return this.zzpht.equals(zzfhp.zzpht);
            }
            try {
                return Arrays.equals(toByteArray(), zzfhp.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzphs == zzfhp.zzphs) {
            return !this.zzphs.zznbf.isArray() ? this.value.equals(zzfhp.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzfhp.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzfhp.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzfhp.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzfhp.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzfhp.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzfhp.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzfhp.value);
        } else {
            return false;
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.value != null) {
            zzfhn<?, ?> zzfhn = this.zzphs;
            Object obj = this.value;
            if (zzfhn.zzphn) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzfhn.zza(obj2, zzfhk);
                    }
                }
                return;
            }
            zzfhn.zza(obj, zzfhk);
            return;
        }
        for (zzfhu next : this.zzpht) {
            zzfhk.zzly(next.tag);
            zzfhk.zzbg(next.zzjkv);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfhu zzfhu) {
        this.zzpht.add(zzfhu);
    }

    /* access modifiers changed from: package-private */
    public final <T> T zzb(zzfhn<?, T> zzfhn) {
        if (this.value == null) {
            this.zzphs = zzfhn;
            this.value = zzfhn.zzbp(this.zzpht);
            this.zzpht = null;
        } else if (!this.zzphs.equals(zzfhn)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    /* access modifiers changed from: package-private */
    public final int zzo() {
        int i = 0;
        if (this.value != null) {
            zzfhn<?, ?> zzfhn = this.zzphs;
            Object obj = this.value;
            if (!zzfhn.zzphn) {
                return zzfhn.zzcl(obj);
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                if (Array.get(obj, i2) != null) {
                    i += zzfhn.zzcl(Array.get(obj, i2));
                }
            }
            return i;
        }
        Iterator<zzfhu> it = this.zzpht.iterator();
        while (true) {
            int i3 = i;
            if (!it.hasNext()) {
                return i3;
            }
            zzfhu next = it.next();
            i = next.zzjkv.length + zzfhk.zzlz(next.tag) + 0 + i3;
        }
    }
}
