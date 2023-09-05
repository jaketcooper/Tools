package com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;

public class SQLiteDaoFactory extends BookDescriptionDaoFactory {
    private SQLiteDatabase database;

    public SQLiteDaoFactory(Context context) {
        this.database = new BookDescriptionDatabaseHelper(context).getWritableDatabase();
    }

    public IBookDescriptionDao getBookDescriptionDao() {
        return new SqlLiteBookDescriptionDao(this.database);
    }
}
