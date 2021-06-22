package com.cos.blog.controller.api;


import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    
    @Autowired
    private UserService userService;
    
    
    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) { //User로 받는것이 username, password , email 3개뿐입니다.
        
        System.out.println("UserApiController: save 호출됨");
        //실제로 DB에 insert하고 아래에서 return이 되면 됩니다.
        
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //자바오브젝트를 JSON을 변환해서 리턴합니다(Jackson)
    }
    
    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user) { //requestBody가 걸려 있어야 JSON데이터를 받을 수 있습니다.
        userService.회원수정(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}

