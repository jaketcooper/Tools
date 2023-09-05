package com.safonov.speedreading.reader.reader.util2;

import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PageSplitter {
    private final float lineSpacingExtra;
    private final float lineSpacingMultiplier;
    private final int pageHeight;
    private final int pageWidth;
    private final TextPaint textPaint;

    public PageSplitter(TextPaint textPaint2, int pageWidth2, int pageHeight2) {
        this.textPaint = textPaint2;
        this.pageWidth = pageWidth2;
        this.pageHeight = pageHeight2;
        this.lineSpacingMultiplier = 1.0f;
        this.lineSpacingExtra = 0.0f;
    }

    public PageSplitter(TextPaint textPaint2, int pageWidth2, int pageHeight2, float lineSpacingMultiplier2, int lineSpacingExtra2) {
        this.textPaint = textPaint2;
        this.pageWidth = pageWidth2;
        this.pageHeight = pageHeight2;
        this.lineSpacingMultiplier = lineSpacingMultiplier2;
        this.lineSpacingExtra = (float) lineSpacingExtra2;
    }

    public SplittedBook getSeparatedBook(@NonNull BookContent bookContent) {
        ArrayList arrayList = new ArrayList(bookContent.getTitles().size());
        for (String title : bookContent.getTitles()) {
            arrayList.add(title.toString());
        }
        List<List<CharSequence>> pages = new LinkedList<>();
        for (CharSequence chapter : bookContent.getChaptersText()) {
            List<CharSequence> chapterPages = new LinkedList<>();
            int usedHeight = 0;
            int startIndex = 0;
            StaticLayout tempLayout = new StaticLayout(chapter, this.textPaint, this.pageWidth, Layout.Alignment.ALIGN_NORMAL, this.lineSpacingMultiplier, this.lineSpacingExtra, true);
            int lastLineIndex = tempLayout.getLineCount() - 1;
            if (lastLineIndex == 0) {
                chapterPages.add(chapter);
            }
            int selectedLine = 0;
            while (selectedLine != lastLineIndex) {
                int verticalOffset = usedHeight + this.pageHeight;
                selectedLine = tempLayout.getLineForVertical(verticalOffset);
                if (tempLayout.getLineBottom(selectedLine) > verticalOffset) {
                    selectedLine--;
                }
                usedHeight = tempLayout.getLineBottom(selectedLine);
                int endIndex = tempLayout.getLineEnd(selectedLine);
                chapterPages.add(chapter.subSequence(startIndex, endIndex));
                startIndex = endIndex;
            }
            pages.add(chapterPages);
        }
        return new SplittedBook(arrayList, pages);
    }
}
