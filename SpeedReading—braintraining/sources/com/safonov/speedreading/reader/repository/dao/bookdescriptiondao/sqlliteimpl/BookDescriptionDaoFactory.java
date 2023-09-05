package com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl;

import android.content.Context;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;

public abstract class BookDescriptionDaoFactory {
    public abstract IBookDescriptionDao getBookDescriptionDao();

    public static BookDescriptionDaoFactory getDaoFactory(Context context) {
        return new SQLiteDaoFactory(context);
    }
}
