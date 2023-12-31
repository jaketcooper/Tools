package p006io.realm.internal;

import java.util.Date;
import p006io.realm.Case;
import p006io.realm.Sort;

/* renamed from: io.realm.internal.TableQuery */
public class TableQuery implements NativeObject {
    private static final String DATE_NULL_ERROR_MESSAGE = "Date value in query criteria must not be null.";
    private static final String STRING_NULL_ERROR_MESSAGE = "String value in query criteria must not be null.";
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    protected boolean DEBUG = false;
    private final Context context;
    protected long nativePtr;
    private boolean queryValidated = true;
    protected final Table table;

    private native double nativeAverageDouble(long j, long j2, long j3, long j4, long j5);

    private native double nativeAverageFloat(long j, long j2, long j3, long j4, long j5);

    private native double nativeAverageInt(long j, long j2, long j3, long j4, long j5);

    private native void nativeBeginsWith(long j, long[] jArr, String str, boolean z);

    private native void nativeBetween(long j, long[] jArr, double d, double d2);

    private native void nativeBetween(long j, long[] jArr, float f, float f2);

    private native void nativeBetween(long j, long[] jArr, long j2, long j3);

    private native void nativeBetweenTimestamp(long j, long[] jArr, long j2, long j3);

    private native void nativeContains(long j, long[] jArr, String str, boolean z);

    private native long nativeCount(long j, long j2, long j3, long j4);

    private native void nativeEndGroup(long j);

    private native void nativeEndsWith(long j, long[] jArr, String str, boolean z);

    private native void nativeEqual(long j, long[] jArr, double d);

    private native void nativeEqual(long j, long[] jArr, float f);

    private native void nativeEqual(long j, long[] jArr, long j2);

    private native void nativeEqual(long j, long[] jArr, String str, boolean z);

    private native void nativeEqual(long j, long[] jArr, boolean z);

    private native void nativeEqual(long j, long[] jArr, byte[] bArr);

    private native void nativeEqualTimestamp(long j, long[] jArr, long j2);

    private native long nativeFind(long j, long j2);

    private native long nativeFindAll(long j, long j2, long j3, long j4);

    private static native long nativeGetFinalizerPtr();

    private native void nativeGreater(long j, long[] jArr, double d);

    private native void nativeGreater(long j, long[] jArr, float f);

    private native void nativeGreater(long j, long[] jArr, long j2);

    private native void nativeGreaterEqual(long j, long[] jArr, double d);

    private native void nativeGreaterEqual(long j, long[] jArr, float f);

    private native void nativeGreaterEqual(long j, long[] jArr, long j2);

    private native void nativeGreaterEqualTimestamp(long j, long[] jArr, long j2);

    private native void nativeGreaterTimestamp(long j, long[] jArr, long j2);

    private native void nativeGroup(long j);

    private native long nativeHandoverQuery(long j, long j2);

    private static native long nativeImportHandoverRowIntoSharedGroup(long j, long j2);

    private native void nativeIsEmpty(long j, long[] jArr);

    private native void nativeIsNotNull(long j, long[] jArr);

    private native void nativeIsNull(long j, long[] jArr);

    private native void nativeLess(long j, long[] jArr, double d);

    private native void nativeLess(long j, long[] jArr, float f);

    private native void nativeLess(long j, long[] jArr, long j2);

    private native void nativeLessEqual(long j, long[] jArr, double d);

    private native void nativeLessEqual(long j, long[] jArr, float f);

    private native void nativeLessEqual(long j, long[] jArr, long j2);

    private native void nativeLessEqualTimestamp(long j, long[] jArr, long j2);

    private native void nativeLessTimestamp(long j, long[] jArr, long j2);

    private native void nativeLike(long j, long[] jArr, String str, boolean z);

    private native Double nativeMaximumDouble(long j, long j2, long j3, long j4, long j5);

    private native Float nativeMaximumFloat(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMaximumInt(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMaximumTimestamp(long j, long j2, long j3, long j4, long j5);

    private native Double nativeMinimumDouble(long j, long j2, long j3, long j4, long j5);

    private native Float nativeMinimumFloat(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMinimumInt(long j, long j2, long j3, long j4, long j5);

    private native Long nativeMinimumTimestamp(long j, long j2, long j3, long j4, long j5);

    private native void nativeNot(long j);

    private native void nativeNotEqual(long j, long[] jArr, double d);

    private native void nativeNotEqual(long j, long[] jArr, float f);

    private native void nativeNotEqual(long j, long[] jArr, long j2);

    private native void nativeNotEqual(long j, long[] jArr, String str, boolean z);

    private native void nativeNotEqual(long j, long[] jArr, byte[] bArr);

    private native void nativeNotEqualTimestamp(long j, long[] jArr, long j2);

    private native void nativeOr(long j);

    private native long nativeRemove(long j);

    private native double nativeSumDouble(long j, long j2, long j3, long j4, long j5);

    private native double nativeSumFloat(long j, long j2, long j3, long j4, long j5);

    private native long nativeSumInt(long j, long j2, long j3, long j4, long j5);

    private native String nativeValidateQuery(long j);

    public TableQuery(Context context2, Table table2, long nativeQueryPtr) {
        if (this.DEBUG) {
            System.err.println("++++++ new TableQuery, ptr= " + nativeQueryPtr);
        }
        this.context = context2;
        this.table = table2;
        this.nativePtr = nativeQueryPtr;
        context2.addReference(this);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public Table getTable() {
        return this.table;
    }

    /* access modifiers changed from: package-private */
    public void validateQuery() {
        if (!this.queryValidated) {
            String invalidMessage = nativeValidateQuery(this.nativePtr);
            if (invalidMessage.equals("")) {
                this.queryValidated = true;
                return;
            }
            throw new UnsupportedOperationException(invalidMessage);
        }
    }

    public TableQuery group() {
        nativeGroup(this.nativePtr);
        this.queryValidated = false;
        return this;
    }

    public TableQuery endGroup() {
        nativeEndGroup(this.nativePtr);
        this.queryValidated = false;
        return this;
    }

    /* renamed from: or */
    public TableQuery mo18066or() {
        nativeOr(this.nativePtr);
        this.queryValidated = false;
        return this;
    }

    public TableQuery not() {
        nativeNot(this.nativePtr);
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndexes, long value) {
        nativeEqual(this.nativePtr, columnIndexes, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] columnIndex, long value) {
        nativeNotEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long[] columnIndex, long value) {
        nativeGreater(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThanOrEqual(long[] columnIndex, long value) {
        nativeGreaterEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long[] columnIndex, long value) {
        nativeLess(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThanOrEqual(long[] columnIndex, long value) {
        nativeLessEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery between(long[] columnIndex, long value1, long value2) {
        nativeBetween(this.nativePtr, columnIndex, value1, value2);
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndex, float value) {
        nativeEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] columnIndex, float value) {
        nativeNotEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long[] columnIndex, float value) {
        nativeGreater(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThanOrEqual(long[] columnIndex, float value) {
        nativeGreaterEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long[] columnIndex, float value) {
        nativeLess(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThanOrEqual(long[] columnIndex, float value) {
        nativeLessEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery between(long[] columnIndex, float value1, float value2) {
        nativeBetween(this.nativePtr, columnIndex, value1, value2);
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndex, double value) {
        nativeEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] columnIndex, double value) {
        nativeNotEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long[] columnIndex, double value) {
        nativeGreater(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThanOrEqual(long[] columnIndex, double value) {
        nativeGreaterEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long[] columnIndex, double value) {
        nativeLess(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThanOrEqual(long[] columnIndex, double value) {
        nativeLessEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery between(long[] columnIndex, double value1, double value2) {
        nativeBetween(this.nativePtr, columnIndex, value1, value2);
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndex, boolean value) {
        nativeEqual(this.nativePtr, columnIndex, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndex, Date value) {
        if (value == null) {
            nativeIsNull(this.nativePtr, columnIndex);
        } else {
            nativeEqualTimestamp(this.nativePtr, columnIndex, value.getTime());
        }
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] columnIndex, Date value) {
        if (value == null) {
            throw new IllegalArgumentException(DATE_NULL_ERROR_MESSAGE);
        }
        nativeNotEqualTimestamp(this.nativePtr, columnIndex, value.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThan(long[] columnIndex, Date value) {
        if (value == null) {
            throw new IllegalArgumentException(DATE_NULL_ERROR_MESSAGE);
        }
        nativeGreaterTimestamp(this.nativePtr, columnIndex, value.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery greaterThanOrEqual(long[] columnIndex, Date value) {
        if (value == null) {
            throw new IllegalArgumentException(DATE_NULL_ERROR_MESSAGE);
        }
        nativeGreaterEqualTimestamp(this.nativePtr, columnIndex, value.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThan(long[] columnIndex, Date value) {
        if (value == null) {
            throw new IllegalArgumentException(DATE_NULL_ERROR_MESSAGE);
        }
        nativeLessTimestamp(this.nativePtr, columnIndex, value.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery lessThanOrEqual(long[] columnIndex, Date value) {
        if (value == null) {
            throw new IllegalArgumentException(DATE_NULL_ERROR_MESSAGE);
        }
        nativeLessEqualTimestamp(this.nativePtr, columnIndex, value.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery between(long[] columnIndex, Date value1, Date value2) {
        if (value1 == null || value2 == null) {
            throw new IllegalArgumentException("Date values in query criteria must not be null.");
        }
        nativeBetweenTimestamp(this.nativePtr, columnIndex, value1.getTime(), value2.getTime());
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndices, byte[] value) {
        nativeEqual(this.nativePtr, columnIndices, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] columnIndices, byte[] value) {
        nativeNotEqual(this.nativePtr, columnIndices, value);
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndexes, String value, Case caseSensitive) {
        nativeEqual(this.nativePtr, columnIndexes, value, caseSensitive.getValue());
        this.queryValidated = false;
        return this;
    }

    public TableQuery equalTo(long[] columnIndexes, String value) {
        nativeEqual(this.nativePtr, columnIndexes, value, true);
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] columnIndex, String value, Case caseSensitive) {
        nativeNotEqual(this.nativePtr, columnIndex, value, caseSensitive.getValue());
        this.queryValidated = false;
        return this;
    }

    public TableQuery notEqualTo(long[] columnIndex, String value) {
        nativeNotEqual(this.nativePtr, columnIndex, value, true);
        this.queryValidated = false;
        return this;
    }

    public TableQuery beginsWith(long[] columnIndices, String value, Case caseSensitive) {
        nativeBeginsWith(this.nativePtr, columnIndices, value, caseSensitive.getValue());
        this.queryValidated = false;
        return this;
    }

    public TableQuery beginsWith(long[] columnIndices, String value) {
        nativeBeginsWith(this.nativePtr, columnIndices, value, true);
        this.queryValidated = false;
        return this;
    }

    public TableQuery endsWith(long[] columnIndices, String value, Case caseSensitive) {
        nativeEndsWith(this.nativePtr, columnIndices, value, caseSensitive.getValue());
        this.queryValidated = false;
        return this;
    }

    public TableQuery endsWith(long[] columnIndices, String value) {
        nativeEndsWith(this.nativePtr, columnIndices, value, true);
        this.queryValidated = false;
        return this;
    }

    public TableQuery like(long[] columnIndices, String value, Case caseSensitive) {
        nativeLike(this.nativePtr, columnIndices, value, caseSensitive.getValue());
        this.queryValidated = false;
        return this;
    }

    public TableQuery like(long[] columnIndices, String value) {
        nativeLike(this.nativePtr, columnIndices, value, true);
        this.queryValidated = false;
        return this;
    }

    public TableQuery contains(long[] columnIndices, String value, Case caseSensitive) {
        nativeContains(this.nativePtr, columnIndices, value, caseSensitive.getValue());
        this.queryValidated = false;
        return this;
    }

    public TableQuery contains(long[] columnIndices, String value) {
        nativeContains(this.nativePtr, columnIndices, value, true);
        this.queryValidated = false;
        return this;
    }

    public TableQuery isEmpty(long[] columnIndices) {
        nativeIsEmpty(this.nativePtr, columnIndices);
        this.queryValidated = false;
        return this;
    }

    public TableQuery isNotEmpty(long[] columnIndices) {
        return not().isEmpty(columnIndices);
    }

    @Deprecated
    public long find(long fromTableRow) {
        validateQuery();
        return nativeFind(this.nativePtr, fromTableRow);
    }

    public long find() {
        validateQuery();
        return nativeFind(this.nativePtr, 0);
    }

    public static long importHandoverRow(long handoverRowPtr, SharedRealm sharedRealm) {
        return nativeImportHandoverRowIntoSharedGroup(handoverRowPtr, sharedRealm.getNativePtr());
    }

    public long handoverQuery(SharedRealm sharedRealm) {
        return nativeHandoverQuery(sharedRealm.getNativePtr(), this.nativePtr);
    }

    public long sumInt(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeSumInt(this.nativePtr, columnIndex, start, end, limit);
    }

    public long sumInt(long columnIndex) {
        validateQuery();
        return nativeSumInt(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public Long maximumInt(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeMaximumInt(this.nativePtr, columnIndex, start, end, limit);
    }

    public Long maximumInt(long columnIndex) {
        validateQuery();
        return nativeMaximumInt(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public Long minimumInt(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeMinimumInt(this.nativePtr, columnIndex, start, end, limit);
    }

    public Long minimumInt(long columnIndex) {
        validateQuery();
        return nativeMinimumInt(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public double averageInt(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeAverageInt(this.nativePtr, columnIndex, start, end, limit);
    }

    public double averageInt(long columnIndex) {
        validateQuery();
        return nativeAverageInt(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public double sumFloat(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeSumFloat(this.nativePtr, columnIndex, start, end, limit);
    }

    public double sumFloat(long columnIndex) {
        validateQuery();
        return nativeSumFloat(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public Float maximumFloat(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeMaximumFloat(this.nativePtr, columnIndex, start, end, limit);
    }

    public Float maximumFloat(long columnIndex) {
        validateQuery();
        return nativeMaximumFloat(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public Float minimumFloat(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeMinimumFloat(this.nativePtr, columnIndex, start, end, limit);
    }

    public Float minimumFloat(long columnIndex) {
        validateQuery();
        return nativeMinimumFloat(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public double averageFloat(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeAverageFloat(this.nativePtr, columnIndex, start, end, limit);
    }

    public double averageFloat(long columnIndex) {
        validateQuery();
        return nativeAverageFloat(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public double sumDouble(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeSumDouble(this.nativePtr, columnIndex, start, end, limit);
    }

    public double sumDouble(long columnIndex) {
        validateQuery();
        return nativeSumDouble(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public Double maximumDouble(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeMaximumDouble(this.nativePtr, columnIndex, start, end, limit);
    }

    public Double maximumDouble(long columnIndex) {
        validateQuery();
        return nativeMaximumDouble(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public Double minimumDouble(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeMinimumDouble(this.nativePtr, columnIndex, start, end, limit);
    }

    public Double minimumDouble(long columnIndex) {
        validateQuery();
        return nativeMinimumDouble(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public double averageDouble(long columnIndex, long start, long end, long limit) {
        validateQuery();
        return nativeAverageDouble(this.nativePtr, columnIndex, start, end, limit);
    }

    public double averageDouble(long columnIndex) {
        validateQuery();
        return nativeAverageDouble(this.nativePtr, columnIndex, 0, -1, -1);
    }

    public Date maximumDate(long columnIndex, long start, long end, long limit) {
        validateQuery();
        Long result = nativeMaximumTimestamp(this.nativePtr, columnIndex, start, end, limit);
        if (result != null) {
            return new Date(result.longValue());
        }
        return null;
    }

    public Date maximumDate(long columnIndex) {
        validateQuery();
        Long result = nativeMaximumTimestamp(this.nativePtr, columnIndex, 0, -1, -1);
        if (result != null) {
            return new Date(result.longValue());
        }
        return null;
    }

    public Date minimumDate(long columnIndex, long start, long end, long limit) {
        validateQuery();
        Long result = nativeMinimumTimestamp(this.nativePtr, columnIndex, start, end, limit);
        if (result != null) {
            return new Date(result.longValue() * 1000);
        }
        return null;
    }

    public Date minimumDate(long columnIndex) {
        validateQuery();
        Long result = nativeMinimumTimestamp(this.nativePtr, columnIndex, 0, -1, -1);
        if (result != null) {
            return new Date(result.longValue());
        }
        return null;
    }

    public TableQuery isNull(long[] columnIndices) {
        nativeIsNull(this.nativePtr, columnIndices);
        this.queryValidated = false;
        return this;
    }

    public TableQuery isNotNull(long[] columnIndices) {
        nativeIsNotNull(this.nativePtr, columnIndices);
        this.queryValidated = false;
        return this;
    }

    public long count(long start, long end, long limit) {
        validateQuery();
        return nativeCount(this.nativePtr, start, end, limit);
    }

    public long count() {
        validateQuery();
        return nativeCount(this.nativePtr, 0, -1, -1);
    }

    public long remove() {
        validateQuery();
        if (this.table.isImmutable()) {
            throwImmutable();
        }
        return nativeRemove(this.nativePtr);
    }

    public static boolean[] getNativeSortOrderValues(Sort[] sortOrders) {
        boolean[] nativeValues = new boolean[sortOrders.length];
        for (int i = 0; i < sortOrders.length; i++) {
            nativeValues[i] = sortOrders[i].getValue();
        }
        return nativeValues;
    }

    private void throwImmutable() {
        throw new IllegalStateException("Mutable method call during read transaction.");
    }
}
