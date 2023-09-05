package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzbs;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@zzzb
public final class zzsl {
    private final Map<zzsm, zzsn> zzbxw = new HashMap();
    private final LinkedList<zzsm> zzbxx = new LinkedList<>();
    @Nullable
    private zzri zzbxy;

    private static void zza(String str, zzsm zzsm) {
        if (zzafj.zzae(2)) {
            zzafj.m11v(String.format(str, new Object[]{zzsm}));
        }
    }

    private static String[] zzaw(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private static boolean zzax(String str) {
        try {
            return Pattern.matches((String) zzbs.zzep().zzd(zzmq.zzbkn), str);
        } catch (RuntimeException e) {
            zzbs.zzeg().zza((Throwable) e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    private static String zzay(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            return matcher.matches() ? matcher.group(1) : str;
        } catch (RuntimeException e) {
            return str;
        }
    }

    private static void zzc(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split("/", 2);
            if (split.length != 0) {
                String str2 = split[0];
                if (split.length == 1) {
                    bundle.remove(str2);
                    return;
                }
                bundle = bundle.getBundle(str2);
                if (bundle != null) {
                    str = split[1];
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    static Set<String> zzi(zzis zzis) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(zzis.extras.keySet());
        Bundle bundle = zzis.zzbcf.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    static zzis zzj(zzis zzis) {
        zzis zzl = zzl(zzis);
        Bundle bundle = zzl.zzbcf.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean("_skipMediation", true);
        }
        zzl.extras.putBoolean("_skipMediation", true);
        return zzl;
    }

    private static zzis zzk(zzis zzis) {
        zzis zzl = zzl(zzis);
        for (String str : ((String) zzbs.zzep().zzd(zzmq.zzbkj)).split(",")) {
            zzc(zzl.zzbcf, str);
            if (str.startsWith("com.google.ads.mediation.admob.AdMobAdapter/")) {
                zzc(zzl.extras, str.replaceFirst("com.google.ads.mediation.admob.AdMobAdapter/", ""));
            }
        }
        return zzl;
    }

    private final String zzkq() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.zzbxx.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(((zzsm) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static zzis zzl(zzis zzis) {
        Parcel obtain = Parcel.obtain();
        zzis.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        zzis createFromParcel = zzis.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (((Boolean) zzbs.zzep().zzd(zzmq.zzbjy)).booleanValue()) {
            zzis.zzh(createFromParcel);
        }
        return createFromParcel;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final zzso zza(zzis zzis, String str) {
        zzsn zzsn;
        if (zzax(str)) {
            return null;
        }
        int i = new zzabv(this.zzbxy.getApplicationContext()).zzns().zzcsg;
        zzis zzk = zzk(zzis);
        String zzay = zzay(str);
        zzsm zzsm = new zzsm(zzk, zzay, i);
        zzsn zzsn2 = this.zzbxw.get(zzsm);
        if (zzsn2 == null) {
            zza("Interstitial pool created at %s.", zzsm);
            zzsn zzsn3 = new zzsn(zzk, zzay, i);
            this.zzbxw.put(zzsm, zzsn3);
            zzsn = zzsn3;
        } else {
            zzsn = zzsn2;
        }
        this.zzbxx.remove(zzsm);
        this.zzbxx.add(zzsm);
        zzsn.zzku();
        while (true) {
            if (this.zzbxx.size() <= ((Integer) zzbs.zzep().zzd(zzmq.zzbkk)).intValue()) {
                break;
            }
            zzsm remove = this.zzbxx.remove();
            zzsn zzsn4 = this.zzbxw.get(remove);
            zza("Evicting interstitial queue for %s.", remove);
            while (zzsn4.size() > 0) {
                zzso zzm = zzsn4.zzm((zzis) null);
                if (zzm.zzbyh) {
                    zzsp.zzkw().zzky();
                }
                zzm.zzbyd.zzde();
            }
            this.zzbxw.remove(remove);
        }
        while (zzsn.size() > 0) {
            zzso zzm2 = zzsn.zzm(zzk);
            if (zzm2.zzbyh) {
                if (zzbs.zzei().currentTimeMillis() - zzm2.zzbyg > 1000 * ((long) ((Integer) zzbs.zzep().zzd(zzmq.zzbkm)).intValue())) {
                    zza("Expired interstitial at %s.", zzsm);
                    zzsp.zzkw().zzkx();
                }
            }
            String str2 = zzm2.zzbye != null ? " (inline) " : " ";
            zza(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), zzsm);
            return zzm2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzri zzri) {
        if (this.zzbxy == null) {
            this.zzbxy = zzri.zzko();
            if (this.zzbxy != null) {
                SharedPreferences sharedPreferences = this.zzbxy.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.zzbxx.size() > 0) {
                    zzsm remove = this.zzbxx.remove();
                    zzsn zzsn = this.zzbxw.get(remove);
                    zza("Flushing interstitial queue for %s.", remove);
                    while (zzsn.size() > 0) {
                        zzsn.zzm((zzis) null).zzbyd.zzde();
                    }
                    this.zzbxw.remove(remove);
                }
                try {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                        if (!((String) next.getKey()).equals("PoolKeys")) {
                            zzsr zzaz = zzsr.zzaz((String) next.getValue());
                            zzsm zzsm = new zzsm(zzaz.zzara, zzaz.zzaou, zzaz.zzbyb);
                            if (!this.zzbxw.containsKey(zzsm)) {
                                this.zzbxw.put(zzsm, new zzsn(zzaz.zzara, zzaz.zzaou, zzaz.zzbyb));
                                hashMap.put(zzsm.toString(), zzsm);
                                zza("Restored interstitial queue for %s.", zzsm);
                            }
                        }
                    }
                    for (String str : zzaw(sharedPreferences.getString("PoolKeys", ""))) {
                        zzsm zzsm2 = (zzsm) hashMap.get(str);
                        if (this.zzbxw.containsKey(zzsm2)) {
                            this.zzbxx.add(zzsm2);
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    zzbs.zzeg().zza(e, "InterstitialAdPool.restore");
                    zzafj.zzc("Malformed preferences value for InterstitialAdPool.", e);
                    this.zzbxw.clear();
                    this.zzbxx.clear();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzis zzis, String str) {
        if (this.zzbxy != null) {
            int i = new zzabv(this.zzbxy.getApplicationContext()).zzns().zzcsg;
            zzis zzk = zzk(zzis);
            String zzay = zzay(str);
            zzsm zzsm = new zzsm(zzk, zzay, i);
            zzsn zzsn = this.zzbxw.get(zzsm);
            if (zzsn == null) {
                zza("Interstitial pool created at %s.", zzsm);
                zzsn = new zzsn(zzk, zzay, i);
                this.zzbxw.put(zzsm, zzsn);
            }
            zzsn.zza(this.zzbxy, zzis);
            zzsn.zzku();
            zza("Inline entry added to the queue at %s.", zzsm);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r2 = r0.size();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzkp() {
        /*
            r9 = this;
            r8 = 2
            r7 = 0
            com.google.android.gms.internal.zzri r0 = r9.zzbxy
            if (r0 != 0) goto L_0x0007
        L_0x0006:
            return
        L_0x0007:
            java.util.Map<com.google.android.gms.internal.zzsm, com.google.android.gms.internal.zzsn> r0 = r9.zzbxw
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r4 = r0.iterator()
        L_0x0011:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x008c
            java.lang.Object r0 = r4.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            com.google.android.gms.internal.zzsm r1 = (com.google.android.gms.internal.zzsm) r1
            java.lang.Object r0 = r0.getValue()
            com.google.android.gms.internal.zzsn r0 = (com.google.android.gms.internal.zzsn) r0
            boolean r2 = com.google.android.gms.internal.zzafj.zzae(r8)
            if (r2 == 0) goto L_0x0056
            int r2 = r0.size()
            int r3 = r0.zzks()
            if (r3 >= r2) goto L_0x0056
            java.lang.String r5 = "Loading %s/%s pooled interstitials for %s."
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            int r3 = r2 - r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6[r7] = r3
            r3 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6[r3] = r2
            r6[r8] = r1
            java.lang.String r2 = java.lang.String.format(r5, r6)
            com.google.android.gms.internal.zzafj.m11v(r2)
        L_0x0056:
            int r2 = r0.zzkt()
            int r2 = r2 + 0
            r3 = r2
        L_0x005d:
            int r5 = r0.size()
            com.google.android.gms.internal.zzmg<java.lang.Integer> r2 = com.google.android.gms.internal.zzmq.zzbkl
            com.google.android.gms.internal.zzmo r6 = com.google.android.gms.ads.internal.zzbs.zzep()
            java.lang.Object r2 = r6.zzd(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r5 >= r2) goto L_0x0084
            java.lang.String r2 = "Pooling and loading one new interstitial for %s."
            zza((java.lang.String) r2, (com.google.android.gms.internal.zzsm) r1)
            com.google.android.gms.internal.zzri r2 = r9.zzbxy
            boolean r2 = r0.zzb((com.google.android.gms.internal.zzri) r2)
            if (r2 == 0) goto L_0x005d
            int r2 = r3 + 1
            r3 = r2
            goto L_0x005d
        L_0x0084:
            com.google.android.gms.internal.zzsp r0 = com.google.android.gms.internal.zzsp.zzkw()
            r0.zzu(r3)
            goto L_0x0011
        L_0x008c:
            com.google.android.gms.internal.zzri r0 = r9.zzbxy
            if (r0 == 0) goto L_0x0006
            com.google.android.gms.internal.zzri r0 = r9.zzbxy
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "com.google.android.gms.ads.internal.interstitial.InterstitialAdPool"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r7)
            android.content.SharedPreferences$Editor r2 = r0.edit()
            r2.clear()
            java.util.Map<com.google.android.gms.internal.zzsm, com.google.android.gms.internal.zzsn> r0 = r9.zzbxw
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r3 = r0.iterator()
        L_0x00ad:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x00e1
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            com.google.android.gms.internal.zzsm r1 = (com.google.android.gms.internal.zzsm) r1
            java.lang.Object r0 = r0.getValue()
            com.google.android.gms.internal.zzsn r0 = (com.google.android.gms.internal.zzsn) r0
            boolean r4 = r0.zzkv()
            if (r4 == 0) goto L_0x00ad
            com.google.android.gms.internal.zzsr r4 = new com.google.android.gms.internal.zzsr
            r4.<init>(r0)
            java.lang.String r0 = r4.zzlf()
            java.lang.String r4 = r1.toString()
            r2.putString(r4, r0)
            java.lang.String r0 = "Saved interstitial queue for %s."
            zza((java.lang.String) r0, (com.google.android.gms.internal.zzsm) r1)
            goto L_0x00ad
        L_0x00e1:
            java.lang.String r0 = "PoolKeys"
            java.lang.String r1 = r9.zzkq()
            r2.putString(r0, r1)
            r2.apply()
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsl.zzkp():void");
    }
}
