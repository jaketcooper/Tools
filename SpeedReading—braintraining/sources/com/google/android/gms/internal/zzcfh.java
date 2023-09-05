package com.google.android.gms.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.common.internal.zzbq;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzcfh extends zzcii {
    zzcfh(zzchj zzchj) {
        super(zzchj);
    }

    private final Boolean zza(double d, zzckr zzckr) {
        try {
            return zza(new BigDecimal(d), zzckr, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(long j, zzckr zzckr) {
        try {
            return zza(new BigDecimal(j), zzckr, (double) Utils.DOUBLE_EPSILON);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(zzckp zzckp, zzcky zzcky, long j) {
        Boolean zza;
        if (zzckp.zzjhp != null) {
            Boolean zza2 = zza(j, zzckp.zzjhp);
            if (zza2 == null) {
                return null;
            }
            if (!zza2.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzckq zzckq : zzckp.zzjhn) {
            if (TextUtils.isEmpty(zzckq.zzjhu)) {
                zzawn().zzayu().zzj("null or empty param name in filter. event", zzawi().zzjc(zzcky.name));
                return null;
            }
            hashSet.add(zzckq.zzjhu);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzckz zzckz : zzcky.zzjiw) {
            if (hashSet.contains(zzckz.name)) {
                if (zzckz.zzjja != null) {
                    arrayMap.put(zzckz.name, zzckz.zzjja);
                } else if (zzckz.zzjha != null) {
                    arrayMap.put(zzckz.name, zzckz.zzjha);
                } else if (zzckz.zzfzs != null) {
                    arrayMap.put(zzckz.name, zzckz.zzfzs);
                } else {
                    zzawn().zzayu().zze("Unknown value for param. event, param", zzawi().zzjc(zzcky.name), zzawi().zzjd(zzckz.name));
                    return null;
                }
            }
        }
        for (zzckq zzckq2 : zzckp.zzjhn) {
            boolean equals = Boolean.TRUE.equals(zzckq2.zzjht);
            String str = zzckq2.zzjhu;
            if (TextUtils.isEmpty(str)) {
                zzawn().zzayu().zzj("Event has empty param name. event", zzawi().zzjc(zzcky.name));
                return null;
            }
            Object obj = arrayMap.get(str);
            if (obj instanceof Long) {
                if (zzckq2.zzjhs == null) {
                    zzawn().zzayu().zze("No number filter for long param. event, param", zzawi().zzjc(zzcky.name), zzawi().zzjd(str));
                    return null;
                }
                Boolean zza3 = zza(((Long) obj).longValue(), zzckq2.zzjhs);
                if (zza3 == null) {
                    return null;
                }
                if ((!zza3.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (zzckq2.zzjhs == null) {
                    zzawn().zzayu().zze("No number filter for double param. event, param", zzawi().zzjc(zzcky.name), zzawi().zzjd(str));
                    return null;
                }
                Boolean zza4 = zza(((Double) obj).doubleValue(), zzckq2.zzjhs);
                if (zza4 == null) {
                    return null;
                }
                if ((!zza4.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (zzckq2.zzjhr != null) {
                    zza = zza((String) obj, zzckq2.zzjhr);
                } else if (zzckq2.zzjhs == null) {
                    zzawn().zzayu().zze("No filter for String param. event, param", zzawi().zzjc(zzcky.name), zzawi().zzjd(str));
                    return null;
                } else if (zzckn.zzkf((String) obj)) {
                    zza = zza((String) obj, zzckq2.zzjhs);
                } else {
                    zzawn().zzayu().zze("Invalid param value for number filter. event, param", zzawi().zzjc(zzcky.name), zzawi().zzjd(str));
                    return null;
                }
                if (zza == null) {
                    return null;
                }
                if ((!zza.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj == null) {
                zzawn().zzayy().zze("Missing param for filter. event, param", zzawi().zzjc(zzcky.name), zzawi().zzjd(str));
                return false;
            } else {
                zzawn().zzayu().zze("Unknown param type. event, param", zzawi().zzjc(zzcky.name), zzawi().zzjd(str));
                return null;
            }
        }
        return true;
    }

    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    zzawn().zzayu().zzj("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(String str, zzckr zzckr) {
        if (!zzckn.zzkf(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzckr, (double) Utils.DOUBLE_EPSILON);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(String str, zzckt zzckt) {
        List arrayList;
        String str2 = null;
        zzbq.checkNotNull(zzckt);
        if (str == null || zzckt.zzjid == null || zzckt.zzjid.intValue() == 0) {
            return null;
        }
        if (zzckt.zzjid.intValue() == 6) {
            if (zzckt.zzjig == null || zzckt.zzjig.length == 0) {
                return null;
            }
        } else if (zzckt.zzjie == null) {
            return null;
        }
        int intValue = zzckt.zzjid.intValue();
        boolean z = zzckt.zzjif != null && zzckt.zzjif.booleanValue();
        String upperCase = (z || intValue == 1 || intValue == 6) ? zzckt.zzjie : zzckt.zzjie.toUpperCase(Locale.ENGLISH);
        if (zzckt.zzjig == null) {
            arrayList = null;
        } else {
            String[] strArr = zzckt.zzjig;
            if (z) {
                arrayList = Arrays.asList(strArr);
            } else {
                arrayList = new ArrayList();
                for (String upperCase2 : strArr) {
                    arrayList.add(upperCase2.toUpperCase(Locale.ENGLISH));
                }
            }
        }
        if (intValue == 1) {
            str2 = upperCase;
        }
        return zza(str, intValue, z, upperCase, arrayList, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        if (r5 != null) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r10, com.google.android.gms.internal.zzckr r11, double r12) {
        /*
            r8 = 4
            r7 = -1
            r1 = 0
            r0 = 1
            r2 = 0
            com.google.android.gms.common.internal.zzbq.checkNotNull(r11)
            java.lang.Integer r3 = r11.zzjhv
            if (r3 == 0) goto L_0x0014
            java.lang.Integer r3 = r11.zzjhv
            int r3 = r3.intValue()
            if (r3 != 0) goto L_0x0016
        L_0x0014:
            r0 = r2
        L_0x0015:
            return r0
        L_0x0016:
            java.lang.Integer r3 = r11.zzjhv
            int r3 = r3.intValue()
            if (r3 != r8) goto L_0x0028
            java.lang.String r3 = r11.zzjhy
            if (r3 == 0) goto L_0x0026
            java.lang.String r3 = r11.zzjhz
            if (r3 != 0) goto L_0x002e
        L_0x0026:
            r0 = r2
            goto L_0x0015
        L_0x0028:
            java.lang.String r3 = r11.zzjhx
            if (r3 != 0) goto L_0x002e
            r0 = r2
            goto L_0x0015
        L_0x002e:
            java.lang.Integer r3 = r11.zzjhv
            int r6 = r3.intValue()
            java.lang.Integer r3 = r11.zzjhv
            int r3 = r3.intValue()
            if (r3 != r8) goto L_0x0066
            java.lang.String r3 = r11.zzjhy
            boolean r3 = com.google.android.gms.internal.zzckn.zzkf(r3)
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = r11.zzjhz
            boolean r3 = com.google.android.gms.internal.zzckn.zzkf(r3)
            if (r3 != 0) goto L_0x004e
        L_0x004c:
            r0 = r2
            goto L_0x0015
        L_0x004e:
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r3 = r11.zzjhy     // Catch:{ NumberFormatException -> 0x0063 }
            r4.<init>(r3)     // Catch:{ NumberFormatException -> 0x0063 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r5 = r11.zzjhz     // Catch:{ NumberFormatException -> 0x0063 }
            r3.<init>(r5)     // Catch:{ NumberFormatException -> 0x0063 }
            r5 = r2
        L_0x005d:
            if (r6 != r8) goto L_0x007e
            if (r4 != 0) goto L_0x0080
            r0 = r2
            goto L_0x0015
        L_0x0063:
            r0 = move-exception
            r0 = r2
            goto L_0x0015
        L_0x0066:
            java.lang.String r3 = r11.zzjhx
            boolean r3 = com.google.android.gms.internal.zzckn.zzkf(r3)
            if (r3 != 0) goto L_0x0070
            r0 = r2
            goto L_0x0015
        L_0x0070:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x007b }
            java.lang.String r4 = r11.zzjhx     // Catch:{ NumberFormatException -> 0x007b }
            r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x007b }
            r4 = r2
            r5 = r3
            r3 = r2
            goto L_0x005d
        L_0x007b:
            r0 = move-exception
            r0 = r2
            goto L_0x0015
        L_0x007e:
            if (r5 == 0) goto L_0x0083
        L_0x0080:
            switch(r6) {
                case 1: goto L_0x0085;
                case 2: goto L_0x0092;
                case 3: goto L_0x00a0;
                case 4: goto L_0x00ee;
                default: goto L_0x0083;
            }
        L_0x0083:
            r0 = r2
            goto L_0x0015
        L_0x0085:
            int r2 = r10.compareTo(r5)
            if (r2 != r7) goto L_0x0090
        L_0x008b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x0090:
            r0 = r1
            goto L_0x008b
        L_0x0092:
            int r2 = r10.compareTo(r5)
            if (r2 != r0) goto L_0x009e
        L_0x0098:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x009e:
            r0 = r1
            goto L_0x0098
        L_0x00a0:
            r2 = 0
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00e0
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r12)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r4 = 2
            r3.<init>(r4)
            java.math.BigDecimal r2 = r2.multiply(r3)
            java.math.BigDecimal r2 = r5.subtract(r2)
            int r2 = r10.compareTo(r2)
            if (r2 != r0) goto L_0x00de
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r12)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r4 = 2
            r3.<init>(r4)
            java.math.BigDecimal r2 = r2.multiply(r3)
            java.math.BigDecimal r2 = r5.add(r2)
            int r2 = r10.compareTo(r2)
            if (r2 != r7) goto L_0x00de
        L_0x00d8:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x00de:
            r0 = r1
            goto L_0x00d8
        L_0x00e0:
            int r2 = r10.compareTo(r5)
            if (r2 != 0) goto L_0x00ec
        L_0x00e6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x00ec:
            r0 = r1
            goto L_0x00e6
        L_0x00ee:
            int r2 = r10.compareTo(r4)
            if (r2 == r7) goto L_0x0100
            int r2 = r10.compareTo(r3)
            if (r2 == r0) goto L_0x0100
        L_0x00fa:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x0100:
            r0 = r1
            goto L_0x00fa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcfh.zza(java.math.BigDecimal, com.google.android.gms.internal.zzckr, double):java.lang.Boolean");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzckx[] zza(String str, zzcky[] zzckyArr, zzcld[] zzcldArr) {
        Map map;
        Boolean bool;
        zzcft zzayl;
        Map map2;
        zzbq.zzgi(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map<Integer, zzclc> zziz = zzawh().zziz(str);
        if (zziz != null) {
            for (Integer intValue : zziz.keySet()) {
                int intValue2 = intValue.intValue();
                zzclc zzclc = zziz.get(Integer.valueOf(intValue2));
                BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue2));
                BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue2));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue2), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue2), bitSet2);
                }
                for (int i = 0; i < (zzclc.zzjke.length << 6); i++) {
                    if (zzckn.zza(zzclc.zzjke, i)) {
                        zzawn().zzayy().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzckn.zza(zzclc.zzjkf, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzckx zzckx = new zzckx();
                arrayMap.put(Integer.valueOf(intValue2), zzckx);
                zzckx.zzjiu = false;
                zzckx.zzjit = zzclc;
                zzckx.zzjis = new zzclc();
                zzckx.zzjis.zzjkf = zzckn.zza(bitSet);
                zzckx.zzjis.zzjke = zzckn.zza(bitSet2);
            }
        }
        if (zzckyArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            int length = zzckyArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                zzcky zzcky = zzckyArr[i3];
                zzcft zzae = zzawh().zzae(str, zzcky.name);
                if (zzae == null) {
                    zzawn().zzayu().zze("Event aggregate wasn't created during raw event logging. appId, event", zzcgj.zzjf(str), zzawi().zzjc(zzcky.name));
                    zzayl = new zzcft(str, zzcky.name, 1, 1, zzcky.zzjix.longValue(), 0, (Long) null, (Long) null, (Boolean) null);
                } else {
                    zzayl = zzae.zzayl();
                }
                zzawh().zza(zzayl);
                long j = zzayl.zziwz;
                Map map3 = (Map) arrayMap4.get(zzcky.name);
                if (map3 == null) {
                    Map zzaj = zzawh().zzaj(str, zzcky.name);
                    if (zzaj == null) {
                        zzaj = new ArrayMap();
                    }
                    arrayMap4.put(zzcky.name, zzaj);
                    map2 = zzaj;
                } else {
                    map2 = map3;
                }
                for (Integer intValue3 : map2.keySet()) {
                    int intValue4 = intValue3.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        zzawn().zzayy().zzj("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        zzckx zzckx2 = (zzckx) arrayMap.get(Integer.valueOf(intValue4));
                        BitSet bitSet3 = (BitSet) arrayMap2.get(Integer.valueOf(intValue4));
                        BitSet bitSet4 = (BitSet) arrayMap3.get(Integer.valueOf(intValue4));
                        if (zzckx2 == null) {
                            zzckx zzckx3 = new zzckx();
                            arrayMap.put(Integer.valueOf(intValue4), zzckx3);
                            zzckx3.zzjiu = true;
                            bitSet3 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue4), bitSet3);
                            bitSet4 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue4), bitSet4);
                        }
                        for (zzckp zzckp : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (zzawn().zzae(2)) {
                                zzawn().zzayy().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue4), zzckp.zzjhl, zzawi().zzjc(zzckp.zzjhm));
                                zzawn().zzayy().zzj("Filter definition", zzawi().zza(zzckp));
                            }
                            if (zzckp.zzjhl == null || zzckp.zzjhl.intValue() > 256) {
                                zzawn().zzayu().zze("Invalid event filter ID. appId, id", zzcgj.zzjf(str), String.valueOf(zzckp.zzjhl));
                            } else if (bitSet3.get(zzckp.zzjhl.intValue())) {
                                zzawn().zzayy().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), zzckp.zzjhl);
                            } else {
                                Boolean zza = zza(zzckp, zzcky, j);
                                zzawn().zzayy().zzj("Event filter result", zza == null ? "null" : zza);
                                if (zza == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet4.set(zzckp.zzjhl.intValue());
                                    if (zza.booleanValue()) {
                                        bitSet3.set(zzckp.zzjhl.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        if (zzcldArr != null) {
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzcld zzcld : zzcldArr) {
                Map map4 = (Map) arrayMap5.get(zzcld.name);
                if (map4 == null) {
                    Map zzak = zzawh().zzak(str, zzcld.name);
                    if (zzak == null) {
                        zzak = new ArrayMap();
                    }
                    arrayMap5.put(zzcld.name, zzak);
                    map = zzak;
                } else {
                    map = map4;
                }
                for (Integer intValue5 : map.keySet()) {
                    int intValue6 = intValue5.intValue();
                    if (!hashSet.contains(Integer.valueOf(intValue6))) {
                        zzckx zzckx4 = (zzckx) arrayMap.get(Integer.valueOf(intValue6));
                        BitSet bitSet5 = (BitSet) arrayMap2.get(Integer.valueOf(intValue6));
                        BitSet bitSet6 = (BitSet) arrayMap3.get(Integer.valueOf(intValue6));
                        if (zzckx4 == null) {
                            zzckx zzckx5 = new zzckx();
                            arrayMap.put(Integer.valueOf(intValue6), zzckx5);
                            zzckx5.zzjiu = true;
                            bitSet5 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue6), bitSet5);
                            bitSet6 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue6), bitSet6);
                        }
                        Iterator it = ((List) map.get(Integer.valueOf(intValue6))).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            zzcks zzcks = (zzcks) it.next();
                            if (zzawn().zzae(2)) {
                                zzawn().zzayy().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue6), zzcks.zzjhl, zzawi().zzje(zzcks.zzjib));
                                zzawn().zzayy().zzj("Filter definition", zzawi().zza(zzcks));
                            }
                            if (zzcks.zzjhl == null || zzcks.zzjhl.intValue() > 256) {
                                zzawn().zzayu().zze("Invalid property filter ID. appId, id", zzcgj.zzjf(str), String.valueOf(zzcks.zzjhl));
                                hashSet.add(Integer.valueOf(intValue6));
                            } else if (bitSet5.get(zzcks.zzjhl.intValue())) {
                                zzawn().zzayy().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue6), zzcks.zzjhl);
                            } else {
                                zzckq zzckq = zzcks.zzjic;
                                if (zzckq == null) {
                                    zzawn().zzayu().zzj("Missing property filter. property", zzawi().zzje(zzcld.name));
                                    bool = null;
                                } else {
                                    boolean equals = Boolean.TRUE.equals(zzckq.zzjht);
                                    if (zzcld.zzjja != null) {
                                        if (zzckq.zzjhs == null) {
                                            zzawn().zzayu().zzj("No number filter for long property. property", zzawi().zzje(zzcld.name));
                                            bool = null;
                                        } else {
                                            bool = zza(zza(zzcld.zzjja.longValue(), zzckq.zzjhs), equals);
                                        }
                                    } else if (zzcld.zzjha != null) {
                                        if (zzckq.zzjhs == null) {
                                            zzawn().zzayu().zzj("No number filter for double property. property", zzawi().zzje(zzcld.name));
                                            bool = null;
                                        } else {
                                            bool = zza(zza(zzcld.zzjha.doubleValue(), zzckq.zzjhs), equals);
                                        }
                                    } else if (zzcld.zzfzs == null) {
                                        zzawn().zzayu().zzj("User property has no value, property", zzawi().zzje(zzcld.name));
                                        bool = null;
                                    } else if (zzckq.zzjhr == null) {
                                        if (zzckq.zzjhs == null) {
                                            zzawn().zzayu().zzj("No string or number filter defined. property", zzawi().zzje(zzcld.name));
                                        } else if (zzckn.zzkf(zzcld.zzfzs)) {
                                            bool = zza(zza(zzcld.zzfzs, zzckq.zzjhs), equals);
                                        } else {
                                            zzawn().zzayu().zze("Invalid user property value for Numeric number filter. property, value", zzawi().zzje(zzcld.name), zzcld.zzfzs);
                                        }
                                        bool = null;
                                    } else {
                                        bool = zza(zza(zzcld.zzfzs, zzckq.zzjhr), equals);
                                    }
                                }
                                zzawn().zzayy().zzj("Property filter result", bool == null ? "null" : bool);
                                if (bool == null) {
                                    hashSet.add(Integer.valueOf(intValue6));
                                } else {
                                    bitSet6.set(zzcks.zzjhl.intValue());
                                    if (bool.booleanValue()) {
                                        bitSet5.set(zzcks.zzjhl.intValue());
                                    }
                                }
                            }
                        }
                    } else {
                        zzawn().zzayy().zzj("Skipping failed audience ID", Integer.valueOf(intValue6));
                    }
                }
            }
        }
        zzckx[] zzckxArr = new zzckx[arrayMap2.size()];
        int i4 = 0;
        for (Integer intValue7 : arrayMap2.keySet()) {
            int intValue8 = intValue7.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue8))) {
                zzckx zzckx6 = (zzckx) arrayMap.get(Integer.valueOf(intValue8));
                zzckx zzckx7 = zzckx6 == null ? new zzckx() : zzckx6;
                int i5 = i4 + 1;
                zzckxArr[i4] = zzckx7;
                zzckx7.zzjhh = Integer.valueOf(intValue8);
                zzckx7.zzjis = new zzclc();
                zzckx7.zzjis.zzjkf = zzckn.zza((BitSet) arrayMap2.get(Integer.valueOf(intValue8)));
                zzckx7.zzjis.zzjke = zzckn.zza((BitSet) arrayMap3.get(Integer.valueOf(intValue8)));
                zzcfl zzawh = zzawh();
                zzclc zzclc2 = zzckx7.zzjis;
                zzawh.zzwu();
                zzawh.zzut();
                zzbq.zzgi(str);
                zzbq.checkNotNull(zzclc2);
                try {
                    byte[] bArr = new byte[zzclc2.zzhl()];
                    zzfhk zzo = zzfhk.zzo(bArr, 0, bArr.length);
                    zzclc2.zza(zzo);
                    zzo.zzcut();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(intValue8));
                    contentValues.put("current_results", bArr);
                    try {
                        if (zzawh.getWritableDatabase().insertWithOnConflict("audience_filter_values", (String) null, contentValues, 5) == -1) {
                            zzawh.zzawn().zzays().zzj("Failed to insert filter results (got -1). appId", zzcgj.zzjf(str));
                        }
                        i4 = i5;
                    } catch (SQLiteException e) {
                        zzawh.zzawn().zzays().zze("Error storing filter results. appId", zzcgj.zzjf(str), e);
                        i4 = i5;
                    }
                } catch (IOException e2) {
                    zzawh.zzawn().zzays().zze("Configuration loss. Failed to serialize filter results. appId", zzcgj.zzjf(str), e2);
                    i4 = i5;
                }
            }
        }
        return (zzckx[]) Arrays.copyOf(zzckxArr, i4);
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return false;
    }
}
