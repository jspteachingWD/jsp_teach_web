package com.jsptw.util;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**

 * 描    述：密码加密
 */
public class PasswordMd5 {

    public static String standPwdEncoder(String rawStr){
        StandardPasswordEncoder encoder = new StandardPasswordEncoder("my-secret-key");
        return encoder.encode(rawStr);
    }
}
