package com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import java.util.ArrayList;
import java.util.List;

class SqlLiteBookDescriptionDao implements IBookDescriptionDao {
    private SQLiteDatabase database;

    SqlLiteBookDescriptionDao(SQLiteDatabase database2) {
        this.database = database2;
    }

    private ContentValues getValues(BookDescription bookDescription) {
        ContentValues values = new ContentValues();
        values.put(BookDescriptionDatabaseHelper.BOOK_TITLE, bookDescription.getTitle());
        values.put(BookDescriptionDatabaseHelper.BOOK_AUTHOR, bookDescription.getAuthor());
        values.put(BookDescriptionDatabaseHelper.BOOK_LANGUAGE, bookDescription.getLanguage());
        values.put(BookDescriptionDatabaseHelper.BOOK_COVER_NAME, bookDescription.getCoverImagePath());
        values.put(BookDescriptionDatabaseHelper.BOOK_FILE_PATH, bookDescription.getFilePath());
        values.put("type", bookDescription.getType());
        values.put(BookDescriptionDatabaseHelper.BOOK_FAVORITE_FLAG, Boolean.valueOf(bookDescription.isFavorite()));
        values.put("progress", Integer.valueOf(bookDescription.getProgress()));
        values.put(BookDescriptionDatabaseHelper.BOOK_OFFSET, Long.valueOf(bookDescription.getBookOffset()));
        return values;
    }

    public long addBookDescription(BookDescription bookDescription) {
        return this.database.insert(BookDescriptionDatabaseHelper.BOOK_TABLE, (String) null, getValues(bookDescription));
    }

    public long getNextItemId() {
        Cursor cursor = this.database.rawQuery("SELECT * FROM SQLITE_SEQUENCE WHERE name='books'", (String[]) null);
        long result = 0;
        if (cursor.moveToFirst()) {
            result = cursor.getLong(cursor.getColumnIndex("seq"));
            cursor.close();
        }
        return 1 + result;
    }

    public BookDescription findBookDescription(String filePath) {
        Cursor cursor = this.database.rawQuery("SELECT * FROM books WHERE file_path='" + filePath.replaceAll("'", "''") + "'", (String[]) null);
        if (!cursor.moveToFirst()) {
            return null;
        }
        BookDescription result = getBookDescription(cursor);
        cursor.close();
        return result;
    }

    public BookDescription findBookDescription(long id) {
        Cursor cursor = this.database.rawQuery("SELECT * FROM books WHERE _id='" + id + "'", (String[]) null);
        if (!cursor.moveToFirst()) {
            return null;
        }
        BookDescription result = getBookDescription(cursor);
        cursor.close();
        return result;
    }

    public void updateBookDescription(BookDescription bookDescription) {
        this.database.update(BookDescriptionDatabaseHelper.BOOK_TABLE, getValues(bookDescription), "_id='" + bookDescription.getId() + "'", (String[]) null);
    }

    public void removeBookDescription(long id) {
        this.database.delete(BookDescriptionDatabaseHelper.BOOK_TABLE, "_id=" + id, (String[]) null);
    }

    @NonNull
    public List<BookDescription> getBookDescriptionList() {
        Cursor cursor = this.database.query(BookDescriptionDatabaseHelper.BOOK_TABLE, BookDescriptionDatabaseHelper.BOOK_TABLE_COLUMNS, (String) null, (String[]) null, (String) null, (String) null, BookDescriptionDatabaseHelper.BOOK_TITLE);
        List<BookDescription> bookDescriptions = new ArrayList<>(cursor.getCount());
        if (cursor.moveToFirst()) {
            do {
                bookDescriptions.add(getBookDescription(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return bookDescriptions;
    }

    private BookDescription getBookDescription(Cursor cursor) {
        boolean favoriteFlag = true;
        BookDescription bookDescription = new BookDescription();
        bookDescription.setId((long) cursor.getInt(cursor.getColumnIndex("_id")));
        bookDescription.setTitle(cursor.getString(cursor.getColumnIndex(BookDescriptionDatabaseHelper.BOOK_TITLE)));
        bookDescription.setAuthor(cursor.getString(cursor.getColumnIndex(BookDescriptionDatabaseHelper.BOOK_AUTHOR)));
        bookDescription.setLanguage(cursor.getString(cursor.getColumnIndex(BookDescriptionDatabaseHelper.BOOK_LANGUAGE)));
        bookDescription.setCoverImagePath(cursor.getString(cursor.getColumnIndex(BookDescriptionDatabaseHelper.BOOK_COVER_NAME)));
        bookDescription.setFilePath(cursor.getString(cursor.getColumnIndex(BookDescriptionDatabaseHelper.BOOK_FILE_PATH)));
        bookDescription.setType(cursor.getString(cursor.getColumnIndex("type")));
        bookDescription.setProgress(cursor.getInt(cursor.getColumnIndex("progress")));
        bookDescription.setBookOffset(cursor.getLong(cursor.getColumnIndex(BookDescriptionDatabaseHelper.BOOK_OFFSET)));
        if (cursor.getInt(cursor.getColumnIndex(BookDescriptionDatabaseHelper.BOOK_FAVORITE_FLAG)) != 1) {
            favoriteFlag = false;
        }
        bookDescription.setFavorite(favoriteFlag);
        return bookDescription;
    }
}
