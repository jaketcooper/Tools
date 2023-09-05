package com.safonov.speedreading.reader.repository.dao.bookdao;

import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.exception.BookAlreadyExistException;
import com.safonov.speedreading.reader.repository.exception.BookParserException;

public interface IBookDao {
    BookDescription addBook(String str) throws BookParserException, BookAlreadyExistException;

    BookContent getBookContent(BookDescription bookDescription) throws BookParserException;

    void removeBook(long j);
}
