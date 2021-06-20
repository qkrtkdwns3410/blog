package com.cos.blog.controller;


import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
    
    
    @Autowired
    private BoardService boardService;
    
    
    //컨트롤러에서 세션을 어떻게 찾는가?
    //@AuthenticationPrincipal PrincipalDetail principalDetail
    @GetMapping({"", "/"})
    public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.글목록(pageable));
        return "index"; //viewResolver작동!! return application.yml의 프리픽스 .. 붙여줍니다.
    }
    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id,Model model) {
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/detailForm";
    }
    
    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/updateForm";
    }
    
    //USER의 권한이 필요합니다.
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
    
}
