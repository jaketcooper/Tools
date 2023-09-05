package com.safonov.speedreading.application.util.timeticker;

import java.util.Locale;

public class TimeTickerConverterUtil {
    private static final String format = "%.1f";

    public static String formatToMinutes(long trainingDuration) {
        return String.format(Locale.getDefault(), format, new Object[]{Float.valueOf((((float) trainingDuration) / 1000.0f) / 60.0f)});
    }

    public static String formatToSeconds(long trainingDuration) {
        return String.format(Locale.getDefault(), format, new Object[]{Float.valueOf(((float) trainingDuration) / 1000.0f)});
    }
}
