package com.safonov.speedreading.reader.library.library.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class LibraryFragment_ViewBinding implements Unbinder {
    private LibraryFragment target;
    private View view2131296406;
    private View view2131296472;

    @UiThread
    public LibraryFragment_ViewBinding(final LibraryFragment target2, View source) {
        this.target = target2;
        target2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        target2.emptyView = (TextView) Utils.findRequiredViewAsType(source, R.id.empty_view, "field 'emptyView'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.library_speed_reading_book_view, "field 'speedReadingBookView' and method 'onSpeedReadingBookClick'");
        target2.speedReadingBookView = (ConstraintLayout) Utils.castView(view, R.id.library_speed_reading_book_view, "field 'speedReadingBookView'", ConstraintLayout.class);
        this.view2131296472 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onSpeedReadingBookClick();
            }
        });
        target2.speedReadingBookProgress = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.speed_reading_book_progress, "field 'speedReadingBookProgress'", ProgressBar.class);
        target2.speedReadingBookProgressTv = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_book_progress_tv, "field 'speedReadingBookProgressTv'", TextView.class);
        View view2 = Utils.findRequiredView(source, R.id.floating_button, "method 'onAddBookClick'");
        this.view2131296406 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAddBookClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        LibraryFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.recyclerView = null;
        target2.emptyView = null;
        target2.speedReadingBookView = null;
        target2.speedReadingBookProgress = null;
        target2.speedReadingBookProgressTv = null;
        this.view2131296472.setOnClickListener((View.OnClickListener) null);
        this.view2131296472 = null;
        this.view2131296406.setOnClickListener((View.OnClickListener) null);
        this.view2131296406 = null;
    }
}
