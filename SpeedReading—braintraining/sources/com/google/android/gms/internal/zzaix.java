package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zzzb
public final class zzaix implements zzaiv {
    @Nullable
    private final String zzcxh;

    public zzaix() {
        this((String) null);
    }

    public zzaix(@Nullable String str) {
        this.zzcxh = str;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzch(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r1 = "Pinging URL: "
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            int r2 = r0.length()     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            if (r2 == 0) goto L_0x0061
            java.lang.String r0 = r1.concat(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
        L_0x0010:
            com.google.android.gms.internal.zzaiw.zzbw(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            java.net.URL r0 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            r0.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            com.google.android.gms.internal.zzjk.zzhx()     // Catch:{ all -> 0x00a0 }
            r1 = 1
            java.lang.String r2 = r4.zzcxh     // Catch:{ all -> 0x00a0 }
            com.google.android.gms.internal.zzais.zza((boolean) r1, (java.net.HttpURLConnection) r0, (java.lang.String) r2)     // Catch:{ all -> 0x00a0 }
            int r1 = r0.getResponseCode()     // Catch:{ all -> 0x00a0 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 < r2) goto L_0x0033
            r2 = 300(0x12c, float:4.2E-43)
            if (r1 < r2) goto L_0x005d
        L_0x0033:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00a0 }
            int r2 = r2.length()     // Catch:{ all -> 0x00a0 }
            int r2 = r2 + 65
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r3.<init>(r2)     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = "Received non-success response code "
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = " from pinging URL: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ all -> 0x00a0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a0 }
            com.google.android.gms.internal.zzaiw.zzco(r1)     // Catch:{ all -> 0x00a0 }
        L_0x005d:
            r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
        L_0x0060:
            return
        L_0x0061:
            java.lang.String r0 = new java.lang.String     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            r0.<init>(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            goto L_0x0010
        L_0x0067:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r1 = r1.length()
            int r1 = r1 + 32
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Error while parsing ping URL: "
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = ". "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.zzaiw.zzco(r0)
            goto L_0x0060
        L_0x00a0:
            r1 = move-exception
            r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
            throw r1     // Catch:{ IndexOutOfBoundsException -> 0x0067, IOException -> 0x00a5, RuntimeException -> 0x00de }
        L_0x00a5:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r1 = r1.length()
            int r1 = r1 + 27
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Error while pinging URL: "
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = ". "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.zzaiw.zzco(r0)
            goto L_0x0060
        L_0x00de:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r1 = r1.length()
            int r1 = r1 + 27
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Error while pinging URL: "
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = ". "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.zzaiw.zzco(r0)
            goto L_0x0060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaix.zzch(java.lang.String):void");
    }
}
