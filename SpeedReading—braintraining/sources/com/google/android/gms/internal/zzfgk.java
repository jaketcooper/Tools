package com.google.android.gms.internal;

final class zzfgk {
    static String zzaq(zzfdp zzfdp) {
        zzfgl zzfgl = new zzfgl(zzfdp);
        StringBuilder sb = new StringBuilder(zzfgl.size());
        for (int i = 0; i < zzfgl.size(); i++) {
            byte zzke = zzfgl.zzke(i);
            switch (zzke) {
                case 7:
                    sb.append("\\a");
                    break;
                case 8:
                    sb.append("\\b");
                    break;
                case 9:
                    sb.append("\\t");
                    break;
                case 10:
                    sb.append("\\n");
                    break;
                case 11:
                    sb.append("\\v");
                    break;
                case 12:
                    sb.append("\\f");
                    break;
                case 13:
                    sb.append("\\r");
                    break;
                case 34:
                    sb.append("\\\"");
                    break;
                case 39:
                    sb.append("\\'");
                    break;
                case 92:
                    sb.append("\\\\");
                    break;
                default:
                    if (zzke >= 32 && zzke <= 126) {
                        sb.append((char) zzke);
                        break;
                    } else {
                        sb.append('\\');
                        sb.append((char) (((zzke >>> 6) & 3) + 48));
                        sb.append((char) (((zzke >>> 3) & 7) + 48));
                        sb.append((char) ((zzke & 7) + 48));
                        break;
                    }
            }
        }
        return sb.toString();
    }
}
