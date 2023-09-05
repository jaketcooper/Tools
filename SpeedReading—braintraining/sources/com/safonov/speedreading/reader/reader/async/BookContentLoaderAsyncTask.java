package com.safonov.speedreading.reader.reader.async;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.IBookController;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import com.safonov.speedreading.reader.repository.exception.BookUnsupportedFormatException;

public class BookContentLoaderAsyncTask extends AsyncTask<BookDescription, Void, BookContent> {
    private IBookController bookController;
    private BookContentLoaderAsyncTaskListener listener;

    public BookContentLoaderAsyncTask(@NonNull IBookController bookController2, BookContentLoaderAsyncTaskListener listener2) {
        this.bookController = bookController2;
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.listener != null) {
            this.listener.onBookContentLoaderPreExecute();
        }
    }

    /* access modifiers changed from: protected */
    public BookContent doInBackground(BookDescription... bookDescriptions) {
        try {
            return this.bookController.getBookContent(bookDescriptions[0]);
        } catch (BookParserException | BookUnsupportedFormatException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(BookContent bookContent) {
        super.onPostExecute(bookContent);
        if (this.listener == null) {
            return;
        }
        if (bookContent == null) {
            this.listener.onBookContentLoaderExecuteError();
        } else {
            this.listener.onBookContentLoaderExecuteSuccess(bookContent);
        }
    }
}
