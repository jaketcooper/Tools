package p006io.realm.internal.modules;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p006io.realm.Realm;
import p006io.realm.RealmModel;
import p006io.realm.RealmObjectSchema;
import p006io.realm.RealmSchema;
import p006io.realm.internal.ColumnInfo;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.RealmProxyMediator;
import p006io.realm.internal.Row;
import p006io.realm.internal.SharedRealm;
import p006io.realm.internal.Table;
import p006io.realm.internal.Util;

/* renamed from: io.realm.internal.modules.CompositeMediator */
public class CompositeMediator extends RealmProxyMediator {
    private final Map<Class<? extends RealmModel>, RealmProxyMediator> mediators;

    public CompositeMediator(RealmProxyMediator... mediators2) {
        HashMap<Class<? extends RealmModel>, RealmProxyMediator> tempMediators = new HashMap<>();
        if (mediators2 != null) {
            for (RealmProxyMediator mediator : mediators2) {
                for (Class<? extends RealmModel> realmClass : mediator.getModelClasses()) {
                    tempMediators.put(realmClass, mediator);
                }
            }
        }
        this.mediators = Collections.unmodifiableMap(tempMediators);
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema schema) {
        return getMediator(clazz).createRealmObjectSchema(clazz, schema);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        return getMediator(clazz).createTable(clazz, sharedRealm);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        return getMediator(clazz).validateTable(clazz, sharedRealm, allowExtraColumns);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        return getMediator(clazz).getFieldNames(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        return getMediator(clazz).getTableName(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        return getMediator(clazz).newInstance(clazz, baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return this.mediators.keySet();
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        return getMediator(Util.getOriginalModelClass(object.getClass())).copyOrUpdate(realm, object, update, cache);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        getMediator(Util.getOriginalModelClass(object.getClass())).insert(realm, object, cache);
    }

    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        getMediator(Util.getOriginalModelClass(Util.getOriginalModelClass(((RealmModel) objects.iterator().next()).getClass()))).insert(realm, objects);
    }

    public void insertOrUpdate(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        getMediator(Util.getOriginalModelClass(object.getClass())).insertOrUpdate(realm, object, cache);
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        getMediator(Util.getOriginalModelClass(Util.getOriginalModelClass(((RealmModel) objects.iterator().next()).getClass()))).insertOrUpdate(realm, objects);
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        return getMediator(clazz).createOrUpdateUsingJsonObject(clazz, realm, json, update);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        return getMediator(clazz).createUsingJsonStream(clazz, realm, reader);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        return getMediator(Util.getOriginalModelClass(realmObject.getClass())).createDetachedCopy(realmObject, maxDepth, cache);
    }

    public boolean transformerApplied() {
        for (Map.Entry<Class<? extends RealmModel>, RealmProxyMediator> entry : this.mediators.entrySet()) {
            if (!entry.getValue().transformerApplied()) {
                return false;
            }
        }
        return true;
    }

    private RealmProxyMediator getMediator(Class<? extends RealmModel> clazz) {
        RealmProxyMediator mediator = this.mediators.get(clazz);
        if (mediator != null) {
            return mediator;
        }
        throw new IllegalArgumentException(clazz.getSimpleName() + " is not part of the schema for this Realm");
    }
}
