package com.safonov.speedreading.training.activity;

import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;

public class LineOfSightConfigUtil {
    private static final int DEFAULT_COLUMN_COUNT = 9;
    private static final int DEFAULT_MISTAKE_PROBABILITY = 35;
    private static final int DEFAULT_ROW_COUNT = 5;
    private static final int DEFAULT_SHOW_COUNT = 40;
    private static final int DEFAULT_SHOW_DELAY = 1000;
    private static final int PASS_COURSE_TYPE_1_FILED_TYPE = 0;
    private static final int PASS_COURSE_TYPE_2_FILED_TYPE = 1;
    private static final int PASS_COURSE_TYPE_3_COLUMN_COUNT = 9;
    private static final int PASS_COURSE_TYPE_3_FILED_TYPE = 1;
    private static final int PASS_COURSE_TYPE_3_ROW_COUNT = 9;

    public static LineOfSightConfig getUserConfig(int rowColumn, int fieldType) {
        LineOfSightConfig config = new LineOfSightConfig();
        config.setRowCount(rowColumn);
        config.setColumnCount(9);
        config.setShowCount(40);
        config.setShowDelay(1000);
        config.setMistakeProbability(35);
        config.setFieldType(fieldType);
        return config;
    }

    public static LineOfSightConfig getPassCourseType1Config() {
        LineOfSightConfig config = new LineOfSightConfig();
        config.setRowCount(5);
        config.setColumnCount(9);
        config.setShowCount(40);
        config.setShowDelay(1000);
        config.setMistakeProbability(35);
        config.setFieldType(0);
        return config;
    }

    public static LineOfSightConfig getPassCourseType2Config() {
        LineOfSightConfig config = new LineOfSightConfig();
        config.setRowCount(5);
        config.setColumnCount(9);
        config.setShowCount(40);
        config.setShowDelay(1000);
        config.setMistakeProbability(35);
        config.setFieldType(1);
        return config;
    }

    public static LineOfSightConfig getPassCourseType3Config() {
        LineOfSightConfig config = new LineOfSightConfig();
        config.setRowCount(9);
        config.setColumnCount(9);
        config.setShowCount(40);
        config.setShowDelay(1000);
        config.setMistakeProbability(35);
        config.setFieldType(1);
        return config;
    }
}
