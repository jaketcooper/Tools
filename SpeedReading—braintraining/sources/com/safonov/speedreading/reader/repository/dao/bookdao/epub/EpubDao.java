package com.safonov.speedreading.reader.repository.dao.bookdao.epub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.reader.repository.dao.bookdao.BookDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.entity.BookChapter;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.entity.EpubBookChapter;
import com.safonov.speedreading.reader.repository.exception.BookAlreadyExistException;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import com.safonov.speedreading.reader.repository.util.FileUtil;
import com.safonov.speedreading.reader.repository.util.JsonUtil;
import com.safonov.speedreading.reader.repository.util.XmlParserUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EpubDao extends BookDao implements IEpubDao {
    private static final String EMPHASIS_TAG_1 = "em";
    private static final String EMPHASIS_TAG_2 = "i";
    private static final String EMPTY_LINE_TAG = "br";
    private static final String HEAD_1_TAG = "h1";
    private static final String HEAD_2_TAG = "h2";
    private static final String HEAD_3_TAG = "h3";
    private static final String HEAD_4_TAG = "h4";
    private static final String HEAD_5_TAG = "h5";
    private static final String HEAD_6_TAG = "h6";
    private static final String PARAGRAPH_TAG_1 = "p";
    private static final String PARAGRAPH_TAG_2 = "div";
    private static final String STRIKE_THROUGH_TAG = "strike";
    private static final String STRONG_TAG_1 = "strong";
    private static final String STRONG_TAG_2 = "b";
    public static final float SUB_FONT_HEIGHT = 0.5f;
    private static final String SUB_TAG = "sub";
    private static final String SUP_TAG = "sup";
    private static final String UNDERLINE_TAG = "u";
    private static final Map<String, Float> headers = new HashMap();
    private static final Pattern xmlPattern = Pattern.compile(".+\\.x?html");

    static {
        headers.put(HEAD_1_TAG, Float.valueOf(1.5f));
        headers.put(HEAD_2_TAG, Float.valueOf(1.4f));
        headers.put(HEAD_3_TAG, Float.valueOf(1.3f));
        headers.put(HEAD_4_TAG, Float.valueOf(1.2f));
        headers.put(HEAD_5_TAG, Float.valueOf(1.1f));
        headers.put(HEAD_6_TAG, Float.valueOf(1.0f));
    }

    public EpubDao(@NonNull Context context, @NonNull IBookDescriptionDao bookDescriptionDao) {
        super(context, bookDescriptionDao);
    }

    public BookDescription addBook(String filePath) throws BookParserException, BookAlreadyExistException {
        if (this.bookDescriptionDao.findBookDescription(filePath) != null) {
            throw new BookAlreadyExistException();
        }
        long id = this.bookDescriptionDao.getNextItemId();
        BookDescription bookDescription = new BookDescription();
        try {
            ZipFile zipFile = new ZipFile(filePath);
            try {
                List<? extends ZipEntry> zipEntries = Collections.list(zipFile.entries());
                List emptyList = Collections.emptyList();
                String coverPath = null;
                for (ZipEntry zipEntry : zipEntries) {
                    if (new File(zipEntry.getName()).getName().toLowerCase().equals("content.opf")) {
                        Document contentOpf = XmlParserUtil.getXmlFromFile(zipFile.getInputStream(zipEntry));
                        bookDescription.setTitle(getBookTitle(contentOpf));
                        bookDescription.setLanguage(getBookLanguage(contentOpf));
                        bookDescription.setAuthor(getBookAuthor(contentOpf));
                        coverPath = getCoverPath(contentOpf);
                    }
                }
                if (coverPath != null) {
                    String coverName = new File(coverPath).getName();
                    String imagePath = this.libraryFilePath + File.separator + id + File.separator + coverName;
                    File imageFile = new File(imagePath);
                    imageFile.getParentFile().mkdirs();
                    Iterator<? extends ZipEntry> it = zipEntries.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ZipEntry zipEntry2 = (ZipEntry) it.next();
                        if (new File(zipEntry2.getName()).getName().equals(coverName)) {
                            FileUtil.copyFile(zipFile.getInputStream(zipEntry2), imageFile);
                            bookDescription.setCoverImagePath(imagePath);
                            break;
                        }
                    }
                }
                zipFile.close();
                bookDescription.setId(id);
                bookDescription.setFilePath(filePath);
                bookDescription.setType(FileUtil.getFileExtension(filePath));
                JsonUtil.saveBook(bookDescription, parseBook(filePath), this.libraryFilePath + File.separator + id);
                this.bookDescriptionDao.addBookDescription(bookDescription);
                return bookDescription;
            } catch (IOException e) {
                e = e;
                ZipFile zipFile2 = zipFile;
                throw new BookParserException((Throwable) e);
            }
        } catch (IOException e2) {
            e = e2;
            throw new BookParserException((Throwable) e);
        }
    }

    private String getBookTitle(Document document) {
        return document.getElementsByTagName("dc:title").item(0).getTextContent();
    }

    private String getBookLanguage(Document document) {
        return document.getElementsByTagName("dc:language").item(0).getTextContent();
    }

    private String getBookAuthor(Document document) {
        return document.getElementsByTagName("dc:creator").item(0).getTextContent();
    }

    private String getCoverPath(Document document) throws BookParserException {
        String coverId = null;
        String coverFilePath = null;
        NodeList itemNodes = document.getElementsByTagName("meta");
        for (int i = 0; i < itemNodes.getLength(); i++) {
            Element metaElement = (Element) itemNodes.item(i);
            if (metaElement.getAttribute("name").equals("cover")) {
                coverId = metaElement.getAttribute(FirebaseAnalytics.Param.CONTENT);
            }
        }
        if (coverId == null) {
            return null;
        }
        NodeList itemNodes2 = document.getElementsByTagName("item");
        for (int i2 = 0; i2 < itemNodes2.getLength(); i2++) {
            Element element = (Element) itemNodes2.item(i2);
            if (element.getAttribute(IdentityRealmObject.FIELD_ID).equals(coverId)) {
                coverFilePath = element.getAttribute("href");
            }
        }
        return coverFilePath;
    }

    public BookContent getBookContent(BookDescription bookDescription) throws BookParserException {
        return JsonUtil.readBook(bookDescription, this.libraryFilePath + File.separator + bookDescription.getId());
    }

    private BookContent parseBook(String filePath) throws BookParserException {
        try {
            ZipFile zipFile = new ZipFile(filePath);
            List<? extends ZipEntry> zipEntries = Collections.list(zipFile.entries());
            List<NavigationPoint> navigationPoints = Collections.emptyList();
            Iterator<? extends ZipEntry> it = zipEntries.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ZipEntry zipEntry = (ZipEntry) it.next();
                if (new File(zipEntry.getName()).getName().toLowerCase().equals("toc.ncx")) {
                    navigationPoints = getBookNavigationPoints(XmlParserUtil.getXmlFromFile(zipFile.getInputStream(zipEntry)));
                    break;
                }
            }
            BookContent bookContent = new BookContent();
            List<BookChapter> bookChapters = new LinkedList<>();
            int i = 0;
            while (i < navigationPoints.size()) {
                String bookChapterId = navigationPoints.get(i).getBookChapterId();
                String bookChapterPath = navigationPoints.get(i).getBookChapterPath();
                String bookChapterTitle = navigationPoints.get(i).getBookChapterTitle();
                Iterator<? extends ZipEntry> it2 = zipEntries.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ZipEntry zipEntry2 = (ZipEntry) it2.next();
                    if (bookChapterPath.equals(new File(zipEntry2.getName()).getName())) {
                        if (bookChapterId == null) {
                            CharSequence bookChapterContent = parseChapter(XmlParserUtil.getXmlFromFile(zipFile.getInputStream(zipEntry2)));
                            if (!bookChapterContent.toString().trim().isEmpty()) {
                                bookChapters.add(new EpubBookChapter(bookChapterTitle, bookChapterContent));
                            }
                        } else {
                            List<String> ids = new ArrayList<>();
                            ArrayList arrayList = new ArrayList();
                            ids.add(bookChapterId);
                            arrayList.add(bookChapterTitle);
                            for (int j = i + 1; j < navigationPoints.size(); j++) {
                                if (bookChapterPath.equals(navigationPoints.get(j).getBookChapterPath())) {
                                    ids.add(navigationPoints.get(j).getBookChapterId());
                                    arrayList.add(navigationPoints.get(j).getBookChapterTitle());
                                    i++;
                                }
                            }
                            String html = FileUtil.getTextFromFile(zipFile.getInputStream(zipEntry2));
                            bookChapters.addAll(parseCombineChapter(XmlParserUtil.getXmlFromFile(zipFile.getInputStream(zipEntry2)), html, ids, arrayList));
                        }
                    }
                }
                i++;
            }
            bookContent.setBookChapterList(bookChapters);
            return bookContent;
        } catch (IOException e) {
            throw new BookParserException((Throwable) e);
        }
    }

    private List<BookChapter> parseCombineChapter(Document combineChapterDocument, String html, List<String> ids, List<String> titles) throws BookParserException {
        CharSequence combineChapter = parseChapter(combineChapterDocument);
        Matcher matcher = Pattern.compile("<body[\\s\\S]+</body>").matcher(html);
        String body = html;
        if (matcher.find()) {
            body = html.substring(matcher.start(), matcher.end()).replaceAll("\n", "");
        }
        int chaptersCount = ids.size();
        int[] startIndexes = new int[chaptersCount];
        List<BookChapter> bookChapters = new ArrayList<>(chaptersCount);
        for (int i = 0; i < chaptersCount; i++) {
            StringBuilder request = new StringBuilder();
            request.append("id=\"");
            request.append(ids.get(i));
            request.append("\"");
            Matcher matcher2 = Pattern.compile(request.toString()).matcher(body);
            if (matcher2.find()) {
                int bodyLength = body.length();
                int startIndex = 0;
                int endIndex = bodyLength;
                boolean itsTag = false;
                int j = matcher2.start();
                while (true) {
                    if (j >= bodyLength) {
                        break;
                    } else if (body.charAt(j) == '>') {
                        startIndex = j + 1;
                        break;
                    } else {
                        j++;
                    }
                }
                int j2 = startIndex;
                while (true) {
                    if (j2 >= bodyLength) {
                        break;
                    }
                    if (body.charAt(j2) == '<') {
                        itsTag = true;
                    } else if (body.charAt(j2) == '>') {
                        if (itsTag) {
                            itsTag = false;
                        }
                    } else if (!itsTag) {
                        startIndex = j2;
                        break;
                    }
                    j2++;
                }
                int j3 = startIndex;
                while (true) {
                    if (j3 >= bodyLength) {
                        break;
                    } else if (body.charAt(j3) == '<') {
                        endIndex = j3 - 1;
                        break;
                    } else {
                        j3++;
                    }
                }
                String partOfContent = body.substring(startIndex, endIndex + 1).trim();
                body = body.substring(endIndex + 1);
                Matcher combineMatcher = Pattern.compile(partOfContent).matcher(combineChapter);
                if (i > 0) {
                    if (combineMatcher.find(startIndexes[i - 1])) {
                        startIndexes[i] = combineMatcher.start();
                    }
                } else if (combineMatcher.find()) {
                    startIndexes[i] = combineMatcher.start();
                }
            }
        }
        for (int i2 = 0; i2 < chaptersCount - 1; i2++) {
            CharSequence title = titles.get(i2);
            CharSequence chapter = combineChapter.subSequence(startIndexes[i2], startIndexes[i2 + 1]);
            if (!chapter.toString().trim().isEmpty()) {
                bookChapters.add(new EpubBookChapter(title, chapter));
            }
        }
        CharSequence title2 = titles.get(chaptersCount - 1);
        CharSequence chapter2 = combineChapter.subSequence(startIndexes[chaptersCount - 1], combineChapter.length());
        if (!chapter2.toString().trim().isEmpty()) {
            bookChapters.add(new EpubBookChapter(title2, chapter2));
        }
        return bookChapters;
    }

    private class NavigationPoint {
        private String bookChapterId;
        private String bookChapterPath;
        private String bookChapterTitle;

        public NavigationPoint(String bookChapterTitle2, String bookChapterPath2) {
            this.bookChapterTitle = bookChapterTitle2;
            this.bookChapterPath = bookChapterPath2;
        }

        public NavigationPoint(String bookChapterTitle2, String bookChapterPath2, String bookChapterId2) {
            this.bookChapterTitle = bookChapterTitle2;
            this.bookChapterPath = bookChapterPath2;
            this.bookChapterId = bookChapterId2;
        }

        public String getBookChapterTitle() {
            return this.bookChapterTitle;
        }

        public String getBookChapterPath() {
            return this.bookChapterPath;
        }

        public String getBookChapterId() {
            return this.bookChapterId;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007e, code lost:
        r9 = r15.group();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao.NavigationPoint> getBookNavigationPoints(org.w3c.dom.Document r29) {
        /*
            r28 = this;
            java.lang.String r24 = "navPoint"
            r0 = r29
            r1 = r24
            org.w3c.dom.NodeList r20 = r0.getElementsByTagName(r1)
            int r21 = r20.getLength()
            java.util.ArrayList r5 = new java.util.ArrayList
            r0 = r21
            r5.<init>(r0)
            java.util.ArrayList r7 = new java.util.ArrayList
            r0 = r21
            r7.<init>(r0)
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = r21
            r6.<init>(r0)
            r11 = 0
        L_0x0024:
            r0 = r21
            if (r11 >= r0) goto L_0x00ed
            r0 = r20
            org.w3c.dom.Node r24 = r0.item(r11)
            org.w3c.dom.NodeList r18 = r24.getChildNodes()
            int r19 = r18.getLength()
            r9 = 0
            r10 = 0
            r8 = 0
            r13 = 0
        L_0x003a:
            r0 = r19
            if (r13 >= r0) goto L_0x00e0
            r0 = r18
            org.w3c.dom.Node r24 = r0.item(r13)
            java.lang.String r24 = r24.getNodeName()
            java.lang.String r25 = "content"
            boolean r24 = r24.equals(r25)
            if (r24 == 0) goto L_0x0098
            r0 = r18
            org.w3c.dom.Node r24 = r0.item(r13)
            org.w3c.dom.Element r24 = (org.w3c.dom.Element) r24
            java.lang.String r25 = "src"
            java.lang.String r9 = r24.getAttribute(r25)
            java.util.regex.Pattern r24 = xmlPattern
            r0 = r24
            java.util.regex.Matcher r15 = r0.matcher(r9)
            r24 = 35
            r0 = r24
            int r23 = r9.lastIndexOf(r0)
            if (r23 <= 0) goto L_0x0078
            int r24 = r23 + 1
            r0 = r24
            java.lang.String r8 = r9.substring(r0)
        L_0x0078:
            boolean r24 = r15.find()
            if (r24 == 0) goto L_0x0098
            java.lang.String r9 = r15.group()
            r24 = 47
            r0 = r24
            int r12 = r9.lastIndexOf(r0)
            r24 = -1
            r0 = r24
            if (r12 <= r0) goto L_0x0098
            int r24 = r12 + 1
            r0 = r24
            java.lang.String r9 = r9.substring(r0)
        L_0x0098:
            r0 = r18
            org.w3c.dom.Node r24 = r0.item(r13)
            java.lang.String r24 = r24.getNodeName()
            java.lang.String r25 = "navLabel"
            boolean r24 = r24.equals(r25)
            if (r24 == 0) goto L_0x00d9
            r0 = r18
            org.w3c.dom.Node r24 = r0.item(r13)
            org.w3c.dom.NodeList r16 = r24.getChildNodes()
            int r17 = r16.getLength()
            r14 = 0
        L_0x00b9:
            r0 = r17
            if (r14 >= r0) goto L_0x00d9
            r0 = r16
            org.w3c.dom.Node r24 = r0.item(r14)
            java.lang.String r24 = r24.getNodeName()
            java.lang.String r25 = "text"
            boolean r24 = r24.equals(r25)
            if (r24 == 0) goto L_0x00dd
            r0 = r16
            org.w3c.dom.Node r24 = r0.item(r14)
            java.lang.String r10 = r24.getTextContent()
        L_0x00d9:
            int r13 = r13 + 1
            goto L_0x003a
        L_0x00dd:
            int r14 = r14 + 1
            goto L_0x00b9
        L_0x00e0:
            r5.add(r9)
            r7.add(r10)
            r6.add(r8)
            int r11 = r11 + 1
            goto L_0x0024
        L_0x00ed:
            java.util.ArrayList r22 = new java.util.ArrayList
            r0 = r22
            r1 = r21
            r0.<init>(r1)
            r11 = 0
        L_0x00f7:
            r0 = r21
            if (r11 >= r0) goto L_0x0126
            com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao$NavigationPoint r27 = new com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao$NavigationPoint
            java.lang.Object r24 = r7.get(r11)
            java.lang.String r24 = (java.lang.String) r24
            java.lang.Object r25 = r5.get(r11)
            java.lang.String r25 = (java.lang.String) r25
            java.lang.Object r26 = r6.get(r11)
            java.lang.String r26 = (java.lang.String) r26
            r0 = r27
            r1 = r28
            r2 = r24
            r3 = r25
            r4 = r26
            r0.<init>(r2, r3, r4)
            r0 = r22
            r1 = r27
            r0.add(r1)
            int r11 = r11 + 1
            goto L_0x00f7
        L_0x0126:
            return r22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.safonov.speedreading.reader.repository.dao.bookdao.epub.EpubDao.getBookNavigationPoints(org.w3c.dom.Document):java.util.List");
    }

    private CharSequence parseChapter(Document bookDocument) {
        return parseBody(bookDocument.getElementsByTagName("body").item(0));
    }

    private CharSequence parseBody(Node body) {
        NodeList bodyChildNotes = body.getChildNodes();
        int bodyChildNotesCount = bodyChildNotes.getLength();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        for (int i = 0; i < bodyChildNotesCount; i++) {
            Node currentTag = bodyChildNotes.item(i);
            if (currentTag.getNodeType() == 1) {
                builder.append(parseTag(currentTag));
            }
        }
        return builder;
    }

    private CharSequence parseTag(Node tag) {
        if (tag.getNodeType() == 3) {
            String tagNodeValue = tag.getNodeValue().trim();
            if (!tagNodeValue.isEmpty()) {
                return tagNodeValue;
            }
            return "";
        }
        SpannableStringBuilder builder = new SpannableStringBuilder();
        NodeList nestedTags = tag.getChildNodes();
        int nestedTagsCount = nestedTags.getLength();
        for (int i = 0; i < nestedTagsCount; i++) {
            builder.append(parseTag(nestedTags.item(i)));
        }
        String nodeName = tag.getNodeName();
        char c = 65535;
        switch (nodeName.hashCode()) {
            case -891985998:
                if (nodeName.equals(STRIKE_THROUGH_TAG)) {
                    c = 14;
                    break;
                }
                break;
            case -891980137:
                if (nodeName.equals(STRONG_TAG_1)) {
                    c = 10;
                    break;
                }
                break;
            case 98:
                if (nodeName.equals(STRONG_TAG_2)) {
                    c = 11;
                    break;
                }
                break;
            case 105:
                if (nodeName.equals(EMPHASIS_TAG_2)) {
                    c = 9;
                    break;
                }
                break;
            case 112:
                if (nodeName.equals(PARAGRAPH_TAG_1)) {
                    c = 6;
                    break;
                }
                break;
            case 117:
                if (nodeName.equals(UNDERLINE_TAG)) {
                    c = 15;
                    break;
                }
                break;
            case 3152:
                if (nodeName.equals(EMPTY_LINE_TAG)) {
                    c = 16;
                    break;
                }
                break;
            case 3240:
                if (nodeName.equals(EMPHASIS_TAG_1)) {
                    c = 8;
                    break;
                }
                break;
            case 3273:
                if (nodeName.equals(HEAD_1_TAG)) {
                    c = 0;
                    break;
                }
                break;
            case 3274:
                if (nodeName.equals(HEAD_2_TAG)) {
                    c = 1;
                    break;
                }
                break;
            case 3275:
                if (nodeName.equals(HEAD_3_TAG)) {
                    c = 2;
                    break;
                }
                break;
            case 3276:
                if (nodeName.equals(HEAD_4_TAG)) {
                    c = 3;
                    break;
                }
                break;
            case 3277:
                if (nodeName.equals(HEAD_5_TAG)) {
                    c = 4;
                    break;
                }
                break;
            case 3278:
                if (nodeName.equals(HEAD_6_TAG)) {
                    c = 5;
                    break;
                }
                break;
            case 99473:
                if (nodeName.equals(PARAGRAPH_TAG_2)) {
                    c = 7;
                    break;
                }
                break;
            case 114240:
                if (nodeName.equals(SUB_TAG)) {
                    c = 12;
                    break;
                }
                break;
            case 114254:
                if (nodeName.equals(SUP_TAG)) {
                    c = 13;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                builder.setSpan(new RelativeSizeSpan(headers.get(HEAD_1_TAG).floatValue()), 0, builder.length(), 33);
                builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                int builderLength = builder.length();
                if (builderLength >= 1 && builder.charAt(builderLength - 1) != 10) {
                    builder.append("\n\n");
                    break;
                }
            case 1:
                builder.setSpan(new RelativeSizeSpan(headers.get(HEAD_2_TAG).floatValue()), 0, builder.length(), 33);
                builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                int builderLength2 = builder.length();
                if (builderLength2 >= 1 && builder.charAt(builderLength2 - 1) != 10) {
                    builder.append("\n\n");
                    break;
                }
            case 2:
                builder.setSpan(new RelativeSizeSpan(headers.get(HEAD_3_TAG).floatValue()), 0, builder.length(), 33);
                builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                break;
            case 3:
                builder.setSpan(new RelativeSizeSpan(headers.get(HEAD_4_TAG).floatValue()), 0, builder.length(), 33);
                builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                break;
            case 4:
                builder.setSpan(new RelativeSizeSpan(headers.get(HEAD_5_TAG).floatValue()), 0, builder.length(), 33);
                builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                break;
            case 5:
                builder.setSpan(new RelativeSizeSpan(headers.get(HEAD_6_TAG).floatValue()), 0, builder.length(), 33);
                builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                break;
            case 6:
                int builderLength3 = builder.length();
                if (builderLength3 >= 1 && builder.charAt(builderLength3 - 1) != 10) {
                    builder.append("\n\n");
                    break;
                }
            case 7:
                int builderLength4 = builder.length();
                if (builderLength4 >= 1 && builder.charAt(builderLength4 - 1) != 10) {
                    builder.append("\n\n");
                    break;
                }
            case 8:
                builder.setSpan(new StyleSpan(2), 0, builder.length(), 33);
                break;
            case 9:
                builder.setSpan(new StyleSpan(2), 0, builder.length(), 33);
                break;
            case 10:
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                break;
            case 11:
                builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                break;
            case 12:
                builder.setSpan(new RelativeSizeSpan(0.5f), 0, builder.length(), 33);
                builder.setSpan(new SubscriptSpan(), 0, builder.length(), 33);
                break;
            case 13:
                builder.setSpan(new RelativeSizeSpan(0.5f), 0, builder.length(), 33);
                builder.setSpan(new SuperscriptSpan(), 0, builder.length(), 33);
                break;
            case 14:
                builder.setSpan(new StrikethroughSpan(), 0, builder.length(), 33);
                break;
            case 15:
                builder.setSpan(new UnderlineSpan(), 0, builder.length(), 33);
                break;
            case 16:
                builder.append("\n");
                break;
        }
        return builder;
    }

    public void removeBook(long id) {
        this.bookDescriptionDao.removeBookDescription(id);
        FileUtil.removeDirectory(new File(this.libraryFilePath + File.separator + id));
    }
}
