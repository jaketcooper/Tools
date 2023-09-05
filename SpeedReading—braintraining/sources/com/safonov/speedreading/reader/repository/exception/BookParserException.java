package com.safonov.speedreading.reader.repository.exception;

public class BookParserException extends Exception {
    public BookParserException() {
    }

    public BookParserException(String message) {
        super(message);
    }

    public BookParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookParserException(Throwable cause) {
        super(cause);
    }
}
