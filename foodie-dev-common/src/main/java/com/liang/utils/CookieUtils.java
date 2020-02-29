package com.liang.utils;

import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class CookieUtils {

    /**
     * 设置cookie信息
     * @param request request
     * @param response response
     * @param cookieName cookie名
     * @param cookieValue cookie值
     * @param isEncode 是否加密
     */
    public static void setCookie(HttpServletRequest request,HttpServletResponse response, String cookieName, String cookieValue,boolean isEncode){
        doSetCookie(request,response,cookieName,cookieValue,-1,isEncode);
    }

    /**
     *
     * 删除Cookie带cookie域名
     * @param request request
     * @param response response
     * @param cookieName cookie名
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
                                    String cookieName) {
        doSetCookie(request, response, cookieName, null, -1, false);
    }

    /**
     *
     * @content : 设置Cookie的值，并使其在指定时间内生效
     * @param request request
     * @param response response
     * @param cookieName  cookie名
     * @param cookieValue cookie值
     * @param cookieMaxage	cookie生效的最大秒数
     * @param isEncode 加密
     */
    private static void doSetCookie(HttpServletRequest request, HttpServletResponse response,
                                    String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {
                // 设置域名的cookie
                String domainName = getDomainName(request);
                log.debug("========== domainName: {} ==========", domainName);
                if (!"localhost".equals(domainName)) {
                    cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @content : 得到cookie的域名
     * @return 域名
     */
    private static String getDomainName(HttpServletRequest request) {
        String domainName = null;

        String serverName = request.getRequestURL().toString();
        if ("".equals(serverName)) {
            domainName = "";
        } else {
            serverName = serverName.toLowerCase();
            serverName = serverName.substring(7);
            final int end = serverName.indexOf("/");
            serverName = serverName.substring(0, end);
            if (serverName.indexOf(":") > 0) {
                String[] ary = serverName.split(":");
                serverName = ary[0];
            }

            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3 && !isIp(serverName)) {
                // www.xxx.com.cn
                domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
                // xxx.com or xxx.cn
                domainName = "." + domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }
        return domainName;
    }

    private static String trimSpaces(String IP){//去掉IP字符串前后所有的空格
        while(IP.startsWith(" ")){
            IP= IP.substring(1,IP.length()).trim();
        }
        while(IP.endsWith(" ")){
            IP= IP.substring(0,IP.length()-1).trim();
        }
        return IP;
    }

    private static boolean isIp(String IP){//判断是否是一个IP
        boolean b = false;
        IP = trimSpaces(IP);
        if(IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")){
            String s[] = IP.split("\\.");
            if(Integer.parseInt(s[0])<255) {
                if(Integer.parseInt(s[1])<255) {
                    if(Integer.parseInt(s[2])<255) {
                        if(Integer.parseInt(s[3])<255) {
                            b = true;
                        }
                    }
                }
            }
        }
        return b;
    }


}
