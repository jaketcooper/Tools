package com.safonov.speedreading.reader.reader.async;

import com.safonov.speedreading.reader.reader.util2.SplittedBook;

public interface BookSeparatorAsyncTaskListener {
    void onPostBookSeparate(SplittedBook splittedBook);

    void onPreBookSeparate();
}
