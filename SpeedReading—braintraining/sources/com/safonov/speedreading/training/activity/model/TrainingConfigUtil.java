package com.safonov.speedreading.training.activity.model;

import android.support.annotation.NonNull;
import com.safonov.speedreading.training.FragmentType;
import com.safonov.speedreading.training.TrainingType;
import com.safonov.speedreading.training.activity.ConcentrationConfigUtil;
import com.safonov.speedreading.training.activity.CupTimerConfigUtil;
import com.safonov.speedreading.training.activity.EvenNumbersConfigUtil;
import com.safonov.speedreading.training.activity.FlashWordsConfigUtil;
import com.safonov.speedreading.training.activity.GreenDotConfigUtil;
import com.safonov.speedreading.training.activity.LineOfSightConfigUtil;
import com.safonov.speedreading.training.activity.MathConfigUtil;
import com.safonov.speedreading.training.activity.RememberNumberConfigUtil;
import com.safonov.speedreading.training.activity.RememberWordsConfigUtil;
import com.safonov.speedreading.training.activity.SchulteTableConfigUtil;
import com.safonov.speedreading.training.activity.SpeedReadingConfigUtil;
import com.safonov.speedreading.training.activity.TrueColorsConfigUtil;
import com.safonov.speedreading.training.activity.WordBlockConfigUtil;
import com.safonov.speedreading.training.activity.WordPairsConfigUtil;
import com.safonov.speedreading.training.activity.WordsColumnsConfigUtil;
import com.safonov.speedreading.training.activity.model.ITrainingConfigUtil;
import com.safonov.speedreading.training.activity.model.entity.ConfigWrapper;
import com.safonov.speedreading.training.activity.model.entity.TrainingWrapper;
import com.safonov.speedreading.training.fragment.concentration.repository.IConcentrationRepository;
import com.safonov.speedreading.training.fragment.cuptimer.repository.ICupTimerRepository;
import com.safonov.speedreading.training.fragment.evennumbers.repository.IEvenNumberRepository;
import com.safonov.speedreading.training.fragment.flashword.repository.IFlashWordRepository;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
import com.safonov.speedreading.training.fragment.greendot.repository.IGreenDotRepository;
import com.safonov.speedreading.training.fragment.lineofsight.repository.ILineOfSightRepository;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
import com.safonov.speedreading.training.fragment.math.repository.IMathRepository;
import com.safonov.speedreading.training.fragment.remembernumber.repository.IRememberNumberRepository;
import com.safonov.speedreading.training.fragment.rememberwords.repository.IRememberWordsRepository;
import com.safonov.speedreading.training.fragment.schultetable.repository.ISchulteTableRepository;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
import com.safonov.speedreading.training.fragment.speedreading.repository.ISpeedReadingRepository;
import com.safonov.speedreading.training.fragment.truecolors.repository.ITrueColorsRepository;
import com.safonov.speedreading.training.fragment.wordpairs.repository.IWordPairsRepository;
import com.safonov.speedreading.training.fragment.wordsblock.repository.IWordBlockRepository;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.IWordsColumnsRepository;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;
import com.safonov.speedreading.training.util.preference.TrainingDescriptionUtil;
import com.safonov.speedreading.training.util.preference.TrainingSettingsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainingConfigUtil implements ITrainingConfigUtil {
    private IWordsColumnsRepository acceleratorRepository;
    private IConcentrationRepository concentrationRepository;
    private ICupTimerRepository cupTimerRepository;
    private IEvenNumberRepository evenNumberRepository;
    private IFlashWordRepository flashWordRepository;
    private IGreenDotRepository greenDotRepository;
    private ILineOfSightRepository lineOfSightRepository;
    private IMathRepository mathRepository;
    private IRememberNumberRepository rememberNumberRepository;
    private IRememberWordsRepository rememberWordsRepository;
    private ISchulteTableRepository schulteTableRepository;
    private ISpeedReadingRepository speedReadingRepository;
    private TrainingDescriptionUtil trainingDescriptionUtil;
    private TrainingSettingsUtil trainingSettingsUtil;
    private ITrueColorsRepository trueColorsRepository;
    private IWordBlockRepository wordBlockRepository;
    private IWordPairsRepository wordPairsRepository;

    public TrainingConfigUtil(TrainingSettingsUtil trainingSettingsUtil2, TrainingDescriptionUtil trainingDescriptionUtil2, IWordsColumnsRepository acceleratorRepository2, IWordBlockRepository wordBlockRepository2, IFlashWordRepository flashWordRepository2, ISchulteTableRepository schulteTableRepository2, IRememberNumberRepository rememberNumberRepository2, ILineOfSightRepository lineOfSightRepository2, ISpeedReadingRepository speedReadingRepository2, IEvenNumberRepository evenNumberRepository2, IWordPairsRepository wordPairsRepository2, IGreenDotRepository greenDotRepository2, IMathRepository mathRepository2, IConcentrationRepository concentrationRepository2, ICupTimerRepository cupTimerRepository2, IRememberWordsRepository rememberWordsRepository2, ITrueColorsRepository trueColorsRepository2) {
        this.trainingSettingsUtil = trainingSettingsUtil2;
        this.trainingDescriptionUtil = trainingDescriptionUtil2;
        this.acceleratorRepository = acceleratorRepository2;
        this.wordBlockRepository = wordBlockRepository2;
        this.flashWordRepository = flashWordRepository2;
        this.schulteTableRepository = schulteTableRepository2;
        this.rememberNumberRepository = rememberNumberRepository2;
        this.lineOfSightRepository = lineOfSightRepository2;
        this.speedReadingRepository = speedReadingRepository2;
        this.evenNumberRepository = evenNumberRepository2;
        this.wordPairsRepository = wordPairsRepository2;
        this.greenDotRepository = greenDotRepository2;
        this.mathRepository = mathRepository2;
        this.concentrationRepository = concentrationRepository2;
        this.cupTimerRepository = cupTimerRepository2;
        this.rememberWordsRepository = rememberWordsRepository2;
        this.trueColorsRepository = trueColorsRepository2;
    }

    /* access modifiers changed from: private */
    public List<FragmentType> getTrainingFragmentTypes(@NonNull TrainingType trainingType, boolean shouldShowDescription, boolean shouldShowInterstitial, boolean shouldShowComplexity) {
        List<FragmentType> trainingStack = new ArrayList<>();
        if (shouldShowInterstitial) {
            trainingStack.add(FragmentType.INTERSTITIAL);
        }
        if (shouldShowDescription) {
            FragmentType descriptionFragmentType = TrainingType.getReferenceDescriptionFragmentType(trainingType);
            if (this.trainingDescriptionUtil.shouldShowDescriptionFragment(descriptionFragmentType)) {
                trainingStack.add(descriptionFragmentType);
            }
        }
        if (shouldShowComplexity) {
            trainingStack.add(TrainingType.getReferenceComplexityFragmentType(trainingType));
        }
        trainingStack.add(FragmentType.PREPARE);
        trainingStack.add(TrainingType.getReferenceTrainingFragmentType(trainingType));
        return trainingStack;
    }

    /* access modifiers changed from: private */
    public boolean itemsAreNonNull(Object[] array) {
        for (Object object : array) {
            if (object == null) {
                return false;
            }
        }
        return true;
    }

    public void requestToGetCourseConfigList(@NonNull TrainingType courseType, ITrainingConfigUtil.CourseConfigResponseListener listener) {
        switch (courseType) {
            case PASS_COURSE:
                requestToGetPassCourseConfigList(listener);
                return;
            case ACCELERATOR_COURSE:
                requestToGetAcceleratorCourseConfigList(listener);
                return;
            default:
                return;
        }
    }

    private void requestToGetPassCourseConfigList(@NonNull final ITrainingConfigUtil.CourseConfigResponseListener listener) {
        final TrainingWrapper[] trainingWrappers = new TrainingWrapper[20];
        final SchulteTableConfig passCourseSchulteTableConfig1 = SchulteTableConfigUtil.getPassCourseType1Config();
        final SchulteTableConfig passCourseSchulteTableConfig2 = SchulteTableConfigUtil.getPassCourseType2Config();
        final ITrainingConfigUtil.CourseConfigResponseListener courseConfigResponseListener = listener;
        this.schulteTableRepository.addOrFindConfigs(new SchulteTableConfig[]{passCourseSchulteTableConfig1, passCourseSchulteTableConfig2}, new ISchulteTableRepository.OnMultiTransactionCallback() {
            public void onTransactionCompleted(int[] ids) {
                ConfigWrapper configWrapperType1 = new ConfigWrapper();
                configWrapperType1.setConfigId(ids[0]);
                configWrapperType1.setTrainingType(TrainingType.SCHULTE_TABLE);
                configWrapperType1.setFullscreen(passCourseSchulteTableConfig1.isFullscreen());
                ConfigWrapper configWrapperType2 = new ConfigWrapper();
                configWrapperType2.setConfigId(ids[1]);
                configWrapperType2.setTrainingType(TrainingType.SCHULTE_TABLE);
                configWrapperType2.setFullscreen(passCourseSchulteTableConfig2.isFullscreen());
                List<FragmentType> fragmentTypeListWithDescription = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.SCHULTE_TABLE, true, true, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.SCHULTE_TABLE, false, true, false);
                TrainingWrapper trainingWrapperType1WithDescription = new TrainingWrapper(configWrapperType1, fragmentTypeListWithDescription);
                TrainingWrapper trainingWrapperType1 = new TrainingWrapper(configWrapperType1, fragmentTypeList);
                TrainingWrapper trainingWrapperType2 = new TrainingWrapper(configWrapperType2, fragmentTypeList);
                trainingWrappers[0] = trainingWrapperType1WithDescription;
                Arrays.fill(trainingWrappers, 1, 5, trainingWrapperType1);
                Arrays.fill(trainingWrappers, 10, 15, trainingWrapperType2);
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrappers)) {
                    courseConfigResponseListener.onCourseConfigResponse(trainingWrappers);
                }
            }
        });
        this.rememberNumberRepository.addOrFindConfig(RememberNumberConfigUtil.getDefaultConfig(), new IRememberNumberRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.REMEMBER_NUMBER, id, false);
                List<FragmentType> fragmentTypeListWithDescription = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.REMEMBER_NUMBER, true, true, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.REMEMBER_NUMBER, false, true, false);
                TrainingWrapper trainingWrapperWithDescription = new TrainingWrapper(configWrapper, fragmentTypeListWithDescription);
                TrainingWrapper trainingWrapper = new TrainingWrapper(configWrapper, fragmentTypeList);
                trainingWrappers[5] = trainingWrapperWithDescription;
                trainingWrappers[15] = trainingWrapper;
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrappers)) {
                    listener.onCourseConfigResponse(trainingWrappers);
                }
            }
        });
        this.lineOfSightRepository.addOrFindConfigs(new LineOfSightConfig[]{LineOfSightConfigUtil.getPassCourseType1Config(), LineOfSightConfigUtil.getPassCourseType2Config(), LineOfSightConfigUtil.getPassCourseType3Config()}, new ILineOfSightRepository.OnMultiTransactionCallback() {
            public void onTransactionCompleted(int[] ids) {
                ConfigWrapper configWrapperType1 = new ConfigWrapper();
                configWrapperType1.setConfigId(ids[0]);
                configWrapperType1.setTrainingType(TrainingType.LINE_OF_SIGHT);
                configWrapperType1.setFullscreen(false);
                ConfigWrapper configWrapperType2 = new ConfigWrapper();
                configWrapperType2.setConfigId(ids[1]);
                configWrapperType2.setTrainingType(TrainingType.LINE_OF_SIGHT);
                configWrapperType2.setFullscreen(false);
                ConfigWrapper configWrapperType3 = new ConfigWrapper();
                configWrapperType3.setConfigId(ids[2]);
                configWrapperType3.setTrainingType(TrainingType.LINE_OF_SIGHT);
                configWrapperType3.setFullscreen(false);
                List<FragmentType> fragmentTypeListWithDescription = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.LINE_OF_SIGHT, true, true, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.LINE_OF_SIGHT, false, true, false);
                TrainingWrapper trainingWrapperType1 = new TrainingWrapper(configWrapperType1, fragmentTypeListWithDescription);
                TrainingWrapper trainingWrapperType2 = new TrainingWrapper(configWrapperType2, fragmentTypeList);
                TrainingWrapper trainingWrapperType3 = new TrainingWrapper(configWrapperType3, fragmentTypeList);
                trainingWrappers[6] = trainingWrapperType1;
                trainingWrappers[16] = trainingWrapperType2;
                trainingWrappers[17] = trainingWrapperType3;
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrappers)) {
                    listener.onCourseConfigResponse(trainingWrappers);
                }
            }
        });
        this.speedReadingRepository.addOrFindConfig(SpeedReadingConfigUtil.getDefaultConfig(), new ISpeedReadingRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.SPEED_READING, id, false);
                List<FragmentType> fragmentTypeListWithDescription = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.SPEED_READING, true, true, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.SPEED_READING, false, true, false);
                TrainingWrapper trainingWrapper1 = new TrainingWrapper(configWrapper, fragmentTypeListWithDescription);
                TrainingWrapper trainingWrapper2 = new TrainingWrapper(configWrapper, fragmentTypeList);
                trainingWrappers[7] = trainingWrapper1;
                trainingWrappers[18] = trainingWrapper2;
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrappers)) {
                    listener.onCourseConfigResponse(trainingWrappers);
                }
            }
        });
        this.wordPairsRepository.addOrFindConfig(WordPairsConfigUtil.getDefaultConfig(), new IWordPairsRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                trainingWrappers[8] = new TrainingWrapper(new ConfigWrapper(TrainingType.WORD_PAIRS, id, false), TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.WORD_PAIRS, true, true, false));
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrappers)) {
                    listener.onCourseConfigResponse(trainingWrappers);
                }
            }
        });
        this.evenNumberRepository.addOrFindConfig(EvenNumbersConfigUtil.getDefaultConfig(), new IEvenNumberRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                trainingWrappers[9] = new TrainingWrapper(new ConfigWrapper(TrainingType.EVEN_NUMBERS, id, false), TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.EVEN_NUMBERS, true, true, false));
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrappers)) {
                    listener.onCourseConfigResponse(trainingWrappers);
                }
            }
        });
        this.greenDotRepository.addOrFindConfig(GreenDotConfigUtil.getPassCourseConfig(), new IGreenDotRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                trainingWrappers[19] = new TrainingWrapper(new ConfigWrapper(TrainingType.GREEN_DOT, id, true), TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.GREEN_DOT, true, true, false));
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrappers)) {
                    listener.onCourseConfigResponse(trainingWrappers);
                }
            }
        });
    }

    private void requestToGetAcceleratorCourseConfigList(@NonNull final ITrainingConfigUtil.CourseConfigResponseListener listener) {
        final TrainingWrapper[] trainingWrapperArray = new TrainingWrapper[9];
        this.acceleratorRepository.addOrFindConfigs(new WordsColumnsConfig[]{WordsColumnsConfigUtil.getAcceleratorCourseType1Config(), WordsColumnsConfigUtil.getAcceleratorCourseType2Config(), WordsColumnsConfigUtil.getAcceleratorCourseType3Config(), WordsColumnsConfigUtil.getAcceleratorCourseType4Config(), WordsColumnsConfigUtil.getAcceleratorCourseType5Config()}, new IWordsColumnsRepository.OnMultiTransactionCallback() {
            public void onTransactionCompleted(int[] ids) {
                List<FragmentType> fragmentTypeListWithDescription = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.WORDS_COLUMNS, true, true, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.WORDS_COLUMNS, false, true, false);
                ConfigWrapper configWrapper = new ConfigWrapper();
                configWrapper.setTrainingType(TrainingType.WORDS_COLUMNS);
                configWrapper.setConfigId(ids[0]);
                configWrapper.setFullscreen(false);
                trainingWrapperArray[0] = new TrainingWrapper(configWrapper, fragmentTypeListWithDescription);
                trainingWrapperArray[0] = new TrainingWrapper(configWrapper, fragmentTypeList);
                for (int i = 1; i < ids.length; i++) {
                    ConfigWrapper configWrapper2 = new ConfigWrapper();
                    configWrapper2.setTrainingType(TrainingType.WORDS_COLUMNS);
                    configWrapper2.setConfigId(ids[i]);
                    configWrapper2.setFullscreen(false);
                    trainingWrapperArray[i] = new TrainingWrapper(configWrapper2, fragmentTypeList);
                }
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrapperArray)) {
                    listener.onCourseConfigResponse(trainingWrapperArray);
                }
            }
        });
        this.flashWordRepository.addOrFindConfigs(new FlashWordsConfig[]{FlashWordsConfigUtil.getAcceleratorCourse1Config(), FlashWordsConfigUtil.getAcceleratorCourse2Config(), FlashWordsConfigUtil.getAcceleratorCourse3Config()}, new IFlashWordRepository.OnMultiTransactionCallback() {
            public void onTransactionCompleted(int[] ids) {
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.FLASH_WORDS, false, true, false);
                int idIndex = 0;
                for (int i = 5; i <= 7; i++) {
                    ConfigWrapper configWrapper = new ConfigWrapper();
                    configWrapper.setTrainingType(TrainingType.FLASH_WORDS);
                    configWrapper.setFullscreen(false);
                    configWrapper.setConfigId(ids[idIndex]);
                    idIndex++;
                    trainingWrapperArray[i] = new TrainingWrapper(configWrapper, fragmentTypeList);
                }
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrapperArray)) {
                    listener.onCourseConfigResponse(trainingWrapperArray);
                }
            }
        });
        this.wordBlockRepository.addOrFindConfig(WordBlockConfigUtil.getDefaultConfig(), new IWordBlockRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.WORDS_BLOCK, false, true, false);
                trainingWrapperArray[8] = new TrainingWrapper(new ConfigWrapper(TrainingType.WORDS_BLOCK, id, false), fragmentTypeList);
                if (TrainingConfigUtil.this.itemsAreNonNull(trainingWrapperArray)) {
                    listener.onCourseConfigResponse(trainingWrapperArray);
                }
            }
        });
    }

    public void requestToGetTrainingConfig(@NonNull TrainingType trainingType, ITrainingConfigUtil.ConfigResponseListener listener) {
        switch (trainingType) {
            case WORDS_COLUMNS:
                requestToGetAcceleratorConfig(listener);
                return;
            case WORDS_BLOCK:
                requestToGetWordBlockConfig(listener);
                return;
            case FLASH_WORDS:
                requestToGetFlashWordsConfig(listener);
                return;
            case SCHULTE_TABLE:
                requestToGetSchulteTableConfig(listener);
                return;
            case REMEMBER_NUMBER:
                requestToGetRememberNumberConfig(listener);
                return;
            case LINE_OF_SIGHT:
                requestToGetLineOfSightConfig(listener);
                return;
            case SPEED_READING:
                requestToGetSpeedReadingConfig(listener);
                return;
            case WORD_PAIRS:
                requestToGetWordPairsConfig(listener);
                return;
            case EVEN_NUMBERS:
                requestToGetEvenNumbersConfig(listener);
                return;
            case GREEN_DOT:
                requestToGreenDotConfig(listener);
                return;
            case MATHEMATICS:
                requestToGetMathConfig(listener);
                return;
            case CONCENTRATION:
                requestToGetConcentrationConfig(listener);
                return;
            case CUPTIMER:
                requestToGetCupTimerConfig(listener);
                return;
            case REMEMBER_WORDS:
                requestToGetRememberWordsConfig(listener);
                return;
            case TRUE_COLORS:
                requestToGetTrueColorsConfig(listener);
                return;
            default:
                return;
        }
    }

    private void requestToGetAcceleratorConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.acceleratorRepository.addOrFindConfig(WordsColumnsConfigUtil.getUserConfig(this.trainingSettingsUtil.getWordsColumnsColumnCount(), this.trainingSettingsUtil.getWordsColumnsDuration()), new IWordsColumnsRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.WORDS_COLUMNS, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.WORDS_COLUMNS, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetWordBlockConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.wordBlockRepository.addOrFindConfig(WordBlockConfigUtil.getDefaultConfig(), new IWordBlockRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.WORDS_BLOCK, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.WORDS_BLOCK, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetFlashWordsConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.flashWordRepository.addOrFindConfig(FlashWordsConfigUtil.getUserConfig(this.trainingSettingsUtil.getFlashWordsBoardType(), this.trainingSettingsUtil.getFlashWordsDuration()), new IFlashWordRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.FLASH_WORDS, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.FLASH_WORDS, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetSchulteTableConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        int rowCount = this.trainingSettingsUtil.getSchulteTableRowCount();
        int columnCount = this.trainingSettingsUtil.getSchulteTableColumnCount();
        final boolean isFullscreen = this.trainingSettingsUtil.isSchulteTableFullscreen();
        this.schulteTableRepository.addOrFindConfig(SchulteTableConfigUtil.getUserConfig(rowCount, columnCount, isFullscreen), new ISchulteTableRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.SCHULTE_TABLE, id, isFullscreen);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.SCHULTE_TABLE, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetRememberNumberConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.rememberNumberRepository.addOrFindConfig(RememberNumberConfigUtil.getDefaultConfig(), new IRememberNumberRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.REMEMBER_NUMBER, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.REMEMBER_NUMBER, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetLineOfSightConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.lineOfSightRepository.addOrFindConfig(LineOfSightConfigUtil.getUserConfig(this.trainingSettingsUtil.getLineOfSightRowCount(), this.trainingSettingsUtil.getLineOfSightFieldType()), new ILineOfSightRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.LINE_OF_SIGHT, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.LINE_OF_SIGHT, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetSpeedReadingConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.speedReadingRepository.addOrFindConfig(SpeedReadingConfigUtil.getDefaultConfig(), new ISpeedReadingRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.SPEED_READING, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.SPEED_READING, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetWordPairsConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.wordPairsRepository.addOrFindConfig(WordPairsConfigUtil.getDefaultConfig(), new IWordPairsRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.WORD_PAIRS, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.WORD_PAIRS, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetEvenNumbersConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.evenNumberRepository.addOrFindConfig(EvenNumbersConfigUtil.getDefaultConfig(), new IEvenNumberRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.EVEN_NUMBERS, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.EVEN_NUMBERS, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGreenDotConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.greenDotRepository.addOrFindConfig(GreenDotConfigUtil.getUserConfig(this.trainingSettingsUtil.getGreenDotDuration()), new IGreenDotRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.GREEN_DOT, id, true);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.GREEN_DOT, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetMathConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.mathRepository.addOrFindConfig(MathConfigUtil.getDefaultConfig(this.trainingSettingsUtil.getMathDuration()), new IMathRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.MATHEMATICS, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.MATHEMATICS, true, false, true);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetConcentrationConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.concentrationRepository.addOrFindConfig(ConcentrationConfigUtil.getDefaultConfig(), new IConcentrationRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.CONCENTRATION, id, true);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.CONCENTRATION, true, false, true);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetCupTimerConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.cupTimerRepository.addOrFindConfig(CupTimerConfigUtil.getUserConfig(this.trainingSettingsUtil.getCupTimerDuration(), this.trainingSettingsUtil.getCupTimerType()), new ICupTimerRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.CUPTIMER, id, true);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.CUPTIMER, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetRememberWordsConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.rememberWordsRepository.addOrFindConfig(RememberWordsConfigUtil.getDefaultConfig(), new IRememberWordsRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.REMEMBER_WORDS, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.REMEMBER_WORDS, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }

    private void requestToGetTrueColorsConfig(final ITrainingConfigUtil.ConfigResponseListener listener) {
        this.trueColorsRepository.addOrFindConfig(TrueColorsConfigUtil.getDefaultConfig(), new ITrueColorsRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                ConfigWrapper configWrapper = new ConfigWrapper(TrainingType.TRUE_COLORS, id, false);
                List<FragmentType> fragmentTypeList = TrainingConfigUtil.this.getTrainingFragmentTypes(TrainingType.TRUE_COLORS, true, false, false);
                if (listener != null) {
                    listener.onConfigResponse(new TrainingWrapper(configWrapper, fragmentTypeList));
                }
            }
        });
    }
}
