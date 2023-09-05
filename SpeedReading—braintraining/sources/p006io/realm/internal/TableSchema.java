package p006io.realm.internal;

import p006io.realm.RealmFieldType;

/* renamed from: io.realm.internal.TableSchema */
public interface TableSchema {
    long addColumn(RealmFieldType realmFieldType, String str);

    void removeColumn(long j);

    void renameColumn(long j, String str);
}
