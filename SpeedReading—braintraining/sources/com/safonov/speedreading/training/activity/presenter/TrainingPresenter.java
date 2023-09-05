package com.safonov.speedreading.training.activity.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.activity.model.ITrainingConfigUtil;
import com.safonov.speedreading.training.activity.model.entity.ConfigWrapper;
import com.safonov.speedreading.training.activity.model.entity.TrainingWrapper;
import com.safonov.speedreading.training.activity.view.ITrainingView;
import com.safonov.speedreading.training.util.course.CourseSaveUtil;
import com.safonov.speedreading.training.util.course.CourseTrainingSave;
import com.safonov.speedreading.training.util.course.ReaderTimerModeSaveUtil;
import java.util.List;

public class TrainingPresenter extends MvpBasePresenter<ITrainingView> implements ITrainingPresenter {
    /* access modifiers changed from: private */
    public ConfigWrapper configWrapper;
    /* access modifiers changed from: private */
    public int[] courseResultsIds;
    /* access modifiers changed from: private */
    public CourseSaveUtil courseSaveUtil;
    /* access modifiers changed from: private */
    public int courseTrainingIndex;
    /* access modifiers changed from: private */
    public FragmentType currentFragmentType;
    /* access modifiers changed from: private */
    public int fragmentIndex;
    /* access modifiers changed from: private */
    public List<FragmentType> fragmentTypeList;
    private boolean isActivityFullscreen;
    private boolean isFirstLaunch = true;
    private boolean isPauseDialogShowing;
    /* access modifiers changed from: private */
    public TrainingWrapper[] passCourseTrainingWrapperArray;
    private ReaderTimerModeSaveUtil readerTimerModeSaveUtil;
    private boolean shouldShowPauseDialog;
    private ITrainingConfigUtil trainingConfigUtil;
    private TrainingType trainingType;

    public TrainingPresenter(@NonNull ITrainingConfigUtil trainingConfigUtil2, @NonNull CourseSaveUtil courseSaveUtil2, @NonNull ReaderTimerModeSaveUtil readerTimerModeSaveUtil2) {
        this.trainingConfigUtil = trainingConfigUtil2;
        this.courseSaveUtil = courseSaveUtil2;
        this.readerTimerModeSaveUtil = readerTimerModeSaveUtil2;
    }

    public void restartCourse() {
        this.courseTrainingIndex = 0;
        this.courseSaveUtil.reset(this.trainingType);
        requestToLoadTraining(this.trainingType);
    }

    public void requestToLoadTraining(@NonNull final TrainingType trainingType2) {
        this.trainingType = trainingType2;
        if (isViewAttached()) {
            ((ITrainingView) getView()).setToolbarTitle(trainingType2.getTitleRes());
        }
        if (TrainingType.isCourseTraining(trainingType2)) {
            this.trainingConfigUtil.requestToGetCourseConfigList(trainingType2, new ITrainingConfigUtil.CourseConfigResponseListener() {
                public void onCourseConfigResponse(TrainingWrapper[] trainingWrapperArray) {
                    CourseTrainingSave save = TrainingPresenter.this.courseSaveUtil.load(trainingType2);
                    if (save != null) {
                        int[] unused = TrainingPresenter.this.courseResultsIds = save.trainingResultIds;
                        int unused2 = TrainingPresenter.this.courseTrainingIndex = save.trainingCompletedCount;
                    } else {
                        int unused3 = TrainingPresenter.this.courseTrainingIndex = 0;
                        int[] unused4 = TrainingPresenter.this.courseResultsIds = new int[trainingWrapperArray.length];
                    }
                    if (TrainingPresenter.this.courseTrainingIndex >= trainingWrapperArray.length) {
                        TrainingPresenter.this.onReadingCompleted();
                    }
                    int unused5 = TrainingPresenter.this.fragmentIndex = 0;
                    TrainingWrapper[] unused6 = TrainingPresenter.this.passCourseTrainingWrapperArray = trainingWrapperArray;
                    ConfigWrapper unused7 = TrainingPresenter.this.configWrapper = TrainingPresenter.this.passCourseTrainingWrapperArray[TrainingPresenter.this.courseTrainingIndex].getConfigWrapper();
                    List unused8 = TrainingPresenter.this.fragmentTypeList = TrainingPresenter.this.passCourseTrainingWrapperArray[TrainingPresenter.this.courseTrainingIndex].getFragmentTypeList();
                    FragmentType unused9 = TrainingPresenter.this.currentFragmentType = (FragmentType) TrainingPresenter.this.fragmentTypeList.get(TrainingPresenter.this.fragmentIndex);
                    if (TrainingPresenter.this.isViewAttached()) {
                        TrainingPresenter.this.setFragment(TrainingPresenter.this.currentFragmentType);
                    }
                }
            });
        } else {
            this.trainingConfigUtil.requestToGetTrainingConfig(trainingType2, new ITrainingConfigUtil.ConfigResponseListener() {
                public void onConfigResponse(TrainingWrapper trainingWrapper) {
                    int unused = TrainingPresenter.this.fragmentIndex = 0;
                    ConfigWrapper unused2 = TrainingPresenter.this.configWrapper = trainingWrapper.getConfigWrapper();
                    List unused3 = TrainingPresenter.this.fragmentTypeList = trainingWrapper.getFragmentTypeList();
                    FragmentType unused4 = TrainingPresenter.this.currentFragmentType = (FragmentType) TrainingPresenter.this.fragmentTypeList.get(TrainingPresenter.this.fragmentIndex);
                    if (TrainingPresenter.this.isViewAttached()) {
                        TrainingPresenter.this.setFragment(TrainingPresenter.this.currentFragmentType);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setFragment(FragmentType fragmentType) {
        if (fragmentType == FragmentType.INTERSTITIAL) {
            if (this.isActivityFullscreen) {
                this.isActivityFullscreen = false;
                if (isViewAttached()) {
                    ((ITrainingView) getView()).showActionBar();
                }
            }
            if (isViewAttached()) {
                ((ITrainingView) getView()).setInterstitialFragment(this.trainingType, this.courseTrainingIndex);
                ((ITrainingView) getView()).setArrowActionBar();
            }
        } else if (fragmentType == FragmentType.PREPARE) {
            if (this.configWrapper.isFullscreen()) {
                this.isActivityFullscreen = true;
                if (isViewAttached()) {
                    ((ITrainingView) getView()).hideActionBar();
                }
            }
            if (isViewAttached()) {
                ((ITrainingView) getView()).setPrepareFragment();
                ((ITrainingView) getView()).setArrowActionBar();
            }
        } else if (FragmentType.isDescriptionFragmentType(fragmentType)) {
            if (this.isActivityFullscreen) {
                this.isActivityFullscreen = false;
                if (isViewAttached()) {
                    ((ITrainingView) getView()).showActionBar();
                }
            }
            if (isViewAttached()) {
                ((ITrainingView) getView()).setDescriptionFragment(fragmentType);
                ((ITrainingView) getView()).setArrowActionBar();
            }
        } else {
            if (FragmentType.isComplexityFragmentType(fragmentType) && isViewAttached()) {
                setComplexityActionBar();
                switch (fragmentType) {
                    case MATHEMATICS_COMPLEXITY:
                        ((ITrainingView) getView()).setMathComplexityFragment(this.configWrapper.getConfigId());
                        break;
                    case CONCENTRATION_COMPLEXITY:
                        ((ITrainingView) getView()).setConcentrationComplexityFragment(this.configWrapper.getConfigId());
                        break;
                }
            }
            if (FragmentType.isTrainingFragmentType(fragmentType)) {
                if (isViewAttached()) {
                    switch (fragmentType) {
                        case WORDS_COLUMNS:
                            ((ITrainingView) getView()).setWordsColumnsFragment(this.configWrapper.getConfigId());
                            break;
                        case WORDS_BLOCK:
                            ((ITrainingView) getView()).setWordsBlockFragment(this.configWrapper.getConfigId());
                            break;
                        case FLASH_WORDS_TRAINING:
                            ((ITrainingView) getView()).setFlashWordsFragment(this.configWrapper.getConfigId());
                            break;
                        case SCHULTE_TABLE:
                            ((ITrainingView) getView()).setSchulteTableFragment(this.configWrapper.getConfigId());
                            break;
                        case REMEMBER_NUMBER:
                            ((ITrainingView) getView()).setRememberNumberFragment(this.configWrapper.getConfigId());
                            break;
                        case LINE_OF_SIGHT:
                            ((ITrainingView) getView()).setLineOfSightFragment(this.configWrapper.getConfigId());
                            break;
                        case SPEED_READING:
                            ((ITrainingView) getView()).setSpeedReadingFragment(this.configWrapper.getConfigId());
                            break;
                        case WORD_PAIRS:
                            ((ITrainingView) getView()).setWordPairsFragment(this.configWrapper.getConfigId());
                            break;
                        case EVEN_NUMBERS:
                            ((ITrainingView) getView()).setEvenNumbersFragment(this.configWrapper.getConfigId());
                            break;
                        case GREEN_DOT:
                            ((ITrainingView) getView()).setGreenDotFragment(this.configWrapper.getConfigId());
                            break;
                        case MATHEMATICS:
                            ((ITrainingView) getView()).setMathFragment(this.configWrapper.getConfigId());
                            break;
                        case CONCENTRATION:
                            ((ITrainingView) getView()).setConcentrationFragment(this.configWrapper.getConfigId());
                            break;
                        case CUPTIMER:
                            ((ITrainingView) getView()).setCupTimerFragment(this.configWrapper.getConfigId());
                            break;
                        case REMEMBER_WORDS:
                            ((ITrainingView) getView()).setRememberWordsFragment(this.configWrapper.getConfigId());
                            break;
                        case TRUE_COLORS:
                            ((ITrainingView) getView()).setTrueColorsFragment(this.configWrapper.getConfigId());
                            break;
                    }
                }
                if (isViewAttached()) {
                    ((ITrainingView) getView()).setArrowTrainingToolbar(this.trainingType.isSettingsSupported());
                }
            }
        }
    }

    private void setSettingsFragment(FragmentType settingsFragmentType) {
        if (isViewAttached()) {
            switch (settingsFragmentType) {
                case WORDS_COLUMNS_SETTINGS:
                    ((ITrainingView) getView()).setWordsColumnsSettingsFragment();
                    return;
                case WORDS_BLOCK_SETTINGS:
                    ((ITrainingView) getView()).setWordsBlockSettingsFragment();
                    return;
                case FLASH_WORDS_SETTINGS:
                    ((ITrainingView) getView()).setFlashWordsSettingsFragment();
                    return;
                case SCHULTE_TABLE_SETTINGS:
                    ((ITrainingView) getView()).setSchulteTableSettingsFragment();
                    return;
                case LINE_OF_SIGHT_SETTINGS:
                    ((ITrainingView) getView()).setLineOfSightSettingsFragment();
                    return;
                case GREEN_DOT_SETTINGS:
                    ((ITrainingView) getView()).setGreenDotSettingsFragment();
                    return;
                case MATHEMATICS_SETTINGS:
                    ((ITrainingView) getView()).setMathSettingsFragment();
                    return;
                case CUPTIMER_SETTINGS:
                    ((ITrainingView) getView()).setCupTimerSettingsFragment();
                    return;
                default:
                    return;
            }
        }
    }

    private void setResultFragment(FragmentType resultFragmentType, int resultId) {
        if (isViewAttached()) {
            switch (resultFragmentType) {
                case WORDS_COLUMNS_RESULT:
                    ((ITrainingView) getView()).setWordsColumnsResultFragment(resultId);
                    return;
                case WORDS_BLOCK_RESULT:
                    ((ITrainingView) getView()).setWordsBlockResultFragment(resultId);
                    return;
                case FLASH_WORDS_RESULT:
                    ((ITrainingView) getView()).setFlashWordsResultFragment(resultId);
                    return;
                case SCHULTE_TABLE_RESULT:
                    ((ITrainingView) getView()).setSchulteTableResultFragment(resultId);
                    return;
                case REMEMBER_NUMBER_RESULT:
                    ((ITrainingView) getView()).setRememberNumberResultFragment(resultId);
                    return;
                case LINE_OF_SIGHT_RESULT:
                    ((ITrainingView) getView()).setLineOfSightResultFragment(resultId);
                    return;
                case SPEED_READING_RESULT:
                    ((ITrainingView) getView()).setSpeedReadingResultFragment(resultId);
                    return;
                case WORD_PAIRS_RESULT:
                    ((ITrainingView) getView()).setWordPairsResultFragment(resultId);
                    return;
                case EVEN_NUMBERS_RESULT:
                    ((ITrainingView) getView()).setEvenNumbersResultFragment(resultId);
                    return;
                case GREEN_DOT_RESULT:
                    ((ITrainingView) getView()).setGreenDotResultFragment(resultId);
                    return;
                case MATHEMATICS_RESULT:
                    ((ITrainingView) getView()).setMathResultFragment(resultId);
                    return;
                case CONCENTRATION_RESULT:
                    ((ITrainingView) getView()).setConcentrationResultFragment(resultId);
                    return;
                case CUPTIMER_RESULT:
                    ((ITrainingView) getView()).setCupTimerResultFragment(resultId);
                    return;
                case REMEMBER_WORDS_RESULT:
                    ((ITrainingView) getView()).setRememberWordsResultFragment(resultId);
                    return;
                case TRUE_COLORS_RESULT:
                    ((ITrainingView) getView()).setTrueColorsResultFragment(resultId);
                    return;
                default:
                    return;
            }
        }
    }

    private void setCourseResultFragment(FragmentType resultFragmentType, int resultId) {
        if (isViewAttached()) {
            switch (resultFragmentType) {
                case WORDS_COLUMNS_RESULT:
                    ((ITrainingView) getView()).setWordsColumnsCourseResultFragment(resultId);
                    return;
                case WORDS_BLOCK_RESULT:
                    ((ITrainingView) getView()).setWordsBlockCourseResultFragment(resultId);
                    return;
                case FLASH_WORDS_RESULT:
                    ((ITrainingView) getView()).setFlashWordsPassCourseResultFragment(resultId);
                    return;
                case SCHULTE_TABLE_RESULT:
                    ((ITrainingView) getView()).setSchulteTablePassCourseResultFragment(resultId);
                    return;
                case REMEMBER_NUMBER_RESULT:
                    ((ITrainingView) getView()).setRememberNumberPassCourseResultFragment(resultId);
                    return;
                case LINE_OF_SIGHT_RESULT:
                    ((ITrainingView) getView()).setLineOfSightPassCourseResultFragment(resultId);
                    return;
                case SPEED_READING_RESULT:
                    ((ITrainingView) getView()).setSpeedReadingPassCourseResultFragment(resultId);
                    return;
                case WORD_PAIRS_RESULT:
                    ((ITrainingView) getView()).setWordPairsPassCourseResultFragment(resultId);
                    return;
                case EVEN_NUMBERS_RESULT:
                    ((ITrainingView) getView()).setEvenNumbersPassCourseResultFragment(resultId);
                    return;
                case GREEN_DOT_RESULT:
                    ((ITrainingView) getView()).setGreenDotPassCourseResultFragment(resultId);
                    return;
                default:
                    return;
            }
        }
    }

    private void setSettingsActionBar() {
        if (this.isActivityFullscreen) {
            if (isViewAttached()) {
                ((ITrainingView) getView()).showActionBar();
            }
            this.isActivityFullscreen = false;
        }
        if (isViewAttached()) {
            ((ITrainingView) getView()).setCloseActionBar();
        }
    }

    private void setHelpActionBar() {
        if (this.isActivityFullscreen) {
            if (isViewAttached()) {
                ((ITrainingView) getView()).showActionBar();
            }
            this.isActivityFullscreen = false;
        }
        if (isViewAttached()) {
            ((ITrainingView) getView()).setCloseActionBar();
        }
    }

    private void setComplexityActionBar() {
        if (isViewAttached()) {
            ((ITrainingView) getView()).setArrowActionBar();
        }
    }

    private void setResultActionBar() {
        if (this.isActivityFullscreen) {
            if (isViewAttached()) {
                ((ITrainingView) getView()).showActionBar();
            }
            this.isActivityFullscreen = false;
        }
        if (isViewAttached()) {
            ((ITrainingView) getView()).setArrowTrainingToolbar(this.trainingType.isSettingsSupported());
        }
    }

    private void setCourseResultActionBar() {
        if (this.isActivityFullscreen) {
            if (isViewAttached()) {
                ((ITrainingView) getView()).showActionBar();
            }
            this.isActivityFullscreen = false;
        }
        if (isViewAttached()) {
            ((ITrainingView) getView()).setArrowActionBar();
        }
    }

    public void onBackPressed() {
        if (!this.isPauseDialogShowing) {
            if (this.trainingType == TrainingType.PASS_COURSE || this.trainingType == TrainingType.ACCELERATOR_COURSE) {
                if (this.currentFragmentType == FragmentType.PREPARE) {
                    if (isViewAttached()) {
                        ((ITrainingView) getView()).pauseFragmentAnimations();
                        ((ITrainingView) getView()).showPauseDialog(false, false, false);
                    }
                } else if (this.currentFragmentType == FragmentType.PASS_COURSE_RESULT || this.currentFragmentType == FragmentType.ACCELERATOR_COURSE_RESULT) {
                    if (isViewAttached()) {
                        ((ITrainingView) getView()).finish();
                    }
                } else if (FragmentType.isHelpFragmentType(this.currentFragmentType)) {
                    goToPrepareFragment();
                } else if (FragmentType.isTrainingFragmentType(this.currentFragmentType)) {
                    if (isViewAttached()) {
                        ((ITrainingView) getView()).pauseFragmentAnimations();
                        ((ITrainingView) getView()).showPauseDialog(true, true, false);
                    }
                } else if (FragmentType.isResultFragment(this.currentFragmentType)) {
                    if (isViewAttached()) {
                        ((ITrainingView) getView()).showPauseDialog(true, true, false);
                    }
                } else if (isViewAttached()) {
                    ((ITrainingView) getView()).showPauseDialog(false, false, false);
                }
            } else if (this.currentFragmentType == FragmentType.PREPARE) {
                if (isViewAttached()) {
                    ((ITrainingView) getView()).finish();
                }
            } else if (FragmentType.isDescriptionFragmentType(this.currentFragmentType)) {
                if (isViewAttached()) {
                    ((ITrainingView) getView()).finish();
                }
            } else if (FragmentType.isResultFragment(this.currentFragmentType)) {
                if (isViewAttached()) {
                    ((ITrainingView) getView()).finish();
                }
            } else if (FragmentType.isHelpFragmentType(this.currentFragmentType)) {
                goToPrepareFragment();
            } else if (FragmentType.isSettingsFragmentType(this.currentFragmentType)) {
                requestToLoadTraining(this.trainingType);
            } else if (FragmentType.isComplexityFragmentType(this.currentFragmentType)) {
                if (isViewAttached()) {
                    ((ITrainingView) getView()).finish();
                }
            } else if (FragmentType.isTrainingFragmentType(this.currentFragmentType) && isViewAttached()) {
                ((ITrainingView) getView()).pauseFragmentAnimations();
                ((ITrainingView) getView()).showPauseDialog(true, true, this.trainingType.isSettingsSupported());
            }
        }
    }

    public void onStop() {
        if (!TrainingType.isCourseTraining(this.trainingType)) {
            return;
        }
        if (this.courseTrainingIndex == 0) {
            this.courseSaveUtil.reset(this.trainingType);
            switch (this.trainingType) {
                case PASS_COURSE:
                    this.readerTimerModeSaveUtil.reset(1);
                    return;
                case ACCELERATOR_COURSE:
                    this.readerTimerModeSaveUtil.reset(2);
                    return;
                default:
                    return;
            }
        } else {
            this.courseSaveUtil.save(this.trainingType, this.courseTrainingIndex, this.courseResultsIds);
        }
    }

    public void onPause() {
        if (this.currentFragmentType == FragmentType.PREPARE) {
            if (isViewAttached()) {
                ((ITrainingView) getView()).pauseFragmentAnimations();
            }
        } else if (FragmentType.isTrainingFragmentType(this.currentFragmentType)) {
            this.shouldShowPauseDialog = true;
            if (isViewAttached()) {
                ((ITrainingView) getView()).pauseFragmentAnimations();
            }
        }
    }

    public void onResume() {
        if (this.isFirstLaunch) {
            this.isFirstLaunch = false;
        } else if (this.shouldShowPauseDialog) {
            this.shouldShowPauseDialog = false;
            if (!this.isPauseDialogShowing && isViewAttached()) {
                ((ITrainingView) getView()).showPauseDialog(true, true, this.trainingType.isSettingsSupported());
            }
        } else if (this.currentFragmentType == FragmentType.PREPARE && isViewAttached()) {
            ((ITrainingView) getView()).resumeFragmentAnimations();
        }
    }

    private void goToPrepareFragment() {
        do {
            this.fragmentIndex--;
            this.currentFragmentType = this.fragmentTypeList.get(this.fragmentIndex);
        } while (this.currentFragmentType != FragmentType.PREPARE);
        setFragment(this.currentFragmentType);
    }

    public void onActionBarRestartPressed() {
        goToPrepareFragment();
    }

    public void onActionBarHelpPressed() {
        this.currentFragmentType = TrainingType.getReferenceHelpFragmentType(this.configWrapper.getTrainingType());
        setHelpActionBar();
        if (isViewAttached()) {
            ((ITrainingView) getView()).setHelpFragment(this.currentFragmentType);
        }
    }

    public void onActionBarSettingsPressed() {
        this.currentFragmentType = TrainingType.getReferenceSettingsFragmentType(this.trainingType);
        setSettingsActionBar();
        setSettingsFragment(this.currentFragmentType);
    }

    public void onActionBarHomePressed() {
        if (FragmentType.isHelpFragmentType(this.currentFragmentType)) {
            goToPrepareFragment();
        } else if (FragmentType.isSettingsFragmentType(this.currentFragmentType)) {
            requestToLoadTraining(this.trainingType);
        } else if (isViewAttached()) {
            ((ITrainingView) getView()).finish();
        }
    }

    public void onPauseDialogShow() {
        this.isPauseDialogShowing = true;
    }

    public void onPauseDialogDismiss() {
        this.isPauseDialogShowing = false;
    }

    public void onPauseDialogContinueClick() {
        if (isViewAttached()) {
            ((ITrainingView) getView()).resumeFragmentAnimations();
            ((ITrainingView) getView()).dismissPauseDialog();
        }
    }

    public void onPauseDialogSettingsClick() {
        this.currentFragmentType = TrainingType.getReferenceSettingsFragmentType(this.configWrapper.getTrainingType());
        setSettingsActionBar();
        setSettingsFragment(this.currentFragmentType);
        if (isViewAttached()) {
            ((ITrainingView) getView()).dismissPauseDialog();
        }
    }

    public void onPauseDialogRestartClick() {
        goToPrepareFragment();
        if (isViewAttached()) {
            ((ITrainingView) getView()).dismissPauseDialog();
        }
    }

    public void onPauseDialogHelpClick() {
        this.currentFragmentType = TrainingType.getReferenceHelpFragmentType(this.configWrapper.getTrainingType());
        setHelpActionBar();
        if (isViewAttached()) {
            ((ITrainingView) getView()).setHelpFragment(this.currentFragmentType);
            ((ITrainingView) getView()).dismissPauseDialog();
        }
    }

    public void onPauseDialogExitClick() {
        if (isViewAttached()) {
            ((ITrainingView) getView()).dismissPauseDialog();
            ((ITrainingView) getView()).finish();
        }
    }

    public void requestToSetNextCourseTraining() {
        this.fragmentIndex = 0;
        this.courseTrainingIndex++;
        if (this.courseTrainingIndex < this.passCourseTrainingWrapperArray.length) {
            this.configWrapper = this.passCourseTrainingWrapperArray[this.courseTrainingIndex].getConfigWrapper();
            this.fragmentTypeList = this.passCourseTrainingWrapperArray[this.courseTrainingIndex].getFragmentTypeList();
            this.currentFragmentType = this.fragmentTypeList.get(this.fragmentIndex);
            if (isViewAttached()) {
                setFragment(this.currentFragmentType);
                return;
            }
            return;
        }
        onReadingCompleted();
    }

    public void requestToSetNextFragment() {
        this.fragmentIndex++;
        if (this.fragmentIndex < this.fragmentTypeList.size()) {
            this.currentFragmentType = this.fragmentTypeList.get(this.fragmentIndex);
            if (isViewAttached()) {
                setFragment(this.currentFragmentType);
            }
        }
    }

    public void onTrainingCompleted(@NonNull TrainingType completedTrainingType, int resultId) {
        if (this.trainingType == TrainingType.PASS_COURSE || this.trainingType == TrainingType.ACCELERATOR_COURSE) {
            this.courseResultsIds[this.courseTrainingIndex] = resultId;
            this.currentFragmentType = TrainingType.getReferenceResultFragmentType(completedTrainingType);
            if (isViewAttached()) {
                setResultActionBar();
                setCourseResultFragment(this.currentFragmentType, resultId);
                return;
            }
            return;
        }
        this.currentFragmentType = TrainingType.getReferenceResultFragmentType(completedTrainingType);
        if (isViewAttached()) {
            setResultActionBar();
            setResultFragment(this.currentFragmentType, resultId);
        }
    }

    public void onReadingCompleted() {
        this.courseTrainingIndex = 0;
        if (this.trainingType == TrainingType.PASS_COURSE) {
            this.currentFragmentType = FragmentType.PASS_COURSE_RESULT;
            setCourseResultActionBar();
            if (isViewAttached()) {
                ((ITrainingView) getView()).setPassCourseResultFragment(this.courseResultsIds);
            }
        }
        if (this.trainingType == TrainingType.ACCELERATOR_COURSE) {
            this.currentFragmentType = FragmentType.ACCELERATOR_COURSE_RESULT;
            setCourseResultActionBar();
            if (isViewAttached()) {
                ((ITrainingView) getView()).setAcceleratorCourseResultFragment(this.courseResultsIds);
            }
        }
    }
}
