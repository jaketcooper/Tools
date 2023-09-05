package com.safonov.speedreading.training.fragment.passcource.util;

import com.safonov.speedreading.training.fragment.truecolors.training.presenter.TrueColorsPresenter;
import org.solovyev.android.checkout.ResponseCodes;

public class GreenDotScoreUtil {
    public static int getPassCourseScore(long duration) {
        switch ((int) duration) {
            case TrueColorsPresenter.DEFAULT_LEVEL_DURATION /*5000*/:
                return 10;
            case ResponseCodes.SERVICE_NOT_CONNECTED /*10000*/:
                return 20;
            case 15000:
                return 30;
            case 20000:
                return 40;
            case 30000:
                return 60;
            default:
                return 0;
        }
    }
}
