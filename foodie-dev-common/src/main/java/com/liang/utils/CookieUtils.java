package com.liang.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/29 15:13
 * @content cookie相关工具类
 */
public class CookieUtils {

    public static void setCookie(HttpServletResponse response,HttpServletRequest request, String cookieName, String cookieValue,boolean isEncode){
        try {
            if (cookieValue==null) {
                cookieValue="";
            }
            if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName,cookieValue);
//            if (null!=request) {
//                String domainName = getDomainName(request);
//                if (!"localhost".equals(domainName)) {
//                    cookie.setDomain(domainName);
//                }
//            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static String getDomainName(HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
    }
}
