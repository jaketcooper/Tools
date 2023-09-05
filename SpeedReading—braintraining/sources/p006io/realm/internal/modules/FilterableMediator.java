package p006io.realm.internal.modules;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
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

/* renamed from: io.realm.internal.modules.FilterableMediator */
public class FilterableMediator extends RealmProxyMediator {
    private final Set<Class<? extends RealmModel>> allowedClasses;
    private final RealmProxyMediator originalMediator;

    public FilterableMediator(RealmProxyMediator originalMediator2, Collection<Class<? extends RealmModel>> allowedClasses2) {
        this.originalMediator = originalMediator2;
        Set<Class<? extends RealmModel>> tempAllowedClasses = new HashSet<>();
        if (originalMediator2 != null) {
            Set<Class<? extends RealmModel>> originalClasses = originalMediator2.getModelClasses();
            for (Class<? extends RealmModel> clazz : allowedClasses2) {
                if (originalClasses.contains(clazz)) {
                    tempAllowedClasses.add(clazz);
                }
            }
        }
        this.allowedClasses = Collections.unmodifiableSet(tempAllowedClasses);
    }

    public RealmProxyMediator getOriginalMediator() {
        return this.originalMediator;
    }

    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema schema) {
        checkSchemaHasClass(clazz);
        return this.originalMediator.createRealmObjectSchema(clazz, schema);
    }

    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkSchemaHasClass(clazz);
        return this.originalMediator.createTable(clazz, sharedRealm);
    }

    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkSchemaHasClass(clazz);
        return this.originalMediator.validateTable(clazz, sharedRealm, allowExtraColumns);
    }

    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkSchemaHasClass(clazz);
        return this.originalMediator.getFieldNames(clazz);
    }

    public String getTableName(Class<? extends RealmModel> clazz) {
        checkSchemaHasClass(clazz);
        return this.originalMediator.getTableName(clazz);
    }

    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        checkSchemaHasClass(clazz);
        return this.originalMediator.newInstance(clazz, baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
    }

    public Set<Class<? extends RealmModel>> getModelClasses() {
        return this.allowedClasses;
    }

    public <E extends RealmModel> E copyOrUpdate(Realm realm, E object, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        checkSchemaHasClass(Util.getOriginalModelClass(object.getClass()));
        return this.originalMediator.copyOrUpdate(realm, object, update, cache);
    }

    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        checkSchemaHasClass(Util.getOriginalModelClass(object.getClass()));
        this.originalMediator.insert(realm, object, cache);
    }

    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        checkSchemaHasClass(Util.getOriginalModelClass(((RealmModel) objects.iterator().next()).getClass()));
        this.originalMediator.insert(realm, objects);
    }

    public void insertOrUpdate(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        checkSchemaHasClass(Util.getOriginalModelClass(object.getClass()));
        this.originalMediator.insertOrUpdate(realm, object, cache);
    }

    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        checkSchemaHasClass(Util.getOriginalModelClass(((RealmModel) objects.iterator().next()).getClass()));
        this.originalMediator.insertOrUpdate(realm, objects);
    }

    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update) throws JSONException {
        checkSchemaHasClass(clazz);
        return this.originalMediator.createOrUpdateUsingJsonObject(clazz, realm, json, update);
    }

    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader) throws IOException {
        checkSchemaHasClass(clazz);
        return this.originalMediator.createUsingJsonStream(clazz, realm, reader);
    }

    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        checkSchemaHasClass(Util.getOriginalModelClass(realmObject.getClass()));
        return this.originalMediator.createDetachedCopy(realmObject, maxDepth, cache);
    }

    public boolean transformerApplied() {
        if (this.originalMediator == null) {
            return true;
        }
        return this.originalMediator.transformerApplied();
    }

    private void checkSchemaHasClass(Class<? extends RealmModel> clazz) {
        if (!this.allowedClasses.contains(clazz)) {
            throw new IllegalArgumentException(clazz.getSimpleName() + " is not part of the schema for this Realm");
        }
    }
}
