package com.google.android.gms.internal;

import com.github.mikephil.charting.utils.Utils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class zzfft {
    static String zza(zzffq zzffq, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(str);
        zza(zzffq, sb, 0);
        return sb.toString();
    }

    private static void zza(zzffq zzffq, StringBuilder sb, int i) {
        boolean booleanValue;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzffq.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String replaceFirst : treeSet) {
            String replaceFirst2 = replaceFirst.replaceFirst("get", "");
            if (replaceFirst2.endsWith("List") && !replaceFirst2.endsWith("OrBuilderList")) {
                String valueOf = String.valueOf(replaceFirst2.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst2.substring(1, replaceFirst2.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                String valueOf3 = String.valueOf(replaceFirst2);
                Method method2 = (Method) hashMap.get(valueOf3.length() != 0 ? "get".concat(valueOf3) : new String("get"));
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zztg(concat), zzfem.zza(method2, (Object) zzffq, new Object[0]));
                }
            }
            String valueOf4 = String.valueOf(replaceFirst2);
            if (((Method) hashMap2.get(valueOf4.length() != 0 ? "set".concat(valueOf4) : new String("set"))) != null) {
                if (replaceFirst2.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(replaceFirst2.substring(0, replaceFirst2.length() - 5));
                    if (hashMap.containsKey(valueOf5.length() != 0 ? "get".concat(valueOf5) : new String("get"))) {
                    }
                }
                String valueOf6 = String.valueOf(replaceFirst2.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(replaceFirst2.substring(1));
                String concat2 = valueOf7.length() != 0 ? valueOf6.concat(valueOf7) : new String(valueOf6);
                String valueOf8 = String.valueOf(replaceFirst2);
                Method method3 = (Method) hashMap.get(valueOf8.length() != 0 ? "get".concat(valueOf8) : new String("get"));
                String valueOf9 = String.valueOf(replaceFirst2);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "has".concat(valueOf9) : new String("has"));
                if (method3 != null) {
                    Object zza = zzfem.zza(method3, (Object) zzffq, new Object[0]);
                    if (method4 == null) {
                        booleanValue = !(zza instanceof Boolean ? !((Boolean) zza).booleanValue() : zza instanceof Integer ? ((Integer) zza).intValue() == 0 : zza instanceof Float ? (((Float) zza).floatValue() > 0.0f ? 1 : (((Float) zza).floatValue() == 0.0f ? 0 : -1)) == 0 : zza instanceof Double ? (((Double) zza).doubleValue() > Utils.DOUBLE_EPSILON ? 1 : (((Double) zza).doubleValue() == Utils.DOUBLE_EPSILON ? 0 : -1)) == 0 : zza instanceof String ? zza.equals("") : zza instanceof zzfdp ? zza.equals(zzfdp.zzpaz) : zza instanceof zzffq ? zza == ((zzffq) zza).zzcvi() : zza instanceof Enum ? ((Enum) zza).ordinal() == 0 : false);
                    } else {
                        booleanValue = ((Boolean) zzfem.zza(method4, (Object) zzffq, new Object[0])).booleanValue();
                    }
                    if (booleanValue) {
                        zzb(sb, i, zztg(concat2), zza);
                    }
                }
            }
        }
        if (zzffq instanceof zzfer) {
            Iterator<Map.Entry<Object, Object>> it = ((zzfer) zzffq).zzpcn.iterator();
            if (it.hasNext()) {
                it.next().getKey();
                throw new NoSuchMethodError();
            }
        }
        if (((zzfem) zzffq).zzpcg != null) {
            ((zzfem) zzffq).zzpcg.zzd(sb, i);
        }
    }

    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
            return;
        }
        sb.append(10);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"").append(zzfgk.zzaq(zzfdp.zztc((String) obj))).append('\"');
        } else if (obj instanceof zzfdp) {
            sb.append(": \"").append(zzfgk.zzaq((zzfdp) obj)).append('\"');
        } else if (obj instanceof zzfem) {
            sb.append(" {");
            zza((zzfem) obj, sb, i + 2);
            sb.append("\n");
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append("}");
        } else {
            sb.append(": ").append(obj.toString());
        }
    }

    private static final String zztg(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
