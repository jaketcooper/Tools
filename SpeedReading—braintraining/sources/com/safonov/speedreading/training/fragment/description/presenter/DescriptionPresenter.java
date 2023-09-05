package com.safonov.speedreading.training.fragment.description.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.fragment.description.view.IDescriptionView;
import com.safonov.speedreading.training.util.preference.TrainingDescriptionUtil;
import com.speedreading.alexander.speedreading.R;

public class DescriptionPresenter extends MvpBasePresenter<IDescriptionView> implements IDescriptionPresenter {
    private TrainingDescriptionUtil trainingDescriptionUtil;

    public DescriptionPresenter(@NonNull Context context) {
        this.trainingDescriptionUtil = new TrainingDescriptionUtil(context);
    }

    public void requestToLoadContent(FragmentType fragmentType) {
        if (isViewAttached()) {
            switch (fragmentType) {
                case FLASH_WORDS_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.acceleraotor_course_description_content);
                    return;
                case WORDS_COLUMNS_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.acceleraotor_course_description_content);
                    return;
                case WORDS_BLOCK_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.acceleraotor_course_description_content);
                    return;
                case SCHULTE_TABLE_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.schulte_table_description_content);
                    return;
                case REMEMBER_NUMBER_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.remember_number_description_content);
                    return;
                case LINE_OF_SIGHT_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.line_of_sight_description_content);
                    return;
                case SPEED_READING_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.speed_reading_description_content);
                    return;
                case WORD_PAIRS_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.word_pairs_description_content);
                    return;
                case EVEN_NUMBERS_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.even_number_description_content);
                    return;
                case GREEN_DOT_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.green_dot_description_content);
                    return;
                case MATHEMATICS_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.math_description_content);
                    return;
                case CONCENTRATION_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.concentration_description_content);
                    return;
                case CUPTIMER_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.cuptimer_description_content);
                    return;
                case REMEMBER_WORDS_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.remember_words_description_content);
                    return;
                case TRUE_COLORS_DESCRIPTION:
                    ((IDescriptionView) getView()).setContentLayout(R.layout.true_colors_description_content);
                    return;
                default:
                    return;
            }
        }
    }

    public void setDontShowAgain(FragmentType type, boolean dontShowAgaing) {
        this.trainingDescriptionUtil.setShowDescriptionFragment(type, !dontShowAgaing);
    }
}
