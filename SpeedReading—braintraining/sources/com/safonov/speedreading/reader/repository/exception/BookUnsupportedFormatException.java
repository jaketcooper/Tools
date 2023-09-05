package com.safonov.speedreading.reader.repository.exception;

public class BookUnsupportedFormatException extends Exception {
    public BookUnsupportedFormatException() {
    }

    public BookUnsupportedFormatException(String message) {
        super(message);
    }

    public BookUnsupportedFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookUnsupportedFormatException(Throwable cause) {
        super(cause);
    }
}
