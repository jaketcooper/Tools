package com.github.mikephil.charting.utils;

import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    public static List<Entry> loadEntriesFromFile(String path) {
        File file = new File(Environment.getExternalStorageDirectory(), path);
        List<Entry> entries = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] split = line.split("#");
                if (split.length <= 2) {
                    entries.add(new Entry(Float.parseFloat(split[0]), (float) Integer.parseInt(split[1])));
                } else {
                    float[] vals = new float[(split.length - 1)];
                    for (int i = 0; i < vals.length; i++) {
                        vals[i] = Float.parseFloat(split[i]);
                    }
                    entries.add(new BarEntry((float) Integer.parseInt(split[split.length - 1]), vals));
                }
            }
        } catch (IOException e) {
            Log.e(LOG, e.toString());
        }
        return entries;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A[SYNTHETIC, Splitter:B:21:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009a A[SYNTHETIC, Splitter:B:34:0x009a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.Entry> loadEntriesFromAssets(android.content.res.AssetManager r11, java.lang.String r12) {
        /*
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4 = 0
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ac }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ac }
            java.io.InputStream r9 = r11.open(r12)     // Catch:{ IOException -> 0x00ac }
            java.lang.String r10 = "UTF-8"
            r8.<init>(r9, r10)     // Catch:{ IOException -> 0x00ac }
            r5.<init>(r8)     // Catch:{ IOException -> 0x00ac }
            java.lang.String r3 = r5.readLine()     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
        L_0x001a:
            if (r3 == 0) goto L_0x0079
            java.lang.String r8 = "#"
            java.lang.String[] r6 = r3.split(r8)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            int r8 = r6.length     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r9 = 2
            if (r8 > r9) goto L_0x0041
            com.github.mikephil.charting.data.Entry r8 = new com.github.mikephil.charting.data.Entry     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r9 = 1
            r9 = r6[r9]     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r10 = 0
            r10 = r6[r10]     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r8.<init>(r9, r10)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r1.add(r8)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
        L_0x003c:
            java.lang.String r3 = r5.readLine()     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            goto L_0x001a
        L_0x0041:
            int r8 = r6.length     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            int r8 = r8 + -1
            float[] r7 = new float[r8]     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r2 = 0
        L_0x0047:
            int r8 = r7.length     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            if (r2 >= r8) goto L_0x0055
            r8 = r6[r2]     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r7[r2] = r8     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            int r2 = r2 + 1
            goto L_0x0047
        L_0x0055:
            com.github.mikephil.charting.data.BarEntry r8 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            int r9 = r6.length     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            int r9 = r9 + -1
            r9 = r6[r9]     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            float r9 = (float) r9     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r8.<init>((float) r9, (float[]) r7)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            r1.add(r8)     // Catch:{ IOException -> 0x0068, all -> 0x00a9 }
            goto L_0x003c
        L_0x0068:
            r0 = move-exception
            r4 = r5
        L_0x006a:
            java.lang.String r8 = "MPChart-FileUtils"
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0097 }
            android.util.Log.e(r8, r9)     // Catch:{ all -> 0x0097 }
            if (r4 == 0) goto L_0x0078
            r4.close()     // Catch:{ IOException -> 0x008c }
        L_0x0078:
            return r1
        L_0x0079:
            if (r5 == 0) goto L_0x00ae
            r5.close()     // Catch:{ IOException -> 0x0080 }
            r4 = r5
            goto L_0x0078
        L_0x0080:
            r0 = move-exception
            java.lang.String r8 = "MPChart-FileUtils"
            java.lang.String r9 = r0.toString()
            android.util.Log.e(r8, r9)
            r4 = r5
            goto L_0x0078
        L_0x008c:
            r0 = move-exception
            java.lang.String r8 = "MPChart-FileUtils"
            java.lang.String r9 = r0.toString()
            android.util.Log.e(r8, r9)
            goto L_0x0078
        L_0x0097:
            r8 = move-exception
        L_0x0098:
            if (r4 == 0) goto L_0x009d
            r4.close()     // Catch:{ IOException -> 0x009e }
        L_0x009d:
            throw r8
        L_0x009e:
            r0 = move-exception
            java.lang.String r9 = "MPChart-FileUtils"
            java.lang.String r10 = r0.toString()
            android.util.Log.e(r9, r10)
            goto L_0x009d
        L_0x00a9:
            r8 = move-exception
            r4 = r5
            goto L_0x0098
        L_0x00ac:
            r0 = move-exception
            goto L_0x006a
        L_0x00ae:
            r4 = r5
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }

    public static void saveToSdCard(List<Entry> entries, String path) {
        File saved = new File(Environment.getExternalStorageDirectory(), path);
        if (!saved.exists()) {
            try {
                saved.createNewFile();
            } catch (IOException e) {
                Log.e(LOG, e.toString());
            }
        }
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(saved, true));
            for (Entry e2 : entries) {
                buf.append(e2.getY() + "#" + e2.getX());
                buf.newLine();
            }
            buf.close();
        } catch (IOException e3) {
            Log.e(LOG, e3.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[SYNTHETIC, Splitter:B:19:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[SYNTHETIC, Splitter:B:25:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.github.mikephil.charting.data.BarEntry> loadBarEntriesFromAssets(android.content.res.AssetManager r9, java.lang.String r10) {
        /*
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0050 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0050 }
            java.io.InputStream r7 = r9.open(r10)     // Catch:{ IOException -> 0x0050 }
            java.lang.String r8 = "UTF-8"
            r6.<init>(r7, r8)     // Catch:{ IOException -> 0x0050 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x0050 }
            java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x0080, all -> 0x007d }
        L_0x001a:
            if (r2 == 0) goto L_0x003d
            java.lang.String r6 = "#"
            java.lang.String[] r5 = r2.split(r6)     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            com.github.mikephil.charting.data.BarEntry r6 = new com.github.mikephil.charting.data.BarEntry     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            r7 = 1
            r7 = r5[r7]     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            r8 = 0
            r8 = r5[r8]     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            r6.<init>((float) r7, (float) r8)     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            r1.add(r6)     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x0080, all -> 0x007d }
            goto L_0x001a
        L_0x003d:
            if (r4 == 0) goto L_0x0083
            r4.close()     // Catch:{ IOException -> 0x0044 }
            r3 = r4
        L_0x0043:
            return r1
        L_0x0044:
            r0 = move-exception
            java.lang.String r6 = "MPChart-FileUtils"
            java.lang.String r7 = r0.toString()
            android.util.Log.e(r6, r7)
            r3 = r4
            goto L_0x0043
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            java.lang.String r6 = "MPChart-FileUtils"
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x006b }
            android.util.Log.e(r6, r7)     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0043
        L_0x0060:
            r0 = move-exception
            java.lang.String r6 = "MPChart-FileUtils"
            java.lang.String r7 = r0.toString()
            android.util.Log.e(r6, r7)
            goto L_0x0043
        L_0x006b:
            r6 = move-exception
        L_0x006c:
            if (r3 == 0) goto L_0x0071
            r3.close()     // Catch:{ IOException -> 0x0072 }
        L_0x0071:
            throw r6
        L_0x0072:
            r0 = move-exception
            java.lang.String r7 = "MPChart-FileUtils"
            java.lang.String r8 = r0.toString()
            android.util.Log.e(r7, r8)
            goto L_0x0071
        L_0x007d:
            r6 = move-exception
            r3 = r4
            goto L_0x006c
        L_0x0080:
            r0 = move-exception
            r3 = r4
            goto L_0x0051
        L_0x0083:
            r3 = r4
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.FileUtils.loadBarEntriesFromAssets(android.content.res.AssetManager, java.lang.String):java.util.List");
    }
}
