package com.jsptw.exception;


public class RoleRepeatExecption extends AuthException {

    public RoleRepeatExecption() {
        super("角色重复注册", null);
    }

    public RoleRepeatExecption(Object data) {
        super("角色重复注册", data);
    }
}
