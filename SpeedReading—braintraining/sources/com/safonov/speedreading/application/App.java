package com.safonov.speedreading.application;

import android.app.Application;
import com.google.android.gms.ads.MobileAds;
import com.safonov.speedreading.application.util.BookUtil;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.purchase.view.PurchaseActivity_2;
import com.safonov.speedreading.training.fragment.concentration.repository.ConcentrationRealmModule;
import com.safonov.speedreading.training.fragment.cuptimer.repository.CupTimerRealmModule;
import com.safonov.speedreading.training.fragment.evennumbers.repository.EvenNumbersRealmModule;
import com.safonov.speedreading.training.fragment.flashword.repository.FlashWordRealmModule;
import com.safonov.speedreading.training.fragment.greendot.repository.GreenDotRealmModule;
import com.safonov.speedreading.training.fragment.lineofsight.repository.LineOfSightRealmModule;
import com.safonov.speedreading.training.fragment.math.repository.MathRealmModule;
import com.safonov.speedreading.training.fragment.passcource.repository.PassCourseRealmModule;
import com.safonov.speedreading.training.fragment.remembernumber.repository.RememberNumberRealmModule;
import com.safonov.speedreading.training.fragment.rememberwords.repository.RememberWordsRealmModule;
import com.safonov.speedreading.training.fragment.schultetable.repository.SchulteTableRealmModule;
import com.safonov.speedreading.training.fragment.speedreading.repository.SpeedReadingRealmModule;
import com.safonov.speedreading.training.fragment.truecolors.repository.TrueColorsRealmModule;
import com.safonov.speedreading.training.fragment.wordpairs.repository.WordPairsRealmModule;
import com.safonov.speedreading.training.fragment.wordsblock.repository.WordBlockRealmModule;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.WordsColumnsRealmModule;
import javax.annotation.Nonnull;
import org.solovyev.android.checkout.Billing;
import p006io.realm.Realm;
import p006io.realm.RealmConfiguration;
import p006io.realm.exceptions.RealmFileException;
import p006io.realm.exceptions.RealmMigrationNeededException;

public class App extends Application {
    private static App instance;
    @Nonnull
    private final Billing billing = new Billing(this, new Billing.DefaultConfiguration() {
        @Nonnull
        public String getPublicKey() {
            return PurchaseActivity_2.publicKey;
        }
    });
    private BookUtil bookUtil;
    private RealmConfiguration concentrationConfiguration;
    private RealmConfiguration cupTimerConfiguration;
    private RealmConfiguration evenNumbersConfiguration;
    private RealmConfiguration flashWordsConfiguration;
    private RealmConfiguration greenDotConfiguration;
    private RealmConfiguration lineOfSightConfiguration;
    private RealmConfiguration mathConfiguration;
    private RealmConfiguration passCourseConfiguration;
    private PremiumUtil premiumUtil;
    private RealmConfiguration rememberNumberConfiguration;
    private RealmConfiguration rememberWordsConfiguration;
    private RealmConfiguration schulteTableConfiguration;
    private RealmConfiguration speedReadingConfiguration;
    private RealmConfiguration trueColorsConfiguration;
    private RealmConfiguration wordBlockConfiguration;
    private RealmConfiguration wordPairsConfiguration;
    private RealmConfiguration wordsColumnsConfiguration;

    public PremiumUtil getPremiumUtil() {
        return this.premiumUtil;
    }

    public BookUtil getBookUtil() {
        return this.bookUtil;
    }

    @Nonnull
    public Billing getBilling() {
        return this.billing;
    }

    public static App get() {
        return instance;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
        this.premiumUtil = new PremiumUtil(this);
        this.bookUtil = new BookUtil(this);
        Realm.init(this);
        MobileAds.initialize(this, "ca-app-pub-1214906094509332~3275388209");
        this.passCourseConfiguration = new RealmConfiguration.Builder().name("passcourse.realm").modules(new PassCourseRealmModule(), new Object[0]).schemaVersion(5).deleteRealmIfMigrationNeeded().build();
        this.wordsColumnsConfiguration = new RealmConfiguration.Builder().name("wordscolumns.realm").modules(new WordsColumnsRealmModule(), new Object[0]).build();
        this.wordBlockConfiguration = new RealmConfiguration.Builder().name("wordblock.realm").modules(new WordBlockRealmModule(), new Object[0]).schemaVersion(1).deleteRealmIfMigrationNeeded().build();
        this.flashWordsConfiguration = new RealmConfiguration.Builder().name("flashwords.realm").modules(new FlashWordRealmModule(), new Object[0]).schemaVersion(1).deleteRealmIfMigrationNeeded().build();
        this.schulteTableConfiguration = new RealmConfiguration.Builder().name("schultetable.realm").modules(new SchulteTableRealmModule(), new Object[0]).build();
        this.rememberNumberConfiguration = new RealmConfiguration.Builder().name("remembernumber.realm").modules(new RememberNumberRealmModule(), new Object[0]).build();
        this.lineOfSightConfiguration = new RealmConfiguration.Builder().name("lineofsight.realm").modules(new LineOfSightRealmModule(), new Object[0]).build();
        this.speedReadingConfiguration = new RealmConfiguration.Builder().name("speedreading.realm").modules(new SpeedReadingRealmModule(), new Object[0]).build();
        this.wordPairsConfiguration = new RealmConfiguration.Builder().name("wordpairs.realm").modules(new WordPairsRealmModule(), new Object[0]).build();
        this.evenNumbersConfiguration = new RealmConfiguration.Builder().name("evennumbers.realm").modules(new EvenNumbersRealmModule(), new Object[0]).build();
        this.greenDotConfiguration = new RealmConfiguration.Builder().name("greendot.realm").modules(new GreenDotRealmModule(), new Object[0]).build();
        this.mathConfiguration = new RealmConfiguration.Builder().name("math.realm").modules(new MathRealmModule(), new Object[0]).schemaVersion(2).deleteRealmIfMigrationNeeded().build();
        this.concentrationConfiguration = new RealmConfiguration.Builder().name("concentration.realm").modules(new ConcentrationRealmModule(), new Object[0]).schemaVersion(5).deleteRealmIfMigrationNeeded().build();
        this.cupTimerConfiguration = new RealmConfiguration.Builder().name("cuptimer.realm").modules(new CupTimerRealmModule(), new Object[0]).schemaVersion(4).deleteRealmIfMigrationNeeded().build();
        this.rememberWordsConfiguration = new RealmConfiguration.Builder().name("rememberwords.realm").modules(new RememberWordsRealmModule(), new Object[0]).schemaVersion(1).deleteRealmIfMigrationNeeded().build();
        this.trueColorsConfiguration = new RealmConfiguration.Builder().name("truecolors.realm").modules(new TrueColorsRealmModule(), new Object[0]).schemaVersion(1).deleteRealmIfMigrationNeeded().build();
    }

    public Realm getPassCourseConfiguration() {
        try {
            return Realm.getInstance(this.passCourseConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.passCourseConfiguration);
            return Realm.getInstance(this.passCourseConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.passCourseConfiguration);
            return Realm.getInstance(this.passCourseConfiguration);
        }
    }

    public Realm getWordsColumnsRealm() {
        try {
            return Realm.getInstance(this.wordsColumnsConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.wordsColumnsConfiguration);
            return Realm.getInstance(this.wordsColumnsConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.wordsColumnsConfiguration);
            return Realm.getInstance(this.wordsColumnsConfiguration);
        }
    }

    public Realm getWordBlockRealm() {
        try {
            return Realm.getInstance(this.wordBlockConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.wordBlockConfiguration);
            return Realm.getInstance(this.wordBlockConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.wordBlockConfiguration);
            return Realm.getInstance(this.wordBlockConfiguration);
        }
    }

    public Realm getFlashWordsRealm() {
        try {
            return Realm.getInstance(this.flashWordsConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.flashWordsConfiguration);
            return Realm.getInstance(this.flashWordsConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.flashWordsConfiguration);
            return Realm.getInstance(this.flashWordsConfiguration);
        }
    }

    public Realm getSchulteTableRealm() {
        try {
            return Realm.getInstance(this.schulteTableConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.schulteTableConfiguration);
            return Realm.getInstance(this.schulteTableConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.schulteTableConfiguration);
            return Realm.getInstance(this.schulteTableConfiguration);
        }
    }

    public Realm getRememberNumberRealm() {
        try {
            return Realm.getInstance(this.rememberNumberConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.rememberNumberConfiguration);
            return Realm.getInstance(this.rememberNumberConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.rememberNumberConfiguration);
            return Realm.getInstance(this.rememberNumberConfiguration);
        }
    }

    public Realm getLineOfSightRealm() {
        try {
            return Realm.getInstance(this.lineOfSightConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.lineOfSightConfiguration);
            return Realm.getInstance(this.lineOfSightConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.lineOfSightConfiguration);
            return Realm.getInstance(this.lineOfSightConfiguration);
        }
    }

    public Realm getSpeedReadingRealm() {
        try {
            return Realm.getInstance(this.speedReadingConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.speedReadingConfiguration);
            return Realm.getInstance(this.speedReadingConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.speedReadingConfiguration);
            return Realm.getInstance(this.speedReadingConfiguration);
        }
    }

    public Realm getWordPairsRealm() {
        try {
            return Realm.getInstance(this.wordPairsConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.wordPairsConfiguration);
            return Realm.getInstance(this.wordPairsConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.wordPairsConfiguration);
            return Realm.getInstance(this.wordPairsConfiguration);
        }
    }

    public Realm getEvenNumbersRealm() {
        try {
            return Realm.getInstance(this.evenNumbersConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.evenNumbersConfiguration);
            return Realm.getInstance(this.evenNumbersConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.evenNumbersConfiguration);
            return Realm.getInstance(this.evenNumbersConfiguration);
        }
    }

    public Realm getGreenDotRealm() {
        try {
            return Realm.getInstance(this.greenDotConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.greenDotConfiguration);
            return Realm.getInstance(this.greenDotConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.greenDotConfiguration);
            return Realm.getInstance(this.greenDotConfiguration);
        }
    }

    public Realm getMathRealm() {
        try {
            return Realm.getInstance(this.mathConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.mathConfiguration);
            return Realm.getInstance(this.mathConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.mathConfiguration);
            return Realm.getInstance(this.mathConfiguration);
        }
    }

    public Realm getConcentrationRealm() {
        try {
            return Realm.getInstance(this.concentrationConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.concentrationConfiguration);
            return Realm.getInstance(this.concentrationConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.concentrationConfiguration);
            return Realm.getInstance(this.concentrationConfiguration);
        }
    }

    public Realm getCupTimerRealm() {
        try {
            return Realm.getInstance(this.cupTimerConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.cupTimerConfiguration);
            return Realm.getInstance(this.cupTimerConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.cupTimerConfiguration);
            return Realm.getInstance(this.cupTimerConfiguration);
        }
    }

    public Realm getRememberWordsRealm() {
        try {
            return Realm.getInstance(this.rememberWordsConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.rememberWordsConfiguration);
            return Realm.getInstance(this.rememberWordsConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.rememberWordsConfiguration);
            return Realm.getInstance(this.rememberWordsConfiguration);
        }
    }

    public Realm getTrueColorsRealm() {
        try {
            return Realm.getInstance(this.trueColorsConfiguration);
        } catch (RealmMigrationNeededException e) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.trueColorsConfiguration);
            return Realm.getInstance(this.trueColorsConfiguration);
        } catch (RealmFileException e2) {
            if (!Realm.getDefaultInstance().isClosed()) {
                Realm.getDefaultInstance().close();
            }
            Realm.deleteRealm(this.trueColorsConfiguration);
            return Realm.getInstance(this.trueColorsConfiguration);
        }
    }
}
