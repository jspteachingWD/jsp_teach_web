package com.jsptw.exception;

/**
 * 描    述：异常处理类
 */
public class AuthException extends Exception {
    protected final Object data;

    public AuthException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

}
