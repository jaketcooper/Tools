package com.safonov.speedreading.reader.library.library.async;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.IBookController;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import java.util.List;

public class BookCollectionAsyncTask extends AsyncTask<Void, Void, List<BookDescription>> {
    private IBookController bookController;
    private BookCollectionAsyncTaskListener listener;

    public BookCollectionAsyncTask(@NonNull IBookController bookController2, BookCollectionAsyncTaskListener listener2) {
        this.bookController = bookController2;
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        this.listener.onCollectionPreExecute();
    }

    /* access modifiers changed from: protected */
    public List<BookDescription> doInBackground(Void... params) {
        return this.bookController.getBookDescriptionList();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<BookDescription> bookDescriptionList) {
        super.onPostExecute(bookDescriptionList);
        if (this.listener != null) {
            this.listener.onCollectionPostExecute(bookDescriptionList);
        }
    }
}
