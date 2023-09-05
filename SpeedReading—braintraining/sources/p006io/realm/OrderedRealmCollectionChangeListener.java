package p006io.realm;

/* renamed from: io.realm.OrderedRealmCollectionChangeListener */
public interface OrderedRealmCollectionChangeListener<T> {
    void onChange(T t, OrderedCollectionChangeSet orderedCollectionChangeSet);
}
