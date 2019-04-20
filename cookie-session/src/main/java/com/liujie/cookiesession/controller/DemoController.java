package com.liujie.cookiesession.controller;

import com.alibaba.fastjson.JSON;
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

    //这个变量用于装cookies信息
    private static Cookie cookie;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "passWord",required = true) String passWord){
        if(userName.equals("lyn") && passWord.equals("123456")){
            cookie = new Cookie("login","true");  //对比入参数据
            response.addCookie(cookie);
            return "恭喜登录成功";
        }
        return  "用户名或密码错误";

    }
}
