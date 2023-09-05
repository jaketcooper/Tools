package p006io.realm.internal;

import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p006io.realm.RealmConfiguration;
import p006io.realm.RealmSchema;
import p006io.realm.internal.Collection;
import p006io.realm.internal.android.AndroidCapabilities;
import p006io.realm.internal.android.AndroidRealmNotifier;

/* renamed from: io.realm.internal.SharedRealm */
public final class SharedRealm implements Closeable, NativeObject {
    public static final byte FILE_EXCEPTION_KIND_ACCESS_ERROR = 0;
    public static final byte FILE_EXCEPTION_KIND_BAD_HISTORY = 1;
    public static final byte FILE_EXCEPTION_KIND_EXISTS = 3;
    public static final byte FILE_EXCEPTION_KIND_FORMAT_UPGRADE_REQUIRED = 6;
    public static final byte FILE_EXCEPTION_KIND_INCOMPATIBLE_LOCK_FILE = 5;
    public static final byte FILE_EXCEPTION_KIND_NOT_FOUND = 4;
    public static final byte FILE_EXCEPTION_KIND_PERMISSION_DENIED = 2;
    public static final byte SCHEMA_MODE_VALUE_ADDITIVE = 3;
    public static final byte SCHEMA_MODE_VALUE_AUTOMATIC = 0;
    public static final byte SCHEMA_MODE_VALUE_MANUAL = 4;
    public static final byte SCHEMA_MODE_VALUE_READONLY = 1;
    public static final byte SCHEMA_MODE_VALUE_RESET_FILE = 2;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private static volatile File temporaryDirectory;
    public final Capabilities capabilities;
    public final List<WeakReference<Collection>> collections = new CopyOnWriteArrayList();
    private RealmConfiguration configuration;
    final Context context;
    public final List<WeakReference<Collection.Iterator>> iterators = new ArrayList();
    private long lastSchemaVersion;
    private long nativePtr;
    public final ObjectServerFacade objectServerFacade;
    public final RealmNotifier realmNotifier;
    private final SchemaVersionListener schemaChangeListener;

    /* renamed from: io.realm.internal.SharedRealm$SchemaVersionListener */
    public interface SchemaVersionListener {
        void onSchemaVersionChanged(long j);
    }

    private static native void nativeBeginTransaction(long j);

    private static native void nativeCancelTransaction(long j);

    private static native void nativeCloseConfig(long j);

    private static native void nativeCloseSharedRealm(long j);

    private static native void nativeCommitTransaction(long j);

    private static native boolean nativeCompact(long j);

    private static native long nativeCreateConfig(String str, byte[] bArr, byte b, boolean z, boolean z2, long j, boolean z3, boolean z4, String str2, String str3);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetSharedRealm(long j, RealmNotifier realmNotifier2);

    private static native long nativeGetSnapshotVersion(long j);

    private static native long nativeGetTable(long j, String str);

    private static native String nativeGetTableName(long j, int i);

    private static native long nativeGetVersion(long j);

    private static native long[] nativeGetVersionID(long j);

    private static native boolean nativeHasTable(long j, String str);

    private static native void nativeInit(String str);

    private static native boolean nativeIsAutoRefresh(long j);

    private static native boolean nativeIsClosed(long j);

    private static native boolean nativeIsEmpty(long j);

    private static native boolean nativeIsInTransaction(long j);

    private static native long nativeReadGroup(long j);

    private static native void nativeRefresh(long j);

    private static native void nativeRemoveTable(long j, String str);

    private static native void nativeRenameTable(long j, String str, String str2);

    private static native boolean nativeRequiresMigration(long j, long j2);

    private static native void nativeSetAutoRefresh(long j, boolean z);

    private static native void nativeSetVersion(long j, long j2);

    private static native long nativeSize(long j);

    private static native void nativeStopWaitForChange(long j);

    private static native void nativeUpdateSchema(long j, long j2, long j3);

    private static native boolean nativeWaitForChange(long j);

    private static native void nativeWriteCopy(long j, String str, byte[] bArr);

    public static void initialize(File tempDirectory) {
        if (temporaryDirectory == null) {
            if (tempDirectory == null) {
                throw new IllegalArgumentException("'tempDirectory' must not be null.");
            }
            String temporaryDirectoryPath = tempDirectory.getAbsolutePath();
            if (tempDirectory.isDirectory() || tempDirectory.mkdirs() || tempDirectory.isDirectory()) {
                if (!temporaryDirectoryPath.endsWith("/")) {
                    temporaryDirectoryPath = temporaryDirectoryPath + "/";
                }
                nativeInit(temporaryDirectoryPath);
                temporaryDirectory = tempDirectory;
                return;
            }
            throw new IOException("failed to create temporary directory: " + temporaryDirectoryPath);
        }
    }

    public static File getTemporaryDirectory() {
        return temporaryDirectory;
    }

    /* renamed from: io.realm.internal.SharedRealm$Durability */
    public enum Durability {
        FULL(0),
        MEM_ONLY(1);
        
        final int value;

        private Durability(int value2) {
            this.value = value2;
        }
    }

    /* renamed from: io.realm.internal.SharedRealm$SchemaMode */
    public enum SchemaMode {
        SCHEMA_MODE_AUTOMATIC((byte) 0),
        SCHEMA_MODE_READONLY((byte) 1),
        SCHEMA_MODE_RESET_FILE((byte) 2),
        SCHEMA_MODE_ADDITIVE((byte) 3),
        SCHEMA_MODE_MANUAL((byte) 4);
        
        final byte value;

        private SchemaMode(byte value2) {
            this.value = value2;
        }

        public byte getNativeValue() {
            return this.value;
        }
    }

    /* renamed from: io.realm.internal.SharedRealm$VersionID */
    public static class VersionID implements Comparable<VersionID> {
        public final long index;
        public final long version;

        VersionID(long version2, long index2) {
            this.version = version2;
            this.index = index2;
        }

        public int compareTo(VersionID another) {
            if (another == null) {
                throw new IllegalArgumentException("Version cannot be compared to a null value.");
            } else if (this.version > another.version) {
                return 1;
            } else {
                if (this.version < another.version) {
                    return -1;
                }
                return 0;
            }
        }

        public String toString() {
            return "VersionID{version=" + this.version + ", index=" + this.index + '}';
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            VersionID versionID = (VersionID) object;
            if (this.version == versionID.version && this.index == versionID.index) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((super.hashCode() * 31) + ((int) (this.version ^ (this.version >>> 32)))) * 31) + ((int) (this.index ^ (this.index >>> 32)));
        }
    }

    private SharedRealm(long nativeConfigPtr, RealmConfiguration configuration2, SchemaVersionListener schemaVersionListener) {
        Capabilities capabilities2 = new AndroidCapabilities();
        RealmNotifier realmNotifier2 = new AndroidRealmNotifier(this, capabilities2);
        this.nativePtr = nativeGetSharedRealm(nativeConfigPtr, realmNotifier2);
        this.configuration = configuration2;
        this.capabilities = capabilities2;
        this.realmNotifier = realmNotifier2;
        this.schemaChangeListener = schemaVersionListener;
        this.context = new Context();
        this.context.addReference(this);
        this.lastSchemaVersion = schemaVersionListener == null ? -1 : getSchemaVersion();
        this.objectServerFacade = null;
        nativeSetAutoRefresh(this.nativePtr, capabilities2.canDeliverNotification());
    }

    public static SharedRealm getInstance(RealmConfiguration config) {
        return getInstance(config, (SchemaVersionListener) null, false);
    }

    public static SharedRealm getInstance(RealmConfiguration config, SchemaVersionListener schemaVersionListener, boolean autoChangeNotifications) {
        String[] userAndServer = ObjectServerFacade.getSyncFacadeIfPossible().getUserAndServerUrl(config);
        String rosServerUrl = userAndServer[0];
        long nativeConfigPtr = nativeCreateConfig(config.getPath(), config.getEncryptionKey(), rosServerUrl != null ? SchemaMode.SCHEMA_MODE_ADDITIVE.getNativeValue() : SchemaMode.SCHEMA_MODE_MANUAL.getNativeValue(), config.getDurability() == Durability.MEM_ONLY, false, config.getSchemaVersion(), false, autoChangeNotifications, rosServerUrl, userAndServer[1]);
        try {
            return new SharedRealm(nativeConfigPtr, config, schemaVersionListener);
        } finally {
            nativeCloseConfig(nativeConfigPtr);
        }
    }

    public void beginTransaction() {
        detachIterators();
        nativeBeginTransaction(this.nativePtr);
        invokeSchemaChangeListenerIfSchemaChanged();
    }

    public void commitTransaction() {
        nativeCommitTransaction(this.nativePtr);
    }

    public void cancelTransaction() {
        nativeCancelTransaction(this.nativePtr);
    }

    public boolean isInTransaction() {
        return nativeIsInTransaction(this.nativePtr);
    }

    public void setSchemaVersion(long schemaVersion) {
        nativeSetVersion(this.nativePtr, schemaVersion);
    }

    public long getSchemaVersion() {
        return nativeGetVersion(this.nativePtr);
    }

    /* access modifiers changed from: package-private */
    public long getGroupNative() {
        return nativeReadGroup(this.nativePtr);
    }

    public boolean hasTable(String name) {
        return nativeHasTable(this.nativePtr, name);
    }

    public Table getTable(String name) {
        return new Table(this, nativeGetTable(this.nativePtr, name));
    }

    public void renameTable(String oldName, String newName) {
        nativeRenameTable(this.nativePtr, oldName, newName);
    }

    public void removeTable(String name) {
        nativeRemoveTable(this.nativePtr, name);
    }

    public String getTableName(int index) {
        return nativeGetTableName(this.nativePtr, index);
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public String getPath() {
        return this.configuration.getPath();
    }

    public boolean isEmpty() {
        return nativeIsEmpty(this.nativePtr);
    }

    public void refresh() {
        nativeRefresh(this.nativePtr);
        invokeSchemaChangeListenerIfSchemaChanged();
    }

    public VersionID getVersionID() {
        long[] versionId = nativeGetVersionID(this.nativePtr);
        return new VersionID(versionId[0], versionId[1]);
    }

    public long getLastSnapshotVersion() {
        return nativeGetSnapshotVersion(this.nativePtr);
    }

    public boolean isClosed() {
        return this.nativePtr == 0 || nativeIsClosed(this.nativePtr);
    }

    public void writeCopy(File file, byte[] key) {
        if (!file.isFile() || !file.exists()) {
            nativeWriteCopy(this.nativePtr, file.getAbsolutePath(), key);
            return;
        }
        throw new IllegalArgumentException("The destination file must not exist");
    }

    public boolean waitForChange() {
        return nativeWaitForChange(this.nativePtr);
    }

    public void stopWaitForChange() {
        nativeStopWaitForChange(this.nativePtr);
    }

    public boolean compact() {
        return nativeCompact(this.nativePtr);
    }

    public void updateSchema(RealmSchema schema, long version) {
        nativeUpdateSchema(this.nativePtr, schema.getNativePtr(), version);
    }

    public void setAutoRefresh(boolean enabled) {
        this.capabilities.checkCanDeliverNotification((String) null);
        nativeSetAutoRefresh(this.nativePtr, enabled);
    }

    public boolean isAutoRefresh() {
        return nativeIsAutoRefresh(this.nativePtr);
    }

    public boolean requiresMigration(RealmSchema schema) {
        return nativeRequiresMigration(this.nativePtr, schema.getNativePtr());
    }

    public void close() {
        if (this.realmNotifier != null) {
            this.realmNotifier.close();
        }
        synchronized (this.context) {
            if (this.nativePtr != 0) {
                nativeCloseSharedRealm(this.nativePtr);
                this.nativePtr = 0;
            }
        }
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public void invokeSchemaChangeListenerIfSchemaChanged() {
        if (this.schemaChangeListener != null) {
            long before = this.lastSchemaVersion;
            long current = getSchemaVersion();
            if (current != before) {
                this.lastSchemaVersion = current;
                this.schemaChangeListener.onSchemaVersionChanged(current);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addIterator(Collection.Iterator iterator) {
        this.iterators.add(new WeakReference(iterator));
    }

    /* access modifiers changed from: package-private */
    public void detachIterators() {
        for (WeakReference<Collection.Iterator> iteratorRef : this.iterators) {
            Collection.Iterator iterator = (Collection.Iterator) iteratorRef.get();
            if (iterator != null) {
                iterator.detach();
            }
        }
        this.iterators.clear();
    }

    /* access modifiers changed from: package-private */
    public void invalidateIterators() {
        for (WeakReference<Collection.Iterator> iteratorRef : this.iterators) {
            Collection.Iterator iterator = (Collection.Iterator) iteratorRef.get();
            if (iterator != null) {
                iterator.invalidate();
            }
        }
        this.iterators.clear();
    }
}
