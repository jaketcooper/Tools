package com.google.android.gms.common.util;

import java.util.HashMap;

public final class zzp {
    public static void zza(StringBuilder sb, HashMap<String, String> hashMap) {
        boolean z;
        sb.append("{");
        boolean z2 = true;
        for (String next : hashMap.keySet()) {
            if (!z2) {
                sb.append(",");
                z = z2;
            } else {
                z = false;
            }
            String str = hashMap.get(next);
            sb.append("\"").append(next).append("\":");
            if (str == null) {
                sb.append("null");
                z2 = z;
            } else {
                sb.append("\"").append(str).append("\"");
                z2 = z;
            }
        }
        sb.append("}");
    }
}
