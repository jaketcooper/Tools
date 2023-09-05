package com.safonov.speedreading.reader.library.fileexplorer.util;

import com.safonov.speedreading.reader.library.fileexplorer.model.FileExplorerFileType;
import com.safonov.speedreading.reader.library.fileexplorer.model.FileExplorerFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileExplorerUtils {
    private static final String EPUB = "epub";
    private static final String FB2 = "fb2";
    private static final String FB2_ZIP = "fb2.zip";
    private static final String TXT = "txt";

    private static String getFileExtension(File file) {
        return getFileExtension(file.getName());
    }

    private static String getFileExtension(String filePath) {
        int zipIndex;
        String fileName = new File(filePath).getName();
        String extension = null;
        int i = fileName.lastIndexOf(46);
        if (i > 0 && i < fileName.length() - 1) {
            extension = fileName.substring(i + 1).toLowerCase();
            if (extension.equals("zip") && (zipIndex = fileName.lastIndexOf("fb2.zip")) > 1 && zipIndex == fileName.length() - "fb2.zip".length() && fileName.charAt(zipIndex - 1) == '.') {
                return "fb2.zip";
            }
        }
        return extension;
    }

    public static List<FileExplorerFileWrapper> filterFiles(File[] files) {
        if (files == null) {
            return Collections.emptyList();
        }
        List<FileExplorerFileWrapper> acceptedFiles = new ArrayList<>(files.length);
        for (File file : files) {
            if (!file.isHidden()) {
                if (file.isDirectory()) {
                    acceptedFiles.add(new FileExplorerFileWrapper(file, FileExplorerFileType.FOLDER));
                } else {
                    String fileExtension = getFileExtension(file);
                    if (fileExtension != null) {
                        char c = 65535;
                        switch (fileExtension.hashCode()) {
                            case -1110581207:
                                if (fileExtension.equals("fb2.zip")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 101110:
                                if (fileExtension.equals("fb2")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 115312:
                                if (fileExtension.equals("txt")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 3120248:
                                if (fileExtension.equals("epub")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                acceptedFiles.add(new FileExplorerFileWrapper(file, FileExplorerFileType.EPUB));
                                break;
                            case 1:
                                acceptedFiles.add(new FileExplorerFileWrapper(file, FileExplorerFileType.TXT));
                                break;
                            case 2:
                                acceptedFiles.add(new FileExplorerFileWrapper(file, FileExplorerFileType.FB2));
                                break;
                            case 3:
                                acceptedFiles.add(new FileExplorerFileWrapper(file, FileExplorerFileType.FB2_ZIP));
                                break;
                        }
                    }
                }
            }
        }
        return acceptedFiles;
    }
}
