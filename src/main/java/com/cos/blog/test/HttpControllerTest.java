package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;


@RestController //사용자가 요청 -> 응답 (Data)
public class HttpControllerTest {
    
    //인터넷 브라우저 요청은 항상 get만 가능합니다,.
    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get요청: " + m.getId() + "," + m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }
    
    @PostMapping("/http/post")
    public String postTest(@RequestBody String text) {
        return "post요청: " + text;
    }
    
    @PutMapping("/http/put")
    public String putTest() {
        return "put요청";
    }
    
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete요청";
    }
    
}

