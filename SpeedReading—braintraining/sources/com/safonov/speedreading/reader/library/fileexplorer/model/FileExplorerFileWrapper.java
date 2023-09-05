package com.safonov.speedreading.reader.library.fileexplorer.model;

import java.io.File;

public class FileExplorerFileWrapper {
    private File file;
    private FileExplorerFileType type;

    public FileExplorerFileWrapper(File file2, FileExplorerFileType type2) {
        this.file = file2;
        this.type = type2;
    }

    public File getFile() {
        return this.file;
    }

    public FileExplorerFileType getType() {
        return this.type;
    }

    public String getFileName() {
        return this.file.getName();
    }
}
