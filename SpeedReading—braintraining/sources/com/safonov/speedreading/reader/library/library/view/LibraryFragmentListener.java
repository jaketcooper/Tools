package com.safonov.speedreading.reader.library.library.view;

import com.safonov.speedreading.reader.repository.entity.BookDescription;

public interface LibraryFragmentListener {
    void onLibraryAddBookClick();

    void onLibraryBookOpen(BookDescription bookDescription);
}
