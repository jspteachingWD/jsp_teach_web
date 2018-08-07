package com.jsptw.exception;

import org.springframework.security.core.AuthenticationException;


public class InvalidCaptchaException extends AuthenticationException {

    public InvalidCaptchaException() {
        super("您填写的验证码不正确!");
    }

    public InvalidCaptchaException(String msg, Throwable t) {
        super(msg, t);
    }
}
