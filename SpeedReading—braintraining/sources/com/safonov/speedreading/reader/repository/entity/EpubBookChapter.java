package com.safonov.speedreading.reader.repository.entity;

public class EpubBookChapter implements BookChapter {
    private CharSequence content;
    private CharSequence title;

    public EpubBookChapter() {
    }

    public EpubBookChapter(CharSequence title2, CharSequence content2) {
        this.title = title2;
        this.content = content2;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public void setTitle(CharSequence title2) {
        this.title = title2;
    }

    public CharSequence getContent() {
        return this.content;
    }

    public void setContent(CharSequence content2) {
        this.content = content2;
    }

    public CharSequence getBookChapter() {
        if (this.content == null) {
            return "";
        }
        for (int i = this.content.length() - 1; i >= 0; i--) {
            if (this.content.charAt(i) != 10) {
                return this.content.subSequence(0, i + 1);
            }
        }
        return this.content;
    }
}
