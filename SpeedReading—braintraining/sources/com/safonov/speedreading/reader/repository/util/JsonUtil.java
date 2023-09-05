package com.safonov.speedreading.reader.repository.util;

import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.BookDescriptionDatabaseHelper;
import com.safonov.speedreading.reader.repository.entity.BookChapter;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.entity.EpubBookChapter;
import com.safonov.speedreading.reader.repository.entity.Fb2BookChapter;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    private static final String BOOK_CONTENT_DIRECTORY_NAME = "book_content";

    public static void saveBook(BookDescription bookDescription, BookContent bookContent, String bookIdDirectoryPath) throws BookParserException {
        try {
            saveBookChapters(convertChaptersToJson(bookDescription, bookContent.getBookChapterList()), bookIdDirectoryPath + File.separator + bookDescription.getType());
        } catch (JSONException e) {
            throw new BookParserException((Throwable) e);
        }
    }

    private static void saveBookChapters(List<JSONObject> jsonChapters, String directoryPath) throws BookParserException {
        try {
            new File(directoryPath).mkdirs();
            int jsonChaptersCount = jsonChapters.size();
            for (int i = 0; i < jsonChaptersCount; i++) {
                File file = new File(directoryPath + File.separator + i + ".json");
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(jsonChapters.get(i).toString());
                fileWriter.close();
            }
        } catch (IOException e) {
            throw new BookParserException((Throwable) e);
        }
    }

    private static List<JSONObject> convertChaptersToJson(BookDescription bookDescription, List<BookChapter> chapters) throws JSONException {
        List<JSONObject> jsonChapters = new ArrayList<>(chapters.size());
        for (BookChapter chapter : chapters) {
            JSONObject chapterJsonObject = new JSONObject();
            JSONArray titleSpanJsonArray = new JSONArray();
            JSONArray chapterSpanJsonArray = new JSONArray();
            CharSequence title = chapter.getTitle();
            if (title == null) {
                chapterJsonObject.put(BookDescriptionDatabaseHelper.BOOK_TITLE, "");
                chapterJsonObject.put("title_spans", titleSpanJsonArray);
            } else if (bookDescription.getType().equals(FileUtil.FB2)) {
                Spanned spannedTitle = (Spanned) title;
                chapterJsonObject.put(BookDescriptionDatabaseHelper.BOOK_TITLE, spannedTitle.toString());
                for (Object span : spannedTitle.getSpans(0, spannedTitle.length(), Object.class)) {
                    titleSpanJsonArray.put(convertSpanToJson(spannedTitle, span));
                }
                chapterJsonObject.put("title_spans", titleSpanJsonArray);
            } else {
                chapterJsonObject.put(BookDescriptionDatabaseHelper.BOOK_TITLE, title.toString());
            }
            CharSequence content = chapter.getContent();
            if (content == null) {
                chapterJsonObject.put(FirebaseAnalytics.Param.CONTENT, "");
                chapterJsonObject.put("content_spans", chapterSpanJsonArray);
            } else {
                Spanned spannedContent = (Spanned) content;
                chapterJsonObject.put(FirebaseAnalytics.Param.CONTENT, spannedContent.toString());
                for (Object span2 : spannedContent.getSpans(0, spannedContent.length(), Object.class)) {
                    chapterSpanJsonArray.put(convertSpanToJson(spannedContent, span2));
                }
                chapterJsonObject.put("content_spans", chapterSpanJsonArray);
            }
            jsonChapters.add(chapterJsonObject);
        }
        return jsonChapters;
    }

    private static JSONObject convertSpanToJson(Spanned spanned, Object span) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        Class spanClass = span.getClass();
        jsonObject.put("span_class", spanClass.toString());
        jsonObject.put("start_index", spanned.getSpanStart(span));
        jsonObject.put("end_index", spanned.getSpanEnd(span));
        if (spanClass == AlignmentSpan.Standard.class) {
            jsonObject.put("alignment", ((AlignmentSpan.Standard) span).getAlignment().name());
        } else if (spanClass == RelativeSizeSpan.class) {
            jsonObject.put("relative_size", (double) ((RelativeSizeSpan) span).getSizeChange());
        } else if (spanClass == StyleSpan.class) {
            jsonObject.put("style_type", ((StyleSpan) span).getStyle());
        }
        return jsonObject;
    }

    public static BookContent readBook(BookDescription bookDescription, String bookIdDirectoryPath) throws BookParserException {
        try {
            String bookType = bookDescription.getType();
            File[] chapterFiles = new File(bookIdDirectoryPath + File.separator + bookType).listFiles();
            List<BookChapter> bookChapters = new ArrayList<>(chapterFiles.length);
            for (File chapterFile : chapterFiles) {
                StringBuilder jsonStringBuilder = new StringBuilder();
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(chapterFile)));
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    jsonStringBuilder.append(line);
                }
                br.close();
                bookChapters.add(parseChapter(new JSONObject(jsonStringBuilder.toString()), bookType));
            }
            BookContent bookContent = new BookContent();
            bookContent.setBookChapterList(bookChapters);
            return bookContent;
        } catch (IOException | JSONException e) {
            throw new BookParserException((Throwable) e);
        }
    }

    private static BookChapter parseChapter(JSONObject chapter, String bookType) throws JSONException, BookParserException {
        char c = 65535;
        switch (bookType.hashCode()) {
            case 101110:
                if (bookType.equals(FileUtil.FB2)) {
                    c = 0;
                    break;
                }
                break;
            case 3120248:
                if (bookType.equals(FileUtil.EPUB)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                SpannableString spannedTitle = new SpannableString(chapter.getString(BookDescriptionDatabaseHelper.BOOK_TITLE));
                SpannableString spannedContent = new SpannableString(chapter.getString(FirebaseAnalytics.Param.CONTENT));
                JSONArray titleSpansJsonArray = chapter.getJSONArray("title_spans");
                int titleSpansJsonArrayLength = titleSpansJsonArray.length();
                for (int i = 0; i < titleSpansJsonArrayLength; i++) {
                    setSpan(spannedTitle, (JSONObject) titleSpansJsonArray.get(i));
                }
                JSONArray contentSpansJsonArray = chapter.getJSONArray("content_spans");
                int contentSpansJsonArrayLength = contentSpansJsonArray.length();
                for (int i2 = 0; i2 < contentSpansJsonArrayLength; i2++) {
                    setSpan(spannedContent, (JSONObject) contentSpansJsonArray.get(i2));
                }
                return new Fb2BookChapter(spannedTitle, spannedContent);
            case 1:
                CharSequence title = chapter.getString(BookDescriptionDatabaseHelper.BOOK_TITLE);
                SpannableString spannedContent2 = new SpannableString(chapter.getString(FirebaseAnalytics.Param.CONTENT));
                JSONArray contentSpansJsonArray2 = chapter.getJSONArray("content_spans");
                int contentSpansJsonArrayLength2 = contentSpansJsonArray2.length();
                for (int i3 = 0; i3 < contentSpansJsonArrayLength2; i3++) {
                    setSpan(spannedContent2, (JSONObject) contentSpansJsonArray2.get(i3));
                }
                return new EpubBookChapter(title, spannedContent2);
            default:
                throw new BookParserException("Unsupported epub_book formatToSeconds");
        }
    }

    private static void setSpan(SpannableString spannableString, JSONObject span) throws JSONException {
        String className = span.getString("span_class");
        int startIndex = span.getInt("start_index");
        int endIndex = span.getInt("end_index");
        if (className.equals(AlignmentSpan.Standard.class.toString())) {
            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.valueOf(span.getString("alignment"))), startIndex, endIndex, 33);
        } else if (className.equals(RelativeSizeSpan.class.toString())) {
            spannableString.setSpan(new RelativeSizeSpan((float) span.getDouble("relative_size")), startIndex, endIndex, 33);
        } else if (className.equals(StyleSpan.class.toString())) {
            spannableString.setSpan(new StyleSpan(span.getInt("style_type")), startIndex, endIndex, 33);
        } else if (className.equals(SubscriptSpan.class.toString())) {
            spannableString.setSpan(new SubscriptSpan(), startIndex, endIndex, 33);
        } else if (className.equals(SuperscriptSpan.class.toString())) {
            spannableString.setSpan(new SuperscriptSpan(), startIndex, endIndex, 33);
        } else if (className.equals(StrikethroughSpan.class.toString())) {
            spannableString.setSpan(new StrikethroughSpan(), startIndex, endIndex, 33);
        } else if (className.equals(UnderlineSpan.class.toString())) {
            spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, 33);
        }
    }
}
