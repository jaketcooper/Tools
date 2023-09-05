package p006io.realm.log;

import android.util.Log;

/* renamed from: io.realm.log.RealmLog */
public final class RealmLog {
    private static String REALM_JAVA_TAG = "REALM_JAVA";

    private static native void nativeAddLogger(RealmLogger realmLogger);

    private static native void nativeClearLoggers();

    private static native int nativeGetLogLevel();

    private static native void nativeLog(int i, String str, Throwable th, String str2);

    private static native void nativeRegisterDefaultLogger();

    private static native void nativeRemoveLogger(RealmLogger realmLogger);

    private static native void nativeSetLogLevel(int i);

    public static void add(RealmLogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("A non-null logger has to be provided");
        }
        nativeAddLogger(logger);
    }

    public static void setLevel(int level) {
        nativeSetLogLevel(level);
    }

    public static int getLevel() {
        return nativeGetLogLevel();
    }

    public static boolean remove(RealmLogger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("A non-null logger has to be provided");
        }
        nativeRemoveLogger(logger);
        return true;
    }

    public static void clear() {
        nativeClearLoggers();
    }

    public static void registerDefaultLogger() {
        nativeRegisterDefaultLogger();
    }

    public static void trace(Throwable throwable) {
        trace(throwable, (String) null, new Object[0]);
    }

    public static void trace(String message, Object... args) {
        trace((Throwable) null, message, args);
    }

    public static void trace(Throwable throwable, String message, Object... args) {
        log(2, throwable, message, args);
    }

    public static void debug(Throwable throwable) {
        debug(throwable, (String) null, new Object[0]);
    }

    public static void debug(String message, Object... args) {
        debug((Throwable) null, message, args);
    }

    public static void debug(Throwable throwable, String message, Object... args) {
        log(3, throwable, message, args);
    }

    public static void info(Throwable throwable) {
        info(throwable, (String) null, new Object[0]);
    }

    public static void info(String message, Object... args) {
        info((Throwable) null, message, args);
    }

    public static void info(Throwable throwable, String message, Object... args) {
        log(4, throwable, message, args);
    }

    public static void warn(Throwable throwable) {
        warn(throwable, (String) null, new Object[0]);
    }

    public static void warn(String message, Object... args) {
        warn((Throwable) null, message, args);
    }

    public static void warn(Throwable throwable, String message, Object... args) {
        log(5, throwable, message, args);
    }

    public static void error(Throwable throwable) {
        error(throwable, (String) null, new Object[0]);
    }

    public static void error(String message, Object... args) {
        error((Throwable) null, message, args);
    }

    public static void error(Throwable throwable, String message, Object... args) {
        log(6, throwable, message, args);
    }

    public static void fatal(Throwable throwable) {
        fatal(throwable, (String) null, new Object[0]);
    }

    public static void fatal(String message, Object... args) {
        fatal((Throwable) null, message, args);
    }

    public static void fatal(Throwable throwable, String message, Object... args) {
        log(7, throwable, message, args);
    }

    private static void log(int level, Throwable throwable, String message, Object... args) {
        StringBuilder stringBuilder = new StringBuilder();
        if (args != null && args.length > 0) {
            message = String.format(message, args);
        }
        if (throwable != null) {
            stringBuilder.append(Log.getStackTraceString(throwable));
        }
        if (message != null) {
            if (throwable != null) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(message);
        }
        nativeLog(level, REALM_JAVA_TAG, throwable, stringBuilder.toString());
    }
}
