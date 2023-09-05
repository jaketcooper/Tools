package com.safonov.speedreading.training.activity.view;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.fragment.concentration.complexity.view.IConcentrationComplexityListner;
import com.safonov.speedreading.training.fragment.concentration.training.view.ConcentrationCompleteListener;
import com.safonov.speedreading.training.fragment.cuptimer.training.view.CupTimerCompleteListener;
import com.safonov.speedreading.training.fragment.description.view.DescriptionFragmentListener;
import com.safonov.speedreading.training.fragment.evennumbers.training.view.EvenNumbersTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.flashword.training.view.FlashWordsTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.greendot.training.view.GreenDotTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.interstitial.view.InterstitialFragmentListener;
import com.safonov.speedreading.training.fragment.lineofsight.training.view.LineOfSightTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.math.complexity.view.MathComplexityFragmentListner;
import com.safonov.speedreading.training.fragment.math.training.view.MathTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.passcource.CourseResultFragmentListener;
import com.safonov.speedreading.training.fragment.prepare.PrepareFragmentListener;
import com.safonov.speedreading.training.fragment.remembernumber.training.view.RememberNumberTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.rememberwords.training.view.RememberWordsTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.schultetable.training.view.SchulteTableTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.speedreading.training.view.SpeedReadingTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.truecolors.training.view.TrueColorsTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.wordpairs.training.view.WordPairsTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.wordsblock.training.view.WordBlockTrainingCompleteListener;
import com.safonov.speedreading.training.fragment.wordscolumns.training.view.WordColumnsTrainingCompleteListener;

public interface ITrainingView extends MvpView, WordColumnsTrainingCompleteListener, WordBlockTrainingCompleteListener, FlashWordsTrainingCompleteListener, SchulteTableTrainingCompleteListener, RememberNumberTrainingCompleteListener, LineOfSightTrainingCompleteListener, SpeedReadingTrainingCompleteListener, WordPairsTrainingCompleteListener, EvenNumbersTrainingCompleteListener, GreenDotTrainingCompleteListener, MathTrainingCompleteListener, MathComplexityFragmentListner, IConcentrationComplexityListner, ConcentrationCompleteListener, CupTimerCompleteListener, RememberWordsTrainingCompleteListener, TrueColorsTrainingCompleteListener, PrepareFragmentListener, DescriptionFragmentListener, InterstitialFragmentListener, CourseResultFragmentListener {
    void dismissPauseDialog();

    void finish();

    void hideActionBar();

    void pauseFragmentAnimations();

    void restartCourse();

    void resumeFragmentAnimations();

    void setAcceleratorCourseResultFragment(int[] iArr);

    void setArrowActionBar();

    void setArrowTrainingToolbar(boolean z);

    void setCloseActionBar();

    void setConcentrationComplexityFragment(int i);

    void setConcentrationFragment(int i);

    void setConcentrationResultFragment(int i);

    void setCupTimerFragment(int i);

    void setCupTimerResultFragment(int i);

    void setCupTimerSettingsFragment();

    void setDescriptionFragment(@NonNull FragmentType fragmentType);

    void setEvenNumbersFragment(int i);

    void setEvenNumbersPassCourseResultFragment(int i);

    void setEvenNumbersResultFragment(int i);

    void setFlashWordsFragment(int i);

    void setFlashWordsPassCourseResultFragment(int i);

    void setFlashWordsResultFragment(int i);

    void setFlashWordsSettingsFragment();

    void setGreenDotFragment(int i);

    void setGreenDotPassCourseResultFragment(int i);

    void setGreenDotResultFragment(int i);

    void setGreenDotSettingsFragment();

    void setHelpFragment(@NonNull FragmentType fragmentType);

    void setInterstitialFragment(@NonNull TrainingType trainingType, int i);

    void setLineOfSightFragment(int i);

    void setLineOfSightPassCourseResultFragment(int i);

    void setLineOfSightResultFragment(int i);

    void setLineOfSightSettingsFragment();

    void setMathComplexityFragment(int i);

    void setMathFragment(int i);

    void setMathResultFragment(int i);

    void setMathSettingsFragment();

    void setPassCourseResultFragment(int[] iArr);

    void setPrepareFragment();

    void setRememberNumberFragment(int i);

    void setRememberNumberPassCourseResultFragment(int i);

    void setRememberNumberResultFragment(int i);

    void setRememberWordsFragment(int i);

    void setRememberWordsResultFragment(int i);

    void setSchulteTableFragment(int i);

    void setSchulteTablePassCourseResultFragment(int i);

    void setSchulteTableResultFragment(int i);

    void setSchulteTableSettingsFragment();

    void setSpeedReadingFragment(int i);

    void setSpeedReadingPassCourseResultFragment(int i);

    void setSpeedReadingResultFragment(int i);

    void setToolbarTitle(@StringRes int i);

    void setTrueColorsFragment(int i);

    void setTrueColorsResultFragment(int i);

    void setWordPairsFragment(int i);

    void setWordPairsPassCourseResultFragment(int i);

    void setWordPairsResultFragment(int i);

    void setWordsBlockCourseResultFragment(int i);

    void setWordsBlockFragment(int i);

    void setWordsBlockResultFragment(int i);

    void setWordsBlockSettingsFragment();

    void setWordsColumnsCourseResultFragment(int i);

    void setWordsColumnsFragment(int i);

    void setWordsColumnsResultFragment(int i);

    void setWordsColumnsSettingsFragment();

    void showActionBar();

    void showPauseDialog(boolean z, boolean z2, boolean z3);

    void startCourseReaderActivity(@NonNull TrainingType trainingType);
}
