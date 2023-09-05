package com.safonov.speedreading.reader.reader.util2;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSelector {
    private static final Pattern pattern = Pattern.compile(regExp);
    private static final String regExp = "\\b([\\w]+)\\b";
    private Matcher matcher;
    private CharSequence page;

    public WordSelector(CharSequence page2) {
        this.page = page2;
        this.matcher = pattern.matcher(page2);
    }

    public Spanned getPageWithNextSelectedWord() {
        if (!this.matcher.find()) {
            return null;
        }
        int startIndex = this.matcher.start();
        int endIndex = this.matcher.end();
        SpannableString spannableString = new SpannableString(this.page);
        spannableString.setSpan(new BackgroundColorSpan(-16711681), startIndex, endIndex, 33);
        return spannableString;
    }
}
