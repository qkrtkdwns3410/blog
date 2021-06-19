package com.cos.blog.controller;


import com.cos.blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    
    @GetMapping({"", "/"})
    public String index() { //컨트롤러에서 세션을 어떻게 찾는가?
        return "index";
    }
    
    //USER의 권한이 필요합니다.
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
    
}
