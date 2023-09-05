package com.safonov.speedreading.reader.repository;

import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.dao.bookdao.epub.IEpubDao;
import com.safonov.speedreading.reader.repository.dao.bookdao.fb2.IFb2Dao;
import com.safonov.speedreading.reader.repository.dao.bookdao.txt.ITxtDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.exception.BookAlreadyExistException;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import com.safonov.speedreading.reader.repository.exception.BookUnsupportedFormatException;
import com.safonov.speedreading.reader.repository.util.FileUtil;
import java.util.List;

public class BookController implements IBookController {
    private IBookDescriptionDao bookDescriptionDao;
    private IEpubDao epubDao;
    private IFb2Dao fb2Dao;
    private ITxtDao txtDao;

    public BookController(@NonNull IBookDescriptionDao bookDescriptionDao2, @NonNull IFb2Dao fb2Dao2, @NonNull IEpubDao epubDao2, @NonNull ITxtDao txtDao2) {
        this.bookDescriptionDao = bookDescriptionDao2;
        this.fb2Dao = fb2Dao2;
        this.epubDao = epubDao2;
        this.txtDao = txtDao2;
    }

    public BookDescription addBook(String filePath) throws BookParserException, BookAlreadyExistException, BookUnsupportedFormatException {
        String fileExtension = FileUtil.getFileExtension(filePath);
        char c = 65535;
        switch (fileExtension.hashCode()) {
            case -1110581207:
                if (fileExtension.equals(FileUtil.FB2_ZIP)) {
                    c = 1;
                    break;
                }
                break;
            case 101110:
                if (fileExtension.equals(FileUtil.FB2)) {
                    c = 0;
                    break;
                }
                break;
            case 115312:
                if (fileExtension.equals(FileUtil.TXT)) {
                    c = 3;
                    break;
                }
                break;
            case 3120248:
                if (fileExtension.equals(FileUtil.EPUB)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return this.fb2Dao.addBook(filePath);
            case 2:
                return this.epubDao.addBook(filePath);
            case 3:
                return this.txtDao.addBook(filePath);
            default:
                throw new BookUnsupportedFormatException();
        }
    }

    public BookContent getBookContent(BookDescription bookDescription) throws BookParserException, BookUnsupportedFormatException {
        String type = bookDescription.getType();
        char c = 65535;
        switch (type.hashCode()) {
            case 101110:
                if (type.equals(FileUtil.FB2)) {
                    c = 0;
                    break;
                }
                break;
            case 115312:
                if (type.equals(FileUtil.TXT)) {
                    c = 2;
                    break;
                }
                break;
            case 3120248:
                if (type.equals(FileUtil.EPUB)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.fb2Dao.getBookContent(bookDescription);
            case 1:
                return this.epubDao.getBookContent(bookDescription);
            case 2:
                return this.txtDao.getBookContent(bookDescription);
            default:
                throw new BookUnsupportedFormatException();
        }
    }

    public BookDescription findBookDescription(String filePath) {
        return this.bookDescriptionDao.findBookDescription(filePath);
    }

    public BookDescription findBookDescription(long id) {
        return this.bookDescriptionDao.findBookDescription(id);
    }

    @NonNull
    public List<BookDescription> getBookDescriptionList() {
        return this.bookDescriptionDao.getBookDescriptionList();
    }

    public void updateBookDescription(BookDescription bookDescription) {
        this.bookDescriptionDao.updateBookDescription(bookDescription);
    }

    public void removeBook(BookDescription bookDescription) {
        String type = bookDescription.getType();
        char c = 65535;
        switch (type.hashCode()) {
            case 101110:
                if (type.equals(FileUtil.FB2)) {
                    c = 0;
                    break;
                }
                break;
            case 115312:
                if (type.equals(FileUtil.TXT)) {
                    c = 2;
                    break;
                }
                break;
            case 3120248:
                if (type.equals(FileUtil.EPUB)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.fb2Dao.removeBook(bookDescription.getId());
                return;
            case 1:
                this.epubDao.removeBook(bookDescription.getId());
                return;
            case 2:
                this.txtDao.removeBook(bookDescription.getId());
                return;
            default:
                return;
        }
    }
}
