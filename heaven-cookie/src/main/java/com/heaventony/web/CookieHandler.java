package com.heaventony.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/4/1
 * Time: 下午2:31
 */
public class CookieHandler {

    private static final int DEFAULT_MAXAGE = 0;
    public CookieHandler() {

    }

    public CookieHandler(String name, String value, HttpServletResponse response) {
        generateCookie(name, value, response, DEFAULT_MAXAGE);
    }

    public CookieHandler (String name, String value,HttpServletResponse response, int maxAge) {
         generateCookie(name, value, response, maxAge);
    }

    public void generateCookie(String name, String value, HttpServletResponse response, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }



}
