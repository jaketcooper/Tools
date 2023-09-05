package p006io.realm;

import android.util.JsonReader;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerConfig;
import com.safonov.speedreading.training.fragment.cuptimer.repository.entity.CupTimerResult;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersConfig;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotConfig;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightConfig;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathResult;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsConfig;
import com.safonov.speedreading.training.fragment.rememberwords.repository.entity.RememberWordsResult;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableConfig;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingConfig;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsConfig;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockConfig;
import com.safonov.speedreading.training.fragment.wordsblock.repository.entity.WordBlockResult;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsConfig;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.entity.WordsColumnsResult;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p006io.realm.BaseRealm;
import p006io.realm.annotations.RealmModule;
import p006io.realm.internal.ColumnInfo;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.RealmProxyMediator;
import p006io.realm.internal.Row;
import p006io.realm.internal.SharedRealm;
import p006io.realm.internal.Table;

@RealmModule
/* renamed from: io.realm.DefaultRealmModuleMediator */
class DefaultRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    public boolean transformerApplied() {
        return true;
    }

    DefaultRealmModuleMediator() {
    }

    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<>();
        modelClasses.add(MathConfig.class);
        modelClasses.add(SpeedReadingResult.class);
        modelClasses.add(LineOfSightConfig.class);
        modelClasses.add(CupTimerResult.class);
        modelClasses.add(EvenNumbersConfig.class);
        modelClasses.add(WordPairsResult.class);
        modelClasses.add(GreenDotResult.class);
        modelClasses.add(ConcentrationConfig.class);
        modelClasses.add(PassCourseResult.class);
        modelClasses.add(RememberNumberConfig.class);
        modelClasses.add(WordBlockConfig.class);
        modelClasses.add(FlashWordsConfig.class);
        modelClasses.add(GreenDotConfig.class);
        modelClasses.add(RememberNumberResult.class);
        modelClasses.add(WordPairsConfig.class);
        modelClasses.add(CupTimerConfig.class);
        modelClasses.add(LineOfSightResult.class);
        modelClasses.add(EvenNumbersResult.class);
        modelClasses.add(SpeedReadingConfig.class);
        modelClasses.add(WordsColumnsResult.class);
        modelClasses.add(MathResult.class);
        modelClasses.add(WordsColumnsConfig.class);
        modelClasses.add(ConcentrationResult.class);
        modelClasses.add(SchulteTableConfig.class);
        modelClasses.add(FlashWordResult.class);
        modelClasses.add(SchulteTableResult.class);
        modelClasses.add(RememberWordsResult.class);
        modelClasses.add(TrueColorsResult.class);
        modelClasses.add(RememberWordsConfig.class);
        modelClasses.add(TrueColorsConfig.class);
        modelClasses.add(WordBlockResult.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);
        if (clazz.equals(MathConfig.class)) {
            return MathConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(SpeedReadingResult.class)) {
            return SpeedReadingResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(LineOfSightConfig.class)) {
            return LineOfSightConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(CupTimerResult.class)) {
            return CupTimerResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(EvenNumbersConfig.class)) {
            return EvenNumbersConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(WordPairsResult.class)) {
            return WordPairsResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(GreenDotResult.class)) {
            return GreenDotResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(PassCourseResult.class)) {
            return PassCourseResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(WordBlockConfig.class)) {
            return WordBlockConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(GreenDotConfig.class)) {
            return GreenDotConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(WordPairsConfig.class)) {
            return WordPairsConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(CupTimerConfig.class)) {
            return CupTimerConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(LineOfSightResult.class)) {
            return LineOfSightResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(EvenNumbersResult.class)) {
            return EvenNumbersResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(SpeedReadingConfig.class)) {
            return SpeedReadingConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(MathResult.class)) {
            return MathResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(SchulteTableConfig.class)) {
            return SchulteTableConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(SchulteTableResult.class)) {
            return SchulteTableResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(RememberWordsResult.class)) {
            return RememberWordsResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(RememberWordsConfig.class)) {
            return RememberWordsConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(WordBlockResult.class)) {
            return WordBlockResultRealmProxy.initTable(sharedRealm);
        }
        throw getMissingProxyClassException(clazz);
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);
        if (clazz.equals(MathConfig.class)) {
            return MathConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(SpeedReadingResult.class)) {
            return SpeedReadingResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(LineOfSightConfig.class)) {
            return LineOfSightConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(CupTimerResult.class)) {
            return CupTimerResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(EvenNumbersConfig.class)) {
            return EvenNumbersConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(WordPairsResult.class)) {
            return WordPairsResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(GreenDotResult.class)) {
            return GreenDotResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(PassCourseResult.class)) {
            return PassCourseResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(WordBlockConfig.class)) {
            return WordBlockConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(GreenDotConfig.class)) {
            return GreenDotConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(WordPairsConfig.class)) {
            return WordPairsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(CupTimerConfig.class)) {
            return CupTimerConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(LineOfSightResult.class)) {
            return LineOfSightResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(EvenNumbersResult.class)) {
            return EvenNumbersResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(SpeedReadingConfig.class)) {
            return SpeedReadingConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(MathResult.class)) {
            return MathResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(SchulteTableConfig.class)) {
            return SchulteTableConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(SchulteTableResult.class)) {
            return SchulteTableResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(RememberWordsResult.class)) {
            return RememberWordsResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(RememberWordsConfig.class)) {
            return RememberWordsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(WordBlockResult.class)) {
            return WordBlockResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);
        if (clazz.equals(MathConfig.class)) {
            return MathConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(SpeedReadingResult.class)) {
            return SpeedReadingResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(LineOfSightConfig.class)) {
            return LineOfSightConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(CupTimerResult.class)) {
            return CupTimerResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(EvenNumbersConfig.class)) {
            return EvenNumbersConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(WordPairsResult.class)) {
            return WordPairsResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(GreenDotResult.class)) {
            return GreenDotResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(PassCourseResult.class)) {
            return PassCourseResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(WordBlockConfig.class)) {
            return WordBlockConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(GreenDotConfig.class)) {
            return GreenDotConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(WordPairsConfig.class)) {
            return WordPairsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(CupTimerConfig.class)) {
            return CupTimerConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(LineOfSightResult.class)) {
            return LineOfSightResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(EvenNumbersResult.class)) {
            return EvenNumbersResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(SpeedReadingConfig.class)) {
            return SpeedReadingConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(MathResult.class)) {
            return MathResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(SchulteTableConfig.class)) {
            return SchulteTableConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(SchulteTableResult.class)) {
            return SchulteTableResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RememberWordsResult.class)) {
            return RememberWordsResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RememberWordsConfig.class)) {
            return RememberWordsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(WordBlockResult.class)) {
            return WordBlockResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(MathConfig.class)) {
            return MathConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(SpeedReadingResult.class)) {
            return SpeedReadingResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(LineOfSightConfig.class)) {
            return LineOfSightConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(CupTimerResult.class)) {
            return CupTimerResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(EvenNumbersConfig.class)) {
            return EvenNumbersConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(WordPairsResult.class)) {
            return WordPairsResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(GreenDotResult.class)) {
            return GreenDotResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(PassCourseResult.class)) {
            return PassCourseResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(WordBlockConfig.class)) {
            return WordBlockConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(GreenDotConfig.class)) {
            return GreenDotConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(WordPairsConfig.class)) {
            return WordPairsConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(CupTimerConfig.class)) {
            return CupTimerConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(LineOfSightResult.class)) {
            return LineOfSightResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(EvenNumbersResult.class)) {
            return EvenNumbersResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(SpeedReadingConfig.class)) {
            return SpeedReadingConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(MathResult.class)) {
            return MathResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(SchulteTableConfig.class)) {
            return SchulteTableConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(SchulteTableResult.class)) {
            return SchulteTableResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(RememberWordsResult.class)) {
            return RememberWordsResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(RememberWordsConfig.class)) {
            return RememberWordsConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(WordBlockResult.class)) {
            return WordBlockResultRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(MathConfig.class)) {
            return MathConfigRealmProxy.getTableName();
        }
        if (clazz.equals(SpeedReadingResult.class)) {
            return SpeedReadingResultRealmProxy.getTableName();
        }
        if (clazz.equals(LineOfSightConfig.class)) {
            return LineOfSightConfigRealmProxy.getTableName();
        }
        if (clazz.equals(CupTimerResult.class)) {
            return CupTimerResultRealmProxy.getTableName();
        }
        if (clazz.equals(EvenNumbersConfig.class)) {
            return EvenNumbersConfigRealmProxy.getTableName();
        }
        if (clazz.equals(WordPairsResult.class)) {
            return WordPairsResultRealmProxy.getTableName();
        }
        if (clazz.equals(GreenDotResult.class)) {
            return GreenDotResultRealmProxy.getTableName();
        }
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.getTableName();
        }
        if (clazz.equals(PassCourseResult.class)) {
            return PassCourseResultRealmProxy.getTableName();
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.getTableName();
        }
        if (clazz.equals(WordBlockConfig.class)) {
            return WordBlockConfigRealmProxy.getTableName();
        }
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.getTableName();
        }
        if (clazz.equals(GreenDotConfig.class)) {
            return GreenDotConfigRealmProxy.getTableName();
        }
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.getTableName();
        }
        if (clazz.equals(WordPairsConfig.class)) {
            return WordPairsConfigRealmProxy.getTableName();
        }
        if (clazz.equals(CupTimerConfig.class)) {
            return CupTimerConfigRealmProxy.getTableName();
        }
        if (clazz.equals(LineOfSightResult.class)) {
            return LineOfSightResultRealmProxy.getTableName();
        }
        if (clazz.equals(EvenNumbersResult.class)) {
            return EvenNumbersResultRealmProxy.getTableName();
        }
        if (clazz.equals(SpeedReadingConfig.class)) {
            return SpeedReadingConfigRealmProxy.getTableName();
        }
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.getTableName();
        }
        if (clazz.equals(MathResult.class)) {
            return MathResultRealmProxy.getTableName();
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.getTableName();
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.getTableName();
        }
        if (clazz.equals(SchulteTableConfig.class)) {
            return SchulteTableConfigRealmProxy.getTableName();
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.getTableName();
        }
        if (clazz.equals(SchulteTableResult.class)) {
            return SchulteTableResultRealmProxy.getTableName();
        }
        if (clazz.equals(RememberWordsResult.class)) {
            return RememberWordsResultRealmProxy.getTableName();
        }
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.getTableName();
        }
        if (clazz.equals(RememberWordsConfig.class)) {
            return RememberWordsConfigRealmProxy.getTableName();
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.getTableName();
        }
        if (clazz.equals(WordBlockResult.class)) {
            return WordBlockResultRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        E e;
        BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);
            if (clazz.equals(MathConfig.class)) {
                e = (RealmModel) clazz.cast(new MathConfigRealmProxy());
            } else if (clazz.equals(SpeedReadingResult.class)) {
                e = (RealmModel) clazz.cast(new SpeedReadingResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(LineOfSightConfig.class)) {
                e = (RealmModel) clazz.cast(new LineOfSightConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(CupTimerResult.class)) {
                e = (RealmModel) clazz.cast(new CupTimerResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(EvenNumbersConfig.class)) {
                e = (RealmModel) clazz.cast(new EvenNumbersConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(WordPairsResult.class)) {
                e = (RealmModel) clazz.cast(new WordPairsResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(GreenDotResult.class)) {
                e = (RealmModel) clazz.cast(new GreenDotResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(ConcentrationConfig.class)) {
                e = (RealmModel) clazz.cast(new ConcentrationConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(PassCourseResult.class)) {
                e = (RealmModel) clazz.cast(new PassCourseResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(RememberNumberConfig.class)) {
                e = (RealmModel) clazz.cast(new RememberNumberConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(WordBlockConfig.class)) {
                e = (RealmModel) clazz.cast(new WordBlockConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(FlashWordsConfig.class)) {
                e = (RealmModel) clazz.cast(new FlashWordsConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(GreenDotConfig.class)) {
                e = (RealmModel) clazz.cast(new GreenDotConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(RememberNumberResult.class)) {
                e = (RealmModel) clazz.cast(new RememberNumberResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(WordPairsConfig.class)) {
                e = (RealmModel) clazz.cast(new WordPairsConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(CupTimerConfig.class)) {
                e = (RealmModel) clazz.cast(new CupTimerConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(LineOfSightResult.class)) {
                e = (RealmModel) clazz.cast(new LineOfSightResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(EvenNumbersResult.class)) {
                e = (RealmModel) clazz.cast(new EvenNumbersResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(SpeedReadingConfig.class)) {
                e = (RealmModel) clazz.cast(new SpeedReadingConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(WordsColumnsResult.class)) {
                e = (RealmModel) clazz.cast(new WordsColumnsResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(MathResult.class)) {
                e = (RealmModel) clazz.cast(new MathResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(WordsColumnsConfig.class)) {
                e = (RealmModel) clazz.cast(new WordsColumnsConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(ConcentrationResult.class)) {
                e = (RealmModel) clazz.cast(new ConcentrationResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(SchulteTableConfig.class)) {
                e = (RealmModel) clazz.cast(new SchulteTableConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(FlashWordResult.class)) {
                e = (RealmModel) clazz.cast(new FlashWordResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(SchulteTableResult.class)) {
                e = (RealmModel) clazz.cast(new SchulteTableResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(RememberWordsResult.class)) {
                e = (RealmModel) clazz.cast(new RememberWordsResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(TrueColorsResult.class)) {
                e = (RealmModel) clazz.cast(new TrueColorsResultRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(RememberWordsConfig.class)) {
                e = (RealmModel) clazz.cast(new RememberWordsConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(TrueColorsConfig.class)) {
                e = (RealmModel) clazz.cast(new TrueColorsConfigRealmProxy());
                objectContext.clear();
            } else if (clazz.equals(WordBlockResult.class)) {
                e = (RealmModel) clazz.cast(new WordBlockResultRealmProxy());
                objectContext.clear();
            } else {
                throw getMissingProxyClassException(clazz);
            }
            return e;
        } finally {
            objectContext.clear();
        }
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        Class<?> superclass = obj instanceof RealmObjectProxy ? obj.getClass().getSuperclass() : obj.getClass();
        if (superclass.equals(MathConfig.class)) {
            return (RealmModel) superclass.cast(MathConfigRealmProxy.copyOrUpdate(realm, (MathConfig) obj, update, cache));
        }
        if (superclass.equals(SpeedReadingResult.class)) {
            return (RealmModel) superclass.cast(SpeedReadingResultRealmProxy.copyOrUpdate(realm, (SpeedReadingResult) obj, update, cache));
        }
        if (superclass.equals(LineOfSightConfig.class)) {
            return (RealmModel) superclass.cast(LineOfSightConfigRealmProxy.copyOrUpdate(realm, (LineOfSightConfig) obj, update, cache));
        }
        if (superclass.equals(CupTimerResult.class)) {
            return (RealmModel) superclass.cast(CupTimerResultRealmProxy.copyOrUpdate(realm, (CupTimerResult) obj, update, cache));
        }
        if (superclass.equals(EvenNumbersConfig.class)) {
            return (RealmModel) superclass.cast(EvenNumbersConfigRealmProxy.copyOrUpdate(realm, (EvenNumbersConfig) obj, update, cache));
        }
        if (superclass.equals(WordPairsResult.class)) {
            return (RealmModel) superclass.cast(WordPairsResultRealmProxy.copyOrUpdate(realm, (WordPairsResult) obj, update, cache));
        }
        if (superclass.equals(GreenDotResult.class)) {
            return (RealmModel) superclass.cast(GreenDotResultRealmProxy.copyOrUpdate(realm, (GreenDotResult) obj, update, cache));
        }
        if (superclass.equals(ConcentrationConfig.class)) {
            return (RealmModel) superclass.cast(ConcentrationConfigRealmProxy.copyOrUpdate(realm, (ConcentrationConfig) obj, update, cache));
        }
        if (superclass.equals(PassCourseResult.class)) {
            return (RealmModel) superclass.cast(PassCourseResultRealmProxy.copyOrUpdate(realm, (PassCourseResult) obj, update, cache));
        }
        if (superclass.equals(RememberNumberConfig.class)) {
            return (RealmModel) superclass.cast(RememberNumberConfigRealmProxy.copyOrUpdate(realm, (RememberNumberConfig) obj, update, cache));
        }
        if (superclass.equals(WordBlockConfig.class)) {
            return (RealmModel) superclass.cast(WordBlockConfigRealmProxy.copyOrUpdate(realm, (WordBlockConfig) obj, update, cache));
        }
        if (superclass.equals(FlashWordsConfig.class)) {
            return (RealmModel) superclass.cast(FlashWordsConfigRealmProxy.copyOrUpdate(realm, (FlashWordsConfig) obj, update, cache));
        }
        if (superclass.equals(GreenDotConfig.class)) {
            return (RealmModel) superclass.cast(GreenDotConfigRealmProxy.copyOrUpdate(realm, (GreenDotConfig) obj, update, cache));
        }
        if (superclass.equals(RememberNumberResult.class)) {
            return (RealmModel) superclass.cast(RememberNumberResultRealmProxy.copyOrUpdate(realm, (RememberNumberResult) obj, update, cache));
        }
        if (superclass.equals(WordPairsConfig.class)) {
            return (RealmModel) superclass.cast(WordPairsConfigRealmProxy.copyOrUpdate(realm, (WordPairsConfig) obj, update, cache));
        }
        if (superclass.equals(CupTimerConfig.class)) {
            return (RealmModel) superclass.cast(CupTimerConfigRealmProxy.copyOrUpdate(realm, (CupTimerConfig) obj, update, cache));
        }
        if (superclass.equals(LineOfSightResult.class)) {
            return (RealmModel) superclass.cast(LineOfSightResultRealmProxy.copyOrUpdate(realm, (LineOfSightResult) obj, update, cache));
        }
        if (superclass.equals(EvenNumbersResult.class)) {
            return (RealmModel) superclass.cast(EvenNumbersResultRealmProxy.copyOrUpdate(realm, (EvenNumbersResult) obj, update, cache));
        }
        if (superclass.equals(SpeedReadingConfig.class)) {
            return (RealmModel) superclass.cast(SpeedReadingConfigRealmProxy.copyOrUpdate(realm, (SpeedReadingConfig) obj, update, cache));
        }
        if (superclass.equals(WordsColumnsResult.class)) {
            return (RealmModel) superclass.cast(WordsColumnsResultRealmProxy.copyOrUpdate(realm, (WordsColumnsResult) obj, update, cache));
        }
        if (superclass.equals(MathResult.class)) {
            return (RealmModel) superclass.cast(MathResultRealmProxy.copyOrUpdate(realm, (MathResult) obj, update, cache));
        }
        if (superclass.equals(WordsColumnsConfig.class)) {
            return (RealmModel) superclass.cast(WordsColumnsConfigRealmProxy.copyOrUpdate(realm, (WordsColumnsConfig) obj, update, cache));
        }
        if (superclass.equals(ConcentrationResult.class)) {
            return (RealmModel) superclass.cast(ConcentrationResultRealmProxy.copyOrUpdate(realm, (ConcentrationResult) obj, update, cache));
        }
        if (superclass.equals(SchulteTableConfig.class)) {
            return (RealmModel) superclass.cast(SchulteTableConfigRealmProxy.copyOrUpdate(realm, (SchulteTableConfig) obj, update, cache));
        }
        if (superclass.equals(FlashWordResult.class)) {
            return (RealmModel) superclass.cast(FlashWordResultRealmProxy.copyOrUpdate(realm, (FlashWordResult) obj, update, cache));
        }
        if (superclass.equals(SchulteTableResult.class)) {
            return (RealmModel) superclass.cast(SchulteTableResultRealmProxy.copyOrUpdate(realm, (SchulteTableResult) obj, update, cache));
        }
        if (superclass.equals(RememberWordsResult.class)) {
            return (RealmModel) superclass.cast(RememberWordsResultRealmProxy.copyOrUpdate(realm, (RememberWordsResult) obj, update, cache));
        }
        if (superclass.equals(TrueColorsResult.class)) {
            return (RealmModel) superclass.cast(TrueColorsResultRealmProxy.copyOrUpdate(realm, (TrueColorsResult) obj, update, cache));
        }
        if (superclass.equals(RememberWordsConfig.class)) {
            return (RealmModel) superclass.cast(RememberWordsConfigRealmProxy.copyOrUpdate(realm, (RememberWordsConfig) obj, update, cache));
        }
        if (superclass.equals(TrueColorsConfig.class)) {
            return (RealmModel) superclass.cast(TrueColorsConfigRealmProxy.copyOrUpdate(realm, (TrueColorsConfig) obj, update, cache));
        }
        if (superclass.equals(WordBlockResult.class)) {
            return (RealmModel) superclass.cast(WordBlockResultRealmProxy.copyOrUpdate(realm, (WordBlockResult) obj, update, cache));
        }
        throw getMissingProxyClassException(superclass);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
        if (superclass.equals(MathConfig.class)) {
            MathConfigRealmProxy.insert(realm, (MathConfig) object, cache);
        } else if (superclass.equals(SpeedReadingResult.class)) {
            SpeedReadingResultRealmProxy.insert(realm, (SpeedReadingResult) object, cache);
        } else if (superclass.equals(LineOfSightConfig.class)) {
            LineOfSightConfigRealmProxy.insert(realm, (LineOfSightConfig) object, cache);
        } else if (superclass.equals(CupTimerResult.class)) {
            CupTimerResultRealmProxy.insert(realm, (CupTimerResult) object, cache);
        } else if (superclass.equals(EvenNumbersConfig.class)) {
            EvenNumbersConfigRealmProxy.insert(realm, (EvenNumbersConfig) object, cache);
        } else if (superclass.equals(WordPairsResult.class)) {
            WordPairsResultRealmProxy.insert(realm, (WordPairsResult) object, cache);
        } else if (superclass.equals(GreenDotResult.class)) {
            GreenDotResultRealmProxy.insert(realm, (GreenDotResult) object, cache);
        } else if (superclass.equals(ConcentrationConfig.class)) {
            ConcentrationConfigRealmProxy.insert(realm, (ConcentrationConfig) object, cache);
        } else if (superclass.equals(PassCourseResult.class)) {
            PassCourseResultRealmProxy.insert(realm, (PassCourseResult) object, cache);
        } else if (superclass.equals(RememberNumberConfig.class)) {
            RememberNumberConfigRealmProxy.insert(realm, (RememberNumberConfig) object, cache);
        } else if (superclass.equals(WordBlockConfig.class)) {
            WordBlockConfigRealmProxy.insert(realm, (WordBlockConfig) object, cache);
        } else if (superclass.equals(FlashWordsConfig.class)) {
            FlashWordsConfigRealmProxy.insert(realm, (FlashWordsConfig) object, cache);
        } else if (superclass.equals(GreenDotConfig.class)) {
            GreenDotConfigRealmProxy.insert(realm, (GreenDotConfig) object, cache);
        } else if (superclass.equals(RememberNumberResult.class)) {
            RememberNumberResultRealmProxy.insert(realm, (RememberNumberResult) object, cache);
        } else if (superclass.equals(WordPairsConfig.class)) {
            WordPairsConfigRealmProxy.insert(realm, (WordPairsConfig) object, cache);
        } else if (superclass.equals(CupTimerConfig.class)) {
            CupTimerConfigRealmProxy.insert(realm, (CupTimerConfig) object, cache);
        } else if (superclass.equals(LineOfSightResult.class)) {
            LineOfSightResultRealmProxy.insert(realm, (LineOfSightResult) object, cache);
        } else if (superclass.equals(EvenNumbersResult.class)) {
            EvenNumbersResultRealmProxy.insert(realm, (EvenNumbersResult) object, cache);
        } else if (superclass.equals(SpeedReadingConfig.class)) {
            SpeedReadingConfigRealmProxy.insert(realm, (SpeedReadingConfig) object, cache);
        } else if (superclass.equals(WordsColumnsResult.class)) {
            WordsColumnsResultRealmProxy.insert(realm, (WordsColumnsResult) object, cache);
        } else if (superclass.equals(MathResult.class)) {
            MathResultRealmProxy.insert(realm, (MathResult) object, cache);
        } else if (superclass.equals(WordsColumnsConfig.class)) {
            WordsColumnsConfigRealmProxy.insert(realm, (WordsColumnsConfig) object, cache);
        } else if (superclass.equals(ConcentrationResult.class)) {
            ConcentrationResultRealmProxy.insert(realm, (ConcentrationResult) object, cache);
        } else if (superclass.equals(SchulteTableConfig.class)) {
            SchulteTableConfigRealmProxy.insert(realm, (SchulteTableConfig) object, cache);
        } else if (superclass.equals(FlashWordResult.class)) {
            FlashWordResultRealmProxy.insert(realm, (FlashWordResult) object, cache);
        } else if (superclass.equals(SchulteTableResult.class)) {
            SchulteTableResultRealmProxy.insert(realm, (SchulteTableResult) object, cache);
        } else if (superclass.equals(RememberWordsResult.class)) {
            RememberWordsResultRealmProxy.insert(realm, (RememberWordsResult) object, cache);
        } else if (superclass.equals(TrueColorsResult.class)) {
            TrueColorsResultRealmProxy.insert(realm, (TrueColorsResult) object, cache);
        } else if (superclass.equals(RememberWordsConfig.class)) {
            RememberWordsConfigRealmProxy.insert(realm, (RememberWordsConfig) object, cache);
        } else if (superclass.equals(TrueColorsConfig.class)) {
            TrueColorsConfigRealmProxy.insert(realm, (TrueColorsConfig) object, cache);
        } else if (superclass.equals(WordBlockResult.class)) {
            WordBlockResultRealmProxy.insert(realm, (WordBlockResult) object, cache);
        } else {
            throw getMissingProxyClassException(superclass);
        }
    }

    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        Map<RealmModel, Long> cache = new HashMap<>(objects.size());
        if (iterator.hasNext()) {
            RealmModel object = (RealmModel) iterator.next();
            Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
            if (superclass.equals(MathConfig.class)) {
                MathConfigRealmProxy.insert(realm, (MathConfig) object, cache);
            } else if (superclass.equals(SpeedReadingResult.class)) {
                SpeedReadingResultRealmProxy.insert(realm, (SpeedReadingResult) object, cache);
            } else if (superclass.equals(LineOfSightConfig.class)) {
                LineOfSightConfigRealmProxy.insert(realm, (LineOfSightConfig) object, cache);
            } else if (superclass.equals(CupTimerResult.class)) {
                CupTimerResultRealmProxy.insert(realm, (CupTimerResult) object, cache);
            } else if (superclass.equals(EvenNumbersConfig.class)) {
                EvenNumbersConfigRealmProxy.insert(realm, (EvenNumbersConfig) object, cache);
            } else if (superclass.equals(WordPairsResult.class)) {
                WordPairsResultRealmProxy.insert(realm, (WordPairsResult) object, cache);
            } else if (superclass.equals(GreenDotResult.class)) {
                GreenDotResultRealmProxy.insert(realm, (GreenDotResult) object, cache);
            } else if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insert(realm, (ConcentrationConfig) object, cache);
            } else if (superclass.equals(PassCourseResult.class)) {
                PassCourseResultRealmProxy.insert(realm, (PassCourseResult) object, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insert(realm, (RememberNumberConfig) object, cache);
            } else if (superclass.equals(WordBlockConfig.class)) {
                WordBlockConfigRealmProxy.insert(realm, (WordBlockConfig) object, cache);
            } else if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insert(realm, (FlashWordsConfig) object, cache);
            } else if (superclass.equals(GreenDotConfig.class)) {
                GreenDotConfigRealmProxy.insert(realm, (GreenDotConfig) object, cache);
            } else if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insert(realm, (RememberNumberResult) object, cache);
            } else if (superclass.equals(WordPairsConfig.class)) {
                WordPairsConfigRealmProxy.insert(realm, (WordPairsConfig) object, cache);
            } else if (superclass.equals(CupTimerConfig.class)) {
                CupTimerConfigRealmProxy.insert(realm, (CupTimerConfig) object, cache);
            } else if (superclass.equals(LineOfSightResult.class)) {
                LineOfSightResultRealmProxy.insert(realm, (LineOfSightResult) object, cache);
            } else if (superclass.equals(EvenNumbersResult.class)) {
                EvenNumbersResultRealmProxy.insert(realm, (EvenNumbersResult) object, cache);
            } else if (superclass.equals(SpeedReadingConfig.class)) {
                SpeedReadingConfigRealmProxy.insert(realm, (SpeedReadingConfig) object, cache);
            } else if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insert(realm, (WordsColumnsResult) object, cache);
            } else if (superclass.equals(MathResult.class)) {
                MathResultRealmProxy.insert(realm, (MathResult) object, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insert(realm, (WordsColumnsConfig) object, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insert(realm, (ConcentrationResult) object, cache);
            } else if (superclass.equals(SchulteTableConfig.class)) {
                SchulteTableConfigRealmProxy.insert(realm, (SchulteTableConfig) object, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insert(realm, (FlashWordResult) object, cache);
            } else if (superclass.equals(SchulteTableResult.class)) {
                SchulteTableResultRealmProxy.insert(realm, (SchulteTableResult) object, cache);
            } else if (superclass.equals(RememberWordsResult.class)) {
                RememberWordsResultRealmProxy.insert(realm, (RememberWordsResult) object, cache);
            } else if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insert(realm, (TrueColorsResult) object, cache);
            } else if (superclass.equals(RememberWordsConfig.class)) {
                RememberWordsConfigRealmProxy.insert(realm, (RememberWordsConfig) object, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insert(realm, (TrueColorsConfig) object, cache);
            } else if (superclass.equals(WordBlockResult.class)) {
                WordBlockResultRealmProxy.insert(realm, (WordBlockResult) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(MathConfig.class)) {
                MathConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(SpeedReadingResult.class)) {
                SpeedReadingResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(LineOfSightConfig.class)) {
                LineOfSightConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(CupTimerResult.class)) {
                CupTimerResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(EvenNumbersConfig.class)) {
                EvenNumbersConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(WordPairsResult.class)) {
                WordPairsResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(GreenDotResult.class)) {
                GreenDotResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(PassCourseResult.class)) {
                PassCourseResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(WordBlockConfig.class)) {
                WordBlockConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(GreenDotConfig.class)) {
                GreenDotConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(WordPairsConfig.class)) {
                WordPairsConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(CupTimerConfig.class)) {
                CupTimerConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(LineOfSightResult.class)) {
                LineOfSightResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(EvenNumbersResult.class)) {
                EvenNumbersResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(SpeedReadingConfig.class)) {
                SpeedReadingConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(MathResult.class)) {
                MathResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(SchulteTableConfig.class)) {
                SchulteTableConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(SchulteTableResult.class)) {
                SchulteTableResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(RememberWordsResult.class)) {
                RememberWordsResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(RememberWordsConfig.class)) {
                RememberWordsConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(WordBlockResult.class)) {
                WordBlockResultRealmProxy.insert(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        Class<?> superclass = obj instanceof RealmObjectProxy ? obj.getClass().getSuperclass() : obj.getClass();
        if (superclass.equals(MathConfig.class)) {
            MathConfigRealmProxy.insertOrUpdate(realm, (MathConfig) obj, cache);
        } else if (superclass.equals(SpeedReadingResult.class)) {
            SpeedReadingResultRealmProxy.insertOrUpdate(realm, (SpeedReadingResult) obj, cache);
        } else if (superclass.equals(LineOfSightConfig.class)) {
            LineOfSightConfigRealmProxy.insertOrUpdate(realm, (LineOfSightConfig) obj, cache);
        } else if (superclass.equals(CupTimerResult.class)) {
            CupTimerResultRealmProxy.insertOrUpdate(realm, (CupTimerResult) obj, cache);
        } else if (superclass.equals(EvenNumbersConfig.class)) {
            EvenNumbersConfigRealmProxy.insertOrUpdate(realm, (EvenNumbersConfig) obj, cache);
        } else if (superclass.equals(WordPairsResult.class)) {
            WordPairsResultRealmProxy.insertOrUpdate(realm, (WordPairsResult) obj, cache);
        } else if (superclass.equals(GreenDotResult.class)) {
            GreenDotResultRealmProxy.insertOrUpdate(realm, (GreenDotResult) obj, cache);
        } else if (superclass.equals(ConcentrationConfig.class)) {
            ConcentrationConfigRealmProxy.insertOrUpdate(realm, (ConcentrationConfig) obj, cache);
        } else if (superclass.equals(PassCourseResult.class)) {
            PassCourseResultRealmProxy.insertOrUpdate(realm, (PassCourseResult) obj, cache);
        } else if (superclass.equals(RememberNumberConfig.class)) {
            RememberNumberConfigRealmProxy.insertOrUpdate(realm, (RememberNumberConfig) obj, cache);
        } else if (superclass.equals(WordBlockConfig.class)) {
            WordBlockConfigRealmProxy.insertOrUpdate(realm, (WordBlockConfig) obj, cache);
        } else if (superclass.equals(FlashWordsConfig.class)) {
            FlashWordsConfigRealmProxy.insertOrUpdate(realm, (FlashWordsConfig) obj, cache);
        } else if (superclass.equals(GreenDotConfig.class)) {
            GreenDotConfigRealmProxy.insertOrUpdate(realm, (GreenDotConfig) obj, cache);
        } else if (superclass.equals(RememberNumberResult.class)) {
            RememberNumberResultRealmProxy.insertOrUpdate(realm, (RememberNumberResult) obj, cache);
        } else if (superclass.equals(WordPairsConfig.class)) {
            WordPairsConfigRealmProxy.insertOrUpdate(realm, (WordPairsConfig) obj, cache);
        } else if (superclass.equals(CupTimerConfig.class)) {
            CupTimerConfigRealmProxy.insertOrUpdate(realm, (CupTimerConfig) obj, cache);
        } else if (superclass.equals(LineOfSightResult.class)) {
            LineOfSightResultRealmProxy.insertOrUpdate(realm, (LineOfSightResult) obj, cache);
        } else if (superclass.equals(EvenNumbersResult.class)) {
            EvenNumbersResultRealmProxy.insertOrUpdate(realm, (EvenNumbersResult) obj, cache);
        } else if (superclass.equals(SpeedReadingConfig.class)) {
            SpeedReadingConfigRealmProxy.insertOrUpdate(realm, (SpeedReadingConfig) obj, cache);
        } else if (superclass.equals(WordsColumnsResult.class)) {
            WordsColumnsResultRealmProxy.insertOrUpdate(realm, (WordsColumnsResult) obj, cache);
        } else if (superclass.equals(MathResult.class)) {
            MathResultRealmProxy.insertOrUpdate(realm, (MathResult) obj, cache);
        } else if (superclass.equals(WordsColumnsConfig.class)) {
            WordsColumnsConfigRealmProxy.insertOrUpdate(realm, (WordsColumnsConfig) obj, cache);
        } else if (superclass.equals(ConcentrationResult.class)) {
            ConcentrationResultRealmProxy.insertOrUpdate(realm, (ConcentrationResult) obj, cache);
        } else if (superclass.equals(SchulteTableConfig.class)) {
            SchulteTableConfigRealmProxy.insertOrUpdate(realm, (SchulteTableConfig) obj, cache);
        } else if (superclass.equals(FlashWordResult.class)) {
            FlashWordResultRealmProxy.insertOrUpdate(realm, (FlashWordResult) obj, cache);
        } else if (superclass.equals(SchulteTableResult.class)) {
            SchulteTableResultRealmProxy.insertOrUpdate(realm, (SchulteTableResult) obj, cache);
        } else if (superclass.equals(RememberWordsResult.class)) {
            RememberWordsResultRealmProxy.insertOrUpdate(realm, (RememberWordsResult) obj, cache);
        } else if (superclass.equals(TrueColorsResult.class)) {
            TrueColorsResultRealmProxy.insertOrUpdate(realm, (TrueColorsResult) obj, cache);
        } else if (superclass.equals(RememberWordsConfig.class)) {
            RememberWordsConfigRealmProxy.insertOrUpdate(realm, (RememberWordsConfig) obj, cache);
        } else if (superclass.equals(TrueColorsConfig.class)) {
            TrueColorsConfigRealmProxy.insertOrUpdate(realm, (TrueColorsConfig) obj, cache);
        } else if (superclass.equals(WordBlockResult.class)) {
            WordBlockResultRealmProxy.insertOrUpdate(realm, (WordBlockResult) obj, cache);
        } else {
            throw getMissingProxyClassException(superclass);
        }
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        Map<RealmModel, Long> cache = new HashMap<>(objects.size());
        if (iterator.hasNext()) {
            RealmModel object = (RealmModel) iterator.next();
            Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
            if (superclass.equals(MathConfig.class)) {
                MathConfigRealmProxy.insertOrUpdate(realm, (MathConfig) object, cache);
            } else if (superclass.equals(SpeedReadingResult.class)) {
                SpeedReadingResultRealmProxy.insertOrUpdate(realm, (SpeedReadingResult) object, cache);
            } else if (superclass.equals(LineOfSightConfig.class)) {
                LineOfSightConfigRealmProxy.insertOrUpdate(realm, (LineOfSightConfig) object, cache);
            } else if (superclass.equals(CupTimerResult.class)) {
                CupTimerResultRealmProxy.insertOrUpdate(realm, (CupTimerResult) object, cache);
            } else if (superclass.equals(EvenNumbersConfig.class)) {
                EvenNumbersConfigRealmProxy.insertOrUpdate(realm, (EvenNumbersConfig) object, cache);
            } else if (superclass.equals(WordPairsResult.class)) {
                WordPairsResultRealmProxy.insertOrUpdate(realm, (WordPairsResult) object, cache);
            } else if (superclass.equals(GreenDotResult.class)) {
                GreenDotResultRealmProxy.insertOrUpdate(realm, (GreenDotResult) object, cache);
            } else if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insertOrUpdate(realm, (ConcentrationConfig) object, cache);
            } else if (superclass.equals(PassCourseResult.class)) {
                PassCourseResultRealmProxy.insertOrUpdate(realm, (PassCourseResult) object, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insertOrUpdate(realm, (RememberNumberConfig) object, cache);
            } else if (superclass.equals(WordBlockConfig.class)) {
                WordBlockConfigRealmProxy.insertOrUpdate(realm, (WordBlockConfig) object, cache);
            } else if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insertOrUpdate(realm, (FlashWordsConfig) object, cache);
            } else if (superclass.equals(GreenDotConfig.class)) {
                GreenDotConfigRealmProxy.insertOrUpdate(realm, (GreenDotConfig) object, cache);
            } else if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insertOrUpdate(realm, (RememberNumberResult) object, cache);
            } else if (superclass.equals(WordPairsConfig.class)) {
                WordPairsConfigRealmProxy.insertOrUpdate(realm, (WordPairsConfig) object, cache);
            } else if (superclass.equals(CupTimerConfig.class)) {
                CupTimerConfigRealmProxy.insertOrUpdate(realm, (CupTimerConfig) object, cache);
            } else if (superclass.equals(LineOfSightResult.class)) {
                LineOfSightResultRealmProxy.insertOrUpdate(realm, (LineOfSightResult) object, cache);
            } else if (superclass.equals(EvenNumbersResult.class)) {
                EvenNumbersResultRealmProxy.insertOrUpdate(realm, (EvenNumbersResult) object, cache);
            } else if (superclass.equals(SpeedReadingConfig.class)) {
                SpeedReadingConfigRealmProxy.insertOrUpdate(realm, (SpeedReadingConfig) object, cache);
            } else if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insertOrUpdate(realm, (WordsColumnsResult) object, cache);
            } else if (superclass.equals(MathResult.class)) {
                MathResultRealmProxy.insertOrUpdate(realm, (MathResult) object, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insertOrUpdate(realm, (WordsColumnsConfig) object, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insertOrUpdate(realm, (ConcentrationResult) object, cache);
            } else if (superclass.equals(SchulteTableConfig.class)) {
                SchulteTableConfigRealmProxy.insertOrUpdate(realm, (SchulteTableConfig) object, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insertOrUpdate(realm, (FlashWordResult) object, cache);
            } else if (superclass.equals(SchulteTableResult.class)) {
                SchulteTableResultRealmProxy.insertOrUpdate(realm, (SchulteTableResult) object, cache);
            } else if (superclass.equals(RememberWordsResult.class)) {
                RememberWordsResultRealmProxy.insertOrUpdate(realm, (RememberWordsResult) object, cache);
            } else if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insertOrUpdate(realm, (TrueColorsResult) object, cache);
            } else if (superclass.equals(RememberWordsConfig.class)) {
                RememberWordsConfigRealmProxy.insertOrUpdate(realm, (RememberWordsConfig) object, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insertOrUpdate(realm, (TrueColorsConfig) object, cache);
            } else if (superclass.equals(WordBlockResult.class)) {
                WordBlockResultRealmProxy.insertOrUpdate(realm, (WordBlockResult) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(MathConfig.class)) {
                MathConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(SpeedReadingResult.class)) {
                SpeedReadingResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(LineOfSightConfig.class)) {
                LineOfSightConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(CupTimerResult.class)) {
                CupTimerResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(EvenNumbersConfig.class)) {
                EvenNumbersConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(WordPairsResult.class)) {
                WordPairsResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(GreenDotResult.class)) {
                GreenDotResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(PassCourseResult.class)) {
                PassCourseResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(WordBlockConfig.class)) {
                WordBlockConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(GreenDotConfig.class)) {
                GreenDotConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(WordPairsConfig.class)) {
                WordPairsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(CupTimerConfig.class)) {
                CupTimerConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(LineOfSightResult.class)) {
                LineOfSightResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(EvenNumbersResult.class)) {
                EvenNumbersResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(SpeedReadingConfig.class)) {
                SpeedReadingConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(MathResult.class)) {
                MathResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(SchulteTableConfig.class)) {
                SchulteTableConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(SchulteTableResult.class)) {
                SchulteTableResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(RememberWordsResult.class)) {
                RememberWordsResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(RememberWordsConfig.class)) {
                RememberWordsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(WordBlockResult.class)) {
                WordBlockResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        checkClass(clazz);
        if (clazz.equals(MathConfig.class)) {
            return (RealmModel) clazz.cast(MathConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(SpeedReadingResult.class)) {
            return (RealmModel) clazz.cast(SpeedReadingResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(LineOfSightConfig.class)) {
            return (RealmModel) clazz.cast(LineOfSightConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(CupTimerResult.class)) {
            return (RealmModel) clazz.cast(CupTimerResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(EvenNumbersConfig.class)) {
            return (RealmModel) clazz.cast(EvenNumbersConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(WordPairsResult.class)) {
            return (RealmModel) clazz.cast(WordPairsResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(GreenDotResult.class)) {
            return (RealmModel) clazz.cast(GreenDotResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(ConcentrationConfig.class)) {
            return (RealmModel) clazz.cast(ConcentrationConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(PassCourseResult.class)) {
            return (RealmModel) clazz.cast(PassCourseResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return (RealmModel) clazz.cast(RememberNumberConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(WordBlockConfig.class)) {
            return (RealmModel) clazz.cast(WordBlockConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(FlashWordsConfig.class)) {
            return (RealmModel) clazz.cast(FlashWordsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(GreenDotConfig.class)) {
            return (RealmModel) clazz.cast(GreenDotConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(RememberNumberResult.class)) {
            return (RealmModel) clazz.cast(RememberNumberResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(WordPairsConfig.class)) {
            return (RealmModel) clazz.cast(WordPairsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(CupTimerConfig.class)) {
            return (RealmModel) clazz.cast(CupTimerConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(LineOfSightResult.class)) {
            return (RealmModel) clazz.cast(LineOfSightResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(EvenNumbersResult.class)) {
            return (RealmModel) clazz.cast(EvenNumbersResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(SpeedReadingConfig.class)) {
            return (RealmModel) clazz.cast(SpeedReadingConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(WordsColumnsResult.class)) {
            return (RealmModel) clazz.cast(WordsColumnsResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(MathResult.class)) {
            return (RealmModel) clazz.cast(MathResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return (RealmModel) clazz.cast(WordsColumnsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return (RealmModel) clazz.cast(ConcentrationResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(SchulteTableConfig.class)) {
            return (RealmModel) clazz.cast(SchulteTableConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(FlashWordResult.class)) {
            return (RealmModel) clazz.cast(FlashWordResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(SchulteTableResult.class)) {
            return (RealmModel) clazz.cast(SchulteTableResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(RememberWordsResult.class)) {
            return (RealmModel) clazz.cast(RememberWordsResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(TrueColorsResult.class)) {
            return (RealmModel) clazz.cast(TrueColorsResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(RememberWordsConfig.class)) {
            return (RealmModel) clazz.cast(RememberWordsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return (RealmModel) clazz.cast(TrueColorsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(WordBlockResult.class)) {
            return (RealmModel) clazz.cast(WordBlockResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        checkClass(clazz);
        if (clazz.equals(MathConfig.class)) {
            return (RealmModel) clazz.cast(MathConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(SpeedReadingResult.class)) {
            return (RealmModel) clazz.cast(SpeedReadingResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(LineOfSightConfig.class)) {
            return (RealmModel) clazz.cast(LineOfSightConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(CupTimerResult.class)) {
            return (RealmModel) clazz.cast(CupTimerResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(EvenNumbersConfig.class)) {
            return (RealmModel) clazz.cast(EvenNumbersConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(WordPairsResult.class)) {
            return (RealmModel) clazz.cast(WordPairsResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(GreenDotResult.class)) {
            return (RealmModel) clazz.cast(GreenDotResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(ConcentrationConfig.class)) {
            return (RealmModel) clazz.cast(ConcentrationConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(PassCourseResult.class)) {
            return (RealmModel) clazz.cast(PassCourseResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return (RealmModel) clazz.cast(RememberNumberConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(WordBlockConfig.class)) {
            return (RealmModel) clazz.cast(WordBlockConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(FlashWordsConfig.class)) {
            return (RealmModel) clazz.cast(FlashWordsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(GreenDotConfig.class)) {
            return (RealmModel) clazz.cast(GreenDotConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(RememberNumberResult.class)) {
            return (RealmModel) clazz.cast(RememberNumberResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(WordPairsConfig.class)) {
            return (RealmModel) clazz.cast(WordPairsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(CupTimerConfig.class)) {
            return (RealmModel) clazz.cast(CupTimerConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(LineOfSightResult.class)) {
            return (RealmModel) clazz.cast(LineOfSightResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(EvenNumbersResult.class)) {
            return (RealmModel) clazz.cast(EvenNumbersResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(SpeedReadingConfig.class)) {
            return (RealmModel) clazz.cast(SpeedReadingConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(WordsColumnsResult.class)) {
            return (RealmModel) clazz.cast(WordsColumnsResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(MathResult.class)) {
            return (RealmModel) clazz.cast(MathResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return (RealmModel) clazz.cast(WordsColumnsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return (RealmModel) clazz.cast(ConcentrationResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(SchulteTableConfig.class)) {
            return (RealmModel) clazz.cast(SchulteTableConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(FlashWordResult.class)) {
            return (RealmModel) clazz.cast(FlashWordResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(SchulteTableResult.class)) {
            return (RealmModel) clazz.cast(SchulteTableResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(RememberWordsResult.class)) {
            return (RealmModel) clazz.cast(RememberWordsResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(TrueColorsResult.class)) {
            return (RealmModel) clazz.cast(TrueColorsResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(RememberWordsConfig.class)) {
            return (RealmModel) clazz.cast(RememberWordsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return (RealmModel) clazz.cast(TrueColorsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(WordBlockResult.class)) {
            return (RealmModel) clazz.cast(WordBlockResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        Class<? super Object> superclass = realmObject.getClass().getSuperclass();
        if (superclass.equals(MathConfig.class)) {
            return (RealmModel) superclass.cast(MathConfigRealmProxy.createDetachedCopy((MathConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(SpeedReadingResult.class)) {
            return (RealmModel) superclass.cast(SpeedReadingResultRealmProxy.createDetachedCopy((SpeedReadingResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(LineOfSightConfig.class)) {
            return (RealmModel) superclass.cast(LineOfSightConfigRealmProxy.createDetachedCopy((LineOfSightConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(CupTimerResult.class)) {
            return (RealmModel) superclass.cast(CupTimerResultRealmProxy.createDetachedCopy((CupTimerResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(EvenNumbersConfig.class)) {
            return (RealmModel) superclass.cast(EvenNumbersConfigRealmProxy.createDetachedCopy((EvenNumbersConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(WordPairsResult.class)) {
            return (RealmModel) superclass.cast(WordPairsResultRealmProxy.createDetachedCopy((WordPairsResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(GreenDotResult.class)) {
            return (RealmModel) superclass.cast(GreenDotResultRealmProxy.createDetachedCopy((GreenDotResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(ConcentrationConfig.class)) {
            return (RealmModel) superclass.cast(ConcentrationConfigRealmProxy.createDetachedCopy((ConcentrationConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(PassCourseResult.class)) {
            return (RealmModel) superclass.cast(PassCourseResultRealmProxy.createDetachedCopy((PassCourseResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(RememberNumberConfig.class)) {
            return (RealmModel) superclass.cast(RememberNumberConfigRealmProxy.createDetachedCopy((RememberNumberConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(WordBlockConfig.class)) {
            return (RealmModel) superclass.cast(WordBlockConfigRealmProxy.createDetachedCopy((WordBlockConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(FlashWordsConfig.class)) {
            return (RealmModel) superclass.cast(FlashWordsConfigRealmProxy.createDetachedCopy((FlashWordsConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(GreenDotConfig.class)) {
            return (RealmModel) superclass.cast(GreenDotConfigRealmProxy.createDetachedCopy((GreenDotConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(RememberNumberResult.class)) {
            return (RealmModel) superclass.cast(RememberNumberResultRealmProxy.createDetachedCopy((RememberNumberResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(WordPairsConfig.class)) {
            return (RealmModel) superclass.cast(WordPairsConfigRealmProxy.createDetachedCopy((WordPairsConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(CupTimerConfig.class)) {
            return (RealmModel) superclass.cast(CupTimerConfigRealmProxy.createDetachedCopy((CupTimerConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(LineOfSightResult.class)) {
            return (RealmModel) superclass.cast(LineOfSightResultRealmProxy.createDetachedCopy((LineOfSightResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(EvenNumbersResult.class)) {
            return (RealmModel) superclass.cast(EvenNumbersResultRealmProxy.createDetachedCopy((EvenNumbersResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(SpeedReadingConfig.class)) {
            return (RealmModel) superclass.cast(SpeedReadingConfigRealmProxy.createDetachedCopy((SpeedReadingConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(WordsColumnsResult.class)) {
            return (RealmModel) superclass.cast(WordsColumnsResultRealmProxy.createDetachedCopy((WordsColumnsResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(MathResult.class)) {
            return (RealmModel) superclass.cast(MathResultRealmProxy.createDetachedCopy((MathResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(WordsColumnsConfig.class)) {
            return (RealmModel) superclass.cast(WordsColumnsConfigRealmProxy.createDetachedCopy((WordsColumnsConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(ConcentrationResult.class)) {
            return (RealmModel) superclass.cast(ConcentrationResultRealmProxy.createDetachedCopy((ConcentrationResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(SchulteTableConfig.class)) {
            return (RealmModel) superclass.cast(SchulteTableConfigRealmProxy.createDetachedCopy((SchulteTableConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(FlashWordResult.class)) {
            return (RealmModel) superclass.cast(FlashWordResultRealmProxy.createDetachedCopy((FlashWordResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(SchulteTableResult.class)) {
            return (RealmModel) superclass.cast(SchulteTableResultRealmProxy.createDetachedCopy((SchulteTableResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(RememberWordsResult.class)) {
            return (RealmModel) superclass.cast(RememberWordsResultRealmProxy.createDetachedCopy((RememberWordsResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(TrueColorsResult.class)) {
            return (RealmModel) superclass.cast(TrueColorsResultRealmProxy.createDetachedCopy((TrueColorsResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(RememberWordsConfig.class)) {
            return (RealmModel) superclass.cast(RememberWordsConfigRealmProxy.createDetachedCopy((RememberWordsConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(TrueColorsConfig.class)) {
            return (RealmModel) superclass.cast(TrueColorsConfigRealmProxy.createDetachedCopy((TrueColorsConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(WordBlockResult.class)) {
            return (RealmModel) superclass.cast(WordBlockResultRealmProxy.createDetachedCopy((WordBlockResult) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(superclass);
    }
}
