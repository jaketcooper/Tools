package p006io.realm.internal;

import java.util.Map;
import p006io.realm.exceptions.RealmMigrationNeededException;

/* renamed from: io.realm.internal.ColumnInfo */
public abstract class ColumnInfo implements Cloneable {
    private Map<String, Long> indicesMap;

    public abstract void copyColumnInfoFrom(ColumnInfo columnInfo);

    /* access modifiers changed from: protected */
    public final long getValidColumnIndex(String realmPath, Table table, String className, String columnName) {
        long columnIndex = table.getColumnIndex(columnName);
        if (columnIndex != -1) {
            return columnIndex;
        }
        throw new RealmMigrationNeededException(realmPath, "Field '" + columnName + "' not found for type " + className);
    }

    public Map<String, Long> getIndicesMap() {
        return this.indicesMap;
    }

    /* access modifiers changed from: protected */
    public final void setIndicesMap(Map<String, Long> indicesMap2) {
        this.indicesMap = indicesMap2;
    }

    public ColumnInfo clone() {
        try {
            return (ColumnInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
