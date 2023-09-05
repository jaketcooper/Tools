package com.safonov.speedreading.reader.library.library.async;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.IBookController;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public class BookDeleteAsyncTask extends AsyncTask<BookDescription, Void, Void> {
    private IBookController bookController;
    private BookDeleteAsyncTaskListener listener;

    public BookDeleteAsyncTask(@NonNull IBookController bookController2, BookDeleteAsyncTaskListener listener2) {
        this.bookController = bookController2;
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.listener != null) {
            this.listener.onBookDeletePreExecute();
        }
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(BookDescription... params) {
        for (BookDescription bookDescription : params) {
            this.bookController.removeBook(bookDescription);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Void v) {
        super.onPostExecute(v);
        if (this.listener != null) {
            this.listener.oBookDeletePostExecute();
        }
    }
}
