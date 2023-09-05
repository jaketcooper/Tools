package p006io.realm;

import java.util.AbstractList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import p006io.realm.RealmModel;
import p006io.realm.internal.Collection;
import p006io.realm.internal.InvalidRow;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.SortDescriptor;
import p006io.realm.internal.Table;
import p006io.realm.internal.UncheckedRow;

/* renamed from: io.realm.OrderedRealmCollectionImpl */
abstract class OrderedRealmCollectionImpl<E extends RealmModel> extends AbstractList<E> implements OrderedRealmCollection<E> {
    private static final String NOT_SUPPORTED_MESSAGE = "This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.";
    String className;
    Class<E> classSpec;
    final Collection collection;
    final BaseRealm realm;

    OrderedRealmCollectionImpl(BaseRealm realm2, Collection collection2, Class<E> clazz) {
        this.realm = realm2;
        this.classSpec = clazz;
        this.collection = collection2;
    }

    OrderedRealmCollectionImpl(BaseRealm realm2, Collection collection2, String className2) {
        this.realm = realm2;
        this.className = className2;
        this.collection = collection2;
    }

    /* access modifiers changed from: package-private */
    public Table getTable() {
        return this.collection.getTable();
    }

    /* access modifiers changed from: package-private */
    public Collection getCollection() {
        return this.collection;
    }

    public boolean isValid() {
        return this.collection.isValid();
    }

    public boolean isManaged() {
        return true;
    }

    public boolean contains(Object object) {
        if (!isLoaded()) {
            return false;
        }
        if ((object instanceof RealmObjectProxy) && ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm() == InvalidRow.INSTANCE) {
            return false;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((RealmModel) it.next()).equals(object)) {
                return true;
            }
        }
        return false;
    }

    public E get(int location) {
        this.realm.checkIfValid();
        return this.realm.get(this.classSpec, this.className, this.collection.getUncheckedRow(location));
    }

    public E first() {
        return firstImpl(true, (RealmModel) null);
    }

    public E first(E defaultValue) {
        return firstImpl(false, defaultValue);
    }

    private E firstImpl(boolean shouldThrow, E defaultValue) {
        UncheckedRow row = this.collection.firstUncheckedRow();
        if (row != null) {
            return this.realm.get(this.classSpec, this.className, row);
        }
        if (!shouldThrow) {
            return defaultValue;
        }
        throw new IndexOutOfBoundsException("No results were found.");
    }

    public E last() {
        return lastImpl(true, (RealmModel) null);
    }

    public E last(E defaultValue) {
        return lastImpl(false, defaultValue);
    }

    private E lastImpl(boolean shouldThrow, E defaultValue) {
        UncheckedRow row = this.collection.lastUncheckedRow();
        if (row != null) {
            return this.realm.get(this.classSpec, this.className, row);
        }
        if (!shouldThrow) {
            return defaultValue;
        }
        throw new IndexOutOfBoundsException("No results were found.");
    }

    public void deleteFromRealm(int location) {
        this.realm.checkIfValidAndInTransaction();
        this.collection.delete((long) location);
    }

    public boolean deleteAllFromRealm() {
        this.realm.checkIfValid();
        if (size() <= 0) {
            return false;
        }
        this.collection.clear();
        return true;
    }

    public Iterator<E> iterator() {
        return new RealmCollectionIterator();
    }

    public ListIterator<E> listIterator() {
        return new RealmCollectionListIterator(0);
    }

    public ListIterator<E> listIterator(int location) {
        return new RealmCollectionListIterator(location);
    }

    private long getColumnIndexForSort(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            throw new IllegalArgumentException("Non-empty field name required.");
        } else if (fieldName.contains(".")) {
            throw new IllegalArgumentException("Aggregates on child object fields are not supported: " + fieldName);
        } else {
            long columnIndex = this.collection.getTable().getColumnIndex(fieldName);
            if (columnIndex >= 0) {
                return columnIndex;
            }
            throw new IllegalArgumentException(String.format("Field '%s' does not exist.", new Object[]{fieldName}));
        }
    }

    public RealmResults<E> sort(String fieldName) {
        return createLoadedResults(this.collection.sort(SortDescriptor.getInstanceForSort(this.collection.getTable(), fieldName, Sort.ASCENDING)));
    }

    public RealmResults<E> sort(String fieldName, Sort sortOrder) {
        return createLoadedResults(this.collection.sort(SortDescriptor.getInstanceForSort(this.collection.getTable(), fieldName, sortOrder)));
    }

    public RealmResults<E> sort(String[] fieldNames, Sort[] sortOrders) {
        return createLoadedResults(this.collection.sort(SortDescriptor.getInstanceForSort(this.collection.getTable(), fieldNames, sortOrders)));
    }

    public RealmResults<E> sort(String fieldName1, Sort sortOrder1, String fieldName2, Sort sortOrder2) {
        return sort(new String[]{fieldName1, fieldName2}, new Sort[]{sortOrder1, sortOrder2});
    }

    public int size() {
        if (!isLoaded()) {
            return 0;
        }
        long size = this.collection.size();
        if (size > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) size;
    }

    public Number min(String fieldName) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Collection.Aggregate.MINIMUM, getColumnIndexForSort(fieldName));
    }

    public Date minDate(String fieldName) {
        this.realm.checkIfValid();
        return this.collection.aggregateDate(Collection.Aggregate.MINIMUM, getColumnIndexForSort(fieldName));
    }

    public Number max(String fieldName) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Collection.Aggregate.MAXIMUM, getColumnIndexForSort(fieldName));
    }

    public Date maxDate(String fieldName) {
        this.realm.checkIfValid();
        return this.collection.aggregateDate(Collection.Aggregate.MAXIMUM, getColumnIndexForSort(fieldName));
    }

    public Number sum(String fieldName) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Collection.Aggregate.SUM, getColumnIndexForSort(fieldName));
    }

    public double average(String fieldName) {
        this.realm.checkIfValid();
        return this.collection.aggregateNumber(Collection.Aggregate.AVERAGE, getColumnIndexForSort(fieldName)).doubleValue();
    }

    @Deprecated
    public E remove(int index) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean remove(Object object) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean removeAll(java.util.Collection<?> collection2) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public E set(int location, E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean retainAll(java.util.Collection<?> collection2) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    public boolean deleteLastFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        return this.collection.deleteLast();
    }

    public boolean deleteFirstFromRealm() {
        this.realm.checkIfValidAndInTransaction();
        return this.collection.deleteFirst();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean add(E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public void add(int index, E e) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean addAll(int location, java.util.Collection<? extends E> collection2) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    @Deprecated
    public boolean addAll(java.util.Collection<? extends E> collection2) {
        throw new UnsupportedOperationException(NOT_SUPPORTED_MESSAGE);
    }

    /* renamed from: io.realm.OrderedRealmCollectionImpl$RealmCollectionIterator */
    private class RealmCollectionIterator extends Collection.Iterator<E> {
        RealmCollectionIterator() {
            super(OrderedRealmCollectionImpl.this.collection);
        }

        /* access modifiers changed from: protected */
        public E convertRowToObject(UncheckedRow row) {
            return OrderedRealmCollectionImpl.this.realm.get(OrderedRealmCollectionImpl.this.classSpec, OrderedRealmCollectionImpl.this.className, row);
        }
    }

    public OrderedRealmCollectionSnapshot<E> createSnapshot() {
        if (this.className != null) {
            return new OrderedRealmCollectionSnapshot<>(this.realm, this.collection, this.className);
        }
        return new OrderedRealmCollectionSnapshot<>(this.realm, this.collection, this.classSpec);
    }

    /* renamed from: io.realm.OrderedRealmCollectionImpl$RealmCollectionListIterator */
    private class RealmCollectionListIterator extends Collection.ListIterator<E> {
        RealmCollectionListIterator(int start) {
            super(OrderedRealmCollectionImpl.this.collection, start);
        }

        /* access modifiers changed from: protected */
        public E convertRowToObject(UncheckedRow row) {
            return OrderedRealmCollectionImpl.this.realm.get(OrderedRealmCollectionImpl.this.classSpec, OrderedRealmCollectionImpl.this.className, row);
        }
    }

    /* access modifiers changed from: package-private */
    public RealmResults<E> createLoadedResults(Collection newCollection) {
        RealmResults<E> results;
        if (this.className != null) {
            results = new RealmResults<>(this.realm, newCollection, this.className);
        } else {
            results = new RealmResults<>(this.realm, newCollection, this.classSpec);
        }
        results.load();
        return results;
    }
}
