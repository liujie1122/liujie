package com.liujie.jwt.config.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.regex.Pattern;

/**
 * @author Lijing
 * @ClassName: ExceptionHandlerController.class
 * @Description: 统一异常处理类
 * @date 2017年8月9日 下午4:44:25
 */
//@RestControllerAdvice
public class ExceptionHandlerController {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    private final static Pattern PATTERN = Pattern.compile("(\\[[^]]*])");


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        //主要输出不确定的异常
        logger.error(exception.getMessage(), exception);

//        return new ResponseDTO<>(exception);
        return null;
    }

}