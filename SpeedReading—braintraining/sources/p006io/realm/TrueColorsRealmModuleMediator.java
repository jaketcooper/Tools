package p006io.realm;

import android.util.JsonReader;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsConfig;
import com.safonov.speedreading.training.fragment.truecolors.repository.entity.TrueColorsResult;
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
/* renamed from: io.realm.TrueColorsRealmModuleMediator */
class TrueColorsRealmModuleMediator extends RealmProxyMediator {
    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;

    public boolean transformerApplied() {
        return true;
    }

    TrueColorsRealmModuleMediator() {
    }

    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<>();
        modelClasses.add(TrueColorsResult.class);
        modelClasses.add(TrueColorsConfig.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.initTable(sharedRealm);
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.initTable(sharedRealm);
        }
        throw getMissingProxyClassException(clazz);
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);
        if (clazz.equals(TrueColorsResult.class)) {
            return TrueColorsResultRealmProxy.getTableName();
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return TrueColorsConfigRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        E e;
        BaseRealm.RealmObjectContext objectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);
            if (clazz.equals(TrueColorsResult.class)) {
                e = (RealmModel) clazz.cast(new TrueColorsResultRealmProxy());
            } else if (clazz.equals(TrueColorsConfig.class)) {
                e = (RealmModel) clazz.cast(new TrueColorsConfigRealmProxy());
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
        if (superclass.equals(TrueColorsResult.class)) {
            return (RealmModel) superclass.cast(TrueColorsResultRealmProxy.copyOrUpdate(realm, (TrueColorsResult) obj, update, cache));
        }
        if (superclass.equals(TrueColorsConfig.class)) {
            return (RealmModel) superclass.cast(TrueColorsConfigRealmProxy.copyOrUpdate(realm, (TrueColorsConfig) obj, update, cache));
        }
        throw getMissingProxyClassException(superclass);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        Class<?> superclass = object instanceof RealmObjectProxy ? object.getClass().getSuperclass() : object.getClass();
        if (superclass.equals(TrueColorsResult.class)) {
            TrueColorsResultRealmProxy.insert(realm, (TrueColorsResult) object, cache);
        } else if (superclass.equals(TrueColorsConfig.class)) {
            TrueColorsConfigRealmProxy.insert(realm, (TrueColorsConfig) object, cache);
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
            if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insert(realm, (TrueColorsResult) object, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insert(realm, (TrueColorsConfig) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insert(realm, iterator, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insert(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        Class<?> superclass = obj instanceof RealmObjectProxy ? obj.getClass().getSuperclass() : obj.getClass();
        if (superclass.equals(TrueColorsResult.class)) {
            TrueColorsResultRealmProxy.insertOrUpdate(realm, (TrueColorsResult) obj, cache);
        } else if (superclass.equals(TrueColorsConfig.class)) {
            TrueColorsConfigRealmProxy.insertOrUpdate(realm, (TrueColorsConfig) obj, cache);
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
            if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insertOrUpdate(realm, (TrueColorsResult) object, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insertOrUpdate(realm, (TrueColorsConfig) object, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
            if (!iterator.hasNext()) {
                return;
            }
            if (superclass.equals(TrueColorsResult.class)) {
                TrueColorsResultRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else if (superclass.equals(TrueColorsConfig.class)) {
                TrueColorsConfigRealmProxy.insertOrUpdate(realm, iterator, cache);
            } else {
                throw getMissingProxyClassException(superclass);
            }
        }
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        checkClass(clazz);
        if (clazz.equals(TrueColorsResult.class)) {
            return (RealmModel) clazz.cast(TrueColorsResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return (RealmModel) clazz.cast(TrueColorsConfigRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        checkClass(clazz);
        if (clazz.equals(TrueColorsResult.class)) {
            return (RealmModel) clazz.cast(TrueColorsResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(TrueColorsConfig.class)) {
            return (RealmModel) clazz.cast(TrueColorsConfigRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        Class<? super Object> superclass = realmObject.getClass().getSuperclass();
        if (superclass.equals(TrueColorsResult.class)) {
            return (RealmModel) superclass.cast(TrueColorsResultRealmProxy.createDetachedCopy((TrueColorsResult) realmObject, 0, maxDepth, cache));
        }
        if (superclass.equals(TrueColorsConfig.class)) {
            return (RealmModel) superclass.cast(TrueColorsConfigRealmProxy.createDetachedCopy((TrueColorsConfig) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(superclass);
    }
}
