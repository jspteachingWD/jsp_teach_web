package com.jsptw.security.login;


import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jsptw.exception.InvalidCaptchaException;
import com.jsptw.util.CaptchaUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * * 描    述：登录filter
 */
public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        if (!request.getMethod().equals("POST"))
            throw new AuthenticationServiceException("不支持的身份验证方法: " + request.getMethod());

        Object attribute = request.getSession().getAttribute(SimpleUrlAuthenticationFailureHandler.SESSION_FAIL_TIMES);
        Integer times = 0;
        if (attribute != null)
            times = (Integer) attribute;

        if (times > 3)
            if (CaptchaUtils.verify(request))
                throw new InvalidCaptchaException();

        String username = obtainUsername(request).trim();
        String password = obtainPassword(request);

        //UsernamePasswordAuthenticationToken校验密码用
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        //这里就将token传到后续验证环节了
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }


}
