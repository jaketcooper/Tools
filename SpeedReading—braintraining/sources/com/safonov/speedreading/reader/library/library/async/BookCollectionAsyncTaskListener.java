package com.safonov.speedreading.reader.library.library.async;

import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import java.util.List;

public interface BookCollectionAsyncTaskListener {
    void onCollectionPostExecute(@NonNull List<BookDescription> list);

    void onCollectionPreExecute();
}
