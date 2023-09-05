package com.safonov.speedreading.reader.library.activity.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p000v4.app.Fragment;
import android.support.p003v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.safonov.speedreading.reader.library.activity.presenter.ILibraryPresenter;
import com.safonov.speedreading.reader.library.activity.presenter.LibraryPresenter;
import com.safonov.speedreading.reader.library.detail.view.BookDetailFragment;
import com.safonov.speedreading.reader.library.fileexplorer.view.FileExplorerFragment;
import com.safonov.speedreading.reader.library.library.view.LibraryFragment;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.speedreading.alexander.speedreading.R;

public class LibraryActivity extends MvpActivity<ILibraryView, ILibraryPresenter> implements ILibraryView {
    private Fragment currentFragment;
    @BindView(2131296781)
    Toolbar toolbar;
    private Unbinder unbinder;

    @NonNull
    public ILibraryPresenter createPresenter() {
        return new LibraryPresenter();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.reader_library_activity);
        this.unbinder = ButterKnife.bind((Activity) this);
        this.toolbar.setTitleTextColor(-1);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((ILibraryPresenter) this.presenter).init();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                ((ILibraryPresenter) this.presenter).onActionBarHomePressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBackPressed() {
        ((ILibraryPresenter) this.presenter).onBackPressed();
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commitAllowingStateLoss();
        this.currentFragment = fragment;
    }

    public void setLibraryFragment() {
        getSupportActionBar().setTitle((int) R.string.library);
        setFragment(LibraryFragment.newInstance());
    }

    public void setFileExplorerFragment() {
        setFragment(FileExplorerFragment.newInstance());
    }

    public void setBookDetailFragment(BookDescription bookDescription) {
        getSupportActionBar().setTitle((CharSequence) bookDescription.getTitle());
        setFragment(BookDetailFragment.newInstance(bookDescription));
    }

    public void onLibraryAddBookClick() {
        ((ILibraryPresenter) this.presenter).requestToSetFileExplorerFragment();
    }

    public void onLibraryBookOpen(BookDescription bookDescription) {
        ((ILibraryPresenter) this.presenter).requestToSetBookDetailFragment(bookDescription);
    }

    public void onFileExplorerBookOpen(BookDescription bookDescription) {
        ((ILibraryPresenter) this.presenter).requestToSetBookDetailFragment(bookDescription);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle((CharSequence) title);
    }

    public void onFileExplorerBackPressed() {
        ((BackPressedListener) this.currentFragment).onBackPressed();
    }

    public void onFileExplorerClose() {
        ((ILibraryPresenter) this.presenter).requestToSetLibraryFragment();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.unbinder.unbind();
    }
}
