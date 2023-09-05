package p006io.realm;

import android.util.JsonReader;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
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
/* renamed from: io.realm.ConcentrationRealmModuleMediator */
class ConcentrationRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    public boolean transformerApplied() {
        return true;
    }

    ConcentrationRealmModuleMediator() {
    }

    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<>();
        modelClasses.add(ConcentrationConfig.class);
        modelClasses.add(ConcentrationResult.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.initTable(sharedRealm);
        }
        throw getMissingProxyClassException(clazz);
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.getFieldNames();
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(ConcentrationConfig.class)) {
            return ConcentrationConfigRealmProxy.getTableName();
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return ConcentrationResultRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        E e;
        BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);
            if (clazz.equals(ConcentrationConfig.class)) {
                e = (RealmModel) clazz.cast(new ConcentrationConfigRealmProxy());
            } else if (clazz.equals(ConcentrationResult.class)) {
                e = (RealmModel) clazz.cast(new ConcentrationResultRealmProxy());
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
        if (superclass.equals(ConcentrationConfig.class)) {
            return (RealmModel) superclass.cast(ConcentrationConfigRealmProxy.copyOrUpdate(realm, (ConcentrationConfig) obj, update, cache));
        }
        if (superclass.equals(ConcentrationResult.class)) {
            return (RealmModel) superclass.cast(ConcentrationResultRealmProxy.copyOrUpdate(realm, (ConcentrationResult) obj, update, cache));
        }
        throw getMissingProxyClassException(superclass);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
        if (superclass.equals(ConcentrationConfig.class)) {
            ConcentrationConfigRealmProxy.insert(realm, (ConcentrationConfig) object, cache);
        } else if (superclass.equals(ConcentrationResult.class)) {
            ConcentrationResultRealmProxy.insert(realm, (ConcentrationResult) object, cache);
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
            if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insert(realm, (ConcentrationConfig) object, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insert(realm, (ConcentrationResult) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insert(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        Class<?> superclass = obj instanceof RealmObjectProxy ? obj.getClass().getSuperclass() : obj.getClass();
        if (superclass.equals(ConcentrationConfig.class)) {
            ConcentrationConfigRealmProxy.insertOrUpdate(realm, (ConcentrationConfig) obj, cache);
        } else if (superclass.equals(ConcentrationResult.class)) {
            ConcentrationResultRealmProxy.insertOrUpdate(realm, (ConcentrationResult) obj, cache);
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
            if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insertOrUpdate(realm, (ConcentrationConfig) object, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insertOrUpdate(realm, (ConcentrationResult) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(ConcentrationConfig.class)) {
                ConcentrationConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(ConcentrationResult.class)) {
                ConcentrationResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        checkClass(clazz);
        if (clazz.equals(ConcentrationConfig.class)) {
            return (RealmModel) clazz.cast(ConcentrationConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return (RealmModel) clazz.cast(ConcentrationResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        checkClass(clazz);
        if (clazz.equals(ConcentrationConfig.class)) {
            return (RealmModel) clazz.cast(ConcentrationConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(ConcentrationResult.class)) {
            return (RealmModel) clazz.cast(ConcentrationResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        Class<? super Object> superclass = realmObject.getClass().getSuperclass();
        if (superclass.equals(ConcentrationConfig.class)) {
            return (RealmModel) superclass.cast(ConcentrationConfigRealmProxy.createDetachedCopy((ConcentrationConfig) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(ConcentrationResult.class)) {
            return (RealmModel) superclass.cast(ConcentrationResultRealmProxy.createDetachedCopy((ConcentrationResult) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(superclass);
    }
}
