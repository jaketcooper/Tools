package com.safonov.speedreading.reader.repository.entity;

public class TxtBookChapter implements BookChapter {
    private CharSequence content;
    private CharSequence title;

    public void setTitle(CharSequence title2) {
        this.title = title2;
    }

    public void setContent(CharSequence content2) {
        this.content = content2;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public CharSequence getContent() {
        return this.content;
    }

    public CharSequence getBookChapter() {
        return this.content;
    }
}
