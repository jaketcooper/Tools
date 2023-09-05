package p006io.realm;

import java.util.Collections;
import java.util.Date;
import p006io.realm.RealmModel;
import p006io.realm.internal.Collection;
import p006io.realm.internal.LinkView;
import p006io.realm.internal.PendingRow;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.Row;
import p006io.realm.internal.SortDescriptor;
import p006io.realm.internal.Table;
import p006io.realm.internal.TableQuery;

/* renamed from: io.realm.RealmQuery */
public class RealmQuery<E extends RealmModel> {
    static final String ASYNC_QUERY_WRONG_THREAD_MESSAGE = "Async query cannot be created on current thread.";
    private static final String EMPTY_VALUES = "Non-empty 'values' must be provided.";
    private static final String TYPE_MISMATCH = "Field '%s': type mismatch - %s expected.";
    private String className;
    private Class<E> clazz;
    private LinkView linkView;
    private TableQuery query;
    private BaseRealm realm;
    private RealmObjectSchema schema;
    private Table table;

    public static <E extends RealmModel> RealmQuery<E> createQuery(Realm realm2, Class<E> clazz2) {
        return new RealmQuery<>(realm2, clazz2);
    }

    public static <E extends RealmModel> RealmQuery<E> createDynamicQuery(DynamicRealm realm2, String className2) {
        return new RealmQuery<>((BaseRealm) realm2, className2);
    }

    public static <E extends RealmModel> RealmQuery<E> createQueryFromResult(RealmResults<E> queryResults) {
        if (queryResults.classSpec != null) {
            return new RealmQuery<>(queryResults, queryResults.classSpec);
        }
        return new RealmQuery<>((RealmResults<DynamicRealmObject>) queryResults, queryResults.className);
    }

    public static <E extends RealmModel> RealmQuery<E> createQueryFromList(RealmList<E> list) {
        if (list.clazz != null) {
            return new RealmQuery<>(list.realm, list.view, list.clazz);
        }
        return new RealmQuery<>(list.realm, list.view, list.className);
    }

    private RealmQuery(Realm realm2, Class<E> clazz2) {
        this.realm = realm2;
        this.clazz = clazz2;
        this.schema = realm2.schema.getSchemaForClass((Class<? extends RealmModel>) clazz2);
        this.table = this.schema.table;
        this.linkView = null;
        this.query = this.table.where();
    }

    private RealmQuery(RealmResults<E> queryResults, Class<E> clazz2) {
        this.realm = queryResults.realm;
        this.clazz = clazz2;
        this.schema = this.realm.schema.getSchemaForClass((Class<? extends RealmModel>) clazz2);
        this.table = queryResults.getTable();
        this.linkView = null;
        this.query = queryResults.getCollection().where();
    }

    private RealmQuery(BaseRealm realm2, LinkView linkView2, Class<E> clazz2) {
        this.realm = realm2;
        this.clazz = clazz2;
        this.schema = realm2.schema.getSchemaForClass((Class<? extends RealmModel>) clazz2);
        this.table = this.schema.table;
        this.linkView = linkView2;
        this.query = linkView2.where();
    }

    private RealmQuery(BaseRealm realm2, String className2) {
        this.realm = realm2;
        this.className = className2;
        this.schema = realm2.schema.getSchemaForClass(className2);
        this.table = this.schema.table;
        this.query = this.table.where();
    }

    private RealmQuery(RealmResults<DynamicRealmObject> queryResults, String className2) {
        this.realm = queryResults.realm;
        this.className = className2;
        this.schema = this.realm.schema.getSchemaForClass(className2);
        this.table = this.schema.table;
        this.query = queryResults.getCollection().where();
    }

    private RealmQuery(BaseRealm realm2, LinkView linkView2, String className2) {
        this.realm = realm2;
        this.className = className2;
        this.schema = realm2.schema.getSchemaForClass(className2);
        this.table = this.schema.table;
        this.linkView = linkView2;
        this.query = linkView2.where();
    }

    public boolean isValid() {
        if (this.realm == null || this.realm.isClosed()) {
            return false;
        }
        if (this.linkView != null) {
            return this.linkView.isAttached();
        }
        if (this.table == null || !this.table.getTable().isValid()) {
            return false;
        }
        return true;
    }

    public RealmQuery<E> isNull(String fieldName) {
        this.realm.checkIfValid();
        this.query.isNull(this.schema.getColumnIndices(fieldName, new RealmFieldType[0]));
        return this;
    }

    public RealmQuery<E> isNotNull(String fieldName) {
        this.realm.checkIfValid();
        this.query.isNotNull(this.schema.getColumnIndices(fieldName, new RealmFieldType[0]));
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, String value) {
        return equalTo(fieldName, value, Case.SENSITIVE);
    }

    public RealmQuery<E> equalTo(String fieldName, String value, Case casing) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value, casing);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, String value, Case casing) {
        this.query.equalTo(this.schema.getColumnIndices(fieldName, RealmFieldType.STRING), value, casing);
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Byte value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Byte value) {
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, (long) value.byteValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, byte[] value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.BINARY);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, value);
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Short value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Short value) {
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, (long) value.shortValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Integer value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Integer value) {
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, (long) value.intValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Long value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Long value) {
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, value.longValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Double value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Double value) {
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.DOUBLE);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, value.doubleValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Float value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Float value) {
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.FLOAT);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, value.floatValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Boolean value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Boolean value) {
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.BOOLEAN);
        if (value == null) {
            this.query.isNull(columnIndices);
        } else {
            this.query.equalTo(columnIndices, value.booleanValue());
        }
        return this;
    }

    public RealmQuery<E> equalTo(String fieldName, Date value) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(fieldName, value);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String fieldName, Date value) {
        this.query.equalTo(this.schema.getColumnIndices(fieldName, RealmFieldType.DATE), value);
        return this;
    }

    /* renamed from: in */
    public RealmQuery<E> mo17564in(String fieldName, String[] values) {
        return mo17565in(fieldName, values, Case.SENSITIVE);
    }

    /* renamed from: in */
    public RealmQuery<E> mo17565in(String fieldName, String[] values, Case casing) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0], casing);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i], casing);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17558in(String fieldName, Byte[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17563in(String fieldName, Short[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17561in(String fieldName, Integer[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17562in(String fieldName, Long[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17559in(String fieldName, Double[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17560in(String fieldName, Float[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17557in(String fieldName, Boolean[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    /* renamed from: in */
    public RealmQuery<E> mo17566in(String fieldName, Date[] values) {
        this.realm.checkIfValid();
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException(EMPTY_VALUES);
        }
        beginGroupWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[0]);
        for (int i = 1; i < values.length; i++) {
            orWithoutThreadValidation().equalToWithoutThreadValidation(fieldName, values[i]);
        }
        return endGroupWithoutThreadValidation();
    }

    public RealmQuery<E> notEqualTo(String fieldName, String value) {
        return notEqualTo(fieldName, value, Case.SENSITIVE);
    }

    public RealmQuery<E> notEqualTo(String fieldName, String value, Case casing) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.STRING);
        if (columnIndices.length <= 1 || casing.getValue()) {
            this.query.notEqualTo(columnIndices, value, casing);
            return this;
        }
        throw new IllegalArgumentException("Link queries cannot be case insensitive - coming soon.");
    }

    public RealmQuery<E> notEqualTo(String fieldName, Byte value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, (long) value.byteValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, byte[] value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.BINARY);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, value);
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, Short value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, (long) value.shortValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, Integer value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, (long) value.intValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, Long value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, value.longValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, Double value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.DOUBLE);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, value.doubleValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, Float value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.FLOAT);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, value.floatValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, Boolean value) {
        boolean z = true;
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.BOOLEAN);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            TableQuery tableQuery = this.query;
            if (value.booleanValue()) {
                z = false;
            }
            tableQuery.equalTo(columnIndices, z);
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String fieldName, Date value) {
        this.realm.checkIfValid();
        long[] columnIndices = this.schema.getColumnIndices(fieldName, RealmFieldType.DATE);
        if (value == null) {
            this.query.isNotNull(columnIndices);
        } else {
            this.query.notEqualTo(columnIndices, value);
        }
        return this;
    }

    public RealmQuery<E> greaterThan(String fieldName, int value) {
        this.realm.checkIfValid();
        this.query.greaterThan(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), (long) value);
        return this;
    }

    public RealmQuery<E> greaterThan(String fieldName, long value) {
        this.realm.checkIfValid();
        this.query.greaterThan(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), value);
        return this;
    }

    public RealmQuery<E> greaterThan(String fieldName, double value) {
        this.realm.checkIfValid();
        this.query.greaterThan(this.schema.getColumnIndices(fieldName, RealmFieldType.DOUBLE), value);
        return this;
    }

    public RealmQuery<E> greaterThan(String fieldName, float value) {
        this.realm.checkIfValid();
        this.query.greaterThan(this.schema.getColumnIndices(fieldName, RealmFieldType.FLOAT), value);
        return this;
    }

    public RealmQuery<E> greaterThan(String fieldName, Date value) {
        this.realm.checkIfValid();
        this.query.greaterThan(this.schema.getColumnIndices(fieldName, RealmFieldType.DATE), value);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String fieldName, int value) {
        this.realm.checkIfValid();
        this.query.greaterThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), (long) value);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String fieldName, long value) {
        this.realm.checkIfValid();
        this.query.greaterThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), value);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String fieldName, double value) {
        this.realm.checkIfValid();
        this.query.greaterThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.DOUBLE), value);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String fieldName, float value) {
        this.realm.checkIfValid();
        this.query.greaterThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.FLOAT), value);
        return this;
    }

    public RealmQuery<E> greaterThanOrEqualTo(String fieldName, Date value) {
        this.realm.checkIfValid();
        this.query.greaterThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.DATE), value);
        return this;
    }

    public RealmQuery<E> lessThan(String fieldName, int value) {
        this.realm.checkIfValid();
        this.query.lessThan(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), (long) value);
        return this;
    }

    public RealmQuery<E> lessThan(String fieldName, long value) {
        this.realm.checkIfValid();
        this.query.lessThan(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), value);
        return this;
    }

    public RealmQuery<E> lessThan(String fieldName, double value) {
        this.realm.checkIfValid();
        this.query.lessThan(this.schema.getColumnIndices(fieldName, RealmFieldType.DOUBLE), value);
        return this;
    }

    public RealmQuery<E> lessThan(String fieldName, float value) {
        this.realm.checkIfValid();
        this.query.lessThan(this.schema.getColumnIndices(fieldName, RealmFieldType.FLOAT), value);
        return this;
    }

    public RealmQuery<E> lessThan(String fieldName, Date value) {
        this.realm.checkIfValid();
        this.query.lessThan(this.schema.getColumnIndices(fieldName, RealmFieldType.DATE), value);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String fieldName, int value) {
        this.realm.checkIfValid();
        this.query.lessThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), (long) value);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String fieldName, long value) {
        this.realm.checkIfValid();
        this.query.lessThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), value);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String fieldName, double value) {
        this.realm.checkIfValid();
        this.query.lessThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.DOUBLE), value);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String fieldName, float value) {
        this.realm.checkIfValid();
        this.query.lessThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.FLOAT), value);
        return this;
    }

    public RealmQuery<E> lessThanOrEqualTo(String fieldName, Date value) {
        this.realm.checkIfValid();
        this.query.lessThanOrEqual(this.schema.getColumnIndices(fieldName, RealmFieldType.DATE), value);
        return this;
    }

    public RealmQuery<E> between(String fieldName, int from, int to) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), (long) from, (long) to);
        return this;
    }

    public RealmQuery<E> between(String fieldName, long from, long to) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(fieldName, RealmFieldType.INTEGER), from, to);
        return this;
    }

    public RealmQuery<E> between(String fieldName, double from, double to) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(fieldName, RealmFieldType.DOUBLE), from, to);
        return this;
    }

    public RealmQuery<E> between(String fieldName, float from, float to) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(fieldName, RealmFieldType.FLOAT), from, to);
        return this;
    }

    public RealmQuery<E> between(String fieldName, Date from, Date to) {
        this.realm.checkIfValid();
        this.query.between(this.schema.getColumnIndices(fieldName, RealmFieldType.DATE), from, to);
        return this;
    }

    public RealmQuery<E> contains(String fieldName, String value) {
        return contains(fieldName, value, Case.SENSITIVE);
    }

    public RealmQuery<E> contains(String fieldName, String value, Case casing) {
        this.realm.checkIfValid();
        this.query.contains(this.schema.getColumnIndices(fieldName, RealmFieldType.STRING), value, casing);
        return this;
    }

    public RealmQuery<E> beginsWith(String fieldName, String value) {
        return beginsWith(fieldName, value, Case.SENSITIVE);
    }

    public RealmQuery<E> beginsWith(String fieldName, String value, Case casing) {
        this.realm.checkIfValid();
        this.query.beginsWith(this.schema.getColumnIndices(fieldName, RealmFieldType.STRING), value, casing);
        return this;
    }

    public RealmQuery<E> endsWith(String fieldName, String value) {
        return endsWith(fieldName, value, Case.SENSITIVE);
    }

    public RealmQuery<E> endsWith(String fieldName, String value, Case casing) {
        this.realm.checkIfValid();
        this.query.endsWith(this.schema.getColumnIndices(fieldName, RealmFieldType.STRING), value, casing);
        return this;
    }

    public RealmQuery<E> like(String fieldName, String value) {
        return like(fieldName, value, Case.SENSITIVE);
    }

    public RealmQuery<E> like(String fieldName, String value, Case casing) {
        this.realm.checkIfValid();
        this.query.like(this.schema.getColumnIndices(fieldName, RealmFieldType.STRING), value, casing);
        return this;
    }

    public RealmQuery<E> beginGroup() {
        this.realm.checkIfValid();
        return beginGroupWithoutThreadValidation();
    }

    private RealmQuery<E> beginGroupWithoutThreadValidation() {
        this.query.group();
        return this;
    }

    public RealmQuery<E> endGroup() {
        this.realm.checkIfValid();
        return endGroupWithoutThreadValidation();
    }

    private RealmQuery<E> endGroupWithoutThreadValidation() {
        this.query.endGroup();
        return this;
    }

    /* renamed from: or */
    public RealmQuery<E> mo17600or() {
        this.realm.checkIfValid();
        return orWithoutThreadValidation();
    }

    private RealmQuery<E> orWithoutThreadValidation() {
        this.query.mo18066or();
        return this;
    }

    public RealmQuery<E> not() {
        this.realm.checkIfValid();
        this.query.not();
        return this;
    }

    public RealmQuery<E> isEmpty(String fieldName) {
        this.realm.checkIfValid();
        this.query.isEmpty(this.schema.getColumnIndices(fieldName, RealmFieldType.STRING, RealmFieldType.BINARY, RealmFieldType.LIST));
        return this;
    }

    public RealmQuery<E> isNotEmpty(String fieldName) {
        this.realm.checkIfValid();
        this.query.isNotEmpty(this.schema.getColumnIndices(fieldName, RealmFieldType.STRING, RealmFieldType.BINARY, RealmFieldType.LIST));
        return this;
    }

    public RealmResults<E> distinct(String fieldName) {
        this.realm.checkIfValid();
        return createRealmResults(this.query, (SortDescriptor) null, SortDescriptor.getInstanceForDistinct(this.query.getTable(), fieldName), true);
    }

    public RealmResults<E> distinctAsync(String fieldName) {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, (SortDescriptor) null, SortDescriptor.getInstanceForDistinct(this.query.getTable(), fieldName), false);
    }

    public RealmResults<E> distinct(String firstFieldName, String... remainingFieldNames) {
        this.realm.checkIfValid();
        String[] fieldNames = new String[(remainingFieldNames.length + 1)];
        fieldNames[0] = firstFieldName;
        System.arraycopy(remainingFieldNames, 0, fieldNames, 1, remainingFieldNames.length);
        return createRealmResults(this.query, (SortDescriptor) null, SortDescriptor.getInstanceForDistinct(this.table.getTable(), fieldNames), true);
    }

    public Number sum(String fieldName) {
        this.realm.checkIfValid();
        long columnIndex = this.schema.getAndCheckFieldIndex(fieldName);
        switch (this.table.getColumnType(columnIndex)) {
            case INTEGER:
                return Long.valueOf(this.query.sumInt(columnIndex));
            case FLOAT:
                return Double.valueOf(this.query.sumFloat(columnIndex));
            case DOUBLE:
                return Double.valueOf(this.query.sumDouble(columnIndex));
            default:
                throw new IllegalArgumentException(String.format(TYPE_MISMATCH, new Object[]{fieldName, "int, float or double"}));
        }
    }

    public double average(String fieldName) {
        this.realm.checkIfValid();
        long columnIndex = this.schema.getAndCheckFieldIndex(fieldName);
        switch (this.table.getColumnType(columnIndex)) {
            case INTEGER:
                return this.query.averageInt(columnIndex);
            case FLOAT:
                return this.query.averageFloat(columnIndex);
            case DOUBLE:
                return this.query.averageDouble(columnIndex);
            default:
                throw new IllegalArgumentException(String.format(TYPE_MISMATCH, new Object[]{fieldName, "int, float or double"}));
        }
    }

    public Number min(String fieldName) {
        this.realm.checkIfValid();
        long columnIndex = this.schema.getAndCheckFieldIndex(fieldName);
        switch (this.table.getColumnType(columnIndex)) {
            case INTEGER:
                return this.query.minimumInt(columnIndex);
            case FLOAT:
                return this.query.minimumFloat(columnIndex);
            case DOUBLE:
                return this.query.minimumDouble(columnIndex);
            default:
                throw new IllegalArgumentException(String.format(TYPE_MISMATCH, new Object[]{fieldName, "int, float or double"}));
        }
    }

    public Date minimumDate(String fieldName) {
        this.realm.checkIfValid();
        return this.query.minimumDate(this.schema.getAndCheckFieldIndex(fieldName));
    }

    public Number max(String fieldName) {
        this.realm.checkIfValid();
        long columnIndex = this.schema.getAndCheckFieldIndex(fieldName);
        switch (this.table.getColumnType(columnIndex)) {
            case INTEGER:
                return this.query.maximumInt(columnIndex);
            case FLOAT:
                return this.query.maximumFloat(columnIndex);
            case DOUBLE:
                return this.query.maximumDouble(columnIndex);
            default:
                throw new IllegalArgumentException(String.format(TYPE_MISMATCH, new Object[]{fieldName, "int, float or double"}));
        }
    }

    public Date maximumDate(String fieldName) {
        this.realm.checkIfValid();
        return this.query.maximumDate(this.schema.getAndCheckFieldIndex(fieldName));
    }

    public long count() {
        this.realm.checkIfValid();
        return this.query.count();
    }

    public RealmResults<E> findAll() {
        this.realm.checkIfValid();
        return createRealmResults(this.query, (SortDescriptor) null, (SortDescriptor) null, true);
    }

    public RealmResults<E> findAllAsync() {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, (SortDescriptor) null, (SortDescriptor) null, false);
    }

    public RealmResults<E> findAllSorted(String fieldName, Sort sortOrder) {
        this.realm.checkIfValid();
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(this.query.getTable(), fieldName, sortOrder), (SortDescriptor) null, true);
    }

    public RealmResults<E> findAllSortedAsync(String fieldName, Sort sortOrder) {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(this.query.getTable(), fieldName, sortOrder), (SortDescriptor) null, false);
    }

    public RealmResults<E> findAllSorted(String fieldName) {
        return findAllSorted(fieldName, Sort.ASCENDING);
    }

    public RealmResults<E> findAllSortedAsync(String fieldName) {
        return findAllSortedAsync(fieldName, Sort.ASCENDING);
    }

    public RealmResults<E> findAllSorted(String[] fieldNames, Sort[] sortOrders) {
        this.realm.checkIfValid();
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(this.query.getTable(), fieldNames, sortOrders), (SortDescriptor) null, true);
    }

    private boolean isDynamicQuery() {
        return this.className != null;
    }

    public RealmResults<E> findAllSortedAsync(String[] fieldNames, Sort[] sortOrders) {
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(this.query.getTable(), fieldNames, sortOrders), (SortDescriptor) null, false);
    }

    public RealmResults<E> findAllSorted(String fieldName1, Sort sortOrder1, String fieldName2, Sort sortOrder2) {
        return findAllSorted(new String[]{fieldName1, fieldName2}, new Sort[]{sortOrder1, sortOrder2});
    }

    public RealmResults<E> findAllSortedAsync(String fieldName1, Sort sortOrder1, String fieldName2, Sort sortOrder2) {
        return findAllSortedAsync(new String[]{fieldName1, fieldName2}, new Sort[]{sortOrder1, sortOrder2});
    }

    public E findFirst() {
        this.realm.checkIfValid();
        long tableRowIndex = getSourceRowIndexForFirstObject();
        if (tableRowIndex >= 0) {
            return this.realm.get(this.clazz, this.className, tableRowIndex);
        }
        return null;
    }

    public E findFirstAsync() {
        Row row;
        E result;
        this.realm.checkIfValid();
        this.realm.sharedRealm.capabilities.checkCanDeliverNotification(ASYNC_QUERY_WRONG_THREAD_MESSAGE);
        if (this.realm.isInTransaction()) {
            row = new Collection(this.realm.sharedRealm, this.query).firstUncheckedRow();
        } else {
            row = new PendingRow(this.realm.sharedRealm, this.query, (SortDescriptor) null, isDynamicQuery());
        }
        if (isDynamicQuery()) {
            result = new DynamicRealmObject(this.realm, row);
        } else {
            result = this.realm.getConfiguration().getSchemaMediator().newInstance(this.clazz, this.realm, row, this.realm.getSchema().getColumnInfo(this.clazz), false, Collections.emptyList());
        }
        if (row instanceof PendingRow) {
            ((PendingRow) row).setFrontEnd(((RealmObjectProxy) result).realmGet$proxyState());
        }
        return result;
    }

    private RealmResults<E> createRealmResults(TableQuery query2, SortDescriptor sortDescriptor, SortDescriptor distinctDescriptor, boolean loadResults) {
        RealmResults<E> results;
        Collection collection = new Collection(this.realm.sharedRealm, query2, sortDescriptor, distinctDescriptor);
        if (isDynamicQuery()) {
            results = new RealmResults<>(this.realm, collection, this.className);
        } else {
            results = new RealmResults<>(this.realm, collection, this.clazz);
        }
        if (loadResults) {
            results.load();
        }
        return results;
    }

    private long getSourceRowIndexForFirstObject() {
        return this.query.find();
    }
}
