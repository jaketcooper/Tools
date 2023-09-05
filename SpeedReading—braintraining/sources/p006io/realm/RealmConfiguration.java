package p006io.realm;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p006io.realm.Realm;
import p006io.realm.annotations.RealmModule;
import p006io.realm.exceptions.RealmException;
import p006io.realm.exceptions.RealmFileException;
import p006io.realm.internal.RealmCore;
import p006io.realm.internal.RealmProxyMediator;
import p006io.realm.internal.SharedRealm;
import p006io.realm.internal.modules.CompositeMediator;
import p006io.realm.internal.modules.FilterableMediator;
import p006io.realm.p007rx.RealmObservableFactory;
import p006io.realm.p007rx.RxObservableFactory;

/* renamed from: io.realm.RealmConfiguration */
public class RealmConfiguration {
    /* access modifiers changed from: private */
    public static final Object DEFAULT_MODULE = Realm.getDefaultModule();
    protected static final RealmProxyMediator DEFAULT_MODULE_MEDIATOR;
    public static final String DEFAULT_REALM_NAME = "default.realm";
    public static final int KEY_LENGTH = 64;
    private static Boolean rxJavaAvailable;
    private final String assetFilePath;
    private final String canonicalPath;
    private final boolean deleteRealmIfMigrationNeeded;
    private final SharedRealm.Durability durability;
    private final Realm.Transaction initialDataTransaction;
    private final byte[] key;
    private final RealmMigration migration;
    private final File realmDirectory;
    private final String realmFileName;
    private final RxObservableFactory rxObservableFactory;
    private final RealmProxyMediator schemaMediator;
    private final long schemaVersion;

    static {
        if (DEFAULT_MODULE != null) {
            RealmProxyMediator mediator = getModuleMediator(DEFAULT_MODULE.getClass().getCanonicalName());
            if (!mediator.transformerApplied()) {
                throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
            }
            DEFAULT_MODULE_MEDIATOR = mediator;
            return;
        }
        DEFAULT_MODULE_MEDIATOR = null;
    }

    protected RealmConfiguration(File realmDirectory2, String realmFileName2, String canonicalPath2, String assetFilePath2, byte[] key2, long schemaVersion2, RealmMigration migration2, boolean deleteRealmIfMigrationNeeded2, SharedRealm.Durability durability2, RealmProxyMediator schemaMediator2, RxObservableFactory rxObservableFactory2, Realm.Transaction initialDataTransaction2) {
        this.realmDirectory = realmDirectory2;
        this.realmFileName = realmFileName2;
        this.canonicalPath = canonicalPath2;
        this.assetFilePath = assetFilePath2;
        this.key = key2;
        this.schemaVersion = schemaVersion2;
        this.migration = migration2;
        this.deleteRealmIfMigrationNeeded = deleteRealmIfMigrationNeeded2;
        this.durability = durability2;
        this.schemaMediator = schemaMediator2;
        this.rxObservableFactory = rxObservableFactory2;
        this.initialDataTransaction = initialDataTransaction2;
    }

    public File getRealmDirectory() {
        return this.realmDirectory;
    }

    public String getRealmFileName() {
        return this.realmFileName;
    }

    public byte[] getEncryptionKey() {
        if (this.key == null) {
            return null;
        }
        return Arrays.copyOf(this.key, this.key.length);
    }

    public long getSchemaVersion() {
        return this.schemaVersion;
    }

    public RealmMigration getMigration() {
        return this.migration;
    }

    public boolean shouldDeleteRealmIfMigrationNeeded() {
        return this.deleteRealmIfMigrationNeeded;
    }

    public SharedRealm.Durability getDurability() {
        return this.durability;
    }

    /* access modifiers changed from: package-private */
    public RealmProxyMediator getSchemaMediator() {
        return this.schemaMediator;
    }

    /* access modifiers changed from: package-private */
    public Realm.Transaction getInitialDataTransaction() {
        return this.initialDataTransaction;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAssetFile() {
        return !TextUtils.isEmpty(this.assetFilePath);
    }

    /* access modifiers changed from: package-private */
    public InputStream getAssetFile() throws IOException {
        return BaseRealm.applicationContext.getAssets().open(this.assetFilePath);
    }

    public Set<Class<? extends RealmModel>> getRealmObjectClasses() {
        return this.schemaMediator.getModelClasses();
    }

    public String getPath() {
        return this.canonicalPath;
    }

    public RxObservableFactory getRxFactory() {
        if (this.rxObservableFactory != null) {
            return this.rxObservableFactory;
        }
        throw new UnsupportedOperationException("RxJava seems to be missing from the classpath. Remember to add it as a compile dependency. See https://realm.io/docs/java/latest/#rxjava for more details.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RealmConfiguration that = (RealmConfiguration) obj;
        if (this.schemaVersion != that.schemaVersion || this.deleteRealmIfMigrationNeeded != that.deleteRealmIfMigrationNeeded || !this.realmDirectory.equals(that.realmDirectory) || !this.realmFileName.equals(that.realmFileName) || !this.canonicalPath.equals(that.canonicalPath) || !Arrays.equals(this.key, that.key) || !this.durability.equals(that.durability)) {
            return false;
        }
        if (this.migration != null) {
            if (!this.migration.equals(that.migration)) {
                return false;
            }
        } else if (that.migration != null) {
            return false;
        }
        if (this.rxObservableFactory != null) {
            if (!this.rxObservableFactory.equals(that.rxObservableFactory)) {
                return false;
            }
        } else if (that.rxObservableFactory != null) {
            return false;
        }
        if (this.initialDataTransaction != null) {
            if (!this.initialDataTransaction.equals(that.initialDataTransaction)) {
                return false;
            }
        } else if (that.initialDataTransaction != null) {
            return false;
        }
        return this.schemaMediator.equals(that.schemaMediator);
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int hashCode = ((((((((this.realmDirectory.hashCode() * 31) + this.realmFileName.hashCode()) * 31) + this.canonicalPath.hashCode()) * 31) + (this.key != null ? Arrays.hashCode(this.key) : 0)) * 31) + ((int) this.schemaVersion)) * 31;
        if (this.migration != null) {
            i = this.migration.hashCode();
        } else {
            i = 0;
        }
        int i5 = (hashCode + i) * 31;
        if (this.deleteRealmIfMigrationNeeded) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int hashCode2 = (((((i5 + i2) * 31) + this.schemaMediator.hashCode()) * 31) + this.durability.hashCode()) * 31;
        if (this.rxObservableFactory != null) {
            i3 = this.rxObservableFactory.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (hashCode2 + i3) * 31;
        if (this.initialDataTransaction != null) {
            i4 = this.initialDataTransaction.hashCode();
        }
        return i6 + i4;
    }

    protected static RealmProxyMediator createSchemaMediator(Set<Object> modules, Set<Class<? extends RealmModel>> debugSchema) {
        if (debugSchema.size() > 0) {
            return new FilterableMediator(DEFAULT_MODULE_MEDIATOR, debugSchema);
        }
        if (modules.size() == 1) {
            return getModuleMediator(modules.iterator().next().getClass().getCanonicalName());
        }
        RealmProxyMediator[] mediators = new RealmProxyMediator[modules.size()];
        int i = 0;
        for (Object module : modules) {
            mediators[i] = getModuleMediator(module.getClass().getCanonicalName());
            i++;
        }
        return new CompositeMediator(mediators);
    }

    private static RealmProxyMediator getModuleMediator(String fullyQualifiedModuleClassName) {
        String[] moduleNameParts = fullyQualifiedModuleClassName.split("\\.");
        String mediatorName = String.format("io.realm.%s%s", new Object[]{moduleNameParts[moduleNameParts.length - 1], "Mediator"});
        try {
            Constructor<?> constructor = Class.forName(mediatorName).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (RealmProxyMediator) constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new RealmException("Could not find " + mediatorName, e);
        } catch (InvocationTargetException e2) {
            throw new RealmException("Could not create an instance of " + mediatorName, e2);
        } catch (InstantiationException e3) {
            throw new RealmException("Could not create an instance of " + mediatorName, e3);
        } catch (IllegalAccessException e4) {
            throw new RealmException("Could not create an instance of " + mediatorName, e4);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("realmDirectory: ").append(this.realmDirectory.toString());
        stringBuilder.append("\n");
        stringBuilder.append("realmFileName : ").append(this.realmFileName);
        stringBuilder.append("\n");
        stringBuilder.append("canonicalPath: ").append(this.canonicalPath);
        stringBuilder.append("\n");
        stringBuilder.append("key: ").append("[length: ").append(this.key == null ? 0 : 64).append("]");
        stringBuilder.append("\n");
        stringBuilder.append("schemaVersion: ").append(Long.toString(this.schemaVersion));
        stringBuilder.append("\n");
        stringBuilder.append("migration: ").append(this.migration);
        stringBuilder.append("\n");
        stringBuilder.append("deleteRealmIfMigrationNeeded: ").append(this.deleteRealmIfMigrationNeeded);
        stringBuilder.append("\n");
        stringBuilder.append("durability: ").append(this.durability);
        stringBuilder.append("\n");
        stringBuilder.append("schemaMediator: ").append(this.schemaMediator);
        return stringBuilder.toString();
    }

    static synchronized boolean isRxJavaAvailable() {
        boolean booleanValue;
        synchronized (RealmConfiguration.class) {
            if (rxJavaAvailable == null) {
                try {
                    Class.forName("rx.Observable");
                    rxJavaAvailable = true;
                } catch (ClassNotFoundException e) {
                    rxJavaAvailable = false;
                }
            }
            booleanValue = rxJavaAvailable.booleanValue();
        }
        return booleanValue;
    }

    protected static String getCanonicalPath(File realmFile) {
        try {
            return realmFile.getCanonicalPath();
        } catch (IOException e) {
            throw new RealmFileException(RealmFileException.Kind.ACCESS_ERROR, "Could not resolve the canonical path to the Realm file: " + realmFile.getAbsolutePath(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isSyncConfiguration() {
        return false;
    }

    /* renamed from: io.realm.RealmConfiguration$Builder */
    public static class Builder {
        private String assetFilePath;
        private HashSet<Class<? extends RealmModel>> debugSchema;
        private boolean deleteRealmIfMigrationNeeded;
        private File directory;
        private SharedRealm.Durability durability;
        private String fileName;
        private Realm.Transaction initialDataTransaction;
        private byte[] key;
        private RealmMigration migration;
        private HashSet<Object> modules;
        private RxObservableFactory rxFactory;
        private long schemaVersion;

        public Builder() {
            this(BaseRealm.applicationContext);
        }

        Builder(Context context) {
            this.modules = new HashSet<>();
            this.debugSchema = new HashSet<>();
            if (context == null) {
                throw new IllegalStateException("Call `Realm.init(Context)` before creating a RealmConfiguration");
            }
            RealmCore.loadLibrary(context);
            initializeBuilder(context);
        }

        private void initializeBuilder(Context context) {
            this.directory = context.getFilesDir();
            this.fileName = "default.realm";
            this.key = null;
            this.schemaVersion = 0;
            this.migration = null;
            this.deleteRealmIfMigrationNeeded = false;
            this.durability = SharedRealm.Durability.FULL;
            if (RealmConfiguration.DEFAULT_MODULE != null) {
                this.modules.add(RealmConfiguration.DEFAULT_MODULE);
            }
        }

        public Builder name(String filename) {
            if (filename == null || filename.isEmpty()) {
                throw new IllegalArgumentException("A non-empty filename must be provided");
            }
            this.fileName = filename;
            return this;
        }

        public Builder directory(File directory2) {
            if (directory2 == null) {
                throw new IllegalArgumentException("Non-null 'dir' required.");
            } else if (directory2.isFile()) {
                throw new IllegalArgumentException("'dir' is a file, not a directory: " + directory2.getAbsolutePath() + ".");
            } else if (!directory2.exists() && !directory2.mkdirs()) {
                throw new IllegalArgumentException("Could not create the specified directory: " + directory2.getAbsolutePath() + ".");
            } else if (!directory2.canWrite()) {
                throw new IllegalArgumentException("Realm directory is not writable: " + directory2.getAbsolutePath() + ".");
            } else {
                this.directory = directory2;
                return this;
            }
        }

        public Builder encryptionKey(byte[] key2) {
            if (key2 == null) {
                throw new IllegalArgumentException("A non-null key must be provided");
            } else if (key2.length != 64) {
                throw new IllegalArgumentException(String.format("The provided key must be %s bytes. Yours was: %s", new Object[]{64, Integer.valueOf(key2.length)}));
            } else {
                this.key = Arrays.copyOf(key2, key2.length);
                return this;
            }
        }

        public Builder schemaVersion(long schemaVersion2) {
            if (schemaVersion2 < 0) {
                throw new IllegalArgumentException("Realm schema version numbers must be 0 (zero) or higher. Yours was: " + schemaVersion2);
            }
            this.schemaVersion = schemaVersion2;
            return this;
        }

        public Builder migration(RealmMigration migration2) {
            if (migration2 == null) {
                throw new IllegalArgumentException("A non-null migration must be provided");
            }
            this.migration = migration2;
            return this;
        }

        public Builder deleteRealmIfMigrationNeeded() {
            if (this.assetFilePath == null || this.assetFilePath.length() == 0) {
                this.deleteRealmIfMigrationNeeded = true;
                return this;
            }
            throw new IllegalStateException("Realm cannot clear its schema when previously configured to use an asset file by calling assetFile().");
        }

        public Builder inMemory() {
            if (!TextUtils.isEmpty(this.assetFilePath)) {
                throw new RealmException("Realm can not use in-memory configuration if asset file is present.");
            }
            this.durability = SharedRealm.Durability.MEM_ONLY;
            return this;
        }

        public Builder modules(Object baseModule, Object... additionalModules) {
            this.modules.clear();
            addModule(baseModule);
            if (additionalModules != null) {
                for (Object module : additionalModules) {
                    addModule(module);
                }
            }
            return this;
        }

        public Builder rxFactory(RxObservableFactory factory) {
            this.rxFactory = factory;
            return this;
        }

        public Builder initialData(Realm.Transaction transaction) {
            this.initialDataTransaction = transaction;
            return this;
        }

        public Builder assetFile(String assetFile) {
            if (TextUtils.isEmpty(assetFile)) {
                throw new IllegalArgumentException("A non-empty asset file path must be provided");
            } else if (this.durability == SharedRealm.Durability.MEM_ONLY) {
                throw new RealmException("Realm can not use in-memory configuration if asset file is present.");
            } else if (this.deleteRealmIfMigrationNeeded) {
                throw new IllegalStateException("Realm cannot use an asset file when previously configured to clear its schema in migration by calling deleteRealmIfMigrationNeeded().");
            } else {
                this.assetFilePath = assetFile;
                return this;
            }
        }

        private void addModule(Object module) {
            if (module != null) {
                checkModule(module);
                this.modules.add(module);
            }
        }

        /* access modifiers changed from: package-private */
        public Builder schema(Class<? extends RealmModel> firstClass, Class<? extends RealmModel>... additionalClasses) {
            if (firstClass == null) {
                throw new IllegalArgumentException("A non-null class must be provided");
            }
            this.modules.clear();
            this.modules.add(RealmConfiguration.DEFAULT_MODULE_MEDIATOR);
            this.debugSchema.add(firstClass);
            if (additionalClasses != null) {
                Collections.addAll(this.debugSchema, additionalClasses);
            }
            return this;
        }

        public RealmConfiguration build() {
            if (this.rxFactory == null && RealmConfiguration.isRxJavaAvailable()) {
                this.rxFactory = new RealmObservableFactory();
            }
            return new RealmConfiguration(this.directory, this.fileName, RealmConfiguration.getCanonicalPath(new File(this.directory, this.fileName)), this.assetFilePath, this.key, this.schemaVersion, this.migration, this.deleteRealmIfMigrationNeeded, this.durability, RealmConfiguration.createSchemaMediator(this.modules, this.debugSchema), this.rxFactory, this.initialDataTransaction);
        }

        private void checkModule(Object module) {
            if (!module.getClass().isAnnotationPresent(RealmModule.class)) {
                throw new IllegalArgumentException(module.getClass().getCanonicalName() + " is not a RealmModule. Add @RealmModule to the class definition.");
            }
        }
    }
}
