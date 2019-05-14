package com.liujie.jwt.controller;

import com.liujie.jwt.base.JwtProperties;
import com.liujie.jwt.pojo.User;
import com.liujie.jwt.service.UserService;
import com.liujie.jwt.utils.jwt.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwt;

    @PostMapping("/login")
    private ResponseEntity userLogin(HttpServletRequest request, HttpServletResponse response,@RequestBody User user){
        User recode = userService.userLogin(user);
        String token = JwtUtils.generateToken(recode, jwt.getPrivateKey(), jwt.getExpire());
//        Cookie[] cookies = request.getCookies();
        Cookie tokenCookie = new Cookie("token",token);
        tokenCookie.setHttpOnly(true);
        tokenCookie.setSecure(true);
        response.addCookie(tokenCookie);
//        for (Cookie cookie:cookies) {
//            if (StringUtils.equals(cookie.getName(),"token")){
//
//            }
//        }
        return ResponseEntity.ok(token);

    }

    @PostMapping("/save")
    private ResponseEntity userSave(@RequestBody @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldErrors().stream()
                    .map(error-> error.getDefaultMessage())
                    .collect(Collectors.joining("|")));
        }
        return ResponseEntity.ok(userService.userSave(user));

    }
}
