package com.safonov.speedreading.reader.library.library.view;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import java.util.List;

public interface ILibraryView extends MvpView {
    void dismissProgressDialog();

    void removeItem(long j);

    void requestToSetBookDetailFragment(@NonNull BookDescription bookDescription);

    void requestToSetFileExplorerFragment();

    void setItems(@NonNull List<BookDescription> list);

    void setSpeedReadingBookInfo(BookDescription bookDescription);

    void showActionDialog(String str);

    void showFormatDialog();

    void showLoadingLibraryProgressDialog();

    void showRemovingBookProgressDialog();
}
