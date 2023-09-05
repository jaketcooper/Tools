package com.safonov.speedreading.reader.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class BookContent {
    private List<BookChapter> bookChapterList;

    public List<BookChapter> getBookChapterList() {
        return this.bookChapterList;
    }

    public void setBookChapterList(List<BookChapter> bookChapterList2) {
        this.bookChapterList = bookChapterList2;
    }

    public List<CharSequence> getChaptersText() {
        List<CharSequence> chapterTextList = new ArrayList<>(this.bookChapterList.size());
        for (BookChapter chapter : this.bookChapterList) {
            chapterTextList.add(chapter.getBookChapter());
        }
        return chapterTextList;
    }

    public List<String> getTitles() {
        List<String> titleList = new ArrayList<>(this.bookChapterList.size());
        for (BookChapter bookChapter : this.bookChapterList) {
            titleList.add(bookChapter.getTitle().toString());
        }
        return titleList;
    }
}
