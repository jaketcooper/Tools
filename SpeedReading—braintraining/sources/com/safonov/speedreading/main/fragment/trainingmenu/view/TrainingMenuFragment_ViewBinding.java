package com.safonov.speedreading.main.fragment.trainingmenu.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class TrainingMenuFragment_ViewBinding implements Unbinder {
    private TrainingMenuFragment target;
    private View view2131296785;
    private View view2131296786;
    private View view2131296788;
    private View view2131296789;
    private View view2131296790;
    private View view2131296792;
    private View view2131296793;
    private View view2131296794;
    private View view2131296795;
    private View view2131296796;
    private View view2131296797;
    private View view2131296798;
    private View view2131296799;
    private View view2131296801;

    @UiThread
    public TrainingMenuFragment_ViewBinding(final TrainingMenuFragment target2, View source) {
        this.target = target2;
        target2.startRememberWords = (TextView) Utils.findRequiredViewAsType(source, R.id.start_remember_words_button, "field 'startRememberWords'", TextView.class);
        target2.startTrueColors = (TextView) Utils.findRequiredViewAsType(source, R.id.start_true_colors_button, "field 'startTrueColors'", TextView.class);
        target2.startCup = (TextView) Utils.findRequiredViewAsType(source, R.id.start_cup_button, "field 'startCup'", TextView.class);
        View view = Utils.findRequiredView(source, R.id.training_menu_start_accelerator_menu, "method 'onAcceleratorMenuClick'");
        this.view2131296786 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onAcceleratorMenuClick();
            }
        });
        View view2 = Utils.findRequiredView(source, R.id.training_menu_start_schulte_table, "method 'onStartSchulteTableClick'");
        this.view2131296797 = view2;
        view2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartSchulteTableClick();
            }
        });
        View view3 = Utils.findRequiredView(source, R.id.training_menu_start_remember_number, "method 'onStartRememberNumberClick'");
        this.view2131296795 = view3;
        view3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartRememberNumberClick();
            }
        });
        View view4 = Utils.findRequiredView(source, R.id.training_menu_start_line_of_sight, "method 'onStartLineOfSightClick'");
        this.view2131296793 = view4;
        view4.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartLineOfSightClick();
            }
        });
        View view5 = Utils.findRequiredView(source, R.id.training_menu_start_speed_reading, "method 'onStartSpeedReadingClick'");
        this.view2131296798 = view5;
        view5.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartSpeedReadingClick();
            }
        });
        View view6 = Utils.findRequiredView(source, R.id.training_menu_start_word_pairs, "method 'onStartWordPairsClick'");
        this.view2131296801 = view6;
        view6.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartWordPairsClick();
            }
        });
        View view7 = Utils.findRequiredView(source, R.id.training_menu_start_even_numbers, "method 'onStartEvenNumbersClick'");
        this.view2131296790 = view7;
        view7.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartEvenNumbersClick();
            }
        });
        View view8 = Utils.findRequiredView(source, R.id.training_menu_start_green_dot, "method 'onStartGreenDotClick'");
        this.view2131296792 = view8;
        view8.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartGreenDotClick();
            }
        });
        View view9 = Utils.findRequiredView(source, R.id.training_menu_start_mathematics, "method 'onStrartMathClick'");
        this.view2131296794 = view9;
        view9.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStrartMathClick();
            }
        });
        View view10 = Utils.findRequiredView(source, R.id.training_menu_start_concentration, "method 'onStartConcentrationClick'");
        this.view2131296788 = view10;
        view10.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartConcentrationClick();
            }
        });
        View view11 = Utils.findRequiredView(source, R.id.training_menu_start_cup_timer, "method 'onStartCupTimerClick'");
        this.view2131296789 = view11;
        view11.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartCupTimerClick();
            }
        });
        View view12 = Utils.findRequiredView(source, R.id.training_menu_start_remember_words, "method 'onStartRememberWordsClick'");
        this.view2131296796 = view12;
        view12.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartRememberWordsClick();
            }
        });
        View view13 = Utils.findRequiredView(source, R.id.training_menu_base_course_view, "method 'onStartBaseCourse'");
        this.view2131296785 = view13;
        view13.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartBaseCourse();
            }
        });
        View view14 = Utils.findRequiredView(source, R.id.training_menu_start_true_colors, "method 'onStartTrueColorsClick'");
        this.view2131296799 = view14;
        view14.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View p0) {
                target2.onStartTrueColorsClick();
            }
        });
    }

    @CallSuper
    public void unbind() {
        TrainingMenuFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.startRememberWords = null;
        target2.startTrueColors = null;
        target2.startCup = null;
        this.view2131296786.setOnClickListener((View.OnClickListener) null);
        this.view2131296786 = null;
        this.view2131296797.setOnClickListener((View.OnClickListener) null);
        this.view2131296797 = null;
        this.view2131296795.setOnClickListener((View.OnClickListener) null);
        this.view2131296795 = null;
        this.view2131296793.setOnClickListener((View.OnClickListener) null);
        this.view2131296793 = null;
        this.view2131296798.setOnClickListener((View.OnClickListener) null);
        this.view2131296798 = null;
        this.view2131296801.setOnClickListener((View.OnClickListener) null);
        this.view2131296801 = null;
        this.view2131296790.setOnClickListener((View.OnClickListener) null);
        this.view2131296790 = null;
        this.view2131296792.setOnClickListener((View.OnClickListener) null);
        this.view2131296792 = null;
        this.view2131296794.setOnClickListener((View.OnClickListener) null);
        this.view2131296794 = null;
        this.view2131296788.setOnClickListener((View.OnClickListener) null);
        this.view2131296788 = null;
        this.view2131296789.setOnClickListener((View.OnClickListener) null);
        this.view2131296789 = null;
        this.view2131296796.setOnClickListener((View.OnClickListener) null);
        this.view2131296796 = null;
        this.view2131296785.setOnClickListener((View.OnClickListener) null);
        this.view2131296785 = null;
        this.view2131296799.setOnClickListener((View.OnClickListener) null);
        this.view2131296799 = null;
    }
}
