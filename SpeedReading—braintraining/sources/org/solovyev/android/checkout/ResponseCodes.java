package org.solovyev.android.checkout;

public final class ResponseCodes {
    public static final int ACCOUNT_ERROR = 2;
    public static final int BILLING_UNAVAILABLE = 3;
    public static final int DEVELOPER_ERROR = 5;
    public static final int ERROR = 6;
    public static final int EXCEPTION = 10001;
    public static final int ITEM_ALREADY_OWNED = 7;
    public static final int ITEM_NOT_OWNED = 8;
    public static final int ITEM_UNAVAILABLE = 4;
    public static final int NULL_INTENT = 10003;

    /* renamed from: OK */
    public static final int f184OK = 0;
    public static final int SERVICE_NOT_CONNECTED = 10000;
    public static final int USER_CANCELED = 1;
    public static final int WRONG_SIGNATURE = 10002;

    private ResponseCodes() {
        throw new AssertionError();
    }

    public static String toString(int code) {
        switch (code) {
            case 0:
                return "OK";
            case 1:
                return "USER_CANCELED";
            case 2:
                return "ACCOUNT_ERROR";
            case 3:
                return "BILLING_UNAVAILABLE";
            case 4:
                return "ITEM_UNAVAILABLE";
            case 5:
                return "DEVELOPER_ERROR";
            case 6:
                return "ERROR";
            case 7:
                return "ITEM_ALREADY_OWNED";
            case 8:
                return "ITEM_NOT_OWNED";
            case SERVICE_NOT_CONNECTED /*10000*/:
                return "SERVICE_NOT_CONNECTED";
            case EXCEPTION /*10001*/:
                return "EXCEPTION";
            case WRONG_SIGNATURE /*10002*/:
                return "WRONG_SIGNATURE";
            case NULL_INTENT /*10003*/:
                return "NULL_INTENT";
            default:
                return "UNKNOWN";
        }
    }
}
