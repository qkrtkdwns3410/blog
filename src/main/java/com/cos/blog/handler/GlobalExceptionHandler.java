package com.cos.blog.handler;


import com.cos.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //예외발생시 해당 클래스로 옵니다.


@RestController
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = IllegalArgumentException.class) //해당 익셉션이 발생하면, 명령을 이쪽으로 하므니다.
    public ResponseDto<String> handleArgumentException(Exception e) {
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
