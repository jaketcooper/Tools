package com.safonov.speedreading.reader.library.fileexplorer.async;

import android.os.AsyncTask;
import com.safonov.speedreading.reader.repository.IBookController;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.exception.BookAlreadyExistException;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import com.safonov.speedreading.reader.repository.exception.BookUnsupportedFormatException;

public class BookAddAsyncTask extends AsyncTask<String, Void, BookDescriptionWrapper> {
    private IBookController bookController;
    private BookAddAsyncTaskListener listener;

    private enum Status {
        OK,
        BOOK_PARSER_EXCEPTION,
        BOOK_ALREADY_EXIST_EXCEPTION,
        BOOK_UNSUPPORTED_FORMAT_EXCEPTION
    }

    public BookAddAsyncTask(IBookController bookController2, BookAddAsyncTaskListener listener2) {
        this.bookController = bookController2;
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        this.listener.onBookAddPreExecute();
    }

    class BookDescriptionWrapper {
        private BookDescription bookDescription;
        private Status status;

        public BookDescriptionWrapper(Status status2) {
            this.status = status2;
        }

        public BookDescriptionWrapper(BookDescription bookDescription2, Status status2) {
            this.bookDescription = bookDescription2;
            this.status = status2;
        }

        public BookDescription getBookDescription() {
            return this.bookDescription;
        }

        public Status getStatus() {
            return this.status;
        }
    }

    /* access modifiers changed from: protected */
    public BookDescriptionWrapper doInBackground(String... params) {
        String filePath = params[0];
        try {
            return new BookDescriptionWrapper(this.bookController.addBook(filePath), Status.OK);
        } catch (BookParserException e) {
            return new BookDescriptionWrapper(Status.BOOK_PARSER_EXCEPTION);
        } catch (BookAlreadyExistException e2) {
            return new BookDescriptionWrapper(this.bookController.findBookDescription(filePath), Status.BOOK_ALREADY_EXIST_EXCEPTION);
        } catch (BookUnsupportedFormatException e3) {
            return new BookDescriptionWrapper(Status.BOOK_UNSUPPORTED_FORMAT_EXCEPTION);
        } catch (Exception e4) {
            return new BookDescriptionWrapper(Status.BOOK_PARSER_EXCEPTION);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(BookDescriptionWrapper bookDescriptionWrapper) {
        super.onPostExecute(bookDescriptionWrapper);
        if (this.listener != null) {
            switch (bookDescriptionWrapper.getStatus()) {
                case OK:
                    this.listener.onBookAddedSuccess(bookDescriptionWrapper.getBookDescription());
                    return;
                case BOOK_ALREADY_EXIST_EXCEPTION:
                    this.listener.onBookAlreadyExist(bookDescriptionWrapper.getBookDescription());
                    return;
                default:
                    this.listener.onBookAddFailed();
                    return;
            }
        }
    }
}
