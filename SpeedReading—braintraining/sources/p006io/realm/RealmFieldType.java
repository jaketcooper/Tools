package p006io.realm;

import java.nio.ByteBuffer;
import java.util.Date;
import p006io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.RealmFieldType */
public enum RealmFieldType {
    INTEGER(0),
    BOOLEAN(1),
    STRING(2),
    BINARY(4),
    UNSUPPORTED_TABLE(5),
    UNSUPPORTED_MIXED(6),
    UNSUPPORTED_DATE(7),
    DATE(8),
    FLOAT(9),
    DOUBLE(10),
    OBJECT(12),
    LIST(13);
    
    private static RealmFieldType[] typeList;
    private final int nativeValue;

    static {
        typeList = new RealmFieldType[15];
        RealmFieldType[] columnTypes = values();
        for (int i = 0; i < columnTypes.length; i++) {
            typeList[columnTypes[i].nativeValue] = columnTypes[i];
        }
    }

    private RealmFieldType(int nativeValue2) {
        this.nativeValue = nativeValue2;
    }

    public int getNativeValue() {
        return this.nativeValue;
    }

    public boolean isValid(Object obj) {
        switch (this.nativeValue) {
            case 0:
                if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                    return true;
                }
                return false;
            case 1:
                return obj instanceof Boolean;
            case 2:
                return obj instanceof String;
            case 4:
                if ((obj instanceof byte[]) || (obj instanceof ByteBuffer)) {
                    return true;
                }
                return false;
            case 5:
                if (obj == null || (obj instanceof Object[][])) {
                    return true;
                }
                return false;
            case 7:
                return obj instanceof Date;
            case 8:
                return obj instanceof Date;
            case 9:
                return obj instanceof Float;
            case 10:
                return obj instanceof Double;
            case 12:
            case 13:
            case 14:
                return false;
            default:
                throw new RuntimeException("Unsupported Realm type:  " + this);
        }
    }

    public static RealmFieldType fromNativeValue(int value) {
        RealmFieldType e;
        if (value >= 0 && value < typeList.length && (e = typeList[value]) != null) {
            return e;
        }
        throw new IllegalArgumentException("Invalid native Realm type: " + value);
    }
}
