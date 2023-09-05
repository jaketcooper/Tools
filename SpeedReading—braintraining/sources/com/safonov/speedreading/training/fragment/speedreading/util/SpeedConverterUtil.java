package com.safonov.speedreading.training.fragment.speedreading.util;

public class SpeedConverterUtil {
    private static final int MINUTE = 60000;

    public static int getWordShowingTime(int wordsPerMinute) {
        return MINUTE / wordsPerMinute;
    }
}
