package com.cos.blog.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //예외발생시 해당 클래스로 옵니다.


@RestController
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = IllegalArgumentException.class) //해당 익셉션이 발생하면, 명령을 이쪽으로 하므니다.
    public String handleArgumentException(IllegalArgumentException e) {
        return "<h1>" + e.getMessage() + "</h1>";
    }
}
