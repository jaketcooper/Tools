package p006io.realm;

import android.util.JsonReader;
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
/* renamed from: io.realm.WordsColumnsRealmModuleMediator */
class WordsColumnsRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    public boolean transformerApplied() {
        return true;
    }

    WordsColumnsRealmModuleMediator() {
    }

    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<>();
        modelClasses.add(WordsColumnsResult.class);
        modelClasses.add(WordsColumnsConfig.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.initTable(sharedRealm);
        }
        throw getMissingProxyClassException(clazz);
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(WordsColumnsResult.class)) {
            return WordsColumnsResultRealmProxy.getTableName();
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return WordsColumnsConfigRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        E e;
        BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);
            if (clazz.equals(WordsColumnsResult.class)) {
                e = (RealmModel) clazz.cast(new WordsColumnsResultRealmProxy());
            } else if (clazz.equals(WordsColumnsConfig.class)) {
                e = (RealmModel) clazz.cast(new WordsColumnsConfigRealmProxy());
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
        if (superclass.equals(WordsColumnsResult.class)) {
            return (RealmModel) superclass.cast(WordsColumnsResultRealmProxy.copyOrUpdate(realm, (WordsColumnsResult) obj, update, cache));
        }
        if (superclass.equals(WordsColumnsConfig.class)) {
            return (RealmModel) superclass.cast(WordsColumnsConfigRealmProxy.copyOrUpdate(realm, (WordsColumnsConfig) obj, update, cache));
        }
        throw getMissingProxyClassException(superclass);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
        if (superclass.equals(WordsColumnsResult.class)) {
            WordsColumnsResultRealmProxy.insert(realm, (WordsColumnsResult) object, cache);
        } else if (superclass.equals(WordsColumnsConfig.class)) {
            WordsColumnsConfigRealmProxy.insert(realm, (WordsColumnsConfig) object, cache);
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
            if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insert(realm, (WordsColumnsResult) object, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insert(realm, (WordsColumnsConfig) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insert(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        Class<?> superclass = obj instanceof RealmObjectProxy ? obj.getClass().getSuperclass() : obj.getClass();
        if (superclass.equals(WordsColumnsResult.class)) {
            WordsColumnsResultRealmProxy.insertOrUpdate(realm, (WordsColumnsResult) obj, cache);
        } else if (superclass.equals(WordsColumnsConfig.class)) {
            WordsColumnsConfigRealmProxy.insertOrUpdate(realm, (WordsColumnsConfig) obj, cache);
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
            if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insertOrUpdate(realm, (WordsColumnsResult) object, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insertOrUpdate(realm, (WordsColumnsConfig) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(WordsColumnsResult.class)) {
                WordsColumnsResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(WordsColumnsConfig.class)) {
                WordsColumnsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        checkClass(clazz);
        if (clazz.equals(WordsColumnsResult.class)) {
            return (RealmModel) clazz.cast(WordsColumnsResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return (RealmModel) clazz.cast(WordsColumnsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        checkClass(clazz);
        if (clazz.equals(WordsColumnsResult.class)) {
            return (RealmModel) clazz.cast(WordsColumnsResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(WordsColumnsConfig.class)) {
            return (RealmModel) clazz.cast(WordsColumnsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        Class<? super Object> superclass = realmObject.getClass().getSuperclass();
        if (superclass.equals(WordsColumnsResult.class)) {
            return (RealmModel) superclass.cast(WordsColumnsResultRealmProxy.createDetachedCopy((WordsColumnsResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(WordsColumnsConfig.class)) {
            return (RealmModel) superclass.cast(WordsColumnsConfigRealmProxy.createDetachedCopy((WordsColumnsConfig) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(superclass);
    }
}
