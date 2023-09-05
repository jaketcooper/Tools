package com.safonov.speedreading.reader.library.library.view;

class LibraryCoverColorHelper {
    LibraryCoverColorHelper() {
    }

    static int getBookCoverColor(char firstLetter) {
        char c = Character.toUpperCase(firstLetter);
        if (c >= '0' && c <= '9') {
            return -1739917;
        }
        if (c == 'A' || c == 'B' || c == 1040 || c == 1041 || c == 1042) {
            return -1023342;
        }
        if (c == 'C' || c == 'D' || c == 1043 || c == 1044 || c == 1045) {
            return -4560696;
        }
        if (c == 'E' || c == 'F' || c == 1025 || c == 1046 || c == 1047) {
            return -6982195;
        }
        if (c == 'G' || c == 'H' || c == 1048 || c == 1049 || c == 1050) {
            return -8812853;
        }
        if (c == 'I' || c == 'J' || c == 1051 || c == 1052 || c == 1053) {
            return -10177034;
        }
        if (c == 'K' || c == 'L' || c == 1054 || c == 1055 || c == 1056) {
            return -11549705;
        }
        if (c == 'M' || c == 'N' || c == 1057 || c == 1058 || c == 1059) {
            return -11677471;
        }
        if (c == 'O' || c == 'P' || c == 1060 || c == 1061 || c == 1062) {
            return -11684180;
        }
        if (c == 'Q' || c == 'R' || c == 1063 || c == 1064 || c == 1065) {
            return -8271996;
        }
        if (c == 'S' || c == 'T' || c == 1066 || c == 1067 || c == 1068) {
            return -5319295;
        }
        if (c == 'U' || c == 'V' || c == 1069 || c == 1070 || c == 1071) {
            return -30107;
        }
        if (c == 'W' || c == 'X') {
            return -2825897;
        }
        if (c == 'Y' || c == 'Z') {
            return -10929;
        }
        return -18611;
    }
}
