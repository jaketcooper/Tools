package com.safonov.speedreading.training.activity;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;

public class SchulteTableConfigUtil {
    private static final int PASS_COURSE_TYPE_1_COLUMN_COUNT = 5;
    private static final boolean PASS_COURSE_TYPE_1_FULLSCREEN = false;
    private static final int PASS_COURSE_TYPE_1_ROW_COUNT = 5;
    private static final int PASS_COURSE_TYPE_2_COLUMN_COUNT = 4;
    private static final boolean PASS_COURSE_TYPE_2_FULLSCREEN = true;
    private static final int PASS_COURSE_TYPE_2_ROW_COUNT = 6;

    @NonNull
    public static SchulteTableConfig getUserConfig(int rowCount, int columnCount, boolean fullscreen) {
        SchulteTableConfig config = new SchulteTableConfig();
        config.setRowCount(rowCount);
        config.setColumnCount(columnCount);
        config.setFullscreen(fullscreen);
        return config;
    }

    @NonNull
    public static SchulteTableConfig getPassCourseType1Config() {
        SchulteTableConfig config = new SchulteTableConfig();
        config.setRowCount(5);
        config.setColumnCount(5);
        config.setFullscreen(false);
        return config;
    }

    @NonNull
    public static SchulteTableConfig getPassCourseType2Config() {
        SchulteTableConfig config = new SchulteTableConfig();
        config.setRowCount(6);
        config.setColumnCount(4);
        config.setFullscreen(true);
        return config;
    }
}
