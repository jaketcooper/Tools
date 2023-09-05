package com.safonov.speedreading.reader.library.detail.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class BookDetailFragment_ViewBinding implements Unbinder {
    private BookDetailFragment target;
    private View view2131296723;

    @UiThread
    public BookDetailFragment_ViewBinding(final BookDetailFragment target2, View source) {
        this.target = target2;
        target2.coverImageView = (ImageView) Utils.findRequiredViewAsType(source, R.id.book_cover_image_view, "field 'coverImageView'", ImageView.class);
        target2.titleTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.title_text_view, "field 'titleTextView'", TextView.class);
        target2.authorView = Utils.findRequiredView(source, R.id.author_view, "field 'authorView'");
        target2.authorTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.author_text_view, "field 'authorTextView'", TextView.class);
        target2.languageView = Utils.findRequiredView(source, R.id.language_view, "field 'languageView'");
        target2.languageTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.language_text_view, "field 'languageTextView'", TextView.class);
        target2.filePathTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.file_path_text_view, "field 'filePathTextView'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.start_reading_button, "method 'onStartReadingClick'");
        this.view2131296723 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartReadingClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        BookDetailFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.coverImageView = null;
        target2.titleTextView = null;
        target2.authorView = null;
        target2.authorTextView = null;
        target2.languageView = null;
        target2.languageTextView = null;
        target2.filePathTextView = null;
        this.view2131296723.setOnClickListener((View.OnClickListener) null);
        this.view2131296723 = null;
    }
}
