package com.safonov.speedreading.reader.reader.util2;

import java.util.ArrayList;
import java.util.List;

public class SplittedBook {
    private List<List<CharSequence>> chapters;
    private final int size;
    private List<String> titles;

    public SplittedBook(List<String> titles2, List<List<CharSequence>> chapters2) {
        List<String> trimTitles = new ArrayList<>(titles2.size());
        for (String title : titles2) {
            String bufTitle = title.trim().replaceAll("[\\s]+", " ");
            if (bufTitle.isEmpty()) {
                bufTitle = "...";
            }
            trimTitles.add(bufTitle);
        }
        this.titles = trimTitles;
        this.chapters = chapters2;
        int size2 = 0;
        for (List<CharSequence> chapter : chapters2) {
            size2 += chapter.size();
        }
        this.size = size2;
    }

    public String getTitle(int pageIndex) {
        int pageCount = 0;
        int lastTitleIndex = 0;
        for (List<CharSequence> chapter : this.chapters) {
            pageCount += chapter.size();
            if (pageIndex < pageCount) {
                return this.titles.get(lastTitleIndex);
            }
            lastTitleIndex++;
        }
        return null;
    }

    public int getPageIndexByTitle(int titleIndex) {
        int pageIndex = 0;
        for (int i = 0; i < titleIndex; i++) {
            pageIndex += this.chapters.get(i).size();
        }
        return pageIndex;
    }

    public List<String> getTitles() {
        return this.titles;
    }

    public CharSequence getPage(int pageIndex) {
        int offsetIndex = pageIndex;
        for (List<CharSequence> chapter : this.chapters) {
            int chapterPagesCount = chapter.size();
            if (offsetIndex < chapterPagesCount) {
                return chapter.get(offsetIndex);
            }
            offsetIndex -= chapterPagesCount;
        }
        return null;
    }

    public int getPageCount() {
        return this.size;
    }
}
