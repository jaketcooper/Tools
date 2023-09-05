package com.safonov.speedreading.reader.repository.util;

import com.safonov.speedreading.reader.repository.exception.BookParserException;
import java.io.File;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XmlParserUtil {
    public static Document getXmlFromFile(File file) throws BookParserException {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            throw new BookParserException((Throwable) e);
        }
    }

    public static Document getXmlFromFile(InputStream inputStream) throws BookParserException {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            throw new BookParserException((Throwable) e);
        }
    }
}
