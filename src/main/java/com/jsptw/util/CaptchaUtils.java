package com.jsptw.util;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

/**
 
 * 描    述：验证码工具类
 */
public class CaptchaUtils {

    public static boolean verify(HttpServletRequest request, String... args) {
        HttpSession session = request.getSession();
        String expected = (String) session.getAttribute(Captcha.NAME);
        String received = null;
        boolean b;
        if (null != args && args.length > 0) {
            for (String temp : args)
                received = temp;
            if (null == received || null == expected) {
                b = Boolean.TRUE;
            } else {
                b = !received.equalsIgnoreCase(expected);
            }
        } else {
            received = request.getParameter("captcha");
            if (null == received || null == expected) {
                b = Boolean.TRUE;
            } else {
                b = !received.equalsIgnoreCase(expected);
            }
        }
        session.setAttribute(Captcha.NAME, null);
        return b;
    }
}
