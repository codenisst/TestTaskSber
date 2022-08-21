package ru.codenisst.sber.util;

public class LogException extends RuntimeException{

    private final String message;

    public LogException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
