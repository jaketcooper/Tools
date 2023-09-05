package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbej;

public abstract class StatsEvent extends zzbej implements ReflectedParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long zzals = zzals();
        String zzalt = zzalt();
        return new StringBuilder(String.valueOf("\t").length() + 51 + String.valueOf("\t").length() + String.valueOf(zzalt).length()).append(timeMillis).append("\t").append(eventType).append("\t").append(zzals).append(zzalt).toString();
    }

    public abstract long zzals();

    public abstract String zzalt();
}
