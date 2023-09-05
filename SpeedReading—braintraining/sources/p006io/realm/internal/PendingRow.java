package p006io.realm.internal;

import java.lang.ref.WeakReference;
import java.util.Date;
import p006io.realm.RealmChangeListener;
import p006io.realm.RealmFieldType;

/* renamed from: io.realm.internal.PendingRow */
public class PendingRow implements Row {
    private static final String PROXY_NOT_SET_MESSAGE = "The 'frontEnd' has not been set.";
    private static final String QUERY_EXECUTED_MESSAGE = "The query has been executed. This 'PendingRow' is not valid anymore.";
    private static final String QUERY_NOT_RETURNED_MESSAGE = "The pending query has not been executed.";
    /* access modifiers changed from: private */
    public WeakReference<FrontEnd> frontEndRef;
    private RealmChangeListener<PendingRow> listener;
    /* access modifiers changed from: private */
    public Collection pendingCollection;
    private boolean returnCheckedRow;

    /* renamed from: io.realm.internal.PendingRow$FrontEnd */
    public interface FrontEnd {
        void onQueryFinished(Row row);
    }

    public PendingRow(SharedRealm sharedRealm, TableQuery query, SortDescriptor sortDescriptor, final boolean returnCheckedRow2) {
        this.pendingCollection = new Collection(sharedRealm, query, sortDescriptor, (SortDescriptor) null);
        this.listener = new RealmChangeListener<PendingRow>() {
            public void onChange(PendingRow pendingRow) {
                Row row;
                if (PendingRow.this.frontEndRef == null) {
                    throw new IllegalStateException(PendingRow.PROXY_NOT_SET_MESSAGE);
                }
                FrontEnd frontEnd = (FrontEnd) PendingRow.this.frontEndRef.get();
                if (frontEnd == null) {
                    PendingRow.this.clearPendingCollection();
                } else if (PendingRow.this.pendingCollection.isValid()) {
                    UncheckedRow uncheckedRow = PendingRow.this.pendingCollection.firstUncheckedRow();
                    if (uncheckedRow != null) {
                        if (returnCheckedRow2) {
                            row = CheckedRow.getFromRow(uncheckedRow);
                        } else {
                            row = uncheckedRow;
                        }
                        frontEnd.onQueryFinished(row);
                        PendingRow.this.clearPendingCollection();
                    }
                } else {
                    PendingRow.this.clearPendingCollection();
                }
            }
        };
        this.pendingCollection.addListener(this, this.listener);
        this.returnCheckedRow = returnCheckedRow2;
    }

    public void setFrontEnd(FrontEnd frontEnd) {
        this.frontEndRef = new WeakReference<>(frontEnd);
    }

    public long getColumnCount() {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public String getColumnName(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public long getColumnIndex(String columnName) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public RealmFieldType getColumnType(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public Table getTable() {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public long getIndex() {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public long getLong(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public boolean getBoolean(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public float getFloat(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public double getDouble(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public Date getDate(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public String getString(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public byte[] getBinaryByteArray(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public long getLink(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public boolean isNullLink(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public LinkView getLinkList(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setLong(long columnIndex, long value) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setBoolean(long columnIndex, boolean value) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setFloat(long columnIndex, float value) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setDouble(long columnIndex, double value) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setDate(long columnIndex, Date date) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setString(long columnIndex, String value) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setBinaryByteArray(long columnIndex, byte[] data) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setLink(long columnIndex, long value) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void nullifyLink(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public boolean isNull(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public void setNull(long columnIndex) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    public boolean isAttached() {
        return false;
    }

    public boolean hasColumn(String fieldName) {
        throw new IllegalStateException(QUERY_NOT_RETURNED_MESSAGE);
    }

    /* access modifiers changed from: private */
    public void clearPendingCollection() {
        this.pendingCollection.removeListener(this, this.listener);
        this.pendingCollection = null;
        this.listener = null;
    }

    public Row executeQuery() {
        if (this.pendingCollection == null) {
            throw new IllegalStateException(QUERY_EXECUTED_MESSAGE);
        } else if (this.frontEndRef == null) {
            throw new IllegalStateException(PROXY_NOT_SET_MESSAGE);
        } else {
            UncheckedRow uncheckedRow = this.pendingCollection.firstUncheckedRow();
            clearPendingCollection();
            if (uncheckedRow == null) {
                return InvalidRow.INSTANCE;
            }
            return this.returnCheckedRow ? CheckedRow.getFromRow(uncheckedRow) : uncheckedRow;
        }
    }
}
