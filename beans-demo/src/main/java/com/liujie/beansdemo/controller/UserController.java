package com.liujie.beansdemo.controller;

import com.alibaba.fastjson.JSON;
import com.liujie.beansdemo.pojo.User;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;


@Api(description = "User接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user, BindingResult bindingResult){
//        boolean b = ;
        if (bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldErrors().stream()
                    .map(error-> error.getDefaultMessage())
                    .collect(Collectors.joining("|")));
        }
        System.out.println("User ---" + JSON.toJSONString(user));
        return null;
    }
}
