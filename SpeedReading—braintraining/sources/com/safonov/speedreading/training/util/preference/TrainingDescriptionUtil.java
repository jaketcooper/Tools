package com.safonov.speedreading.training.util.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import com.safonov.speedreading.training.FragmentType;

public class TrainingDescriptionUtil {
    private static final String ACCELERATOR_SHOW_HELP_KEY = "accelerator_show_help";
    private static final String CONCENTRATION_SHOW_HELP_KEY = "concentration_show_help";
    private static final String CUP_TIMER_SHOW_HELP_KEY = "cup_timer_show_help";
    private static final String EVEN_NUMBERS_SHOW_HELP_KEY = "even_numbers_show_help";
    private static final String GREEN_DOT_SHOW_HELP_KEY = "green_dot_show_help";
    private static final String LINE_OF_SIGHT_SHOW_HELP_KEY = "line_of_sight_show_help";
    private static final String MATHEMATICS_SHOW_HELP_KEY = "mathematics_show_help";
    private static final String PASS_COURSE_SHOW_HELP_KEY = "pass_course_show_help";
    private static final String REMEMBER_NUMBER_SHOW_HELP_KEY = "remember_number_show_help";
    public static final String REMEMBER_WORDS_HELP_KEY = "remember_words_show_help";
    private static final String SCHULTE_TABLE_SHOW_HELP_KEY = "schulte_table_show_help";
    private static final String SPEED_READING_SHOW_HELP_KEY = "speed_reading_show_help";
    public static final String TRUE_COLORS_HELP_KEY = "true_colors_show_help";
    private static final String WORD_BLOCK_SHOW_HELP_KEY = "word_block_show_help";
    private static final String WORD_PAIRS_SHOW_HELP_KEY = "word_pairs_show_help";
    private SharedPreferences sharedPreferences;

    public TrainingDescriptionUtil(@NonNull Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean shouldShowDescriptionFragment(FragmentType descriptionFragmentType) {
        switch (descriptionFragmentType) {
            case PASS_COURSE_DESCRIPTION:
                return this.sharedPreferences.getBoolean(PASS_COURSE_SHOW_HELP_KEY, true);
            case WORDS_COLUMNS_DESCRIPTION:
                return this.sharedPreferences.getBoolean(ACCELERATOR_SHOW_HELP_KEY, true);
            case WORDS_BLOCK_DESCRIPTION:
                return this.sharedPreferences.getBoolean(WORD_BLOCK_SHOW_HELP_KEY, true);
            case FLASH_WORDS_DESCRIPTION:
                return this.sharedPreferences.getBoolean(ACCELERATOR_SHOW_HELP_KEY, true);
            case SCHULTE_TABLE_DESCRIPTION:
                return this.sharedPreferences.getBoolean(SCHULTE_TABLE_SHOW_HELP_KEY, true);
            case REMEMBER_NUMBER_DESCRIPTION:
                return this.sharedPreferences.getBoolean(REMEMBER_NUMBER_SHOW_HELP_KEY, true);
            case LINE_OF_SIGHT_DESCRIPTION:
                return this.sharedPreferences.getBoolean(LINE_OF_SIGHT_SHOW_HELP_KEY, true);
            case SPEED_READING_DESCRIPTION:
                return this.sharedPreferences.getBoolean(SPEED_READING_SHOW_HELP_KEY, true);
            case WORD_PAIRS_DESCRIPTION:
                return this.sharedPreferences.getBoolean(WORD_PAIRS_SHOW_HELP_KEY, true);
            case EVEN_NUMBERS_DESCRIPTION:
                return this.sharedPreferences.getBoolean(EVEN_NUMBERS_SHOW_HELP_KEY, true);
            case GREEN_DOT_DESCRIPTION:
                return this.sharedPreferences.getBoolean(GREEN_DOT_SHOW_HELP_KEY, true);
            case MATHEMATICS_DESCRIPTION:
                return this.sharedPreferences.getBoolean(MATHEMATICS_SHOW_HELP_KEY, true);
            case CONCENTRATION_DESCRIPTION:
                return this.sharedPreferences.getBoolean(CONCENTRATION_SHOW_HELP_KEY, true);
            case CUPTIMER_DESCRIPTION:
                return this.sharedPreferences.getBoolean(CUP_TIMER_SHOW_HELP_KEY, true);
            case REMEMBER_WORDS_DESCRIPTION:
                return this.sharedPreferences.getBoolean(REMEMBER_WORDS_HELP_KEY, true);
            case TRUE_COLORS_DESCRIPTION:
                return this.sharedPreferences.getBoolean(TRUE_COLORS_HELP_KEY, true);
            default:
                throw new IllegalArgumentException("Unsupported fragment type");
        }
    }

    public void setShowDescriptionFragment(FragmentType descriptionFragmentType, boolean shouldShow) {
        switch (descriptionFragmentType) {
            case PASS_COURSE_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(PASS_COURSE_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case WORDS_COLUMNS_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(ACCELERATOR_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case WORDS_BLOCK_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(WORD_BLOCK_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case FLASH_WORDS_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(ACCELERATOR_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case SCHULTE_TABLE_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(SCHULTE_TABLE_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case REMEMBER_NUMBER_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(REMEMBER_NUMBER_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case LINE_OF_SIGHT_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(LINE_OF_SIGHT_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case SPEED_READING_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(SPEED_READING_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case WORD_PAIRS_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(WORD_PAIRS_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case EVEN_NUMBERS_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(EVEN_NUMBERS_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case GREEN_DOT_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(GREEN_DOT_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case MATHEMATICS_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(MATHEMATICS_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case CONCENTRATION_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(CONCENTRATION_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case CUPTIMER_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(CUP_TIMER_SHOW_HELP_KEY, shouldShow).apply();
                return;
            case REMEMBER_WORDS_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(REMEMBER_WORDS_HELP_KEY, shouldShow).apply();
                return;
            case TRUE_COLORS_DESCRIPTION:
                this.sharedPreferences.edit().putBoolean(TRUE_COLORS_HELP_KEY, shouldShow).apply();
                return;
            default:
                throw new IllegalArgumentException("Unsupported fragment type");
        }
    }
}
