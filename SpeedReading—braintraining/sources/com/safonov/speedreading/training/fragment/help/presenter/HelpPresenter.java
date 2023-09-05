package com.safonov.speedreading.training.fragment.help.presenter;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.fragment.help.view.IHelpView;
import com.speedreading.alexander.speedreading.R;

public class HelpPresenter extends MvpBasePresenter<IHelpView> implements IHelpPresenter {
    public void requestToLoadContent(FragmentType helpFragmentType) {
        if (isViewAttached()) {
            switch (helpFragmentType) {
                case WORDS_COLUMNS_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.acceleraotor_course_description_content);
                    return;
                case WORDS_BLOCK_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.acceleraotor_course_description_content);
                    return;
                case SCHULTE_TABLE_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.schulte_table_description_content);
                    return;
                case REMEMBER_NUMBER_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.remember_number_description_content);
                    return;
                case LINE_OF_SIGHT_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.line_of_sight_description_content);
                    return;
                case SPEED_READING_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.speed_reading_description_content);
                    return;
                case WORD_PAIRS_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.word_pairs_description_content);
                    return;
                case EVEN_NUMBERS_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.even_number_description_content);
                    return;
                case GREEN_DOT_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.green_dot_description_content);
                    return;
                case MATHEMATICS_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.math_description_content);
                    return;
                case CONCENTRATION_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.concentration_description_content);
                    return;
                case CUPTIMER_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.cuptimer_description_content);
                    return;
                case REMEMBER_WORDS_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.remember_words_description_content);
                    return;
                case TRUE_COLORS_HELP:
                    ((IHelpView) getView()).setContentLayout(R.layout.true_colors_description_content);
                    return;
                default:
                    return;
            }
        }
    }
}
