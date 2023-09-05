package com.safonov.speedreading.main.fragment.acceleratormenu;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class AcceleratorTrainingMenuFragment_ViewBinding implements Unbinder {
    private AcceleratorTrainingMenuFragment target;
    private View view2131296787;
    private View view2131296791;
    private View view2131296800;
    private View view2131296802;

    @UiThread
    public AcceleratorTrainingMenuFragment_ViewBinding(final AcceleratorTrainingMenuFragment target2, View source) {
        this.target = target2;
        View view = Utils.findRequiredView(source, R.id.training_menu_start_words_columns, "method 'onStartAcceleratorClick'");
        this.view2131296802 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartAcceleratorClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.training_menu_start_word_block, "method 'onStartWordBlockClick'");
        this.view2131296800 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartWordBlockClick();
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.training_menu_start_flash_words, "method 'onStartFlashWordClick'");
        this.view2131296791 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartFlashWordClick();
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.training_menu_start_accelerator_pass_course, "method 'onStartAcceleratorPassCourseClick'");
        this.view2131296787 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartAcceleratorPassCourseClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view2131296802.setOnClickListener((View.OnClickListener) null);
        this.view2131296802 = null;
        this.view2131296800.setOnClickListener((View.OnClickListener) null);
        this.view2131296800 = null;
        this.view2131296791.setOnClickListener((View.OnClickListener) null);
        this.view2131296791 = null;
        this.view2131296787.setOnClickListener((View.OnClickListener) null);
        this.view2131296787 = null;
    }
}
