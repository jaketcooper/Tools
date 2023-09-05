package com.google.android.gms.internal;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class zzdtf {
    private static zzdtg zzlwj;

    static final class zza extends zzdtg {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }

        public final void zza(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static {
        zzdtg zza2;
        try {
            Integer zzbow = zzbow();
            if (zzbow == null || zzbow.intValue() < 19) {
                zza2 = !Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? new zzdtj() : new zza();
                zzlwj = zza2;
            }
            zza2 = new zzdtk();
            zzlwj = zza2;
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zza2 = new zza();
        }
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzlwj.zza(th, printStream);
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        zzlwj.zza(th, printWriter);
    }

    private static Integer zzbow() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
