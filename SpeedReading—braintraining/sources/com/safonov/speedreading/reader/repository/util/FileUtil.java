package com.safonov.speedreading.reader.repository.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.mozilla.universalchardet.CharsetListener;
import org.mozilla.universalchardet.UniversalDetector;

public class FileUtil {
    public static final String EPUB = "epub";
    public static final String FB2 = "fb2";
    public static final String FB2_ZIP = "fb2.zip";
    public static final String TXT = "txt";

    public static String getFileExtension(File file) {
        return getFileExtension(file.getName());
    }

    public static String getFileName(File file) {
        String fileName = file.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static String getFileName(String filePath) {
        String fileName = new File(filePath).getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static String getFileExtension(String filePath) {
        int zipIndex;
        String fileName = new File(filePath).getName();
        String extension = null;
        int i = fileName.lastIndexOf(46);
        if (i > 0 && i < fileName.length() - 1) {
            extension = fileName.substring(i + 1).toLowerCase();
            if (extension.equals("zip") && (zipIndex = fileName.lastIndexOf(FB2_ZIP)) > 1 && zipIndex == fileName.length() - FB2_ZIP.length() && fileName.charAt(zipIndex - 1) == '.') {
                return FB2_ZIP;
            }
        }
        return extension;
    }

    public static String getEncoding(File file) throws IOException {
        UniversalDetector detector = new UniversalDetector((CharsetListener) null);
        byte[] buf = new byte[4096];
        FileInputStream fis = new FileInputStream(file);
        while (true) {
            int nread = fis.read(buf);
            if (nread <= 0 || detector.isDone()) {
                detector.dataEnd();
            } else {
                detector.handleData(buf, 0, nread);
            }
        }
        detector.dataEnd();
        return detector.getDetectedCharset();
    }

    public static String getTextFromFile(File file, String charset) throws IOException {
        return getTextFromFile(new InputStreamReader(new FileInputStream(file), charset));
    }

    public static String getTextFromFile(String filePath, String charset) throws IOException {
        return getTextFromFile(new InputStreamReader(new FileInputStream(filePath), charset));
    }

    public static String getTextFromFile(InputStream inputStream, String charset) throws IOException {
        return getTextFromFile(new InputStreamReader(inputStream, charset));
    }

    public static String getTextFromFile(File file) throws IOException {
        return getTextFromFile(new InputStreamReader(new FileInputStream(file)));
    }

    public static String getTextFromFile(String filePath) throws IOException {
        return getTextFromFile(new InputStreamReader(new FileInputStream(filePath)));
    }

    public static String getTextFromFile(InputStream inputStream) throws IOException {
        return getTextFromFile(new InputStreamReader(inputStream));
    }

    private static String getTextFromFile(InputStreamReader streamReader) throws IOException {
        StringBuilder text = new StringBuilder();
        BufferedReader br = new BufferedReader(streamReader);
        while (true) {
            String line = br.readLine();
            if (line != null) {
                text.append(line);
                text.append(10);
            } else {
                br.close();
                return text.toString();
            }
        }
    }

    public static void unZip(String zipFilePath, String targetDirectory) throws IOException {
        ZipFile zipFile = new ZipFile(zipFilePath);
        File rootDirectory = new File(targetDirectory);
        if (!rootDirectory.exists()) {
            rootDirectory.mkdir();
        } else {
            removeDirectory(rootDirectory);
            rootDirectory.mkdir();
        }
        for (ZipEntry zipEntry : Collections.list(zipFile.entries())) {
            if (!zipEntry.isDirectory()) {
                File file = new File(targetDirectory, zipEntry.getName());
                new File(file.getParent()).mkdirs();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                byte[] data = new byte[4096];
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                while (true) {
                    int currentByte = inputStream.read(data, 0, 4096);
                    if (currentByte == -1) {
                        break;
                    }
                    bufferedOutputStream.write(data, 0, currentByte);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        }
        zipFile.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.io.File r7, java.io.File r8) throws java.io.IOException {
        /*
            r1 = 0
            r4 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0034 }
            r2.<init>(r7)     // Catch:{ all -> 0x0034 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0036 }
            r5.<init>(r8)     // Catch:{ all -> 0x0036 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r6]     // Catch:{ all -> 0x001b }
        L_0x0010:
            int r3 = r2.read(r0)     // Catch:{ all -> 0x001b }
            if (r3 <= 0) goto L_0x0029
            r6 = 0
            r5.write(r0, r6, r3)     // Catch:{ all -> 0x001b }
            goto L_0x0010
        L_0x001b:
            r6 = move-exception
            r4 = r5
            r1 = r2
        L_0x001e:
            if (r1 == 0) goto L_0x0023
            r1.close()
        L_0x0023:
            if (r4 == 0) goto L_0x0028
            r4.close()
        L_0x0028:
            throw r6
        L_0x0029:
            if (r2 == 0) goto L_0x002e
            r2.close()
        L_0x002e:
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return
        L_0x0034:
            r6 = move-exception
            goto L_0x001e
        L_0x0036:
            r6 = move-exception
            r1 = r2
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.safonov.speedreading.reader.repository.util.FileUtil.copyFile(java.io.File, java.io.File):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.io.InputStream r5, java.io.File r6) throws java.io.IOException {
        /*
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x002d }
            r3.<init>(r6)     // Catch:{ all -> 0x002d }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r4]     // Catch:{ all -> 0x0015 }
        L_0x000a:
            int r1 = r5.read(r0)     // Catch:{ all -> 0x0015 }
            if (r1 <= 0) goto L_0x0022
            r4 = 0
            r3.write(r0, r4, r1)     // Catch:{ all -> 0x0015 }
            goto L_0x000a
        L_0x0015:
            r4 = move-exception
            r2 = r3
        L_0x0017:
            if (r5 == 0) goto L_0x001c
            r5.close()
        L_0x001c:
            if (r2 == 0) goto L_0x0021
            r2.close()
        L_0x0021:
            throw r4
        L_0x0022:
            if (r5 == 0) goto L_0x0027
            r5.close()
        L_0x0027:
            if (r3 == 0) goto L_0x002c
            r3.close()
        L_0x002c:
            return
        L_0x002d:
            r4 = move-exception
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.safonov.speedreading.reader.repository.util.FileUtil.copyFile(java.io.InputStream, java.io.File):void");
    }

    public static boolean removeDirectory(File directory) {
        File[] files;
        if (directory.exists() && (files = directory.listFiles()) != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    removeDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        return directory.delete();
    }

    public static List<File> getFilesCollection(String filePath) {
        File[] tempFiles = new File(filePath).listFiles();
        if (tempFiles == null) {
            return Collections.emptyList();
        }
        List<File> files = new ArrayList<>();
        for (File file : tempFiles) {
            if (file.isFile()) {
                files.add(file);
            } else {
                getFilesRecursive(file, files);
            }
        }
        return files;
    }

    private static List<File> getFilesRecursive(File file, List<File> outFilesList) {
        if (file.isFile()) {
            outFilesList.add(file);
        } else {
            File[] tempFiles = file.listFiles();
            if (tempFiles != null) {
                for (File file1 : tempFiles) {
                    getFilesRecursive(file1, outFilesList);
                }
            }
        }
        return outFilesList;
    }
}
