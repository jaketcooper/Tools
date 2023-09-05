package p006io.realm;

import android.util.JsonReader;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordResult;
import com.safonov.speedreading.training.fragment.flashword.repository.entity.FlashWordsConfig;
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
/* renamed from: io.realm.FlashWordRealmModuleMediator */
class FlashWordRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    public boolean transformerApplied() {
        return true;
    }

    FlashWordRealmModuleMediator() {
    }

    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<>();
        modelClasses.add(FlashWordsConfig.class);
        modelClasses.add(FlashWordResult.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.initTable(sharedRealm);
        }
        throw getMissingProxyClassException(clazz);
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(FlashWordsConfig.class)) {
            return FlashWordsConfigRealmProxy.getTableName();
        }
        if (clazz.equals(FlashWordResult.class)) {
            return FlashWordResultRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        E e;
        BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);
            if (clazz.equals(FlashWordsConfig.class)) {
                e = (RealmModel) clazz.cast(new FlashWordsConfigRealmProxy());
            } else if (clazz.equals(FlashWordResult.class)) {
                e = (RealmModel) clazz.cast(new FlashWordResultRealmProxy());
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
        if (superclass.equals(FlashWordsConfig.class)) {
            return (RealmModel) superclass.cast(FlashWordsConfigRealmProxy.copyOrUpdate(realm, (FlashWordsConfig) obj, update, cache));
        }
        if (superclass.equals(FlashWordResult.class)) {
            return (RealmModel) superclass.cast(FlashWordResultRealmProxy.copyOrUpdate(realm, (FlashWordResult) obj, update, cache));
        }
        throw getMissingProxyClassException(superclass);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
        if (superclass.equals(FlashWordsConfig.class)) {
            FlashWordsConfigRealmProxy.insert(realm, (FlashWordsConfig) object, cache);
        } else if (superclass.equals(FlashWordResult.class)) {
            FlashWordResultRealmProxy.insert(realm, (FlashWordResult) object, cache);
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
            if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insert(realm, (FlashWordsConfig) object, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insert(realm, (FlashWordResult) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insert(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        Class<?> superclass = obj instanceof RealmObjectProxy ? obj.getClass().getSuperclass() : obj.getClass();
        if (superclass.equals(FlashWordsConfig.class)) {
            FlashWordsConfigRealmProxy.insertOrUpdate(realm, (FlashWordsConfig) obj, cache);
        } else if (superclass.equals(FlashWordResult.class)) {
            FlashWordResultRealmProxy.insertOrUpdate(realm, (FlashWordResult) obj, cache);
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
            if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insertOrUpdate(realm, (FlashWordsConfig) object, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insertOrUpdate(realm, (FlashWordResult) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(FlashWordsConfig.class)) {
                FlashWordsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(FlashWordResult.class)) {
                FlashWordResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        checkClass(clazz);
        if (clazz.equals(FlashWordsConfig.class)) {
            return (RealmModel) clazz.cast(FlashWordsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(FlashWordResult.class)) {
            return (RealmModel) clazz.cast(FlashWordResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        checkClass(clazz);
        if (clazz.equals(FlashWordsConfig.class)) {
            return (RealmModel) clazz.cast(FlashWordsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(FlashWordResult.class)) {
            return (RealmModel) clazz.cast(FlashWordResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        Class<? super Object> superclass = realmObject.getClass().getSuperclass();
        if (superclass.equals(FlashWordsConfig.class)) {
            return (RealmModel) superclass.cast(FlashWordsConfigRealmProxy.createDetachedCopy((FlashWordsConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(FlashWordResult.class)) {
            return (RealmModel) superclass.cast(FlashWordResultRealmProxy.createDetachedCopy((FlashWordResult) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(superclass);
    }
}
