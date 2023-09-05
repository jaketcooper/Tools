package com.safonov.speedreading.reader.repository.entity;

import android.text.SpannableStringBuilder;

public class Fb2BookChapter implements BookChapter {
    private CharSequence content;
    private CharSequence title;

    public Fb2BookChapter() {
    }

    public Fb2BookChapter(CharSequence title2, CharSequence content2) {
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
        SpannableStringBuilder builder = new SpannableStringBuilder();
        if (this.title != null) {
            builder.append(this.title);
        }
        if (this.content != null) {
            builder.append(this.content);
        }
        for (int i = builder.length() - 1; i >= 0; i--) {
            if (builder.charAt(i) != 10) {
                return builder.subSequence(0, i + 1);
            }
        }
        return builder;
    }
}
