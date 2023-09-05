package com.safonov.speedreading.reader.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.exception.BookAlreadyExistException;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import com.safonov.speedreading.reader.repository.exception.BookUnsupportedFormatException;
import java.util.List;

public interface IBookController {
    BookDescription addBook(String str) throws BookParserException, BookAlreadyExistException, BookUnsupportedFormatException;

    BookDescription findBookDescription(long j);

    BookDescription findBookDescription(String str);

    BookContent getBookContent(BookDescription bookDescription) throws BookParserException, BookUnsupportedFormatException;

    @NonNull
    List<BookDescription> getBookDescriptionList();

    void removeBook(BookDescription bookDescription);

    void updateBookDescription(BookDescription bookDescription);
}
