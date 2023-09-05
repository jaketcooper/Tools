package com.safonov.speedreading.training;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.speedreading.alexander.speedreading.R;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum TrainingType {
    PASS_COURSE(R.string.pass_course, false),
    ACCELERATOR_COURSE(R.string.accelerator, false),
    WORDS_COLUMNS(R.string.words_columns, true),
    WORDS_BLOCK(R.string.words_block, true),
    FLASH_WORDS(R.string.flash_words, true),
    SCHULTE_TABLE(R.string.schulte_table, true),
    REMEMBER_NUMBER(R.string.remember_number, false),
    LINE_OF_SIGHT(R.string.line_of_sight, true),
    SPEED_READING(R.string.speed_reading, false),
    WORD_PAIRS(R.string.word_pairs, false),
    EVEN_NUMBERS(R.string.even_numbers, false),
    GREEN_DOT(R.string.green_dot, true),
    MATHEMATICS(R.string.mathematics, true),
    CONCENTRATION(R.string.concentration, false),
    CUPTIMER(R.string.cuptimer, true),
    REMEMBER_WORDS(R.string.remember_words, false),
    TRUE_COLORS(R.string.true_colors, false);
    
    private static final Random RANDOM = null;
    private static final int SIZE = 0;
    private static final List<TrainingType> VALUES = null;
    private final boolean isSettingsSupported;
    @StringRes
    private final int titleRes;

    static {
        VALUES = Collections.unmodifiableList(Arrays.asList(values()));
        SIZE = VALUES.size();
        RANDOM = new Random();
    }

    private TrainingType(@StringRes int titleRes2, boolean isSettingsSupported2) {
        this.titleRes = titleRes2;
        this.isSettingsSupported = isSettingsSupported2;
    }

    @StringRes
    public int getTitleRes() {
        return this.titleRes;
    }

    public boolean isSettingsSupported() {
        return this.isSettingsSupported;
    }

    public static boolean isCourseTraining(@NonNull TrainingType trainingType) {
        if (PASS_COURSE == trainingType || ACCELERATOR_COURSE == trainingType) {
            return true;
        }
        return false;
    }

    public static TrainingType randomTraining() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static FragmentType getReferenceHelpFragmentType(TrainingType trainingType) {
        switch (trainingType) {
            case WORDS_COLUMNS:
                return FragmentType.WORDS_COLUMNS_HELP;
            case WORDS_BLOCK:
                return FragmentType.WORDS_BLOCK_HELP;
            case FLASH_WORDS:
                return FragmentType.FLASH_WORDS_HELP;
            case SCHULTE_TABLE:
                return FragmentType.SCHULTE_TABLE_HELP;
            case REMEMBER_NUMBER:
                return FragmentType.REMEMBER_NUMBER_HELP;
            case LINE_OF_SIGHT:
                return FragmentType.LINE_OF_SIGHT_HELP;
            case SPEED_READING:
                return FragmentType.SPEED_READING_HELP;
            case WORD_PAIRS:
                return FragmentType.WORD_PAIRS_HELP;
            case EVEN_NUMBERS:
                return FragmentType.EVEN_NUMBERS_HELP;
            case GREEN_DOT:
                return FragmentType.GREEN_DOT_HELP;
            case MATHEMATICS:
                return FragmentType.MATHEMATICS_HELP;
            case CONCENTRATION:
                return FragmentType.CONCENTRATION_HELP;
            case CUPTIMER:
                return FragmentType.CUPTIMER_HELP;
            case REMEMBER_WORDS:
                return FragmentType.REMEMBER_WORDS_HELP;
            case TRUE_COLORS:
                return FragmentType.TRUE_COLORS_HELP;
            default:
                throw new IllegalArgumentException("Unsupported training type");
        }
    }

    public static FragmentType getReferenceDescriptionFragmentType(TrainingType trainingType) {
        switch (trainingType) {
            case WORDS_COLUMNS:
                return FragmentType.WORDS_COLUMNS_DESCRIPTION;
            case WORDS_BLOCK:
                return FragmentType.WORDS_BLOCK_DESCRIPTION;
            case FLASH_WORDS:
                return FragmentType.FLASH_WORDS_DESCRIPTION;
            case SCHULTE_TABLE:
                return FragmentType.SCHULTE_TABLE_DESCRIPTION;
            case REMEMBER_NUMBER:
                return FragmentType.REMEMBER_NUMBER_DESCRIPTION;
            case LINE_OF_SIGHT:
                return FragmentType.LINE_OF_SIGHT_DESCRIPTION;
            case SPEED_READING:
                return FragmentType.SPEED_READING_DESCRIPTION;
            case WORD_PAIRS:
                return FragmentType.WORD_PAIRS_DESCRIPTION;
            case EVEN_NUMBERS:
                return FragmentType.EVEN_NUMBERS_DESCRIPTION;
            case GREEN_DOT:
                return FragmentType.GREEN_DOT_DESCRIPTION;
            case MATHEMATICS:
                return FragmentType.MATHEMATICS_DESCRIPTION;
            case CONCENTRATION:
                return FragmentType.CONCENTRATION_DESCRIPTION;
            case CUPTIMER:
                return FragmentType.CUPTIMER_DESCRIPTION;
            case REMEMBER_WORDS:
                return FragmentType.REMEMBER_WORDS_DESCRIPTION;
            case TRUE_COLORS:
                return FragmentType.TRUE_COLORS_DESCRIPTION;
            default:
                throw new IllegalArgumentException("Unsupported training type");
        }
    }

    public static FragmentType getReferenceSettingsFragmentType(TrainingType trainingType) {
        switch (trainingType) {
            case WORDS_COLUMNS:
                return FragmentType.WORDS_COLUMNS_SETTINGS;
            case WORDS_BLOCK:
                return FragmentType.WORDS_BLOCK_SETTINGS;
            case FLASH_WORDS:
                return FragmentType.FLASH_WORDS_SETTINGS;
            case SCHULTE_TABLE:
                return FragmentType.SCHULTE_TABLE_SETTINGS;
            case LINE_OF_SIGHT:
                return FragmentType.LINE_OF_SIGHT_SETTINGS;
            case GREEN_DOT:
                return FragmentType.GREEN_DOT_SETTINGS;
            case MATHEMATICS:
                return FragmentType.MATHEMATICS_SETTINGS;
            case CUPTIMER:
                return FragmentType.CUPTIMER_SETTINGS;
            default:
                throw new IllegalArgumentException("Unsupported training type");
        }
    }

    public static FragmentType getReferenceTrainingFragmentType(TrainingType trainingType) {
        switch (trainingType) {
            case WORDS_COLUMNS:
                return FragmentType.WORDS_COLUMNS;
            case WORDS_BLOCK:
                return FragmentType.WORDS_BLOCK;
            case FLASH_WORDS:
                return FragmentType.FLASH_WORDS_TRAINING;
            case SCHULTE_TABLE:
                return FragmentType.SCHULTE_TABLE;
            case REMEMBER_NUMBER:
                return FragmentType.REMEMBER_NUMBER;
            case LINE_OF_SIGHT:
                return FragmentType.LINE_OF_SIGHT;
            case SPEED_READING:
                return FragmentType.SPEED_READING;
            case WORD_PAIRS:
                return FragmentType.WORD_PAIRS;
            case EVEN_NUMBERS:
                return FragmentType.EVEN_NUMBERS;
            case GREEN_DOT:
                return FragmentType.GREEN_DOT;
            case MATHEMATICS:
                return FragmentType.MATHEMATICS;
            case CONCENTRATION:
                return FragmentType.CONCENTRATION;
            case CUPTIMER:
                return FragmentType.CUPTIMER;
            case REMEMBER_WORDS:
                return FragmentType.REMEMBER_WORDS;
            case TRUE_COLORS:
                return FragmentType.TRUE_COLORS;
            default:
                throw new IllegalArgumentException("Unsupported training type");
        }
    }

    public static FragmentType getReferenceResultFragmentType(TrainingType trainingType) {
        switch (trainingType) {
            case WORDS_COLUMNS:
                return FragmentType.WORDS_COLUMNS_RESULT;
            case WORDS_BLOCK:
                return FragmentType.WORDS_BLOCK_RESULT;
            case FLASH_WORDS:
                return FragmentType.FLASH_WORDS_RESULT;
            case SCHULTE_TABLE:
                return FragmentType.SCHULTE_TABLE_RESULT;
            case REMEMBER_NUMBER:
                return FragmentType.REMEMBER_NUMBER_RESULT;
            case LINE_OF_SIGHT:
                return FragmentType.LINE_OF_SIGHT_RESULT;
            case SPEED_READING:
                return FragmentType.SPEED_READING_RESULT;
            case WORD_PAIRS:
                return FragmentType.WORD_PAIRS_RESULT;
            case EVEN_NUMBERS:
                return FragmentType.EVEN_NUMBERS_RESULT;
            case GREEN_DOT:
                return FragmentType.GREEN_DOT_RESULT;
            case MATHEMATICS:
                return FragmentType.MATHEMATICS_RESULT;
            case CONCENTRATION:
                return FragmentType.CONCENTRATION_RESULT;
            case CUPTIMER:
                return FragmentType.CUPTIMER_RESULT;
            case REMEMBER_WORDS:
                return FragmentType.REMEMBER_WORDS_RESULT;
            case TRUE_COLORS:
                return FragmentType.TRUE_COLORS_RESULT;
            default:
                throw new IllegalArgumentException("Unsupported training type");
        }
    }

    public static FragmentType getReferenceComplexityFragmentType(TrainingType trainingType) {
        switch (trainingType) {
            case MATHEMATICS:
                return FragmentType.MATHEMATICS_COMPLEXITY;
            case CONCENTRATION:
                return FragmentType.CONCENTRATION_COMPLEXITY;
            default:
                throw new IllegalArgumentException("Unsupported training type");
        }
    }
}
