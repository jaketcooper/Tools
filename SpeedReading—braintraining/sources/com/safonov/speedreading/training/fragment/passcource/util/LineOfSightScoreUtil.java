package com.safonov.speedreading.training.fragment.passcource.util;

public class LineOfSightScoreUtil {
    public static int getPassCourseScore(int mistakeCount, int foundMistakeCount) {
        switch (Math.abs(mistakeCount - foundMistakeCount)) {
            case 0:
                return 60;
            case 1:
                return 48;
            case 2:
                return 42;
            case 3:
                return 30;
            case 4:
                return 18;
            case 5:
                return 12;
            case 6:
                return 6;
            case 7:
                return 5;
            case 8:
                return 3;
            case 9:
                return 1;
            default:
                return 0;
        }
    }
}
