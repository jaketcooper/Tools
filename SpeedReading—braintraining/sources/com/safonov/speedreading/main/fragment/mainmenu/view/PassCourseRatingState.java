package com.safonov.speedreading.main.fragment.mainmenu.view;

import android.support.annotation.StringRes;
import com.speedreading.alexander.speedreading.R;

public enum PassCourseRatingState {
    BEGINNER(R.string.pass_course_rating_beginner, 0),
    LEARNER(R.string.pass_course_rating_learner, 35),
    EXPERT(R.string.pass_course_rating_expert, 50),
    MASTER(R.string.pass_course_rating_master, 70),
    GURU(R.string.pass_course_rating_guru, 80),
    PROFESSOR(R.string.pass_course_rating_professor, 90),
    GENIUS(R.string.pass_course_rating_genius, 100);
    
    private final int progress;
    @StringRes
    private final int titleRes;

    private PassCourseRatingState(@StringRes int titleRes2, int progress2) {
        this.titleRes = titleRes2;
        this.progress = progress2;
    }

    @StringRes
    public int getTitleRes() {
        return this.titleRes;
    }

    public int getCompletedPart() {
        return this.progress;
    }

    public int getUncompletedPart() {
        return 100 - this.progress;
    }
}
