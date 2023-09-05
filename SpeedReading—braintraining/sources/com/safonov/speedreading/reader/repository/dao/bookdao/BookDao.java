package com.safonov.speedreading.reader.repository.dao.bookdao;

import android.content.Context;
import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.BookDescriptionDatabaseHelper;
import java.io.File;

public abstract class BookDao {
    protected final IBookDescriptionDao bookDescriptionDao;
    protected final String libraryFilePath;

    public BookDao(@NonNull Context context, @NonNull IBookDescriptionDao bookDescriptionDao2) {
        this.bookDescriptionDao = bookDescriptionDao2;
        this.libraryFilePath = context.getApplicationInfo().dataDir + File.separator + BookDescriptionDatabaseHelper.BOOK_TABLE;
    }
}
