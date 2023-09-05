package p006io.realm;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p006io.realm.RealmModel;
import p006io.realm.internal.InvalidRow;
import p006io.realm.internal.PendingRow;
import p006io.realm.internal.Row;
import p006io.realm.internal.UncheckedRow;

/* renamed from: io.realm.ProxyState */
public final class ProxyState<E extends RealmModel> implements PendingRow.FrontEnd {
    private boolean acceptDefaultValue;
    protected long currentTableVersion = -1;
    private List<String> excludeFields;
    private final List<RealmChangeListener<E>> listeners = new CopyOnWriteArrayList();
    private E model;
    private BaseRealm realm;
    /* access modifiers changed from: private */
    public Row row;
    private boolean underConstruction = true;

    public ProxyState() {
    }

    public ProxyState(E model2) {
        this.model = model2;
    }

    public BaseRealm getRealm$realm() {
        return this.realm;
    }

    public void setRealm$realm(BaseRealm realm2) {
        this.realm = realm2;
    }

    public Row getRow$realm() {
        return this.row;
    }

    public void setRow$realm(Row row2) {
        this.row = row2;
    }

    public boolean getAcceptDefaultValue$realm() {
        return this.acceptDefaultValue;
    }

    public void setAcceptDefaultValue$realm(boolean acceptDefaultValue2) {
        this.acceptDefaultValue = acceptDefaultValue2;
    }

    public List<String> getExcludeFields$realm() {
        return this.excludeFields;
    }

    public void setExcludeFields$realm(List<String> excludeFields2) {
        this.excludeFields = excludeFields2;
    }

    /* access modifiers changed from: private */
    public void notifyChangeListeners() {
        if (!this.listeners.isEmpty()) {
            for (RealmChangeListener<E> listener : this.listeners) {
                if (this.realm.sharedRealm != null && !this.realm.sharedRealm.isClosed()) {
                    listener.onChange(this.model);
                } else {
                    return;
                }
            }
        }
    }

    public void addChangeListener(RealmChangeListener<E> listener) {
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
        }
        if (this.row instanceof UncheckedRow) {
            registerToRealmNotifier();
        }
    }

    public void removeChangeListener(RealmChangeListener<E> listener) {
        this.listeners.remove(listener);
        if (this.listeners.isEmpty() && (this.row instanceof UncheckedRow)) {
            this.realm.sharedRealm.realmNotifier.removeChangeListeners(this);
        }
    }

    public void removeAllChangeListeners() {
        this.listeners.clear();
        if (this.row instanceof UncheckedRow) {
            this.realm.sharedRealm.realmNotifier.removeChangeListeners(this);
        }
    }

    public void setTableVersion$realm() {
        if (this.row.getTable() != null) {
            this.currentTableVersion = this.row.getTable().getVersion();
        }
    }

    public boolean isUnderConstruction() {
        return this.underConstruction;
    }

    public void setConstructionFinished() {
        this.underConstruction = false;
        this.excludeFields = null;
    }

    private void registerToRealmNotifier() {
        if (this.realm.sharedRealm != null && !this.realm.sharedRealm.isClosed()) {
            this.realm.sharedRealm.realmNotifier.addChangeListener(this, new RealmChangeListener<ProxyState<E>>() {
                public void onChange(ProxyState<E> proxyState) {
                    long tableVersion = -1;
                    if (ProxyState.this.row.isAttached()) {
                        tableVersion = ProxyState.this.row.getTable().getVersion();
                    }
                    if (ProxyState.this.currentTableVersion != tableVersion) {
                        ProxyState.this.currentTableVersion = tableVersion;
                        ProxyState.this.notifyChangeListeners();
                    }
                }
            });
        }
    }

    public boolean isLoaded() {
        return !(this.row instanceof PendingRow);
    }

    public void load() {
        if (this.row instanceof PendingRow) {
            this.row = ((PendingRow) this.row).executeQuery();
            if (!(this.row instanceof InvalidRow)) {
                registerToRealmNotifier();
            }
            notifyChangeListeners();
        }
    }

    public void onQueryFinished(Row row2) {
        this.row = row2;
        this.currentTableVersion = row2.getTable().getVersion();
        notifyChangeListeners();
        registerToRealmNotifier();
    }
}
