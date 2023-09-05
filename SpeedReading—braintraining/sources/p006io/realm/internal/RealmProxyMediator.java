package p006io.realm.internal;

import android.util.JsonReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import p006io.realm.Realm;
import p006io.realm.RealmModel;
import p006io.realm.RealmObjectSchema;
import p006io.realm.RealmSchema;
import p006io.realm.exceptions.RealmException;
import p006io.realm.internal.RealmObjectProxy;

/* renamed from: io.realm.internal.RealmProxyMediator */
public abstract class RealmProxyMediator {
    public abstract <E extends RealmModel> E copyOrUpdate(Realm realm, E e, boolean z, Map<RealmModel, RealmObjectProxy> map);

    public abstract <E extends RealmModel> E createDetachedCopy(E e, int i, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map);

    public abstract <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> cls, Realm realm, JSONObject jSONObject, boolean z) throws JSONException;

    public abstract RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> cls, RealmSchema realmSchema);

    public abstract Table createTable(Class<? extends RealmModel> cls, SharedRealm sharedRealm);

    public abstract <E extends RealmModel> E createUsingJsonStream(Class<E> cls, Realm realm, JsonReader jsonReader) throws IOException;

    public abstract List<String> getFieldNames(Class<? extends RealmModel> cls);

    public abstract Set<Class<? extends RealmModel>> getModelClasses();

    public abstract String getTableName(Class<? extends RealmModel> cls);

    public abstract void insert(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map);

    public abstract void insert(Realm realm, Collection<? extends RealmModel> collection);

    public abstract void insertOrUpdate(Realm realm, RealmModel realmModel, Map<RealmModel, Long> map);

    public abstract void insertOrUpdate(Realm realm, Collection<? extends RealmModel> collection);

    public abstract <E extends RealmModel> E newInstance(Class<E> cls, Object obj, Row row, ColumnInfo columnInfo, boolean z, List<String> list);

    public abstract ColumnInfo validateTable(Class<? extends RealmModel> cls, SharedRealm sharedRealm, boolean z);

    public boolean transformerApplied() {
        return false;
    }

    public boolean equals(Object o) {
        if (!(o instanceof RealmProxyMediator)) {
            return false;
        }
        return getModelClasses().equals(((RealmProxyMediator) o).getModelClasses());
    }

    public int hashCode() {
        return getModelClasses().hashCode();
    }

    protected static void checkClass(Class<? extends RealmModel> clazz) {
        if (clazz == null) {
            throw new NullPointerException("A class extending RealmObject must be provided");
        }
    }

    protected static RealmException getMissingProxyClassException(Class<? extends RealmModel> clazz) {
        return new RealmException(clazz + " is not part of the schema for this Realm.");
    }
}
