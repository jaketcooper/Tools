package com.google.firebase.iid;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public final class zzj {
    private static final Object sLock = new Object();
    private final zzab zznut;

    zzj(zzab zzab) {
        this.zznut = zzab;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final String zzchg() {
        String str = null;
        synchronized (sLock) {
            String string = this.zznut.zzids.getString("topic_operaion_queue", (String) null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void zzqq(String str) {
        synchronized (sLock) {
            String string = this.zznut.zzids.getString("topic_operaion_queue", "");
            this.zznut.zzids.edit().putString("topic_operaion_queue", new StringBuilder(String.valueOf(string).length() + String.valueOf(",").length() + String.valueOf(str).length()).append(string).append(",").append(str).toString()).apply();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzqt(String str) {
        boolean z;
        synchronized (sLock) {
            String string = this.zznut.zzids.getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                String valueOf3 = String.valueOf(",");
                String valueOf4 = String.valueOf(str);
                this.zznut.zzids.edit().putString("topic_operaion_queue", string.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length())).apply();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
