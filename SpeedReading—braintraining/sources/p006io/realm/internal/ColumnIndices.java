package p006io.realm.internal;

import java.util.HashMap;
import java.util.Map;
import p006io.realm.RealmModel;

/* renamed from: io.realm.internal.ColumnIndices */
public final class ColumnIndices implements Cloneable {
    private Map<Class<? extends RealmModel>, ColumnInfo> classes;
    private long schemaVersion;

    public ColumnIndices(long schemaVersion2, Map<Class<? extends RealmModel>, ColumnInfo> classes2) {
        this.schemaVersion = schemaVersion2;
        this.classes = classes2;
    }

    public long getSchemaVersion() {
        return this.schemaVersion;
    }

    public ColumnInfo getColumnInfo(Class<? extends RealmModel> clazz) {
        return this.classes.get(clazz);
    }

    public long getColumnIndex(Class<? extends RealmModel> clazz, String fieldName) {
        Long index;
        ColumnInfo columnInfo = this.classes.get(clazz);
        if (columnInfo == null || (index = columnInfo.getIndicesMap().get(fieldName)) == null) {
            return -1;
        }
        return index.longValue();
    }

    public ColumnIndices clone() {
        try {
            ColumnIndices clone = (ColumnIndices) super.clone();
            clone.classes = duplicateColumnInfoMap();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<Class<? extends RealmModel>, ColumnInfo> duplicateColumnInfoMap() {
        Map<Class<? extends RealmModel>, ColumnInfo> copy = new HashMap<>();
        for (Map.Entry<Class<? extends RealmModel>, ColumnInfo> entry : this.classes.entrySet()) {
            copy.put(entry.getKey(), entry.getValue().clone());
        }
        return copy;
    }

    public void copyFrom(ColumnIndices other, RealmProxyMediator mediator) {
        for (Map.Entry<Class<? extends RealmModel>, ColumnInfo> entry : this.classes.entrySet()) {
            ColumnInfo otherColumnInfo = other.getColumnInfo(entry.getKey());
            if (otherColumnInfo == null) {
                throw new IllegalStateException("Failed to copy ColumnIndices cache: " + Table.tableNameToClassName(mediator.getTableName(entry.getKey())));
            }
            entry.getValue().copyColumnInfoFrom(otherColumnInfo);
        }
        this.schemaVersion = other.schemaVersion;
    }
}
