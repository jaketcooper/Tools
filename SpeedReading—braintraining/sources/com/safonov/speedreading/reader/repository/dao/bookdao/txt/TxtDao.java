package com.safonov.speedreading.reader.repository.dao.bookdao.txt;

import android.content.Context;
import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.dao.bookdao.BookDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.entity.BookChapter;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.entity.TxtBookChapter;
import com.safonov.speedreading.reader.repository.exception.BookAlreadyExistException;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import com.safonov.speedreading.reader.repository.util.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TxtDao extends BookDao implements ITxtDao {
    public TxtDao(@NonNull Context context, @NonNull IBookDescriptionDao bookDescriptionDao) {
        super(context, bookDescriptionDao);
    }

    public BookDescription addBook(String filePath) throws BookParserException, BookAlreadyExistException {
        if (this.bookDescriptionDao.findBookDescription(filePath) != null) {
            throw new BookAlreadyExistException();
        }
        BookDescription bookDescription = new BookDescription();
        bookDescription.setId(this.bookDescriptionDao.getNextItemId());
        bookDescription.setFilePath(filePath);
        bookDescription.setType(FileUtil.TXT);
        bookDescription.setTitle(FileUtil.getFileName(filePath));
        this.bookDescriptionDao.addBookDescription(bookDescription);
        return bookDescription;
    }

    public BookContent getBookContent(BookDescription bookDescription) throws BookParserException {
        TxtBookChapter bookChapter = new TxtBookChapter();
        try {
            String encoding = FileUtil.getEncoding(new File(bookDescription.getFilePath()));
            if (encoding == null) {
                String content = FileUtil.getTextFromFile(bookDescription.getFilePath());
                bookChapter.setTitle(bookDescription.getTitle());
                bookChapter.setContent(content);
            } else {
                String content2 = FileUtil.getTextFromFile(bookDescription.getFilePath(), encoding);
                bookChapter.setTitle(bookDescription.getTitle());
                bookChapter.setContent(content2);
            }
            List<BookChapter> bookChapterList = new LinkedList<>();
            bookChapterList.add(bookChapter);
            BookContent bookContent = new BookContent();
            bookContent.setBookChapterList(bookChapterList);
            return bookContent;
        } catch (IOException e) {
            throw new BookParserException((Throwable) e);
        }
    }

    public void removeBook(long id) {
        this.bookDescriptionDao.removeBookDescription(id);
    }
}
