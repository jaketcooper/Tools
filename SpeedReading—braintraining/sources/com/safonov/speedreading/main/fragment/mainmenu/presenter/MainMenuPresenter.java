package com.safonov.speedreading.main.fragment.mainmenu.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.main.fragment.mainmenu.view.IMainMenuView;
import com.safonov.speedreading.main.fragment.mainmenu.view.PassCourseRatingState;
import com.safonov.speedreading.training.fragment.passcource.repository.IPassCourseRepository;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import java.util.List;

public class MainMenuPresenter extends MvpBasePresenter<IMainMenuView> implements IMainMenuPresenter {
    private static final int MAX_SCORE = 1000;
    private IPassCourseRepository passCourseRepository;

    public MainMenuPresenter(@NonNull IPassCourseRepository passCourseRepository2) {
        this.passCourseRepository = passCourseRepository2;
    }

    private PassCourseRatingState getRatingState(int score) {
        if (score >= 1000) {
            return PassCourseRatingState.GENIUS;
        }
        if (score >= 900) {
            return PassCourseRatingState.PROFESSOR;
        }
        if (score >= 750) {
            return PassCourseRatingState.GURU;
        }
        if (score >= 650) {
            return PassCourseRatingState.MASTER;
        }
        if (score >= 500) {
            return PassCourseRatingState.EXPERT;
        }
        if (score >= 350) {
            return PassCourseRatingState.LEARNER;
        }
        return PassCourseRatingState.BEGINNER;
    }

    private int getUncompletedPart(int score) {
        int uncompletedPart = 1000 - score;
        if (uncompletedPart < 0) {
            return 0;
        }
        return uncompletedPart;
    }

    public void init() {
        List<PassCourseResult> courseResultList = this.passCourseRepository.getResultList();
        if (courseResultList.size() != 0) {
            PassCourseResult bestResult = this.passCourseRepository.getBestResult();
            int score = courseResultList.get(courseResultList.size() - 1).getScore();
            int bestScore = bestResult.getScore();
            PassCourseRatingState bestRatingState = getRatingState(bestScore);
            int completedPart = bestScore;
            int uncompletedPart = getUncompletedPart(bestScore);
            if (isViewAttached()) {
                ((IMainMenuView) getView()).setPassCourseView(score, bestScore, bestRatingState, completedPart, uncompletedPart);
            }
        } else if (isViewAttached()) {
            ((IMainMenuView) getView()).setPassCourseView(0, 0, PassCourseRatingState.BEGINNER, 0, 1000);
        }
    }
}
