package com.cos.blog.controller;


import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sun.font.AttributeValues;

@Controller
public class BoardController {
    
    
    @Autowired
    private BoardService boardService;
    
    
    //컨트롤러에서 세션을 어떻게 찾는가?
    //@AuthenticationPrincipal PrincipalDetail principalDetail
    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("boards", boardService.글목록());
        return "index";
    }
    
    //USER의 권한이 필요합니다.
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
    
}
