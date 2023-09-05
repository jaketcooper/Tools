package p006io.realm.internal;

import android.os.Build;
import android.support.p000v4.p002os.EnvironmentCompat;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import p006io.realm.RealmModel;
import p006io.realm.RealmObject;
import p006io.realm.log.RealmLog;

/* renamed from: io.realm.internal.Util */
public class Util {
    static native long nativeGetMemUsage();

    static native String nativeGetTablePrefix();

    public static long getNativeMemUsage() {
        return nativeGetMemUsage();
    }

    static void javaPrint(String txt) {
        System.out.print(txt);
    }

    public static String getTablePrefix() {
        return nativeGetTablePrefix();
    }

    public static Class<? extends RealmModel> getOriginalModelClass(Class<? extends RealmModel> clazz) {
        Class<? super Object> superclass = clazz.getSuperclass();
        if (superclass.equals(Object.class) || superclass.equals(RealmObject.class)) {
            return clazz;
        }
        return superclass;
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }

    public static boolean isEmulator() {
        if (Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT))) {
            return true;
        }
        return false;
    }

    public static boolean deleteRealm(String canonicalPath, File realmFolder, String realmFileName) {
        boolean realmDeleted;
        boolean realmDeleted2 = true;
        File managementFolder = new File(realmFolder, realmFileName + ".management");
        File[] files = managementFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!realmDeleted2 || !file.delete()) {
                    realmDeleted2 = false;
                } else {
                    realmDeleted2 = true;
                }
            }
        }
        if (!realmDeleted2 || !managementFolder.delete()) {
            realmDeleted = false;
        } else {
            realmDeleted = true;
        }
        if (!realmDeleted || !deletes(canonicalPath, realmFolder, realmFileName)) {
            return false;
        }
        return true;
    }

    private static boolean deletes(String canonicalPath, File rootFolder, String realmFileName) {
        AtomicBoolean realmDeleted = new AtomicBoolean(true);
        for (File fileToDelete : Arrays.asList(new File[]{new File(rootFolder, realmFileName), new File(rootFolder, realmFileName + ".lock"), new File(rootFolder, realmFileName + ".log_a"), new File(rootFolder, realmFileName + ".log_b"), new File(rootFolder, realmFileName + ".log"), new File(canonicalPath)})) {
            if (fileToDelete.exists() && !fileToDelete.delete()) {
                realmDeleted.set(false);
                RealmLog.warn("Could not delete the file %s", fileToDelete);
            }
        }
        return realmDeleted.get();
    }
}
