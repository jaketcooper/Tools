package com.safonov.speedreading.main.fragment.mainmenu.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class MainMenuFragment_ViewBinding implements Unbinder {
    private MainMenuFragment target;
    private View view2131296487;
    private View view2131296489;
    private View view2131296604;
    private View view2131296692;

    @UiThread
    public MainMenuFragment_ViewBinding(final MainMenuFragment target2, View source) {
        this.target = target2;
        target2.recomendationTitleView = (TextView) Utils.findRequiredViewAsType(source, R.id.recommendation_title_view, "field 'recomendationTitleView'", TextView.class);
        target2.recomendationDescriptionView = (TextView) Utils.findRequiredViewAsType(source, R.id.recommendation_description_view, "field 'recomendationDescriptionView'", TextView.class);
        target2.speedReadingBookStartTV = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_book_start_tv, "field 'speedReadingBookStartTV'", TextView.class);
        target2.speedReadingBookNotTV = (TextView) Utils.findRequiredViewAsType(source, R.id.speed_reading_book_not_available, "field 'speedReadingBookNotTV'", TextView.class);
        target2.profileTitleTV = (TextView) Utils.findRequiredViewAsType(source, R.id.profileTitleTV, "field 'profileTitleTV'", TextView.class);
        target2.scoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.score_text_view, "field 'scoreTextView'", TextView.class);
        target2.pointsLeftTV = (TextView) Utils.findRequiredViewAsType(source, R.id.pointsLeftTV, "field 'pointsLeftTV'", TextView.class);
        target2.focusAttentionPB = (ProgressBar) Utils.findRequiredViewAsType(source, R.id.focus_attention_progress, "field 'focusAttentionPB'", ProgressBar.class);
        View view = Utils.findRequiredView(source, R.id.recommendation_link_view, "method 'onRecomendationClick'");
        this.view2131296604 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onRecomendationClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.speed_reading_book, "method 'onspeedReadingBookClick2' and method 'speedReadingBookClick'");
        this.view2131296692 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onspeedReadingBookClick2();
                target2.speedReadingBookClick();
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.main_menu_base_course_view, "method 'onStartPassCourseClick'");
        this.view2131296487 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartPassCourseClick();
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.main_menu_random_trainer_view, "method 'onRandomTrainerClick'");
        this.view2131296489 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onRandomTrainerClick();
            }
        });
        target2.colorAccent = ContextCompat.getColor(source.getContext(), R.color.colorAccent);
    }

    @CallSuper
    public void unbind() {
        MainMenuFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.recomendationTitleView = null;
        target2.recomendationDescriptionView = null;
        target2.speedReadingBookStartTV = null;
        target2.speedReadingBookNotTV = null;
        target2.profileTitleTV = null;
        target2.scoreTextView = null;
        target2.pointsLeftTV = null;
        target2.focusAttentionPB = null;
        this.view2131296604.setOnClickListener((View.OnClickListener) null);
        this.view2131296604 = null;
        this.view2131296692.setOnClickListener((View.OnClickListener) null);
        this.view2131296692 = null;
        this.view2131296487.setOnClickListener((View.OnClickListener) null);
        this.view2131296487 = null;
        this.view2131296489.setOnClickListener((View.OnClickListener) null);
        this.view2131296489 = null;
    }
}
