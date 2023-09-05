package com.safonov.speedreading.reader.reader.async;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.reader.util2.PageSplitter;
import com.safonov.speedreading.reader.reader.util2.SplittedBook;
import com.safonov.speedreading.reader.repository.entity.BookContent;

public class BookSeparatorAsyncTask extends AsyncTask<BookContent, Void, SplittedBook> {
    private BookSeparatorAsyncTaskListener listener;
    private PageSplitter pageSplitter;

    public BookSeparatorAsyncTask(@NonNull PageSplitter pageSplitter2, BookSeparatorAsyncTaskListener listener2) {
        this.pageSplitter = pageSplitter2;
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        if (this.listener != null) {
            this.listener.onPreBookSeparate();
        }
    }

    /* access modifiers changed from: protected */
    public SplittedBook doInBackground(BookContent... bookContents) {
        return this.pageSplitter.getSeparatedBook(bookContents[0]);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(SplittedBook splittedBook) {
        super.onPostExecute(splittedBook);
        if (this.listener != null) {
            this.listener.onPostBookSeparate(splittedBook);
        }
    }
}
