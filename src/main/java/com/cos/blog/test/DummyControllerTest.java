package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;


//html파일이 아니라 data를 리턴해준는 controller =RestController
@RestController
public class DummyControllerTest {
    
    @Autowired
    private UserRepository userRepository;
    
    
    //{id}wnthfh 파라메터를 전달 받을 수 있습니다.
    //http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        //user /4를 찾으면 내가 데이터 베이스에서 못찾아오게 되면 user가 null이 될 것이 아니냐?
        // 그럼 return null 이 리턴이 될.. 그럼 프로그램에 문제가 생길수있음.
        //Optional 로 너의 User객체를 감싸서 들고올테니 null인지 아닌지 판단해서 return해라.
        
        //람다식
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id:" + id);
            }
        });
        //요청:웹브라우저
        //user 객체  =자바 오브젝트
        //변환 (웹브라우저가 이해할 수 있는 데이터) >>JSONl
        //스프링부트  =MessageConverter라는 애가 응답시에 자동 작동합니다.
        //만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson이라는 라이브러리를 호출해서
        //user 오브젝트를 json으로 변환해서 브라우저에 던져ㄷ줍니다.
        return user;
    }
    
    
    
    @PostMapping("/dummy/join")
    public String join(User user) {
        
        System.out.println("id: " + user.getId());
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("createDate: " + user.getCreateDate());
        
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
