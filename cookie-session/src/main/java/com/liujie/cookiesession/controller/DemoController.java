package com.liujie.cookiesession.controller;

import com.alibaba.fastjson.JSON;
import com.liujie.cookiesession.utils.GetRemortIP;
import com.liujie.cookiesession.utils.UdpGetClientMacAddr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(description = "CookieDemo")
@RestController
@RequestMapping
public class DemoController {

    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @GetMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                System.out.println("cookie"+ JSON.toJSONString(cookie));
            }
        }
        Cookie cookie = new Cookie("liujie", "Hello_Word_liujie");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        response.addCookie(cookie);
        return "Hello Word";
    }



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletRequest request,HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "passWord",required = true) String passWord) throws Exception {
        //这个变量用于装cookies信息
        if(userName.equals("lyn") && passWord.equals("123456")){
            String ip = GetRemortIP.getIP(request);
            Cookie cookie = new Cookie("JSESSIONID",ip);  //对比入参数据
            cookie.setMaxAge(0);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return "恭喜登录成功";
        }
        return  "用户名或密码错误";
    }

    @RequestMapping(value = "/loginTest",method = RequestMethod.GET)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "GET")
    public Boolean login(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //这个变量用于装cookies信息
            String ip = GetRemortIP.getIP(request);
        Cookie[] cookies = request.getCookies();
        for (int i=0;i<cookies.length;i++){
            Cookie cookie = cookies[i];
            if (cookie.getName().equalsIgnoreCase("JSESSIONID")){
                return cookie.getValue().equals(ip);
            }
        }

//            Cookie cookie = new Cookie("JSESSIONID",ip);  //对比入参数据
//            cookie.setMaxAge(0);
//            cookie.setSecure(true);
//            cookie.setHttpOnly(true);

            return false;

    }

    @RequestMapping(value = "/getIP",method = RequestMethod.GET)
    @ApiOperation(value = "获取客户端ip与MAC地址",httpMethod = "GET")
    private String getRemortIP(HttpServletRequest request) throws Exception {
        String clientIP = GetRemortIP.getIP(request);
        System.out.println("clientIP"+clientIP);
        return clientIP;
    }




}
