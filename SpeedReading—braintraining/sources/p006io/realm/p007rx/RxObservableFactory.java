package p006io.realm.p007rx;

import p006io.realm.DynamicRealm;
import p006io.realm.DynamicRealmObject;
import p006io.realm.Realm;
import p006io.realm.RealmList;
import p006io.realm.RealmModel;
import p006io.realm.RealmQuery;
import p006io.realm.RealmResults;
import rx.Observable;

/* renamed from: io.realm.rx.RxObservableFactory */
public interface RxObservableFactory {
    Observable<DynamicRealm> from(DynamicRealm dynamicRealm);

    Observable<DynamicRealmObject> from(DynamicRealm dynamicRealm, DynamicRealmObject dynamicRealmObject);

    Observable<RealmList<DynamicRealmObject>> from(DynamicRealm dynamicRealm, RealmList<DynamicRealmObject> realmList);

    Observable<RealmQuery<DynamicRealmObject>> from(DynamicRealm dynamicRealm, RealmQuery<DynamicRealmObject> realmQuery);

    Observable<RealmResults<DynamicRealmObject>> from(DynamicRealm dynamicRealm, RealmResults<DynamicRealmObject> realmResults);

    Observable<Realm> from(Realm realm);

    <E extends RealmModel> Observable<RealmList<E>> from(Realm realm, RealmList<E> realmList);

    <E extends RealmModel> Observable<E> from(Realm realm, E e);

    <E extends RealmModel> Observable<RealmQuery<E>> from(Realm realm, RealmQuery<E> realmQuery);

    <E extends RealmModel> Observable<RealmResults<E>> from(Realm realm, RealmResults<E> realmResults);
}
