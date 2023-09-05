package p006io.realm;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import p006io.realm.internal.ColumnIndices;
import p006io.realm.internal.ObjectServerFacade;
import p006io.realm.internal.SharedRealm;
import p006io.realm.internal.Table;
import p006io.realm.log.RealmLog;

/* renamed from: io.realm.RealmCache */
final class RealmCache {
    private static final String DIFFERENT_KEY_MESSAGE = "Wrong key used to decrypt Realm.";
    private static final int MAX_ENTRIES_IN_TYPED_COLUMN_INDICES_ARRAY = 4;
    private static final String WRONG_REALM_CLASS_MESSAGE = "The type of Realm class must be Realm or DynamicRealm.";
    private static Map<String, RealmCache> cachesMap = new HashMap();
    private final RealmConfiguration configuration;
    private final EnumMap<RealmCacheType, RefAndCount> refAndCountMap;
    private final ColumnIndices[] typedColumnIndicesArray = new ColumnIndices[4];

    /* renamed from: io.realm.RealmCache$Callback */
    interface Callback {
        void onResult(int i);
    }

    /* renamed from: io.realm.RealmCache$Callback0 */
    interface Callback0 {
        void onCall();
    }

    /* renamed from: io.realm.RealmCache$RefAndCount */
    private static class RefAndCount {
        /* access modifiers changed from: private */
        public int globalCount;
        /* access modifiers changed from: private */
        public final ThreadLocal<Integer> localCount;
        /* access modifiers changed from: private */
        public final ThreadLocal<BaseRealm> localRealm;

        private RefAndCount() {
            this.localRealm = new ThreadLocal<>();
            this.localCount = new ThreadLocal<>();
            this.globalCount = 0;
        }

        static /* synthetic */ int access$108(RefAndCount x0) {
            int i = x0.globalCount;
            x0.globalCount = i + 1;
            return i;
        }

        static /* synthetic */ int access$110(RefAndCount x0) {
            int i = x0.globalCount;
            x0.globalCount = i - 1;
            return i;
        }
    }

    /* renamed from: io.realm.RealmCache$RealmCacheType */
    private enum RealmCacheType {
        TYPED_REALM,
        DYNAMIC_REALM;

        static RealmCacheType valueOf(Class<? extends BaseRealm> clazz) {
            if (clazz == Realm.class) {
                return TYPED_REALM;
            }
            if (clazz == DynamicRealm.class) {
                return DYNAMIC_REALM;
            }
            throw new IllegalArgumentException(RealmCache.WRONG_REALM_CLASS_MESSAGE);
        }
    }

    private RealmCache(RealmConfiguration config) {
        this.configuration = config;
        this.refAndCountMap = new EnumMap<>(RealmCacheType.class);
        for (RealmCacheType type : RealmCacheType.values()) {
            this.refAndCountMap.put(type, new RefAndCount());
        }
    }

    static synchronized <E extends BaseRealm> E createRealmOrGetFromCache(RealmConfiguration configuration2, Class<E> realmClass) {
        E realm;
        BaseRealm realm2;
        synchronized (RealmCache.class) {
            boolean isCacheInMap = true;
            RealmCache cache = cachesMap.get(configuration2.getPath());
            if (cache == null) {
                cache = new RealmCache(configuration2);
                isCacheInMap = false;
                copyAssetFileIfNeeded(configuration2);
            } else {
                cache.validateConfiguration(configuration2);
            }
            RefAndCount refAndCount = cache.refAndCountMap.get(RealmCacheType.valueOf((Class<? extends BaseRealm>) realmClass));
            if (refAndCount.globalCount == 0) {
                SharedRealm sharedRealm = SharedRealm.getInstance(configuration2);
                if (Table.primaryKeyTableNeedsMigration(sharedRealm)) {
                    sharedRealm.beginTransaction();
                    if (Table.migratePrimaryKeyTableIfNeeded(sharedRealm)) {
                        sharedRealm.commitTransaction();
                    } else {
                        sharedRealm.cancelTransaction();
                    }
                }
                sharedRealm.close();
            }
            if (refAndCount.localRealm.get() == null) {
                if (realmClass == Realm.class) {
                    realm2 = Realm.createInstance(configuration2, cache.typedColumnIndicesArray);
                } else if (realmClass == DynamicRealm.class) {
                    realm2 = DynamicRealm.createInstance(configuration2);
                } else {
                    throw new IllegalArgumentException(WRONG_REALM_CLASS_MESSAGE);
                }
                if (!isCacheInMap) {
                    cachesMap.put(configuration2.getPath(), cache);
                }
                refAndCount.localRealm.set(realm2);
                refAndCount.localCount.set(0);
            }
            Integer refCount = (Integer) refAndCount.localCount.get();
            if (refCount.intValue() == 0) {
                if (realmClass == Realm.class && refAndCount.globalCount == 0) {
                    storeColumnIndices(cache.typedColumnIndicesArray, ((BaseRealm) refAndCount.localRealm.get()).schema.columnIndices.clone());
                }
                RefAndCount.access$108(refAndCount);
            }
            refAndCount.localCount.set(Integer.valueOf(refCount.intValue() + 1));
            realm = (BaseRealm) refAndCount.localRealm.get();
            if (refAndCount.globalCount == 1) {
                ObjectServerFacade.getFacade(configuration2.isSyncConfiguration()).realmOpened(configuration2);
            }
        }
        return realm;
    }

    static synchronized void release(BaseRealm realm) {
        synchronized (RealmCache.class) {
            String canonicalPath = realm.getPath();
            RealmCache cache = cachesMap.get(canonicalPath);
            Integer refCount = null;
            RefAndCount refAndCount = null;
            if (cache != null) {
                refAndCount = cache.refAndCountMap.get(RealmCacheType.valueOf((Class<? extends BaseRealm>) realm.getClass()));
                refCount = (Integer) refAndCount.localCount.get();
            }
            if (refCount == null) {
                refCount = 0;
            }
            if (refCount.intValue() <= 0) {
                RealmLog.warn("%s has been closed already.", canonicalPath);
            } else {
                Integer refCount2 = Integer.valueOf(refCount.intValue() - 1);
                if (refCount2.intValue() == 0) {
                    refAndCount.localCount.set((Object) null);
                    refAndCount.localRealm.set((Object) null);
                    RefAndCount.access$110(refAndCount);
                    if (refAndCount.globalCount < 0) {
                        throw new IllegalStateException("Global reference counter of Realm" + canonicalPath + " got corrupted.");
                    }
                    if ((realm instanceof Realm) && refAndCount.globalCount == 0) {
                        Arrays.fill(cache.typedColumnIndicesArray, (Object) null);
                    }
                    int totalRefCount = 0;
                    for (RealmCacheType type : RealmCacheType.values()) {
                        totalRefCount += cache.refAndCountMap.get(type).globalCount;
                    }
                    realm.doClose();
                    if (totalRefCount == 0) {
                        cachesMap.remove(canonicalPath);
                        ObjectServerFacade.getFacade(realm.getConfiguration().isSyncConfiguration()).realmClosed(realm.getConfiguration());
                    }
                } else {
                    refAndCount.localCount.set(refCount2);
                }
            }
        }
    }

    private void validateConfiguration(RealmConfiguration newConfiguration) {
        if (!this.configuration.equals(newConfiguration)) {
            if (!Arrays.equals(this.configuration.getEncryptionKey(), newConfiguration.getEncryptionKey())) {
                throw new IllegalArgumentException(DIFFERENT_KEY_MESSAGE);
            }
            RealmMigration newMigration = newConfiguration.getMigration();
            RealmMigration oldMigration = this.configuration.getMigration();
            if (oldMigration == null || newMigration == null || !oldMigration.getClass().equals(newMigration.getClass()) || newMigration.equals(oldMigration)) {
                throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. \nCached configuration: \n" + this.configuration + "\n\nNew configuration: \n" + newConfiguration);
            }
            throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: " + newConfiguration.getMigration().getClass().getCanonicalName());
        }
    }

    static synchronized void invokeWithGlobalRefCount(RealmConfiguration configuration2, Callback callback) {
        synchronized (RealmCache.class) {
            RealmCache cache = cachesMap.get(configuration2.getPath());
            if (cache == null) {
                callback.onResult(0);
            } else {
                int totalRefCount = 0;
                for (RealmCacheType type : RealmCacheType.values()) {
                    totalRefCount += cache.refAndCountMap.get(type).globalCount;
                }
                callback.onResult(totalRefCount);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r2 = r0.typedColumnIndicesArray;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void updateSchemaCache(p006io.realm.Realm r7) {
        /*
            java.lang.Class<io.realm.RealmCache> r5 = p006io.realm.RealmCache.class
            monitor-enter(r5)
            java.util.Map<java.lang.String, io.realm.RealmCache> r4 = cachesMap     // Catch:{ all -> 0x0033 }
            java.lang.String r6 = r7.getPath()     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r4.get(r6)     // Catch:{ all -> 0x0033 }
            io.realm.RealmCache r0 = (p006io.realm.RealmCache) r0     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0013
        L_0x0011:
            monitor-exit(r5)
            return
        L_0x0013:
            java.util.EnumMap<io.realm.RealmCache$RealmCacheType, io.realm.RealmCache$RefAndCount> r4 = r0.refAndCountMap     // Catch:{ all -> 0x0033 }
            io.realm.RealmCache$RealmCacheType r6 = p006io.realm.RealmCache.RealmCacheType.TYPED_REALM     // Catch:{ all -> 0x0033 }
            java.lang.Object r3 = r4.get(r6)     // Catch:{ all -> 0x0033 }
            io.realm.RealmCache$RefAndCount r3 = (p006io.realm.RealmCache.RefAndCount) r3     // Catch:{ all -> 0x0033 }
            java.lang.ThreadLocal r4 = r3.localRealm     // Catch:{ all -> 0x0033 }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x0011
            io.realm.internal.ColumnIndices[] r2 = r0.typedColumnIndicesArray     // Catch:{ all -> 0x0033 }
            io.realm.internal.ColumnIndices r1 = r7.updateSchemaCache(r2)     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0011
            storeColumnIndices(r2, r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0011
        L_0x0033:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p006io.realm.RealmCache.updateSchemaCache(io.realm.Realm):void");
    }

    static synchronized void invokeWithLock(Callback0 callback) {
        synchronized (RealmCache.class) {
            callback.onCall();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[SYNTHETIC, Splitter:B:16:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A[SYNTHETIC, Splitter:B:19:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void copyAssetFileIfNeeded(p006io.realm.RealmConfiguration r11) {
        /*
            r3 = 0
            boolean r8 = r11.hasAssetFile()
            if (r8 == 0) goto L_0x001a
            java.io.File r7 = new java.io.File
            java.io.File r8 = r11.getRealmDirectory()
            java.lang.String r9 = r11.getRealmFileName()
            r7.<init>(r8, r9)
            boolean r8 = r7.exists()
            if (r8 == 0) goto L_0x001b
        L_0x001a:
            return
        L_0x001b:
            r4 = 0
            r5 = 0
            java.io.InputStream r4 = r11.getAssetFile()     // Catch:{ IOException -> 0x002d }
            if (r4 != 0) goto L_0x0044
            io.realm.exceptions.RealmFileException r8 = new io.realm.exceptions.RealmFileException     // Catch:{ IOException -> 0x002d }
            io.realm.exceptions.RealmFileException$Kind r9 = p006io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR     // Catch:{ IOException -> 0x002d }
            java.lang.String r10 = "Invalid input stream to asset file."
            r8.<init>((p006io.realm.exceptions.RealmFileException.Kind) r9, (java.lang.String) r10)     // Catch:{ IOException -> 0x002d }
            throw r8     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            r2 = move-exception
        L_0x002e:
            io.realm.exceptions.RealmFileException r8 = new io.realm.exceptions.RealmFileException     // Catch:{ all -> 0x0038 }
            io.realm.exceptions.RealmFileException$Kind r9 = p006io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR     // Catch:{ all -> 0x0038 }
            java.lang.String r10 = "Could not resolve the path to the Realm asset file."
            r8.<init>(r9, r10, r2)     // Catch:{ all -> 0x0038 }
            throw r8     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r8 = move-exception
        L_0x0039:
            if (r4 == 0) goto L_0x003e
            r4.close()     // Catch:{ IOException -> 0x0078 }
        L_0x003e:
            if (r5 == 0) goto L_0x0043
            r5.close()     // Catch:{ IOException -> 0x007b }
        L_0x0043:
            throw r8
        L_0x0044:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002d }
            r6.<init>(r7)     // Catch:{ IOException -> 0x002d }
            r8 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r8]     // Catch:{ IOException -> 0x0059, all -> 0x0080 }
        L_0x004d:
            int r1 = r4.read(r0)     // Catch:{ IOException -> 0x0059, all -> 0x0080 }
            r8 = -1
            if (r1 <= r8) goto L_0x005c
            r8 = 0
            r6.write(r0, r8, r1)     // Catch:{ IOException -> 0x0059, all -> 0x0080 }
            goto L_0x004d
        L_0x0059:
            r2 = move-exception
            r5 = r6
            goto L_0x002e
        L_0x005c:
            if (r4 == 0) goto L_0x0061
            r4.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0061:
            if (r6 == 0) goto L_0x0066
            r6.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0066:
            if (r3 == 0) goto L_0x001a
            io.realm.exceptions.RealmFileException r8 = new io.realm.exceptions.RealmFileException
            io.realm.exceptions.RealmFileException$Kind r9 = p006io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR
            r8.<init>((p006io.realm.exceptions.RealmFileException.Kind) r9, (java.lang.Throwable) r3)
            throw r8
        L_0x0070:
            r2 = move-exception
            r3 = r2
            goto L_0x0061
        L_0x0073:
            r2 = move-exception
            if (r3 != 0) goto L_0x0066
            r3 = r2
            goto L_0x0066
        L_0x0078:
            r2 = move-exception
            r3 = r2
            goto L_0x003e
        L_0x007b:
            r2 = move-exception
            if (r3 != 0) goto L_0x0043
            r3 = r2
            goto L_0x0043
        L_0x0080:
            r8 = move-exception
            r5 = r6
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: p006io.realm.RealmCache.copyAssetFileIfNeeded(io.realm.RealmConfiguration):void");
    }

    static int getLocalThreadCount(RealmConfiguration configuration2) {
        int i;
        RealmCache cache = cachesMap.get(configuration2.getPath());
        if (cache == null) {
            return 0;
        }
        int totalRefCount = 0;
        for (RealmCacheType type : RealmCacheType.values()) {
            Integer localCount = (Integer) cache.refAndCountMap.get(type).localCount.get();
            if (localCount != null) {
                i = localCount.intValue();
            } else {
                i = 0;
            }
            totalRefCount += i;
        }
        return totalRefCount;
    }

    public static ColumnIndices findColumnIndices(ColumnIndices[] array, long schemaVersion) {
        for (int i = array.length - 1; i >= 0; i--) {
            ColumnIndices candidate = array[i];
            if (candidate != null && candidate.getSchemaVersion() == schemaVersion) {
                return candidate;
            }
        }
        return null;
    }

    private static int storeColumnIndices(ColumnIndices[] array, ColumnIndices columnIndices) {
        long oldestSchemaVersion = Long.MAX_VALUE;
        int candidateIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == null) {
                array[i] = columnIndices;
                return i;
            }
            ColumnIndices target = array[i];
            if (target.getSchemaVersion() <= oldestSchemaVersion) {
                oldestSchemaVersion = target.getSchemaVersion();
                candidateIndex = i;
            }
        }
        array[candidateIndex] = columnIndices;
        return candidateIndex;
    }
}
