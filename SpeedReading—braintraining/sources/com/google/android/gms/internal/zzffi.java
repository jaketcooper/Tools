package com.google.android.gms.internal;

import java.util.Map;

final class zzffi<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzffg> zzpdj;

    private zzffi(Map.Entry<K, zzffg> entry) {
        this.zzpdj = entry;
    }

    public final K getKey() {
        return this.zzpdj.getKey();
    }

    public final Object getValue() {
        if (this.zzpdj.getValue() == null) {
            return null;
        }
        return zzffg.zzcwb();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzffq) {
            return this.zzpdj.getValue().zzj((zzffq) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
