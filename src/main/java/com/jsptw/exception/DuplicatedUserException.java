package com.jsptw.exception;

public class DuplicatedUserException extends AuthException {
    public DuplicatedUserException() {
        super("重复注册", null);
    }

    public DuplicatedUserException(Object data) {
        super("重复注册", data);
    }
}
