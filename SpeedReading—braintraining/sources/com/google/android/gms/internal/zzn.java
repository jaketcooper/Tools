package com.google.android.gms.internal;

import android.support.p003v7.widget.helper.ItemTouchHelper;
import java.util.Map;

public final class zzn {
    public final byte[] data;
    private int statusCode;
    private long zzaa;
    public final Map<String, String> zzy;
    public final boolean zzz;

    public zzn(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzy = map;
        this.zzz = z;
        this.zzaa = j;
    }

    public zzn(byte[] bArr, Map<String, String> map) {
        this(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, bArr, map, false, 0);
    }
}
