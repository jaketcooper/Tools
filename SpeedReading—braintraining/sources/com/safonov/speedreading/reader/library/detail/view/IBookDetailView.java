package com.safonov.speedreading.reader.library.detail.view;

import android.graphics.Bitmap;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface IBookDetailView extends MvpView {
    void setAuthorView(String str);

    void setAuthorViewVisibility(boolean z);

    void setCoverView(Bitmap bitmap);

    void setFilePathView(String str);

    void setLanguageView(String str);

    void setLanguageViewVisibility(boolean z);

    void setTitleView(String str);
}
