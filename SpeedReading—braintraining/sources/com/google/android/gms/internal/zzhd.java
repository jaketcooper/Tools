package com.google.android.gms.internal;

@zzzb
public final class zzhd {
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007a, code lost:
        if (((r9 >= 65382 && r9 <= 65437) || (r9 >= 65441 && r9 <= 65500)) != false) goto L_0x007c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] zzb(@android.support.annotation.Nullable java.lang.String r13, boolean r14) {
        /*
            r3 = 1
            r2 = 0
            if (r13 != 0) goto L_0x0006
            r0 = 0
        L_0x0005:
            return r0
        L_0x0006:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            char[] r7 = r13.toCharArray()
            int r8 = r13.length()
            r4 = r2
            r0 = r2
            r1 = r2
        L_0x0016:
            if (r1 >= r8) goto L_0x00e3
            int r9 = java.lang.Character.codePointAt(r7, r1)
            int r10 = java.lang.Character.charCount(r9)
            boolean r5 = java.lang.Character.isLetter(r9)
            if (r5 == 0) goto L_0x009f
            java.lang.Character$UnicodeBlock r5 = java.lang.Character.UnicodeBlock.of(r9)
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.BOPOMOFO
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.BOPOMOFO_EXTENDED
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.HANGUL_JAMO
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.HANGUL_SYLLABLES
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.HIRAGANA
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.KATAKANA
            if (r5 == r11) goto L_0x0062
            java.lang.Character$UnicodeBlock r11 = java.lang.Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS
            if (r5 != r11) goto L_0x009b
        L_0x0062:
            r5 = r3
        L_0x0063:
            if (r5 != 0) goto L_0x007c
            r5 = 65382(0xff66, float:9.162E-41)
            if (r9 < r5) goto L_0x006f
            r5 = 65437(0xff9d, float:9.1697E-41)
            if (r9 <= r5) goto L_0x0079
        L_0x006f:
            r5 = 65441(0xffa1, float:9.1702E-41)
            if (r9 < r5) goto L_0x009d
            r5 = 65500(0xffdc, float:9.1785E-41)
            if (r9 > r5) goto L_0x009d
        L_0x0079:
            r5 = r3
        L_0x007a:
            if (r5 == 0) goto L_0x009f
        L_0x007c:
            r5 = r3
        L_0x007d:
            if (r5 == 0) goto L_0x00a1
            if (r4 == 0) goto L_0x008b
            java.lang.String r4 = new java.lang.String
            int r5 = r1 - r0
            r4.<init>(r7, r0, r5)
            r6.add(r4)
        L_0x008b:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r7, r1, r10)
            r6.add(r4)
            r4 = r0
            r0 = r2
        L_0x0095:
            int r1 = r1 + r10
            r12 = r0
            r0 = r4
            r4 = r12
            goto L_0x0016
        L_0x009b:
            r5 = r2
            goto L_0x0063
        L_0x009d:
            r5 = r2
            goto L_0x007a
        L_0x009f:
            r5 = r2
            goto L_0x007d
        L_0x00a1:
            boolean r5 = java.lang.Character.isLetterOrDigit(r9)
            if (r5 != 0) goto L_0x00b6
            int r5 = java.lang.Character.getType(r9)
            r11 = 6
            if (r5 == r11) goto L_0x00b6
            int r5 = java.lang.Character.getType(r9)
            r11 = 8
            if (r5 != r11) goto L_0x00bc
        L_0x00b6:
            if (r4 != 0) goto L_0x00b9
            r0 = r1
        L_0x00b9:
            r4 = r0
            r0 = r3
            goto L_0x0095
        L_0x00bc:
            if (r14 == 0) goto L_0x00d4
            int r5 = java.lang.Character.charCount(r9)
            if (r5 != r3) goto L_0x00d4
            char[] r5 = java.lang.Character.toChars(r9)
            char r5 = r5[r2]
            r9 = 39
            if (r5 != r9) goto L_0x00d4
            if (r4 != 0) goto L_0x00d1
            r0 = r1
        L_0x00d1:
            r4 = r0
            r0 = r3
            goto L_0x0095
        L_0x00d4:
            if (r4 == 0) goto L_0x00fc
            java.lang.String r4 = new java.lang.String
            int r5 = r1 - r0
            r4.<init>(r7, r0, r5)
            r6.add(r4)
            r4 = r0
            r0 = r2
            goto L_0x0095
        L_0x00e3:
            if (r4 == 0) goto L_0x00ee
            java.lang.String r2 = new java.lang.String
            int r1 = r1 - r0
            r2.<init>(r7, r0, r1)
            r6.add(r2)
        L_0x00ee:
            int r0 = r6.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r0 = r6.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            goto L_0x0005
        L_0x00fc:
            r12 = r4
            r4 = r0
            r0 = r12
            goto L_0x0095
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhd.zzb(java.lang.String, boolean):java.lang.String[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0057, code lost:
        r0 = r0 ^ r5;
        r0 = (r0 ^ (r0 >>> 16)) * -2048144789;
        r0 = (r0 ^ (r0 >>> 13)) * -1028477387;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0069, code lost:
        return r0 ^ (r0 >>> 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0072, code lost:
        r1 = r1 | ((r0[r6 + 1] & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007b, code lost:
        r0 = ((r0[r6] & 255) | r1) * -862048943;
        r0 = (((r0 >>> 17) | (r0 << 15)) * 461845907) ^ r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzz(java.lang.String r10) {
        /*
            r9 = 461845907(0x1b873593, float:2.2368498E-22)
            r8 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            r1 = 0
            java.lang.String r0 = "UTF-8"
            byte[] r0 = r10.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004b }
        L_0x000d:
            int r5 = r0.length
            r2 = r5 & -4
            int r6 = r2 + 0
            r3 = r1
            r2 = r1
        L_0x0014:
            if (r3 >= r6) goto L_0x0051
            byte r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r7 = r3 + 1
            byte r7 = r0[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            r4 = r4 | r7
            int r7 = r3 + 2
            byte r7 = r0[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 16
            r4 = r4 | r7
            int r7 = r3 + 3
            byte r7 = r0[r7]
            int r7 = r7 << 24
            r4 = r4 | r7
            int r4 = r4 * r8
            int r7 = r4 << 15
            int r4 = r4 >>> 17
            r4 = r4 | r7
            int r4 = r4 * r9
            r2 = r2 ^ r4
            int r4 = r2 << 13
            int r2 = r2 >>> 19
            r2 = r2 | r4
            int r2 = r2 * 5
            r4 = -430675100(0xffffffffe6546b64, float:-2.5078068E23)
            int r4 = r4 + r2
            int r2 = r3 + 4
            r3 = r2
            r2 = r4
            goto L_0x0014
        L_0x004b:
            r0 = move-exception
            byte[] r0 = r10.getBytes()
            goto L_0x000d
        L_0x0051:
            r3 = r5 & 3
            switch(r3) {
                case 1: goto L_0x007b;
                case 2: goto L_0x0072;
                case 3: goto L_0x006a;
                default: goto L_0x0056;
            }
        L_0x0056:
            r0 = r2
        L_0x0057:
            r0 = r0 ^ r5
            int r1 = r0 >>> 16
            r0 = r0 ^ r1
            r1 = -2048144789(0xffffffff85ebca6b, float:-2.217365E-35)
            int r0 = r0 * r1
            int r1 = r0 >>> 13
            r0 = r0 ^ r1
            r1 = -1028477387(0xffffffffc2b2ae35, float:-89.34025)
            int r0 = r0 * r1
            int r1 = r0 >>> 16
            r0 = r0 ^ r1
            return r0
        L_0x006a:
            int r1 = r6 + 2
            byte r1 = r0[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 16
        L_0x0072:
            int r3 = r6 + 1
            byte r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            r1 = r1 | r3
        L_0x007b:
            byte r0 = r0[r6]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r0 = r0 | r1
            int r0 = r0 * r8
            int r1 = r0 << 15
            int r0 = r0 >>> 17
            r0 = r0 | r1
            int r0 = r0 * r9
            r0 = r0 ^ r2
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhd.zzz(java.lang.String):int");
    }
}
