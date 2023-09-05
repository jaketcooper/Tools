package com.safonov.speedreading.reader.reader.async;

import com.safonov.speedreading.reader.repository.entity.BookContent;

public interface BookContentLoaderAsyncTaskListener {
    void onBookContentLoaderExecuteError();

    void onBookContentLoaderExecuteSuccess(BookContent bookContent);

    void onBookContentLoaderPreExecute();
}
