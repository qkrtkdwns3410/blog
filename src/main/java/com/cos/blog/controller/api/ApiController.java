package com.cos.blog.controller.api;


import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        //실제로 DB에 insert하고 아래에서 return이 되면 됩니다.
        int result = userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK, result); //자바오브젝트를 JSON을 변환해서 리턴합니다(Jackson)
    }
}

