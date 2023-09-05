package com.safonov.speedreading.reader.reader.util2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.regex.Pattern;

public class PencilFramePageSelector {
    private static final Pattern pattern = Pattern.compile(regExp);
    private static final String regExp = "\\b([\\w]+)\\b";
    private StaticLayout staticLayout;
    private CharSequence text;

    public static class PencilFrameDataSet {
        private int frameBottomY;
        private int frameTopY;
        private int wordCount;

        public int getFrameTopY() {
            return this.frameTopY;
        }

        public void setFrameTopY(int frameTopY2) {
            this.frameTopY = frameTopY2;
        }

        public int getFrameBottomY() {
            return this.frameBottomY;
        }

        public void setFrameBottomY(int frameBottomY2) {
            this.frameBottomY = frameBottomY2;
        }

        public int getWordCount() {
            return this.wordCount;
        }

        public void setWordCount(int wordCount2) {
            this.wordCount = wordCount2;
        }
    }

    public PencilFramePageSelector(@NonNull TextPaint textPaint, CharSequence text2, int pageWidth) {
        this.text = text2;
        this.staticLayout = new StaticLayout(text2, textPaint, pageWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    @Nullable
    public PencilFrameDataSet getFrameCoordinates(int lineStartIndex, int lineCount) {
        int lineEndIndex;
        if (lineStartIndex > this.staticLayout.getLineCount()) {
            return null;
        }
        if (lineStartIndex + lineCount > this.staticLayout.getLineCount()) {
            lineEndIndex = this.staticLayout.getLineCount();
        } else {
            lineEndIndex = lineStartIndex + lineCount;
        }
        PencilFrameDataSet pencilFrameDataSet = new PencilFrameDataSet();
        pencilFrameDataSet.setFrameTopY(this.staticLayout.getLineTop(lineStartIndex));
        pencilFrameDataSet.setFrameBottomY(this.staticLayout.getLineTop(lineEndIndex));
        pencilFrameDataSet.setWordCount(getWordCount(this.text.subSequence(this.staticLayout.getLineStart(lineStartIndex), this.staticLayout.getLineStart(lineEndIndex))));
        return pencilFrameDataSet;
    }

    private int getWordCount(CharSequence charSequence) {
        int wordCount = 0;
        while (pattern.matcher(charSequence).find()) {
            wordCount++;
        }
        return wordCount;
    }
}
