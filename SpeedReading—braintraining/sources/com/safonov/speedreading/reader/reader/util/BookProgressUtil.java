package com.safonov.speedreading.reader.reader.util;

import android.support.annotation.NonNull;
import com.safonov.speedreading.reader.reader.util2.SplittedBook;

public class BookProgressUtil {
    public static int getPageIndex(@NonNull SplittedBook splittedBook, long bookOffset) {
        if (bookOffset == 0) {
            return 0;
        }
        int pageIndex = 0;
        long bookLength = 0;
        for (int i = 0; i < splittedBook.getPageCount(); i++) {
            bookLength += (long) splittedBook.getPage(i).length();
            if (bookLength > bookOffset) {
                return pageIndex;
            }
            pageIndex++;
        }
        return pageIndex;
    }

    public static long getBookOffset(@NonNull SplittedBook splittedBook, int pageIndex) {
        if (pageIndex == 0) {
            return 0;
        }
        long bookOffset = 0;
        for (int i = 0; i < pageIndex; i++) {
            bookOffset += (long) splittedBook.getPage(i).length();
        }
        if (pageIndex < splittedBook.getPageCount() - 1) {
            return bookOffset + 1;
        }
        return bookOffset;
    }

    public static int getProgress(int pageIndex, int pageCount) {
        if (pageIndex == 0) {
            return 0;
        }
        return (int) ((((float) (pageIndex + 1)) * 100.0f) / ((float) pageCount));
    }

    public static int getPageFromProgress(int progress, int pageCount) {
        if (progress == 0) {
            return 0;
        }
        return (int) ((((float) pageCount) / 100.0f) * ((float) progress));
    }
}
