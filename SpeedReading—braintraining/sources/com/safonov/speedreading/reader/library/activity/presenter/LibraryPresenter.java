package com.safonov.speedreading.reader.library.activity.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.reader.library.activity.view.ILibraryView;
import com.safonov.speedreading.reader.repository.entity.BookDescription;

public class LibraryPresenter extends MvpBasePresenter<ILibraryView> implements ILibraryPresenter {
    private FragmentType fragmentType;

    private enum FragmentType {
        LIBRARY,
        FILE_EXPLORER,
        BOOK_DETAIL
    }

    public void init() {
        setFragmentType(FragmentType.LIBRARY);
    }

    private void setFragmentType(FragmentType fragmentType2) {
        this.fragmentType = fragmentType2;
        switch (fragmentType2) {
            case LIBRARY:
                ((ILibraryView) getView()).setLibraryFragment();
                return;
            case FILE_EXPLORER:
                ((ILibraryView) getView()).setFileExplorerFragment();
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        switch (this.fragmentType) {
            case LIBRARY:
                ((ILibraryView) getView()).finish();
                return;
            case FILE_EXPLORER:
                ((ILibraryView) getView()).onFileExplorerBackPressed();
                return;
            case BOOK_DETAIL:
                setFragmentType(FragmentType.LIBRARY);
                return;
            default:
                return;
        }
    }

    public void requestToSetLibraryFragment() {
        setFragmentType(FragmentType.LIBRARY);
    }

    public void requestToSetFileExplorerFragment() {
        setFragmentType(FragmentType.FILE_EXPLORER);
    }

    public void requestToSetBookDetailFragment(BookDescription bookDescription) {
        setFragmentType(FragmentType.BOOK_DETAIL);
        if (isViewAttached()) {
            ((ILibraryView) getView()).setBookDetailFragment(bookDescription);
        }
    }

    public void onActionBarHomePressed() {
        switch (this.fragmentType) {
            case LIBRARY:
                ((ILibraryView) getView()).finish();
                return;
            case FILE_EXPLORER:
                setFragmentType(FragmentType.LIBRARY);
                return;
            case BOOK_DETAIL:
                setFragmentType(FragmentType.LIBRARY);
                return;
            default:
                return;
        }
    }
}
