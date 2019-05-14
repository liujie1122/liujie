package com.liujie.cookiesession.utils;

import javax.servlet.http.HttpServletRequest;

public class GetRemortIP {
    public static String getIP(HttpServletRequest request) throws Exception {
        System.out.println("用户请求来了---------------");
        String clientIP = request.getHeader("x-forwarded-for");
        if(clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("Proxy-Client-IP");
        }
        if(clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("WL-Proxy-Client-IP");
        }
        if(clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getRemoteAddr();
        }
//        UdpGetClientMacAddr addr = new UdpGetClientMacAddr(clientIP);
//        String remoteMacAddr = addr.getRemoteMacAddr();
//        System.out.println("remoteMacAddr"+remoteMacAddr);
        System.out.println("clientIP"+clientIP);
        return clientIP;

    }

}
