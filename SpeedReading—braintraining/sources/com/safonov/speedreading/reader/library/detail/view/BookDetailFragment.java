package com.safonov.speedreading.reader.library.detail.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.reader.library.detail.presenter.BookDetailPresenter;
import com.safonov.speedreading.reader.library.detail.presenter.IBookDetailPresenter;
import com.safonov.speedreading.reader.reader.view.ReaderActivity;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.training.activity.view.TrainingActivity;
import com.speedreading.alexander.speedreading.R;

public class BookDetailFragment extends MvpFragment<IBookDetailView, IBookDetailPresenter> implements IBookDetailView {
    private static final String BOOK_DESCRIPTION_PARAM = "book_description";
    @BindView(2131296301)
    TextView authorTextView;
    @BindView(2131296302)
    View authorView;
    private BookDescription bookDescription;
    @BindView(2131296316)
    ImageView coverImageView;
    @BindView(2131296400)
    TextView filePathTextView;
    @BindView(2131296467)
    TextView languageTextView;
    @BindView(2131296468)
    View languageView;
    @BindView(2131296780)
    TextView titleTextView;
    private Unbinder unbinder;

    @NonNull
    public IBookDetailPresenter createPresenter() {
        return new BookDetailPresenter();
    }

    public static BookDetailFragment newInstance(BookDescription bookDescription2) {
        BookDetailFragment fragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(BOOK_DESCRIPTION_PARAM, bookDescription2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.bookDescription = (BookDescription) getArguments().getParcelable(BOOK_DESCRIPTION_PARAM);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reader_book_detail_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IBookDetailPresenter) this.presenter).init(this.bookDescription);
    }

    public void setCoverView(Bitmap bitmap) {
        this.coverImageView.setImageBitmap(bitmap);
    }

    public void setTitleView(String title) {
        this.titleTextView.setText(title);
    }

    public void setAuthorView(String author) {
        this.authorTextView.setText(author);
    }

    public void setAuthorViewVisibility(boolean visible) {
        this.authorView.setVisibility(visible ? 0 : 8);
    }

    public void setLanguageView(String language) {
        this.languageTextView.setText(language);
    }

    public void setLanguageViewVisibility(boolean visible) {
        this.languageView.setVisibility(visible ? 0 : 8);
    }

    public void setFilePathView(String filePath) {
        this.filePathTextView.setText(filePath);
    }

    @OnClick({2131296723})
    public void onStartReadingClick() {
        int timerModeParam = getActivity().getIntent().getIntExtra(ReaderActivity.TIMER_MODE_PARAM, 0);
        Intent intent = new Intent(getContext(), ReaderActivity.class);
        intent.putExtra(ReaderActivity.BOOK_DESCRIPTION_ID_PARAM, this.bookDescription.getId());
        intent.putExtra(ReaderActivity.TIMER_MODE_PARAM, timerModeParam);
        if (timerModeParam == 0) {
            startActivity(intent);
        } else {
            startActivityForResult(intent, TrainingActivity.COURSE_REQUEST_CODE);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TrainingActivity.COURSE_REQUEST_CODE /*1998*/:
                if (resultCode == -1) {
                    getActivity().setResult(-1);
                    getActivity().finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }
}
