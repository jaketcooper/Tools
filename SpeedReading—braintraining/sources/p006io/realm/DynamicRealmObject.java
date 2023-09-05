package p006io.realm;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import p006io.realm.internal.LinkView;
import p006io.realm.internal.RealmObjectProxy;
import p006io.realm.internal.Row;
import p006io.realm.internal.Table;
import p006io.realm.internal.UncheckedRow;
import p006io.realm.internal.android.JsonUtils;

/* renamed from: io.realm.DynamicRealmObject */
public class DynamicRealmObject extends RealmObject implements RealmObjectProxy {
    private final ProxyState proxyState = new ProxyState(this);

    public DynamicRealmObject(RealmModel obj) {
        if (obj == null) {
            throw new IllegalArgumentException("A non-null object must be provided.");
        } else if (obj instanceof DynamicRealmObject) {
            throw new IllegalArgumentException("The object is already a DynamicRealmObject: " + obj);
        } else if (!RealmObject.isManaged(obj)) {
            throw new IllegalArgumentException("An object managed by Realm must be provided. This is an unmanaged object.");
        } else if (!RealmObject.isValid(obj)) {
            throw new IllegalArgumentException("A valid object managed by Realm must be provided. This object was deleted.");
        } else {
            RealmObjectProxy proxy = (RealmObjectProxy) obj;
            Row row = proxy.realmGet$proxyState().getRow$realm();
            this.proxyState.setRealm$realm(proxy.realmGet$proxyState().getRealm$realm());
            this.proxyState.setRow$realm(((UncheckedRow) row).convertToChecked());
            this.proxyState.setConstructionFinished();
        }
    }

    DynamicRealmObject(BaseRealm realm, Row row) {
        this.proxyState.setRealm$realm(realm);
        this.proxyState.setRow$realm(row);
        this.proxyState.setConstructionFinished();
    }

    public <E> E get(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        RealmFieldType type = this.proxyState.getRow$realm().getColumnType(columnIndex);
        switch (type) {
            case BOOLEAN:
                return Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(columnIndex));
            case INTEGER:
                return Long.valueOf(this.proxyState.getRow$realm().getLong(columnIndex));
            case FLOAT:
                return Float.valueOf(this.proxyState.getRow$realm().getFloat(columnIndex));
            case DOUBLE:
                return Double.valueOf(this.proxyState.getRow$realm().getDouble(columnIndex));
            case STRING:
                return this.proxyState.getRow$realm().getString(columnIndex);
            case BINARY:
                return this.proxyState.getRow$realm().getBinaryByteArray(columnIndex);
            case DATE:
                return this.proxyState.getRow$realm().getDate(columnIndex);
            case OBJECT:
                return getObject(fieldName);
            case LIST:
                return getList(fieldName);
            default:
                throw new IllegalStateException("Field type not supported: " + type);
        }
    }

    public boolean getBoolean(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        try {
            return this.proxyState.getRow$realm().getBoolean(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(fieldName, columnIndex, RealmFieldType.BOOLEAN);
            throw e;
        }
    }

    public int getInt(String fieldName) {
        return (int) getLong(fieldName);
    }

    public short getShort(String fieldName) {
        return (short) ((int) getLong(fieldName));
    }

    public long getLong(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        try {
            return this.proxyState.getRow$realm().getLong(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(fieldName, columnIndex, RealmFieldType.INTEGER);
            throw e;
        }
    }

    public byte getByte(String fieldName) {
        return (byte) ((int) getLong(fieldName));
    }

    public float getFloat(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        try {
            return this.proxyState.getRow$realm().getFloat(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(fieldName, columnIndex, RealmFieldType.FLOAT);
            throw e;
        }
    }

    public double getDouble(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        try {
            return this.proxyState.getRow$realm().getDouble(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(fieldName, columnIndex, RealmFieldType.DOUBLE);
            throw e;
        }
    }

    public byte[] getBlob(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        try {
            return this.proxyState.getRow$realm().getBinaryByteArray(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(fieldName, columnIndex, RealmFieldType.BINARY);
            throw e;
        }
    }

    public String getString(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        try {
            return this.proxyState.getRow$realm().getString(columnIndex);
        } catch (IllegalArgumentException e) {
            checkFieldType(fieldName, columnIndex, RealmFieldType.STRING);
            throw e;
        }
    }

    public Date getDate(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        checkFieldType(fieldName, columnIndex, RealmFieldType.DATE);
        if (this.proxyState.getRow$realm().isNull(columnIndex)) {
            return null;
        }
        return this.proxyState.getRow$realm().getDate(columnIndex);
    }

    public DynamicRealmObject getObject(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        checkFieldType(fieldName, columnIndex, RealmFieldType.OBJECT);
        if (this.proxyState.getRow$realm().isNullLink(columnIndex)) {
            return null;
        }
        return new DynamicRealmObject(this.proxyState.getRealm$realm(), this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getCheckedRow(this.proxyState.getRow$realm().getLink(columnIndex)));
    }

    public RealmList<DynamicRealmObject> getList(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        try {
            LinkView linkView = this.proxyState.getRow$realm().getLinkList(columnIndex);
            return new RealmList<>(RealmSchema.getSchemaForTable(linkView.getTargetTable()), linkView, this.proxyState.getRealm$realm());
        } catch (IllegalArgumentException e) {
            checkFieldType(fieldName, columnIndex, RealmFieldType.LIST);
            throw e;
        }
    }

    public boolean isNull(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        switch (this.proxyState.getRow$realm().getColumnType(columnIndex)) {
            case BOOLEAN:
            case INTEGER:
            case FLOAT:
            case DOUBLE:
            case STRING:
            case BINARY:
            case DATE:
                return this.proxyState.getRow$realm().isNull(columnIndex);
            case OBJECT:
                return this.proxyState.getRow$realm().isNullLink(columnIndex);
            default:
                return false;
        }
    }

    public boolean hasField(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        if (fieldName == null || fieldName.isEmpty()) {
            return false;
        }
        return this.proxyState.getRow$realm().hasColumn(fieldName);
    }

    public String[] getFieldNames() {
        this.proxyState.getRealm$realm().checkIfValid();
        String[] keys = new String[((int) this.proxyState.getRow$realm().getColumnCount())];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = this.proxyState.getRow$realm().getColumnName((long) i);
        }
        return keys;
    }

    public void set(String fieldName, Object value) {
        this.proxyState.getRealm$realm().checkIfValid();
        boolean isString = value instanceof String;
        String strValue = isString ? (String) value : null;
        RealmFieldType type = this.proxyState.getRow$realm().getColumnType(this.proxyState.getRow$realm().getColumnIndex(fieldName));
        if (isString && type != RealmFieldType.STRING) {
            switch (type) {
                case BOOLEAN:
                    value = Boolean.valueOf(Boolean.parseBoolean(strValue));
                    break;
                case INTEGER:
                    value = Long.valueOf(Long.parseLong(strValue));
                    break;
                case FLOAT:
                    value = Float.valueOf(Float.parseFloat(strValue));
                    break;
                case DOUBLE:
                    value = Double.valueOf(Double.parseDouble(strValue));
                    break;
                case DATE:
                    value = JsonUtils.stringToDate(strValue);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Field %s is not a String field, and the provide value could not be automatically converted: %s. Use a typedsetter instead", new Object[]{fieldName, value}));
            }
        }
        if (value == null) {
            setNull(fieldName);
        } else {
            setValue(fieldName, value);
        }
    }

    private void setValue(String fieldName, Object value) {
        Class<?> valueClass = value.getClass();
        if (valueClass == Boolean.class) {
            setBoolean(fieldName, ((Boolean) value).booleanValue());
        } else if (valueClass == Short.class) {
            setShort(fieldName, ((Short) value).shortValue());
        } else if (valueClass == Integer.class) {
            setInt(fieldName, ((Integer) value).intValue());
        } else if (valueClass == Long.class) {
            setLong(fieldName, ((Long) value).longValue());
        } else if (valueClass == Byte.class) {
            setByte(fieldName, ((Byte) value).byteValue());
        } else if (valueClass == Float.class) {
            setFloat(fieldName, ((Float) value).floatValue());
        } else if (valueClass == Double.class) {
            setDouble(fieldName, ((Double) value).doubleValue());
        } else if (valueClass == String.class) {
            setString(fieldName, (String) value);
        } else if (value instanceof Date) {
            setDate(fieldName, (Date) value);
        } else if (value instanceof byte[]) {
            setBlob(fieldName, (byte[]) value);
        } else if (valueClass == DynamicRealmObject.class) {
            setObject(fieldName, (DynamicRealmObject) value);
        } else if (valueClass == RealmList.class) {
            setList(fieldName, (RealmList) value);
        } else {
            throw new IllegalArgumentException("Value is of an type not supported: " + value.getClass());
        }
    }

    public void setBoolean(String fieldName, boolean value) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setBoolean(this.proxyState.getRow$realm().getColumnIndex(fieldName), value);
    }

    public void setShort(String fieldName, short value) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(fieldName);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(fieldName), (long) value);
    }

    public void setInt(String fieldName, int value) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(fieldName);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(fieldName), (long) value);
    }

    public void setLong(String fieldName, long value) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(fieldName);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(fieldName), value);
    }

    public void setByte(String fieldName, byte value) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(fieldName);
        this.proxyState.getRow$realm().setLong(this.proxyState.getRow$realm().getColumnIndex(fieldName), (long) value);
    }

    public void setFloat(String fieldName, float value) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setFloat(this.proxyState.getRow$realm().getColumnIndex(fieldName), value);
    }

    public void setDouble(String fieldName, double value) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setDouble(this.proxyState.getRow$realm().getColumnIndex(fieldName), value);
    }

    public void setString(String fieldName, String value) {
        this.proxyState.getRealm$realm().checkIfValid();
        checkIsPrimaryKey(fieldName);
        this.proxyState.getRow$realm().setString(this.proxyState.getRow$realm().getColumnIndex(fieldName), value);
    }

    public void setBlob(String fieldName, byte[] value) {
        this.proxyState.getRealm$realm().checkIfValid();
        this.proxyState.getRow$realm().setBinaryByteArray(this.proxyState.getRow$realm().getColumnIndex(fieldName), value);
    }

    public void setDate(String fieldName, Date value) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        if (value == null) {
            this.proxyState.getRow$realm().setNull(columnIndex);
        } else {
            this.proxyState.getRow$realm().setDate(columnIndex, value);
        }
    }

    public void setObject(String fieldName, DynamicRealmObject value) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        if (value == null) {
            this.proxyState.getRow$realm().nullifyLink(columnIndex);
        } else if (value.proxyState.getRealm$realm() == null || value.proxyState.getRow$realm() == null) {
            throw new IllegalArgumentException("Cannot link to objects that are not part of the Realm.");
        } else if (this.proxyState.getRealm$realm() != value.proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("Cannot add an object from another Realm instance.");
        } else {
            Table table = this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex);
            Table inputTable = value.proxyState.getRow$realm().getTable();
            if (!table.hasSameSchema(inputTable)) {
                throw new IllegalArgumentException(String.format("Type of object is wrong. Was %s, expected %s", new Object[]{inputTable.getName(), table.getName()}));
            } else {
                this.proxyState.getRow$realm().setLink(columnIndex, value.proxyState.getRow$realm().getIndex());
            }
        }
    }

    public void setList(String fieldName, RealmList<DynamicRealmObject> list) {
        String listType;
        boolean typeValidated;
        this.proxyState.getRealm$realm().checkIfValid();
        if (list == null) {
            throw new IllegalArgumentException("Null values not allowed for lists");
        }
        LinkView links = this.proxyState.getRow$realm().getLinkList(this.proxyState.getRow$realm().getColumnIndex(fieldName));
        Table linkTargetTable = links.getTargetTable();
        String linkTargetTableName = Table.tableNameToClassName(linkTargetTable.getName());
        if (list.className == null && list.clazz == null) {
            typeValidated = false;
        } else {
            if (list.className != null) {
                listType = list.className;
            } else {
                listType = Table.tableNameToClassName(this.proxyState.getRealm$realm().schema.getTable((Class<? extends RealmModel>) list.clazz).getName());
            }
            if (!linkTargetTableName.equals(listType)) {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "The elements in the list are not the proper type. Was %s expected %s.", new Object[]{listType, linkTargetTableName}));
            }
            typeValidated = true;
        }
        int listLength = list.size();
        long[] indices = new long[listLength];
        int i = 0;
        while (i < listLength) {
            RealmObjectProxy obj = list.get(i);
            if (obj.realmGet$proxyState().getRealm$realm() != this.proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element in 'list' must belong to the same Realm instance.");
            } else if (typeValidated || linkTargetTable.hasSameSchema(obj.realmGet$proxyState().getRow$realm().getTable())) {
                indices[i] = obj.realmGet$proxyState().getRow$realm().getIndex();
                i++;
            } else {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Element at index %d is not the proper type. Was '%s' expected '%s'.", new Object[]{Integer.valueOf(i), Table.tableNameToClassName(obj.realmGet$proxyState().getRow$realm().getTable().getName()), linkTargetTableName}));
            }
        }
        links.clear();
        for (int i2 = 0; i2 < listLength; i2++) {
            links.add(indices[i2]);
        }
    }

    public void setNull(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        long columnIndex = this.proxyState.getRow$realm().getColumnIndex(fieldName);
        if (this.proxyState.getRow$realm().getColumnType(columnIndex) == RealmFieldType.OBJECT) {
            this.proxyState.getRow$realm().nullifyLink(columnIndex);
            return;
        }
        checkIsPrimaryKey(fieldName);
        this.proxyState.getRow$realm().setNull(columnIndex);
    }

    public String getType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return RealmSchema.getSchemaForTable(this.proxyState.getRow$realm().getTable());
    }

    public RealmFieldType getFieldType(String fieldName) {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getColumnType(this.proxyState.getRow$realm().getColumnIndex(fieldName));
    }

    private void checkFieldType(String fieldName, long columnIndex, RealmFieldType expectedType) {
        RealmFieldType columnType = this.proxyState.getRow$realm().getColumnType(columnIndex);
        if (columnType != expectedType) {
            String expectedIndefiniteVowel = "";
            if (expectedType == RealmFieldType.INTEGER || expectedType == RealmFieldType.OBJECT) {
                expectedIndefiniteVowel = "n";
            }
            String columnTypeIndefiniteVowel = "";
            if (columnType == RealmFieldType.INTEGER || columnType == RealmFieldType.OBJECT) {
                columnTypeIndefiniteVowel = "n";
            }
            throw new IllegalArgumentException(String.format("'%s' is not a%s '%s', but a%s '%s'.", new Object[]{fieldName, expectedIndefiniteVowel, expectedType, columnTypeIndefiniteVowel, columnType}));
        }
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        this.proxyState.getRealm$realm().checkIfValid();
        String realmName = this.proxyState.getRealm$realm().getPath();
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        long rowIndex = this.proxyState.getRow$realm().getIndex();
        if (realmName != null) {
            i = realmName.hashCode();
        } else {
            i = 0;
        }
        int i3 = (i + 527) * 31;
        if (tableName != null) {
            i2 = tableName.hashCode();
        }
        return ((i3 + i2) * 31) + ((int) ((rowIndex >>> 32) ^ rowIndex));
    }

    public boolean equals(Object o) {
        boolean z = true;
        this.proxyState.getRealm$realm().checkIfValid();
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DynamicRealmObject other = (DynamicRealmObject) o;
        String path = this.proxyState.getRealm$realm().getPath();
        String otherPath = other.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(otherPath)) {
                return false;
            }
        } else if (otherPath != null) {
            return false;
        }
        String tableName = this.proxyState.getRow$realm().getTable().getName();
        String otherTableName = other.proxyState.getRow$realm().getTable().getName();
        if (tableName != null) {
            if (!tableName.equals(otherTableName)) {
                return false;
            }
        } else if (otherTableName != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != other.proxyState.getRow$realm().getIndex()) {
            z = false;
        }
        return z;
    }

    public String toString() {
        String tableNameToClassName;
        this.proxyState.getRealm$realm().checkIfValid();
        if (!this.proxyState.getRow$realm().isAttached()) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder(Table.tableNameToClassName(this.proxyState.getRow$realm().getTable().getName()) + " = [");
        for (String field : getFieldNames()) {
            long columnIndex = this.proxyState.getRow$realm().getColumnIndex(field);
            RealmFieldType type = this.proxyState.getRow$realm().getColumnType(columnIndex);
            sb.append("{");
            sb.append(field).append(":");
            switch (type) {
                case BOOLEAN:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Boolean.valueOf(this.proxyState.getRow$realm().getBoolean(columnIndex)));
                    break;
                case INTEGER:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Long.valueOf(this.proxyState.getRow$realm().getLong(columnIndex)));
                    break;
                case FLOAT:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Float.valueOf(this.proxyState.getRow$realm().getFloat(columnIndex)));
                    break;
                case DOUBLE:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : Double.valueOf(this.proxyState.getRow$realm().getDouble(columnIndex)));
                    break;
                case STRING:
                    sb.append(this.proxyState.getRow$realm().getString(columnIndex));
                    break;
                case BINARY:
                    sb.append(Arrays.toString(this.proxyState.getRow$realm().getBinaryByteArray(columnIndex)));
                    break;
                case DATE:
                    sb.append(this.proxyState.getRow$realm().isNull(columnIndex) ? "null" : this.proxyState.getRow$realm().getDate(columnIndex));
                    break;
                case OBJECT:
                    if (this.proxyState.getRow$realm().isNullLink(columnIndex)) {
                        tableNameToClassName = "null";
                    } else {
                        tableNameToClassName = Table.tableNameToClassName(this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getName());
                    }
                    sb.append(tableNameToClassName);
                    break;
                case LIST:
                    sb.append(String.format("RealmList<%s>[%s]", new Object[]{Table.tableNameToClassName(this.proxyState.getRow$realm().getTable().getLinkTarget(columnIndex).getName()), Long.valueOf(this.proxyState.getRow$realm().getLinkList(columnIndex).size())}));
                    break;
                default:
                    sb.append("?");
                    break;
            }
            sb.append("}, ");
        }
        sb.replace(sb.length() - 2, sb.length(), "");
        sb.append("]");
        return sb.toString();
    }

    public void realm$injectObjectContext() {
    }

    public ProxyState realmGet$proxyState() {
        return this.proxyState;
    }

    private void checkIsPrimaryKey(String fieldName) {
        RealmObjectSchema objectSchema = this.proxyState.getRealm$realm().getSchema().getSchemaForClass(getType());
        if (objectSchema.hasPrimaryKey() && objectSchema.getPrimaryKey().equals(fieldName)) {
            throw new IllegalArgumentException(String.format("Primary key field '%s' cannot be changed after object was created.", new Object[]{fieldName}));
        }
    }
}
