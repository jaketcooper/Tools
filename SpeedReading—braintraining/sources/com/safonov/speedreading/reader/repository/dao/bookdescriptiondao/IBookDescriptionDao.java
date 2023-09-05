package com.safonov.speedreading.reader.repository.dao.bookdescriptiondao;

import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import java.util.List;

public interface IBookDescriptionDao {
    long addBookDescription(BookDescription bookDescription);

    BookDescription findBookDescription(long j);

    BookDescription findBookDescription(String str);

    @NonNull
    List<BookDescription> getBookDescriptionList();

    long getNextItemId();

    void removeBookDescription(long j);

    void updateBookDescription(BookDescription bookDescription);
}
