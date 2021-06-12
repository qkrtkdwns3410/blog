package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;


@RestController //사용자가 요청 -> 응답 (Data)
public class HttpControllerTest {
    
    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
        System.out.println(TAG + "getter" + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "setter" + m.getUsername());
        return "lombok 테스트 완료";
    }
    
    
    
    
    
    
    public static final String TAG = "HttpControllerTest";
    //인터넷 브라우저 요청은 항상 get만 가능합니다,.
    @GetMapping("/http/get")
    public String getTest(Member m) {

        return "get요청: " + m.getId() + "," + m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }
    
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) { //스프링부트의 (Message convertor) 라는 친구가 json을 멤버변수에 매칭시켜서 출력을 도와준다.
        return "post요청: " + m.getId()+","+m.getEmail()+","+m.getPassword()+","+m.getUsername();
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

