package com.safonov.speedreading.training.activity.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.reader.library.activity.view.LibraryActivity;
import com.safonov.speedreading.reader.reader.view.ReaderActivity;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.activity.model.TrainingConfigUtil;
import com.safonov.speedreading.training.activity.presenter.ITrainingPresenter;
import com.safonov.speedreading.training.activity.presenter.TrainingPresenter;
import com.safonov.speedreading.training.fragment.aceeleratorcourse.view.AcceleratorCourseResultFragment;
import com.safonov.speedreading.training.fragment.concentration.complexity.view.ConcentrationComplexityFragment;
import com.safonov.speedreading.training.fragment.concentration.repository.ConcentrationRealmUtil;
import com.safonov.speedreading.training.fragment.concentration.result.view.ConcentrationResultFragment;
import com.safonov.speedreading.training.fragment.concentration.training.view.ConcentrationFragment;
import com.safonov.speedreading.training.fragment.cuptimer.repository.CupTimerRealmUtil;
import com.safonov.speedreading.training.fragment.cuptimer.result.view.CupTimerResultFragment;
import com.safonov.speedreading.training.fragment.cuptimer.settings.CupTimerSettingsFragment;
import com.safonov.speedreading.training.fragment.cuptimer.training.view.CupTimerFragment;
import com.safonov.speedreading.training.fragment.description.view.DescriptionFragment;
import com.safonov.speedreading.training.fragment.evennumbers.passcourseresult.view.EvenNumbersPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.evennumbers.repository.EvenNumbersRealmUtil;
import com.safonov.speedreading.training.fragment.evennumbers.result.view.EvenNumbersResultFragment;
import com.safonov.speedreading.training.fragment.evennumbers.training.view.EvenNumbersFragment;
import com.safonov.speedreading.training.fragment.flashword.passcourseresult.view.FlashWordsPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.flashword.repository.FlashWordRealmUtil;
import com.safonov.speedreading.training.fragment.flashword.result.view.FlashWordsResultFragment;
import com.safonov.speedreading.training.fragment.flashword.settings.FlashWordsSettingsFragment;
import com.safonov.speedreading.training.fragment.flashword.training.view.FlashWordsFragment;
import com.safonov.speedreading.training.fragment.greendot.passcourseresult.view.GreenDotPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.greendot.repository.GreenDotRealmUtil;
import com.safonov.speedreading.training.fragment.greendot.result.view.GreenDotResultFragment;
import com.safonov.speedreading.training.fragment.greendot.settings.GreenDotSettingsFragment;
import com.safonov.speedreading.training.fragment.greendot.training.view.GreenDotFragment;
import com.safonov.speedreading.training.fragment.help.view.HelpFragment;
import com.safonov.speedreading.training.fragment.interstitial.view.InterstitialFragment;
import com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.view.LineOfSightPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.lineofsight.repository.LineOfSightRealmUtil;
import com.safonov.speedreading.training.fragment.lineofsight.result.view.LineOfSightResultFragment;
import com.safonov.speedreading.training.fragment.lineofsight.settings.LineOfSightSettingsFragment;
import com.safonov.speedreading.training.fragment.lineofsight.training.view.LineOfSightFragment;
import com.safonov.speedreading.training.fragment.math.complexity.view.MathComplexityFragment;
import com.safonov.speedreading.training.fragment.math.repository.MathRealmUtil;
import com.safonov.speedreading.training.fragment.math.result.view.MathResultFragment;
import com.safonov.speedreading.training.fragment.math.settings.MathSettingsFragment;
import com.safonov.speedreading.training.fragment.math.training.view.MathFragment;
import com.safonov.speedreading.training.fragment.passcource.result.view.PassCourseResultFragment;
import com.safonov.speedreading.training.fragment.prepare.view.PrepareTrainingFragment;
import com.safonov.speedreading.training.fragment.remembernumber.passcourseresult.view.RememberNumberPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.remembernumber.repository.RememberNumberRealmUtil;
import com.safonov.speedreading.training.fragment.remembernumber.result.view.RememberNumberResultFragment;
import com.safonov.speedreading.training.fragment.remembernumber.training.view.RememberNumberFragment;
import com.safonov.speedreading.training.fragment.rememberwords.repository.RememberWordsRealmUtil;
import com.safonov.speedreading.training.fragment.rememberwords.result.view.RememberWordsResultFragment;
import com.safonov.speedreading.training.fragment.rememberwords.training.view.RememberWordsFragment;
import com.safonov.speedreading.training.fragment.schultetable.passcourseresult.view.SchulteTablePassCourseResultFragment;
import com.safonov.speedreading.training.fragment.schultetable.repository.SchulteTableRealmUtil;
import com.safonov.speedreading.training.fragment.schultetable.result.view.SchulteTableResultFragment;
import com.safonov.speedreading.training.fragment.schultetable.settings.SchulteTableSettingsFragment;
import com.safonov.speedreading.training.fragment.schultetable.training.view.SchulteTableFragment;
import com.safonov.speedreading.training.fragment.speedreading.passcourseresult.view.SpeedReadingPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.speedreading.repository.SpeedReadingRealmUtil;
import com.safonov.speedreading.training.fragment.speedreading.result.view.SpeedReadingResultFragment;
import com.safonov.speedreading.training.fragment.speedreading.training.view.SpeedReadingFragment;
import com.safonov.speedreading.training.fragment.truecolors.repository.TrueColorsRealmUtil;
import com.safonov.speedreading.training.fragment.truecolors.result.view.TrueColorsResultFragment;
import com.safonov.speedreading.training.fragment.truecolors.training.view.TrueColorsFragment;
import com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.view.WordPairsPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.wordpairs.repository.WordPairsRealmUtil;
import com.safonov.speedreading.training.fragment.wordpairs.result.view.WordPairsResultFragment;
import com.safonov.speedreading.training.fragment.wordpairs.training.view.WordPairsFragment;
import com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.view.WordBlockPassCourseResultFragment;
import com.safonov.speedreading.training.fragment.wordsblock.repository.WordBlockRealmUtil;
import com.safonov.speedreading.training.fragment.wordsblock.result.view.WordBlockResultFragment;
import com.safonov.speedreading.training.fragment.wordsblock.training.view.WordBlockFragment;
import com.safonov.speedreading.training.fragment.wordscolumns.passcourseresult.view.WordColumnsCourseResultFragment;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.WordsColumnsRealmUtil;
import com.safonov.speedreading.training.fragment.wordscolumns.result.view.WordColumnsResultFragment;
import com.safonov.speedreading.training.fragment.wordscolumns.settings.WordColumnsSettingsFragment;
import com.safonov.speedreading.training.fragment.wordscolumns.training.view.WordColumnsFragment;
import com.safonov.speedreading.training.util.course.CourseSaveUtil;
import com.safonov.speedreading.training.util.course.ReaderTimerModeSaveUtil;
import com.safonov.speedreading.training.util.preference.TrainingDescriptionUtil;
import com.safonov.speedreading.training.util.preference.TrainingSettingsUtil;
import com.speedreading.alexander.speedreading.R;

public class TrainingActivity extends MvpActivity<ITrainingView, ITrainingPresenter> implements ITrainingView {
    public static final int COURSE_REQUEST_CODE = 1998;
    public static final String TRAINING_TYPE_PARAM = "training_type";
    private ConcentrationRealmUtil concentrationRealmUtil;
    private CupTimerRealmUtil cupTimerRealmUtil;
    private Fragment currentFragment;
    private EvenNumbersRealmUtil evenNumbersRealmUtil;
    private FlashWordRealmUtil flashWordRealmUtil;
    private FragmentManager fragmentManager;
    private GreenDotRealmUtil greenDotRealmUtil;
    /* access modifiers changed from: private */
    public InterstitialAd interstitialAd;
    private LineOfSightRealmUtil lineOfSightRealmUtil;
    private MathRealmUtil mathRealmUtil;
    private Menu menu;
    private AlertDialog pauseDialog;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private boolean readingCompleted;
    private RememberNumberRealmUtil rememberNumberRealmUtil;
    private RememberWordsRealmUtil rememberWordsRealmUtil;
    private SchulteTableRealmUtil schulteTableRealmUtil;
    private SpeedReadingRealmUtil speedReadingRealmUtil;
    @BindView(2131296781)
    Toolbar toolbar;
    private TrainingType trainingType;
    private TrueColorsRealmUtil trueColorsRealmUtil;
    private Unbinder unbinder;
    private WordBlockRealmUtil wordBlockRealmUtil;
    private WordPairsRealmUtil wordPairsRealmUtil;
    private WordsColumnsRealmUtil wordsColumnsRealmUtil;

    @NonNull
    public ITrainingPresenter createPresenter() {
        App app = App.get();
        TrainingSettingsUtil trainingSettingsUtil = new TrainingSettingsUtil(this);
        TrainingDescriptionUtil trainingDescriptionUtil = new TrainingDescriptionUtil(this);
        this.wordsColumnsRealmUtil = new WordsColumnsRealmUtil(app.getWordsColumnsRealm());
        this.wordBlockRealmUtil = new WordBlockRealmUtil(app.getWordBlockRealm());
        this.flashWordRealmUtil = new FlashWordRealmUtil(app.getFlashWordsRealm());
        this.schulteTableRealmUtil = new SchulteTableRealmUtil(app.getSchulteTableRealm());
        this.rememberNumberRealmUtil = new RememberNumberRealmUtil(app.getRememberNumberRealm());
        this.lineOfSightRealmUtil = new LineOfSightRealmUtil(app.getLineOfSightRealm());
        this.evenNumbersRealmUtil = new EvenNumbersRealmUtil(app.getEvenNumbersRealm());
        this.wordPairsRealmUtil = new WordPairsRealmUtil(app.getWordPairsRealm());
        this.speedReadingRealmUtil = new SpeedReadingRealmUtil(app.getSpeedReadingRealm());
        this.greenDotRealmUtil = new GreenDotRealmUtil(app.getGreenDotRealm());
        this.mathRealmUtil = new MathRealmUtil(app.getMathRealm());
        this.concentrationRealmUtil = new ConcentrationRealmUtil(app.getConcentrationRealm());
        this.cupTimerRealmUtil = new CupTimerRealmUtil(app.getCupTimerRealm());
        this.rememberWordsRealmUtil = new RememberWordsRealmUtil(app.getRememberWordsRealm());
        this.trueColorsRealmUtil = new TrueColorsRealmUtil(app.getTrueColorsRealm());
        return new TrainingPresenter(new TrainingConfigUtil(trainingSettingsUtil, trainingDescriptionUtil, this.wordsColumnsRealmUtil, this.wordBlockRealmUtil, this.flashWordRealmUtil, this.schulteTableRealmUtil, this.rememberNumberRealmUtil, this.lineOfSightRealmUtil, this.speedReadingRealmUtil, this.evenNumbersRealmUtil, this.wordPairsRealmUtil, this.greenDotRealmUtil, this.mathRealmUtil, this.concentrationRealmUtil, this.cupTimerRealmUtil, this.rememberWordsRealmUtil, this.trueColorsRealmUtil), new CourseSaveUtil(this), new ReaderTimerModeSaveUtil(this));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.training_activity);
        this.interstitialAd = new InterstitialAd(this);
        this.interstitialAd.setAdUnitId(getString(R.string.interstitial_advertisement_id));
        if (!this.premiumUtil.isPremiumUser()) {
            this.interstitialAd.loadAd(new AdRequest.Builder().build());
        }
        this.unbinder = ButterKnife.bind((Activity) this);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.fragmentManager = getSupportFragmentManager();
        this.trainingType = (TrainingType) getIntent().getExtras().getSerializable(TRAINING_TYPE_PARAM);
    }

    public void restartCourse() {
        ((ITrainingPresenter) this.presenter).restartCourse();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ((ITrainingPresenter) this.presenter).onStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ((ITrainingPresenter) this.presenter).onPause();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((ITrainingPresenter) this.presenter).onResume();
    }

    public void onBackPressed() {
        ((ITrainingPresenter) this.presenter).onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                ((ITrainingPresenter) this.presenter).onActionBarHomePressed();
                return true;
            case R.id.help /*2131296425*/:
                ((ITrainingPresenter) this.presenter).onActionBarHelpPressed();
                return true;
            case R.id.restart /*2131296628*/:
                ((ITrainingPresenter) this.presenter).onActionBarRestartPressed();
                return true;
            case R.id.settings /*2131296669*/:
                ((ITrainingPresenter) this.presenter).onActionBarSettingsPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        super.onCreateOptionsMenu(menu2);
        getMenuInflater().inflate(R.menu.training_menu, menu2);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu2) {
        this.menu = menu2;
        ((ITrainingPresenter) this.presenter).requestToLoadTraining(this.trainingType);
        return super.onPrepareOptionsMenu(menu2);
    }

    public void startCourseReaderActivity(@NonNull TrainingType courseType) {
        switch (courseType) {
            case PASS_COURSE:
                startActivityForResult(new Intent(this, LibraryActivity.class).putExtra(ReaderActivity.TIMER_MODE_PARAM, 1), COURSE_REQUEST_CODE);
                return;
            case ACCELERATOR_COURSE:
                startActivityForResult(new Intent(this, LibraryActivity.class).putExtra(ReaderActivity.TIMER_MODE_PARAM, 2), COURSE_REQUEST_CODE);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case COURSE_REQUEST_CODE /*1998*/:
                if (resultCode == -1) {
                    this.readingCompleted = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        if (this.readingCompleted) {
            this.readingCompleted = false;
            ((ITrainingPresenter) this.presenter).onReadingCompleted();
        }
    }

    public void setToolbarTitle(@StringRes int titleRes) {
        getSupportActionBar().setTitle(titleRes);
    }

    public void setCloseActionBar() {
        this.menu.findItem(R.id.restart).setVisible(false);
        this.menu.findItem(R.id.help).setVisible(false);
        this.menu.findItem(R.id.settings).setVisible(false);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_close_icon);
    }

    public void setArrowActionBar() {
        this.menu.findItem(R.id.restart).setVisible(false);
        this.menu.findItem(R.id.help).setVisible(false);
        this.menu.findItem(R.id.settings).setVisible(false);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
    }

    public void setArrowTrainingToolbar(boolean isSettingsSupported) {
        this.menu.findItem(R.id.restart).setVisible(true);
        this.menu.findItem(R.id.help).setVisible(true);
        this.menu.findItem(R.id.settings).setVisible(isSettingsSupported);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
    }

    public void hideActionBar() {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
        getSupportActionBar().hide();
    }

    public void showActionBar() {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().clearFlags(1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
        getSupportActionBar().show();
    }

    public void pauseFragmentAnimations() {
        if (this.currentFragment instanceof IAnimatedFragment) {
            ((IAnimatedFragment) this.currentFragment).pauseAnimations();
        }
    }

    public void resumeFragmentAnimations() {
        if (this.currentFragment instanceof IAnimatedFragment) {
            ((IAnimatedFragment) this.currentFragment).resumeAnimations();
        }
    }

    public void showPauseDialog(boolean showRestart, boolean showHelp, boolean showSettings) {
        int i;
        int i2;
        int i3 = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.training_pause_dialog, (ViewGroup) null);
        builder.setView(view);
        ButterKnife.findById(view, (int) R.id.training_pause_dialog_continue_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ITrainingPresenter) TrainingActivity.this.presenter).onPauseDialogContinueClick();
            }
        });
        View restartView = ButterKnife.findById(view, (int) R.id.training_pause_dialog_restart_view);
        if (showRestart) {
            i = 0;
        } else {
            i = 8;
        }
        restartView.setVisibility(i);
        restartView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ITrainingPresenter) TrainingActivity.this.presenter).onPauseDialogRestartClick();
            }
        });
        View settingsView = ButterKnife.findById(view, (int) R.id.training_pause_dialog_settings_view);
        if (showSettings) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        settingsView.setVisibility(i2);
        settingsView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ITrainingPresenter) TrainingActivity.this.presenter).onPauseDialogSettingsClick();
            }
        });
        View helpView = ButterKnife.findById(view, (int) R.id.training_pause_dialog_help_view);
        if (!showHelp) {
            i3 = 8;
        }
        helpView.setVisibility(i3);
        helpView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ITrainingPresenter) TrainingActivity.this.presenter).onPauseDialogHelpClick();
            }
        });
        ButterKnife.findById(view, (int) R.id.training_pause_dialog_exit_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((ITrainingPresenter) TrainingActivity.this.presenter).onPauseDialogExitClick();
            }
        });
        this.pauseDialog = builder.create();
        this.pauseDialog.getWindow().addFlags(8);
        this.pauseDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialog) {
                ((ITrainingPresenter) TrainingActivity.this.presenter).onPauseDialogShow();
            }
        });
        this.pauseDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                ((ITrainingPresenter) TrainingActivity.this.presenter).onPauseDialogDismiss();
            }
        });
        this.pauseDialog.show();
    }

    public void dismissPauseDialog() {
        this.pauseDialog.dismiss();
    }

    public void onPrepareFragmentCompleted() {
        ((ITrainingPresenter) this.presenter).requestToSetNextFragment();
    }

    public void onDescriptionFragmentStartClick() {
        ((ITrainingPresenter) this.presenter).requestToSetNextFragment();
    }

    public void onInterstitialFragmentListenerCompleted() {
        ((ITrainingPresenter) this.presenter).requestToSetNextFragment();
    }

    public void onPassCourseRestarted() {
        ((ITrainingPresenter) this.presenter).restartCourse();
    }

    public void onCourseResultNextClick() {
        ((ITrainingPresenter) this.presenter).requestToSetNextCourseTraining();
    }

    private void setCurrentFragment(Fragment fragment) {
        this.currentFragment = fragment;
        this.fragmentManager.beginTransaction().replace(R.id.fragment_container, this.currentFragment).commit();
    }

    /* access modifiers changed from: private */
    public void setCurrentFragmentStateLoss(Fragment fragment) {
        this.currentFragment = fragment;
        this.fragmentManager.beginTransaction().replace(R.id.fragment_container, this.currentFragment).commitAllowingStateLoss();
    }

    public void setWordsColumnsFragment(int configId) {
        setCurrentFragment(WordColumnsFragment.newInstance(configId));
    }

    public void setWordsColumnsResultFragment(int resultId) {
        setCurrentFragment(WordColumnsResultFragment.newInstance(resultId));
    }

    public void setWordsColumnsCourseResultFragment(int resultId) {
        setCurrentFragment(WordColumnsCourseResultFragment.newInstance(resultId));
    }

    public void setWordsColumnsSettingsFragment() {
        setCurrentFragment(WordColumnsSettingsFragment.newInstance());
    }

    public void setAcceleratorCourseResultFragment(int[] resultIds) {
        setCurrentFragment(AcceleratorCourseResultFragment.newInstance(resultIds));
    }

    public void onWordColumnsTrainingCompleted(int resultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.WORDS_COLUMNS, resultId);
    }

    public void setWordsBlockFragment(int configId) {
        setCurrentFragment(WordBlockFragment.newInstance(configId));
    }

    public void setWordsBlockResultFragment(int resultId) {
        setCurrentFragment(WordBlockResultFragment.newInstance(resultId));
    }

    public void setWordsBlockCourseResultFragment(int resultId) {
        setCurrentFragment(WordBlockPassCourseResultFragment.newInstance(resultId));
    }

    public void setWordsBlockSettingsFragment() {
    }

    public void onWordBlockTrainingCompleted(int resultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.WORDS_BLOCK, resultId);
    }

    public void setFlashWordsFragment(int configId) {
        setCurrentFragment(FlashWordsFragment.newInstance(configId));
    }

    public void setFlashWordsResultFragment(int resultId) {
        setCurrentFragment(FlashWordsResultFragment.newInstance(resultId));
    }

    public void setFlashWordsPassCourseResultFragment(int resultId) {
        setCurrentFragment(FlashWordsPassCourseResultFragment.newInstance(resultId));
    }

    public void setFlashWordsSettingsFragment() {
        setCurrentFragment(FlashWordsSettingsFragment.newInstance());
    }

    public void onFlashWordsTrainingCompleted(int resultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.FLASH_WORDS, resultId);
    }

    public void setSchulteTableFragment(int configId) {
        setCurrentFragment(SchulteTableFragment.newInstance(configId));
    }

    public void setSchulteTableResultFragment(int resultId) {
        setCurrentFragment(SchulteTableResultFragment.newInstance(resultId));
    }

    public void setSchulteTablePassCourseResultFragment(int resultId) {
        setCurrentFragment(SchulteTablePassCourseResultFragment.newInstance(resultId));
    }

    public void setSchulteTableSettingsFragment() {
        setCurrentFragment(SchulteTableSettingsFragment.newInstance());
    }

    public void onSchulteTableTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.SCHULTE_TABLE, trainingResultId);
    }

    public void setRememberNumberFragment(int configId) {
        setCurrentFragment(RememberNumberFragment.newInstance(configId));
    }

    public void setRememberNumberResultFragment(int resultId) {
        setCurrentFragment(RememberNumberResultFragment.newInstance(resultId));
    }

    public void setRememberNumberPassCourseResultFragment(int resultId) {
        setCurrentFragment(RememberNumberPassCourseResultFragment.newInstance(resultId));
    }

    public void onRememberNumberTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.REMEMBER_NUMBER, trainingResultId);
    }

    public void setSpeedReadingFragment(int configId) {
        setCurrentFragment(SpeedReadingFragment.newInstance(configId));
    }

    public void setSpeedReadingResultFragment(int resultId) {
        setCurrentFragment(SpeedReadingResultFragment.newInstance(resultId));
    }

    public void setSpeedReadingPassCourseResultFragment(int resultId) {
        setCurrentFragment(SpeedReadingPassCourseResultFragment.newInstance(resultId));
    }

    public void onSpeedReadingTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.SPEED_READING, trainingResultId);
    }

    public void setLineOfSightFragment(int configId) {
        setCurrentFragment(LineOfSightFragment.newInstance(configId));
    }

    public void setLineOfSightResultFragment(int resultId) {
        setCurrentFragment(LineOfSightResultFragment.newInstance(resultId));
    }

    public void setLineOfSightPassCourseResultFragment(int resultId) {
        setCurrentFragment(LineOfSightPassCourseResultFragment.newInstance(resultId));
    }

    public void setLineOfSightSettingsFragment() {
        setCurrentFragment(LineOfSightSettingsFragment.newInstance());
    }

    public void onLineOfSightTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.LINE_OF_SIGHT, trainingResultId);
    }

    public void setWordPairsFragment(int configId) {
        setCurrentFragment(WordPairsFragment.newInstance(configId));
    }

    public void setWordPairsResultFragment(int resultId) {
        setCurrentFragment(WordPairsResultFragment.newInstance(resultId));
    }

    public void setWordPairsPassCourseResultFragment(int resultId) {
        setCurrentFragment(WordPairsPassCourseResultFragment.newInstance(resultId));
    }

    public void onWordPairsTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.WORD_PAIRS, trainingResultId);
    }

    public void setEvenNumbersFragment(int configId) {
        setCurrentFragment(EvenNumbersFragment.newInstance(configId));
    }

    public void setEvenNumbersResultFragment(int resultId) {
        setCurrentFragment(EvenNumbersResultFragment.newInstance(resultId));
    }

    public void setEvenNumbersPassCourseResultFragment(int resultId) {
        setCurrentFragment(EvenNumbersPassCourseResultFragment.newInstance(resultId));
    }

    public void onEvenNumbersTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.EVEN_NUMBERS, trainingResultId);
    }

    public void setGreenDotFragment(int configId) {
        setCurrentFragment(GreenDotFragment.newInstance(configId));
    }

    public void setGreenDotResultFragment(int resultId) {
        setCurrentFragment(GreenDotResultFragment.newInstance(resultId));
    }

    public void setGreenDotPassCourseResultFragment(int resultId) {
        setCurrentFragment(GreenDotPassCourseResultFragment.newInstance(resultId));
    }

    public void setGreenDotSettingsFragment() {
        setCurrentFragment(GreenDotSettingsFragment.newInstance());
    }

    public void onGreenDotTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.GREEN_DOT, trainingResultId);
    }

    public void setMathFragment(int configId) {
        setCurrentFragment(MathFragment.newInstance(configId));
    }

    public void setMathResultFragment(int resultId) {
        setCurrentFragment(MathResultFragment.newInstance(resultId));
    }

    public void setMathComplexityFragment(int configId) {
        setCurrentFragment(MathComplexityFragment.newInstance(configId));
    }

    public void setMathSettingsFragment() {
        setCurrentFragment(MathSettingsFragment.newInstance());
    }

    public void onMathTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.MATHEMATICS, trainingResultId);
    }

    public void setConcentrationFragment(int configId) {
        setCurrentFragment(ConcentrationFragment.newInstance(configId));
    }

    public void setConcentrationResultFragment(int resultId) {
        setCurrentFragment(ConcentrationResultFragment.newInstance(resultId));
    }

    public void setConcentrationComplexityFragment(int configId) {
        setCurrentFragment(ConcentrationComplexityFragment.newInstance(configId));
    }

    public void setCupTimerFragment(int configId) {
        setCurrentFragment(CupTimerFragment.newInstance(configId));
    }

    public void onCupTimerTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.CUPTIMER, trainingResultId);
    }

    public void setCupTimerResultFragment(int resultId) {
        setCurrentFragment(CupTimerResultFragment.newInstance(resultId));
    }

    public void setCupTimerSettingsFragment() {
        setCurrentFragment(CupTimerSettingsFragment.newInstance());
    }

    public void onConcentrationComplexityStartClick() {
        ((ITrainingPresenter) this.presenter).requestToSetNextFragment();
    }

    public void onConcentrationTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.CONCENTRATION, trainingResultId);
    }

    public void onRememberWordsTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.REMEMBER_WORDS, trainingResultId);
    }

    public void setRememberWordsFragment(int configId) {
        setCurrentFragment(RememberWordsFragment.newInstance(configId));
    }

    public void setRememberWordsResultFragment(int resultId) {
        setCurrentFragment(RememberWordsResultFragment.newInstance(resultId));
    }

    public void setTrueColorsFragment(int configId) {
        setCurrentFragment(TrueColorsFragment.newInstance(configId));
    }

    public void setTrueColorsResultFragment(int resultId) {
        setCurrentFragment(TrueColorsResultFragment.newInstance(resultId));
    }

    public void onTrueColorsTrainingCompleted(int trainingResultId) {
        ((ITrainingPresenter) this.presenter).onTrainingCompleted(TrainingType.TRUE_COLORS, trainingResultId);
    }

    public void setPassCourseResultFragment(int[] resultIds) {
        setCurrentFragment(PassCourseResultFragment.newInstance(resultIds));
    }

    public void setPrepareFragment() {
        setCurrentFragment(PrepareTrainingFragment.newInstance());
    }

    public void setInterstitialFragment(@NonNull final TrainingType courseType, final int trainingIndex) {
        if (this.premiumUtil.isPremiumUser()) {
            setCurrentFragment(InterstitialFragment.newInstance(courseType, trainingIndex));
        } else if (this.interstitialAd.isLoaded()) {
            this.interstitialAd.show();
            this.interstitialAd.setAdListener(new AdListener() {
                public void onAdClosed() {
                    TrainingActivity.this.interstitialAd.loadAd(new AdRequest.Builder().build());
                    TrainingActivity.this.setCurrentFragmentStateLoss(InterstitialFragment.newInstance(courseType, trainingIndex));
                }
            });
        } else {
            setCurrentFragment(InterstitialFragment.newInstance(courseType, trainingIndex));
        }
    }

    public void setHelpFragment(@NonNull FragmentType helpFragmentType) {
        setCurrentFragment(HelpFragment.newInstance(helpFragmentType));
    }

    public void setDescriptionFragment(@NonNull FragmentType descriptionFragmentType) {
        setCurrentFragment(DescriptionFragment.newInstance(descriptionFragmentType));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.unbinder.unbind();
        this.wordsColumnsRealmUtil.close();
        this.wordBlockRealmUtil.close();
        this.flashWordRealmUtil.close();
        this.schulteTableRealmUtil.close();
        this.rememberNumberRealmUtil.close();
        this.lineOfSightRealmUtil.close();
        this.speedReadingRealmUtil.close();
        this.wordPairsRealmUtil.close();
        this.evenNumbersRealmUtil.close();
        this.greenDotRealmUtil.close();
        this.mathRealmUtil.close();
        this.concentrationRealmUtil.close();
        this.cupTimerRealmUtil.close();
        this.rememberWordsRealmUtil.close();
        this.trueColorsRealmUtil.close();
    }

    public void onMathComplexityStartClick() {
        ((ITrainingPresenter) this.presenter).requestToSetNextFragment();
    }
}
