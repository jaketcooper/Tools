package com.safonov.speedreading.reader.library.fileexplorer.async;

import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface BookAddAsyncTaskListener {
    void onBookAddFailed();

    void onBookAddPreExecute();

    void onBookAddedSuccess(BookDescription bookDescription);

    void onBookAlreadyExist(BookDescription bookDescription);
}
