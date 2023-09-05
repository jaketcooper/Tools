package com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class BookDescriptionDatabaseHelper extends SQLiteOpenHelper implements BaseColumns {
    public static final String BOOK_AUTHOR = "author";
    public static final String BOOK_COVER_NAME = "cover_name";
    public static final String BOOK_FAVORITE_FLAG = "favorite";
    public static final String BOOK_FILE_PATH = "file_path";
    public static final String BOOK_LANGUAGE = "language";
    public static final String BOOK_OFFSET = "book_offset";
    public static final String BOOK_PROGRESS = "progress";
    public static final String BOOK_TABLE = "books";
    public static final String[] BOOK_TABLE_COLUMNS = {"_id", BOOK_TITLE, BOOK_AUTHOR, BOOK_LANGUAGE, BOOK_COVER_NAME, BOOK_FILE_PATH, "type", BOOK_FAVORITE_FLAG, "progress", BOOK_OFFSET};
    public static final String BOOK_TITLE = "title";
    public static final String BOOK_TYPE = "type";
    private static final String DATABASE_NAME = "books_database.db";
    private static final int DATABASE_VERSION = 3;

    public BookDescriptionDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 3);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE books(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT, language TEXT, cover_name TEXT, file_path TEXT NOT NULL, type TEXT NOT NULL, favorite INTEGER NOT NULL, progress INTEGER NOT NULL, book_offset INTEGER NOT NULL);");
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        onCreate(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        onCreate(db);
    }
}
