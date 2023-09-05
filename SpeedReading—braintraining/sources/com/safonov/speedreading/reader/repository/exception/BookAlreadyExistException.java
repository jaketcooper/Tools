package com.safonov.speedreading.reader.repository.exception;

public class BookAlreadyExistException extends Exception {
    public BookAlreadyExistException() {
    }

    public BookAlreadyExistException(String message) {
        super(message);
    }

    public BookAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
