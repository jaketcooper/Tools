package com.safonov.speedreading.reader.library.fileexplorer.view;

import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface FileExplorerFragmentListener {
    void onFileExplorerBookOpen(BookDescription bookDescription);

    void onFileExplorerClose();

    void setActionBarTitle(String str);
}
