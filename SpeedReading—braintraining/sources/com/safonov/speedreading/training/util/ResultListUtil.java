package com.safonov.speedreading.training.util;

import java.util.List;

public class ResultListUtil {
    private static final int RESULT_COUNT = 25;

    public static <T> List<T> getLastPartOfList(List<T> list) {
        if (list.size() > 25) {
            return list.subList(list.size() - 25, list.size());
        }
        return list;
    }
}
