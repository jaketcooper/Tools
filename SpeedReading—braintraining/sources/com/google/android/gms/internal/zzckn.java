package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzckn extends zzcii {
    private static String[] zzjhc = {"firebase_"};
    private SecureRandom zzjhd;
    private final AtomicLong zzjhe = new AtomicLong(0);
    private int zzjhf;

    zzckn(zzchj zzchj) {
        super(zzchj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.lang.String r8, java.lang.Object r9, boolean r10) {
        /*
            r7 = this;
            r1 = 1
            r6 = 0
            if (r10 == 0) goto L_0x0039
            java.lang.String r2 = "param"
            boolean r0 = r9 instanceof android.os.Parcelable[]
            if (r0 == 0) goto L_0x0029
            r0 = r9
            android.os.Parcelable[] r0 = (android.os.Parcelable[]) r0
            int r0 = r0.length
        L_0x000e:
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r0 <= r3) goto L_0x0037
            com.google.android.gms.internal.zzcgj r1 = r7.zzawn()
            com.google.android.gms.internal.zzcgl r1 = r1.zzayu()
            java.lang.String r3 = "Parameter array is too long; discarded. Value kind, name, array length"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.zzd(r3, r2, r8, r0)
            r0 = r6
        L_0x0024:
            if (r0 != 0) goto L_0x0039
            r0 = 17
        L_0x0028:
            return r0
        L_0x0029:
            boolean r0 = r9 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x0035
            r0 = r9
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            goto L_0x000e
        L_0x0035:
            r0 = r1
            goto L_0x0024
        L_0x0037:
            r0 = r1
            goto L_0x0024
        L_0x0039:
            boolean r0 = zzkd(r8)
            if (r0 == 0) goto L_0x004f
            java.lang.String r1 = "param"
            r3 = 256(0x100, float:3.59E-43)
            r0 = r7
            r2 = r8
            r4 = r9
            r5 = r10
            boolean r0 = r0.zza((java.lang.String) r1, (java.lang.String) r2, (int) r3, (java.lang.Object) r4, (boolean) r5)
        L_0x004b:
            if (r0 == 0) goto L_0x005c
            r0 = r6
            goto L_0x0028
        L_0x004f:
            java.lang.String r1 = "param"
            r3 = 100
            r0 = r7
            r2 = r8
            r4 = r9
            r5 = r10
            boolean r0 = r0.zza((java.lang.String) r1, (java.lang.String) r2, (int) r3, (java.lang.Object) r4, (boolean) r5)
            goto L_0x004b
        L_0x005c:
            r0 = 4
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckn.zza(java.lang.String, java.lang.Object, boolean):int");
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static Object zza(zzcky zzcky, String str) {
        for (zzckz zzckz : zzcky.zzjiw) {
            if (zzckz.name.equals(str)) {
                if (zzckz.zzfzs != null) {
                    return zzckz.zzfzs;
                }
                if (zzckz.zzjja != null) {
                    return zzckz.zzjja;
                }
                if (zzckz.zzjha != null) {
                    return zzckz.zzjha;
                }
            }
        }
        return null;
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    @Nullable
    public static String zza(String str, String[] strArr, String[] strArr2) {
        zzbq.checkNotNull(strArr);
        zzbq.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzas(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) <= i) {
                return true;
            }
            zzawn().zzayu().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            if ((obj instanceof Parcelable[]) && z) {
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (!(parcelable instanceof Bundle)) {
                        zzawn().zzayu().zze("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    if (!(obj2 instanceof Bundle)) {
                        zzawn().zzayu().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    private final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            zzawn().zzays().zzj("Name is required and can't be null. Type", str);
            return false;
        }
        zzbq.checkNotNull(str2);
        int i = 0;
        while (true) {
            if (i >= zzjhc.length) {
                z = false;
                break;
            } else if (str2.startsWith(zzjhc[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzawn().zzays().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            zzbq.checkNotNull(strArr);
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z2 = false;
                    break;
                } else if (zzas(str2, strArr[i2])) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                zzawn().zzays().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public static boolean zza(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i << 6) + i2 < bitSet.length()) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    static zzckz[] zza(zzckz[] zzckzArr, String str, Object obj) {
        int length = zzckzArr.length;
        int i = 0;
        while (i < length) {
            zzckz zzckz = zzckzArr[i];
            if (Objects.equals(zzckz.name, str)) {
                zzckz.zzjja = null;
                zzckz.zzfzs = null;
                zzckz.zzjha = null;
                if (obj instanceof Long) {
                    zzckz.zzjja = (Long) obj;
                    return zzckzArr;
                } else if (obj instanceof String) {
                    zzckz.zzfzs = (String) obj;
                    return zzckzArr;
                } else if (!(obj instanceof Double)) {
                    return zzckzArr;
                } else {
                    zzckz.zzjha = (Double) obj;
                    return zzckzArr;
                }
            } else {
                i++;
            }
        }
        zzckz[] zzckzArr2 = new zzckz[(zzckzArr.length + 1)];
        System.arraycopy(zzckzArr, 0, zzckzArr2, 0, zzckzArr.length);
        zzckz zzckz2 = new zzckz();
        zzckz2.name = str;
        if (obj instanceof Long) {
            zzckz2.zzjja = (Long) obj;
        } else if (obj instanceof String) {
            zzckz2.zzfzs = (String) obj;
        } else if (obj instanceof Double) {
            zzckz2.zzjha = (Double) obj;
        }
        zzckzArr2[zzckzArr.length] = zzckz2;
        return zzckzArr2;
    }

    public static Bundle[] zzae(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            return (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
        } else {
            if (!(obj instanceof ArrayList)) {
                return null;
            }
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[Catch:{ IOException | ClassNotFoundException -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A[Catch:{ IOException | ClassNotFoundException -> 0x003c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object zzaf(java.lang.Object r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
        L_0x0003:
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x002e }
            r1.<init>()     // Catch:{ all -> 0x002e }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x002e }
            r3.<init>(r1)     // Catch:{ all -> 0x002e }
            r3.writeObject(r5)     // Catch:{ all -> 0x0040 }
            r3.flush()     // Catch:{ all -> 0x0040 }
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0040 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0040 }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x0040 }
            r4.<init>(r1)     // Catch:{ all -> 0x0040 }
            r2.<init>(r4)     // Catch:{ all -> 0x0040 }
            java.lang.Object r1 = r2.readObject()     // Catch:{ all -> 0x0043 }
            r3.close()     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
            r2.close()     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
            r0 = r1
            goto L_0x0003
        L_0x002e:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L_0x0031:
            if (r3 == 0) goto L_0x0036
            r3.close()     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
        L_0x003b:
            throw r1     // Catch:{ IOException -> 0x003c, ClassNotFoundException -> 0x003e }
        L_0x003c:
            r1 = move-exception
            goto L_0x0003
        L_0x003e:
            r1 = move-exception
            goto L_0x0003
        L_0x0040:
            r1 = move-exception
            r2 = r0
            goto L_0x0031
        L_0x0043:
            r1 = move-exception
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckn.zzaf(java.lang.Object):java.lang.Object");
    }

    private final boolean zzag(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = zzbgc.zzcy(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e) {
            zzawn().zzays().zzj("Error obtaining certificate", e);
        } catch (PackageManager.NameNotFoundException e2) {
            zzawn().zzays().zzj("Package name not found", e2);
        }
        return true;
    }

    private final boolean zzaq(String str, String str2) {
        if (str2 == null) {
            zzawn().zzays().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzawn().zzays().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzawn().zzays().zze("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzawn().zzays().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    private final boolean zzar(String str, String str2) {
        if (str2 == null) {
            zzawn().zzays().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzawn().zzays().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzawn().zzays().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzawn().zzays().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean zzas(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    private static void zzb(Bundle bundle, Object obj) {
        zzbq.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private final boolean zzb(String str, int i, String str2) {
        if (str2 == null) {
            zzawn().zzays().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzawn().zzays().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    private static boolean zzd(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    @WorkerThread
    static boolean zzd(zzcfx zzcfx, zzcff zzcff) {
        zzbq.checkNotNull(zzcfx);
        zzbq.checkNotNull(zzcff);
        return !TextUtils.isEmpty(zzcff.zzivh);
    }

    static MessageDigest zzed(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    static boolean zzju(String str) {
        zzbq.zzgi(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private final int zzjz(String str) {
        if (!zzaq("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        return zzb("event param", 40, str) ? 0 : 3;
    }

    private final int zzka(String str) {
        if (!zzar("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        return zzb("event param", 40, str) ? 0 : 3;
    }

    private static int zzkc(String str) {
        return "_ldl".equals(str) ? 2048 : 36;
    }

    public static boolean zzkd(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzkf(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    @WorkerThread
    static boolean zzki(String str) {
        zzbq.zzgi(str);
        char c = 65535;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    c = 0;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    c = 2;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzo(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    static long zzr(byte[] bArr) {
        int i = 0;
        zzbq.checkNotNull(bArr);
        zzbq.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = r1.getServiceInfo(new android.content.ComponentName(r4, r5), 4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzt(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001a }
            if (r1 != 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x001a }
            r2.<init>(r4, r5)     // Catch:{ NameNotFoundException -> 0x001a }
            r3 = 4
            android.content.pm.ServiceInfo r1 = r1.getServiceInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x001a }
            if (r1 == 0) goto L_0x0007
            boolean r1 = r1.enabled     // Catch:{ NameNotFoundException -> 0x001a }
            if (r1 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0007
        L_0x001a:
            r1 = move-exception
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzckn.zzt(android.content.Context, java.lang.String):boolean");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int i2 = 0;
            if (list == null || !list.contains(str2)) {
                if (z) {
                    i2 = zzjz(str2);
                }
                if (i2 == 0) {
                    i2 = zzka(str2);
                }
            }
            if (i2 != 0) {
                if (zzd(bundle2, i2)) {
                    bundle2.putString("_ev", zza(str2, 40, true));
                    if (i2 == 3) {
                        zzb(bundle2, (Object) str2);
                    }
                }
                bundle2.remove(str2);
            } else {
                int zza = zza(str2, bundle.get(str2), z2);
                if (zza != 0 && !"_ev".equals(str2)) {
                    if (zzd(bundle2, zza)) {
                        bundle2.putString("_ev", zza(str2, 40, true));
                        zzb(bundle2, bundle.get(str2));
                    }
                    bundle2.remove(str2);
                } else if (!zzju(str2) || (i = i + 1) <= 25) {
                    i = i;
                } else {
                    zzawn().zzays().zze(new StringBuilder(48).append("Event can't contain more then 25 params").toString(), zzawi().zzjc(str), zzawi().zzx(bundle));
                    zzd(bundle2, 5);
                    bundle2.remove(str2);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final zzcfx zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzjw(str) != 0) {
            zzawn().zzays().zzj("Invalid conditional property event name", zzawi().zzje(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        return new zzcfx(str, new zzcfu(zzy(zza(str, bundle2, (List<String>) Collections.singletonList("_o"), false, false))), str2, j);
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzawn().zzayv().zze("Not putting event parameter. Invalid value type. name, type", zzawi().zzjd(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(zzckz zzckz, Object obj) {
        zzbq.checkNotNull(obj);
        zzckz.zzfzs = null;
        zzckz.zzjja = null;
        zzckz.zzjha = null;
        if (obj instanceof String) {
            zzckz.zzfzs = (String) obj;
        } else if (obj instanceof Long) {
            zzckz.zzjja = (Long) obj;
        } else if (obj instanceof Double) {
            zzckz.zzjha = (Double) obj;
        } else {
            zzawn().zzays().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zza(zzcld zzcld, Object obj) {
        zzbq.checkNotNull(obj);
        zzcld.zzfzs = null;
        zzcld.zzjja = null;
        zzcld.zzjha = null;
        if (obj instanceof String) {
            zzcld.zzfzs = (String) obj;
        } else if (obj instanceof Long) {
            zzcld.zzjja = (Long) obj;
        } else if (obj instanceof Double) {
            zzcld.zzjha = (Double) obj;
        } else {
            zzawn().zzays().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzitu.zzawb().zzc("auto", "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zzaf(Context context, String str) {
        zzut();
        zzbq.checkNotNull(context);
        zzbq.zzgi(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzed = zzed("MD5");
        if (zzed == null) {
            zzawn().zzays().log("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zzag(context, str)) {
                    PackageInfo packageInfo = zzbgc.zzcy(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzr(zzed.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzawn().zzayu().log("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzawn().zzays().zzj("Package name not found", e);
            }
        }
        return 0;
    }

    public final /* bridge */ /* synthetic */ void zzavx() {
        super.zzavx();
    }

    public final /* bridge */ /* synthetic */ void zzavy() {
        super.zzavy();
    }

    public final /* bridge */ /* synthetic */ zzcfa zzavz() {
        return super.zzavz();
    }

    public final /* bridge */ /* synthetic */ zzcfh zzawa() {
        return super.zzawa();
    }

    public final /* bridge */ /* synthetic */ zzcik zzawb() {
        return super.zzawb();
    }

    public final /* bridge */ /* synthetic */ zzcge zzawc() {
        return super.zzawc();
    }

    public final /* bridge */ /* synthetic */ zzcfr zzawd() {
        return super.zzawd();
    }

    public final /* bridge */ /* synthetic */ zzcjd zzawe() {
        return super.zzawe();
    }

    public final /* bridge */ /* synthetic */ zzciz zzawf() {
        return super.zzawf();
    }

    public final /* bridge */ /* synthetic */ zzcgf zzawg() {
        return super.zzawg();
    }

    public final /* bridge */ /* synthetic */ zzcfl zzawh() {
        return super.zzawh();
    }

    public final /* bridge */ /* synthetic */ zzcgh zzawi() {
        return super.zzawi();
    }

    public final /* bridge */ /* synthetic */ zzckn zzawj() {
        return super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzchd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzche zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzcgj zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzcfk zzawp() {
        return super.zzawp();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzayn() {
        zzut();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzawn().zzayu().log("Utils falling back to Random for random id");
            }
        }
        this.zzjhe.set(nextLong);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final <T extends Parcelable> T zzb(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            T t = (Parcelable) creator.createFromParcel(obtain);
            obtain.recycle();
            return t;
        } catch (zzbel e) {
            zzawn().zzays().log("Failed to load parcelable from buffer");
            obtain.recycle();
            return null;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    public final byte[] zzb(zzcla zzcla) {
        try {
            byte[] bArr = new byte[zzcla.zzhl()];
            zzfhk zzo = zzfhk.zzo(bArr, 0, bArr.length);
            zzcla.zza(zzo);
            zzo.zzcut();
            return bArr;
        } catch (IOException e) {
            zzawn().zzays().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final long zzban() {
        long andIncrement;
        if (this.zzjhe.get() == 0) {
            synchronized (this.zzjhe) {
                long nextLong = new Random(System.nanoTime() ^ zzwh().currentTimeMillis()).nextLong();
                int i = this.zzjhf + 1;
                this.zzjhf = i;
                andIncrement = nextLong + ((long) i);
            }
        } else {
            synchronized (this.zzjhe) {
                this.zzjhe.compareAndSet(-1, 1);
                andIncrement = this.zzjhe.getAndIncrement();
            }
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final SecureRandom zzbao() {
        zzut();
        if (this.zzjhd == null) {
            this.zzjhd = new SecureRandom();
        }
        return this.zzjhd;
    }

    @WorkerThread
    public final boolean zzdu(String str) {
        zzut();
        if (zzbgc.zzcy(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzawn().zzayx().zzj("Permission not granted", str);
        return false;
    }

    public final boolean zzf(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzwh().currentTimeMillis() - j) > j2;
    }

    public final int zzjv(String str) {
        if (!zzaq(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zza(NotificationCompat.CATEGORY_EVENT, AppMeasurement.Event.zzitv, str)) {
            return 13;
        }
        return zzb(NotificationCompat.CATEGORY_EVENT, 40, str) ? 0 : 2;
    }

    public final int zzjw(String str) {
        if (!zzar(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zza(NotificationCompat.CATEGORY_EVENT, AppMeasurement.Event.zzitv, str)) {
            return 13;
        }
        return zzb(NotificationCompat.CATEGORY_EVENT, 40, str) ? 0 : 2;
    }

    public final int zzjx(String str) {
        if (!zzaq("user property", str)) {
            return 6;
        }
        if (!zza("user property", AppMeasurement.UserProperty.zziuc, str)) {
            return 15;
        }
        return zzb("user property", 24, str) ? 0 : 6;
    }

    public final int zzjy(String str) {
        if (!zzar("user property", str)) {
            return 6;
        }
        if (!zza("user property", AppMeasurement.UserProperty.zziuc, str)) {
            return 15;
        }
        return zzb("user property", 24, str) ? 0 : 6;
    }

    public final Object zzk(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return zza(256, obj, true);
        }
        if (!zzkd(str)) {
            i = 100;
        }
        return zza(i, obj, false);
    }

    public final boolean zzkb(String str) {
        if (TextUtils.isEmpty(str)) {
            zzawn().zzays().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        zzbq.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzawn().zzays().zzj("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean zzke(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zzawp().zzaxs().equals(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzkg(String str) {
        return "1".equals(zzawk().zzam(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzkh(String str) {
        return "1".equals(zzawk().zzam(str, "measurement.upload.blacklist_public"));
    }

    public final int zzl(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzkc(str), obj, false) : zza("user property", str, zzkc(str), obj, false) ? 0 : 7;
    }

    public final Object zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzkc(str), obj, true) : zza(zzkc(str), obj, false);
    }

    public final Bundle zzp(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        Bundle bundle = null;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str4 = uri.getQueryParameter("utm_campaign");
                    str3 = uri.getQueryParameter("utm_source");
                    str2 = uri.getQueryParameter("utm_medium");
                    str = uri.getQueryParameter("gclid");
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(str4)) {
                        bundle.putString(FirebaseAnalytics.Param.CAMPAIGN, str4);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        bundle.putString(FirebaseAnalytics.Param.SOURCE, str3);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        bundle.putString(FirebaseAnalytics.Param.MEDIUM, str2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putString("gclid", str);
                    }
                    String queryParameter = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
                    }
                    String queryParameter2 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
                    }
                    String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
                    }
                    String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
                    }
                    String queryParameter5 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString("anid", queryParameter5);
                    }
                }
            } catch (UnsupportedOperationException e) {
                zzawn().zzayu().zzj("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    public final byte[] zzp(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzawn().zzays().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public final byte[] zzq(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzawn().zzays().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzy(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzk = zzk(str, bundle.get(str));
                if (zzk == null) {
                    zzawn().zzayu().zzj("Param value can't be null", zzawi().zzjd(str));
                } else {
                    zza(bundle2, str, zzk);
                }
            }
        }
        return bundle2;
    }
}
