package p006io.realm;

import java.util.Collection;
import java.util.Date;
import p006io.realm.RealmModel;

/* renamed from: io.realm.RealmCollection */
public interface RealmCollection<E extends RealmModel> extends Collection<E> {
    double average(String str);

    boolean contains(Object obj);

    boolean deleteAllFromRealm();

    boolean isLoaded();

    boolean isManaged();

    boolean isValid();

    boolean load();

    Number max(String str);

    Date maxDate(String str);

    Number min(String str);

    Date minDate(String str);

    Number sum(String str);

    RealmQuery<E> where();
}
