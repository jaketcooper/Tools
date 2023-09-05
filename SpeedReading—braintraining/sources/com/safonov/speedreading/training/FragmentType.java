package com.safonov.speedreading.training;

public enum FragmentType {
    PREPARE,
    INTERSTITIAL,
    PASS_COURSE_DESCRIPTION,
    PASS_COURSE_RESULT,
    ACCELERATOR_COURSE_RESULT,
    WORDS_COLUMNS,
    WORDS_COLUMNS_HELP,
    WORDS_COLUMNS_DESCRIPTION,
    WORDS_COLUMNS_SETTINGS,
    WORDS_COLUMNS_RESULT,
    WORDS_BLOCK,
    WORDS_BLOCK_HELP,
    WORDS_BLOCK_DESCRIPTION,
    WORDS_BLOCK_SETTINGS,
    WORDS_BLOCK_RESULT,
    FLASH_WORDS_TRAINING,
    FLASH_WORDS_HELP,
    FLASH_WORDS_DESCRIPTION,
    FLASH_WORDS_SETTINGS,
    FLASH_WORDS_RESULT,
    SCHULTE_TABLE,
    SCHULTE_TABLE_HELP,
    SCHULTE_TABLE_DESCRIPTION,
    SCHULTE_TABLE_SETTINGS,
    SCHULTE_TABLE_RESULT,
    REMEMBER_NUMBER,
    REMEMBER_NUMBER_HELP,
    REMEMBER_NUMBER_DESCRIPTION,
    REMEMBER_NUMBER_RESULT,
    LINE_OF_SIGHT,
    LINE_OF_SIGHT_DESCRIPTION,
    LINE_OF_SIGHT_HELP,
    LINE_OF_SIGHT_SETTINGS,
    LINE_OF_SIGHT_RESULT,
    SPEED_READING,
    SPEED_READING_DESCRIPTION,
    SPEED_READING_HELP,
    SPEED_READING_RESULT,
    WORD_PAIRS,
    WORD_PAIRS_HELP,
    WORD_PAIRS_DESCRIPTION,
    WORD_PAIRS_RESULT,
    EVEN_NUMBERS,
    EVEN_NUMBERS_HELP,
    EVEN_NUMBERS_DESCRIPTION,
    EVEN_NUMBERS_RESULT,
    GREEN_DOT,
    GREEN_DOT_HELP,
    GREEN_DOT_DESCRIPTION,
    GREEN_DOT_SETTINGS,
    GREEN_DOT_RESULT,
    MATHEMATICS,
    MATHEMATICS_HELP,
    MATHEMATICS_DESCRIPTION,
    MATHEMATICS_RESULT,
    MATHEMATICS_COMPLEXITY,
    MATHEMATICS_SETTINGS,
    CONCENTRATION,
    CONCENTRATION_HELP,
    CONCENTRATION_DESCRIPTION,
    CONCENTRATION_RESULT,
    CONCENTRATION_COMPLEXITY,
    CUPTIMER,
    CUPTIMER_HELP,
    CUPTIMER_DESCRIPTION,
    CUPTIMER_SETTINGS,
    CUPTIMER_RESULT,
    REMEMBER_WORDS,
    REMEMBER_WORDS_HELP,
    REMEMBER_WORDS_DESCRIPTION,
    REMEMBER_WORDS_RESULT,
    TRUE_COLORS,
    TRUE_COLORS_HELP,
    TRUE_COLORS_DESCRIPTION,
    TRUE_COLORS_RESULT;

    public static boolean isHelpFragmentType(FragmentType fragmentType) {
        if (fragmentType == WORDS_COLUMNS_HELP || fragmentType == WORDS_BLOCK_HELP || fragmentType == FLASH_WORDS_HELP || fragmentType == SCHULTE_TABLE_HELP || fragmentType == REMEMBER_NUMBER_HELP || fragmentType == LINE_OF_SIGHT_HELP || fragmentType == SPEED_READING_HELP || fragmentType == WORD_PAIRS_HELP || fragmentType == EVEN_NUMBERS_HELP || fragmentType == GREEN_DOT_HELP || fragmentType == MATHEMATICS_HELP || fragmentType == CONCENTRATION_HELP || fragmentType == CUPTIMER_HELP || fragmentType == REMEMBER_WORDS_HELP || fragmentType == TRUE_COLORS_HELP) {
            return true;
        }
        return false;
    }

    public static boolean isSettingsFragmentType(FragmentType fragmentType) {
        if (fragmentType == WORDS_COLUMNS_SETTINGS || fragmentType == WORDS_BLOCK_SETTINGS || fragmentType == FLASH_WORDS_SETTINGS || fragmentType == SCHULTE_TABLE_SETTINGS || fragmentType == LINE_OF_SIGHT_SETTINGS || fragmentType == GREEN_DOT_SETTINGS || fragmentType == MATHEMATICS_SETTINGS || fragmentType == CUPTIMER_SETTINGS) {
            return true;
        }
        return false;
    }

    public static boolean isDescriptionFragmentType(FragmentType fragmentType) {
        if (fragmentType == WORDS_COLUMNS_DESCRIPTION || fragmentType == WORDS_BLOCK_DESCRIPTION || fragmentType == FLASH_WORDS_DESCRIPTION || fragmentType == SCHULTE_TABLE_DESCRIPTION || fragmentType == REMEMBER_NUMBER_DESCRIPTION || fragmentType == LINE_OF_SIGHT_DESCRIPTION || fragmentType == SPEED_READING_DESCRIPTION || fragmentType == WORD_PAIRS_DESCRIPTION || fragmentType == EVEN_NUMBERS_DESCRIPTION || fragmentType == GREEN_DOT_DESCRIPTION || fragmentType == MATHEMATICS_DESCRIPTION || fragmentType == CONCENTRATION_DESCRIPTION || fragmentType == CUPTIMER_DESCRIPTION || fragmentType == REMEMBER_WORDS_DESCRIPTION || fragmentType == TRUE_COLORS_DESCRIPTION) {
            return true;
        }
        return false;
    }

    public static boolean isResultFragment(FragmentType fragmentType) {
        if (fragmentType == PASS_COURSE_RESULT || fragmentType == ACCELERATOR_COURSE_RESULT || fragmentType == WORDS_COLUMNS_RESULT || fragmentType == WORDS_BLOCK_RESULT || fragmentType == FLASH_WORDS_RESULT || fragmentType == SCHULTE_TABLE_RESULT || fragmentType == REMEMBER_NUMBER_RESULT || fragmentType == LINE_OF_SIGHT_RESULT || fragmentType == SPEED_READING_RESULT || fragmentType == WORD_PAIRS_RESULT || fragmentType == EVEN_NUMBERS_RESULT || fragmentType == GREEN_DOT_RESULT || fragmentType == MATHEMATICS_RESULT || fragmentType == CONCENTRATION_RESULT || fragmentType == CUPTIMER_RESULT || fragmentType == REMEMBER_WORDS_RESULT || fragmentType == TRUE_COLORS_RESULT) {
            return true;
        }
        return false;
    }

    public static boolean isTrainingFragmentType(FragmentType fragmentType) {
        if (fragmentType == WORDS_COLUMNS || fragmentType == WORDS_BLOCK || fragmentType == FLASH_WORDS_TRAINING || fragmentType == SCHULTE_TABLE || fragmentType == REMEMBER_NUMBER || fragmentType == LINE_OF_SIGHT || fragmentType == SPEED_READING || fragmentType == WORD_PAIRS || fragmentType == EVEN_NUMBERS || fragmentType == GREEN_DOT || fragmentType == MATHEMATICS || fragmentType == CONCENTRATION || fragmentType == CUPTIMER || fragmentType == REMEMBER_WORDS || fragmentType == TRUE_COLORS) {
            return true;
        }
        return false;
    }

    public static boolean isComplexityFragmentType(FragmentType fragmentType) {
        if (fragmentType == MATHEMATICS_COMPLEXITY || fragmentType == CONCENTRATION_COMPLEXITY) {
            return true;
        }
        return false;
    }
}
