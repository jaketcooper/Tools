package p006io.realm;

import android.util.JsonReader;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberConfig;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
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
/* renamed from: io.realm.RememberNumberRealmModuleMediator */
class RememberNumberRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    public boolean transformerApplied() {
        return true;
    }

    RememberNumberRealmModuleMediator() {
    }

    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<>();
        modelClasses.add(RememberNumberResult.class);
        modelClasses.add(RememberNumberConfig.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.initTable(sharedRealm);
        }
        throw getMissingProxyClassException(clazz);
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(RememberNumberResult.class)) {
            return RememberNumberResultRealmProxy.getTableName();
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return RememberNumberConfigRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        E e;
        BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);
            if (clazz.equals(RememberNumberResult.class)) {
                e = (RealmModel) clazz.cast(new RememberNumberResultRealmProxy());
            } else if (clazz.equals(RememberNumberConfig.class)) {
                e = (RealmModel) clazz.cast(new RememberNumberConfigRealmProxy());
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
        if (superclass.equals(RememberNumberResult.class)) {
            return (RealmModel) superclass.cast(RememberNumberResultRealmProxy.copyOrUpdate(realm, (RememberNumberResult) obj, update, cache));
        }
        if (superclass.equals(RememberNumberConfig.class)) {
            return (RealmModel) superclass.cast(RememberNumberConfigRealmProxy.copyOrUpdate(realm, (RememberNumberConfig) obj, update, cache));
        }
        throw getMissingProxyClassException(superclass);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
        if (superclass.equals(RememberNumberResult.class)) {
            RememberNumberResultRealmProxy.insert(realm, (RememberNumberResult) object, cache);
        } else if (superclass.equals(RememberNumberConfig.class)) {
            RememberNumberConfigRealmProxy.insert(realm, (RememberNumberConfig) object, cache);
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
            if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insert(realm, (RememberNumberResult) object, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insert(realm, (RememberNumberConfig) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insert(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        Class<?> superclass = obj instanceof RealmObjectProxy ? obj.getClass().getSuperclass() : obj.getClass();
        if (superclass.equals(RememberNumberResult.class)) {
            RememberNumberResultRealmProxy.insertOrUpdate(realm, (RememberNumberResult) obj, cache);
        } else if (superclass.equals(RememberNumberConfig.class)) {
            RememberNumberConfigRealmProxy.insertOrUpdate(realm, (RememberNumberConfig) obj, cache);
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
            if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insertOrUpdate(realm, (RememberNumberResult) object, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insertOrUpdate(realm, (RememberNumberConfig) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(RememberNumberResult.class)) {
                RememberNumberResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(RememberNumberConfig.class)) {
                RememberNumberConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        checkClass(clazz);
        if (clazz.equals(RememberNumberResult.class)) {
            return (RealmModel) clazz.cast(RememberNumberResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return (RealmModel) clazz.cast(RememberNumberConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        checkClass(clazz);
        if (clazz.equals(RememberNumberResult.class)) {
            return (RealmModel) clazz.cast(RememberNumberResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(RememberNumberConfig.class)) {
            return (RealmModel) clazz.cast(RememberNumberConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        Class<? super Object> superclass = realmObject.getClass().getSuperclass();
        if (superclass.equals(RememberNumberResult.class)) {
            return (RealmModel) superclass.cast(RememberNumberResultRealmProxy.createDetachedCopy((RememberNumberResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(RememberNumberConfig.class)) {
            return (RealmModel) superclass.cast(RememberNumberConfigRealmProxy.createDetachedCopy((RememberNumberConfig) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(superclass);
    }
}
