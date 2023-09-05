package p006io.realm;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import p006io.realm.RealmModel;
import p006io.realm.internal.UncheckedRow;

/* renamed from: io.realm.OrderedRealmCollectionSnapshot */
public class OrderedRealmCollectionSnapshot<E extends RealmModel> extends OrderedRealmCollectionImpl<E> {
    private int size = -1;

    @Deprecated
    public /* bridge */ /* synthetic */ void add(int i, RealmModel realmModel) {
        super.add(i, realmModel);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean add(RealmModel realmModel) {
        return super.add(realmModel);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        return super.addAll(i, collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public /* bridge */ /* synthetic */ double average(String str) {
        return super.average(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ RealmModel first() {
        return super.first();
    }

    public /* bridge */ /* synthetic */ RealmModel first(RealmModel realmModel) {
        return super.first(realmModel);
    }

    public /* bridge */ /* synthetic */ RealmModel get(int i) {
        return super.get(i);
    }

    public /* bridge */ /* synthetic */ boolean isManaged() {
        return super.isManaged();
    }

    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public /* bridge */ /* synthetic */ RealmModel last() {
        return super.last();
    }

    public /* bridge */ /* synthetic */ RealmModel last(RealmModel realmModel) {
        return super.last(realmModel);
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return super.listIterator(i);
    }

    public /* bridge */ /* synthetic */ Number max(String str) {
        return super.max(str);
    }

    public /* bridge */ /* synthetic */ Date maxDate(String str) {
        return super.maxDate(str);
    }

    public /* bridge */ /* synthetic */ Number min(String str) {
        return super.min(str);
    }

    public /* bridge */ /* synthetic */ Date minDate(String str) {
        return super.minDate(str);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ RealmModel remove(int i) {
        return super.remove(i);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Deprecated
    public /* bridge */ /* synthetic */ RealmModel set(int i, RealmModel realmModel) {
        return super.set(i, realmModel);
    }

    public /* bridge */ /* synthetic */ Number sum(String str) {
        return super.sum(str);
    }

    OrderedRealmCollectionSnapshot(BaseRealm realm, p006io.realm.internal.Collection collection, Class<E> clazz) {
        super(realm, collection.createSnapshot(), clazz);
    }

    OrderedRealmCollectionSnapshot(BaseRealm realm, p006io.realm.internal.Collection collection, String className) {
        super(realm, collection.createSnapshot(), className);
    }

    public int size() {
        if (this.size == -1) {
            this.size = super.size();
        }
        return this.size;
    }

    public RealmResults<E> sort(String fieldName) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String fieldName, Sort sortOrder) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String fieldName1, Sort sortOrder1, String fieldName2, Sort sortOrder2) {
        throw getUnsupportedException("sort");
    }

    public RealmResults<E> sort(String[] fieldNames, Sort[] sortOrders) {
        throw getUnsupportedException("sort");
    }

    @Deprecated
    public RealmQuery<E> where() {
        throw getUnsupportedException("where");
    }

    private UnsupportedOperationException getUnsupportedException(String methodName) {
        return new UnsupportedOperationException(String.format("'%s()' is not supported by OrderedRealmCollectionSnapshot. Call '%s()' on the original 'RealmCollection' instead.", new Object[]{methodName, methodName}));
    }

    public boolean isLoaded() {
        return true;
    }

    public boolean load() {
        return true;
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        this.realm.checkIfValid();
        return this;
    }

    public void deleteFromRealm(int location) {
        this.realm.checkIfValidAndInTransaction();
        if (this.collection.getUncheckedRow(location).isAttached()) {
            this.collection.delete((long) location);
        }
    }

    public boolean deleteFirstFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        UncheckedRow row = this.collection.firstUncheckedRow();
        return row != null && row.isAttached() && this.collection.deleteFirst();
    }

    public boolean deleteLastFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        UncheckedRow row = this.collection.lastUncheckedRow();
        return row != null && row.isAttached() && this.collection.deleteLast();
    }

    public boolean deleteAllFromRealm() {
        return super.deleteAllFromRealm();
    }
}
