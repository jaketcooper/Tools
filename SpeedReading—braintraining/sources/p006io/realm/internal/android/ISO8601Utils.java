package p006io.realm.internal.android;

import java.util.TimeZone;

/* renamed from: io.realm.internal.android.ISO8601Utils */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final TimeZone TIMEZONE_Z = TIMEZONE_UTC;
    private static final String UTC_ID = "UTC";

    /* JADX WARNING: Removed duplicated region for block: B:45:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r32, java.text.ParsePosition r33) throws java.text.ParseException {
        /*
            int r20 = r33.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            int r21 = r20 + 4
            r0 = r32
            r1 = r20
            r2 = r21
            int r28 = parseInt(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 45
            r0 = r32
            r1 = r21
            r2 = r29
            boolean r29 = checkOffset(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 == 0) goto L_0x0022
            int r20 = r21 + 1
            r21 = r20
        L_0x0022:
            int r20 = r21 + 2
            r0 = r32
            r1 = r21
            r2 = r20
            int r18 = parseInt(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 45
            r0 = r32
            r1 = r20
            r2 = r29
            boolean r29 = checkOffset(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 == 0) goto L_0x0315
            int r20 = r20 + 1
            r21 = r20
        L_0x0040:
            int r20 = r21 + 2
            r0 = r32
            r1 = r21
            r2 = r20
            int r7 = parseInt(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r14 = 0
            r17 = 0
            r23 = 0
            r16 = 0
            r29 = 84
            r0 = r32
            r1 = r20
            r2 = r29
            boolean r13 = checkOffset(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r13 != 0) goto L_0x0082
            int r29 = r32.length()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r29
            r1 = r20
            if (r0 > r1) goto L_0x0082
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            int r29 = r18 + -1
            r0 = r28
            r1 = r29
            r5.<init>(r0, r1, r7)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r33
            r1 = r20
            r0.setIndex(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.util.Date r29 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
        L_0x0081:
            return r29
        L_0x0082:
            if (r13 == 0) goto L_0x0139
            int r20 = r20 + 1
            int r21 = r20 + 2
            r0 = r32
            r1 = r20
            r2 = r21
            int r14 = parseInt(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 58
            r0 = r32
            r1 = r21
            r2 = r29
            boolean r29 = checkOffset(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 == 0) goto L_0x00a4
            int r20 = r21 + 1
            r21 = r20
        L_0x00a4:
            int r20 = r21 + 2
            r0 = r32
            r1 = r21
            r2 = r20
            int r17 = parseInt(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 58
            r0 = r32
            r1 = r20
            r2 = r29
            boolean r29 = checkOffset(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 == 0) goto L_0x0311
            int r20 = r20 + 1
            r21 = r20
        L_0x00c2:
            int r29 = r32.length()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r29
            r1 = r21
            if (r0 <= r1) goto L_0x030d
            r0 = r32
            r1 = r21
            char r4 = r0.charAt(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 90
            r0 = r29
            if (r4 == r0) goto L_0x030d
            r29 = 43
            r0 = r29
            if (r4 == r0) goto L_0x030d
            r29 = 45
            r0 = r29
            if (r4 == r0) goto L_0x030d
            int r20 = r21 + 2
            r0 = r32
            r1 = r21
            r2 = r20
            int r23 = parseInt(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 59
            r0 = r23
            r1 = r29
            if (r0 <= r1) goto L_0x0104
            r29 = 63
            r0 = r23
            r1 = r29
            if (r0 >= r1) goto L_0x0104
            r23 = 59
        L_0x0104:
            r29 = 46
            r0 = r32
            r1 = r20
            r2 = r29
            boolean r29 = checkOffset(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 == 0) goto L_0x0139
            int r20 = r20 + 1
            int r29 = r20 + 1
            r0 = r32
            r1 = r29
            int r9 = indexOfNonDigit(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            int r29 = r20 + 3
            r0 = r29
            int r22 = java.lang.Math.min(r9, r0)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r32
            r1 = r20
            r2 = r22
            int r12 = parseInt(r0, r1, r2)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            int r29 = r22 - r20
            switch(r29) {
                case 1: goto L_0x01b4;
                case 2: goto L_0x01b1;
                default: goto L_0x0135;
            }     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
        L_0x0135:
            r16 = r12
        L_0x0137:
            r20 = r9
        L_0x0139:
            int r29 = r32.length()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r29
            r1 = r20
            if (r0 > r1) goto L_0x01b7
            java.lang.IllegalArgumentException r29 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r30 = "No time zone indicator"
            r29.<init>(r30)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            throw r29     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
        L_0x014b:
            r8 = move-exception
            r11 = r8
        L_0x014d:
            if (r32 != 0) goto L_0x02ee
            r15 = 0
        L_0x0150:
            java.lang.String r19 = r11.getMessage()
            if (r19 == 0) goto L_0x015c
            boolean r29 = r19.isEmpty()
            if (r29 == 0) goto L_0x017d
        L_0x015c:
            java.lang.StringBuilder r29 = new java.lang.StringBuilder
            r29.<init>()
            java.lang.String r30 = "("
            java.lang.StringBuilder r29 = r29.append(r30)
            java.lang.Class r30 = r11.getClass()
            java.lang.String r30 = r30.getName()
            java.lang.StringBuilder r29 = r29.append(r30)
            java.lang.String r30 = ")"
            java.lang.StringBuilder r29 = r29.append(r30)
            java.lang.String r19 = r29.toString()
        L_0x017d:
            java.text.ParseException r10 = new java.text.ParseException
            java.lang.StringBuilder r29 = new java.lang.StringBuilder
            r29.<init>()
            java.lang.String r30 = "Failed to parse date ["
            java.lang.StringBuilder r29 = r29.append(r30)
            r0 = r29
            java.lang.StringBuilder r29 = r0.append(r15)
            java.lang.String r30 = "]: "
            java.lang.StringBuilder r29 = r29.append(r30)
            r0 = r29
            r1 = r19
            java.lang.StringBuilder r29 = r0.append(r1)
            java.lang.String r29 = r29.toString()
            int r30 = r33.getIndex()
            r0 = r29
            r1 = r30
            r10.<init>(r0, r1)
            r10.initCause(r11)
            throw r10
        L_0x01b1:
            int r16 = r12 * 10
            goto L_0x0137
        L_0x01b4:
            int r16 = r12 * 100
            goto L_0x0137
        L_0x01b7:
            r0 = r32
            r1 = r20
            char r26 = r0.charAt(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 90
            r0 = r26
            r1 = r29
            if (r0 != r1) goto L_0x0223
            java.util.TimeZone r24 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            int r20 = r20 + 1
        L_0x01cb:
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r24
            r5.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 0
            r0 = r29
            r5.setLenient(r0)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 1
            r0 = r29
            r1 = r28
            r5.set(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 2
            int r30 = r18 + -1
            r0 = r29
            r1 = r30
            r5.set(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 5
            r0 = r29
            r5.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 11
            r0 = r29
            r5.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 12
            r0 = r29
            r1 = r17
            r5.set(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 13
            r0 = r29
            r1 = r23
            r5.set(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29 = 14
            r0 = r29
            r1 = r16
            r5.set(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r33
            r1 = r20
            r0.setIndex(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.util.Date r29 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            goto L_0x0081
        L_0x0223:
            r29 = 43
            r0 = r26
            r1 = r29
            if (r0 == r1) goto L_0x0233
            r29 = 45
            r0 = r26
            r1 = r29
            if (r0 != r1) goto L_0x02c7
        L_0x0233:
            r0 = r32
            r1 = r20
            java.lang.String r27 = r0.substring(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            int r29 = r27.length()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            int r20 = r20 + r29
            java.lang.String r29 = "+0000"
            r0 = r29
            r1 = r27
            boolean r29 = r0.equals(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 != 0) goto L_0x0259
            java.lang.String r29 = "+00:00"
            r0 = r29
            r1 = r27
            boolean r29 = r0.equals(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 == 0) goto L_0x025d
        L_0x0259:
            java.util.TimeZone r24 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            goto L_0x01cb
        L_0x025d:
            java.lang.StringBuilder r29 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r30 = "GMT"
            java.lang.StringBuilder r29 = r29.append(r30)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r29
            r1 = r27
            java.lang.StringBuilder r29 = r0.append(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r25 = r29.toString()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.util.TimeZone r24 = java.util.TimeZone.getTimeZone(r25)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r3 = r24.getID()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r25
            boolean r29 = r3.equals(r0)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 != 0) goto L_0x01cb
            java.lang.String r29 = ":"
            java.lang.String r30 = ""
            r0 = r29
            r1 = r30
            java.lang.String r6 = r3.replace(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r25
            boolean r29 = r6.equals(r0)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            if (r29 != 0) goto L_0x01cb
            java.lang.IndexOutOfBoundsException r29 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.StringBuilder r30 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r30.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r31 = "Mismatching time zone indicator: "
            java.lang.StringBuilder r30 = r30.append(r31)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r30
            r1 = r25
            java.lang.StringBuilder r30 = r0.append(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r31 = " given, resolves to "
            java.lang.StringBuilder r30 = r30.append(r31)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r31 = r24.getID()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.StringBuilder r30 = r30.append(r31)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r30 = r30.toString()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29.<init>(r30)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            throw r29     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
        L_0x02c3:
            r8 = move-exception
            r11 = r8
            goto L_0x014d
        L_0x02c7:
            java.lang.IndexOutOfBoundsException r29 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.StringBuilder r30 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r30.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r31 = "Invalid time zone indicator '"
            java.lang.StringBuilder r30 = r30.append(r31)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r0 = r30
            r1 = r26
            java.lang.StringBuilder r30 = r0.append(r1)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r31 = "'"
            java.lang.StringBuilder r30 = r30.append(r31)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            java.lang.String r30 = r30.toString()     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            r29.<init>(r30)     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
            throw r29     // Catch:{ IndexOutOfBoundsException -> 0x014b, NumberFormatException -> 0x02c3, IllegalArgumentException -> 0x02ea }
        L_0x02ea:
            r8 = move-exception
            r11 = r8
            goto L_0x014d
        L_0x02ee:
            java.lang.StringBuilder r29 = new java.lang.StringBuilder
            r29.<init>()
            r30 = 34
            java.lang.StringBuilder r29 = r29.append(r30)
            r0 = r29
            r1 = r32
            java.lang.StringBuilder r29 = r0.append(r1)
            java.lang.String r30 = "'"
            java.lang.StringBuilder r29 = r29.append(r30)
            java.lang.String r15 = r29.toString()
            goto L_0x0150
        L_0x030d:
            r20 = r21
            goto L_0x0139
        L_0x0311:
            r21 = r20
            goto L_0x00c2
        L_0x0315:
            r21 = r20
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: p006io.realm.internal.android.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(String value, int offset, char expected) {
        return offset < value.length() && value.charAt(offset) == expected;
    }

    private static int parseInt(String value, int beginIndex, int endIndex) throws NumberFormatException {
        int i;
        if (beginIndex < 0 || endIndex > value.length() || beginIndex > endIndex) {
            throw new NumberFormatException(value);
        }
        int i2 = beginIndex;
        int result = 0;
        if (i2 < endIndex) {
            i = i2 + 1;
            int digit = Character.digit(value.charAt(i2), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
            result = -digit;
        } else {
            i = i2;
        }
        while (i < endIndex) {
            int i3 = i + 1;
            int digit2 = Character.digit(value.charAt(i), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
            result = (result * 10) - digit2;
            i = i3;
        }
        return -result;
    }

    private static int indexOfNonDigit(String string, int offset) {
        int i = offset;
        while (i < string.length()) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return i;
            }
            i++;
        }
        return string.length();
    }
}
