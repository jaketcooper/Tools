package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzfgd extends zzfgc<FieldDescriptorType, Object> {
    zzfgd(int i) {
        super(i, (zzfgd) null);
    }

    public final void zzbin() {
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzcwk()) {
                    break;
                }
                Map.Entry zzlr = zzlr(i2);
                if (((zzfel) zzlr.getKey()).zzcvd()) {
                    zzlr.setValue(Collections.unmodifiableList((List) zzlr.getValue()));
                }
                i = i2 + 1;
            }
            for (Map.Entry entry : zzcwl()) {
                if (((zzfel) entry.getKey()).zzcvd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbin();
    }
}
