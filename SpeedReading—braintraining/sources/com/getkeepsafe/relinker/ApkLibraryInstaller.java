package com.getkeepsafe.relinker;

import com.getkeepsafe.relinker.ReLinker;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ApkLibraryInstaller implements ReLinker.LibraryInstaller {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final int MAX_TRIES = 5;

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        if (r11 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a3, code lost:
        throw new com.getkeepsafe.relinker.MissingLibraryException(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
        throw new com.getkeepsafe.relinker.MissingLibraryException(r26);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void installLibrary(android.content.Context r24, java.lang.String[] r25, java.lang.String r26, java.io.File r27, com.getkeepsafe.relinker.ReLinkerInstance r28) {
        /*
            r23 = this;
            r15 = 0
            android.content.pm.ApplicationInfo r5 = r24.getApplicationInfo()     // Catch:{ all -> 0x00a4 }
            r13 = 0
            r14 = r13
        L_0x0007:
            int r13 = r14 + 1
            r19 = 5
            r0 = r19
            if (r14 >= r0) goto L_0x0021
            java.util.zip.ZipFile r18 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0032 }
            java.io.File r19 = new java.io.File     // Catch:{ IOException -> 0x0032 }
            java.lang.String r0 = r5.sourceDir     // Catch:{ IOException -> 0x0032 }
            r20 = r0
            r19.<init>(r20)     // Catch:{ IOException -> 0x0032 }
            r20 = 1
            r18.<init>(r19, r20)     // Catch:{ IOException -> 0x0032 }
            r15 = r18
        L_0x0021:
            if (r15 != 0) goto L_0x0035
            java.lang.String r19 = "FATAL! Couldn't find application APK!"
            r0 = r28
            r1 = r19
            r0.log((java.lang.String) r1)     // Catch:{ all -> 0x00a4 }
            if (r15 == 0) goto L_0x0031
            r15.close()     // Catch:{ IOException -> 0x0183 }
        L_0x0031:
            return
        L_0x0032:
            r19 = move-exception
            r14 = r13
            goto L_0x0007
        L_0x0035:
            r13 = 0
            r14 = r13
        L_0x0037:
            int r13 = r14 + 1
            r19 = 5
            r0 = r19
            if (r14 >= r0) goto L_0x0170
            r11 = 0
            r12 = 0
            r0 = r25
            int r0 = r0.length     // Catch:{ all -> 0x00a4 }
            r20 = r0
            r19 = 0
        L_0x0048:
            r0 = r19
            r1 = r20
            if (r0 >= r1) goto L_0x007f
            r4 = r25[r19]     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r21 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r21.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r22 = "lib"
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ all -> 0x00a4 }
            char r22 = java.io.File.separatorChar     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ all -> 0x00a4 }
            r0 = r21
            java.lang.StringBuilder r21 = r0.append(r4)     // Catch:{ all -> 0x00a4 }
            char r22 = java.io.File.separatorChar     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuilder r21 = r21.append(r22)     // Catch:{ all -> 0x00a4 }
            r0 = r21
            r1 = r26
            java.lang.StringBuilder r21 = r0.append(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.String r11 = r21.toString()     // Catch:{ all -> 0x00a4 }
            java.util.zip.ZipEntry r12 = r15.getEntry(r11)     // Catch:{ all -> 0x00a4 }
            if (r12 == 0) goto L_0x00ab
        L_0x007f:
            if (r11 == 0) goto L_0x0098
            java.lang.String r19 = "Looking for %s in APK..."
            r20 = 1
            r0 = r20
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00a4 }
            r20 = r0
            r21 = 0
            r20[r21] = r11     // Catch:{ all -> 0x00a4 }
            r0 = r28
            r1 = r19
            r2 = r20
            r0.log(r1, r2)     // Catch:{ all -> 0x00a4 }
        L_0x0098:
            if (r12 != 0) goto L_0x00b8
            if (r11 == 0) goto L_0x00ae
            com.getkeepsafe.relinker.MissingLibraryException r19 = new com.getkeepsafe.relinker.MissingLibraryException     // Catch:{ all -> 0x00a4 }
            r0 = r19
            r0.<init>(r11)     // Catch:{ all -> 0x00a4 }
            throw r19     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r19 = move-exception
            if (r15 == 0) goto L_0x00aa
            r15.close()     // Catch:{ IOException -> 0x0186 }
        L_0x00aa:
            throw r19
        L_0x00ab:
            int r19 = r19 + 1
            goto L_0x0048
        L_0x00ae:
            com.getkeepsafe.relinker.MissingLibraryException r19 = new com.getkeepsafe.relinker.MissingLibraryException     // Catch:{ all -> 0x00a4 }
            r0 = r19
            r1 = r26
            r0.<init>(r1)     // Catch:{ all -> 0x00a4 }
            throw r19     // Catch:{ all -> 0x00a4 }
        L_0x00b8:
            java.lang.String r19 = "Found %s! Extracting..."
            r20 = 1
            r0 = r20
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00a4 }
            r20 = r0
            r21 = 0
            r20[r21] = r11     // Catch:{ all -> 0x00a4 }
            r0 = r28
            r1 = r19
            r2 = r20
            r0.log(r1, r2)     // Catch:{ all -> 0x00a4 }
            boolean r19 = r27.exists()     // Catch:{ IOException -> 0x00de }
            if (r19 != 0) goto L_0x00e2
            boolean r19 = r27.createNewFile()     // Catch:{ IOException -> 0x00de }
            if (r19 != 0) goto L_0x00e2
            r14 = r13
            goto L_0x0037
        L_0x00de:
            r9 = move-exception
            r14 = r13
            goto L_0x0037
        L_0x00e2:
            r10 = 0
            r7 = 0
            java.io.InputStream r10 = r15.getInputStream(r12)     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0156, all -> 0x0164 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0156, all -> 0x0164 }
            r0 = r27
            r8.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0148, IOException -> 0x0156, all -> 0x0164 }
            r0 = r23
            long r16 = r0.copy(r10, r8)     // Catch:{ FileNotFoundException -> 0x018f, IOException -> 0x018c, all -> 0x0189 }
            java.io.FileDescriptor r19 = r8.getFD()     // Catch:{ FileNotFoundException -> 0x018f, IOException -> 0x018c, all -> 0x0189 }
            r19.sync()     // Catch:{ FileNotFoundException -> 0x018f, IOException -> 0x018c, all -> 0x0189 }
            long r20 = r27.length()     // Catch:{ FileNotFoundException -> 0x018f, IOException -> 0x018c, all -> 0x0189 }
            int r19 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r19 == 0) goto L_0x0111
            r0 = r23
            r0.closeSilently(r10)     // Catch:{ all -> 0x00a4 }
            r0 = r23
            r0.closeSilently(r8)     // Catch:{ all -> 0x00a4 }
            r14 = r13
            goto L_0x0037
        L_0x0111:
            r0 = r23
            r0.closeSilently(r10)     // Catch:{ all -> 0x00a4 }
            r0 = r23
            r0.closeSilently(r8)     // Catch:{ all -> 0x00a4 }
            r19 = 1
            r20 = 0
            r0 = r27
            r1 = r19
            r2 = r20
            r0.setReadable(r1, r2)     // Catch:{ all -> 0x00a4 }
            r19 = 1
            r20 = 0
            r0 = r27
            r1 = r19
            r2 = r20
            r0.setExecutable(r1, r2)     // Catch:{ all -> 0x00a4 }
            r19 = 1
            r0 = r27
            r1 = r19
            r0.setWritable(r1)     // Catch:{ all -> 0x00a4 }
            if (r15 == 0) goto L_0x0031
            r15.close()     // Catch:{ IOException -> 0x0145 }
            goto L_0x0031
        L_0x0145:
            r19 = move-exception
            goto L_0x0031
        L_0x0148:
            r6 = move-exception
        L_0x0149:
            r0 = r23
            r0.closeSilently(r10)     // Catch:{ all -> 0x00a4 }
            r0 = r23
            r0.closeSilently(r7)     // Catch:{ all -> 0x00a4 }
            r14 = r13
            goto L_0x0037
        L_0x0156:
            r6 = move-exception
        L_0x0157:
            r0 = r23
            r0.closeSilently(r10)     // Catch:{ all -> 0x00a4 }
            r0 = r23
            r0.closeSilently(r7)     // Catch:{ all -> 0x00a4 }
            r14 = r13
            goto L_0x0037
        L_0x0164:
            r19 = move-exception
        L_0x0165:
            r0 = r23
            r0.closeSilently(r10)     // Catch:{ all -> 0x00a4 }
            r0 = r23
            r0.closeSilently(r7)     // Catch:{ all -> 0x00a4 }
            throw r19     // Catch:{ all -> 0x00a4 }
        L_0x0170:
            java.lang.String r19 = "FATAL! Couldn't extract the library from the APK!"
            r0 = r28
            r1 = r19
            r0.log((java.lang.String) r1)     // Catch:{ all -> 0x00a4 }
            if (r15 == 0) goto L_0x0031
            r15.close()     // Catch:{ IOException -> 0x0180 }
            goto L_0x0031
        L_0x0180:
            r19 = move-exception
            goto L_0x0031
        L_0x0183:
            r19 = move-exception
            goto L_0x0031
        L_0x0186:
            r20 = move-exception
            goto L_0x00aa
        L_0x0189:
            r19 = move-exception
            r7 = r8
            goto L_0x0165
        L_0x018c:
            r6 = move-exception
            r7 = r8
            goto L_0x0157
        L_0x018f:
            r6 = move-exception
            r7 = r8
            goto L_0x0149
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getkeepsafe.relinker.ApkLibraryInstaller.installLibrary(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.getkeepsafe.relinker.ReLinkerInstance):void");
    }

    private long copy(InputStream in, OutputStream out) throws IOException {
        long copied = 0;
        byte[] buf = new byte[4096];
        while (true) {
            int read = in.read(buf);
            if (read == -1) {
                out.flush();
                return copied;
            }
            out.write(buf, 0, read);
            copied += (long) read;
        }
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
