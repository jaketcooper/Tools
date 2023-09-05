package com.safonov.speedreading.reader.repository.dao.bookdao.fb2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.util.Base64;
import com.safonov.speedreading.application.realm.IdentityRealmObject;
import com.safonov.speedreading.reader.repository.dao.bookdao.BookDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.IBookDescriptionDao;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.BookDescriptionDatabaseHelper;
import com.safonov.speedreading.reader.repository.entity.BookChapter;
import com.safonov.speedreading.reader.repository.entity.BookContent;
import com.safonov.speedreading.reader.repository.entity.BookDescription;
import com.safonov.speedreading.reader.repository.entity.Fb2BookChapter;
import com.safonov.speedreading.reader.repository.exception.BookAlreadyExistException;
import com.safonov.speedreading.reader.repository.exception.BookParserException;
import com.safonov.speedreading.reader.repository.util.FileUtil;
import com.safonov.speedreading.reader.repository.util.JsonUtil;
import com.safonov.speedreading.reader.repository.util.XmlParserUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Fb2Dao extends BookDao implements IFb2Dao {
    private static final String CITE_TAG = "cite";
    private static final String EMPHASIS_TAG = "emphasis";
    private static final String EMPTY_LINE_TAG = "empty-line";
    private static final String EPIGRAPH_TAG = "epigraph";
    private static final String PARAGRAPH_TAG = "p";
    private static final String POEM_TAG = "poem";
    private static final String SECTION_TAG = "section";
    private static final String STANZA_TAG = "stanza";
    private static final String STRIKE_THROUGH_TAG = "strikethrough";
    private static final String STRONG_TAG = "strong";
    private static final float SUBTITLE_FONT_HEIGHT = 1.2f;
    private static final String SUBTITLE_TAG = "subtitle";
    private static final float SUB_FONT_HEIGHT = 0.5f;
    private static final String SUB_TAG = "sub";
    private static final String SUP_TAG = "sup";
    private static final String TEXT_AUTHOR_TAG = "text-author";
    private static final float TITLE_FONT_HEIGHT = 1.5f;
    private static final String TITLE_TAG = "title";
    private static final String V_TAG = "v";

    public Fb2Dao(@NonNull Context context, @NonNull IBookDescriptionDao bookDescriptionDao) {
        super(context, bookDescriptionDao);
    }

    public BookDescription addBook(String filePath) throws BookParserException, BookAlreadyExistException {
        Document bookDocument;
        if (this.bookDescriptionDao.findBookDescription(filePath) != null) {
            throw new BookAlreadyExistException();
        }
        long bookId = this.bookDescriptionDao.getNextItemId();
        BookDescription bookDescription = new BookDescription();
        bookDescription.setId(bookId);
        bookDescription.setFilePath(filePath);
        bookDescription.setType(FileUtil.FB2);
        if (FileUtil.getFileExtension(filePath).equals(FileUtil.FB2_ZIP)) {
            bookDocument = parseZippedBook(filePath);
        } else {
            bookDocument = XmlParserUtil.getXmlFromFile(new File(filePath));
        }
        Element titleInfo = (Element) ((Element) bookDocument.getElementsByTagName("description").item(0)).getElementsByTagName("title-info").item(0);
        String bookTitle = getBookTitle(titleInfo);
        String bookLanguage = getBookLanguage(titleInfo);
        List<String> authors = getBookAuthors(titleInfo);
        bookDescription.setTitle(bookTitle);
        bookDescription.setLanguage(bookLanguage);
        bookDescription.setAuthor(authors.get(0));
        String saveDirectoryPath = this.libraryFilePath + File.separator + bookId;
        CoverParseWrapper coverParseWrapper = parseCover(bookDocument);
        if (coverParseWrapper != null) {
            bookDescription.setCoverImagePath(saveCover(coverParseWrapper.getBinaryCover(), coverParseWrapper.getFileName(), saveDirectoryPath));
        }
        JsonUtil.saveBook(bookDescription, parseBook(bookDocument), saveDirectoryPath);
        this.bookDescriptionDao.addBookDescription(bookDescription);
        return bookDescription;
    }

    private Document parseZippedBook(String filePath) throws BookParserException {
        try {
            ZipFile zipFile = new ZipFile(filePath);
            for (ZipEntry zipEntry : Collections.list(zipFile.entries())) {
                if (FileUtil.getFileExtension(zipEntry.getName()).equals(FileUtil.FB2)) {
                    return XmlParserUtil.getXmlFromFile(zipFile.getInputStream(zipEntry));
                }
            }
            return null;
        } catch (IOException e) {
            throw new BookParserException((Throwable) e);
        }
    }

    public BookContent getBookContent(BookDescription bookDescription) throws BookParserException {
        return JsonUtil.readBook(bookDescription, this.libraryFilePath + File.separator + bookDescription.getId());
    }

    public void removeBook(long id) {
        this.bookDescriptionDao.removeBookDescription(id);
        FileUtil.removeDirectory(new File(this.libraryFilePath + File.separator + id));
    }

    private class CoverParseWrapper {
        private final String binaryCover;
        private final String fileName;

        public CoverParseWrapper(String binaryCover2, String fileName2) {
            this.binaryCover = binaryCover2;
            this.fileName = fileName2;
        }

        public String getBinaryCover() {
            return this.binaryCover;
        }

        public String getFileName() {
            return this.fileName;
        }
    }

    @Nullable
    private CoverParseWrapper parseCover(Document bookDocument) {
        NodeList coverPageTags = bookDocument.getElementsByTagName("coverpage");
        if (coverPageTags.getLength() == 0) {
            return null;
        }
        NodeList coverPageNestedTags = coverPageTags.item(0).getChildNodes();
        int coverPageNestedTagsCount = coverPageNestedTags.getLength();
        Element imageTag = null;
        int i = 0;
        while (true) {
            if (i >= coverPageNestedTagsCount) {
                break;
            } else if (coverPageNestedTags.item(i).getNodeType() == 1) {
                imageTag = (Element) coverPageNestedTags.item(i);
                break;
            } else {
                i++;
            }
        }
        if (imageTag == null) {
            return null;
        }
        NamedNodeMap imageAttributes = imageTag.getAttributes();
        int imageAttributesCount = imageAttributes.getLength();
        String coverId = null;
        int i2 = 0;
        while (true) {
            if (i2 >= imageAttributesCount) {
                break;
            } else if (imageAttributes.item(i2).getNodeName().indexOf("href") > 0) {
                coverId = imageAttributes.item(i2).getNodeValue();
                break;
            } else {
                i2++;
            }
        }
        if (coverId == null) {
            return null;
        }
        if (coverId.charAt(0) == '#') {
            coverId = coverId.substring(1, coverId.length());
        }
        NodeList binaryTags = bookDocument.getElementsByTagName("binary");
        int binaryTagsCount = binaryTags.getLength();
        for (int i3 = 0; i3 < binaryTagsCount; i3++) {
            Element binaryTag = (Element) binaryTags.item(i3);
            String attribute = binaryTag.getAttribute(IdentityRealmObject.FIELD_ID);
            if (attribute != null && attribute.equals(coverId)) {
                return new CoverParseWrapper(binaryTag.getTextContent(), coverId);
            }
        }
        return null;
    }

    private String saveCover(String binaryCover, String fileName, String directoryPath) throws BookParserException {
        try {
            byte[] imageByte = Base64.decode(binaryCover, 0);
            String imagePath = directoryPath + File.separator + fileName;
            File imageFile = new File(imagePath);
            imageFile.getParentFile().mkdirs();
            imageFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
            fileOutputStream.write(imageByte);
            fileOutputStream.close();
            return imagePath;
        } catch (IOException e) {
            throw new BookParserException((Throwable) e);
        }
    }

    private String getBookTitle(Element titleInfo) {
        return titleInfo.getElementsByTagName("book-title").item(0).getTextContent();
    }

    private String getBookLanguage(Element titleInfo) {
        return titleInfo.getElementsByTagName("lang").item(0).getTextContent();
    }

    private List<String> getBookAuthors(Element titleInfo) {
        NodeList authorTags = titleInfo.getElementsByTagName(BookDescriptionDatabaseHelper.BOOK_AUTHOR);
        int authorTagsCount = authorTags.getLength();
        List<String> result = new ArrayList<>(authorTags.getLength());
        for (int i = 0; i < authorTagsCount; i++) {
            NodeList authorNestedTags = authorTags.item(i).getChildNodes();
            int authorNestedTagsCount = authorNestedTags.getLength();
            String firstName = null;
            String middleName = null;
            String lastName = null;
            String nickName = null;
            for (int j = 0; j < authorNestedTagsCount; j++) {
                Node currentAuthorNestedTag = authorNestedTags.item(j);
                String nodeName = currentAuthorNestedTag.getNodeName();
                char c = 65535;
                switch (nodeName.hashCode()) {
                    case -207161464:
                        if (nodeName.equals("first-name")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 70690926:
                        if (nodeName.equals("nickname")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 374896579:
                        if (nodeName.equals("middle-name")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1966946146:
                        if (nodeName.equals("last-name")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        firstName = currentAuthorNestedTag.getTextContent();
                        break;
                    case 1:
                        middleName = currentAuthorNestedTag.getTextContent();
                        break;
                    case 2:
                        lastName = currentAuthorNestedTag.getTextContent();
                        break;
                    case 3:
                        nickName = currentAuthorNestedTag.getTextContent();
                        break;
                }
            }
            if (firstName == null) {
                result.add(nickName);
            } else if (middleName != null) {
                result.add(firstName + ' ' + middleName + ' ' + lastName);
            } else {
                result.add(firstName + ' ' + lastName);
            }
        }
        return result;
    }

    private BookContent parseBook(Document bookDocument) {
        BookContent bookContent = new BookContent();
        NodeList bodyTags = bookDocument.getElementsByTagName("body");
        int bodyTagsCount = bodyTags.getLength();
        List<BookChapter> bookChapterList = new LinkedList<>();
        for (int i = 0; i < bodyTagsCount; i++) {
            NodeList sectionTags = ((Element) bodyTags.item(i)).getElementsByTagName(SECTION_TAG);
            int sectionTagsCount = sectionTags.getLength();
            bookChapterList.add(parseBody(bodyTags.item(i)));
            for (int j = 0; j < sectionTagsCount; j++) {
                Fb2BookChapter bookChapter = parseSection(sectionTags.item(j));
                if (!bookChapter.getBookChapter().toString().trim().isEmpty()) {
                    bookChapterList.add(bookChapter);
                }
            }
        }
        bookContent.setBookChapterList(bookChapterList);
        return bookContent;
    }

    private Fb2BookChapter parseBody(Node body) {
        Fb2BookChapter bookChapter = new Fb2BookChapter();
        NodeList bodyNestedTags = body.getChildNodes();
        int bodyNestedTagsCount = bodyNestedTags.getLength();
        for (int i = 0; i < bodyNestedTagsCount; i++) {
            Node currentTag = bodyNestedTags.item(i);
            String currentTagName = currentTag.getNodeName();
            char c = 65535;
            switch (currentTagName.hashCode()) {
                case -643941648:
                    if (currentTagName.equals(EPIGRAPH_TAG)) {
                        c = 1;
                        break;
                    }
                    break;
                case 110371416:
                    if (currentTagName.equals("title")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    bookChapter.setTitle(parseTag(currentTag));
                    break;
                case 1:
                    bookChapter.setContent(parseTag(currentTag));
                    break;
            }
        }
        return bookChapter;
    }

    private Fb2BookChapter parseSection(Node section) {
        NodeList sectionNestedTags = section.getChildNodes();
        int sectionNestedTagsCount = sectionNestedTags.getLength();
        Fb2BookChapter bookChapter = new Fb2BookChapter();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        for (int i = 0; i < sectionNestedTagsCount; i++) {
            Node currentTag = sectionNestedTags.item(i);
            String currentTagName = currentTag.getNodeName();
            char c = 65535;
            switch (currentTagName.hashCode()) {
                case -643941648:
                    if (currentTagName.equals(EPIGRAPH_TAG)) {
                        c = 1;
                        break;
                    }
                    break;
                case 110371416:
                    if (currentTagName.equals("title")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1970241253:
                    if (currentTagName.equals(SECTION_TAG)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    bookChapter.setTitle(parseTag(currentTag));
                    break;
                case 1:
                    builder.append(parseTag(currentTag));
                    break;
                case 2:
                    break;
                default:
                    builder.append(parseTag(currentTag));
                    break;
            }
        }
        if (builder.length() > 0) {
            bookChapter.setContent(builder);
        }
        return bookChapter;
    }

    private CharSequence parseTag(Node tag) {
        if (tag.getNodeType() != 3) {
            SpannableStringBuilder builder = new SpannableStringBuilder();
            NodeList nestedTags = tag.getChildNodes();
            int nestedTagsCount = nestedTags.getLength();
            for (int i = 0; i < nestedTagsCount; i++) {
                builder.append(parseTag(nestedTags.item(i)));
            }
            String nodeName = tag.getNodeName();
            char c = 65535;
            switch (nodeName.hashCode()) {
                case -2060497896:
                    if (nodeName.equals(SUBTITLE_TAG)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1105554316:
                    if (nodeName.equals(EMPTY_LINE_TAG)) {
                        c = 14;
                        break;
                    }
                    break;
                case -972521773:
                    if (nodeName.equals(STRIKE_THROUGH_TAG)) {
                        c = 13;
                        break;
                    }
                    break;
                case -892487179:
                    if (nodeName.equals(STANZA_TAG)) {
                        c = 5;
                        break;
                    }
                    break;
                case -891980137:
                    if (nodeName.equals(STRONG_TAG)) {
                        c = 10;
                        break;
                    }
                    break;
                case -643941648:
                    if (nodeName.equals(EPIGRAPH_TAG)) {
                        c = 3;
                        break;
                    }
                    break;
                case 112:
                    if (nodeName.equals(PARAGRAPH_TAG)) {
                        c = 2;
                        break;
                    }
                    break;
                case 118:
                    if (nodeName.equals(V_TAG)) {
                        c = 6;
                        break;
                    }
                    break;
                case 114240:
                    if (nodeName.equals(SUB_TAG)) {
                        c = 11;
                        break;
                    }
                    break;
                case 114254:
                    if (nodeName.equals(SUP_TAG)) {
                        c = 12;
                        break;
                    }
                    break;
                case 3053911:
                    if (nodeName.equals(CITE_TAG)) {
                        c = 7;
                        break;
                    }
                    break;
                case 3446503:
                    if (nodeName.equals(POEM_TAG)) {
                        c = 4;
                        break;
                    }
                    break;
                case 110371416:
                    if (nodeName.equals("title")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1189352828:
                    if (nodeName.equals(EMPHASIS_TAG)) {
                        c = 9;
                        break;
                    }
                    break;
                case 1667009067:
                    if (nodeName.equals(TEXT_AUTHOR_TAG)) {
                        c = 8;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    int builderLength = builder.length();
                    if (builderLength < 1) {
                        return builder;
                    }
                    builder.setSpan(new RelativeSizeSpan(TITLE_FONT_HEIGHT), 0, builder.length(), 33);
                    builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                    builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                    if (builder.charAt(builderLength - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n\n");
                    return builder;
                case 1:
                    int builderLength2 = builder.length();
                    if (builderLength2 < 1) {
                        return builder;
                    }
                    builder.setSpan(new RelativeSizeSpan(SUBTITLE_FONT_HEIGHT), 0, builder.length(), 33);
                    builder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, builder.length(), 33);
                    builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                    if (builder.charAt(builderLength2 - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n\n");
                    return builder;
                case 2:
                    int builderLength3 = builder.length();
                    if (builderLength3 < 1 || builder.charAt(builderLength3 - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n\n");
                    return builder;
                case 3:
                    int builderLength4 = builder.length();
                    if (builderLength4 < 1 || builder.charAt(builderLength4 - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n");
                    return builder;
                case 4:
                    int builderLength5 = builder.length();
                    if (builderLength5 < 1 || builder.charAt(builderLength5 - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n\n");
                    return builder;
                case 5:
                    int builderLength6 = builder.length();
                    if (builderLength6 < 1) {
                        return builder;
                    }
                    builder.setSpan(new StyleSpan(2), 0, builder.length(), 33);
                    if (builder.charAt(builderLength6 - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n\n");
                    return builder;
                case 6:
                    int builderLength7 = builder.length();
                    if (builderLength7 < 1 || builder.charAt(builderLength7 - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n");
                    return builder;
                case 7:
                    if (builder.length() < 1) {
                        return builder;
                    }
                    builder.setSpan(new StyleSpan(2), 0, builder.length(), 33);
                    return builder;
                case 8:
                    int builderLength8 = builder.length();
                    if (builderLength8 < 1 || builder.charAt(builderLength8 - 1) == 10) {
                        return builder;
                    }
                    builder.append("\n");
                    return builder;
                case 9:
                    if (builder.length() < 1) {
                        return builder;
                    }
                    builder.setSpan(new StyleSpan(2), 0, builder.length(), 33);
                    return builder;
                case 10:
                    if (builder.length() < 1) {
                        return builder;
                    }
                    builder.setSpan(new StyleSpan(1), 0, builder.length(), 33);
                    return builder;
                case 11:
                    if (builder.length() < 1) {
                        return builder;
                    }
                    builder.setSpan(new RelativeSizeSpan(0.5f), 0, builder.length(), 33);
                    builder.setSpan(new SubscriptSpan(), 0, builder.length(), 33);
                    return builder;
                case 12:
                    if (builder.length() < 1) {
                        return builder;
                    }
                    builder.setSpan(new RelativeSizeSpan(0.5f), 0, builder.length(), 33);
                    builder.setSpan(new SuperscriptSpan(), 0, builder.length(), 33);
                    return builder;
                case 13:
                    if (builder.length() < 1) {
                        return builder;
                    }
                    builder.setSpan(new StrikethroughSpan(), 0, builder.length(), 33);
                    return builder;
                case 14:
                    builder.append("\n");
                    return builder;
                default:
                    return builder;
            }
        } else if (!tag.getNodeValue().trim().isEmpty()) {
            return tag.getNodeValue();
        } else {
            return "";
        }
    }
}
