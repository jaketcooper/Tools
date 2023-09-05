package com.safonov.speedreading.training.fragment.greendot.util;

public class GreenDotTimeConverterUtil {
    public String format(long duration) {
        return String.valueOf((duration / 1000) / 60);
    }
}
